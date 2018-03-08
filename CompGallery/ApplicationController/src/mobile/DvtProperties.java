package mobile;

import javax.el.ValueExpression;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.exception.AdfException;

public class DvtProperties
{

  private ChartProperties areaChartProperties;
  private ChartProperties barChartProperties;
  private ChartProperties drillingProperties;
  private ChartProperties bubbleChartProperties;
  private ChartProperties comboChartProperties;
  private ChartProperties funnelChartProperties;
  private ChartProperties horizontalBarChartProperties;
  private ChartProperties lineChartProperties;
  private ChartProperties pieChartProperties;
  private ChartProperties scatterChartProperties;
  private ChartProperties sparkChartProperties;
  private ChartProperties stockChartProperties;
  private GaugeProperties ledGaugeProperties;
  private GaugeProperties statusMeterGaugeHorizontalProperties;
  private GaugeProperties statusMeterGaugeVerticalProperties;
  private GaugeProperties statusMeterGaugeCircularProperties;
  private DialGaugeProperties dialGaugeProperties;
  private RatingGaugeProperties ratingGaugeProperties;
  private GeographicMapProperties geographicMapProperties;
  private GeographicMapProperties geographicMapProperties2;
  private GeographicMapProperties geographicMapBubbleProperties;
  private LegendProperties commonLegendProperties;
  private LegendProperties commonLegendSectionProperties;
  private LegendProperties commonLegendItemProperties;
  private ThematicMapProperties thematicMapProperties;
  private ThematicMapProperties thematicMapIsolationProperties;
  private ThematicMapProperties thematicMapZoomProperties;
  private ThematicMapProperties thematicMapAreaMarkerProperties;
  private ThematicMapProperties thematicMapCustomMapProperties;
  private ThematicMapProperties thematicMapCustomMarkerProperties;
  private ThematicMapProperties thematicMapSwitcherProperties;
  private TreeviewProperties treemapProperties;
  private TreeviewProperties sunburstProperties;
  private boolean thematicMapShowPointDataProperties;
  private boolean thematicMapShowAreaProperties;
  private boolean thematicMapShowMarkerProperties;
  private boolean thematicMapShowMapsProperties;
  private String selectedValuesInlineStyle;
  private String selectedValuesInitialValue;
  private boolean thematicMapShowMarkerShortDesc;
  private boolean thematicMapShowAreaShortDesc;
  private boolean thematicMapShowMarkerValue;
  private boolean hostedMode;

