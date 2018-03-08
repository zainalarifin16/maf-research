package mobile;

public class DialGaugeProperties {
    
    private String value = "65";
    private String minValue = "0";
    private String maxValue = "100";
    
    private String background = "circleAntique";
    private String indicator = "needleAntique";
    
    private String animationDuration = "1000";
    private String animationOnDataChange = "auto";
    private String animationOnDisplay = "auto";
    
    private String shortDesc = "";
    
    private String inlineStyle = "width:100%; height:#{deviceScope.hardware.screen.availableHeight-44}px; background-color: white;";
    private String styleClass = "";
    
    private String readOnly = "true";
    
    private String tickScaling = "none";
    private String metricScaling = "none";
    
    private String tickLabelStyle = "";
    private String metricLabelStyle = "";
    private String metricLabelText = "";
    private boolean metricLabelRendered = true;
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
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
    
    public String getBackground() {
        return background;
    }
    
    public void setBackground(String background) {
        this.background = background;
    }
    
    public String getIndicator() {
        return indicator;
    }
    
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
    
    public String getAnimationDuration() {
        return animationDuration;
    }
    
    public void setAnimationDuration(String animationDuration) {
        this.animationDuration = animationDuration;
    }
    
    public String getAnimationOnDataChange() {
        return animationOnDataChange;
    }
    
    public void setAnimationOnDataChange(String animationOnDataChange) {
        this.animationOnDataChange = animationOnDataChange;
    }
    
    public String getAnimationOnDisplay() {
        return animationOnDisplay;
    }
    
    public void setAnimationOnDisplay(String animationOnDisplay) {
        this.animationOnDisplay = animationOnDisplay;
    }
    
    public String getShortDesc() {
        return shortDesc;
    }
    
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
    
    public String getInlineStyle() {
        return inlineStyle;
    }
    
    public void setInlineStyle(String inlineStyle) {
        this.inlineStyle = inlineStyle;
    }
    
    public String getStyleClass() {
        return styleClass;
    }
    
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }
    
    public String getReadOnly() {
        return readOnly;
    }
    
    public void setReadOnly(String readOnly) {
        this.readOnly = readOnly;
    }

    public void setTickScaling(String tickScaling) {
        this.tickScaling = tickScaling;
    }

    public String getTickScaling() {
        return tickScaling;
    }

    public void setMetricScaling(String metricScaling) {
        this.metricScaling = metricScaling;
    }

    public String getMetricScaling() {
        return metricScaling;
    }

    public void setTickLabelStyle(String tickLabelStyle) {
        this.tickLabelStyle = tickLabelStyle;
    }

    public String getTickLabelStyle() {
        return tickLabelStyle;
    }

    public void setMetricLabelStyle(String metricLabelStyle) {
        this.metricLabelStyle = metricLabelStyle;
    }

    public String getMetricLabelStyle() {
        return metricLabelStyle;
    }

    public void setMetricLabelText(String metricLabelText)
    {
      this.metricLabelText = metricLabelText;
    }
  
    public String getMetricLabelText()
    {
      return metricLabelText;
    }
  
    public void setMetricLabelRendered(boolean metricLabelRendered)
    {
      this.metricLabelRendered = metricLabelRendered;
    }
  
    public boolean isMetricLabelRendered()
    {
      return metricLabelRendered;
    }
}
