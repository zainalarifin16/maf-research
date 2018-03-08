package model;

public class RangeData
{
  private String group;
  private String series;      
  private double low;
  private double high; 
  
  public RangeData(String group, String series, double low, double high)
  {    
    this.group = group;
    this.series = series;
    this.low = low;
    this.high = high;
  }
  
  public void setGroup(String group)
  {
    this.group = group;
  }

  public String getGroup()
  {
    return group;
  }
  
  public void setSeries(String series)
  {
    this.series = series;
  }

  public String getSeries()
  {
    return series;
  }

  public void setLow(double low)
  {
    this.low = low;
  }

  public double getLow()
  {
    return low;
  }

  public void setHigh(double high)
  {
    this.high = high;
  }

  public double getHigh()
  {
    return high;
  }
  
}
