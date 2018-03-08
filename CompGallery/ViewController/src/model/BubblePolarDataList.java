package model;

import java.util.ArrayList;
import java.util.List;


public class BubblePolarDataList {
    
    private static List<BubbleData> s_bubblePolarDataList = null;
    
    public BubblePolarDataList() {
        super();
        
        if (s_bubblePolarDataList == null) {
            s_bubblePolarDataList = new ArrayList<BubbleData>();
            
            s_bubblePolarDataList.add(new BubbleData("Group A", "Series 1", 15, 7, 5));
            s_bubblePolarDataList.add(new BubbleData("Group A", "Series 2", 4, 19, 7));
            s_bubblePolarDataList.add(new BubbleData("Group A", "Series 3", 20, 20, 1));
            s_bubblePolarDataList.add(new BubbleData("Group A", "Series 4", 10, 20, 3));
        }        
    }
    
    
    public List<BubbleData> getBubblePolarData() {
        return s_bubblePolarDataList;
    }
    
    
    public int getBubbleDataCount() {
        return s_bubblePolarDataList.size();
    }
}