  public DvtProperties()
  {

    // area chart
    this.areaChartProperties = new ChartProperties();
    this.areaChartProperties.setTitle("Area Chart");
    this.areaChartProperties.setSDataCursor(true);
    this.areaChartProperties.setSDataCursorBehavior(true);
    this.areaChartProperties.setSDataSelection(true);
    this.areaChartProperties.setSHideAndShowBehavior(true);
    this.areaChartProperties.setSRolloverBehavior(true);
    this.areaChartProperties.setSScaleY(true);
    this.areaChartProperties.setSStack(true);

    // bar chart
    this.barChartProperties = new ChartProperties();
    this.barChartProperties.setTitle("Bar Chart");
    this.barChartProperties.setSDataCursor(true);
    this.barChartProperties.setSDataCursorBehavior(true);
    this.barChartProperties.setSDataSelection(true);
    this.barChartProperties.setSHideAndShowBehavior(true);
    this.barChartProperties.setSRolloverBehavior(true);
    this.barChartProperties.setSScaleY(true);
    this.barChartProperties.setSStack(true);
    this.barChartProperties.setSStackLabel(true);

    // drilling in chart
    this.setDrillingProperties(new ChartProperties());
    this.getDrillingProperties().setTitle("Drilling");
    this.getDrillingProperties().setSDataCursor(true);
    this.getDrillingProperties().setSDataCursorBehavior(true);
    this.getDrillingProperties().setSDataSelection(true);
    this.getDrillingProperties().setSHideAndShowBehavior(true);
    this.getDrillingProperties().setSRolloverBehavior(true);
    this.getDrillingProperties().setSStack(true);

    // bubble chart
    this.bubbleChartProperties = new ChartProperties();
    this.bubbleChartProperties.setTitle("Bubble Chart");
    this.bubbleChartProperties.setSDataSelection(true);
    this.bubbleChartProperties.setSHideAndShowBehavior(true);
    this.bubbleChartProperties.setSRolloverBehavior(true);
    this.bubbleChartProperties.setSAnimationIndicators(false);
    this.bubbleChartProperties.setSAnimationUpColor(false);
    this.bubbleChartProperties.setSAnimationDownColor(false);
    this.bubbleChartProperties.setSScaleX(true);
    this.bubbleChartProperties.setSScaleY(true);
    this.bubbleChartProperties.setSZoomAndScroll(true);
    this.bubbleChartProperties.setSZoomDirection(true);

    // combo chart
    this.comboChartProperties = new ChartProperties();
    this.comboChartProperties.setTitle("Combo Chart");
    this.comboChartProperties.setSDataCursor(true);
    this.comboChartProperties.setSDataCursorBehavior(true);
    this.comboChartProperties.setSDataSelection(true);
    this.comboChartProperties.setSHideAndShowBehavior(true);
    this.comboChartProperties.setSRolloverBehavior(true);
    this.comboChartProperties.setSScaleY(true);
    this.comboChartProperties.setSStack(true);

    // funnel chart
    this.funnelChartProperties = new ChartProperties();
    this.funnelChartProperties.setTitle("Funnel Chart");
    this.funnelChartProperties.setSDataCursor(false);
    this.funnelChartProperties.setSDataCursorBehavior(false);
    this.funnelChartProperties.setSDataSelection(true);
    this.funnelChartProperties.setSHideAndShowBehavior(true);
    this.funnelChartProperties.setSRolloverBehavior(true);
    this.funnelChartProperties.setSStack(false);
    this.funnelChartProperties.setSThreeDEffect(true);
    this.funnelChartProperties.setSAnimationIndicators(false);
    this.funnelChartProperties.setSAnimationDownColor(false);
    this.funnelChartProperties.setSAnimationUpColor(false);

    // horizontal bar chart
    this.horizontalBarChartProperties = new ChartProperties();
    this.horizontalBarChartProperties.setTitle("Horizontal Bar Chart");
    this.horizontalBarChartProperties.setSDataSelection(true);
    this.horizontalBarChartProperties.setSHideAndShowBehavior(true);
    this.horizontalBarChartProperties.setSRolloverBehavior(true);
    this.horizontalBarChartProperties.setSStack(true);

    // legend
    this.commonLegendProperties = new LegendProperties();
    this.commonLegendProperties.setInlineStyle("width: 100%;");

    this.commonLegendSectionProperties = new LegendProperties();

    this.commonLegendItemProperties = new LegendProperties();
    this.commonLegendItemProperties.setColor("#ff0000");

    // line chart
    this.lineChartProperties = new ChartProperties();
    this.lineChartProperties.setTitle("Line Chart");
    this.lineChartProperties.setSDataCursor(true);
    this.lineChartProperties.setSDataCursorBehavior(true);
    this.lineChartProperties.setSDataSelection(true);
    this.lineChartProperties.setSHideAndShowBehavior(true);
    this.lineChartProperties.setSRolloverBehavior(true);
    this.lineChartProperties.setSScaleX(true);
    this.lineChartProperties.setSScaleY(true);
    this.lineChartProperties.setSStack(true);
    this.lineChartProperties.setSSeriesEffect(false);

    // pie chart
    this.pieChartProperties = new ChartProperties();
    this.pieChartProperties.setTitle("Pie Chart");
    this.pieChartProperties.setSDataSelection(true);
    this.pieChartProperties.setSHideAndShowBehavior(true);
    this.pieChartProperties.setSRolloverBehavior(true);
    this.pieChartProperties.setSThreeDEffect(true);
    this.pieChartProperties.setSAnimationIndicators(false);
    this.pieChartProperties.setSAnimationUpColor(false);
    this.pieChartProperties.setSAnimationDownColor(false);

    // scatter chart
    this.scatterChartProperties = new ChartProperties();
    this.scatterChartProperties.setTitle("Scatter Chart");
    this.scatterChartProperties.setSDataSelection(true);
    this.scatterChartProperties.setSHideAndShowBehavior(true);
    this.scatterChartProperties.setSRolloverBehavior(true);
    this.scatterChartProperties.setSAnimationIndicators(false);
    this.scatterChartProperties.setSAnimationUpColor(false);
    this.scatterChartProperties.setSAnimationDownColor(false);
    this.scatterChartProperties.setSScaleX(false);
    this.scatterChartProperties.setSScaleY(false);
    this.scatterChartProperties.setSSeriesEffect(false);
    this.bubbleChartProperties.setSZoomAndScroll(true);
    this.bubbleChartProperties.setSZoomDirection(true);

    // spark chart
    this.sparkChartProperties = new ChartProperties();
    this.sparkChartProperties.setInlineStyle("width:100%; height:#{deviceScope.hardware.screen.availableHeight-44}px; background-color: white;");
    this.sparkChartProperties.setSColor(true);
    this.sparkChartProperties.setSFootnote(false);
    this.sparkChartProperties.setSSubtitle(false);
    this.sparkChartProperties.setSTitle(false);
    // TODO: this.sparkChartProperties.setSType(true);
    this.sparkChartProperties.setSAnimationIndicators(false);
    this.sparkChartProperties.setSAnimationUpColor(false);
    this.sparkChartProperties.setSAnimationDownColor(false);
    this.sparkChartProperties.setSSeriesEffect(false);

    // stock chart
    this.setStockChartProperties(new ChartProperties());
    this.getStockChartProperties().setTitle("Stock Chart");
    this.getStockChartProperties().setShortDesc("Stock Chart");
    this.getStockChartProperties().setSubtitle("BTC / USD");
    this.getStockChartProperties().setSDataSelection(true);
    this.getStockChartProperties().setDataSelection("single");
    this.getStockChartProperties().setDataCursor("on");
    this.getStockChartProperties().setZoomAndScroll("delayed");
    this.getStockChartProperties().setSplitDualY("on");
    this.getStockChartProperties().setRisingColor("#6b6f74");
    this.getStockChartProperties().setRangeColor("#B8B8B8");
    this.getStockChartProperties().setFailingColor("#ED6647");
    this.getStockChartProperties().setFootnote("Reference line show technical analysis");

    // led gauge
    this.ledGaugeProperties = new GaugeProperties();
    this.ledGaugeProperties.setValue("55");
    this.ledGaugeProperties.setType("circle");
    this.ledGaugeProperties.setLabelDisplay("on");
    this.ledGaugeProperties.setInlineStyle("width: 50px; height: 50px;");
    this.ledGaugeProperties.setMetricLabelStyle("");

    // status meter gauge horizontal
    this.statusMeterGaugeHorizontalProperties = new GaugeProperties();
    this.statusMeterGaugeHorizontalProperties.setColor("#267db3");
    this.statusMeterGaugeHorizontalProperties.setValue("65");
    this.statusMeterGaugeHorizontalProperties.setReadOnly("true");
    this.statusMeterGaugeHorizontalProperties.setMinValue("0");
    this.statusMeterGaugeHorizontalProperties.setMaxValue("100");
    this.statusMeterGaugeHorizontalProperties.setLabelDisplay("on");
    this.statusMeterGaugeHorizontalProperties.setInlineStyle("");
    this.statusMeterGaugeHorizontalProperties.setIndicatorSize("0.4");
    this.statusMeterGaugeHorizontalProperties.setPlotArea("auto");
    this.statusMeterGaugeHorizontalProperties.setThresholdDisplay("all");
    this.statusMeterGaugeHorizontalProperties.setReferenceLineColor("#888888");
    this.statusMeterGaugeHorizontalProperties.setReferenceLineValue("65");
    this.statusMeterGaugeHorizontalProperties.setTitleStyle("font-size:16px; font-weight: bold");

    // status meter gauge vertical
    this.statusMeterGaugeVerticalProperties = new GaugeProperties();
    this.statusMeterGaugeVerticalProperties.setColor("#267db3");
    this.statusMeterGaugeVerticalProperties.setValue("65");
    this.statusMeterGaugeVerticalProperties.setReadOnly("true");
    this.statusMeterGaugeVerticalProperties.setMinValue("0");
    this.statusMeterGaugeVerticalProperties.setMaxValue("100");
    this.statusMeterGaugeVerticalProperties.setLabelDisplay("on");
    this.statusMeterGaugeVerticalProperties.setInlineStyle("width: 40px;");
    this.statusMeterGaugeVerticalProperties.setIndicatorSize("0.4");
    this.statusMeterGaugeVerticalProperties.setPlotArea("auto");
    this.statusMeterGaugeVerticalProperties.setThresholdDisplay("all");
    this.statusMeterGaugeVerticalProperties.setReferenceLineColor("#888888");
    this.statusMeterGaugeVerticalProperties.setReferenceLineValue("65");
    this.statusMeterGaugeVerticalProperties.setMetricLabelStyle("");
    this.statusMeterGaugeVerticalProperties.setTitleStyle("");

    // status meter gauge circular
    this.statusMeterGaugeCircularProperties = new GaugeProperties();
    this.statusMeterGaugeCircularProperties.setColor("#267db3");
    this.statusMeterGaugeCircularProperties.setValue("65");
    this.statusMeterGaugeCircularProperties.setReadOnly("true");
    this.statusMeterGaugeCircularProperties.setMinValue("0");
    this.statusMeterGaugeCircularProperties.setMaxValue("100");
    this.statusMeterGaugeCircularProperties.setLabelDisplay("on");
    this.statusMeterGaugeCircularProperties.setInlineStyle("");
    this.statusMeterGaugeCircularProperties.setIndicatorSize("0.4");
    this.statusMeterGaugeCircularProperties.setPlotArea("auto");
    this.statusMeterGaugeCircularProperties.setThresholdDisplay("all");
    this.statusMeterGaugeCircularProperties.setReferenceLineColor("#888888");
    this.statusMeterGaugeCircularProperties.setReferenceLineValue("65");
    this.statusMeterGaugeCircularProperties.setMetricLabelStyle("");
    this.statusMeterGaugeCircularProperties.setTitleStyle("");

    // dial gauge
    this.dialGaugeProperties = new DialGaugeProperties();
    this.dialGaugeProperties.setValue("65");
    this.dialGaugeProperties.setMinValue("0");
    this.dialGaugeProperties.setMaxValue("100");
    this.dialGaugeProperties.setBackground("circleAntique");
    this.dialGaugeProperties.setIndicator("needleAntique");
    this.dialGaugeProperties.setReadOnly("true");
    this.dialGaugeProperties.setTickScaling("none");
    this.dialGaugeProperties.setMetricScaling("none");
    this.dialGaugeProperties.setTickLabelStyle("");
    this.dialGaugeProperties.setMetricLabelStyle("");

    // rating gauge
    this.ratingGaugeProperties = new RatingGaugeProperties();
    this.ratingGaugeProperties.setMinValue("0");
    this.ratingGaugeProperties.setMaxValue("5");
    this.ratingGaugeProperties.setValue("2.5");
    this.ratingGaugeProperties.setInputIncrement("half");
    this.ratingGaugeProperties.setShape("star");
    this.ratingGaugeProperties.setUnselectedShape("auto");
    this.ratingGaugeProperties.setReadOnly("false");
    this.ratingGaugeProperties.setInlineStyle("");
    this.ratingGaugeProperties.setShortDesc("");

    // geographic map
    this.geographicMapProperties = new GeographicMapProperties();
    this.geographicMapProperties.setMapType("ROADMAP");
    this.geographicMapProperties.setCenterX("-71.11");
    this.geographicMapProperties.setCenterY("42.23");
    this.geographicMapProperties.setZoomLevel(null);
    this.geographicMapProperties.setShortDesc("");
    this.geographicMapProperties.setInlineStyle("width:100%; height:#{deviceScope.hardware.screen.availableHeight-64}px; background-color: white;");

    // geographic map 2
    this.geographicMapProperties2 = new GeographicMapProperties();
    this.geographicMapProperties2.setMapType("ROADMAP");
    this.geographicMapProperties2.setCenterX("-71.21");
    this.geographicMapProperties2.setCenterY("42.48");
    this.geographicMapProperties2.setZoomLevel(null);
    this.geographicMapProperties2.setShortDesc("");
    this.geographicMapProperties2.setInlineStyle("width:100%; height:#{deviceScope.hardware.screen.availableHeight-64}px; background-color: white;");

    // geographic map
    this.geographicMapBubbleProperties = new GeographicMapProperties();
    this.geographicMapBubbleProperties.setMapType("ROADMAP");
    this.geographicMapBubbleProperties.setCenterX("-96.02");
    this.geographicMapBubbleProperties.setCenterY("40.038");
    this.geographicMapBubbleProperties.setZoomLevel(null);
    this.geographicMapBubbleProperties.setShortDesc("");
    this.geographicMapBubbleProperties.setInlineStyle("width:100%; height:#{deviceScope.hardware.screen.availableHeight-64}px; background-color: white;");
    this.geographicMapBubbleProperties.setMarkerLabelPosition("bubble");

    // thematic map
    this.thematicMapProperties = createThematicMapProperties();
    this.thematicMapProperties.setBasemap("world");
    this.thematicMapProperties.setLayer("continents");
    this.thematicMapProperties.setInlineStyle("width:100%; height:#{deviceScope.hardware.screen.availableHeight-64}px; background-color: white;");

    // thematic map: isolation
    this.thematicMapIsolationProperties = createThematicMapProperties();
    this.thematicMapIsolationProperties.setBasemap("usa");
    this.thematicMapIsolationProperties.setLayer("states");

    // thematic map: zoom
    this.thematicMapZoomProperties = createThematicMapProperties();
    this.thematicMapZoomProperties.setBasemap("usa");
    this.thematicMapZoomProperties.setLayer("states");
    this.thematicMapZoomProperties.setPointDataRendered(true);
    this.thematicMapZoomProperties.setPointDataAnimationOnDataChange("alphaFade");
    this.thematicMapZoomProperties.setPointDataAnimationDuration(1000);
    this.thematicMapZoomProperties.setPointDataSelection("single");
    this.thematicMapZoomProperties.setInitialZooming("auto");
    this.thematicMapZoomProperties.setAreaOpacity(0);
    this.thematicMapZoomProperties.setAreaLabelDisplay2("off");
    this.thematicMapZoomProperties.setMarkerGradientEffect("auto");
    this.thematicMapZoomProperties.setMarkerLabelPosition("center");
    this.thematicMapZoomProperties.setMarkerScaleX(2);
    this.thematicMapZoomProperties.setMarkerScaleY(2);
    this.thematicMapZoomProperties.setMarkerShape("circle");
    this.thematicMapZoomProperties.setMarkerOpacity(0);
    this.thematicMapZoomProperties.setMarkerLabelDisplay("off");

    // thematic map: area/marker
    this.thematicMapAreaMarkerProperties = createThematicMapProperties();
    this.thematicMapAreaMarkerProperties.setBasemap("world");
    this.thematicMapAreaMarkerProperties.setLayer("continents");
    this.thematicMapAreaMarkerProperties.setAreaOpacity(0);
    this.thematicMapAreaMarkerProperties.setAreaLabelDisplay2("off");
    this.thematicMapAreaMarkerProperties.setMarkerGradientEffect("auto");
    this.thematicMapAreaMarkerProperties.setMarkerLabelPosition("center");
    this.thematicMapAreaMarkerProperties.setMarkerScaleX(2);
    this.thematicMapAreaMarkerProperties.setMarkerScaleY(2);
    this.thematicMapAreaMarkerProperties.setMarkerShape("circle");
    this.thematicMapAreaMarkerProperties.setMarkerOpacity(0);
    this.thematicMapAreaMarkerProperties.setMarkerLabelDisplay("off");

    // thematic map: custom map
    this.thematicMapCustomMapProperties = createThematicMapProperties();
    this.thematicMapCustomMapProperties.setAreaOpacity(0);
    this.thematicMapCustomMapProperties.setAreaLabelDisplay("off");
    this.thematicMapCustomMapProperties.setPointDataRendered(true);
    this.thematicMapCustomMapProperties.setPointDataAnimationOnDataChange("alphaFade");
    this.thematicMapCustomMapProperties.setPointDataAnimationDuration(1000);
    this.thematicMapCustomMapProperties.setPointDataSelection("single");
    this.thematicMapCustomMapProperties.setMarkerFillColor("#49545B");
    this.thematicMapCustomMapProperties.setMarkerGradientEffect("auto");
    this.thematicMapCustomMapProperties.setMarkerLabelPosition("center");
    this.thematicMapCustomMapProperties.setMarkerLabelStyle("font-size:16px; color:#FEDCBA;");
    this.thematicMapCustomMapProperties.setMarkerScaleX(5);
    this.thematicMapCustomMapProperties.setMarkerScaleY(5);
    this.thematicMapCustomMapProperties.setMarkerShape("circle");
    this.thematicMapCustomMapProperties.setMarkerOpacity(0.50);
    this.thematicMapCustomMapProperties.setMarkerLabelDisplay("on");

    // thematic map: custom marker
    this.thematicMapCustomMarkerProperties = createThematicMapProperties();
    this.thematicMapCustomMarkerProperties.setAreaSelection("single");
    this.thematicMapCustomMarkerProperties.setDataSelection("single");
    this.thematicMapCustomMarkerProperties.setAreaLabelDisplay("off");
    this.thematicMapCustomMarkerProperties.setMarkerLabelDisplay("off");
    this.thematicMapCustomMarkerProperties.setMarkerScaleX(5);
    this.thematicMapCustomMarkerProperties.setMarkerScaleY(5);

    // thematic map: switcher
    this.thematicMapSwitcherProperties = createThematicMapProperties();
    this.thematicMapSwitcherProperties.setBasemap("usa");
    this.thematicMapSwitcherProperties.setLayer("states");
    this.thematicMapSwitcherProperties.setAreaSelection("single");
    this.thematicMapSwitcherProperties.setDataSelection("single");
    this.thematicMapSwitcherProperties.setAreaLabelDisplay("off");
    this.thematicMapSwitcherProperties.setMarkerLabelDisplay("off");

    // treemap
    this.treemapProperties = new TreeviewProperties();
    this.treemapProperties.setAnimationDuration(500);
    this.treemapProperties.setAnimationOnDataChange("auto");
    this.treemapProperties.setAnimationOnDisplay("auto");
    this.treemapProperties.setLayout("squarified");
    this.treemapProperties.setNodeSelection("multiple");
    this.treemapProperties.setRendered(true);
    this.treemapProperties.setEmptyText("");
    this.treemapProperties.setInlineStyle("position:relative; top:0px; left:0px; right:0px; bottom:0px;");
    this.treemapProperties.setSizeLabel("Market Share");
    this.treemapProperties.setStyleClass("");
    this.treemapProperties.setColorLabel("Market Trend");
    this.treemapProperties.setSorting("off");
    this.treemapProperties.setShortDesc("");
    this.treemapProperties.setFillColor("");
    this.treemapProperties.setFillPattern("");
    this.treemapProperties.setLabelDisplay("node");
    this.treemapProperties.setLabelHalign("center");
    this.treemapProperties.setLabelValign("center");
    this.treemapProperties.setSelectedRowKeys("");
    this.treemapProperties.setIsTreemap(true);

    // sunburst
    this.sunburstProperties = new TreeviewProperties();
    this.sunburstProperties.setAnimationDuration(500);
    this.sunburstProperties.setAnimationOnDataChange("auto");
    this.sunburstProperties.setAnimationOnDisplay("auto");
    this.sunburstProperties.setColorLabel("Market Trend");
    this.sunburstProperties.setEmptyText("");
    this.sunburstProperties.setInlineStyle("position:relative; top:0px; left:0px; right:0px; bottom:0px;");
    this.sunburstProperties.setNodeSelection("multiple");
    this.sunburstProperties.setRendered(true);
    this.sunburstProperties.setRotation("on");
    this.sunburstProperties.setShortDesc("");
    this.sunburstProperties.setSizeLabel("Market Share");
    this.sunburstProperties.setSorting("off");
    this.sunburstProperties.setStartAngle(90);
    this.sunburstProperties.setStyleClass("");
    this.sunburstProperties.setFillColor("");
    this.sunburstProperties.setFillPattern("");
    this.sunburstProperties.setSelectedRowKeys("1");
    this.sunburstProperties.setLabelHalign("center");
    this.sunburstProperties.setLabelDisplay("horizontal");
    this.sunburstProperties.setIsTreemap(false);

    // thematic map: global
    this.thematicMapShowPointDataProperties = false;
    this.thematicMapShowAreaProperties = false;
    this.thematicMapShowMarkerProperties = false;
    this.thematicMapShowMapsProperties = false;

    this.thematicMapShowAreaShortDesc = false;
    this.thematicMapShowMarkerValue = false;
    this.thematicMapShowMarkerShortDesc = false;

    // selections: global
    this.selectedValuesInlineStyle = "margin-top: 10px; margin-bottom:5px;";
    this.selectedValuesInitialValue = "";

    this.hostedMode = false;
  }

