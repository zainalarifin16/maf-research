package HR;

import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Department {
    protected static DepartmentList depts = new DepartmentList();
    protected int deptId;
    protected String deptName;
    protected String address;
    protected String city;
    protected String state;
    protected String zip;
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

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
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }



    public void setDeptId(int deptId) {
        int oldDeptId = this.deptId;
        this.deptId = deptId;
        propertyChangeSupport.firePropertyChange("deptId", oldDeptId, deptId);
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptName(String deptName) {
        String oldDeptName = this.deptName;
        this.deptName = deptName;
        propertyChangeSupport.firePropertyChange("deptName", oldDeptName, deptName);
    }

    public String getDeptName() {
        return deptName;
    }

    public Employee[] getEmployees() {
        return depts.getEmployeesByDept(deptId);
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        propertyChangeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        propertyChangeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
        propertyChangeSupport.firePropertyChange("state", oldState, state);
    }

    public String getState() {
        return state;
    }

    public void setZip(String zip) {
        String oldZip = this.zip;
        this.zip = zip;
        propertyChangeSupport.firePropertyChange("zip", oldZip, zip);
    }

    public String getZip() {
        return zip;
    }
}
