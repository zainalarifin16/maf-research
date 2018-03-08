package mobile;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.amx.event.RangeChangeEvent;
import oracle.adfmf.amx.event.RangeChangeListener;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

/**
 * This class defines the business logic encapsulated in the managed bean that is used in Pattern 2.
 */
public class DepartmentsBean {

    private static int _listSize = 50;    // Total number of rows on the simulated remote server
    private static int _initialSize = 10; // This is set to the same as the ListView's FetchSize

    private List _departments = null;
    private boolean _moreRowsAvailable = true;
    private String _outputText = "";
    private int _rceCalls = 0;
    
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    public DepartmentsBean() {
        if (_departments == null) {
            // Initialise & load initial list from the external source
            _departments = new ArrayList();
            loadMoreData(_initialSize);
            setOutputText("[0] Loaded initial " + _initialSize + " rows");
        }
    }

    public Department[] getDepartments() {
        return (Department[])_departments.toArray(new Department[_departments.size()]);
    }

    public void setMoreRowsAvailable(boolean moreRowsAvailable) {
        boolean oldMoreRowsAvailable = _moreRowsAvailable;
        _moreRowsAvailable = moreRowsAvailable;
        propertyChangeSupport.firePropertyChange("moreRowsAvailable", oldMoreRowsAvailable, moreRowsAvailable);
    }

    // This method can be used by the view to determine if new rows are available, but
    // is not actually used within this sample.  Refer to the line that is commented-out within 
    // pattern2.amx for an example of its use.
    public boolean isMoreRowsAvailable() {
        return _moreRowsAvailable;
    }

    public void setOutputText(String outputText) {
        _outputText = outputText;
        propertyChangeSupport.firePropertyChange("outputText", null, _outputText);
        System.out.println(_outputText);
    }

    public String getOutputText() {
        return _outputText;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void addProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
    }

    // This method is called by the framework to fire a RangeChangeEvent.  
    // It is identified in the ListView attributes.
    public void goGet(RangeChangeEvent rangeChangeEvent) {
        // This call would normally go to the remote server
        List newRows = loadMoreData(rangeChangeEvent.getFetchSize());
        
        // Display the number of rows requested & loaded - only required for this sample app
        setOutputText("[" + (++_rceCalls) + "] " + rangeChangeEvent.getFetchSize() + " rows requested, " + newRows.size() + " loaded");
    }

    // This is the call to load more data from the external source
    private List loadMoreData(int range) {
        // Load the data
        List loadedData = new ArrayList();
        for (int i = 0; i < range && _departments.size() < _listSize; i++ ) {
            int index = _departments.size() + 1;
            Department newDepartment = new Department(100+index, "Engineering" + index, "20" + index + " Oracle Parkway", "Redwood City", "CA", "94065");
            _departments.add(newDepartment);
            providerChangeSupport.fireProviderCreate("departments", newDepartment.getDeptId(), newDepartment);
            loadedData.add(newDepartment);
            if (_departments.size() == _listSize) {
                setMoreRowsAvailable(false);
            }
        }
        return loadedData;
    }
}