  private ThematicMapProperties createThematicMapProperties()
  {
    ThematicMapProperties thematicMapProperties = new ThematicMapProperties();
    thematicMapProperties.setDemoRendered(true);
    thematicMapProperties.setAnimationOnDisplay("alphaFade");
    thematicMapProperties.setAnimationOnMapChange("alphaFade");
    thematicMapProperties.setAnimationDuration(1000);
    thematicMapProperties.setAreaLabelDisplay("auto");
    thematicMapProperties.setLabelType("short");
    thematicMapProperties.setRendered(true);
    thematicMapProperties.setInlineStyle("width:100%; height:#{deviceScope.hardware.screen.availableHeight-44}px; background-color: white;");
    thematicMapProperties.setTooltipDisplay("auto");
    thematicMapProperties.setDataAnimationOnDataChange("alphaFade");
    thematicMapProperties.setDataAnimationDuration(1000);
    thematicMapProperties.setDataSelection("single");
    thematicMapProperties.setZooming("none");
    thematicMapProperties.setPanning("none");
    thematicMapProperties.setInitialZooming("none");
    thematicMapProperties.setAnimationOnLayerChange("none");
    return thematicMapProperties;
  }

  public ChartProperties getAreaChartProperties()
  {
    return areaChartProperties;
  }

