package model;

import java.util.ArrayList;
import java.util.List;

public class ThematicMapUSAStatesDataList {

    private static List<ThematicMapUSAStatesData> s_dataList = null;

    public ThematicMapUSAStatesDataList() {
        if (s_dataList == null) {
            s_dataList = new ArrayList<ThematicMapUSAStatesData>();
            s_dataList.add(new ThematicMapUSAStatesData("AL","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("AK","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("AZ","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("AR","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("CA","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("CO","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("CT","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("DC","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("DE","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("FL","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("GA","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("HI","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("ID","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("IL","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("IN","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("IA","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("KS","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("KY","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("LA","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("ME","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("MD","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("MA","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("MI","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("MN","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("MS","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("MO","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("MT","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("NE","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("NV","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("NH","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("NJ","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("NM","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("NY","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("NC","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("ND","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("OH","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("OK","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("OR","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("PA","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("RI","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("SC","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("SD","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("TN","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("TX","category1"));
            s_dataList.add(new ThematicMapUSAStatesData("UT","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("VT","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("VA","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("WA","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("WV","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("WI","category2"));
            s_dataList.add(new ThematicMapUSAStatesData("WY","category2"));
        }
    }

    public List<ThematicMapUSAStatesData> getThematicMapUSAStatesData() {
        return s_dataList;
    }

    public int getThematicMapUSAStatesDataCount() {
        return s_dataList.size();
    }
}