package GPS;

import java.util.logging.Level;

import java.sql.Timestamp;

import oracle.adf.model.datacontrols.device.DeviceManagerFactory;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adf.model.datacontrols.device.Location;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class GPSBean {
    private boolean highAccuracy = true;
    private int updateInterval = 1000;
    private boolean started = false;

    private double accuracy = 0;
    private double altitude = 0;
    private double altitudeAccuracy = 0;
    private double longitude = 0;
    private double latitude = 0;
    private double heading = 0;
    private String watchId = "";
    private double speed = 0;
    private Timestamp timestamp = new Timestamp(0);
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public GPSBean() {
        super();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void LocationHandler(Location currentLocation) {
        Trace.log(Utility.ApplicationLogger, Level.INFO, GPSBean.class, "LocationHandler",
                  "#############LocationHandler called");

        setAccuracy(currentLocation.getAccuracy());
        setAltitude(currentLocation.getAltitude());
        setAltitudeAccuracy(currentLocation.getAltitudeAccuracy());
        setLongitude(currentLocation.getLongitude());
        setLatitude(currentLocation.getLatitude());
        setHeading(currentLocation.getHeading());
        setWatchId(currentLocation.getWatchId());
        setSpeed(currentLocation.getSpeed());
        setTimestamp(new Timestamp(currentLocation.getTimestamp()));
    }

    public void stopLocationMonitor(ActionEvent actionEvent) {
        Trace.log(Utility.ApplicationLogger, Level.INFO, GPSBean.class, "stopLocationMonitor",
                  "###############watchid=" + getWatchId());
        if (getWatchId().length() > 0) {
            DeviceManagerFactory.getDeviceManager().clearWatchPosition(getWatchId());
            setAccuracy(0);
            setAltitude(0);
            setAltitudeAccuracy(0);
            setLongitude(0);
            setLatitude(0);
            setHeading(0);
            setWatchId("");
            setSpeed(0);
            setTimestamp(new Timestamp(0));
        }
    }

    public void setAccuracy(double accuracy) {
        double oldAccuracy = this.accuracy;
        this.accuracy = accuracy;
        propertyChangeSupport.firePropertyChange("accuracy", oldAccuracy, accuracy);
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAltitude(double altitude) {
        double oldAltitude = this.altitude;
        this.altitude = altitude;
        propertyChangeSupport.firePropertyChange("altitude", oldAltitude, altitude);
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitudeAccuracy(double altitudeAccuracy) {
        double oldAltitudeAccuracy = this.altitudeAccuracy;
        this.altitudeAccuracy = altitudeAccuracy;
        propertyChangeSupport.firePropertyChange("altitudeAccuracy", oldAltitudeAccuracy, altitudeAccuracy);
    }

    public double getAltitudeAccuracy() {
        return altitudeAccuracy;
    }

    public void setLongitude(double longitude) {
        double oldLongitude = this.longitude;
        this.longitude = longitude;
        propertyChangeSupport.firePropertyChange("longitude", oldLongitude, longitude);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        double oldLatitude = this.latitude;
        this.latitude = latitude;
        propertyChangeSupport.firePropertyChange("latitude", oldLatitude, latitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setHeading(double heading) {
        double oldHeading = this.heading;
        this.heading = heading;
        propertyChangeSupport.firePropertyChange("heading", oldHeading, heading);
    }

    public double getHeading() {
        return heading;
    }

    public void setWatchId(String watchId) {
        String oldWatchId = this.watchId;
        this.watchId = watchId;
        propertyChangeSupport.firePropertyChange("watchId", oldWatchId, watchId);
    }

    public String getWatchId() {
        return watchId;
    }

    public void setSpeed(double speed) {
        double oldSpeed = this.speed;
        this.speed = speed;
        propertyChangeSupport.firePropertyChange("speed", oldSpeed, speed);
    }

    public double getSpeed() {
        return speed;
    }

    public void setTimestamp(Timestamp timestamp) {
        Timestamp oldTimestamp = this.timestamp;
        this.timestamp = timestamp;
        propertyChangeSupport.firePropertyChange("timestamp", oldTimestamp, timestamp);
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setHighAccuracy(boolean highAccuracy) {
        boolean oldHighAccuracy = this.highAccuracy;
        this.highAccuracy = highAccuracy;
        propertyChangeSupport.firePropertyChange("highAccuracy", oldHighAccuracy, highAccuracy);
    }

    public boolean isHighAccuracy() {
        return highAccuracy;
    }

    public void setUpdateInterval(int updateInterval) {
        int oldUpdateInterval = this.updateInterval;
        this.updateInterval = updateInterval;
        propertyChangeSupport.firePropertyChange("updateInterval", oldUpdateInterval, updateInterval);
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public void setStarted(boolean started) {
        boolean oldStarted = this.started;
        this.started = started;
        propertyChangeSupport.firePropertyChange("started", oldStarted, started);
    }

    public boolean getStarted() {
        return started;
    }
}
