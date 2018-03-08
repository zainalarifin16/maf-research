package model;

public class TreeviewData {

    private int id;
    private int value;
    private String fillColor;
    private String cat;
    private String cat2;
    private String label;
    private float marketShare;
    private float deltaInPosition;
    private float booksCount;

    public TreeviewData(int id,int value,String fillColor,String cat,String cat2,String label, float marketShare, float deltaInPosition, float booksCount) {
        this.id = id;
        this.value = value;
        this.fillColor = fillColor;
        this.cat = cat;
        this.cat2 = cat2;
        this.label = label;
        this.marketShare = marketShare;
        this.deltaInPosition = deltaInPosition;
        this.booksCount = booksCount;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int val) {
        this.id = val;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int val) {
        this.value = val;
    }

    public String getFillColor() {
        return this.fillColor;
    }

    public void setFillColor(String val) {
        this.fillColor = val;
    }

    public String getCat() {
        return this.cat;
    }

    public void setCat(String val) {
        this.cat = val;
    }

    public String getCat2() {
        return this.cat2;
    }

    public void setCat2(String val) {
        this.cat2 = val;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String val) {
        this.label = val;
    }

    public String toString() {
        return this.label;
    }

    public void setMarketShare(float marketShare) {
        this.marketShare = marketShare;
    }

    public float getMarketShare() {
        return marketShare;
    }

    public void setDeltaInPosition(float deltaInPosition) {
        this.deltaInPosition = deltaInPosition;
    }

    public float getDeltaInPosition() {
        return deltaInPosition;
    }

    public void setBooksCount(float booksCount) {
        this.booksCount = booksCount;
    }

    public float getBooksCount() {
        return booksCount;
    }
}
