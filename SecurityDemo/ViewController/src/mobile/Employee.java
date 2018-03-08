package mobile;

import java.util.Date;

public class Employee {
    protected int id;
    protected String first;
    protected String last;
    protected String email;
    protected String phone;
    protected Date hireDate;
    protected double salary;
    protected double commPct;
    protected int deptId;

    public Employee() {
    }
    
    public Employee( Employee newemp ) {
        setId(newemp.id);
        setFirst(newemp.first);
        setLast(newemp.last);
        setEmail(newemp.email);
        setPhone(newemp.phone);
        setHireDate(newemp.hireDate);
        setSalary(newemp.salary);
        setCommPct(newemp.commPct);
        setDeptId(newemp.deptId);
    }

    public Employee(int id, String first, String last, String email, String phone, Date hireDate, double salary, double commPct, int deptId) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.email = email;
        this.phone = phone;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commPct = commPct;
        this.deptId = deptId;
    }

    public void copy( Employee newemp ) {
        setId(newemp.id);
        setFirst(newemp.first);
        setLast(newemp.last);
        setEmail(newemp.email);
        setPhone(newemp.phone);
        setHireDate(newemp.hireDate);
        setSalary(newemp.salary);
        setCommPct(newemp.commPct);
        setDeptId(newemp.deptId);
    }
 

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirst(String first) {
        String oldFirst = this.first;
        this.first = first;
    }

    public String getFirst() {
        return first;
    }

    public void setLast(String last) {
        String oldLast = this.last;
        this.last = last;
    }

    public String getLast() {
        return last;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setSalary(double salary) {
        double oldSalary = this.salary;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setHireDate(Date hireDate) {
        Date oldHireDate = this.hireDate;
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setDeptId(int deptId) {
        int oldDeptId = this.deptId;
        this.deptId = deptId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setCommPct(double commPct) {
        double oldCommPct = this.commPct;
        this.commPct = commPct;
    }

    public double getCommPct() {
        return commPct;
    }
}
