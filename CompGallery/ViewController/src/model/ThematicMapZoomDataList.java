package model;

import java.util.ArrayList;
import java.util.List;


public class ThematicMapZoomDataList {
    
    private static List<ThematicMapZoomData> s_thematicMapZoomDataList = null;
    
    public ThematicMapZoomDataList() {
        
        if (s_thematicMapZoomDataList == null) {
            s_thematicMapZoomDataList = new ArrayList<ThematicMapZoomData>();
            
            s_thematicMapZoomDataList.add(new ThematicMapZoomData("CT", "#64C8C8", "Category 1"));
            s_thematicMapZoomDataList.add(new ThematicMapZoomData("ME", "#64C8C8", "Category 2"));
            s_thematicMapZoomDataList.add(new ThematicMapZoomData("MA", "#64C8C8", "Category 3"));
            s_thematicMapZoomDataList.add(new ThematicMapZoomData("NH", "#64C8C8", "Category 4"));
            s_thematicMapZoomDataList.add(new ThematicMapZoomData("RI", "#64C8C8", "Category 5"));
            s_thematicMapZoomDataList.add(new ThematicMapZoomData("VT", "#64C8C8", "Category 6"));
        }        
    }    
    
    public List<ThematicMapZoomData> getThematicMapZoomData() {
        return s_thematicMapZoomDataList;
    }
    
    public int getThematicMapZoomDataCount() {
        return s_thematicMapZoomDataList.size();
    }
}