package model;

public class HierarchicalChartGroupData {
    private String group;
    private String subGroup;
    private String series;
    private double value;

    public HierarchicalChartGroupData() {
        super();
    }

    public HierarchicalChartGroupData(String group, String subGroup, String series, double value) {
        this.group = group;
        this.series = series;
        this.value = value;
        this.subGroup = subGroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public String getSubGroup() {
        return subGroup;
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
