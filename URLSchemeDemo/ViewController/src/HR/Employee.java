package HR;

import java.util.List;

public class Employee {

    public Employee() {
    }

    public Employee(int id, String first, String last, String address, String city, String state, String zip,
                   String phone, String mobile, int salary, int deptid) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.mobile = mobile;
        this.salary = salary;
        this.deptid = deptid;
    }


    protected int id;
    protected String first;
    protected String last;
    protected String address;
    protected String city;
    protected String state;
    protected String zip;
    protected String phone;
    protected String mobile;
    protected int salary;
    protected int deptid;

    public String getKey() {
        Integer i = new Integer(id);
        return i.toString();        
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFirst() {
        return first;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLast() {
        return last;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getDeptid() {
        return deptid;
    }

}
