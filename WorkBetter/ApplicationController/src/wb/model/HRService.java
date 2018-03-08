package wb.model;


import java.lang.reflect.Type;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;
import java.util.logging.Level;

import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;
import oracle.maf.api.dc.ws.rest.RestServiceAdapter;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.api.Model;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.json.JSONObject;
import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;


public class HRService {
    private Employee profile = null;
    private Department department = null;
    private String filter = "";
    private static OrgSummary orgSummary = null;
    private static List<Employee> orgEmployees = new ArrayList<Employee>();
    private List<Employee> directory = new ArrayList<Employee>();
    private List<Employee> filteredDirectory = new ArrayList<Employee>();
    private List<Department> departments = new ArrayList<Department>();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

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

    public HRService() {
    }

    public void setProfile(Employee profile) {
        Employee oldProfile = this.profile;
        this.profile = profile;
        propertyChangeSupport.firePropertyChange("profile", oldProfile, profile);
    }

    public Employee getProfile() {
        return profile;
    }

    public void setDepartment(Department department) {
        Department oldDepartment = this.department;
        this.department = department;
        propertyChangeSupport.firePropertyChange("department", oldDepartment, department);
    }

    public Department getDepartment() {
        return department;
    }

    public void setOrgSummary(OrgSummary orgSummary) {
        OrgSummary oldOrgSummary = HRService.orgSummary;
        HRService.orgSummary = orgSummary;
        propertyChangeSupport.firePropertyChange("orgSummary", oldOrgSummary, orgSummary);
    }

    public OrgSummary getOrgSummary() {
        return orgSummary;
    }

    public void login(int empid) {
        if (orgSummary == null || (orgSummary.getEmpid() != empid)) {
            orgSummary = WBUtils.loadSummary(empid);
            if (orgSummary != null) {
                loadOrgEmployees();
            }
        }
        if (orgSummary != null) {
            AdfmfJavaUtilities.setELValue("#{applicationScope.UserBean.userEmpid}", orgSummary.getEmpid());
            AdfmfJavaUtilities.setELValue("#{applicationScope.UserBean.firstname}",
                                          orgSummary.getUser().getFirstname());
            AdfmfJavaUtilities.setELValue("#{applicationScope.UserBean.lastname}", orgSummary.getUser().getLastname());
            AdfmfJavaUtilities.setELValue("#{applicationScope.UserBean.title}", orgSummary.getUser().getTitle());
        } else {
            AdfmfJavaUtilities.purgeSyncCache();
            throw (new AdfException("The server is not responding", AdfException.ERROR));
        }
    }

    public void loadProfile(int empid) {
        setProfile(WBUtils.loadEmp(empid));
    }
    
    public void loadDept(int deptid) {
        setDepartment(WBUtils.loadDept(deptid));
    }


    public void setFilter(String filter) {
        String oldFilter = this.filter;
        this.filter = filter;
        propertyChangeSupport.firePropertyChange("filter", oldFilter, filter);
        filterDirectory();
    }

    public String getFilter() {
        return filter;
    }

    public List<Employee> getDirectory() {
        if (directory.size() == 0) {
            loadDirectory();
            filterDirectory();
        }
        return filteredDirectory;
    }

    private void filterDirectory() {
        filteredDirectory.clear();

        int count = directory.size();
        for (int x = 0; x < count; x++) {
            Employee e = directory.get(x);
            if (e.getFirstname().toLowerCase().contains(filter.toLowerCase()) ||
                e.getLastname().toLowerCase().contains(filter.toLowerCase())) {
                filteredDirectory.add(e);
            }
        }
        providerChangeSupport.fireProviderRefresh("directory");
    }

