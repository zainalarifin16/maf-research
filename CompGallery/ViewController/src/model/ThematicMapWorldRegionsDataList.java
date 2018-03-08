package model;

import java.util.ArrayList;
import java.util.List;

public class ThematicMapWorldRegionsDataList {

    private static List<ThematicMapWorldRegionsData> s_dataList = null;

    public ThematicMapWorldRegionsDataList() {
        if (s_dataList == null) {
            s_dataList = new ArrayList<ThematicMapWorldRegionsData>();
            s_dataList.add(new ThematicMapWorldRegionsData("APAC","Category1","Asia Pacific"));
            s_dataList.add(new ThematicMapWorldRegionsData("EMEA","Category2","Europe, Middle East, Africa"));
            s_dataList.add(new ThematicMapWorldRegionsData("LAT","Category3","Latin America"));
            s_dataList.add(new ThematicMapWorldRegionsData("NA","Category4","North America"));
        }
    }

    public List<ThematicMapWorldRegionsData> getThematicMapWorldRegionsData() {
        return s_dataList;
    }

    public int getThematicMapWorldRegionsDataCount() {
        return s_dataList.size();
    }
}