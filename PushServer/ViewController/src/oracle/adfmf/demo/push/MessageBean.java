package oracle.adfmf.demo.push;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class MessageBean {
    private String message;
    private String deviceType;

    /**
     * ---------------------------------------------------------
     * Instructions on how to configure and run this server app.
     * ---------------------------------------------------------
     *  
     * This app requires a Google API Key for communicating with 
     * the Google Cloud Messaging (GCM) server and iOS keystore
     * details for communicating with the Apple Push Notification
     * server (APNs).  
     * 
     * If you are an Oracle employee, you can retrieve these 
     * details from the MAF Uptake Guide wiki.
     * 
     * If you are not an Oracle employee:
     * 
     * 1. Create your own project on the Google Developer site.
     *    The Project Number is the GCM Sender Id used in the 
     *    PushDemo mobile app.
     * 2. Create an API Key for the server (0.0.0.0 can be used
     *    for testing), which is required by this server app.
     * 3. Create your own iOS provisioning profile and matching
     *    certificate via the Apple Developer site.
     * 4. Create a keystore (.p12) file from the certificate.
     * 5. Rename the PushDemo mobile app appropriately.
     *
     * Having followed these steps, configure and run this server
     * app as follows:
     * 
     * 1.  Set the Google API Key and iOS keystore details below.
     * 2.  If you are running on a corporate network, you may need 
     *     to set the proxy details below.
     * 3.  This app requires a database.  Two database connections
     *     are specified within bc4j.xcfg.  RegistrationModelShared
     *     points a shared DB available to those on the Oracle 
     *     corporate network.  RegistrationModelLocal points to a
     *     local MySQL database that you must manage yourself.  A
     *     pushschema.sql script is provided in the Model project
     *     to create the necessary tables.  If you are not on the
     *     Oracle  network, you may need to remove the shared DB
     *     connection completely for the server app to run.
     * 4.  Ensure the DB is running and you can connect to it via
     *     Application Resources > Connections > Database.
     * 5.  If you are on a corporate network, you may need to set
     *     a proxy in Preferences > Web Browser & Proxy.
     * 6.  Start a WLS instance via Run > Start Server Instance.
     *     On a Mac you may need to add a line specifying your
     *     machine name in /etc/hosts as IP address 127.0.0.1.
     * 7.  The first time you start the embedded server, you must
     *     specify which IP address(es) can be used for server
     *     connection (typically all).  This can be modified via
     *     the WLS console (http://localhost:7101/console).
     * 8.  To facilitate connection to GCM, turn off hostname 
     *     verification via the WLS console > Servers > 
     *     Default Server > Configuration > SSL > Advanced.
     * 9.  Deploy the server app via RegistrationServlet.java > 
     *     Run. This may report an error, which is ok.
     *     
     * If you are running the server on a corporate network, you
     * may require to run a VPN on the mobile device in order to 
     * connect to the server via the corporate network.  In this
     * case, you may need to turn off the VPN on your Android 
     * device for registration with GCM and when you wish to 
     * receive the notification from GCM.
     */

    // Your Google project APIKEY
    private static String GOOGLE_APIKEY = null;
    // Your iOS keystore file location
    private static String IOS_KEYFILE = null;
    // Your iOS keystore password
    private static String IOS_KEYPWD = null;
    // Your proxy host name (or null)
    private static String PROXY_HOST = null;
    // Your proxy port (or null)
    private static String PROXY_PORT = null;

    public MessageBean() {
        super();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void pushMessage(ActionEvent evt) {
        try {
            String deviceType = getValueFromEL("#{bindings.DeviceModel.inputValue}");
            if ("android".equals(deviceType)) {
               pushMessageAndroid();
            } else if("ios".equals(deviceType)) {
               pushMessageIOS();
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), "");
            FacesContext fctx = FacesContext.getCurrentInstance();
            fctx.addMessage(null, fm);
        }
    }
    
    private void pushMessageAndroid() throws Exception {
        Sender sender = new Sender(GOOGLE_APIKEY);
        Message message = new Message.Builder().addData("alert", this.getMessage()).addData("sound", "default").addData("badge", "1").build();
        String regId = getValueFromEL("#{bindings.deviceToken.inputValue}");
        try {
            Result res = sender.send(message, regId, 5);
            String id = res.getMessageId();
            String cregId = res.getCanonicalRegistrationId();
            String errorCode = res.getErrorCodeName();
            String retMsg = "Message pushed : Id : " + id + "; CRegId: " + cregId + "; ErrorCode : " + errorCode;
            showResponse(retMsg);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void pushMessageIOS() throws Exception {
        String regId = getValueFromEL("#{bindings.deviceToken.inputValue}");
        String message = "{\n" +
                "   \"aps\":\n" +
                "   {\n" +
                "       \"alert\":\"" + this.getMessage() + "\",\n" +
                "       \"sound\":\"default\",\n" +
                "       \"badge\":1\n" +
                "   }\n" +
                "}";
        new PushApns(IOS_KEYFILE, IOS_KEYPWD, PROXY_HOST, PROXY_PORT).sendString(regId, message);
    }
    
    private void showResponse(String msg) {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        FacesContext fctx = FacesContext.getCurrentInstance();
        fctx.addMessage(null, fm);
    }

    private String getValueFromEL(String expr) {
        FacesContext fctx = FacesContext.getCurrentInstance();
        Application app = fctx.getApplication();
        ExpressionFactory eFac = app.getExpressionFactory();
        ELContext elCtx = fctx.getELContext();
        ValueExpression ve = eFac.createValueExpression(elCtx, expr, String.class);
        return (String)ve.getValue(elCtx);
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }
}
