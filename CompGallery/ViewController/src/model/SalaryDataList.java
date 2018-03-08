package model;

import java.util.ArrayList;
import java.util.List;


public class SalaryDataList {
    
    private static List<SalaryData> s_salaryDataList = null;
    
    public SalaryDataList() {
        super();
        
        if (s_salaryDataList == null) {
            s_salaryDataList = new ArrayList<SalaryData>();
            
            s_salaryDataList.add(new SalaryData("John", 4500, 2200));
            s_salaryDataList.add(new SalaryData("Jane", 3200, 3600));
            s_salaryDataList.add(new SalaryData("Frank", 5200, 1950));

        }        
    }
    
    
    public List<SalaryData> getSalaryData() {
        return s_salaryDataList;
    }
    
    public int getSalaryDataCount() {
        return s_salaryDataList.size();
    }
}
