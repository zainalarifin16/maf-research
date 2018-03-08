package model;

import java.util.ArrayList;
import java.util.List;


public class GeographicMapAddressDataList {
    
    private static List<GeographicMapAddressData> s_geographicMapAddressDataList = null;
    
    public GeographicMapAddressDataList() {
        
        if (s_geographicMapAddressDataList == null) {
            s_geographicMapAddressDataList = new ArrayList<GeographicMapAddressData>();
            
            s_geographicMapAddressDataList.add(new GeographicMapAddressData("10 van de graaff drive, burlington, ma", "address", "Boston"));
            s_geographicMapAddressDataList.add(new GeographicMapAddressData("new york, NY", "address", "New York"));
            s_geographicMapAddressDataList.add(new GeographicMapAddressData("Philadephia, PA", "address", "Philadephia"));
            s_geographicMapAddressDataList.add(new GeographicMapAddressData("Los Angeles, CA", "address", "Los Angeles"));
        }        
    }    
    
    public List<GeographicMapAddressData> getGeographicMapAddressData() {
        return s_geographicMapAddressDataList;
    }
    
    public int getGeographicMapAddressDataCount() {
        return s_geographicMapAddressDataList.size();
    }
}