package model;

import java.util.ArrayList;

public class RangeDataList
{

  private static ArrayList<RangeData> s_data;

  public RangeDataList()
  {
    if (s_data == null)
      s_data = new ArrayList<RangeData>();
    
    s_data.add(new RangeData("Group A", "Series 1", 17, 25));
    s_data.add(new RangeData("Group B", "Series 1", 15, 23));
    s_data.add(new RangeData("Group C", "Series 1", 12, 19));
    s_data.add(new RangeData("Group D", "Series 1", 8, 13));
    s_data.add(new RangeData("Group E", "Series 1", 2, 5));      
    s_data.add(new RangeData("Group A", "Series 2", 9, 15));
    s_data.add(new RangeData("Group B", "Series 2", 19, 27));
    s_data.add(new RangeData("Group C", "Series 2", 25, 32));
    s_data.add(new RangeData("Group D", "Series 2", 21, 29));
    s_data.add(new RangeData("Group E", "Series 2", 14, 23));      
  }
  
  public RangeData[] getRangeData() {
    RangeData[] data = s_data.toArray(new RangeData[s_data.size()]);
    return data;
  }
  
  public int getRangeDataCount() {
    return s_data.size();
  }
  
}
