package Contacts;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class ValueChangeHandler {
    
    
    public ValueChangeHandler() {
    }

    public void handleValueChange(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("inside handleValueChange.."+valueChangeEvent);
        Object newvalue=valueChangeEvent.getNewValue();
        ContactField ffield=new ContactField();
        if(newvalue!=null){
            ffield=(ContactField)newvalue;
            AdfmfJavaUtilities.setELValue("#{pageFlowScope.valuechange}", ffield.getFieldName());        
            System.out.println("new value.."+ffield.getFieldName());
        }
        System.out.println("after if condition..");
  
        
      
        

    }
}
