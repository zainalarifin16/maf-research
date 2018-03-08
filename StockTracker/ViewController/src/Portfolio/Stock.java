package Portfolio;

import java.text.NumberFormat;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Stock {

    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Stock() {
       super(); 
    }

    private int id = 0;
    private String ticker = "";
    private String company = "";
    private double price;

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        propertyChangeSupport.firePropertyChange("price", oldPrice, price);
    }

    public double getPrice() {
        return price;
    }
    

    private double previous;
    private long volume;
    private int stockOrder=-1;

    public void setStockOrder(int stockOrder) {
        int oldStockOrder = this.stockOrder;
        this.stockOrder = stockOrder;
        propertyChangeSupport.firePropertyChange("stockOrder", oldStockOrder, stockOrder);
    }

    public int getStockOrder() {
        return stockOrder;
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


    public Stock(int id, String ticker, String company, double price, double previous, long volume, int stockOrder) {
        super();
        this.id = id;
        this.ticker = ticker;
        this.company = company;
        this.price = price;
        this.previous = previous;
        this.volume = volume;
        this.stockOrder=stockOrder;
    }
    
    public String getChange() {
        String c = "color:green";
        if( price < previous) {
            c = "color:red";
        }
        return c;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public int getId() {
        return id;
    }

    public void setTicker(String ticker) {
        String oldTicker = this.ticker;
        this.ticker = ticker;
        propertyChangeSupport.firePropertyChange("ticker", oldTicker, ticker);
    }

    public String getTicker() {
        return ticker;
    }

    public void setCompany(String company) {
        String oldCompany = this.company;
        this.company = company;
        propertyChangeSupport.firePropertyChange("company", oldCompany, company);
    }

    public String getCompany() {
        return company;
    }

 

    public void setPrevious(double previous) {
        double oldPrevious = this.previous;
        this.previous = previous;
        propertyChangeSupport.firePropertyChange("previous", oldPrevious, previous);
    }

    public double getPrevious() {
        return previous;
    }

    public void setVolume(long volume) {
        long oldVolume = this.volume;
        this.volume = volume;
        propertyChangeSupport.firePropertyChange("volume", oldVolume, volume);
    }

    public long getVolume() {
        return volume;
    }
    
    public void copy( Stock stock ) {
        this.setId(stock.id);
        this.setPrevious(stock.previous);
        this.setPrice(stock.price);
        this.setCompany(stock.company);
        this.setStockOrder(stock.stockOrder);
        this.setTicker(stock.ticker);
        this.setVolume(stock.volume);
    }

}
