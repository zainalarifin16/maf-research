package wb.model;

import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;

import java.util.logging.Level;

import javax.microedition.io.HttpConnection;


import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;
import oracle.maf.api.dc.ws.rest.RestServiceAdapter;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.api.Model;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONObject;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

import wb.application.LifeCycleListenerImpl;

public class WBUtils {
    protected static volatile Map<Integer, Employee> empMaster = new HashMap<Integer, Employee>();
    protected static volatile Map<Integer, Department> deptMaster = new HashMap<Integer, Department>();
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static final String MBEID = "cd2ff671-b72e-4bb5-bc6f-3a43dc6a60f9";
    public static final String MBESECRET =
        "Basic TUNTSUREMV9NQ1NTVkMxUFJPRF9NT0JJTEVfQU5PTllNT1VTX0FQUElEOmI0MS5pYXJiRXRzd2tn";

    protected static String imageURL = "";

    public WBUtils() {
    }

    public static synchronized OrgSummary loadSummary(int empid) {
        OrgSummary summary = null;
        String queryString = "/OrgSummary?rootEmpId=" + empid;
        String response = invokeService(queryString);
        if (!response.isEmpty()) {
            JSONObject obj = null;
            try {
                obj = new JSONObject(response);
                JSONArray jsonArray = new JSONArray();
                summary = (OrgSummary) JSONBeanSerializationHelper.fromJSON(OrgSummary.class, obj);

                if (obj.has("Attrition")) {
                    jsonArray = obj.getJSONArray("Attrition");
                    if (jsonArray != null) {
                        int count = jsonArray.length();
                        if (count > 0) {
                            summary.attritionList.clear();
                        }
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Attrition jObj = new Attrition();
                            jObj = (Attrition) JSONBeanSerializationHelper.fromJSON(Attrition.class, arrayObj);
                            summary.attritionList.add(jObj);
                        }
                        summary.providerChangeSupport.fireProviderRefresh("attrition");
                    }
                }

                if (obj.has("OrgDepartments")) {
                    jsonArray = obj.getJSONArray("OrgDepartments");
                    if (jsonArray != null) {
                        int count = jsonArray.length();
                        if (count > 0) {
                            summary.orgDeptList.clear();
                        }
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Department jObj = new Department();
                            jObj = (Department) JSONBeanSerializationHelper.fromJSON(Department.class, arrayObj);
                            jObj.setDeptavgrating(arrayObj.getDouble("Deptavgrating"));
                            jObj.setDeptavgcompratio(arrayObj.getDouble("Deptavgcompratio"));
                            summary.orgDeptList.add(jObj);
                            updateDeptMaster(jObj);
                        }
                        summary.providerChangeSupport.fireProviderRefresh("userDepartments");
                    }
                }

                if (obj.has("Profile")) {
                    jsonArray = obj.getJSONArray("Profile");
                    if (jsonArray != null) {
                        JSONObject profile = (JSONObject) jsonArray.get(0);
                        if (profile != null) {
                            Employee emp = (Employee) JSONBeanSerializationHelper.fromJSON(Employee.class, profile);
                            emp.setInOrg(true);
                            updateEmpMaster(emp);
                            summary.setUser(emp);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return summary;
    }

    public static Employee loadEmp(int empid) {
        Employee emp = empMaster.get(empid);
        if (emp == null) {
            emp = new Employee();
            emp.setEmpid(empid);
            // Load it syncronously because the summary isn't already loaded
            loadEmp(emp);
        } else {
            // Load it asynchronously because the summary is already loaded
            if (!emp.isDetailLoaded()) {
                emp.loadDetail();
            }
        }
        return emp;
    }

    public static Department loadDept(int deptid) {
        Department dept = deptMaster.get(deptid);
        if (dept == null) {
            dept = new Department();
            dept.setDeptid(deptid);
            // Load it syncronously because the summary isn't already loaded
            loadDept(dept);
        } else {
            // Load it asynchronously because the summary is already loaded
            if (!dept.isDetailLoaded()) {
                dept.loadDetail();
            }
        }
        return dept;
    }

    public static void loadDept(Department dept) {
        String queryString = "/Departments/" + dept.getDeptid();
        String response = invokeService(queryString);
        JSONObject obj = null;
        try {
            obj = new JSONObject(response);
            parseDept(dept, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadEmp(Employee emp) {
        String queryString = "/Employees/" + emp.getEmpid();
        String response = invokeService(queryString);
        JSONObject obj = null;
        try {
            obj = new JSONObject(response);
            parseEmp(emp, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void parseEmp(Employee emp, JSONObject obj) {
        try {
            if (obj.has("Empid"))
                emp.setEmpid(obj.getInt("Empid"));
            if (obj.has("Address"))
                emp.setAddress(obj.getString("Address"));
            if (obj.has("Bonus"))
                emp.setBonus(obj.getInt("Bonus"));
            if (obj.has("City"))
                emp.setCity(obj.getString("City"));
            if (obj.has("Commission"))
                emp.setCommission(obj.getInt("Commission"));
            if (obj.has("Compratio"))
                emp.setCompratio(obj.getInt("Compratio"));
            if (obj.has("Country"))
                emp.setCountry(obj.getString("Country"));
            if (obj.has("Deptid"))
                emp.setDeptid(obj.getInt("Deptid"));
            if (obj.has("Deptname"))
                emp.setDeptname(obj.getString("Deptname"));
            if (obj.has("Directs"))
                emp.setDirects(obj.getInt("Directs"));
            if (obj.has("Email"))
                emp.setEmail(obj.getString("Email"));
            if (obj.has("Facebook"))
                emp.setFacebook(obj.getString("Facebook"));
            if (obj.has("Firstname"))
                emp.setFirstname(obj.getString("Firstname"));
            if (obj.has("Hiredate"))
                emp.setHiredate(formatter.parse(obj.getString("Hiredate")));
            if (obj.has("Jobcode"))
                emp.setJobcode(obj.getString("Jobcode"));
            if (obj.has("Lastname"))
                emp.setLastname(obj.getString("Lastname"));
            if (obj.has("Linkedin"))
                emp.setLinkedin(obj.getString("Linkedin"));
            if (obj.has("Lossimpact"))
                emp.setLossimpact(obj.getInt("Lossimpact"));
            if (obj.has("Lossrisk"))
                emp.setLossrisk(obj.getInt("Lossrisk"));
            if (obj.has("MgrFirstname"))
                emp.setMgrFirstname(obj.getString("MgrFirstname"));
            if (obj.has("MgrLastname"))
                emp.setMgrLastname(obj.getString("MgrLastname"));
            if (obj.has("MgrTitle"))
                emp.setMgrTitle(obj.getString("MgrTitle"));
            if (obj.has("Mgrid"))
                emp.setMgrid(obj.getInt("Mgrid"));
            if (obj.has("Mobile"))
                emp.setMobile(obj.getString("Mobile"));
            if (obj.has("Office"))
                emp.setOffice(obj.getString("Office"));
            if (obj.has("Phone"))
                emp.setPhone(obj.getString("Phone"));
            if (obj.has("Postal"))
                emp.setPostal(obj.getString("Postal"));
            if (obj.has("Potential"))
                emp.setPotential(obj.getInt("Potential"));
            if (obj.has("Rating"))
                emp.setRating(obj.getInt("Rating"));
            if (obj.has("Salary"))
                emp.setSalary(obj.getInt("Salary"));
            if (obj.has("State"))
                emp.setState(obj.getString("State"));
            if (obj.has("Tenure"))
                emp.setTenure(obj.getInt("Tenure"));
            if (obj.has("Title"))
                emp.setTitle(obj.getString("Title"));
            if (obj.has("Twitter"))
                emp.setTwitter(obj.getString("Twitter"));
            if (obj.has("Teamavgrating"))
                emp.setTeamAvgRating(obj.getDouble("Teamavgrating"));
            if (obj.has("Teamavgpotential"))
                emp.setTeamAvgPotential(obj.getDouble("Teamavgpotential"));
            if (obj.has("Maxteamcomp"))
                emp.setMaxTeamComp(obj.getInt("Maxteamcomp"));

            JSONArray jsonArray = null;

            Department d = deptMaster.get(emp.getDeptid());
            if (d != null) {
                emp.setDept(d);
            } else {
                d = new Department();
                d.setDeptid(emp.getDeptid());
                d.setDeptname(emp.getDeptname());
                updateDeptMaster(d);

            }

            if (obj.has("PerfHistory")) {
                jsonArray = obj.getJSONArray("PerfHistory");
                if (jsonArray != null) {
                    int count = jsonArray.length();
                    if (count > 0) {
                        emp.perfHistoryList.clear();
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Performance jObj = new Performance();
                            jObj = (Performance) JSONBeanSerializationHelper.fromJSON(Performance.class, arrayObj);
                            emp.perfHistoryList.add(jObj);
                        }
                        emp.providerChangeSupport.fireProviderRefresh("perfHistory");
                    }
                }
            }

            if (obj.has("OrgEmpPerfHistory")) {
                jsonArray = obj.getJSONArray("OrgEmpPerfHistory");
                if (jsonArray != null) {
                    int count = jsonArray.length();
                    if (count > 0) {
                        emp.perfHistoryList.clear();
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Performance jObj = new Performance();
                            jObj = (Performance) JSONBeanSerializationHelper.fromJSON(Performance.class, arrayObj);
                            emp.perfHistoryList.add(jObj);
                        }
                        emp.providerChangeSupport.fireProviderRefresh("perfHistory");
                    }
                }
            }

            if (obj.has("CompHistory")) {
                jsonArray = obj.getJSONArray("CompHistory");
                if (jsonArray != null) {
                    int count = jsonArray.length();
                    if (count > 0) {
                        emp.compHistoryList.clear();
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Compensation jObj = new Compensation();
                            jObj = (Compensation) JSONBeanSerializationHelper.fromJSON(Compensation.class, arrayObj);
                            emp.compHistoryList.add(jObj);
                        }
                        emp.providerChangeSupport.fireProviderRefresh("compHistory");
                    }
                }
            }

            if (obj.has("Skills")) {
                jsonArray = obj.getJSONArray("Skills");
                if (jsonArray != null) {
                    int count = jsonArray.length();
                    if (count > 0) {
                        emp.skillList.clear();
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Skill jObj = new Skill();
                            jObj = (Skill) JSONBeanSerializationHelper.fromJSON(Skill.class, arrayObj);
                            emp.skillList.add(jObj);
                        }
                        emp.providerChangeSupport.fireProviderRefresh("skills");
                    }
                }
            }

            if (obj.has("Colleagues")) {
                jsonArray = obj.getJSONArray("Colleagues");
                if (jsonArray != null) {
                    int count = jsonArray.length();
                    if (count > 0) {
                        emp.colleagueList.clear();
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Employee jObj = new Employee();
                            jObj = (Employee) JSONBeanSerializationHelper.fromJSON(Employee.class, arrayObj);
                            emp.colleagueList.add(jObj);
                            updateEmpMaster(jObj);
                        }
                        emp.providerChangeSupport.fireProviderRefresh("colleagues");
                    }
                }
            }

            if (obj.has("Events")) {
                jsonArray = obj.getJSONArray("Events");
                if (jsonArray != null) {
                    int count = jsonArray.length();
                    if (count > 0) {
                        emp.eventList.clear();
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Event jObj = new Event();
                            jObj = (Event) JSONBeanSerializationHelper.fromJSON(Event.class, arrayObj);
                            emp.eventList.add(jObj);
                        }
                        emp.providerChangeSupport.fireProviderRefresh("events");
                    }
                }
            }

            if (obj.has("DirectEmps")) {
                jsonArray = obj.getJSONArray("DirectEmps");
                if (jsonArray != null) {
                    int count = jsonArray.length();
                    if (count > 0) {
                        emp.directList.clear();
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Employee jObj = new Employee();
                            jObj = (Employee) JSONBeanSerializationHelper.fromJSON(Employee.class, arrayObj);
                            emp.directList.add(jObj);
                            updateEmpMaster(jObj);
                        }
                        emp.providerChangeSupport.fireProviderRefresh("directReports");
                    }
                }
            }

            empMaster.put(emp.getEmpid(), emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized void parseDept(Department dept, JSONObject obj) {
        try {
            if (obj.has("Address"))
                dept.setAddress(obj.getString("Address"));
            if (obj.has("City"))
                dept.setCity(obj.getString("City"));
            if (obj.has("Color"))
                dept.setColor(obj.getString("Color"));
            if (obj.has("Country"))
                dept.setCountry(obj.getString("Country"));
            if (obj.has("Deptid"))
                dept.setDeptid(obj.getInt("Deptid"));
            if (obj.has("Deptname"))
                dept.setDeptname(obj.getString("Deptname"));
            if (obj.has("Postal"))
                dept.setPostal(obj.getString("Postal"));
            if (obj.has("State"))
                dept.setState(obj.getString("State"));
            if (obj.has("Mgrid"))
                dept.setMgrid(obj.getInt("Mgrid"));

            Employee e = empMaster.get(dept.getMgrid());
            if (e == null) {
                e = new Employee();
                e.setEmpid(dept.getMgrid());
            }
            if (obj.has("MgrFirstname"))
                e.setFirstname(obj.getString("MgrFirstname"));
            if (obj.has("MgrLastname"))
                e.setLastname(obj.getString("MgrLastname"));
            if (obj.has("MgrTitle"))
                e.setTitle(obj.getString("MgrTitle"));
            loadPicture(e, false);
            dept.setManager(e);
            updateEmpMaster(e);

            JSONArray jsonArray = null;

            if (obj.has("DeptEmployees")) {
                jsonArray = obj.getJSONArray("DeptEmployees");
                if (jsonArray != null) {
                    int count = jsonArray.length();
                    if (count > 0) {
                        dept.orgList.clear();
                        for (int x = 0; x < count; x++) {
                            JSONObject arrayObj = (JSONObject) jsonArray.get(x);
                            Employee jObj = new Employee();
                            jObj = (Employee) JSONBeanSerializationHelper.fromJSON(Employee.class, arrayObj);
                            dept.orgList.add(jObj);
                            updateEmpMaster(jObj);
                            if (jObj.getDirects() > 0) {
                                dept.setMgrnum(dept.getMgrnum() + 1);
                            }
                            dept.setEmpnum(dept.getEmpnum() + 1);
                        }
                        dept.providerChangeSupport.fireProviderRefresh("employees");
                    }
                }
            }

            deptMaster.put(dept.getDeptid(), dept);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected static void updateEmpMaster(Employee e) {
        Employee emp = empMaster.get(e.getEmpid());
        if (emp == null) {
            empMaster.put(e.getEmpid(), e);
        }
    }

    protected static void updateDeptMaster(Department d) {
        Department dept = deptMaster.get(d.getDeptid());
        if (dept == null) {
            deptMaster.put(d.getDeptid(), d);
        }
    }

    public static String invokeService(String resource) {
        String response = "";

        RestServiceAdapterFactory factory = RestServiceAdapterFactory.newFactory();
        RestServiceAdapter rs = factory.createRestServiceAdapter();

        // Clear any previously set request properties, if any
        rs.clearRequestProperties();

        // Set the connection name
        rs.setConnectionName("WBService");

        rs.addRequestProperty("Oracle-Mobile-Backend-Id", MBEID);
        rs.addRequestProperty("Authorization", MBESECRET);

        // Specify the type of request
        rs.setRequestMethod(RestServiceAdapter.REQUEST_TYPE_GET);

        // Specify the number of retries
        rs.setRetryLimit(0);

        // Set the URI which is defined after the endpoint in the connections.xml.
        // The request is the endpoint + the URI being set
        rs.setRequestURI("/custom/workbetterV2" + resource);
        try {
            // For GET request, there is no payload
            response = rs.send("");
            if (response.isEmpty()) {
                AdfmfJavaUtilities.purgeSyncCache();
                response = rs.send("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String loadPicture(Employee emp, boolean isMgr) {
        String filename = "/images/nopic.png";

        try {
            int empid;
            if (!isMgr) {
                empid = emp.getEmpid();
            } else {
                empid = emp.getMgrid();
            }
            if (empid <= 190) {
                String localfile =
                    AdfmfJavaUtilities.getDirectoryPathRoot(AdfmfJavaUtilities.ApplicationDirectory) + "/e-" + empid +
                    ".png";

                File f = new File(localfile);
                //First check if we have it cached locally
                if (f != null && !f.exists()) {
                    if( imageURL.isEmpty()) {
                        getImageURL();
                    }
                    if( !imageURL.isEmpty()) {
                        EmployeePicLoader empPicLoader = new EmployeePicLoader(emp, localfile, isMgr);
                        Thread worker = new Thread(empPicLoader);
                        worker.start();
                    }
                } else {
                    filename = "file://" + localfile;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    private static void getImageURL() {
        RestServiceAdapterFactory factory = RestServiceAdapterFactory.newFactory();
        RestServiceAdapter rs =
            factory.createRestServiceAdapter(); // Clear any previously set request properties, if any
        rs.clearRequestProperties();

        // Set the connection name
        rs.setConnectionName("WBService");

        // Specify the type of request
        rs.setRequestMethod(RestServiceAdapter.REQUEST_TYPE_GET);

        rs.addRequestProperty("Oracle-Mobile-Backend-Id", WBUtils.MBEID);
        rs.addRequestProperty("Authorization", WBUtils.MBESECRET);

        // Specify the number of retries
        rs.setRetryLimit(0);

        rs.setRequestURI("/platform/appconfig/client");
        try {
            // For GET request, there is no payload
            String response = rs.send("");
            if (!response.isEmpty()) {
                JSONObject properties = new JSONObject(response);
                imageURL = properties.get("ImageURL").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
