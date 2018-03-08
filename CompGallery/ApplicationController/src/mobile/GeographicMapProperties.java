package mobile;

import oracle.adfmf.amx.event.MapBoundsChangeEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class GeographicMapProperties {
    private String mapType;
    private String centerX;
    private String centerY;
    private String zoomLevel;
    private String inlineStyle;
    private String shortDesc;
    private String animationOnDisplay;
    private String initialZooming;
    private String popupAlign = "topCenter";
    private String dataSelection = "single";
    
    private boolean markerRendered = true;
    private String markerLabelPosition = "bottom";
    private String markerWidth;
    private String markerHeight;
    private String markerScaleX = "1";
    private String markerScaleY = "1";
    private String markerLabelStyle = "";
    private String markerSelectedLabelStyle = "";
    private boolean markerLabelDisplay = true;
    private String markerOpacity = "0.5";
    private String markerIconDisplay = "auto";


    public void setMarkerLabelPosition(String markerLabelPosition) {
        this.markerLabelPosition = markerLabelPosition;
    }

    public String getMarkerLabelPosition() {
        return markerLabelPosition;
    }

    public void setMarkerWidth(String markerWidth) {
        this.markerWidth = markerWidth;
    }

    public String getMarkerWidth() {
        return markerWidth;
    }

    public void setMarkerHeight(String markerHeight) {
        this.markerHeight = markerHeight;
    }

    public String getMarkerHeight() {
        return markerHeight;
    }

    public void setMarkerScaleX(String markerScaleX) {
        this.markerScaleX = markerScaleX;
    }

    public String getMarkerScaleX() {
        return markerScaleX;
    }

    public void setMarkerScaleY(String markerScaleY) {
        this.markerScaleY = markerScaleY;
    }

    public String getMarkerScaleY() {
        return markerScaleY;
    }

    public void setMarkerLabelStyle(String markerLabelStyle) {
        this.markerLabelStyle = markerLabelStyle;
    }

    public String getMarkerLabelStyle() {
        return markerLabelStyle;
    }

    public void setMarkerLabelDisplay(boolean markerLabelDisplay) {
        this.markerLabelDisplay = markerLabelDisplay;
    }

    public boolean isMarkerLabelDisplay() {
        return markerLabelDisplay;
    }

    public void setMarkerOpacity(String markerOpacity) {
        this.markerOpacity = markerOpacity;
    }

    public String getMarkerOpacity() {
        return markerOpacity;
    }

    public GeographicMapProperties(){}
    
    public String getMapType() {
        return mapType;
    }
    
    public void setMapType(String mapType) {
        this.mapType = mapType;
    }
    
    public String getCenterX() {
        return centerX;
    }
    
    public void setCenterX(String centerX) {
        this.centerX = centerX;
    }
    
    public String getCenterY() {
        return centerY;
    }
    
    public void setCenterY(String centerY) {
        this.centerY = centerY;
    }
    
    public String getZoomLevel() {
        return zoomLevel;
    }
    
    public void setZoomLevel(String zoomLevel) {
        this.zoomLevel = zoomLevel;
    }
    
    public String getInlineStyle() {
        return inlineStyle;
    }
    
    public void setInlineStyle(String inlineStyle) {
        this.inlineStyle = inlineStyle;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public void setAnimationOnDisplay(String animationOnDisplay) {
        this.animationOnDisplay = animationOnDisplay;
    }

    public String getAnimationOnDisplay() {
        return animationOnDisplay;
    }

    public void setInitialZooming(String initialZooming) {
        this.initialZooming = initialZooming;
    }

    public String getInitialZooming() {
        return initialZooming;
    }

    public void setPopupAlign(String popupAlign)
    {
      this.popupAlign = popupAlign;
    }
  
    public String getPopupAlign()
    {
      return popupAlign;
    }

    public void setMarkerIconDisplay(String markerIconDisplay) {
        this.markerIconDisplay = markerIconDisplay;
    }

    public String getMarkerIconDisplay() {
        return markerIconDisplay;
    }

    public void setMarkerSelectedLabelStyle(String markerSelectedLabelStyle) {
        this.markerSelectedLabelStyle = markerSelectedLabelStyle;
    }

    public String getMarkerSelectedLabelStyle() {
        return markerSelectedLabelStyle;
    }

    public void setMarkerRendered(boolean markerRendered) {
        this.markerRendered = markerRendered;
    }

    public boolean isMarkerRendered() {
        return markerRendered;
    }

    public void setDataSelection(String dataSelection) {
        this.dataSelection = dataSelection;
    }

    public String getDataSelection() {
        return dataSelection;
    }

    public void mapBoundsChangeListener(MapBoundsChangeEvent mapBoundsChangeEvent)
  {
    AdfmfJavaUtilities.setELValue("#{pageFlowScope._centerX}", mapBoundsChangeEvent.getCenterX());
    AdfmfJavaUtilities.setELValue("#{pageFlowScope._centerY}", mapBoundsChangeEvent.getCenterY());
    AdfmfJavaUtilities.setELValue("#{pageFlowScope._zoomLevel}", mapBoundsChangeEvent.getZoomLevel()); 
  }
}
