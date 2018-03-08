package model;

import java.util.ArrayList;
import java.util.List;


public class ScatterDataList {
    
    private static List<ScatterData> s_scatterDataList = null;
    
    public ScatterDataList() {
        super();
        
        if (s_scatterDataList == null) {
            s_scatterDataList = new ArrayList<ScatterData>();
            
            s_scatterDataList.add(new ScatterData("Group A", "Series 1", -15, -15));
            s_scatterDataList.add(new ScatterData("Group B", "Series 1", -25, -43));
            s_scatterDataList.add(new ScatterData("Group C", "Series 1", -25, -25));
            s_scatterDataList.add(new ScatterData("Group A", "Series 2", -25, -15));
            s_scatterDataList.add(new ScatterData("Group B", "Series 2", -55, -45));
            s_scatterDataList.add(new ScatterData("Group C", "Series 2", -57, -47));
            s_scatterDataList.add(new ScatterData("Group A", "Series 3", -17, -36));
            s_scatterDataList.add(new ScatterData("Group B", "Series 3", -32, -52));
            s_scatterDataList.add(new ScatterData("Group C", "Series 3", -26, -28));
            s_scatterDataList.add(new ScatterData("Group A", "Series 4", -38, -22));
            s_scatterDataList.add(new ScatterData("Group B", "Series 4", -43, -43));
            s_scatterDataList.add(new ScatterData("Group C", "Series 4", -58, -36));
        }        
    }    
    
    public List<ScatterData> getScatterData() {
        return s_scatterDataList;
    }
    
    public int getScatterDataCount() {
        return s_scatterDataList.size();
    }
}
