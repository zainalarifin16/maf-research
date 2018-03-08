package mobile;

public class GaugeProperties {

    private String animationDuration = "1000";
    private String animationOnDisplay = "auto";
    private String animationOnDataChange = "none";
    private String borderColor = "#000000";
    private String borderRadius = "";
    private String color = "#267db3";
    private String inlineStyle = "";
    private String labelDisplay = "off";
    private String minValue = "0";
    private String maxValue = "100";
    private String type = "circle";
    private String value = "65";
    private String visualEffects = "auto";
    private String title = "Title";
    private String titleStyle = "font-weight: bold";
    private String titlePosition = "auto";
    private String metricLabelPosition = "auto";
    private String metricLabelText = "";
    
    private String threshold1color = "#68c182";
    private String threshold1maxValue = "40";
    private String threshold1text = "Low";

    private String threshold2color = "#fad55c";
    private String threshold2maxValue = "70";
    private String threshold2text = "Medium";

    private String threshold3color = "#ed6647";
    private String threshold3maxValue = "100";
    private String threshold3text = "High";
    
    private String indicatorSize = "0.6";
    private String innerRadius = "0.7";
    private String startAngle = "90";
    private String angleExtent = "360";
    private String plotArea = "auto";
    private String plotAreaColor = "";
    private String plotAreaBorderColor = "";
    private String plotAreaBorderRadius = "";
    private String thresholdDisplay = "all";
    
    private String referenceLineColor = color;
    private String referenceLineValue = "65";
    
    private String readOnly = "true";
    private String shortDesc;
    
    private String metricLabelStyle = "";

    public GaugeProperties() {
    }

    public String getAnimationDuration() {
        return animationDuration;
    }

    public void setAnimationDuration(String animationDuration) {
        this.animationDuration = animationDuration;
    }

    public String getAnimationOnDisplay() {
        return animationOnDisplay;
    }

    public void setAnimationOnDisplay(String animationOnDisplay) {
        this.animationOnDisplay = animationOnDisplay;
    }

    public String getAnimationOnDataChange() {
        return animationOnDataChange;
    }

    public void setAnimationOnDataChange(String animationOnDataChange) {
        this.animationOnDataChange = animationOnDataChange;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(String borderRadius) {
        this.borderRadius = borderRadius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInlineStyle() {
        return inlineStyle;
    }

    public void setInlineStyle(String inlineStyle) {
        this.inlineStyle = inlineStyle;
    }

    public String getLabelDisplay() {
        return labelDisplay;
    }

    public void setLabelDisplay(String labelDisplay) {
        this.labelDisplay = labelDisplay;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVisualEffects() {
        return visualEffects;
    }

    public void setVisualEffects(String visualEffects) {
        this.visualEffects = visualEffects;
    }

    public String getTitle () {
        return title;
    }
    
    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitleStyle () {
        return titleStyle;
    }
    
    public void setTitleStyle (String titleStyle) {
        this.titleStyle = titleStyle;
    }

    public String getTitlePosition () {
        return titlePosition;
    }
    
    public void setTitlePosition (String titlePosition) {
        this.titlePosition = titlePosition;
    }

    public String getMetricLabelPosition () {
        return metricLabelPosition;
    }
    
    public void setMetricLabelPosition (String metricLabelPosition) {
        this.metricLabelPosition = metricLabelPosition;
    }

    public String getMetricLabelText () {
        return metricLabelText;
    }
    
    public void setMetricLabelText (String metricLabelText) {
        this.metricLabelText = metricLabelText;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThreshold1color() {
        return threshold1color;
    }

    public void setThreshold1color(String threshold1color) {
        this.threshold1color = threshold1color;
    }

    public String getThreshold1maxValue() {
        return threshold1maxValue;
    }

    public void setThreshold1maxValue(String threshold1maxValue) {
        this.threshold1maxValue = threshold1maxValue;
    }

    public String getThreshold1text() {
        return threshold1text;
    }

    public void setThreshold1text(String threshold1text) {
        this.threshold1text = threshold1text;
    }

    public String getThreshold2color() {
        return threshold2color;
    }

    public void setThreshold2color(String threshold2color) {
        this.threshold2color = threshold2color;
    }

    public String getThreshold2maxValue() {
        return threshold2maxValue;
    }

    public void setThreshold2maxValue(String threshold2maxValue) {
        this.threshold2maxValue = threshold2maxValue;
    }

    public String getThreshold2text() {
        return threshold2text;
    }

    public void setThreshold2text(String threshold2text) {
        this.threshold2text = threshold2text;
    }

    public String getThreshold3color() {
        return threshold3color;
    }

    public void setThreshold3color(String threshold3color) {
        this.threshold3color = threshold3color;
    }

    public String getThreshold3maxValue() {
        return threshold3maxValue;
    }

    public void setThreshold3maxValue(String threshold3maxValue) {
        this.threshold3maxValue = threshold3maxValue;
    }

    public String getThreshold3text() {
        return threshold3text;
    }

    public void setThreshold3text(String threshold3text) {
        this.threshold3text = threshold3text;
    }

    public void setIndicatorSize(String indicatorSize) {
        this.indicatorSize = indicatorSize;
    }

    public String getIndicatorSize() {
        return indicatorSize;
    }

    public void setInnerRadius(String innerRadius) {
        this.innerRadius = innerRadius;
    }

    public String getInnerRadius() {
        return innerRadius;
    }

    public void setStartAngle(String startAngle) {
        this.startAngle = startAngle;
    }

    public String getStartAngle() {
        return startAngle;
    }

    public void setAngleExtent(String angleExtent) {
        this.angleExtent = angleExtent;
    }

    public String getAngleExtent() {
        return angleExtent;
    }

    public void setPlotArea(String plotArea) {
        this.plotArea = plotArea;
    }

    public String getPlotArea() {
        return plotArea;
    }

    public void setPlotAreaColor(String plotAreaColor) {
        this.plotAreaColor = plotAreaColor;
    }

    public String getPlotAreaColor() {
        return plotAreaColor;
    }

    public void setPlotAreaBorderColor(String plotAreaBorderColor) {
        this.plotAreaBorderColor = plotAreaBorderColor;
    }

    public String getPlotAreaBorderColor() {
        return plotAreaBorderColor;
    }

    public void setPlotAreaBorderRadius(String plotAreaBorderRadius) {
        this.plotAreaBorderRadius = plotAreaBorderRadius;
    }

    public String getPlotAreaBorderRadius() {
        return plotAreaBorderRadius;
    }

    public void setThresholdDisplay(String thresholdDisplay) {
        this.thresholdDisplay = thresholdDisplay;
    }

    public String getThresholdDisplay() {
        return thresholdDisplay;
    }

    public void setReferenceLineColor(String referenceLineColor) {
        this.referenceLineColor = referenceLineColor;
    }

    public String getReferenceLineColor() {
        return referenceLineColor;
    }

    public void setReferenceLineValue(String referenceLineValue) {
        this.referenceLineValue = referenceLineValue;
    }

    public String getReferenceLineValue() {
        return referenceLineValue;
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
    
    public void setMetricLabelStyle(String metricLabelStyle) {
        this.metricLabelStyle = metricLabelStyle;
    }

    public String getMetricLabelStyle() {
        return metricLabelStyle;
    }
    
}
