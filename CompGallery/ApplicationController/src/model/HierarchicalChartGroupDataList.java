package model;

import java.util.ArrayList;
import java.util.List;

public class HierarchicalChartGroupDataList {

    private final List<HierarchicalChartGroupData> dataList;

    public HierarchicalChartGroupDataList() {
        super();

        dataList = new ArrayList<>();

        dataList.add(new HierarchicalChartGroupData("2010", "Q1", "Series 1", 42));
        dataList.add(new HierarchicalChartGroupData("2010", "Q2", "Series 1", 55));
        dataList.add(new HierarchicalChartGroupData("2010", "Q3", "Series 1", 36));
        dataList.add(new HierarchicalChartGroupData("2010", "Q4", "Series 1", 22));
        dataList.add(new HierarchicalChartGroupData("2011", "Q1", "Series 1", 34));
        dataList.add(new HierarchicalChartGroupData("2011", "Q2", "Series 1", 30));
        dataList.add(new HierarchicalChartGroupData("2011", "Q3", "Series 1", 50));
        dataList.add(new HierarchicalChartGroupData("2011", "Q4", "Series 1", 46));

        dataList.add(new HierarchicalChartGroupData("2010", "Q1", "Series 2", 24));
        dataList.add(new HierarchicalChartGroupData("2010", "Q2", "Series 2", 55));
        dataList.add(new HierarchicalChartGroupData("2010", "Q3", "Series 2", 63));
        dataList.add(new HierarchicalChartGroupData("2010", "Q4", "Series 2", 22));
        dataList.add(new HierarchicalChartGroupData("2011", "Q1", "Series 2", 43));
        dataList.add(new HierarchicalChartGroupData("2011", "Q2", "Series 2", 3));
        dataList.add(new HierarchicalChartGroupData("2011", "Q3", "Series 2", 5));
        dataList.add(new HierarchicalChartGroupData("2011", "Q4", "Series 2", 64));

    }

    public List<HierarchicalChartGroupData> getData() {
        return dataList;
    }

    public int getDataCount() {
        return dataList.size();
    }

}
