package mobile;

import javax.el.ValueExpression;

import oracle.adf.model.datacontrols.device.DeviceManager;
import oracle.adf.model.datacontrols.device.DeviceManagerFactory;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

import oracle.maf.api.dc.ws.rest.RestServiceAdapter;
import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;

public class PushRegisterBean {
    public PushRegisterBean() {
    }
    
    public void registerWithAppProvider(ActionEvent evt) {        
        // Read the token provided by GCM/APNs
        ValueExpression ve1 = AdfmfJavaUtilities.getValueExpression("#{applicationScope.deviceToken}", String.class);
        String deviceToken = (String)ve1.getValue(AdfmfJavaUtilities.getELContext());

        // Read the user id
        ValueExpression ve2 = AdfmfJavaUtilities.getValueExpression("#{applicationScope.userId}", String.class);
        String userId = (String)ve2.getValue(AdfmfJavaUtilities.getELContext());
        
        // Read the GCM sender id
        ValueExpression ve3 = AdfmfJavaUtilities.getValueExpression("#{applicationScope.configuration.gcmSenderId}", String.class);
        String gcmSenderId = (String)ve3.getValue(AdfmfJavaUtilities.getELContext());
        
        // Read the device type
        DeviceManager deviceManager = DeviceManagerFactory.getDeviceManager();
        String deviceType = deviceManager.getOs().toLowerCase();

        // Register this user with this device for this app
        RestServiceAdapter restServiceAdapter = RestServiceAdapterFactory.newFactory().createRestServiceAdapter();
        restServiceAdapter.clearRequestProperties();
        restServiceAdapter.setConnectionName("PushServiceConn");
        restServiceAdapter.setRequestMethod(RestServiceAdapter.REQUEST_TYPE_GET);
        restServiceAdapter.setRetryLimit(0);
        restServiceAdapter.setRequestURI("?userId=" + userId + "&deviceToken=" + deviceToken + "&senderId=" + gcmSenderId + "&deviceType=" + deviceType);

        String response = "";
        try {
            // It's a GET request, so there's no payload
            response = restServiceAdapter.send("");
        } catch (Exception e) {
            e.printStackTrace();
            response = e.getMessage();
        }

        // Write a registration response to app scope to display to the user
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{applicationScope.registerResponse}", String.class);
        if (response.contains("Successfully")) {
            ve.setValue(AdfmfJavaUtilities.getELContext(), "Successfully registered the user with this device.");
        } else {
            ve.setValue(AdfmfJavaUtilities.getELContext(), "Failed to register the user with this device: " + response);
        }
        AdfmfJavaUtilities.flushDataChangeEvent();
    }
    
}