package HR;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EmployeeList {
    private static List s_employees = null;
    private static Stack currEmp = null;

    public EmployeeList() {
        if (s_employees == null) {
            s_employees = new ArrayList();

            s_employees.add(new Employee(1, "Bob", "Billings", "123 Anywhere Dr", "Redwood City", "CA", "94065",
                                         "6503456789", "6501234567", 96000, 1));
            s_employees.add(new Employee(2, "John", "Smith", "344 Anywhere Dr", "San Mateo", "CA", "94065",
                                         "6503456789", "6501234567", 95300, 2));
            s_employees.add(new Employee(3, "Jane", "Smith", "55 Anywhere Dr", "Livermore", "CA", "94065",
                                         "6503456789", "6501234567", 96300, 3));
            s_employees.add(new Employee(4, "Bruce", "Johnson", "232 Anywhere Dr", "Milpitas", "CA", "94065",
                                         "6503456789", "6501234567", 100500, 4));
            s_employees.add(new Employee(5, "Dan", "Dublin", "66 Anywhere Dr", "Palo Alto", "CA", "94065",
                                         "6503456789", "6501234567", 98000, 5));
            s_employees.add(new Employee(6, "Ted", "Tooling", "44 Anywhere Dr", "Los Angeles", "CA", "94065",
                                         "6503456789", "6501234567", 101000, 6));
            s_employees.add(new Employee(7, "Kent", "Kindling", "33 Anywhere Dr", "Millbrae", "CA", "94065",
                                         "6503456789", "6501234567", 97000, 7));
            s_employees.add(new Employee(8, "Travis", "Trails", "22 Anywhere Dr", "Dublin", "CA", "94065",
                                         "6503456789", "6501234567", 96500, 8));
            s_employees.add(new Employee(9, "Julia", "Jiles", "11 Anywhere Dr", "Pleasanton", "CA", "94065",
                                         "6503456789", "6501234567", 94000, 9));
            s_employees.add(new Employee(10, "Larry", "Leering", "3232 Anywhere Dr", "Tracy", "CA", "94065",
                                         "6503456789", "6501234567", 92000, 10));
            s_employees.add(new Employee(11, "John", "Billings", "999 Anywhere Dr", "Brentwood", "CA", "94065",
                                         "6503456789", "6501234567", 96000, 1));
            s_employees.add(new Employee(12, "Jack", "Smith", "888 Anywhere Dr", "Livermore", "CA", "94065",
                                         "6503456789", "6501234567", 95300, 2));
            s_employees.add(new Employee(13, "Bruce", "Smith", "777 Anywhere Dr", "Milpitas", "CA", "94065",
                                         "6503456789", "6501234567", 96300, 3));
            s_employees.add(new Employee(14, "Dan", "Johnson", "666 Anywhere Dr", "Palo Alto", "CA", "94065",
                                         "6503456789", "6501234567", 100500, 4));
            s_employees.add(new Employee(15, "Ted", "Dublin", "555 Anywhere Dr", "Los Angeles", "CA", "94065",
                                         "6503456789", "6501234567", 98000, 5));
            s_employees.add(new Employee(16, "Kent", "Tooling", "444 Anywhere Dr", "Millbrae", "CA", "94065",
                                         "6503456789", "6501234567", 101000, 6));
            s_employees.add(new Employee(17, "Owen", "Kindling", "333 Anywhere Dr", "Dublin", "CA", "94065",
                                         "6503456789", "6501234567", 97000, 7));
            s_employees.add(new Employee(18, "Josh", "Trails", "222 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789",
                                         "6501234567", 96500, 8));
            s_employees.add(new Employee(19, "Travis", "Jiles", "111 Anywhere Dr", "Tracy", "CA", "94065",
                                         "6503456789", "6501234567", 94000, 9));
            s_employees.add(new Employee(20, "Kevin", "Leering", "911 Anywhere Dr", "Antioch", "CA", "94065",
                                         "6503456789", "6501234567", 92000, 10));

        }
        if (currEmp == null) {
            currEmp = new Stack();
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

    public String getCurrentEmpKey() {
        return (String)currEmp.peek();
    }

    public String PopEmployee() {
        return (String)currEmp.pop();
    }

    public void PushEmployee(String key) {
        currEmp.push(key);
    }

}
