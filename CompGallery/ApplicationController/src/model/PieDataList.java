package model;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;


public class PieDataList {
    
    private static List<PieData> s_pieDataList = null;
    
    public PieDataList() {
        super();
        
        if (s_pieDataList == null) {
            s_pieDataList = new ArrayList<PieData>();
            
            s_pieDataList.add(new PieData("Series 1", 42, 20));
            s_pieDataList.add(new PieData("Series 2", 55, 0));
            s_pieDataList.add(new PieData("Series 3", 36, 0));
            s_pieDataList.add(new PieData("Series 4", 22, 0));
            s_pieDataList.add(new PieData("Series 5", 22, 0));            
        }        
    }    
    
    public List<PieData> getPieData() {
        return s_pieDataList;
    }
    
    public int getPieDataCount() {
        return s_pieDataList.size();
    }
    
    public void refreshChart(ActionEvent actionEvent) {
        // Add event code here...
        s_pieDataList.clear();
        
        for (int i = 1; i <= 5; i++) {
            s_pieDataList.add(new PieData("Series " + i, (int)Math.floor(Math.random() * 60), 0));
        }
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.pieDataIterator}", Object.class);
        AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding)ve.getValue(AdfmfJavaUtilities.getELContext());
        BasicIterator bi = (BasicIterator)aib.getIterator();

        bi.refresh(true);
    }

    
}
