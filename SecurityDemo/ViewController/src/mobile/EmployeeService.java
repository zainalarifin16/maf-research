package mobile;

import oracle.maf.api.dc.ws.rest.RestServiceAdapter;
import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.api.Model;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONObject;

public class EmployeeService {

    private Employee[] emps = null;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void setEmps(Employee[] emps) {
        Employee[] oldEmps = this.emps;
        this.emps = emps;
        propertyChangeSupport.firePropertyChange("emps", oldEmps, emps);
    }

    public Employee[] getEmps() {
        if (emps == null) {
            loadData();
        }
        return emps;
    }

    public EmployeeService() {
        super();
    }


    private void loadData() {
        
        RestServiceAdapterFactory factory = RestServiceAdapterFactory.newFactory();
        RestServiceAdapter restServiceAdapter = factory.createRestServiceAdapter();
        // Clear any previously set request properties, if any
        restServiceAdapter.clearRequestProperties();

        // Set the connection name
        restServiceAdapter.setConnectionName("empService");

        // Specify the type of request
        restServiceAdapter.setRequestMethod(RestServiceAdapter.REQUEST_TYPE_GET);        

        // Specify the number of retries
        restServiceAdapter.setRetryLimit(0);

        // Set the URI which is defined after the endpoint in the connections.xml.
        // The request is the endpoint + the URI being set
        restServiceAdapter.setRequestURI("/resources/demo/employees");

        // Execute SEND and RECEIVE operation
        try {
            // For GET request, there is no payload
            //setJsonResponse(restServiceAdapter.send(""));
            String resp = restServiceAdapter.send("");
            JSONObject root = (JSONObject) JSONBeanSerializationHelper.fromJSON(JSONObject.class, resp);
            JSONArray empArray = (JSONArray) root.get("emps");
            int size = empArray.length();
            emps = new Employee[size];
            for (int i = 0; i < size; i++) {
                Employee emp =
                    (Employee) JSONBeanSerializationHelper.fromJSON(Employee.class, empArray.getJSONObject(i));
                emps[i] = emp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
