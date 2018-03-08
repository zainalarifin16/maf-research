package model;

public class GeographicMapPointData {
    
    private double pointX;
    private double pointY;
    private String type;
    private String shortDesc;
    
    public GeographicMapPointData(){}
    
    public GeographicMapPointData(double pointX, double pointY, String type,
            String shortDesc) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.type = type;
        this.shortDesc = shortDesc;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
    
}