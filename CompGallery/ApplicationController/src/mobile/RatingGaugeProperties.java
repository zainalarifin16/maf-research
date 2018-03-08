package mobile;

public class RatingGaugeProperties {
    private String value;
    private String minValue;
    private String maxValue;
    
    private String readOnly;
    private String shortDesc;
    
    private String shape;
    private String orientation = "horizontal";
    private String unselectedShape = "auto";
    private String changedShape = "auto";
    
    private String inputIncrement;
    
    private String inlineStyle;
    private String inlineStyleVertical;


    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    public String getReadOnly() {
        return readOnly;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setUnselectedShape(String unselectedShape) {
        this.unselectedShape = unselectedShape;
    }

    public String getUnselectedShape() {
        return unselectedShape;
    }

    public void setChangedShape(String changedShape) {
        this.changedShape = changedShape;
    }

    public String getChangedShape() {
        return changedShape;
    }

    public void setInputIncrement(String inputIncrement) {
        this.inputIncrement = inputIncrement;
    }

    public String getInputIncrement() {
        return inputIncrement;
    }

    public void setInlineStyle(String inlineStyle) {
        this.inlineStyle = inlineStyle;
    }

    public String getInlineStyle() {
        return inlineStyle;
    }

    public void setInlineStyleVertical(String inlineStyleVertical) {
        this.inlineStyleVertical = inlineStyleVertical;
    }

    public String getInlineStyleVertical() {
        return inlineStyleVertical;
    }
}
