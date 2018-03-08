package model;

public class ThematicMapZoomData {
    
    private String name;
    private String color;
    private String cat1;
    
    public ThematicMapZoomData(String name, String color,
            String cat1) {
        this.name = name;
        this.color = color;
        this.cat1 = cat1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

}