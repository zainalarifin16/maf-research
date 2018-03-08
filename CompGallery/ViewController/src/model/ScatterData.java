package model;

public class ScatterData {
    private String group;
    private String series;
    private double x;
    private double y;

    public ScatterData() {
        super();
    }
    
    public ScatterData(String group, String series, double x, double y) {
        this.group = group;
        this.series = series;
        this.x = x;
        this.y = y;
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

}
