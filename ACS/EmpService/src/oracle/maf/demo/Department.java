package oracle.maf.demo;

import java.util.List;


public class Department {
    protected static DepartmentList depts = new DepartmentList();
    protected int deptId;
    protected String deptName;
    protected String address;
    protected String city;
    protected String state;
    protected String zip;

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




    public void setDeptId(int deptId) {
        int oldDeptId = this.deptId;
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptName(String deptName) {
        String oldDeptName = this.deptName;
        this.deptName = deptName;
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
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(String zip) {
        String oldZip = this.zip;
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }
}
