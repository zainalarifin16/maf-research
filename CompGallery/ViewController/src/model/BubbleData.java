package model;

public class BubbleData {
    private String group;
    private String series;
    private double x;
    private double y;
    private double z;


    public BubbleData() {
        super();
    }
    
    public BubbleData(String group, String series, double x, double y, double z) {
        this.group = group;
        this.series = series;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
}
