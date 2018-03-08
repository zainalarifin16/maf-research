package mobile;

import javax.el.ValueExpression;

import oracle.adfmf.config.client.ConfigurationService;
import oracle.adfmf.config.client.ProgressListener;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.util.Utility;

public class ConfigServiceHandler {
    
    private static String CFG_SERVICE_CONN_NAME = "ConfigService";
    private static String CFG_LOGIN_CONN_NAME = "ConfigServerLogin";
    private static String CFG_LOGIN = "/login.jspx";
    private static String CFG_LOGOUT = "/logout.jspx";
    private static String CFG_SERVICE = "";
    private static String CUSTOMIZED_VERSION_1 = "1.0.1";

    private ConfigurationService cfgService = null;
    private String status = "";
    private boolean downLoadInProgress = false;

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    
    public ConfigServiceHandler() {
        super();
        cfgService = new ConfigurationService();
    }
    
    public void setDownLoadInProgress(boolean downLoadInProgress) {
        boolean oldDownLoadInProgress = this.downLoadInProgress;
        this.downLoadInProgress = downLoadInProgress;
        propertyChangeSupport.firePropertyChange("downLoadInProgress", oldDownLoadInProgress, downLoadInProgress);
    }

    public boolean isDownLoadInProgress() {
        return downLoadInProgress;
    }

    public void setStatus(String status) {
        String oldStatus = this.status;
        this.status = status;
        propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }

    public String getStatus() {
        return status;
    }

    public void updateConfig() throws Exception {
        startConfigurationThread();
    }
    
    public void updateConnectionsEndpoints() {
        
        
        String serverURL = getConfiguredURL();
        if (!Utility.isEmpty(serverURL)) {
            AdfmfJavaUtilities.clearSecurityConfigOverrides(CFG_LOGIN_CONN_NAME);
            AdfmfJavaUtilities.clearSecurityConfigOverrides(CFG_SERVICE_CONN_NAME);
            AdfmfJavaUtilities.overrideConnectionProperty(CFG_LOGIN_CONN_NAME, "login", "url", serverURL + CFG_LOGIN);
            AdfmfJavaUtilities.overrideConnectionProperty(CFG_LOGIN_CONN_NAME, "logout", "url", serverURL + CFG_LOGOUT);
            AdfmfJavaUtilities.overrideConnectionProperty(CFG_SERVICE_CONN_NAME, "restconnection", "url", serverURL + CFG_SERVICE);
            AdfmfJavaUtilities.updateApplicationInformation(false);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    private synchronized void startConfigurationThread() {
        if (!downLoadInProgress) {
            final ConfigurationDownloadThread downloadThread = new ConfigurationDownloadThread();
            setStatus(null);
            downloadThread.start();
        }
    }
    
    private static String getConfiguredURL() {
        ValueExpression ve1 = AdfmfJavaUtilities.getValueExpression("#{applicationScope.configServiceEndpoint}", String.class);
        String serverURL = (String)ve1.getValue(AdfmfJavaUtilities.getELContext());
        System.out.println("Configured URL from preferences: " + serverURL);
        return serverURL;
    }
    
    /**
     * ConfigurationDownloadThread implements progress listener. It provides the progress
     * status update while staging the Configuration Service.
     */
    class ConfigurationDownloadThread extends Thread implements ProgressListener {

        public ConfigurationDownloadThread() {
        }

        /**
         * ProgressListener update progress handler.
         *
         * @param name of the resource
         * @param message associated with the resource
         * @param percentage overall completion percentage
         */
        public void updateProgress(String name, String message, float percentage) {
            final String pMessage = ("" + percentage + "00000000").substring(0, 6);
            setStatus(" [ " + pMessage + "% ] " + message);
            AdfmfJavaUtilities.flushDataChangeEvent();
        }

        /**
         * It stages the configuration and activates the version
         */
        public void run() {
            System.out.println("Download thread started ");
            try {
                ConfigServiceHandler.this.setDownLoadInProgress(true);
                AdfmfJavaUtilities.flushDataChangeEvent();
                cfgService.addProgressListener(this);
                cfgService.setDeliveryMechanism("http");
                cfgService.setDeliveryMechanismConfiguration("connectionName", CFG_SERVICE_CONN_NAME);
                cfgService.stageAndActivateVersion(CUSTOMIZED_VERSION_1);
            } catch (Throwable t) {
                t.printStackTrace();
                setStatus(t.getLocalizedMessage());
            } finally {
                cfgService.removeProgressListener(this);
                ConfigServiceHandler.this.setDownLoadInProgress(false);
                AdfmfJavaUtilities.flushDataChangeEvent();
            }
        }
    }
}
