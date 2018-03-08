package model;

public class FunnelData
{
  private String label;
  private double value;
  private double targetValue;
  private String shortDesc;
  private String color;
  private String borderColor;

  public FunnelData()
  {
    super();
  }

  public FunnelData(String label, double value, double targetValue, String color, String borderColor, String shortDesc)
  {
    this.label = label;
    this.value = value;
    this.shortDesc = shortDesc;
    this.targetValue = targetValue;
    this.color = color;
    this.borderColor = borderColor;
  }

  public String getLabel()
  {
    return label;
  }

  public void setLabel(String label)
  {
    this.label = label;
  }

  public double getValue()
  {
    return value;
  }

  public void setValue(double value)
  {
    this.value = value;
  }

  public double getTargetValue()
  {
    return targetValue;
  }

  public void setTargetValue(double targetValue)
  {
    this.targetValue = targetValue;
  }

  public String getShortDesc()
  {
    return shortDesc;
  }

  public void setShortDesc(String shortDesc)
  {
    this.shortDesc = shortDesc;
  }

  public void setColor(String color)
  {
    this.color = color;
  }

  public void setBorderColor(String color)
  {
    this.borderColor = color;
  }
  public String getColor()
  {
    return color;
  }
  public String getBorderColor()
  {
    return borderColor;
  }  
}
