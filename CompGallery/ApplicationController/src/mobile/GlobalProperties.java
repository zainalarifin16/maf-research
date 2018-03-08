package mobile;

import java.io.InputStream;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.el.ValueExpression;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.json.JSONException;
import oracle.adfmf.json.JSONObject;
import oracle.adfmf.json.JSONTokener;
import oracle.adfmf.util.Utility;

/**
 * Properties shared across all pages.
 */
public class GlobalProperties
  extends Properties
{
  public GlobalProperties()
  {
    try
    {
      InputStream is = Utility.getResourceAsStream("public_html/model.json");
      JSONObject json = new JSONObject(new JSONTokener(is));
      JSONObject globalProperties = json.getJSONObject("GlobalProperties");

      // Read all global properties
      Set skipProperties = new HashSet(2);
      skipProperties.add("componentProperties");
      skipProperties.add("hostedMode");

      _jsonToProperties(globalProperties, this, skipProperties);

      // Read all the properties for the components
      JSONObject componentProperties = globalProperties.getJSONObject("componentProperties");
      HashMap componentPropertiesMap = new HashMap();
      this.put("componentProperties", componentPropertiesMap);

      for (Iterator iter = componentProperties.keys(); iter.hasNext(); )
      {
        String componentName = (String)iter.next();
        JSONObject componentData = componentProperties.getJSONObject(componentName);
        Properties props = new Properties();
        componentPropertiesMap.put(componentName, props);

        _jsonToProperties(componentData, props, null);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * We are using an unusual method name here because we cannot allow it to be
   * invoked unless the navigationDragBehavior triggers it.
   * (Method names with "get" prefixes get invoked even when no EL expressions
   * reference it.)
   */
  public String handleActionOutcome()
  {
    // This method simply returns the "action" value from the component
    // properties. It isn't a getter because it gets invoked as the result of an
    // action.
    ValueExpression ve =
      AdfmfJavaUtilities.getValueExpression(
        "#{pageFlowScope.componentProperties.action}",
        String.class);
    return (String)ve.getValue(AdfmfJavaUtilities.getELContext());
  }

  private void _jsonToProperties(
    JSONObject json,
    Map        map,
    Set        propertiesToSkip
    ) throws JSONException
  {
    for (Iterator iter = json.keys(); iter.hasNext(); )
    {
      String key = (String)iter.next();
      if (propertiesToSkip == null || !propertiesToSkip.contains(key))
      {
        map.put(key, json.get(key));
      }
    }
  }

  private static final long serialVersionUID = 1L;
}
