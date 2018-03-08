package model;

/**
 * @author Michal Drozd
 */
public class StockReferenceData
{
  private double value;
  private long x;

  public StockReferenceData(double value, long x)
  {
    this.x = x;
    this.value = value;
  }

  public double getValue()
  {
    return value;
  }

  public void setValue(double value)
  {
    this.value = value;
  }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }
}
