package model;

public class ThematicMapZoomCitiesData {
    
    private String name;
    private String cat1;
    
    public ThematicMapZoomCitiesData(){}
    
    public ThematicMapZoomCitiesData(String name, String cat1) {
        super();
        this.name = name;
        this.cat1 = cat1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }
    
    
}