  public void setAreaChartProperties(ChartProperties areaChartProperties)
  {
    this.areaChartProperties = areaChartProperties;
  }

  public ChartProperties getBarChartProperties()
  {
    return barChartProperties;
  }

  public void setBarChartProperties(ChartProperties barChartProperties)
  {
    this.barChartProperties = barChartProperties;
  }

  public ChartProperties getBubbleChartProperties()
  {
    return bubbleChartProperties;
  }

  public void setBubbleChartProperties(ChartProperties bubbleChartProperties)
  {
    this.bubbleChartProperties = bubbleChartProperties;
  }

  public ChartProperties getComboChartProperties()
  {
    return comboChartProperties;
  }

  public void setComboChartProperties(ChartProperties comboChartProperties)
  {
    this.comboChartProperties = comboChartProperties;
  }

  public ChartProperties getFunnelChartProperties()
  {
    return funnelChartProperties;
  }

  public void setFunnelChartProperties(ChartProperties funnelChartProperties)
  {
    this.funnelChartProperties = funnelChartProperties;
  }

  public ChartProperties getHorizontalBarChartProperties()
  {
    return horizontalBarChartProperties;
  }

  public void setHorizontalBarChartProperties(ChartProperties horizontalBarChartProperties)
  {
    this.horizontalBarChartProperties = horizontalBarChartProperties;
  }

