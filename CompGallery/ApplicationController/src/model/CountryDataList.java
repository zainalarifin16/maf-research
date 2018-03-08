package model;

import java.util.ArrayList;
import java.util.List;

public class CountryDataList
{
  
  private static ArrayList<CountryData> s_countries;
  
  public CountryDataList()
  {
    if (s_countries == null)
      s_countries = new ArrayList<CountryData>();
        
    s_countries.add(new CountryData("Algeria", 2381740L));
    s_countries.add(new CountryData("Argentina", 2766890L));
    s_countries.add(new CountryData("Australia", 7692024L));
    s_countries.add(new CountryData("Brazil", 8515767L));
    s_countries.add(new CountryData("Canada", 9889000L));
    // s_countries.add(new CountryData("Chad", 1284000L));
    s_countries.add(new CountryData("China", 9615767L));
    s_countries.add(new CountryData("Congo", 2345410L));
    s_countries.add(new CountryData("India", 3287590L));
    // s_countries.add(new CountryData("Indonesia", 1904556L));
    // s_countries.add(new CountryData("Iran", 1648000L));
    s_countries.add(new CountryData("Kazakhstan", 2727300L));
    // s_countries.add(new CountryData("Libya", 1759540L));
    // s_countries.add(new CountryData("Mexico", 1972550L));
    // s_countries.add(new CountryData("Mongolia", 1565000L));
    // s_countries.add(new CountryData("Niger", 1267000L));
    // s_countries.add(new CountryData("Peru", 1285220L));
    s_countries.add(new CountryData("Russia", 17098242L));
    s_countries.add(new CountryData("Saudi Arabia", 2149690L));
    // s_countries.add(new CountryData("Sudan", 1861484L));
    s_countries.add(new CountryData("United States", 9862675L));
  }
  
  public List<CountryData> getCountryData() {
    return s_countries;
  }
  
  public int getCountryDataCount() {
    return s_countries.size();
  }
  
  
}
