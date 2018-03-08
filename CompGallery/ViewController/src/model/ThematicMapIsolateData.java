package model;

public class ThematicMapIsolateData {
    
    private double value;
    private String name;
    private String color;
    
    public ThematicMapIsolateData(double value, String name, String color) {
        this.value = value;
        this.name = name;
        this.color = color;
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
    
}