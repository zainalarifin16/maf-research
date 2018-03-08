package model;

import java.util.ArrayList;
import java.util.List;


public class ThematicMapZoomCitiesDataList {
    
    private static List<ThematicMapZoomCitiesData> s_thematicMapZoomCitiesDataList = null;
    
    public ThematicMapZoomCitiesDataList() {
        
        if (s_thematicMapZoomCitiesDataList == null) {
            s_thematicMapZoomCitiesDataList = new ArrayList<ThematicMapZoomCitiesData>();
            
            s_thematicMapZoomCitiesDataList.add(new ThematicMapZoomCitiesData("ME_AUGUSTA", "Category 6"));
            s_thematicMapZoomCitiesDataList.add(new ThematicMapZoomCitiesData("NY_NEW_YORK", "Category 6"));
            s_thematicMapZoomCitiesDataList.add(new ThematicMapZoomCitiesData("PA_HARRISBURG", "Category 6"));
            
        }        
    }    
    
    public List<ThematicMapZoomCitiesData> getThematicMapZoomCitiesData() {
        return s_thematicMapZoomCitiesDataList;
    }
    
    public int getThematicMapZoomCitiesDataCount() {
        return s_thematicMapZoomCitiesDataList.size();
    }
}