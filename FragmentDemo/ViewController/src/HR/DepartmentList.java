package HR;

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
            s_departments.add(new Department(401, "Engineering1", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(402, "Engineering2", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(403, "Engineering3", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(404, "Engineering4", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(405, "Engineering5", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(406, "Engineering6", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(407, "Engineering7", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(408, "Engineering8", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(409, "Engineering9", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(500, "Engineering10", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(501, "Engineering11", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(502, "Engineering12", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(503, "Engineering13", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(504, "Engineering14", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(505, "Engineering15", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(506, "Engineering16", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(507, "Engineering17", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(508, "Engineering18", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(509, "Engineering19", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(600, "Engineering20", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(601, "Engineering21", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(602, "Engineering22", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(603, "Engineering23", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(604, "Engineering24", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(605, "Engineering25", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(606, "Engineering26", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(607, "Engineering27", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(608, "Engineering28", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(609, "Engineering29", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(700, "Engineering30", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
            s_departments.add(new Department(701, "Engineering31", "200 Oracle Parkway", "Redwood City", "CA", "94065"));
        }
    }

    public Department[] getDepartments() {
        Department d[] = null;

        d = (Department[])s_departments.toArray(new Department[s_departments.size()]);

        return d;
    }

    public Employee[] getEmployeesByDept(int deptId) {
        ArrayList reports = new ArrayList();

        Employee[] emps = s_employees.getEmployees();
        for (int x = 0; x < emps.length; x++) {
            Employee e = emps[x];
            if (e.getDeptId() == deptId) {
                reports.add(e);
            }
        }

        return (Employee[])reports.toArray(new Employee[reports.size()]);
    }

}
