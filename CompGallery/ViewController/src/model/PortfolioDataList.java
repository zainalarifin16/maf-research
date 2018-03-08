package model;

import java.util.ArrayList;
import java.util.List;

public class PortfolioDataList
{

  private static ArrayList<BubbleData> s_data;

  public PortfolioDataList()
  {
    if (s_data == null)
      s_data = new ArrayList<BubbleData>();
    
    s_data.add(new BubbleData("ORCL", "Change", 0, 2.95, 3100));
    s_data.add(new BubbleData("YHOO", "Change", 0, -0.85, 2000));
    s_data.add(new BubbleData("MSFT", "Change", 0, -0.75, 1700));
    s_data.add(new BubbleData("APPL", "Change", 0, 1.88, 2800));
    s_data.add(new BubbleData("INTC", "Change", 0, 2.33, 500));      
  }
  
  public List<BubbleData> getPortfolioData() {
    return s_data;
  }
  
  public int getPortfolioDataCount() {
    return s_data.size();
  }
  
}
