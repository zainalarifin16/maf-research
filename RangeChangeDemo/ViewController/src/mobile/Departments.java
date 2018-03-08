package mobile;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.RangeChangeEvent;
import oracle.adfmf.amx.event.RangeChangeListener;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

/**
 * This class defines the business logic behind the Data Control that is used in Pattern 1.
 *
 * It implements RangeChangeListener so that the framework fire a RangeChangeEvent.
 */
public class Departments implements RangeChangeListener {

    private static int _listSize = 50;    // Total number of rows on the simulated remote server
    private static int _initialSize = 10; // This is set to the same as the iterator's RangeSize

    private List _departments = null;
    private int _rceCalls = 0;
    
    public Departments() {
        if (_departments == null) {
            // Initialise & load initial list from the external source
            _departments = new ArrayList();
            loadMoreData(_initialSize);
            updateOutputText("[0] Loaded initial " + _initialSize + " rows");
        }
    }

    public Department[] getDepartments() {
        return (Department[])_departments.toArray(new Department[_departments.size()]);
    }
    
    // This method is called by the framework to fire a RangeChangeEvent.
    // Its signature is defined by the RangeChangeListener interface.
    public void rangeChange(RangeChangeEvent rangeChangeEvent) {
        List newRows = null;
        
        // Only retrieve more values if required
        if (rangeChangeEvent.isDataExhausted()) {
            // This call would normally go to the remote server
            newRows = loadMoreData(rangeChangeEvent.getFetchSize());
            
            // Must inform the framework of the additional rows that were loaded
            AdfmfJavaUtilities.addDataControlProviders("Departments", rangeChangeEvent.getProviderKey(), rangeChangeEvent.getKeyAttribute(),
                                                       newRows, (_departments.size() < _listSize));
        }

        // Display the number of rows requested & loaded - only required for this sample app
        updateOutputText("[" + (++_rceCalls) + "] " + rangeChangeEvent.getFetchSize() + " rows requested, " + (newRows != null ? newRows.size() : 0) + " loaded");
    }

    // This is the call to load more data from the external source
    private List loadMoreData(int range) {
        // Load the data
        List loadedData = new ArrayList();
        for (int i = 0; i < range && _departments.size() < _listSize; i++ ) {
            int index = _departments.size() + 1;
            Department newDepartment = new Department(100+index, "Engineering" + index, "20" + index + " Oracle Parkway", "Redwood City", "CA", "94065");
            _departments.add(newDepartment);
            loadedData.add(newDepartment);
        }
        return loadedData;
    }
    
    // Used to update the outputText on the page - only required by this sample app
    private void updateOutputText(String outputText) {
        ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.outputText}", String.class);
        ve.setValue(AdfmfJavaUtilities.getELContext(), outputText);
        System.out.println(outputText);
    }
}
