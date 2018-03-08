package Portfolio;

import java.util.ArrayList;

import java.util.List;

import javax.el.MethodExpression;
import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.MoveEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class HandlerBean {

    private boolean readOnlyMode=true;
    private boolean newStock=false;

    public void setNewStock(boolean newStock) {
        boolean oldNewStock = this.newStock;
        this.newStock = newStock;
        propertyChangeSupport.firePropertyChange("newStock", oldNewStock, newStock);
    }

    public boolean isNewStock() {
        return newStock;
    }

    public void setReadOnlyMode(boolean readOnlyMode) {
        boolean oldReadOnlyMode = this.readOnlyMode;
        this.readOnlyMode = readOnlyMode;
        propertyChangeSupport.firePropertyChange("readOnlyMode", oldReadOnlyMode, readOnlyMode);
    }

    public boolean isReadOnlyMode() {
        return readOnlyMode;
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
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);


    public HandlerBean() {
    }

    public void handleMoveListener(MoveEvent moveEvent) {
        String rowKeyMoved=(String)moveEvent.getRowKeyMoved();
        String rowKeyInsertedBefore=(String)moveEvent.getRowKeyInsertedBefore();        
        Portfolio portfolio = new Portfolio();
        portfolio.reorderStocks(rowKeyMoved, rowKeyInsertedBefore);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    
    public void enableEditMode(ActionEvent actionEvent) {
      this.setReadOnlyMode(false);
    }

    public void disableEditMode(ActionEvent actionEvent) {
      this.setReadOnlyMode(true);
    }

    public void enableNewStockFlag(ActionEvent actionEvent) {
      this.setNewStock(true);
    }

    public void disableNewStockFlag(ActionEvent actionEvent) {
      this.setNewStock(false);
    }

    public void invokeCancelAction(ActionEvent actionEvent) {
      
        if(this.isNewStock()){
            MethodExpression me1 = AdfmfJavaUtilities.getMethodExpression("#{bindings.Last.execute}", Object.class, new Class[] {}); 
            me1.invoke(AdfmfJavaUtilities.getELContext(), new Object[] {});

            MethodExpression me2 = AdfmfJavaUtilities.getMethodExpression("#{bindings.Delete.execute}", Object.class, new Class[] {}); 
            me2.invoke(AdfmfJavaUtilities.getELContext(), new Object[] {});
        
            this.setNewStock(false);  
        
        }else{
            MethodExpression me3 = AdfmfJavaUtilities.getMethodExpression("#{bindings.resetStock.execute}", Object.class, new Class[] {}); 
            me3.invoke(AdfmfJavaUtilities.getELContext(), new Object[] {});        
        }
        this.setReadOnlyMode(true);
    }


}
