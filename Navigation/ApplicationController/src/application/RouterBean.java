package application;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.util.logging.Trace;
import java.util.logging.Level;

public class RouterBean {
    public RouterBean() {
        super();
    }
    
    private String currEmp = "";

    public void setCurrEmp(String currEmp) {
        this.currEmp = currEmp;
    }

    public String getCurrEmp() {
        return currEmp;
    }

    public void GotoEmployeeDetail(ActionEvent action) {
        AdfmfContainerUtilities.resetFeature("Employees");
    }
    
    public boolean getIsDetail() {
        boolean ret = false;
        if( currEmp.length() > 0) {
            ret = true;
        }

        return ret;
    }
}
