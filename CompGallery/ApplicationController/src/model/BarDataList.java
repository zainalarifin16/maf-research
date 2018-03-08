package model;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;


public class BarDataList {
    
    private static List<BarData> s_barDataList = null;
    
    public BarDataList() {
        super();
        
        if (s_barDataList == null) {
            s_barDataList = new ArrayList<BarData>();
            
            s_barDataList.add(new BarData("Group A", "Series 1", 42));
            s_barDataList.add(new BarData("Group B", "Series 1", 34));
            s_barDataList.add(new BarData("Group A", "Series 2", 55));
            s_barDataList.add(new BarData("Group B", "Series 2", 30));
            s_barDataList.add(new BarData("Group A", "Series 3", 36));
            s_barDataList.add(new BarData("Group B", "Series 3", 50));
            s_barDataList.add(new BarData("Group A", "Series 4", 22));
            s_barDataList.add(new BarData("Group B", "Series 4", 46));
            s_barDataList.add(new BarData("Group A", "Series 5", 38));
            s_barDataList.add(new BarData("Group B", "Series 5", 52));            
        }        
    }
    
    
    public List<BarData> getBarData() {
        return s_barDataList;
    }
    
    public int getBarDataCount() {
        return s_barDataList.size();
    }
    
    public void refreshChart(ActionEvent actionEvent) {
        // Add event code here...
        s_barDataList.clear();
        
        for (int i = 1; i <= 5; i++) {
            s_barDataList.add(new BarData("Group A", "Series " + i, (int)Math.floor(Math.random() * 60)));
            s_barDataList.add(new BarData("Group B", "Series " + i, (int)Math.floor(Math.random() * 60)));
        }
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.barDataIterator}", Object.class);
        AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding)ve.getValue(AdfmfJavaUtilities.getELContext());
        BasicIterator bi = (BasicIterator)aib.getIterator();

        bi.refresh(true);
    }
    
}
