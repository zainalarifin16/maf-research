package mobile;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class HandlerBean {
    private String currentEmployee="1";
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private boolean detail=false;;

    public void setDetail(boolean detail) {
        boolean oldDetail = this.detail;
        this.detail = detail;
        propertyChangeSupport.firePropertyChange("detail", oldDetail, detail);
    }

    public boolean isDetail() {
        
        ValueExpression val =AdfmfJavaUtilities.getValueExpression("#{applicationScope.empId}", Object.class);
        String currEmp=(String)val.getValue(AdfmfJavaUtilities.getELContext());
        if( currEmp!=null && currEmp.length() > 0) {
            this.setDetail(true);
        }
        return detail;
    }

    public void setCurrentEmployee(String currentEmployee) {
        String oldCurrentEmployee = this.currentEmployee;
        this.currentEmployee = currentEmployee;
        propertyChangeSupport.firePropertyChange("currentEmployee", oldCurrentEmployee, currentEmployee);
    }

    public String getCurrentEmployee() {
        return currentEmployee;
    }

    public HandlerBean() {
    }

    public void handleValueChange(ValueChangeEvent valueChangeEvent) {
        String newValue=(String)valueChangeEvent.getNewValue();
        this.setCurrentEmployee(newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
  

}
