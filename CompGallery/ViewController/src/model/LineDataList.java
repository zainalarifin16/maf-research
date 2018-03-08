package model;

import java.util.ArrayList;
import java.util.List;


public class LineDataList {
    
    private static List<LineData> s_lineDataList = null;
    
    public LineDataList() {
        super();
        
        if (s_lineDataList == null) {
            s_lineDataList = new ArrayList<LineData>();
            
            s_lineDataList.add(new LineData("Group A", "Series 1", 74));
            s_lineDataList.add(new LineData("Group B", "Series 1", 62));
            s_lineDataList.add(new LineData("Group C", "Series 1", 70));
            s_lineDataList.add(new LineData("Group D", "Series 1", 76));
            s_lineDataList.add(new LineData("Group E", "Series 1", 66));
            s_lineDataList.add(new LineData("Group A", "Series 2", 50));
            s_lineDataList.add(new LineData("Group B", "Series 2", 38));
            s_lineDataList.add(new LineData("Group C", "Series 2", 46));
            s_lineDataList.add(new LineData("Group D", "Series 2", 54));
            s_lineDataList.add(new LineData("Group E", "Series 2", 42));
            s_lineDataList.add(new LineData("Group A", "Series 3", 34));
            s_lineDataList.add(new LineData("Group B", "Series 3", 22));
            s_lineDataList.add(new LineData("Group C", "Series 3", 30));
            s_lineDataList.add(new LineData("Group D", "Series 3", 32));
            s_lineDataList.add(new LineData("Group E", "Series 3", 26));
            s_lineDataList.add(new LineData("Group A", "Series 4", 18));
            s_lineDataList.add(new LineData("Group B", "Series 4",  6));
            s_lineDataList.add(new LineData("Group C", "Series 4", 14));
            s_lineDataList.add(new LineData("Group D", "Series 4", 22));
            s_lineDataList.add(new LineData("Group E", "Series 4", 10));
            s_lineDataList.add(new LineData("Group A", "Series 5",  3));
            s_lineDataList.add(new LineData("Group B", "Series 5",  2));            
            s_lineDataList.add(new LineData("Group C", "Series 5",  3));            
            s_lineDataList.add(new LineData("Group D", "Series 5",  3));            
            s_lineDataList.add(new LineData("Group E", "Series 5",  2));            
        }        
    }
    
    public List<LineData> getLineData() {
        return s_lineDataList;
    }
    
    public int getLineDataCount() {
        return s_lineDataList.size();
    }
}
