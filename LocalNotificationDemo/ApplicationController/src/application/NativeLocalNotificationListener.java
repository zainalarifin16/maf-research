package application;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;

import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.event.Event;
import oracle.adfmf.framework.event.EventListener;
import oracle.adfmf.framework.event.NativeLocalNotificationEvent;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.json.JSONObject;

public class NativeLocalNotificationListener implements EventListener {
    public NativeLocalNotificationListener() {
    }

    public void onMessage(Event event) {
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String appState = stringifyAppState(event.getApplicationState());
        String payload = event.getPayload();
                
        System.out.println("#### Local Notification received at " + date);
        System.out.println("#### appState = " + appState);
        System.out.println("#### payload=" + payload);
        
        // For the purpose of demo, set some EL values and navigate to a feature to display it
        HashMap<String, Object> payloadMap = ((NativeLocalNotificationEvent)event).getPayloadObject();
        String alert = (String)payloadMap.get("alert");
        JSONObject jsonPayload = (JSONObject)payloadMap.get("payload");
        AdfmfJavaUtilities.setELValue("#{applicationScope.notificationDate}", date);
        AdfmfJavaUtilities.setELValue("#{applicationScope.notificationAlert}", alert != null ? alert : "");
        AdfmfJavaUtilities.setELValue("#{applicationScope.notificationAppState}", appState);
        AdfmfJavaUtilities.setELValue("#{applicationScope.notificationPayload}", jsonPayload != null ? jsonPayload.toString() : "");
        AdfmfContainerUtilities.gotoFeature("Notification");
    }

    public void onError(AdfException adfException) {
        System.out.println("#### Local Notification error: " + adfException.getMessage());
    }
    
    public void onOpen(String token) {
        System.out.println("#### Local Notification opened: " + token);
    }    
    
    private String stringifyAppState(int appState) {
        switch(appState) {
            case Event.APPLICATION_STATE_FOREGROUND: return "FOREGROUND";
            case Event.APPLICATION_STATE_BACKGROUND: return "BACKGROUND";
            case Event.APPLICATION_STATE_NOT_RUNNING: return "NOT RUNNING";
        }
        return "UNKNOWN";
    }
}
