package mobile;

import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class PreferenceHandler {
    private String currentPanel="iosgroup";
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setCurrentPanel(String currentPanel) {
        String oldCurrentPanel = this.currentPanel;
        this.currentPanel = currentPanel;
        propertyChangeSupport.firePropertyChange("currentPanel", oldCurrentPanel, currentPanel);
    }

    public String getCurrentPanel() {
        return currentPanel;
    }

    public PreferenceHandler() {
    }

    public void handleValueChange(ValueChangeEvent valueChangeEvent) {
        String newValue=(String)valueChangeEvent.getNewValue();
        this.setCurrentPanel(newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
