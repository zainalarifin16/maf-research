package mobile;

import oracle.adfmf.amx.event.ValueChangeEvent;

public class ThematicMapProperties {
    private boolean demoRendered;
    
    // thematicMap
    private String animationOnDisplay;
    private String animationOnMapChange;
    private int animationDuration;
    private String tooltipDisplay;
    private String basemap;
    private String zooming;
    private String panning;
    private String initialZooming;
    private String inlineStyle; 
    
    // areaLayer
    private String layer;
    private String animationOnLayerChange;
    private String areaLabelDisplay;
    private String labelType;
    private boolean rendered;
    
    // areaDataLayer
    private int dataAnimationDuration;
    private String dataAnimationOnDataChange;
    private String dataSelection;
    
    // pointDataLayer
    private int pointDataAnimationDuration;
    private String pointDataAnimationOnDataChange;
    private String pointDataSelection;
    private boolean pointDataRendered;
    
    // selection
    private String areaSelection;
    
    // TMap Legend: area
    private String areaFillColor;
    private double areaOpacity;
    private String areaLabelStyle;
    private String areaLabelDisplay2;
    private String areaShortDesc;
    private String areaValue;
    
    // TMap Legend: marker
    private String markerGradientEffect;
    private String markerLabelPosition;
    private double markerScaleX;
    private double markerScaleY;
    private String markerShape;
    private String markerFillColor;
    private double markerOpacity;
    private String markerLabelStyle;
    private String markerLabelDisplay;
    private String markerShortDesc;
    private String markerValue;
    
    
    public ThematicMapProperties(){}


    public String getAnimationOnDisplay() {
        return animationOnDisplay;
    }

    public void setAnimationOnDisplay(String animationOnDisplay) {
        this.animationOnDisplay = animationOnDisplay;
    }

    public String getAnimationOnMapChange() {
        return animationOnMapChange;
    }

    public void setAnimationOnMapChange(String animationOnMapChange) {
        this.animationOnMapChange = animationOnMapChange;
    }

    public int getAnimationDuration() {
        return animationDuration;
    }

    public void setAnimationDuration(int animationDuration) {
        this.animationDuration = animationDuration;
    }

    public String getTooltipDisplay() {
        return tooltipDisplay;
    }

    public void setTooltipDisplay(String tooltipDisplay) {
        this.tooltipDisplay = tooltipDisplay;
    }

    public String getBasemap() {
        return basemap;
    }

    public void setBasemap(String basemap) {
        this.basemap = basemap;
    }

    public String getZooming() {
        return zooming;
    }

    public void setZooming(String zooming) {
        this.zooming = zooming;
    }

    public String getPanning() {
        return panning;
    }

    public void setPanning(String panning) {
        this.panning = panning;
    }

    public String getInitialZooming() {
        return initialZooming;
    }

    public void setInitialZooming(String initialZooming) {
        this.initialZooming = initialZooming;
    }

    public String getInlineStyle() {
        return inlineStyle;
    }

