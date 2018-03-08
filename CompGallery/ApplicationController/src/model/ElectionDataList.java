package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import javax.el.ValueExpression;

import mobile.PropertyBean;

import oracle.adfmf.amx.event.SelectionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class ElectionDataList {
    
    private static int currentElectionIndex = 0;
    private static String coalition = "";
    private static float coalitionChairs = 0;
    private static String[] electionList = new String[] {
       "1996", 
       "1998", 
       "2002", 
       "2006", 
       "2010", 
       "2013"
    };
    
    private static List<ElectionData> data1996 = Arrays.asList (new ElectionData[] {
        new ElectionData (68, "Party 1"),
        new ElectionData (61, "Party 2"),
        new ElectionData (22, "Party 3"),
        new ElectionData (18, "Party 4"),
        new ElectionData (18, "Party 5"),
        new ElectionData (13, "Party 6")
    });
    
    private static List<ElectionData> data1998 = Arrays.asList (new ElectionData[] {
        new ElectionData (74, "Party 2"),
        new ElectionData (63, "Party 1"),
        new ElectionData (24, "Party 3"),
        new ElectionData (20, "Party 4"),
        new ElectionData (19, "Party 5")
    });
    
    private static List<ElectionData> data2002 = Arrays.asList (new ElectionData[] {
        new ElectionData (70, "Party 2"),
        new ElectionData (58, "Party 1"),
        new ElectionData (41, "Party 3"),
        new ElectionData (23, "Party 4"),
        new ElectionData (8,  "Party 5")
    });
    
    private static List<ElectionData> data2006 = Arrays.asList (new ElectionData[] {
        new ElectionData (81, "Party 1"),
        new ElectionData (74, "Party 2"),
        new ElectionData (26, "Party 3"),
        new ElectionData (13, "Party 4"),
        new ElectionData (6,  "Party 6")
    });
    
    private static List<ElectionData> data2010 = Arrays.asList (new ElectionData[] {
        new ElectionData (56, "Party 2"),
        new ElectionData (53, "Party 1"),
        new ElectionData (41, "Party 7"),
        new ElectionData (26, "Party 3"),
        new ElectionData (34, "Party 8")
    });
    
    private static List<ElectionData> data2013 = Arrays.asList (new ElectionData[] {
        new ElectionData (50, "Party 2"),
        new ElectionData (57, "Party 9"),
        new ElectionData (33, "Party 3"),
        new ElectionData (26, "Party 7"),
        new ElectionData (16, "Party 1"),
        new ElectionData (14, "Party 10"),
        new ElectionData (14, "Party 4")
    });
    
    private static Object[] elections = new Object [] {
        data1996, data1998, data2002, data2006, data2010, data2013
    };
    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private transient final ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);
    
    public ElectionDataList() {
        super();
    }

    public void setCurrentElectionIndex(int currentElection) {
        System.out.println ("#$#currentElectionInt: " + currentElection);
        currentElectionIndex = currentElection;
        
        setCoalition("");
        setCoalitionChairs(0);
        System.out.println ("#$#ValueChange: " + currentElectionIndex);
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.electionDataListIterator}", Object.class);
        AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding)ve.getValue(AdfmfJavaUtilities.getELContext());
        BasicIterator bi = (BasicIterator)aib.getIterator();
        bi.refresh(true);
        //providerChangeSupport.fireProviderRefresh ("electionDataListIterator");

    }

    public int getCurrentElectionIndex() {
        return currentElectionIndex;
    }


    public void setElectionList(String[] electionList) {
        ElectionDataList.electionList = electionList;
    }

    public String[] getElectionList() {
        return electionList;
    }
    
    public List<ElectionData> getElectionDataList () {
        System.out.println ("#$#getElectionDataList: " + currentElectionIndex);
        return (List<ElectionData>) elections [currentElectionIndex];
    }

    public void setCoalition(String coalition) {
        String old = ElectionDataList.coalition;
        ElectionDataList.coalition = coalition;
        propertyChangeSupport.firePropertyChange("coalition", old, coalition);
    }

    public String getCoalition() {
        return coalition;
    }

    public void setCoalitionChairs(float coalitionChairs) {
        float old = ElectionDataList.coalitionChairs;
        ElectionDataList.coalitionChairs = coalitionChairs;
        propertyChangeSupport.firePropertyChange("coalitionChairs", old, coalitionChairs);
    }

    public float getCoalitionChairs() {
        return coalitionChairs;
    }

    public void selectionListener(SelectionEvent se)
    {
        String[] selectedRowKeys = se.getSelectedRowKeys();
        String coalition = "";
        float coalitionChairs = 0;
        for (int i = 0; i < selectedRowKeys.length; i++) {
            int keyIndex = Integer.parseInt(selectedRowKeys [i]);
            coalition += (coalition.isEmpty() ? "" : " + ") + getElectionDataList().get (keyIndex).getLabel();
            coalitionChairs += getElectionDataList().get (keyIndex).getValue();
        }
        setCoalition(coalition);
        setCoalitionChairs(coalitionChairs);
    }
    
    public void addPropertyChangeListener (PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }
        
    public void removePropertyChangeListener (PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }    

    public void addProviderChangeListener(ProviderChangeListener l)
    {
      providerChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l)
    {
      providerChangeSupport.removeProviderChangeListener(l);
    }    
}
