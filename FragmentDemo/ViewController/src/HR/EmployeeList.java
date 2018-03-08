package HR;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;


public class EmployeeList {
    private static List s_employees = null;
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public EmployeeList() {
        System.out.println("!!!!!!!!!!!!!!!!!In the EmployeeList constructor!!!!!!!!!!!!!!!!!!!!!!!!!");
        if (s_employees == null) {
            s_employees = new ArrayList();
            s_employees.add((new Employee(1, "Bill", "Baily", "bill@home.com", "6503456789", new Date(), 100700, .12,
                                          100)));
            s_employees.add((new Employee(2, "Bob", "Billings", "bob@home.com", "6503456789", new Date(), 75000, .05,
                                          100)));
            s_employees.add((new Employee(3, "Fred", "Flintstone", "fred@home.com", "6503456789", new Date(), 84500, .17,
                                          300)));
            s_employees.add((new Employee(4, "Harold", "Horshak", "bruce@home.com", "6503456789", new Date(), 85300, .14,
                                          200)));
            s_employees.add((new Employee(5, "Bruce", "Johnson", "bruce@home.com", "6503456789", new Date(), 100100, .12,
                                          400)));
            s_employees.add((new Employee(6, "Roger", "Robson", "roger@home.com", "6503456789", new Date(), 90200, .13,
                                          100)));
            s_employees.add((new Employee(7, "Barny", "Rubble", "barney@home.com", "6503456789", new Date(), 100600, .18,
                                          400)));
            s_employees.add((new Employee(8, "Slim", "Shady", "slim@home.com", "6503456789", new Date(), 83500, .16,
                                          300)));
            s_employees.add((new Employee(9, "Jane", "Smith", "jane@home.com", "6501234567", new Date(), 96300, 0,
                                          300)));
            s_employees.add((new Employee(10, "John", "Smith", "john@home.com", "6503456789", new Date(), 80300, .09,
                                          200)));
            s_employees.add((new Employee(11, "Ziggy", "Zaggy", "ziggy@home.com", "6503456789", new Date(), 90600, .18,
                                          400)));
            s_employees.add((new Employee(12, "Zane", "Zero", "zane@home.com", "6503456789", new Date(), 92500, .15,
                                          200)));
        }
    }


    public Employee[] getEmployees() {
        Employee e[] = null;

        e = (Employee[])s_employees.toArray(new Employee[s_employees.size()]);

        return e;
    }

    public int getEmployeeCount() {
        return s_employees.size();
    }
}
