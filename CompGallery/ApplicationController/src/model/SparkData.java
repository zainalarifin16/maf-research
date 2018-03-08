package model;

public class SparkData {
    private double date;
    private double value;
    private boolean markerDisplayed;
    private String color;
    private double floatValue;
    private static double FLOAT_LEVEL = 15.0;

    public SparkData() {
        super();
    }
    
    public SparkData(double date, double value, boolean markerDisplayed, String color) {
        this.date = date;
        this.value = value;
        this.markerDisplayed = markerDisplayed;
        this.color = color;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isMarkerDisplayed() {
        return markerDisplayed;
    }

    public void setMarkerDisplayed(boolean markerDisplayed) {
        this.markerDisplayed = markerDisplayed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getFloatValue() {
        return value - FLOAT_LEVEL;
    }


}
