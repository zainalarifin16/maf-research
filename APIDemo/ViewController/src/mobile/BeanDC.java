package mobile;

import oracle.adfmf.framework.api.AdfmfContainerUtilities;

public class BeanDC {
    public BeanDC() {
        super();
    }
    

    public void DoMyMethod() {
        AdfmfContainerUtilities.gotoFeature("Success");
    }

    
    
}
