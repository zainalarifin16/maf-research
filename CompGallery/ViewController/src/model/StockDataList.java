package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import oracle.adfmf.amx.event.SelectionEvent;

public class StockDataList
{

  private static List<StockData> s_stockDataList = null;

  public StockDataList()
  {
    super();

    Calendar calendar = Calendar.getInstance();
    calendar.set(2010, 1, 1);
    Date date;
    double val1;
    double val2;
    double val3;

    if (s_stockDataList == null)
    {
      s_stockDataList = new ArrayList<StockData>();

      for (int i = 0; i < 36; i++)
      {
        date = calendar.getTime();
        val1 = 30.0 + (Math.random() - 0.5) * 16.0;
        val2 = 18.0 + (Math.random() - 0.5) * 20.0;
        val3 = 24.0 + (Math.random() - 0.5) * 10.0;
        s_stockDataList.add(new StockData("ABCD", date, val1));
        s_stockDataList.add(new StockData("EFGH", date, val2));
        s_stockDataList.add(new StockData("IJKL", date, val3));
        calendar.add(Calendar.MONTH, 1);
      }
    }
  }

  public List<StockData> getStockData()
  {
    return s_stockDataList;
  }

  public int getStockDataCount()
  {
    return s_stockDataList.size();
  }

  public void selectionListener(SelectionEvent se)
  {

  }
  /*
    public void viewportChangeListener(oracle.adfmf.amx.event.ViewportChangeEvent vce)
    {
      System.out.println("ViewportChangeEvent -- xMin: " + vce.getXMin() + ", xMax: " + vce.getXMax());
    }
*/
  
/*  
  public static void main(String[] args) 
  {
    new StockDataList();
    
    System.out.println("    \"stockData\" : {");
    System.out.println("        \"collectionModel\" : {");
    System.out.println("            \".type\" : \"TreeBindings\",");
    System.out.println("            \"id\" : \"bindings.stockData\",");
    System.out.println("            \"treeNodeBindings\" : {");
    System.out.println("                \".type\" : \"TreeNodeBindings\",");
    System.out.print("                \"keys\" : [ ");
    for (int j = 0; j < s_stockDataList.size(); j++) {
      if (j == 0)
        System.out.print("\"" + j + "\"");
      else
        System.out.print(", \"" + j + "\"");
    }
    System.out.println(" ],");
    System.out.println("                \"providers\" : {");
    for (int j = 0; j < s_stockDataList.size(); j++) {
      StockData item = (StockData)s_stockDataList.get(j);
      System.out.println("                    \"" + j + "\" : { \"name\" : \"" + item.getName() + "\", "
                         + "\"date\" : " + item.getDate().getTime() + ", \"value\" : " 
                         + item.getValue() + " },");
    }
    System.out.println("                }\n" + 
    "            }\n" + 
    "        }\n" + 
    "    }");
  }
*/
  
}
