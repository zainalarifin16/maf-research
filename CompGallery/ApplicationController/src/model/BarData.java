package model;

public class BarData {
    private String group;
    private String series;
    private double value;

    public BarData() {
        super();
    }
    
    public BarData(String group, String series, double value) {
        this.group = group;
        this.series = series;
        this.value = value;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}
