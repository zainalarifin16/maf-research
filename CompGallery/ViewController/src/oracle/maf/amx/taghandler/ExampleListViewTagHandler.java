/* Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved. */
package oracle.maf.amx.taghandler;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import oracle.adfmf.amx.event.AMXEvent;
import oracle.adfmf.amx.event.RangeChangeEvent;
import oracle.adfmf.bindings.dbf.AmxCollectionModel;
import oracle.adfmf.bindings.iterator.BasicIterator;

import oracle.maf.api.amx.Node;
import oracle.maf.api.amx.metadata.CollectionDefinition;
import oracle.maf.api.amx.taghandler.StampingUITagHandler;
import oracle.maf.impl.amx.View;

/**
 * Tag handler for the example:listView tag
 */
public class ExampleListViewTagHandler
  extends StampingUITagHandler
{
  /**
   * @inheritDoc
   */
  @Override
  protected void initializeAttributes(
    final Node node,
    final boolean renderedAttributeChanged)
  {
    super.initializeAttributes(node, renderedAttributeChanged);

    if (node.isRendered())
    {
      // If the maxRows attribute was not already set, then use the fetchSize as its value
      final int fetchSize = _initializeFetchSize(node);

      if (node.getAttribute("maxRows") == null)
      {
        node.setAttribute("maxRows", fetchSize);
      }

      // See if the maxRows was stored in the client state
      final ClientState state = _getClientState(node, false);

      if (state != null)
      {
        node.setAttribute("maxRows", state.getMaxRows());
      }
    }
  }

  /**
   * @inheritDoc
   */
  @Override
  public String handleAmxEvent(
    final Node node,
    final String attributeName,
    final Object newAttributeValue,
    final String eventName,
    final AMXEvent event)
  {
    final String action = super.handleAmxEvent(node, attributeName, newAttributeValue, eventName, event);

    // See if we need to process the event. If the rangeChangeListener attribute is specified then the listener
    // should be handling the range change event and we may not need to do anything here
    if (event instanceof RangeChangeEvent)
    {
      _handleRangeChangeEvent(node, (RangeChangeEvent)event);
    }

    return action;
  }

  /**
   * Converts actual row keys to stamp keys that may be used safely for JSON serialization
   *
   * @param node the node
   * @param attribute the attribute that contains the row keys
   */
  private static void _initializeRowKeys(
    final Node node,
    final String attribute)
  {
    Object value = node.getAttribute(attribute);

    if (value != null)
    {
      node.setAttribute(attribute, _toStampKeys(node, value));
    }
  }

  /**
   * Convert row keys to stamp keys
   *
   * @param node the AMX node
   * @param value the value to convert
   * @return the stamp keys or null if the value is null
   */
  @SuppressWarnings("oracle.jdeveloper.java.null-array-return")
  private static String[] _toStampKeys(
    final Node node,
    final Object value)
  {
    if (value == null)
    {
      return null;
    }

    // Support comma-separated strings (probably from a non-EL value)
    if (value instanceof String)
    {
      return ((String)value).split("\\s*,\\s*");
    }

    final ArrayList<String> keys = new ArrayList<String>();

    if (value instanceof Number)
    {
      keys.add(View.getInstance(node.getFeatureId()).getStampKey(value));
    }
    else if (value instanceof Iterable)
    {
      final View view = View.getInstance(node.getFeatureId());

      for (Object key : (Iterable)value)
      {
        keys.add(view.getStampKey(key));
      }
    }
    else if (value != null && value.getClass().isArray())
    {
      final View view = View.getInstance(node.getFeatureId());

      for (int i = 0, count = Array.getLength(value); i < count; i++)
      {
        keys.add(view.getStampKey(Array.get(value, i)));
      }
    }

    return keys.toArray(new String[keys.size()]);
  }

  /**
   * Get the client state for the list view node
   *
   * @param node the node
   * @param create true if the caller needs the client state to be created if it does not yet exist
   * @return the client state object or null if it does not yet exist and the create parameter is false
   */
  private ClientState _getClientState(
    final Node node,
    final boolean create)
  {
    final View view = View.getInstance(node.getFeatureId());
    ClientState state = (ClientState)view.getClientState(node);

    if (create && state == null)
    {
      state = new ClientState();
      view.setClientState(node, state);
    }

    return state;
  }

  /**
   * Initialize the fetch size attribute and converts the number to an integer if needed.
   *
   * @param node the AMX node
   * @return the fetchSize
   */
  private int _initializeFetchSize(Node node)
  {
    final Object fetchSizeRawValue = node.getAttribute("fetchSize");
    int fetchSize;

    if (fetchSizeRawValue instanceof String)
    {
      fetchSize = Integer.parseInt((String)fetchSizeRawValue);
    }
    else if (fetchSizeRawValue instanceof Number)
    {
      fetchSize = ((Number)fetchSizeRawValue).intValue();

      if (fetchSize <= 0)
      {
        fetchSize = 25;
      }
    }
    else
    {
      // Fetch size defaults to 25
      fetchSize = 25;
    }

    node.setAttribute("fetchSize", fetchSize);

    return fetchSize;
  }

  /**
   * Handle {@link RangeChangeEvent}
   *
   * @param node the node
   * @param rce the event
   */
  private void _handleRangeChangeEvent(
    final Node node,
    final RangeChangeEvent rce)
  {
    final int fetchSize = rce.getFetchSize();
    final Object lastRowKey = rce.getLastLoadedRowKey();
    final CollectionDefinition collectionDef = getAttributeAsCollection(node, "value");
    final Object value = node.getAttribute("value");
    final int lastMaxRows = (Integer) node.getAttribute("maxRows");
    final int index = getIndexFromRowKey(lastRowKey, value);

    // Verify that we are actually needing to load rows
    if (index + fetchSize > lastMaxRows)
    {
      // If this is backed by an AmxCollectionModel, it expects that the nextSet will be called for hasMoreKeys
      // and not a range change event. So see if we need to manually invoke that method
      if (value instanceof AmxCollectionModel)
      {
        // If the values have not changed, it is possible that more can be loaded if the collection is an
        // AmxCollectionModel. This is because the collection model does not respond to range change events directly,
        // but instead expects the nextSet method to be called
        final AmxCollectionModel collectionModel = (AmxCollectionModel) value;
        final BasicIterator iterator = collectionModel.getAmxTreeBinding().getIterator();
        final boolean hasMoreKeysInitial = collectionModel.getHasMoreKeys();
        final int rowKeysLengthInitial = iterator.getTotalRowCount();

        iterator.setCurrentIndexWithKey(lastRowKey);
        iterator.nextSet();

        if (hasMoreKeysInitial != collectionModel.getHasMoreKeys() ||
          rowKeysLengthInitial != iterator.getTotalRowCount())
        {
          node.markAttributeAsChanged("value");
        }
      }

      final int newMaxRows = lastMaxRows + fetchSize;
      final Object[] keys = getKeys(newMaxRows, value);
      final int newRows = Math.min(keys.length, newMaxRows);

      // Create any rows that need to be added up to the new max rows
      if (newRows > lastMaxRows)
      {
        final Set<Object> keysToCreate = new HashSet<>(newRows - lastMaxRows, 1);

        node.setAttribute("maxRows", newMaxRows);

        _getClientState(node, true).setMaxRows(newMaxRows);

        for (int i = lastMaxRows; i < newRows; i++)
        {
          keysToCreate.add(keys[i]);
        }

        createStampedChildren(node, keysToCreate, collectionDef, null, null);

        node.markAttributeAsChanged("value");
      }
    }
  }

  /**
   * Given an AMX node, get the value as a {@link BasicIterator} if the value is an {@link AmxCollectionModel} instance
   *
   * @param node the amx:listView node
   * @return the iterator or null if the value is not a collection model
   */
  private BasicIterator _getIterator(final Node node)
  {
    final Object value = node.getAttribute("value");

    if (value instanceof AmxCollectionModel)
    {
      return ((AmxCollectionModel)value).getAmxTreeBinding().getIterator();
    }
    else
    {
      return null;
    }
  }

  /**
   * Object for storing the client state of the amx:listView. Retains the maxRows value across navigation to be able
   * to restore how may rows were displayed on the current page
   */
  private static class ClientState
  {
    /**
     * Set the max rows
     *
     * @param maxRows the max rows value to save
     */
    public void setMaxRows(int maxRows)
    {
      _maxRows = maxRows;
    }

    /**
     * Get the max rows
     *
     * @return the previous value for the max rows
     */
    public int getMaxRows()
    {
      return _maxRows;
    }

    private int _maxRows;
  }
}
