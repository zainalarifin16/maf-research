package model;

import java.util.ArrayList;
import java.util.List;

public class ThematicMapWorldContinentsDataList {

    private static List<ThematicMapWorldContinentsData> s_dataList = null;

    public ThematicMapWorldContinentsDataList() {
        if (s_dataList == null) {
            s_dataList = new ArrayList<ThematicMapWorldContinentsData>();
            s_dataList.add(new ThematicMapWorldContinentsData("AS","Category 1"));
            s_dataList.add(new ThematicMapWorldContinentsData("SA","Category 2"));
            s_dataList.add(new ThematicMapWorldContinentsData("NA","Category 3"));
            s_dataList.add(new ThematicMapWorldContinentsData("AF","Category 4"));
            s_dataList.add(new ThematicMapWorldContinentsData("EU","Category 5"));
            s_dataList.add(new ThematicMapWorldContinentsData("AN","Category 6"));
            s_dataList.add(new ThematicMapWorldContinentsData("AU","Category 7"));
        }
    }

    public List<ThematicMapWorldContinentsData> getThematicMapWorldContinentsData() {
        return s_dataList;
    }

    public int getThematicMapWorldContinentsDataCount() {
        return s_dataList.size();
    }
}