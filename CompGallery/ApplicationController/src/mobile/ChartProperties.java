package mobile;

public class ChartProperties {
    
    private String color;
    private String dataCursor;
    private String dataCursorBehavior;
    private String dataSelection;
    private String footnote;
    private String footnoteHalign;
    private String hideAndShowBehavior;
    private String inlineStyle;
    private String rolloverBehavior;
    private String rolloverBehaviorDelay;
    private String scaleX;
    private String scaleY;
    private boolean stack;
    private String stackLabel;
    private String stackLabelStyle;
    private String subtitle;
    private boolean threeDEffect = false;
    private String title;
    private String titleHalign;
    private String type;
    private String animationOnDataChange;
    private String animationIndicators;
    private String animationDuration;
    private String animationOnDisplay;
    private String animationUpColor;
    private String animationDownColor;
    private String shortDesc;
    private String seriesEffect;
    private boolean legendDisplay;
    private String legendPosition;
    private boolean labelDisplay;
    private String labelPosition;
    private boolean xAxisDisplay;
    private boolean yAxisDisplay;
    private String highColor;
    private String lowColor;
    private String firstColor;
    private String lastColor;
    private String splitDualY;

    private String risingColor;
    private String failingColor;
    private String rangeColor;
    private String volumeColor;
    
    private String zoomDirection;
    private String zoomAndScroll;
    
    private boolean sColor = false;
    private boolean sDataCursor = false;
    private boolean sDataCursorBehavior = false;
    private boolean sDataSelection = false;
    private boolean sFootnote = true;
    private boolean sHideAndShowBehavior = false;
    private boolean sRolloverBehavior = false;
    private boolean sScaleX = false;
    private boolean sScaleY = false;
    private boolean sStack = false;
    private boolean sStackLabel = false;
    private boolean sSubtitle = true;
    private boolean sThreeDEffect = false;
    private boolean sTitle = true;
    private boolean sType = false;
    private boolean sAnimationOnDataChange = true;
    private boolean sAnimationIndicators = true;
    private boolean sAnimationDuration = true;
    private boolean sAnimationOnDisplay = true;
    private boolean sAnimationUpColor = true;
    private boolean sAnimationDownColor = true;
    private boolean sSeriesEffect = true;
    private boolean sZoomDirection = false;
    private boolean sZoomAndScroll = false;
    
    public ChartProperties() {
        this.color = "#267db3";
        this.dataCursor = "auto";
        this.dataCursorBehavior = "auto";
        this.dataSelection = "none";
        this.footnote = "This is a footnote";
        this.footnoteHalign = "start";
        this.hideAndShowBehavior = "none";
        this.inlineStyle = "width:100%; height:#{deviceScope.hardware.screen.availableHeight-44}px; background-color: white;";
        this.rolloverBehavior = "none";
        this.rolloverBehaviorDelay = "";
        this.scaleX = "linear";
        this.scaleY = "linear";
        this.stack = false;
        this.stackLabel = "off";
        this.stackLabelStyle = "";
        this.subtitle = "Subtitle";
        this.threeDEffect = false;
        this.title = "Chart Title";
        this.titleHalign = "start";
        this.type = "line";
        this.animationDuration = "1000";
        this.animationOnDataChange = "auto";
        this.animationIndicators = "none";
        this.animationOnDisplay = "none";
        this.seriesEffect = "color";
        this.legendDisplay = true;
        this.legendPosition = "end";
        this.labelDisplay = false;
        this.labelPosition = "auto";
        this.xAxisDisplay = true;
        this.yAxisDisplay = true;
        this.highColor = "#f10e1f";
        this.lowColor = "#1aef1b";
    }

    public String getDataCursor() {
        return dataCursor;
    }

    public void setDataCursor(String dataCursor) {
        this.dataCursor = dataCursor;
    }

    public String getDataCursorBehavior() {
        return dataCursorBehavior;
    }

    public void setDataCursorBehavior(String dataCursorBehavior) {
        this.dataCursorBehavior = dataCursorBehavior;
    }

    public String getDataSelection() {
        return dataSelection;
    }

    public void setDataSelection(String dataSelection) {
        this.dataSelection = dataSelection;
    }

    public String getFootnote() {
        return footnote;
    }

    public void setFootnote(String footnote) {
        this.footnote = footnote;
    }

    public String getFootnoteHalign() {
        return footnoteHalign;
    }

    public void setFootnoteHalign(String footnoteHalign) {
        this.footnoteHalign = footnoteHalign;
    }

    public String getHideAndShowBehavior() {
        return hideAndShowBehavior;
    }

    public void setHideAndShowBehavior(String hideAndShowBehavior) {
        this.hideAndShowBehavior = hideAndShowBehavior;
    }

    public String getRolloverBehavior() {
        return rolloverBehavior;
    }

    public void setRolloverBehavior(String rolloverBehavior) {
        this.rolloverBehavior = rolloverBehavior;
    }

    public String getRolloverBehaviorDelay() {
        return rolloverBehaviorDelay;
    }

