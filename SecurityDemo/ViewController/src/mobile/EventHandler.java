package mobile;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class EventHandler {
    public EventHandler() {
    }

    public void doLogout(ActionEvent evt) {
        AdfmfJavaUtilities.logout();   
    }
}
