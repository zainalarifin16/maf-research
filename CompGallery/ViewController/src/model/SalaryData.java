package model;

public class SalaryData {
    private String name;
    private double salary;
    private double commision;

    public SalaryData() {
        super();
    }
    
    public SalaryData(String name, double salary, double commision) {
        this.name = name;
        this.salary = salary;
        this.commision = commision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }
}
