package oracle.maf.demo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employees {
    
    private List<Employee> emps = null;

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public Employees() {
        super();
    }
}