    public void setInlineStyle(String inlineStyle) {
        this.inlineStyle = inlineStyle;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getAnimationOnLayerChange() {
        return animationOnLayerChange;
    }

    public void setAnimationOnLayerChange(String animationOnLayerChange) {
        this.animationOnLayerChange = animationOnLayerChange;
    }

    public String getAreaLabelDisplay() {
        return areaLabelDisplay;
    }

    public void setAreaLabelDisplay(String areaLabelDisplay) {
        this.areaLabelDisplay = areaLabelDisplay;
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public int getDataAnimationDuration() {
        return dataAnimationDuration;
    }

    public void setDataAnimationDuration(int dataAnimationDuration) {
        this.dataAnimationDuration = dataAnimationDuration;
    }

    public String getDataAnimationOnDataChange() {
        return dataAnimationOnDataChange;
    }

    public void setDataAnimationOnDataChange(String dataAnimationOnDataChange) {
        this.dataAnimationOnDataChange = dataAnimationOnDataChange;
    }

    public String getDataSelection() {
        return dataSelection;
    }

    public void setDataSelection(String dataSelection) {
        this.dataSelection = dataSelection;
    }

    public int getPointDataAnimationDuration() {
        return pointDataAnimationDuration;
    }

    public void setPointDataAnimationDuration(int pointDataAnimationDuration) {
        this.pointDataAnimationDuration = pointDataAnimationDuration;
    }

    public String getPointDataAnimationOnDataChange() {
        return pointDataAnimationOnDataChange;
    }

    public void setPointDataAnimationOnDataChange(
            String pointDataAnimationOnDataChange) {
        this.pointDataAnimationOnDataChange = pointDataAnimationOnDataChange;
    }

    public String getPointDataSelection() {
        return pointDataSelection;
    }

    public void setPointDataSelection(String pointDataSelection) {
        this.pointDataSelection = pointDataSelection;
    }
    
    public boolean isPointDataRendered() {
        return pointDataRendered;
    }

    public void setPointDataRendered(boolean pointDataRendered) {
        this.pointDataRendered = pointDataRendered;
    }

    public String getAreaSelection() {
        return areaSelection;
    }

    public void setAreaSelection(String areaSelection) {
        this.areaSelection = areaSelection;
    }

    public String getAreaFillColor() {
        return areaFillColor;
    }

    public void setAreaFillColor(String areaFillColor) {
        this.areaFillColor = areaFillColor;
    }

    public double getAreaOpacity() {
        return areaOpacity;
    }

    public void setAreaOpacity(double areaOpacity) {
        this.areaOpacity = areaOpacity;
    }

    public String getAreaLabelStyle() {
        return areaLabelStyle;
    }

    public void setAreaLabelStyle(String areaLabelStyle) {
        this.areaLabelStyle = areaLabelStyle;
    }

    public String getAreaLabelDisplay2() {
        return areaLabelDisplay2;
    }

    public void setAreaLabelDisplay2(String areaLabelDisplay2) {
        this.areaLabelDisplay2 = areaLabelDisplay2;
    }

    public String getMarkerGradientEffect() {
        return markerGradientEffect;
    }

    public void setMarkerGradientEffect(String markerGradientEffect) {
        this.markerGradientEffect = markerGradientEffect;
    }

    public String getMarkerLabelPosition() {
        return markerLabelPosition;
    }

    public void setMarkerLabelPosition(String markerLabelPosition) {
        this.markerLabelPosition = markerLabelPosition;
    }

    public double getMarkerScaleX() {
        return markerScaleX;
    }

    public void setMarkerScaleX(double markerScaleX) {
        this.markerScaleX = markerScaleX;
    }

    public double getMarkerScaleY() {
        return markerScaleY;
    }

    public void setMarkerScaleY(double markerScaleY) {
        this.markerScaleY = markerScaleY;
    }

    public String getMarkerShape() {
        return markerShape;
    }

    public void setMarkerShape(String markerShape) {
        this.markerShape = markerShape;
    }

    public String getMarkerFillColor() {
        return markerFillColor;
    }

    public void setMarkerFillColor(String markerFillColor) {
        this.markerFillColor = markerFillColor;
    }

    public double getMarkerOpacity() {
        return markerOpacity;
    }

    public void setMarkerOpacity(double markerOpacity) {
        this.markerOpacity = markerOpacity;
    }

    public String getMarkerLabelStyle() {
        return markerLabelStyle;
    }

    public void setMarkerLabelStyle(String markerLabelStyle) {
        this.markerLabelStyle = markerLabelStyle;
    }

    public String getMarkerLabelDisplay() {
        return markerLabelDisplay;
    }

    public void setMarkerLabelDisplay(String markerLabelDisplay) {
        this.markerLabelDisplay = markerLabelDisplay;
    }

    public String getAreaShortDesc() {
        return areaShortDesc;
    }

    public void setAreaShortDesc(String areaShortDesc) {
        this.areaShortDesc = areaShortDesc;
    }

    public String getMarkerShortDesc() {
        return markerShortDesc;
    }

    public void setMarkerShortDesc(String markerShortDesc) {
        this.markerShortDesc = markerShortDesc;
    }

    public String getAreaValue() {
        return areaValue;
    }

    public void setAreaValue(String areaValue) {
        this.areaValue = areaValue;
    }

    public String getMarkerValue() {
        return markerValue;
    }

    public void setMarkerValue(String markerValue) {
        this.markerValue = markerValue;
    }

    public void basemapChanged(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }

    public void setDemoRendered(boolean demoRendered) {
        this.demoRendered = demoRendered;
    }

    public boolean isDemoRendered() {
        return demoRendered;
    }
}
