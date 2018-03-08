package mobile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.MafNativeLocalNotificationOptions;

public class LocalNotificationBean {
    private String title = "My title";
    private String alert = "My alert message";
    private Date date;
    private int badge;
    private boolean sound;
    private boolean vibration;

    public LocalNotificationBean() {
    }

    public void addLocalNotification(ActionEvent actionEvent) {
        String notificationDate = "now";
        try
        {
            // Set the notification options
            MafNativeLocalNotificationOptions options = new MafNativeLocalNotificationOptions();
            options.setTitle(title);
            options.setAlert(alert);
            if (date != null) {
                Calendar cal = Calendar.getInstance();
                cal.clear();
                cal.setTime(date);
                cal.set(Calendar.SECOND, 0); // Clear the seconds component to fire on the minute
                LocalDateTime l = LocalDateTime.ofInstant(Instant.ofEpochMilli(cal.getTime().getTime()), ZoneOffset.UTC);
                options.setDate(l);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                notificationDate = dateFormat.format(cal.getTime());
            }
            options.setBadge(badge);
            if (sound) {
                options.setSound(MafNativeLocalNotificationOptions.SOUND_DEFAULT_SYSTEM);
            }
            if (vibration) {
                options.setVibration(MafNativeLocalNotificationOptions.VIBRATION_DEFAULT_SYSTEM);
            }
            // Set 3 values in the JSON payload
            HashMap<String,Object> payload = new HashMap<String, Object>();
            payload.put("key1", 1);
            payload.put("key2", "hello");
            payload.put("key3", true);
            options.setPayload(payload);
            
            // Add the notification
            String notificationID = AdfmfContainerUtilities.addLocalNotification(options);
            System.out.println("++++ Notification added successfully for " + notificationDate);
            System.out.println("++++ Notification ID is " + notificationID);
        }
        catch(Exception e)
        {
            System.out.println("++++ There was a problem adding notification: " + e.getMessage());
            e.printStackTrace();
        }    
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getAlert() {
        return alert;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public int getBadge() {
        return badge;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean getSound() {
        return sound;
    }

    public void setVibration(boolean vibration) {
        this.vibration = vibration;
    }

    public boolean getVibration() {
        return vibration;
    }
}
