package model;

public class LineData2 {
    private String group;
    private String series;
    private double value;
    private String shape;
    private String color;
    private String lineColor;
    private int lineWidth;
    private String lineStyle;

    public LineData2() {
        super();
    }
    
    public LineData2(String group, String series, double value,
                     String shape, String color, String lineColor,
                     int lineWidth, String lineStyle) {
        this.group = group;
        this.series = series;
        this.value = value;
        this.shape = shape;
        this.color = color;
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
        this.lineStyle = lineStyle;
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

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLineColor() {
        return lineColor;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public String getLineStyle() {
        return lineStyle;
    }

    public void setLineStyle(String lineStyle) {
        this.lineStyle = lineStyle;
    }
}
