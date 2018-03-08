package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;


public class FunnelDataList
{

  private static List<FunnelData> s_funnelDataList = null;
  private ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

  public FunnelDataList()
  {
    super();

    if (s_funnelDataList == null)
    {
      s_funnelDataList = new ArrayList<FunnelData>();

      s_funnelDataList.add(new FunnelData("Visits", 50, 60, "rgb(104,193,130)", "red", "ShortDesc A"));
      s_funnelDataList.add(new FunnelData("Downloads", 40, 45, "rgb(250,213,92)", "green", "ShortDesc B"));
      s_funnelDataList.add(new FunnelData("Interested", 24, 36, "rgb(237,102,71)", "red", "ShortDesc C"));
      s_funnelDataList.add(new FunnelData("Contracted", 15, 20, "rgb(133,97,200)", "green", "ShortDesc D"));
      s_funnelDataList.add(new FunnelData("Purchased", 5, 15, "rgb(38,125,179)", "red", "ShortDesc E"));
    }
  }

  public List<FunnelData> getFunnelData()
  {
    return s_funnelDataList;
  }

  public int getFunnelDataCount()
  {
    return s_funnelDataList.size();
  }

  public void refreshValues(ActionEvent actionEvent)
  {
    //System.out.println("#### Refreshing Chart Values");
    for (int i = 0; i < s_funnelDataList.size(); i++)
    {
      FunnelData item = s_funnelDataList.get(i);
      double value = item.getTargetValue() * Math.random();
      item.setValue(value);
    }
    ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.funnelDataIterator}", Object.class);
    AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding) ve.getValue(AdfmfJavaUtilities.getELContext());
    BasicIterator bi = (BasicIterator) aib.getIterator();
    bi.refresh(true);
    // providerChangeSupport.fireProviderRefresh("funnelData");
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
