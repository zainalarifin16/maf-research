package Contacts;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class ContactField {
    
    public String fieldName;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setFieldName(String fieldName) {
        String oldFieldName = this.fieldName;
        this.fieldName = fieldName;
        propertyChangeSupport.firePropertyChange("fieldName", oldFieldName, fieldName);
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldStatus(boolean fieldStatus) {
        boolean oldFieldStatus = this.fieldStatus;
        this.fieldStatus = fieldStatus;
        propertyChangeSupport.firePropertyChange("fieldStatus", oldFieldStatus, fieldStatus);
    }

    public boolean isFieldStatus() {
        return fieldStatus;
    }
    public boolean fieldStatus;
    
    public ContactField() {
        super();
    }

    public ContactField(String fieldName, boolean fieldStatus) {
        super();
        this.fieldName=fieldName;
        this.fieldStatus=fieldStatus;
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
