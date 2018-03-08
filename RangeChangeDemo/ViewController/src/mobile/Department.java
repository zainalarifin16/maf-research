package mobile;

import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Department {
    protected int _deptId;
    protected String _deptName;
    protected String _address;
    protected String _city;
    protected String _state;
    protected String _zip;
    private transient PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

    public Department() {
        super();
    }
    
    public Department( int deptId, String deptName, String address, String city, String state, String zip) {
        setDeptId(deptId);
        setDeptName(deptName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setDeptId(int deptId) {
        int oldDeptId = _deptId;
        _deptId = deptId;
        _propertyChangeSupport.firePropertyChange("deptId", oldDeptId, deptId);
    }

    public int getDeptId() {
        return _deptId;
    }
    
    public int getKey() {
        return getDeptId();
    }

    public void setDeptName(String deptName) {
        String oldDeptName = _deptName;
        _deptName = deptName;
        _propertyChangeSupport.firePropertyChange("deptName", oldDeptName, deptName);
    }

    public String getDeptName() {
        return _deptName;
    }

    public void setAddress(String address) {
        String oldAddress = _address;
        _address = address;
        _propertyChangeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getAddress() {
        return _address;
    }

    public void setCity(String city) {
        String oldCity = _city;
        _city = city;
        _propertyChangeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getCity() {
        return _city;
    }

    public void setState(String state) {
        String oldState = _state;
        _state = state;
        _propertyChangeSupport.firePropertyChange("state", oldState, state);
    }

    public String getState() {
        return _state;
    }

    public void setZip(String zip) {
        String oldZip = _zip;
        _zip = zip;
        _propertyChangeSupport.firePropertyChange("zip", oldZip, zip);
    }

    public String getZip() {
        return _zip;
    }
}
