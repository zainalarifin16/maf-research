package model;

public class ThematicMapCustomMarkerDataList {
    
    public static final String AFRICA = "Africa";
    public static final String NAMERICA = "North America";
    public static final String SAMERICA = "South America";
    public static final String ASIA = "Asia";
    public static final String EUROPE = "Europe";
    
    private Region[] regions = null;
    
    public ThematicMapCustomMarkerDataList() {
        super();
    }
    
    public Region[] getRegions() {
        if (regions == null)
        {
            regions = new Region[5];
            regions[0] = new Region("NA", NAMERICA);
            regions[0].setTrendColor("#84C632");
            regions[0].setTrendValue(30);
            regions[0].setTrendShape("triangleUp");
            regions[0].setRegionColor("#CDCC73");
            regions[0].setBestSeller("footBall");
            
            regions[1] = new Region("SA",SAMERICA);
            regions[1].setTrendColor("#84C632");
            regions[1].setTrendValue(20);
            regions[1].setTrendShape("triangleUp");
            regions[1].setRegionColor("#DDDCA0");
            regions[1].setBestSeller("soccerball");

            regions[2] = new Region("AF",AFRICA);
            regions[2].setTrendColor("#D65845");
            regions[2].setTrendValue(15);
            regions[2].setTrendShape("triangleDown");
            regions[2].setRegionColor("#D7CC90");
            regions[2].setBestSeller("soccerball");
            
            regions[3] = new Region("AS", ASIA);
            regions[3].setTrendColor("#CFA607");
            regions[3].setTrendValue(15);
            regions[3].setTrendShape("triangleUp");
            regions[3].setRegionColor("#E6E1BA");
            regions[3].setBestSeller("bicycleSmall");

            regions[4] = new Region("EU", EUROPE);
            regions[4].setTrendColor("#84C632");
            regions[4].setTrendValue(20);
            regions[4].setTrendShape("triangleUp");
            regions[4].setRegionColor("#D2D893");
            regions[4].setBestSeller("skiBoot");
        }
        
        return regions;
    }
    
}