  public ChartProperties getLineChartProperties()
  {
    return lineChartProperties;
  }

  public void setLineChartProperties(ChartProperties lineChartProperties)
  {
    this.lineChartProperties = lineChartProperties;
  }

  public ChartProperties getPieChartProperties()
  {
    return pieChartProperties;
  }

  public void setPieChartProperties(ChartProperties pieChartProperties)
  {
    this.pieChartProperties = pieChartProperties;
  }

  public ChartProperties getScatterChartProperties()
  {
    return scatterChartProperties;
  }

  public void setScatterChartProperties(ChartProperties scatterChartProperties)
  {
    this.scatterChartProperties = scatterChartProperties;
  }

  public GaugeProperties getLedGaugeProperties()
  {
    return ledGaugeProperties;
  }

  public void setLedGaugeProperties(GaugeProperties ledGaugeProperties)
  {
    this.ledGaugeProperties = ledGaugeProperties;
  }

  public GaugeProperties getStatusMeterGaugeHorizontalProperties()
  {
    return statusMeterGaugeHorizontalProperties;
  }

  public GaugeProperties getStatusMeterGaugeVerticalProperties()
  {
    return statusMeterGaugeVerticalProperties;
  }

  public GaugeProperties getStatusMeterGaugeCircularProperties()
  {
    return statusMeterGaugeCircularProperties;
  }

