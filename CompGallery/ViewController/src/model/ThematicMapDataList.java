package model;

import java.util.ArrayList;
import java.util.List;


public class ThematicMapDataList {
    
    private static List<ThematicMapData> s_thematicMapDataList = null;
    
    public ThematicMapDataList() {
        super();
        
        if (s_thematicMapDataList == null) {
            s_thematicMapDataList = new ArrayList<ThematicMapData>();
            
            s_thematicMapDataList.add(new ThematicMapData(29, "AS", "#64C8C8", "Category 1", "Color 1", "Shape 1"));
            s_thematicMapDataList.add(new ThematicMapData(53, "SA", "#C864C8", "Category 2", "Color 2", "Shape 2"));
            s_thematicMapDataList.add(new ThematicMapData(19, "NA", "#C8C864", "Category 3", "Color 3", "Shape 3"));
            s_thematicMapDataList.add(new ThematicMapData(77, "AF", "#C864C8", "Category 4", "Color 2", "Shape 4"));
            s_thematicMapDataList.add(new ThematicMapData(95, "EU", "#64C8C8", "Category 5", "Color 1", "Shape 5"));
            s_thematicMapDataList.add(new ThematicMapData(75, "AN", "#64C8C8", "Category 6", "Color 3", "Shape 6"));
            s_thematicMapDataList.add(new ThematicMapData(43, "AU", "#64C864", "Category 7", "Color 1", "Shape 7"));
        }        
    }    
    
    public List<ThematicMapData> getThematicMapData() {
        return s_thematicMapDataList;
    }
    
    public int getThematicMapDataCount() {
        return s_thematicMapDataList.size();
    }
}