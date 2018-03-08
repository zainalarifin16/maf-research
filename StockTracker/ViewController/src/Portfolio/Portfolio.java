package Portfolio;

import java.util.logging.Level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Random;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class Portfolio {
 
    protected transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    

    public void addProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.removeProviderChangeListener(l);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
  
  
    protected static volatile List<Stock> s_stocks = null;
    private Stock editStock = new Stock();

    private void setEditStock(Stock editStock) {
        Stock oldEditStock = this.editStock;
        this.editStock = editStock;
        propertyChangeSupport.firePropertyChange("editStock", oldEditStock, editStock);
    }

    private Stock getEditStock() {
        return editStock;
    }


    private String deleteTicker = "";
    private boolean threadStarted = false;
    private Refresher refresher = new Refresher(this);
    private Thread worker = new Thread(refresher);



    public void setProviderChangeSupport(ProviderChangeSupport providerChangeSupport) {
        ProviderChangeSupport oldProviderChangeSupport = this.providerChangeSupport;
        this.providerChangeSupport = providerChangeSupport;
        propertyChangeSupport.firePropertyChange("providerChangeSupport", oldProviderChangeSupport,
                                                 providerChangeSupport);
    }

    public ProviderChangeSupport getProviderChangeSupport() {
        return providerChangeSupport;
    }


    public void setThreadStarted(boolean threadStarted) {
        boolean oldThreadStarted = this.threadStarted;
        this.threadStarted = threadStarted;
        propertyChangeSupport.firePropertyChange("threadStarted", oldThreadStarted, threadStarted);
    }

    public boolean isThreadStarted() {
        return threadStarted;
    }


    public void setDeleteTicker(String deleteTicker) {
        String oldDeleteTicker = this.deleteTicker;
        this.deleteTicker = deleteTicker;
        propertyChangeSupport.firePropertyChange("deleteTicker", oldDeleteTicker, deleteTicker);
    }

    public String getDeleteTicker() {
        return deleteTicker;
    }


    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        PropertyChangeSupport oldPropertyChangeSupport = this.propertyChangeSupport;
        this.propertyChangeSupport = propertyChangeSupport;
        propertyChangeSupport.firePropertyChange("propertyChangeSupport", oldPropertyChangeSupport,
                                                 propertyChangeSupport);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }


    public Portfolio() {
        if (s_stocks == null) {
            s_stocks = new ArrayList<Stock>();
            s_stocks.clear();
            this.resetStocks();
        }
    }

    /*
     * 
     * Clears all the records from collection, and preseeds 4 records into collection
     * 
     *  
     */
    
    public synchronized void resetStocks() {
        s_stocks.clear();
        s_stocks.add((new Stock(0, "STOCK1", "Acme Wireless", 35d, 32d, 1000L,0)));
        s_stocks.add((new Stock(1, "STOCK2", "Acme Electronics", 65d, 58d,
                                    900L,1)));
        s_stocks.add((new Stock(2, "STOCK3", "Acme Construction", 45d, 41d, 800L,2)));
        s_stocks.add((new Stock(3, "STOCK4", "Acme Media", 45d, 31d,
                                    800L,3)));

        providerChangeSupport.fireProviderRefresh("stocks"); 
        
    }


    /*
     * 
     * Fetches all the stocks from collection 
     *  
     */
    
    public synchronized List<Stock> getStocks() {
        Stock s[] = null;
        Stock stock=null;
        if(s_stocks==null){
          this.resetStocks();
        }
        
        return s_stocks;
    }


    /*
     * 
     * This method is invoked to remove a stock from collection.
     * 
     */

    public void removeStock(Stock stock){
       s_stocks.remove(stock);
    }


    /*
     * 
     * This method invokes generates a random number and assigns it to the Price attribute for each of
     * the Stock objects within the collection. 
     * The setPrice method invokes the propertyChangeEvent to refresh the UI 
     */

    public synchronized void doChange() {
        Random r = new Random(new Random().nextInt(1000));

        int i = 0;
        while (i < s_stocks.size()) {
            Stock s = (Stock)s_stocks.get(i);
            int ran = r.nextInt(1000);
            double change = ((double)ran - 500) / 10000 + 1;
            s.setPrice((s.getPrice() * change));
            s_stocks.set(i, s);
            i++;
        }
        
    }

    /*
     * 
     * Starts the Refersher thread which invokes the doChange method to constantly update the Price attributes
     * with a random value. The purpose of this method is to demonstrate that while the data within the model is 
     * changing in a background process, the framework refreshes the UI seamlessly.
     *  
     */

    public void startRefresher() {
        setThreadStarted(true);
        refresher.go = true;
        if (!worker.isAlive()) {
            worker.start();
        }
        setThreadStarted(refresher.go);
    }


    /*
     * 
     * Stop the Refresher thread
     *  
     */

    public void stopRefresher() {
        if (refresher.go == true) {
            refresher.go = false;
            setThreadStarted(false);
        }
    }

    /*
     * 
     * Reorders the stocks in the collection and updates the order witin the database.
     *  
     */

    public void reorderStocks(String rowKeyMoved, String rowKeyInsertedBefore){
        int index1=-1;
        int index2=-1;
        int reorderDirection=-1; // Value 0 for downward, value 1 for upward
                        
        if(s_stocks!=null){
            
            int size=s_stocks.size();
            
            if(rowKeyMoved!=null){
                index1=Integer.parseInt(rowKeyMoved);
            }
            if(rowKeyInsertedBefore==null){
               index2=size;
               
            } else if(Integer.parseInt(rowKeyInsertedBefore)==0){
               index2=0;
            }
            else {
               index2=Integer.parseInt(rowKeyInsertedBefore);
            }
            
            if(index1<=index2){
                reorderDirection=-1;
            }else{
                reorderDirection=1;
            }
                      
            for(int i=0;i<s_stocks.size();i++){
                Stock stock=(Stock)s_stocks.get(i);
            }  

            if(reorderDirection==-1){        
             Collections.rotate(s_stocks.subList(index1, index2), reorderDirection);
            } else if (reorderDirection==1){
             Collections.rotate(s_stocks.subList(index2, index1+1), reorderDirection);
            }
            
            for(int i=0;i<s_stocks.size();i++){
                Stock stock=(Stock)s_stocks.get(i);
                stock.setStockOrder(i);
            }   
            
            Stock s[] = (Stock[])s_stocks.toArray(new Stock[s_stocks.size()]);
        }
    
    }

    
    /*
     * 
     * Saves all the Stock objects within the collection
     *  
     */
    
    
    public void saveAllStocks(){
      Stock stock_arr[]= (Stock[])s_stocks.toArray(new Stock[s_stocks.size()]);  
    
    } 
    
    /*
     * 
     * This method is invoked to add a new stock to the collection
     * 
     * 
     */
    
    public void addStock(String ticker, String company, double price, double previous, long volume){
        

        Stock stock = new Stock();
        
        int id=s_stocks.size();
        stock.setId(id);
        stock.setStockOrder(id);
        stock.setTicker("");
        stock.setCompany("");
        stock.setPrice(0);
        stock.setPrevious(0);
        stock.setVolume(0);
        
        s_stocks.add(stock);

    }
    

    /*
     * 
     * This method creates a copy of the Stock object which gets in the edit mode. This is useful
     * when the user wants to cancel editing the stock and go back to the previous values.
     * 
     */

    public void copyStock(int id,String ticker, String company,double price, double previous, long volume,int orderId){
        Stock stockCopy=new Stock(id,ticker,company,price,previous,volume,orderId);
        this.setEditStock(stockCopy);
    }  

    /*
     * 
     * When the user cancels the edit operation for Stock, resetStock method reverts to the copy of the stock
     * which was backed up before the edit operation started
     * 
     */

    public void resetStock(int stockId){

        int count = s_stocks.size();
        for (int x = 0; x < count; x++) {
            Stock stock = (Stock)s_stocks.get(x);
            if (stock.getId() == stockId) {
                Stock copy=this.getEditStock();
                s_stocks.set(x,copy); 
                break;
            }
        }
        
    }  


}
