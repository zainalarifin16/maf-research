package model;

public class Region {
    private String id;
    private String regionName;
    private int trendValue;
    private String trendColor;
    private String trendShape;
    private String regionColor;
    private String bestSeller;
    
    public Region() {
    }
    
    public Region(String id, String regionName) {
        this.id = id;
        this.regionName = regionName;
    }

    public String getId() {
        return id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setTrendValue(int trendValue) {
        this.trendValue = trendValue;
    }

    public int getTrendValue() {
        return trendValue;
    }

    public void setTrendColor(String trendColor) {
        this.trendColor = trendColor;
    }

    public String getTrendColor() {
        return trendColor;
    }

    public void setTrendShape(String trendShape) {
        this.trendShape = trendShape;
    }

    public String getTrendShape() {
        return trendShape;
    }

    public void setRegionColor(String regionColor) {
        this.regionColor = regionColor;
    }

    public String getRegionColor() {
        return regionColor;
    }

    public void setBestSeller(String bestSeller) {
        this.bestSeller = bestSeller;
    }

    public String getBestSeller() {
        return bestSeller;
    }
}
