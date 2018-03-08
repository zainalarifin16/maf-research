package mobile;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class ProgrammaticBean {
    public ProgrammaticBean() {
    }

    public void doNavigation(ActionEvent actionEvent) {
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.outcome}", String.class);
        String outcome = (String)ve.getValue(AdfmfJavaUtilities.getELContext());
        
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureId(),
                                                                   "adf.mf.api.amx.doNavigation", new Object[] { outcome });        
    }

    public void valueChangeNavigate(ValueChangeEvent valueChangeEvent) {
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.outcome}", String.class);
        String outcome = (String)ve.getValue(AdfmfJavaUtilities.getELContext());
        
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureId(),
                                                                   "adf.mf.api.amx.doNavigation", new Object[] { outcome });        
    }
}
