package wb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

public class Department {
    private boolean loading = false;
    private int deptid;
    private String deptname;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postal;
    private int mgrid;
    private String latCoord;
    private String longCoord;
    private Double deptavgrating;
    private int deptminrating;
    private int deptmaxrating;
    private Double deptavgcompratio;
    private String color;
    private int mgrnum;
    private int empnum;

    private Employee manager = new Employee();

    protected List<Employee> orgList = new ArrayList<Employee>();

    protected transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    public Department() {
        super();
    }

    public Department(int deptid, String deptname, String address, String city, String state, String country,
                      String postal, int mgrid, String latCoord,
                      String longCoord, String color) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal = postal;
        this.mgrid = mgrid;
        this.latCoord = latCoord;
        this.longCoord = longCoord;
        this.color = color;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void addProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.removeProviderChangeListener(l);
    }

    public void loadDetail() {
        DepartmentLoader deptLoader = new DepartmentLoader(this);
        Thread worker = new Thread(deptLoader);
        worker.start();
    }

    public List<Employee> getEmployees() {
        return orgList;
    }


    public void setManager(Employee manager) {
        Employee oldManager = this.manager;
        this.manager = manager;
        propertyChangeSupport.firePropertyChange("manager", oldManager, manager);
    }

    public Employee getManager() {
        return manager;
    }

    public boolean isDetailLoaded() {
        return (orgList.size() > 0);
    }

    public void setLoading(boolean loading) {
        boolean oldLoading = this.loading;
        this.loading = loading;
        propertyChangeSupport.firePropertyChange("loading", oldLoading, loading);
    }

    public boolean isLoading() {
        return loading;
    }

    public void setDeptid(int deptid) {
        int oldDeptid = this.deptid;
        this.deptid = deptid;
        propertyChangeSupport.firePropertyChange("deptid", oldDeptid, deptid);
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptname(String deptname) {
        String oldDeptname = this.deptname;
        this.deptname = deptname;
        propertyChangeSupport.firePropertyChange("deptname", oldDeptname, deptname);
    }

    public String getDeptname() {
        return deptname;
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

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
        propertyChangeSupport.firePropertyChange("country", oldCountry, country);
    }

    public String getCountry() {
        return country;
    }

    public void setPostal(String postal) {
        String oldPostal = this.postal;
        this.postal = postal;
        propertyChangeSupport.firePropertyChange("postal", oldPostal, postal);
    }

    public String getPostal() {
        return postal;
    }

    public void setMgrid(int mgrid) {
        int oldMgrid = this.mgrid;
        this.mgrid = mgrid;
        propertyChangeSupport.firePropertyChange("mgrid", oldMgrid, mgrid);
    }

    public int getMgrid() {
        return mgrid;
    }


    public void setLatCoord(String latCoord) {
        String oldLatCoord = this.latCoord;
        this.latCoord = latCoord;
        propertyChangeSupport.firePropertyChange("latCoord", oldLatCoord, latCoord);
    }

    public String getLatCoord() {
        return latCoord;
    }

    public void setLongCoord(String longCoord) {
        String oldLongCoord = this.longCoord;
        this.longCoord = longCoord;
        propertyChangeSupport.firePropertyChange("longCoord", oldLongCoord, longCoord);
    }

    public String getLongCoord() {
        return longCoord;
    }

    public String getPic() {
        String image = "";
        Integer i = new Integer(this.deptid);
        if (i.intValue() < 158) {
            image = i.toString() + ".png";
        }
        return image;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setDeptavgrating(Double deptavgrating) {
        Double oldDeptavgrating = this.deptavgrating;
        this.deptavgrating = deptavgrating;
        propertyChangeSupport.firePropertyChange("deptavgrating", oldDeptavgrating, deptavgrating);
    }

    public Double getDeptavgrating() {
        return deptavgrating;
    }

    public void setDeptminrating(int deptminrating) {
        int oldDeptminrating = this.deptminrating;
        this.deptminrating = deptminrating;
        propertyChangeSupport.firePropertyChange("deptminrating", oldDeptminrating, deptminrating);
    }

    public int getDeptminrating() {
        return deptminrating;
    }

    public void setDeptmaxrating(int deptmaxrating) {
        int oldDeptmaxrating = this.deptmaxrating;
        this.deptmaxrating = deptmaxrating;
        propertyChangeSupport.firePropertyChange("deptmaxrating", oldDeptmaxrating, deptmaxrating);
    }

    public int getDeptmaxrating() {
        return deptmaxrating;
    }

    public void setDeptavgcompratio(Double deptavgcompratio) {
        Double oldDeptavgcompratio = this.deptavgcompratio;
        this.deptavgcompratio = deptavgcompratio;
        propertyChangeSupport.firePropertyChange("deptavgcompratio", oldDeptavgcompratio, deptavgcompratio);
    }

    public Double getDeptavgcompratio() {
        return deptavgcompratio;
    }

    public void setMgrnum(int mgrnum) {
        int oldMgrnum = this.mgrnum;
        this.mgrnum = mgrnum;
        propertyChangeSupport.firePropertyChange("mgrnum", oldMgrnum, mgrnum);
    }

    public int getMgrnum() {
        return mgrnum;
    }

    public void setEmpnum(int empnum) {
        int oldEmpnum = this.empnum;
        this.empnum = empnum;
        propertyChangeSupport.firePropertyChange("empnum", oldEmpnum, empnum);
    }

    public int getEmpnum() {
        return empnum;
    }
}
