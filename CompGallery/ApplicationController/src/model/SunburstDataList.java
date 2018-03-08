package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class SunburstDataList {
    
    private static List<TreeviewData> list2009 = new ArrayList<TreeviewData>(Arrays.asList (new TreeviewData[] {
        new TreeviewData(0,70,"#336699","Category1","Category2","Java",33.54f,2.4f,33.54f),
        new TreeviewData(1,20,"#F7C808","Category2","Category1","C/C++",7.48f,0.1f,7.48f),
        new TreeviewData(2,99,"#CC3300","Category1","Category2","C#",17.86f,0.9f,17.86f),
        new TreeviewData(3,20,"#F7C808","Category2","Category1","PHP",10.13f,-2f,10.13f),
        new TreeviewData(4,20,"#F7C808","Category2","Category1","JavaScript",12.01f,1f,12.01f)
    }));
        
    private static List<TreeviewData> list2010 = new ArrayList<TreeviewData>(Arrays.asList (new TreeviewData[] {
        new TreeviewData(0,70,"#336699","Category1","Category2","Java",33.9f,2.63f,361f),
        new TreeviewData(1,20,"#F7C808","Category2","Category1","C/C++",6.74f,0.26f,192f),
        new TreeviewData(2,99,"#CC3300","Category1","Category2","C#",15.97f,0.11f,263f),
        new TreeviewData(3,20,"#F7C808","Category2","Category1","PHP",7.64f,-2.49f,163f),
        new TreeviewData(4,20,"#F7C808","Category2","Category1","JavaScript",9.42f,1.41f,169f)
    }));
    
    
    private static boolean is2009 = true;
    
    public SunburstDataList() {}
    
    public List<TreeviewData> getSunburstData() {
        return is2009 ? list2009 : list2010;
    }

    public void refreshSunburst(ValueChangeEvent valueChangeEvent) {
        String value = (String) valueChangeEvent.getNewValue();
        is2009 = value.equals("2010");
        
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.sunburstDataIterator}", Object.class);
        AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding)ve.getValue(AdfmfJavaUtilities.getELContext());
        BasicIterator bi = aib.getIterator();
        bi.refresh(true);
    }
}
