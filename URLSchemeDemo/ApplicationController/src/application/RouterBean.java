package application;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.util.logging.Trace;
import java.util.logging.Level;

import javax.el.ValueExpression;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;

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
    
    public boolean getIsDetail() {
        boolean ret = false;
        
        ValueExpression val =AdfmfJavaUtilities.getValueExpression("#{applicationScope.empId}", Object.class);
        currEmp=(String)val.getValue(AdfmfJavaUtilities.getELContext());
        if( currEmp!=null && currEmp.length() > 0) {    
            ret = true; 
        }
        
        return ret;
    }
}