  public void setStatusMeterGaugeHorizontalProperties(GaugeProperties statusMeterGaugeHorizontalProperties)
  {
    this.statusMeterGaugeHorizontalProperties = statusMeterGaugeHorizontalProperties;
  }

  public void setStatusMeterGaugeVerticalProperties(GaugeProperties statusMeterGaugeVerticalProperties)
  {
    this.statusMeterGaugeVerticalProperties = statusMeterGaugeVerticalProperties;
  }

  public void setStatusMeterCircularGaugeProperties(GaugeProperties statusMeterGaugeCircularProperties)
  {
    this.statusMeterGaugeCircularProperties = statusMeterGaugeCircularProperties;
  }

  public ChartProperties getSparkChartProperties()
  {
    return sparkChartProperties;
  }

  public void setSparkChartProperties(ChartProperties sparkChartProperties)
  {
    this.sparkChartProperties = sparkChartProperties;
  }

  public DialGaugeProperties getDialGaugeProperties()
  {
    return dialGaugeProperties;
  }

  public void setDialGaugeProperties(DialGaugeProperties dialGaugeProperties)
  {
    this.dialGaugeProperties = dialGaugeProperties;
  }

  public GeographicMapProperties getGeographicMapProperties()
  {
    return geographicMapProperties;
  }

