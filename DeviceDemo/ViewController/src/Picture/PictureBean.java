package Picture;

import oracle.adf.model.datacontrols.device.DeviceManager;
import oracle.adf.model.datacontrols.device.DeviceManagerFactory;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class PictureBean {
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public PictureBean() {
        super();
    }
    
    private int quality = 25;
    private int destination = DeviceManager.CAMERA_DESTINATIONTYPE_FILE_URI;
    private int source = DeviceManager.CAMERA_SOURCETYPE_PHOTOLIBRARY;
    private boolean allowEdit = false;
    private int encoding = DeviceManager.CAMERA_ENCODINGTYPE_JPEG;
    private int targetWidth = 300;
    private int targetHeight= 300;
    public String pictureData="/images/no-image.png";

    public void setPictureData(String pictureData) {
        String oldPictureData = this.pictureData;
        this.pictureData = pictureData;
        propertyChangeSupport.firePropertyChange("pictureData", oldPictureData, pictureData);
    }

    public String getPictureData() {
        return pictureData;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getDestination() {
        return destination;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getSource() {
        return source;
    }

    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public boolean getAllowEdit() {
        return allowEdit;
    }

    public boolean isAllowEdit() {
        return allowEdit;
    }

    public void setEncoding(int encoding) {
        this.encoding = encoding;
    }

    public int getEncoding() {
        return encoding;
    }

    public void setTargetWidth(int targetWidth) {
        this.targetWidth = targetWidth;
    }

    public int getTargetWidth() {
        return targetWidth;
    }

    public void setTargetHeight(int targetHeight) {
        this.targetHeight = targetHeight;
    }

    public int getTargetHeight() {
        return targetHeight;
    }
    
    public String GetSource(String result) {
        String src = "";
        int cameraDestinationURL=getDestination();
        if( cameraDestinationURL == DeviceManager.CAMERA_DESTINATIONTYPE_DATA_URL ) {
            src = "data:image/gif;base64,";
        }
        src = src + result;
        return src;
    }
    
    public String GetPicture(){
    DeviceManager deviceManager=DeviceManagerFactory.getDeviceManager();
    String picture=deviceManager.getPicture(quality, destination, source, allowEdit, encoding, targetWidth, targetWidth);
    if(picture!=null && picture.trim().length()>0){
     setPictureData(picture);
    }
    return picture;
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
