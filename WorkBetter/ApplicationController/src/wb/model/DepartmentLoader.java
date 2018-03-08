package wb.model;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class DepartmentLoader implements Runnable {
    private Department d = null;
    
    public DepartmentLoader(Department d) {
        this.d = d;
    }

    @Override
    public void run() {
        this.d.setLoading(true);
        AdfmfJavaUtilities.flushDataChangeEvent(); 
        WBUtils.loadDept(d);
        this.d.setLoading(false);
        AdfmfJavaUtilities.flushDataChangeEvent(); 
    }
}