  public void setGeographicMapProperties(GeographicMapProperties geographicMapProperties)
  {
    this.geographicMapProperties = geographicMapProperties;
  }

  public GeographicMapProperties getGeographicMapProperties2()
  {
    return geographicMapProperties2;
  }

  public void setGeographicMapProperties2(GeographicMapProperties geographicMapProperties2)
  {
    this.geographicMapProperties2 = geographicMapProperties2;
  }

  public void setGeographicMapBubbleProperties(GeographicMapProperties geographicMapBubbleProperties)
  {
    this.geographicMapBubbleProperties = geographicMapBubbleProperties;
  }

  public GeographicMapProperties getGeographicMapBubbleProperties()
  {
    return geographicMapBubbleProperties;
  }

  public ThematicMapProperties getThematicMapProperties()
  {
    return thematicMapProperties;
  }

  public void setThematicMapProperties(ThematicMapProperties thematicMapProperties)
  {
    this.thematicMapProperties = thematicMapProperties;
  }

  public ThematicMapProperties getThematicMapIsolationProperties()
  {
    return thematicMapIsolationProperties;
  }

  public void setThematicMapIsolationProperties(ThematicMapProperties thematicMapIsolationProperties)
  {
    this.thematicMapIsolationProperties = thematicMapIsolationProperties;
  }

  public ThematicMapProperties getThematicMapZoomProperties()
  {
    return thematicMapZoomProperties;
  }

  public void setThematicMapZoomProperties(ThematicMapProperties thematicMapZoomProperties)
  {
    this.thematicMapZoomProperties = thematicMapZoomProperties;
  }

  public boolean isThematicMapShowPointDataProperties()
  {
    return thematicMapShowPointDataProperties;
  }

  public void setThematicMapShowPointDataProperties(boolean thematicMapShowPointDataProperties)
  {
    this.thematicMapShowPointDataProperties = thematicMapShowPointDataProperties;
  }

  public boolean isThematicMapShowAreaProperties()
  {
    return thematicMapShowAreaProperties;
  }

  public void setThematicMapShowAreaProperties(boolean thematicMapShowAreaProperties)
  {
    this.thematicMapShowAreaProperties = thematicMapShowAreaProperties;
  }

  public boolean isThematicMapShowMarkerProperties()
  {
    return thematicMapShowMarkerProperties;
  }

  public void setThematicMapShowMarkerProperties(boolean thematicMapShowMarkerProperties)
  {
    this.thematicMapShowMarkerProperties = thematicMapShowMarkerProperties;
  }

  public ThematicMapProperties getThematicMapAreaMarkerProperties()
  {
    return thematicMapAreaMarkerProperties;
  }

  public void setThematicMapAreaMarkerProperties(ThematicMapProperties thematicMapAreaMarkerProperties)
  {
    this.thematicMapAreaMarkerProperties = thematicMapAreaMarkerProperties;
  }

  public void setSelectedValuesInlineStyle(String selectedValuesInlineStyle)
  {
    this.selectedValuesInlineStyle = selectedValuesInlineStyle;
  }

  public String getSelectedValuesInlineStyle()
  {
    return selectedValuesInlineStyle;
  }

  public void setSelectedValuesInitialValue(String selectedValuesInitialValue)
  {
    this.selectedValuesInitialValue = selectedValuesInitialValue;
  }

  public String getSelectedValuesInitialValue()
  {
    return selectedValuesInitialValue;
  }

  public void setRatingGaugeProperties(RatingGaugeProperties ratingGaugeProperties)
  {
    this.ratingGaugeProperties = ratingGaugeProperties;
  }

  public RatingGaugeProperties getRatingGaugeProperties()
  {
    return ratingGaugeProperties;
  }

  public void setThematicMapCustomMapProperties(ThematicMapProperties thematicMapCustomMapProperties)
  {
    this.thematicMapCustomMapProperties = thematicMapCustomMapProperties;
  }

  public ThematicMapProperties getThematicMapCustomMapProperties()
  {
    return thematicMapCustomMapProperties;
  }

