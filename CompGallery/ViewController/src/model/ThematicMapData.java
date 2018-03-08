package model;

public class ThematicMapData {
    
    private double value;
    private String name;
    private String color;
    private String cat1;
    private String cat2;
    private String cat3;
    
    public ThematicMapData(double value, String name, String color,
            String cat1, String cat2, String cat3) {
        this.value = value;
        this.name = name;
        this.color = color;
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }
    
}