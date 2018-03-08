package mobile;

import javax.el.MethodExpression;
import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class ManagedBean {
    public ManagedBean() {
        super();
    }
    
    private Boolean navBarStatus = Boolean.FALSE;

    public void ActionHandler(ActionEvent actionEvent) {
        AdfmfContainerUtilities.gotoFeature("Success");
    }

    public void ValueHandler(ValueChangeEvent valueChangeEvent) {
        String showNav = (String)valueChangeEvent.getNewValue().toString();
        if(showNav.equals("true") ) {
            AdfmfContainerUtilities.showNavigationBar();
        }
        else {
            AdfmfContainerUtilities.hideNavigationBar();
        }
    }

    public void setNavBarStatus(Boolean navBarStatus) {
        this.navBarStatus = navBarStatus;
    }

    public Boolean getNavBarStatus() {
        return navBarStatus;
    }
    

    public void ValueExprHandler(ActionEvent actionEvent) {
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.button1}", String.class);
        String button1 = (String)ve.getValue(AdfmfJavaUtilities.getELContext());
        button1 += "+";
        ve.setValue(AdfmfJavaUtilities.getELContext(), button1);        
    }

    public void MethodExprHandler(ActionEvent actionEvent) {
        MethodExpression me = AdfmfJavaUtilities.getMethodExpression("#{bindings.DoMyMethod.execute}", Object.class, new Class[] {}); 
        me.invoke(AdfmfJavaUtilities.getELContext(), new Object[] {});
    }    

    // This method calls the "doAlert" javascript function in the "Javascript" feature and passes in a variable number of params
    public void FireAlerts(ActionEvent actionEvent) {
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction("Javascript", "doAlert", new Object[] {});

        AdfmfContainerUtilities.invokeContainerJavaScriptFunction("Javascript", "doAlert", new Object[] {"arg1"});

        AdfmfContainerUtilities.invokeContainerJavaScriptFunction("Javascript", "doAlert", new Object[] {"arg1", "arg2"});

    }

    // This method calls the "fetchPic" javascript function in the "Javascript" feature with no params
    public void FetchPic(ActionEvent actionEvent) {
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction("Javascript", "fetchPic", new Object[] {});
    }

    // This method calls the "fetchVideo" javascript function in the "Javascript" feature with no params
    public void FetchVideo(ActionEvent actionEvent) {
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction("Javascript", "fetchVideo", new Object[] {});
    }


    // This method will be called by the Javascript method so we show 2-way communication.     
    public void FetchCallback(String path) {
        // We'll simply set a scoped variable that we are displaying on the page
        AdfmfJavaUtilities.setELValue("#{applicationScope.alertMessage}", path);
    }


}
