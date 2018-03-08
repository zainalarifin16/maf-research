package model;

import java.util.ArrayList;
import java.util.List;


public class BubbleDataList {
    
    private static List<BubbleData> s_bubbleDataList = null;
    
    public BubbleDataList() {
        super();
        
        if (s_bubbleDataList == null) {
            s_bubbleDataList = new ArrayList<BubbleData>();
            
            s_bubbleDataList.add(new BubbleData("Group A", "Series 1", 15, 25, 5));
            s_bubbleDataList.add(new BubbleData("Group B", "Series 1", 25, 30, 12));
            s_bubbleDataList.add(new BubbleData("Group C", "Series 1", 25, 45, 12));
            s_bubbleDataList.add(new BubbleData("Group A", "Series 2", 15, 15, 8));
            s_bubbleDataList.add(new BubbleData("Group B", "Series 2", 20, 35, 14));
            s_bubbleDataList.add(new BubbleData("Group C", "Series 2", 40, 55, 35));
            s_bubbleDataList.add(new BubbleData("Group A", "Series 3", 10, 10, 8));
            s_bubbleDataList.add(new BubbleData("Group B", "Series 3", 18, 55, 10));
            s_bubbleDataList.add(new BubbleData("Group C", "Series 3", 40, 50, 18));
            s_bubbleDataList.add(new BubbleData("Group A", "Series 4", 8, 20, 6));
            s_bubbleDataList.add(new BubbleData("Group B", "Series 4", 11, 30, 8));
            s_bubbleDataList.add(new BubbleData("Group C", "Series 4", 30, 40, 15));
        }        
    }
    
    public List<BubbleData> getBubbleData() {
        return s_bubbleDataList;
    }

    public int getBubleDataCount() {
        return s_bubbleDataList.size();
    }
}
