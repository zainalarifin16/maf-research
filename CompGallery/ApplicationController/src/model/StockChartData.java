package model;

/**
 * Data container for dvtm:stockChart component
 * @author Michal Drozd (michal.drozd@oracle.com)
 */
public class StockChartData
{
  private double close;
  private double high;
  private double low;
  private double open;
  private long x;
  private long volume;
  private String id;

  public StockChartData()
  {
    super();
  }

  public StockChartData(double close, double high, double low, double open, long x, long volume)
  {
    this.close = close;
    this.high = high;
    this.low = low;
    this.open = open;
    this.x = x;
    this.volume = volume;
  }

  public double getClose()
  {
    return close;
  }

  public void setClose(double close)
  {
    this.close = close;
  }

  public double getHigh()
  {
    return high;
  }

  public void setHigh(double high)
  {
    this.high = high;
  }

  public double getLow()
  {
    return low;
  }

  public void setLow(double low)
  {
    this.low = low;
  }

  public double getOpen()
  {
    return open;
  }

  public void setOpen(double open)
  {
    this.open = open;
  }

  public long getX()
  {
    return x;
  }

  public void setX(long x)
  {
    this.x = x;
  }

  public long getVolume()
  {
    return volume;
  }

  public void setVolume(long volume)
  {
    this.volume = volume;
  }
}
