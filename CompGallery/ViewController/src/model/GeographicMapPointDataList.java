package model;

import java.util.ArrayList;
import java.util.List;


public class GeographicMapPointDataList {
    
    private static List<GeographicMapPointData> s_geographicMapPointDataList = null;
    
    public GeographicMapPointDataList() {
        
        if (s_geographicMapPointDataList == null) {
            s_geographicMapPointDataList = new ArrayList<GeographicMapPointData>();
            
            s_geographicMapPointDataList.add(new GeographicMapPointData(-71.5, 42.21, "pointXY", "Boston"));
            s_geographicMapPointDataList.add(new GeographicMapPointData(-87.37, 41.5, "pointXY", "Chicago"));
            s_geographicMapPointDataList.add(new GeographicMapPointData(-122.26, 37.47, "pointXY", "San Francisco"));
            s_geographicMapPointDataList.add(new GeographicMapPointData(-95.21, 29.45, "pointXY", "Houston"));
        }        
    }    
    
    public List<GeographicMapPointData> getGeographicMapPointData() {
        return s_geographicMapPointDataList;
    }
    
    public int getGeographicMapPointDataCount() {
        return s_geographicMapPointDataList.size();
    }
}