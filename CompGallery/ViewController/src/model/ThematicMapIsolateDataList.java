package model;

import java.util.ArrayList;
import java.util.List;


public class ThematicMapIsolateDataList {
    
    private static List<ThematicMapIsolateData> s_thematicMapIsolateDataList = null;
    
    public ThematicMapIsolateDataList() {
        
        if (s_thematicMapIsolateDataList == null) {
            s_thematicMapIsolateDataList = new ArrayList<ThematicMapIsolateData>();
            
            s_thematicMapIsolateDataList.add(new ThematicMapIsolateData(95, "MA", "#64C8C8"));
          s_thematicMapIsolateDataList.add(new ThematicMapIsolateData(35, "DC", "#C864C8"));
          s_thematicMapIsolateDataList.add(new ThematicMapIsolateData(45, "IL", "#C8C864"));
          s_thematicMapIsolateDataList.add(new ThematicMapIsolateData(45, "MI", "#C864C8"));
          s_thematicMapIsolateDataList.add(new ThematicMapIsolateData(65, "NY", "#64C8C8"));
          s_thematicMapIsolateDataList.add(new ThematicMapIsolateData(75, "TX", "#64C864"));
        }        
    }    
    
    public List<ThematicMapIsolateData> getThematicMapIsolateData() {
        return s_thematicMapIsolateDataList;
    }
    
    public int getThematicMapIsolateDataCount() {
        return s_thematicMapIsolateDataList.size();
    }
}