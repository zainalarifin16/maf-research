package application;

import java.util.HashMap;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.event.Event;
import oracle.adfmf.framework.event.EventListener;
import oracle.adfmf.framework.event.NativeLocalNotificationEvent;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;

public class NativeLocalNotificationListener implements EventListener {

  public NativeLocalNotificationListener() {
  }

  public void onMessage(Event event) {
    try {
      HashMap<String, Object> payloadMap = ((NativeLocalNotificationEvent)event).getPayloadObject();
      JSONObject jsonPayload = (JSONObject)payloadMap.get("payload");
      boolean inside = jsonPayload.getBoolean("inside");
    
      // If inside, start ranging and navigate to the Welcome feature
      if (inside) {
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction("About", "startRanging", new Object[] {});
        AdfmfContainerUtilities.gotoFeature("Welcome");
      }
    } catch (JSONException e) {
      System.out.println("Local Notification JSON error: " + e.getMessage());
    }
  }

  public void onError(AdfException adfException) {
    System.out.println("Local Notification error: " + adfException.getMessage());
  }

  public void onOpen(String token) {
    System.out.println("Local Notification opened: " + token);
  }
}