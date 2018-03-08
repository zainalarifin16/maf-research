package mobile;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class GestureHandler implements oracle.adfmf.feature.LifeCycleListener {
    private String currentlySelectedPanel="panel1";
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setCurrentlySelectedPanel(String currentlySelectedPanel) {
        String oldCurrentlySelectedPanel = this.currentlySelectedPanel;
        this.currentlySelectedPanel = currentlySelectedPanel;
        propertyChangeSupport.firePropertyChange("currentlySelectedPanel", oldCurrentlySelectedPanel,
                                                 currentlySelectedPanel);
    }

    public String getCurrentlySelectedPanel() {
        return currentlySelectedPanel;
    }


    public GestureHandler() {
    }

    public void activate() {
        String gesture = "";
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.gesture}", gesture);
    }

    public void deactivate() {
    }


    public void SwipeRightHandler(ActionEvent actionEvent) {
        String gesture = "m:SR";
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.gesture}", gesture);
    }

    public void SwipeLeftHandler(ActionEvent actionEvent) {
        String gesture = "m:SL";
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.gesture}", gesture);
    }

    public void SwipeUpHandler(ActionEvent actionEvent) {
        String gesture = "m:SU";
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.gesture}", gesture);

    }

    public void SwipeDownHandler(ActionEvent actionEvent) {
        String gesture = "m:SD";
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.gesture}", gesture);

    }

    public void TapHoldHandler(ActionEvent actionEvent) {
        String gesture = "m:TH";
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.gesture}", gesture);
    }

    public void invokeValueChange(ValueChangeEvent valueChangeEvent) {
        String newValue=(String)valueChangeEvent.getNewValue();
        this.setCurrentlySelectedPanel(newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
