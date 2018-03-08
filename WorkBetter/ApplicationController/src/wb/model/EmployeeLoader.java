package wb.model;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class EmployeeLoader implements Runnable {
    private Employee e = null;
    
    public EmployeeLoader(Employee e) {
        this.e = e;
    }

    @Override
    public void run() {
        this.e.setLoading(true);
        AdfmfJavaUtilities.flushDataChangeEvent(); 
        WBUtils.loadEmp(e);
        this.e.setLoading(false);
        AdfmfJavaUtilities.flushDataChangeEvent(); 
    }
}
