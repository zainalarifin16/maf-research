package mobile;

import javax.el.ValueExpression;

import model.PictoChartData;
import model.PictoChartDataList;

import oracle.adfmf.amx.event.SelectionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class PictoChartProperties
{
  private String animationDuration = "";
  private String animationOnDataChange = "none";
  private String animationOnDisplay = "none";
  private String columnCount = "12";
  private String columnWidth = "";
  private String dataSelection = "single";
  private String drilling = "off";
  private String emptyText = "";
  private String inlineStyle = "";
  private String layout = "horizontal";
  private String layoutOrigin = "topStart";
  private String rendered = "true";
  private String rolloverBehavior = "none";
  private String rolloverBehaviorDelay = "1000";
  private String rowCount = "12";
  private String rowHeight = "";
  private String selectedRowKeys = "";
  private String shortDesc = "";
  private String styleClass = "";

  private String borderColor = "black";
  private String borderWidth = "2";
  private String shape = "square";
  private String color1 = "#800000";
  private String count1 = "3";
  private String span1 = "4";
  private String color2 = "#FF0000";
  private String count2 = "15";
  private String span2 = "2";
  private String color3 = "#EA0000";
  private String count3 = "33";
  private String span3 = "1";
  
  public PictoChartProperties()
  {
    super();
  }

  public void setAnimationDuration(String animationDuration) {
      this.animationDuration = animationDuration;
  }

  public String getAnimationDuration() {
      return animationDuration;
  }
  
  public void setAnimationOnDataChange(String animationOnDataChange) {
      this.animationOnDataChange = animationOnDataChange;
  }

  public String getAnimationOnDataChange() {
      return animationOnDataChange;
  }

  public void setAnimationOnDisplay(String animationOnDisplay) {
      this.animationOnDisplay = animationOnDisplay;
  }

  public String getAnimationOnDisplay() {
      return animationOnDisplay;
  }

  public void setColumnCount(String columnCount)
  {
    this.columnCount = columnCount;
  }

  public String getColumnCount()
  {
    return columnCount;
  }

  public void setColumnWidth(String columnWidth)
  {
    this.columnWidth = columnWidth;
  }

  public String getColumnWidth()
  {
    return columnWidth;
  }

  public void setDataSelection(String dataSelection)
  {
    this.dataSelection = dataSelection;
  }

  public String getDataSelection()
  {
    return dataSelection;
  }

  public void setDrilling(String drilling)
  {
    this.drilling = drilling;
  }

  public String getDrilling()
  {
    return drilling;
  }

  public void setEmptyText(String emptyText)
  {
    this.emptyText = emptyText;
  }

  public String getEmptyText()
  {
    return emptyText;
  }

  public void setInlineStyle(String inlineStyle)
  {
    this.inlineStyle = inlineStyle;
  }

  public String getInlineStyle()
  {
    return inlineStyle;
  }

  public void setLayout(String layout)
  {
    this.layout = layout;
  }

  public String getLayout()
  {
    return layout;
  }

  public void setLayoutOrigin(String layoutOrigin)
  {
    this.layoutOrigin = layoutOrigin;
  }

  public String getLayoutOrigin()
  {
    return layoutOrigin;
  }

  public void setRendered(String rendered)
  {
    this.rendered = rendered;
  }

  public String getRendered()
  {
    return rendered;
  }

  public void setRolloverBehavior(String rolloverBehavior)
  {
    this.rolloverBehavior = rolloverBehavior;
  }

  public String getRolloverBehavior()
  {
    return rolloverBehavior;
  }

  public void setRolloverBehaviorDelay(String rolloverBehaviorDelay)
  {
    this.rolloverBehaviorDelay = rolloverBehaviorDelay;
  }

  public String getRolloverBehaviorDelay()
  {
    return rolloverBehaviorDelay;
  }

  public void setRowCount(String rowCount)
  {
    this.rowCount = rowCount;
  }

  public String getRowCount()
  {
    return rowCount;
  }

  public void setRowHeight(String rowHeight)
  {
    this.rowHeight = rowHeight;
  }

  public String getRowHeight()
  {
    return rowHeight;
  }

  public void setSelectedRowKeys(String selectedRowKeys)
  {
    this.selectedRowKeys = selectedRowKeys;
  }

  public String getSelectedRowKeys()
  {
    return selectedRowKeys;
  }

  public void setShortDesc(String shortDesc)
  {
    this.shortDesc = shortDesc;
  }

  public String getShortDesc()
  {
    return shortDesc;
  }

  public void setStyleClass(String styleClass)
  {
    this.styleClass = styleClass;
  }

  public String getStyleClass()
  {
    return styleClass;
  }

  public void setBorderColor(String borderColor)
  {
    this.borderColor = borderColor;
  }

  public String getBorderColor()
  {
    return borderColor;
  }

  public void setBorderWidth(String borderWidth)
  {
    this.borderWidth = borderWidth;
  }

  public String getBorderWidth()
  {
    return borderWidth;
  }

  public void setShape(String shape)
  {
    this.shape = shape;
  }

  public String getShape()
  {
    return shape;
  }

  public void setColor1(String color1)
  {
    this.color1 = color1;
  }

  public String getColor1()
  {
    return color1;
  }

  public void setCount1(String count1)
  {
    this.count1 = count1;
  }

  public String getCount1()
  {
    return count1;
  }

  public void setSpan1(String span1)
  {
    this.span1 = span1;
  }

  public String getSpan1()
  {
    return span1;
  }

  public void setColor2(String color2)
  {
    this.color2 = color2;
  }

  public String getColor2()
  {
    return color2;
  }

  public void setCount2(String count2)
  {
    this.count2 = count2;
  }

  public String getCount2()
  {
    return count2;
  }

  public void setSpan2(String span2)
  {
    this.span2 = span2;
  }

  public String getSpan2()
  {
    return span2;
  }

  public void setColor3(String color3)
  {
    this.color3 = color3;
  }

  public String getColor3()
  {
    return color3;
  }

  public void setCount3(String count3)
  {
    this.count3 = count3;
  }

  public String getCount3()
  {
    return count3;
  }

  public void setSpan3(String span3)
  {
    this.span3 = span3;
  }

  public String getSpan3()
  {
    return span3;
  }
  
  private void setName (PictoChartData[] site, SelectionEvent se) 
  {
    String value = "";
    if (se.getSelectedRowKeys().length > 0) {
      int i = Integer.parseInt (se.getSelectedRowKeys()[0]);
      value = site [i].getName ();
    }
    ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.name}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), value);
  }
  
  private void setDepartment (PictoChartData[] site, SelectionEvent se) 
  {
    String value = "";
    if (se.getSelectedRowKeys().length > 0) {
      int i = Integer.parseInt (se.getSelectedRowKeys()[0]);
      value = site [i].getDepartment ();
    }
    ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.department}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), value);
    
    if (site != PRG1) {
      ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.selectedRowKeysPRG1}", String.class);
      ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    }
    if (site != PRG2) {
      ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.selectedRowKeysPRG2}", String.class);
      ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    }
    if (site != DEN) {
      ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.selectedRowKeysDEN}", String.class);
      ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    }
    if (site != SFO) {
      ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.selectedRowKeysSFO}", String.class);
      ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    }
    if (site != NYC) {
      ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.selectedRowKeysNYC}", String.class);
      ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    }
  }
  
  private PictoChartData[] PRG1 = new PictoChartDataList ().getPictoChartPRG1DataList();
  private PictoChartData[] PRG2 = new PictoChartDataList ().getPictoChartPRG2DataList();
  private PictoChartData[] DEN = new PictoChartDataList ().getPictoChartDENDataList();
  private PictoChartData[] SFO = new PictoChartDataList ().getPictoChartSFODataList();
  private PictoChartData[] NYC = new PictoChartDataList ().getPictoChartNYCDataList();
  
  public void selectionListenerPRG1(SelectionEvent se)
  {
    setName (PRG1, se);
    setDepartment (PRG1, se);
  }
  
  public void selectionListenerPRG2(SelectionEvent se)
  {
    setName (PRG2, se);
    setDepartment (PRG2, se);
  }
  
  public void selectionListenerDEN(SelectionEvent se)
  {
    setName (DEN, se);
    setDepartment (DEN, se);
  }
  
  public void selectionListenerSFO(SelectionEvent se)
  {
    setName (SFO, se);
    setDepartment (SFO, se);
  }
  
  public void selectionListenerNYC(SelectionEvent se)
  {
    setName (NYC, se);
    setDepartment (NYC, se);
  }
}
