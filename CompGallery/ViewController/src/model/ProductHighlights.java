package model;

public class ProductHighlights {

    private String pointName;
    private String tooltip;
    private int value;
    private String description;
    private String _partNum;
    private float _price;

    public ProductHighlights(String pointName, String tooltip, int value, String description, String partNum,
                             float price) {
        this.pointName = pointName;
        this.tooltip = tooltip;
        this.value = value;
        this.description = description;
        _partNum = partNum;
        _price = price;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointName() {
        return pointName;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPartNum(String _partNum) {
        this._partNum = _partNum;
    }

    public String getPartNum() {
        return _partNum;
    }

    public void setPrice(float _price) {
        this._price = _price;
    }

    public float getPrice() {
        return _price;
    }
}
