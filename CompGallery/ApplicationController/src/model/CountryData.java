package model;

public class CountryData
{
  private String country;
  private long area;
  
  public CountryData(String country, long area)
  {
    this.setCountry(country);
    this.setArea(area);
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public long getArea()
  {
    return area;
  }

  public void setArea(long area)
  {
    this.area = area;
  }
}