  public void setThematicMapCustomMarkerProperties(ThematicMapProperties thematicMapCustomMarkerProperties)
  {
    this.thematicMapCustomMarkerProperties = thematicMapCustomMarkerProperties;
  }

  public ThematicMapProperties getThematicMapCustomMarkerProperties()
  {
    return thematicMapCustomMarkerProperties;
  }

  public void setThematicMapShowAreaShortDesc(boolean thematicMapShowAreaShortDesc)
  {
    this.thematicMapShowAreaShortDesc = thematicMapShowAreaShortDesc;
  }

  public boolean isThematicMapShowAreaShortDesc()
  {
    return thematicMapShowAreaShortDesc;
  }

  public void setThematicMapShowMarkerValue(boolean thematicMapShowMarkerValue)
  {
    this.thematicMapShowMarkerValue = thematicMapShowMarkerValue;
  }

  public boolean isThematicMapShowMarkerValue()
  {
    return thematicMapShowMarkerValue;
  }

  public void setThematicMapShowMarkerShortDesc(boolean thematicMapShowMarkerShortDesc)
  {
    this.thematicMapShowMarkerShortDesc = thematicMapShowMarkerShortDesc;
  }

  public boolean isThematicMapShowMarkerShortDesc()
  {
    return thematicMapShowMarkerShortDesc;
  }

  public void setThematicMapShowMapsProperties(boolean thematicMapShowMapsProperties)
  {
    this.thematicMapShowMapsProperties = thematicMapShowMapsProperties;
  }

  public boolean isThematicMapShowMapsProperties()
  {
    return thematicMapShowMapsProperties;
  }

  public void setThematicMapSwitcherProperties(ThematicMapProperties thematicMapSwitcherProperties)
  {
    this.thematicMapSwitcherProperties = thematicMapSwitcherProperties;
  }

  public ThematicMapProperties getThematicMapSwitcherProperties()
  {
    return thematicMapSwitcherProperties;
  }

  public void setTreemapProperties(TreeviewProperties treemapProperties)
  {
    this.treemapProperties = treemapProperties;
  }

  public TreeviewProperties getTreemapProperties()
  {
    return treemapProperties;
  }

  public void setSunburstProperties(TreeviewProperties sunburstProperties)
  {
    this.sunburstProperties = sunburstProperties;
  }

  public TreeviewProperties getSunburstProperties()
  {
    return sunburstProperties;
  }

  public void setHostedMode(boolean hostedMode)
  {
    this.hostedMode = hostedMode;
  }

  public boolean isHostedMode()
  {
    return hostedMode;
  }

  public ChartProperties getDrillingProperties()
  {
    return drillingProperties;
  }

  public void setDrillingProperties(ChartProperties drillingProperties)
  {
    this.drillingProperties = drillingProperties;
  }

  public ChartProperties getStockChartProperties()
  {
    return stockChartProperties;
  }

  public void setStockChartProperties(ChartProperties stockChartProperties)
  {
    this.stockChartProperties = stockChartProperties;
  }

  public void setCommonLegendProperties(LegendProperties commonLegendProperties)
  {
    this.commonLegendProperties = commonLegendProperties;
  }

  public LegendProperties getCommonLegendProperties()
  {
    return commonLegendProperties;
  }

  public void setCommonLegendSectionProperties(LegendProperties commonLegendSectionProperties)
  {
    this.commonLegendSectionProperties = commonLegendSectionProperties;
  }

  public LegendProperties getCommonLegendSectionProperties()
  {
    return commonLegendSectionProperties;
  }

  public void setCommonLegendItemProperties(LegendProperties commonLegendItemProperties)
  {
    this.commonLegendItemProperties = commonLegendItemProperties;
  }

  public LegendProperties getCommonLegendItemProperties()
  {
    return commonLegendItemProperties;
  }

  public String validateAndGoBack()
  {
    final String value = getELValue(VALUE_PROPERTY_EL);
    final String min = getELValue(MIN_PROPERTY_EL);
    final String max = getELValue(MAX_PROPERTY_EL);

    if (!min.isEmpty())
    {
      if (Float.parseFloat(value) < Float.parseFloat(min))
      {
        throw new AdfException("Value should not be less than minValue.", AdfException.ERROR);
      }
    }

    if (!max.isEmpty())
    {
      if (Float.parseFloat(value) > Float.parseFloat(max))
      {
        throw new AdfException("Value should not be greater than maxValue", AdfException.ERROR);
      }
    }

    return BACK_ACTION;
  }

  private String getELValue(final String elExpression)
  {
    final ValueExpression ve = AdfmfJavaUtilities.getValueExpression(elExpression, String.class);
    final Object ret = ve.getValue(AdfmfJavaUtilities.getELContext());
    return (String) ret;
  }
  
  private static final String VALUE_PROPERTY_EL = "#{pageFlowScope.value}";
  private static final String MIN_PROPERTY_EL = "#{pageFlowScope.minValue}";
  private static final String MAX_PROPERTY_EL = "#{pageFlowScope.maxValue}";
  
  private static final String BACK_ACTION = "__back";
  
}