    public void loadDirectory() {
        directory.clear();

        String response = WBUtils.invokeService("/Employees");

        if (!response.isEmpty()) {
            try {
                JSONArray jsonArray = new JSONArray(response);

                int count = jsonArray.length();
                for (int x = 0; x < count; x++) {
                    JSONObject item = (JSONObject) jsonArray.get(x);
                    Integer empid = item.getInt("Empid");
                    Employee emp = WBUtils.empMaster.get(empid.intValue());
                    if (emp == null) {
                        emp = new Employee();
                    }
                    WBUtils.parseEmp(emp, item);
                    directory.add(emp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //            throw(new AdfException("The server is not responding", AdfException.ERROR));
        }
    }

    public List<Employee> getOrgEmployees() {
        if (orgEmployees.size() == 0) {
            loadOrgEmployees();
        }
        return orgEmployees;
    }

    public void loadOrgEmployees() {

        orgEmployees.clear();

        int num = WBUtils.empMaster.size();
        for (int x = 0; x < num; x++) {
            Iterator it = WBUtils.empMaster.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                Employee e = (Employee) pair.getValue();
                if (e.getEmpid() == orgSummary.getEmpid()) {
                    e.setInOrg(true);
                } else {
                    e.setInOrg(false);
                }
                WBUtils.empMaster.replace(e.getEmpid(), e);
            }
        }

        if (orgSummary != null) {
            String response =
                WBUtils.invokeService("/OrgEmployees?rootEmpId=" +
                                      orgSummary.getEmpid());

            try {
                JSONArray jsonArray = new JSONArray(response);

                int count = jsonArray.length();
                for (int x = 0; x < count; x++) {
                    JSONObject item = (JSONObject) jsonArray.get(x);
                    Integer empid = item.getInt("Empid");
                    Employee emp = WBUtils.empMaster.get(empid.intValue());
                    if (emp == null) {
                        emp = new Employee();
                    }
                    emp.setInOrg(true);
                    WBUtils.parseEmp(emp, item);
                    orgEmployees.add(emp);
                }
                providerChangeSupport.fireProviderRefresh("orgEmployees");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static final Comparator<Employee> ALPHA = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            int lastCmp = e1.getLastname().compareTo(e2.getLastname());
            return (lastCmp != 0 ? lastCmp : e1.getFirstname().compareTo(e2.getFirstname()));
        }
    };
    static final Comparator<Employee> COMPRATIO = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            Integer e2CR = new Integer(e2.getCompratio());
            Integer e1CR = new Integer(e1.getCompratio());

            return e1CR.compareTo(e2CR);
        }
    };
    static final Comparator<Employee> RATING = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            Integer e2CR = new Integer(e2.getRating());
            Integer e1CR = new Integer(e1.getRating());

            return e1CR.compareTo(e2CR);
        }
    };
    static final Comparator<Employee> POTENTIAL = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            Integer e2CR = new Integer(e2.getPotential());
            Integer e1CR = new Integer(e1.getPotential());

            return e1CR.compareTo(e2CR);
        }
    };
    static final Comparator<Employee> TOTALCOMP = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            Integer e2CR = new Integer(e2.getSalary() + e2.getBonus() + e2.getCommission());
            Integer e1CR = new Integer(e1.getSalary() + e1.getBonus() + e1.getCommission());

            return e1CR.compareTo(e2CR);
        }
    };
    static final Comparator<Employee> LOSSRISK = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            Integer e2CR = new Integer(e2.getLossrisk());
            Integer e1CR = new Integer(e1.getLossrisk());

            return e1CR.compareTo(e2CR);
        }
    };
    static final Comparator<Employee> LOSSIMPACT = new Comparator<Employee>() {
        public int compare(Employee e1, Employee e2) {
            Integer e2CR = new Integer(e2.getLossimpact());
            Integer e1CR = new Integer(e1.getLossimpact());

            return e1CR.compareTo(e2CR);
        }
    };

    public void sortOrgEmployees(String sorttype) {
        List<Employee> newList = new ArrayList<Employee>(orgEmployees);

        switch (sorttype) {
        case "rating":
            Collections.sort(newList, RATING);
            break;
        case "potential":
            Collections.sort(newList, POTENTIAL);
            break;
        case "compratio":
            Collections.sort(newList, COMPRATIO);
            break;
        case "lossrisk":
            Collections.sort(newList, LOSSRISK);
            break;
        case "lossimpact":
            Collections.sort(newList, LOSSIMPACT);
            break;
        case "totalcomp":
            Collections.sort(newList, TOTALCOMP);
            break;
        default:
            Collections.sort(newList, ALPHA);
        }

        orgEmployees.clear();
        int count = newList.size();
        for (int x = 0; x < count; x++) {
            orgEmployees.add(newList.get(x));
        }
        providerChangeSupport.fireProviderRefresh("orgEmployees");
    }
}
