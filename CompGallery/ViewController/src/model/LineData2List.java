package model;

import java.util.ArrayList;
import java.util.List;


public class LineData2List {
    
    private static List<LineData2> s_lineDataList = null;
    
    public LineData2List() {
        super();
        
        if (s_lineDataList == null) {
            s_lineDataList = new ArrayList<LineData2>();
            
            s_lineDataList.add(new LineData2("Group A", "Series 1", 74, "square", "#EF0000", "#113355", 2, "solid"));
            s_lineDataList.add(new LineData2("Group B", "Series 1", 62, "circle", "#00EF00", "#113355", 2, "solid"));
            s_lineDataList.add(new LineData2("Group C", "Series 1", 70, "triangleUp", "#0000EF", "#113355", 2, "solid"));
            s_lineDataList.add(new LineData2("Group D", "Series 1", 76, "triangleDown", "#EFEF00", "#113355", 2, "solid"));
            s_lineDataList.add(new LineData2("Group E", "Series 1", 66, "diamond", "#EF00EF", "#113355", 2, "solid"));
            s_lineDataList.add(new LineData2("Group A", "Series 2", 50, "square", "#EF0000", "#884422", 4, "dashed"));
            s_lineDataList.add(new LineData2("Group B", "Series 2", 38, "circle", "#00EF00", "#884422", 4, "dashed"));
            s_lineDataList.add(new LineData2("Group C", "Series 2", 46, "triangleUp", "#0000EF", "#884422", 4, "dashed"));
            s_lineDataList.add(new LineData2("Group D", "Series 2", 54, "triangleDown", "#EFEF00", "#884422", 4, "dashed"));
            s_lineDataList.add(new LineData2("Group E", "Series 2", 42, "diamond", "#EF00EF", "#884422", 4, "dashed"));
            s_lineDataList.add(new LineData2("Group A", "Series 3", 34, "square", "#EF0000", "#88AAEE", 3, "doted"));
            s_lineDataList.add(new LineData2("Group B", "Series 3", 22, "circle", "#00EF00", "#88AAEE", 3, "doted"));
            s_lineDataList.add(new LineData2("Group C", "Series 3", 30, "triangleUp", "#0000EF", "#88AAEE", 3, "doted"));
            s_lineDataList.add(new LineData2("Group D", "Series 3", 32, "triangleDown", "#EFEF00", "#88AAEE", 3, "doted"));
            s_lineDataList.add(new LineData2("Group E", "Series 3", 26, "diamond", "#EF00EF", "#88AAEE", 3, "doted"));
            s_lineDataList.add(new LineData2("Group A", "Series 4", 18, "square", "#EF0000", "#EEAA77", 2, "dashed"));
            s_lineDataList.add(new LineData2("Group B", "Series 4",  6, "circle", "#00EF00", "#EEAA77", 2, "dashed"));
            s_lineDataList.add(new LineData2("Group C", "Series 4", 14, "triangleUp", "#0000EF", "#EEAA77", 2, "dashed"));
            s_lineDataList.add(new LineData2("Group D", "Series 4", 22, "triangleDown", "#EFEF00", "#EEAA77", 2, "dashed"));
            s_lineDataList.add(new LineData2("Group E", "Series 4", 10, "diamond", "#EF00EF", "#EEAA77", 2, "dashed"));
            s_lineDataList.add(new LineData2("Group A", "Series 5",  3, "square", "#EF0000", "#33CC66", 4, "doted"));
            s_lineDataList.add(new LineData2("Group B", "Series 5",  2, "circle", "#00EF00", "#33CC66", 4, "doted"));            
            s_lineDataList.add(new LineData2("Group C", "Series 5",  3, "triangleUp", "#0000EF", "#33CC66", 4, "doted"));            
            s_lineDataList.add(new LineData2("Group D", "Series 5",  3, "triangleDown", "#EFEF00", "#33CC66", 4, "doted"));            
            s_lineDataList.add(new LineData2("Group E", "Series 5",  2, "diamond", "#EF00EF", "#33CC66", 4, "doted"));            
        }        
    }
    
    public List<LineData2> getLineData() {
        return s_lineDataList;
    }
    
    public int getLineDataCount() {
        return s_lineDataList.size();
    }
}
