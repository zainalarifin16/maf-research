package mobile;

import java.text.DateFormat;

import java.util.logging.Level;

import java.util.Date;
import java.util.Map;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ChartDrillEvent;
import oracle.adfmf.amx.event.FilmStripPageChangeEvent;
import oracle.adfmf.amx.event.MoveEvent;
import oracle.adfmf.amx.event.SelectionEvent;
import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.bindings.dbf.AmxCollectionModel;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class PropertyBean
{
  public PropertyBean()
  {
  }

  public String returnActionString(String actionValue)
  {
    return actionValue;
  }

  public void ResetProperties(ActionEvent actionEvent)
  {
    ValueExpression ve;

    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.actionevent}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechanged}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechangeold}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechangenew}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), "");
    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.movedata}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), "");
  }

  public void ActionHandler(ActionEvent actionEvent)
  {
    ValueExpression ve;

    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.actionevent}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), "Action Fired!");
  }

  public void RefreshActionHandler(ActionEvent actionEvent)
  {
    String lastUpdated = "Last updated: ";
    try
    {
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
      String formattedDate = dateFormat.format(new Date());
      lastUpdated += formattedDate;
    }
    catch (Exception e)
    {
      lastUpdated = e.getMessage();
    }

    ValueExpression ve;
    ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.componentProperties.subText}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), lastUpdated);
  }

  public void ValueChangeHandler(ValueChangeEvent valueChangeEvent)
  {
    Trace.log(Utility.ApplicationLogger, Level.INFO, PropertyBean.class, "ValueChangeHandler",
              "##############Inside ValueChangeHandler");
    ValueExpression ve;

    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechanged}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), "Value Changed!");

    String oldstr = _getStringRepresentation(valueChangeEvent.getOldValue());
    String newstr = _getStringRepresentation(valueChangeEvent.getNewValue());

    String oldval = "Old Value: " + oldstr;
    String newval = "New Value: " + newstr;

    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechangeold}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), oldval);

    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechangenew}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), newval);
    Trace.log(Utility.ApplicationLogger, Level.INFO, PropertyBean.class, "ValueChangeHandler",
              "##############ValueChangeHandler completed");
  }

  private String _getStringRepresentation(Object rawValue)
  {
    if (rawValue == null)
      return "";
    else if (rawValue instanceof Object[])
    {
      Object[] array = (Object[]) rawValue;
      StringBuilder sb = new StringBuilder();
      sb.append("[ ");
      for (int i = 0, length = array.length; i < length; i++)
      {
        if (i > 0)
          sb.append(", ");
        sb.append(array[i]);
      }
      sb.append(" ]");
      return sb.toString();
    }
    else
    {
      return rawValue.toString();
    }
  }

  public void ThematicMapSelectionHandler(SelectionEvent selectionEvent)
  {
    ValueExpression ve1 =
      AdfmfJavaUtilities.getValueExpression("#{bindings.thematicMapData.collectionModel}", AmxCollectionModel.class);
    AmxCollectionModel model = (AmxCollectionModel) ve1.getValue(AdfmfJavaUtilities.getELContext());


    String[] selectedRowKeys = selectionEvent.getSelectedRowKeys();
    StringBuffer buffer = new StringBuffer();
    if (selectedRowKeys != null)
    {
      for (int i = 0; i < selectedRowKeys.length; i++)
      {
        String key = selectedRowKeys[i];
        Map provider = (Map) model.getProviders().get(key);
        buffer.append(provider.get("name"));
        if (i < selectedRowKeys.length - 1)
        {
          buffer.append(", ");
        }
      }
    }

    ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechangenew}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), buffer.toString());
  }

  public void GeographicMapPointDataSelectionHandler(SelectionEvent selectionEvent)
  {
    ValueExpression ve1 =
      AdfmfJavaUtilities.getValueExpression("#{bindings.geographicMapPointData.collectionModel}",
                                            AmxCollectionModel.class);
    AmxCollectionModel model = (AmxCollectionModel) ve1.getValue(AdfmfJavaUtilities.getELContext());


    String[] selectedRowKeys = selectionEvent.getSelectedRowKeys();
    StringBuffer buffer = new StringBuffer();
    if (selectedRowKeys != null)
    {
      for (int i = 0; i < selectedRowKeys.length; i++)
      {
        String key = selectedRowKeys[i];
        Map provider = (Map) model.getProviders().get(key);
        buffer.append(provider.get("shortDesc"));
        if (i < selectedRowKeys.length - 1)
        {
          buffer.append(", ");
        }
      }
    }

    ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechangenew}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), buffer.toString());
  }

  public void GeographicMapAddressDataSelectionHandler(SelectionEvent selectionEvent)
  {
    ValueExpression ve1 =
      AdfmfJavaUtilities.getValueExpression("#{bindings.geographicMapAddressData.collectionModel}",
                                            AmxCollectionModel.class);
    AmxCollectionModel model = (AmxCollectionModel) ve1.getValue(AdfmfJavaUtilities.getELContext());


    String[] selectedRowKeys = selectionEvent.getSelectedRowKeys();
    StringBuffer buffer = new StringBuffer();
    if (selectedRowKeys != null)
    {
      for (int i = 0; i < selectedRowKeys.length; i++)
      {
        String key = selectedRowKeys[i];
        Map provider = (Map) model.getProviders().get(key);
        buffer.append(provider.get("shortDesc"));
        if (i < selectedRowKeys.length - 1)
        {
          buffer.append(", ");
        }
      }
    }

    ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.valuechangenew}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), buffer.toString());
  }

  public void MoveHandler(MoveEvent moveEvent)
  {
    Trace.log(Utility.ApplicationLogger, Level.INFO, PropertyBean.class, "MoveHandler", "MoveListener Called!!");

    String inserted = "null";
    if (moveEvent.getRowKeyInsertedBefore() != null)
      inserted = moveEvent.getRowKeyInsertedBefore().toString();

    String key = "null";
    if (moveEvent.getRowKeyMoved() != null)
      key = (String) moveEvent.getRowKeyMoved();

    Trace.log(Utility.ApplicationLogger, Level.INFO, PropertyBean.class, "MoveHandler",
              "MoveListener Called:  Item Moved: " + key + ",  Inserted before: " + inserted);

    ValueExpression ve;
    ve = AdfmfJavaUtilities.getValueExpression("#{viewScope.movedata}", String.class);
    ve.setValue(AdfmfJavaUtilities.getELContext(), "Item Moved: " + key + ",  Inserted before: " + inserted);

    Trace.log(Utility.ApplicationLogger, Level.INFO, PropertyBean.class, "MoveHandler", "MoveListener Completed!!");
  }

  public void thematicMapBaseMapChanged(ValueChangeEvent valueChangeEvent)
  {
    String newVal = valueChangeEvent.getNewValue().toString();
    ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.layer}", String.class);
    String layer = "countries";
    if (newVal.equals("africa") || newVal.equals("asia") || newVal.equals("australia") || newVal.equals("europe") ||
        newVal.equals("northAmerica") || newVal.equals("southAmerica"))
    {
      layer = "continent";
    }
    else if (newVal.equals("usa"))
    {
      layer = "country";
    }
    else if (newVal.equals("world"))
    {
      layer = "continents";
    }
    Trace.log(Utility.ApplicationLogger, Level.INFO, PropertyBean.class, "thematicMapBaseMapChanged",
              "New value: " + layer);
    ve.setValue(AdfmfJavaUtilities.getELContext(), layer);
  }

  public void addPropertyChangeListener(PropertyChangeListener l)
  {
    _propertyChangeSupport.addPropertyChangeListener(l);
  }

  public void removePropertyChangeListener(PropertyChangeListener l)
  {
    _propertyChangeSupport.removePropertyChangeListener(l);
  }

  private void firePropertyChangeIfMateriallyDifferent(String property, String oldValue, String newValue)
  {
    if (oldValue == newValue)
      return;
    if (oldValue == null && "".equals(newValue))
      return;
    if (newValue == null && "".equals(oldValue))
      return;
    if (oldValue != null && oldValue.equals(newValue))
      return;
    _propertyChangeSupport.firePropertyChange(property, oldValue, newValue);
  }

  public void handleSkinChange(ValueChangeEvent valueChangeEvent)
  {
    String newValue = (String) valueChangeEvent.getNewValue();
    setSelectedSkinValue(newValue);
    new Thread(new Runnable()
    {
      public void run()
      {
        AdfmfContainerUtilities.resetFeature("Gallery", false);
        AdfmfContainerUtilities.resetFeature("Springboard", false);
        AdfmfContainerUtilities.resetFeature("About", false);
      }
    }).start();
  }

  public String getSelectedSkinValue()
  {
    return _skinFamily + "_" + _skinVersion;
  }

  public void setSelectedSkinValue(String newSelectedSkinValue)
  {
    String[] splits = newSelectedSkinValue.split("_");
    setSkinFamily(splits[0]);
    setSkinVersion(splits[1]);
  }

  public String getSkinFamily()
  {
    return _skinFamily;
  }

  public void setSkinFamily(String newSkinFamily)
  {
    final String oldSkinFamily = this._skinFamily;
    this._skinFamily = newSkinFamily;

    firePropertyChangeIfMateriallyDifferent("skinFamily", oldSkinFamily, newSkinFamily);
  }

  public String getSkinVersion()
  {
    return _skinVersion;
  }

  public void setSkinVersion(String newSkinVersion)
  {
    final String oldVersion = this._skinVersion;
    this._skinVersion = newSkinVersion;
    firePropertyChangeIfMateriallyDifferent("skinVersion", oldVersion, newSkinVersion);
  }

  private String _skinFamily = "mobileAlta";
  private String _skinVersion = null;
  private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);

  public void drillListener(final ChartDrillEvent drillEvent)
  {
    AdfmfJavaUtilities.setELValue("#{viewScope.drill}", drillEvent.getId() + "(" + drillEvent.getSeries() + ")");
  }

  public void filmStripPageChangeListener(final FilmStripPageChangeEvent pageChangeEvent)
  {
    AdfmfJavaUtilities.setELValue("#{viewScope.displayedPageNo}",pageChangeEvent.getDisplayedPageIndex() + 1);
    AdfmfJavaUtilities.setELValue("#{viewScope.pageCount}",pageChangeEvent.getPageCount());
  }
}
