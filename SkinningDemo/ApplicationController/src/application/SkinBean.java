package application;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class SkinBean {
    private String skinVersion = "v1.6";
    private String message = "You must see a gray header background color and black header font color";
    private String selectedSkinValue = "mobileAlta";
    private String deviceModel = "iPad iPad4,1";
    private String deviceOS = "iOS";

    public void setDeviceOS(String deviceOS) {
        String oldDeviceOS = this.deviceOS;
        this.deviceOS = deviceOS;
        propertyChangeSupport.firePropertyChange("deviceOS", oldDeviceOS, deviceOS);
    }

    public String getDeviceOS() {
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{deviceScope.device.os}", String.class);
        String deviceOS = (String) ve.getValue(AdfmfJavaUtilities.getELContext());
        return deviceOS;
    }


    public void setDeviceModel(String deviceModel) {
        String oldDeviceModel = this.deviceModel;
        this.deviceModel = deviceModel;
        propertyChangeSupport.firePropertyChange("deviceModel", oldDeviceModel, deviceModel);
    }

    public String getDeviceModel() {
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{deviceScope.device.model}", String.class);
        String deviceModel = (String) ve.getValue(AdfmfJavaUtilities.getELContext());
        return deviceModel;
    }

    public void setSelectedSkinValue(String selectedSkinValue) {
        String oldSelectedSkinValue = this.selectedSkinValue;
        this.selectedSkinValue = selectedSkinValue;
        propertyChangeSupport.firePropertyChange("selectedSkinValue", oldSelectedSkinValue, selectedSkinValue);
    }

    public String getSelectedSkinValue() {
        return selectedSkinValue;
    }

    public void setMessage(String message) {
        String oldMessage = this.message;
        this.message = message;
        propertyChangeSupport.firePropertyChange("message", oldMessage, message);
    }

    public String getMessage() {
        return message;
    }

    public void setSkinVersion(String skinVersion) {
        String oldSkinVersion = this.skinVersion;
        this.skinVersion = skinVersion;
        propertyChangeSupport.firePropertyChange("skinVersion", oldSkinVersion, skinVersion);
    }

    public String getSkinVersion() {
         return skinVersion;
    }
    private String skinFamily = "mobileAlta";


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

    public void setSkinFamily(String skinFamily) {
        String oldSkinFamily = this.skinFamily;
        this.skinFamily = skinFamily;
        propertyChangeSupport.firePropertyChange("skinFamily", oldSkinFamily, skinFamily);
    }

    public String getSkinFamily() {
        return skinFamily;
    }


    public SkinBean() {
        super();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }


    private void updateSkinProperties(String skinFamily) {
        
      
        
        String deviceModel = getDeviceModel();
        String deviceOS = getDeviceOS();

        if (skinFamily != null && skinFamily.equals("mobileAlta")) {
            this.setSkinFamily("mobileAlta");
            this.setSkinVersion("v1.6");
            this.setMessage("You must see a gray header background color and black header font color");
        } else if (skinFamily != null && skinFamily.equals("customFamily1-v1")) {
            this.setSkinFamily("customFamily1");
            this.setSkinVersion("v1");

            if (deviceOS != null && deviceOS.equals("UWP")) {
                this.setMessage("You must see a maroon header background color and white header font color");
            } else if(deviceOS != null && deviceOS.equals("iOS")){
                this.setMessage("You must see a red header background color and white header font color");
            } else if(deviceOS != null && deviceOS.equals("Android")){
                this.setMessage("You must see a red header background color and white header font color");
            } 
            
        } else if (skinFamily != null && skinFamily.equals("customFamily1-v2")) {
            this.setSkinFamily("customFamily1");
            this.setSkinVersion("v2");
            if (deviceModel != null && deviceModel.equals("iPad iPad4,1")) {
                this.setMessage("You must see a blue header background color and white header font color");
            } else if (deviceModel != null && deviceModel.equals("iPhone iPhone6,1")) {
                this.setMessage("You must see a orange header background color and white header font color");
            } else if (deviceModel != null && deviceModel.equals("Nexus 7")) {
                this.setMessage("You must see a maroon header background color and white header font color");
            } else if (deviceModel != null && deviceModel.equals("SAMSUNG-SGH-I747")) {
                this.setMessage("You must see a yellow header background color and black header font color");
            } else if (deviceOS != null && deviceOS.equals("Android")) {
                this.setMessage("You must see a lime header background color and black header font color");
            } else if (deviceOS != null && deviceOS.equals("iOS")) {
                this.setMessage("You must see a green header background color and white header font color");
            } else if (deviceOS != null && deviceOS.equals("UWP")) {
                this.setMessage("You must see a Orange header background color and white header font color");
            }

        }

      AdfmfContainerUtilities.resetApplication("Switching Skins");
    }

    public void handleSkinChange(ValueChangeEvent valueChangeEvent) {
        String newValue = (String) valueChangeEvent.getNewValue();
        updateSkinProperties(newValue);
    }


}