    public void setRolloverBehaviorDelay(String rolloverBehaviorDelay) {
        this.rolloverBehaviorDelay = rolloverBehaviorDelay;
    }

    public String getScaleX() {
        return scaleX;
    }

    public void setScaleX(String scaleX) {
        this.scaleX = scaleX;
    }

    public String getScaleY() {
        return scaleY;
    }

    public void setScaleY(String scaleY) {
        this.scaleY = scaleY;
    }

    public boolean isStack() {
        return stack;
    }

    public void setStack(boolean stack) {
        this.stack = stack;
    }

    public String getStackLabel() {
        return stackLabel;
    }

    public void setStackLabel(String stackLabel) {
        this.stackLabel = stackLabel;
    }

    public String getStackLabelStyle() {
        return stackLabelStyle;
    }

    public void setStackLabelStyle(String stackLabelStyle) {
        this.stackLabelStyle = stackLabelStyle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean getThreeDEffect() {
        return threeDEffect;
    }

    public void setThreeDEffect(boolean threeDEffect) {
        this.threeDEffect = threeDEffect;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleHalign() {
        return titleHalign;
    }

    public void setTitleHalign(String titleHalign) {
        this.titleHalign = titleHalign;
    }

    public boolean isSDataSelection() {
        return sDataSelection;
    }

    public void setSDataSelection(boolean sDataSelection) {
        this.sDataSelection = sDataSelection;
    }

    public boolean isSHideAndShowBehavior() {
        return sHideAndShowBehavior;
    }

    public void setSHideAndShowBehavior(boolean sHideAndShowBehavior) {
        this.sHideAndShowBehavior = sHideAndShowBehavior;
    }

    public boolean isSRolloverBehavior() {
        return sRolloverBehavior;
    }

    public void setSRolloverBehavior(boolean sRolloverBehavior) {
        this.sRolloverBehavior = sRolloverBehavior;
    }

    public boolean isSScaleX() {
        return sScaleX;
    }

    public void setSScaleX(boolean sScaleX) {
        this.sScaleX = sScaleX;
    }

    public boolean isSScaleY() {
        return sScaleY;
    }

    public void setSScaleY(boolean sScaleY) {
        this.sScaleY = sScaleY;
    }

    public boolean isSStack() {
        return sStack;
    }

    public void setSStack(boolean sStack) {
        this.sStack = sStack;
    }

    public boolean isSStackLabel() {
        return sStackLabel;
    }

    public void setSStackLabel(boolean sStackLabel) {
        this.sStackLabel = sStackLabel;
    }

    public boolean isSThreeDEffect() {
        return sThreeDEffect;
    }

    public void setSThreeDEffect(boolean sThreeDEffect) {
        this.sThreeDEffect = sThreeDEffect;
    }

    public boolean isSSeriesEffect() {
        return sSeriesEffect;
    }

    public void setSSeriesEffect(boolean sSeriesEffect) {
        this.sSeriesEffect = sSeriesEffect;
    }

    public boolean isSZoomDirection() {
        return sZoomDirection;
    }

    public void setSZoomDirection(boolean sZoomDirection) {
        this.sZoomDirection = sZoomDirection;
    }

    public boolean isSZoomAndScroll() {
        return sZoomAndScroll;
    }

    public void setSZoomAndScroll(boolean sZoomAndScroll) {
        this.sZoomAndScroll = sZoomAndScroll;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSColor() {
        return sColor;
    }

    public void setSColor(boolean sColor) {
        this.sColor = sColor;
    }

    public boolean isSDataCursor() {
        return sDataCursor;
    }

    public void setSDataCursor(boolean sDataCursor) {
        this.sDataCursor = sDataCursor;
    }

    public boolean isSDataCursorBehavior() {
        return sDataCursorBehavior;
    }

    public void setSDataCursorBehavior(boolean sDataCursorBehavior) {
        this.sDataCursorBehavior = sDataCursorBehavior;
    }

    public boolean isSFootnote() {
        return sFootnote;
    }

    public void setSFootnote(boolean sFootnote) {
        this.sFootnote = sFootnote;
    }

    public boolean isSSubtitle() {
        return sSubtitle;
    }

    public void setSSubtitle(boolean sSubtitle) {
        this.sSubtitle = sSubtitle;
    }

    public boolean isSTitle() {
        return sTitle;
    }

    public void setSTitle(boolean sTitle) {
        this.sTitle = sTitle;
    }

    public boolean isSType() {
        return sType;
    }

    public void setSType(boolean sType) {
        this.sType = sType;
    }

    public void setAnimationOnDataChange(String animationOnDataChange) {
        this.animationOnDataChange = animationOnDataChange;
    }

    public String getAnimationOnDataChange() {
        return animationOnDataChange;
    }

    public void setAnimationIndicators(String animationIndicators) {
        this.animationIndicators = animationIndicators;
    }

    public String getAnimationIndicators() {
        return animationIndicators;
    }

    public void setAnimationDuration(String animationDuration) {
        this.animationDuration = animationDuration;
    }

    public String getAnimationDuration() {
        return animationDuration;
    }

    public void setAnimationOnDisplay(String animationOnDisplay) {
        this.animationOnDisplay = animationOnDisplay;
    }

    public String getAnimationOnDisplay() {
        return animationOnDisplay;
    }

    public void setAnimationUpColor(String animationUpColor) {
        this.animationUpColor = animationUpColor;
    }

    public String getAnimationUpColor() {
        return animationUpColor;
    }

    public void setAnimationDownColor(String animationDownColor) {
        this.animationDownColor = animationDownColor;
    }

    public String getAnimationDownColor() {
        return animationDownColor;
    }

    public void setSAnimationOnDataChange(boolean sAnimationOnDataChange) {
        this.sAnimationOnDataChange = sAnimationOnDataChange;
    }

    public boolean isSAnimationOnDataChange() {
        return sAnimationOnDataChange;
    }

    public void setSAnimationIndicators(boolean sAnimationIndicators) {
        this.sAnimationIndicators = sAnimationIndicators;
    }

    public boolean isSAnimationIndicators() {
        return sAnimationIndicators;
    }

    public void setSAnimationDuration(boolean sAnimationDuration) {
        this.sAnimationDuration = sAnimationDuration;
    }

    public boolean isSAnimationDuration() {
        return sAnimationDuration;
    }

    public void setSAnimationOnDisplay(boolean sAnimationOnDisplay) {
        this.sAnimationOnDisplay = sAnimationOnDisplay;
    }

    public boolean isSAnimationOnDisplay() {
        return sAnimationOnDisplay;
    }

    public void setSAnimationUpColor(boolean sAnimationUpColor) {
        this.sAnimationUpColor = sAnimationUpColor;
    }

    public boolean isSAnimationUpColor() {
        return sAnimationUpColor;
    }

    public void setSAnimationDownColor(boolean sAnimationDownColor) {
        this.sAnimationDownColor = sAnimationDownColor;
    }

    public boolean isSAnimationDownColor() {
        return sAnimationDownColor;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getSeriesEffect() {
        return seriesEffect;
    }

    public void setSeriesEffect(String seriesEffect) {
        this.seriesEffect = seriesEffect;
    }
 
    public void setLegendDisplay(boolean legendDisplay) {
        this.legendDisplay = legendDisplay;
    }

    public boolean isLegendDisplay() {
        return legendDisplay;
    }

    public void setLegendPosition(String legendPosition) {
        this.legendPosition = legendPosition;
    }

    public String getLegendPosition() {
        return legendPosition;
    }

    public void setLabelDisplay(boolean labelDisplay) {
        this.labelDisplay = labelDisplay;
    }

    public boolean isLabelDisplay() {
        return labelDisplay;
    }

    public void setLabelPosition(String labelPosition) {
        this.labelPosition = labelPosition;
    }

    public String getLabelPosition() {
        return labelPosition;
    }

    public void setXAxisDisplay(boolean xAxisDisplay) {
        this.xAxisDisplay = xAxisDisplay;
    }
  
    public boolean isXAxisdDisplay() {
        return xAxisDisplay;
    }

    public void setYAxisDisplay(boolean yAxisDisplay) {
        this.yAxisDisplay = yAxisDisplay;
    }
  
    public boolean isYAxisdDisplay() {
        return yAxisDisplay;
    }

    public String getHighColor()
    {
      return highColor;
    }
  
    public void setHighColor(String highColor)
    {
      this.highColor = highColor;
    }
  
    public String getLowColor()
    {
      return lowColor;
    }
  
    public void setLowColor(String lowColor)
    {
      this.lowColor = lowColor;
    }
  
    public String getFirstColor()
    {
      return firstColor;
    }
  
    public void setFirstColor(String firstColor)
    {
      this.firstColor = firstColor;
    }
  
    public String getLastColor()
    {
      return lastColor;
    }
  
    public void setLastColor(String lastColor)
    {
      this.lastColor = lastColor;
    }

  public String getFailingColor()
  {
    return failingColor;
  }

  public void setFailingColor(String failingColor)
  {
    this.failingColor = failingColor;
  }

  public String getRangeColor()
  {
    return rangeColor;
  }

  public void setRangeColor(String rangeColor)
  {
    this.rangeColor = rangeColor;
  }

  public String getRisingColor()
  {
    return risingColor;
  }

  public void setRisingColor(String risingColor)
  {
    this.risingColor = risingColor;
  }

  public String getZoomAndScroll()
  {
    return zoomAndScroll;
  }

  public void setZoomAndScroll(String zoomAndScroll)
  {
    this.zoomAndScroll = zoomAndScroll;
  }

  public String getZoomDirection()
  {
    return zoomDirection;
  }

  public void setZoomDirection(String zoomDirection)
  {
    this.zoomDirection = zoomDirection;
  }
  
  public String getSplitDualY()
  {
    return splitDualY;
  }

  public void setSplitDualY(String splitDualY)
  {
    this.splitDualY = splitDualY;
  }
  public String getVolumeColor()
  {
    return volumeColor;
  }

  public void setVolumeColor(String volumeColor)
  {
    this.volumeColor = volumeColor;
  }
}
