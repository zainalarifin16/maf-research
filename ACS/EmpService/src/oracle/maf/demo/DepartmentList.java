package oracle.maf.demo;

import java.util.ArrayList;
import java.util.List;


public class DepartmentList {
    private static List s_departments = null;
    private static EmployeeList s_employees = new EmployeeList();

    public DepartmentList() {
        if (s_departments == null) {
            s_departments = new ArrayList();
            s_departments.add(new Department(100, "Sales", "100 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(200, "Finance", "201 Main Street", "Rocklin", "CA", "94065"));
            s_departments.add(new Department(300, "Marketing", "500 Owens Dr", "Pleasanton", "CA", "94065"));
            s_departments.add(new Department(400, "Engineering", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
        }
    }

    public Department[] getDepartments() {
        Department d[] = null;

        d = (Department[])s_departments.toArray(new Department[s_departments.size()]);

        return d;
    }

    public Employee[] getEmployeesByDept(int deptId) {
        ArrayList reports = new ArrayList();

        /*Employee[] emps = s_employees.getEmployees();
        for (int x = 0; x < emps.length; x++) {
            Employee e = emps[x];
            if (e.getDeptId() == deptId) {
                reports.add(e);
            }
        }*/

        return (Employee[])reports.toArray(new Employee[reports.size()]);
    }

}
