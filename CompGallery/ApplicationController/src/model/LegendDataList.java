package model;

import java.util.ArrayList;
import java.util.List;

public class LegendDataList
{
  private final List<BarData> model1;
  private final List<PieData> model2;
  private final List<LegendData> legendData;

  public LegendDataList()
  {
    model1 = new ArrayList<>();

    model1.add(new BarData("Group A", "Bar 1", 42));
    model1.add(new BarData("Group B", "Bar 1", 34));
    model1.add(new BarData("Group A", "Bar 2", 55));
    model1.add(new BarData("Group B", "Bar 2", 30));
    model1.add(new BarData("Group A", "Bar 3", 36));
    model1.add(new BarData("Group B", "Bar 3", 50));
    model1.add(new BarData("Group A", "Bar 4", 22));
    model1.add(new BarData("Group B", "Bar 4", 46));
    model1.add(new BarData("Group A", "Bar 5", 38));
    model1.add(new BarData("Group B", "Bar 5", 52));
    model1.add(new BarData("Group A", "Bar 6", 18));
    model1.add(new BarData("Group B", "Bar 6", 42));

    model2 = new ArrayList<>();

    model2.add(new PieData("Slice 1", 42, 20));
    model2.add(new PieData("Slice 2", 55, 0));
    model2.add(new PieData("Slice 3", 36, 0));
    model2.add(new PieData("Slice 4", 22, 0));

    legendData = new ArrayList<>();

    legendData.add(new LegendData("Item 1", "green", "triangleUp"));
    legendData.add(new LegendData("Item 2", "blue", "circle"));
    legendData.add(new LegendData("Item 3", "red", "triangleDown"));
  }

  public List<BarData> getModel1()
  {
    return model1;
  }

  public List<PieData> getModel2()
  {
    return model2;
  }

  public List<LegendData> getLegendData()
  {
    return legendData;
  }
}
