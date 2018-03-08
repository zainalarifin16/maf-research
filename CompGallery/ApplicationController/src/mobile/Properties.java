package mobile;

import java.util.HashMap;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Properties
  extends HashMap
{
  public Properties()
  {
    super();
  }

  public Object put(Object key, Object value)
  {
    Object old = super.put(key, value);
    _propertyChangeSupport.firePropertyChange(key.toString(), old, value);
    return old;
  }

  public void addPropertyChangeListener(PropertyChangeListener l)
  {
    _propertyChangeSupport.addPropertyChangeListener(l);
  }

  public void removePropertyChangeListener(PropertyChangeListener l)
  {
    _propertyChangeSupport.removePropertyChangeListener(l);
  }

  private transient PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
  private static final long serialVersionUID = 1L;
}
