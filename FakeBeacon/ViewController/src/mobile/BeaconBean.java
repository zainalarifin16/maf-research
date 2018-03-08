package mobile;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class BeaconBean {

  private boolean advertising;
  private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

  public BeaconBean() {
  }

  public void setAdvertising(boolean advertising) {
    boolean oldAdvertising = this.advertising;
    this.advertising = advertising;
    propertyChangeSupport.firePropertyChange("advertising", oldAdvertising, advertising);
  }

  public boolean isAdvertising() {
    return advertising;
  }

  public void startAdvertising(ActionEvent actionEvent) {
    AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureId(), "startAdvertising", new Object[] {});
    setAdvertising(true);
  }

  public void stopAdvertising(ActionEvent actionEvent) {
    AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureId(), "stopAdvertising", new Object[] {});
    setAdvertising(false);
  }

  public void addPropertyChangeListener(PropertyChangeListener l) {
    propertyChangeSupport.addPropertyChangeListener(l);
  }

  public void removePropertyChangeListener(PropertyChangeListener l) {
    propertyChangeSupport.removePropertyChangeListener(l);
  }
}