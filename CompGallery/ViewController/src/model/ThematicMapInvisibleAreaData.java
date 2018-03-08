package model;

import java.util.ArrayList;
import java.util.List;

public class ThematicMapInvisibleAreaData {
    private String id;
    private double sqrtGDP;
    private String formattedGDP;
    private String countryName;
    private int value;
    private String color;

    public ThematicMapInvisibleAreaData(String name, double sqrtGDP, String formattedGDP, String countryName, int value, String color) {
      this.id = name;
      this.sqrtGDP = sqrtGDP;
      this.formattedGDP = formattedGDP;
      this.countryName = countryName;
      this.value = value;
      this.color = color;
    }

    public String getId() {
      return id;
    }

    public void setId(String name) {
      this.id = name;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public void setSqrtGDP(double sqrtGDP) {
        this.sqrtGDP = sqrtGDP;
    }

    public double getSqrtGDP() {
        return sqrtGDP;
    }

    public void setFormattedGDP(String formattedGDP) {
        this.formattedGDP = formattedGDP;
    }

    public String getFormattedGDP() {
        return formattedGDP;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }
}
