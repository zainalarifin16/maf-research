package model;

public class ThematicMapWorldCitiesData {

    private String name;
    private String shortDesc;
    private double value;


    public ThematicMapWorldCitiesData(String name,String shortDesc,double value) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String val) {
        this.name = val;
    }

    public String getShortDesc() {
        return this.shortDesc;
    }

    public void setShortDesc(String val) {
        this.shortDesc = val;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double val) {
        this.value = val;
    }

}