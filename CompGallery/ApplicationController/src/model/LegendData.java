package model;

public class LegendData
{
  private String text;
  private String color;
  private String shape;

  public LegendData(String text, String color, String shape)
  {
    super();
    this.text = text;
    this.color = color;
    this.shape = shape;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public String getText()
  {
    return text;
  }

  public void setColor(String color)
  {
    this.color = color;
  }

  public String getColor()
  {
    return color;
  }

  public void setShape(String shape)
  {
    this.shape = shape;
  }

  public String getShape()
  {
    return shape;
  }
}
