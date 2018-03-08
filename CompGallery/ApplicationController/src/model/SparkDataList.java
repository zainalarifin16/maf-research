package model;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;


public class SparkDataList {
    
    private static List<SparkData> s_sparkDataList = null;
    
    public SparkDataList() {
        super();
        
        if (s_sparkDataList == null) {
            s_sparkDataList = new ArrayList<SparkData>();
            
            s_sparkDataList.add(new SparkData(846080000000.0, 20, true, "#666699"));
            s_sparkDataList.add(new SparkData(856080000000.0, 25, false, ""));
            s_sparkDataList.add(new SparkData(866080000000.0, 15, false, ""));
            s_sparkDataList.add(new SparkData(876080000000.0, 10, true, "#FF0000"));
            s_sparkDataList.add(new SparkData(886080000000.0, 18, false, ""));
            s_sparkDataList.add(new SparkData(896080000000.0, 15, false, ""));
            s_sparkDataList.add(new SparkData(906080000000.0, 20, false, ""));
            s_sparkDataList.add(new SparkData(916080000000.0, 15, false, ""));
            s_sparkDataList.add(new SparkData(926080000000.0, 25, false, ""));
            s_sparkDataList.add(new SparkData(936080000000.0, 30, true, "#008000"));
            s_sparkDataList.add(new SparkData(946080000000.0, 20, false, ""));
            s_sparkDataList.add(new SparkData(956080000000.0, 18, false, ""));
            s_sparkDataList.add(new SparkData(966080000000.0, 25, false, ""));
            s_sparkDataList.add(new SparkData(976080000000.0, 28, false, ""));
            s_sparkDataList.add(new SparkData(986080000000.0, 30, true, "#666699"));
        }        
    }    
    
    public List<SparkData> getSparkData() {
        return s_sparkDataList;
    }
    
    public int getSparkDataCount() {
        return s_sparkDataList.size();
    }
    
    public void refreshChart(ActionEvent actionEvent) {
        // Add event code here...
        
        for (int i = 0; i < s_sparkDataList.size(); i++) {
            SparkData item = s_sparkDataList.get(i);
            item.setValue((int)Math.floor(Math.random() * 30));
        }
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.sparkDataIterator}", Object.class);
        AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding)ve.getValue(AdfmfJavaUtilities.getELContext());
        BasicIterator bi = (BasicIterator)aib.getIterator();

        bi.refresh(true);
    }
    
}
