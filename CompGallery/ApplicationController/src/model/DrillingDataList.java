package model;

import java.io.PrintWriter;
import java.io.StringWriter;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;

import javax.el.ValueExpression;

import mobile.PropertyBean;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.ChartDrillEvent;
import oracle.adfmf.bindings.dbf.AmxAccessorIteratorBinding;
import oracle.adfmf.bindings.dbf.TreeNode;
import oracle.adfmf.bindings.iterator.BasicIterator;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

/**
 * @author midrozd
 */
public class DrillingDataList
{

  private static List<DrillingData> s_drillingDataList = null;
  private static final String GROUP1 = "Total Sales";
  private static final String GROUP2 = "London Sales";
  private static final String GROUP3 = "Paris Sales";
  private static final String SERIES1 = "Mercedes-Benz";
  private static final String SERIES2 = "BMW";
  private static final String SERIES3 = "Honda";

  private static Node<String> currentGroup;
  private Node<String> groupRoot = new Node<String>(null);

  private static Node<String> currentSeries;
  private Node<String> seriesRoot = new Node<String>(null);

  class Node<T>
  {

    private T data;
    private int level;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T data)
    {
      this.setData(data);
      this.setLevel(1);
      this.setChildren(new LinkedList<Node<T>>());
    }

    public Node<T> addChild(T child)
    {
      Node<T> childNode = new Node<T>(child);
      childNode.parent = this;
      childNode.level = this.level + 1;
      this.getChildren().add(childNode);
      return childNode;
    }

    public Node<T> getRoot()
    {
      Node<T> root = this.getParent();
      while (root.parent != null)
      {
        root = root.parent;
      }
      return root;
    }

    public DrillingDataList.Node<T> getParent()
    {
      return parent;
    }

    public void setParent(DrillingDataList.Node<T> parent)
    {
      this.parent = parent;
    }

    public List<DrillingDataList.Node<T>> getChildren()
    {
      return children;
    }

    public void setChildren(List<DrillingDataList.Node<T>> children)
    {
      this.children = children;
    }

    public T getData()
    {
      return data;
    }

    public void setData(T data)
    {
      this.data = data;
    }

    public Node<T> find(Node<T> node, T data)
    {
      if (node.getData() != null && node.getData().equals(data))
        return node;
      List<DrillingDataList.Node<T>> children = node.getChildren();
      Node<T> res = null;
      for (int i = 0; res == null && i < children.size(); i++)
      {
        res = find(children.get(i), data);
      }
      return res;
    }

    public int getLevel()
    {
      return level;
    }

    public void setLevel(int level)
    {
      this.level = level;
    }
  }

  @SuppressWarnings("unchecked")
  public DrillingDataList()
  {
    super();
    setup();
  }

  public void setup()
  {
    currentGroup = groupRoot;
    currentSeries = seriesRoot;
    Node<String> node0 = groupRoot.addChild(GROUP1);
    node0.addChild(GROUP2);
    node0.addChild(GROUP3);

    Node<String> node = seriesRoot.addChild(SERIES1);
    Node<String> node2 = node.addChild("E-class");
    node2.addChild("W120");
    node2.addChild("W110");
    node2.addChild("W114");
    node2.addChild("W123");
    node2.addChild("W124");

    node2 = node.addChild("S-class");
    node2.addChild("Ponton");
    node2.addChild("Fintail");
    node2.addChild("W108");
    node2.addChild("W126");
    node2.addChild("W222");

    node2 = node.addChild("ML-class");
    node2.addChild("W163");
    node2.addChild("W164");
    node2.addChild("W166");

    node2 = node.addChild("G-class");
    node2.addChild("460");
    node2.addChild("461");
    node2.addChild("463");

    node = seriesRoot.addChild(SERIES2);
    node2 = node.addChild("Series 3");
    node2.addChild("X3");
    node2.addChild("Z3");
    node2.addChild("M3");
    node2.addChild("325xi");

    node2 = node.addChild("Series 5");
    node2.addChild("525xi");
    node2.addChild("55xi");
    node2.addChild("M5");
    node2.addChild("325xi");

    node2 = node.addChild("Series 7");
    node2.addChild("E23");
    node2.addChild("E32");
    node2.addChild("E38");
    node2.addChild("E65");

    node = seriesRoot.addChild(SERIES3);
    node2 = node.addChild("Accord");
    node2.addChild("First gen.");
    node2.addChild("Second gen.");
    node2.addChild("Third gen.");
    node2.addChild("Fourth gen.");
    node2.addChild("Fifth gen.");

    node2 = node.addChild("Insight");
    node2.addChild("First gen.");
    node2.addChild("Second gen.");

    node2 = node.addChild("Fit");
    node2.addChild("First gen.");
    node2.addChild("Second gen.");
    node2.addChild("Third gen.");

    node2 = node.addChild("Pilot");
    node2.addChild("First gen.");
    node2.addChild("Second gen.");
    node2.addChild("Third gen.");

    node2 = node.addChild("Element");
    node2.addChild("2003");
    node2.addChild("2005");
    node2.addChild("2007");
    node2.addChild("2009");

    node = seriesRoot.addChild("Volkswagen");
    node2 = node.addChild("Passat");
    node2.addChild("B5");
    node2.addChild("B6");
    node2.addChild("B7");
    node2.addChild("B8");

    node2 = node.addChild("Touareg");
    node2.addChild("W12");
    node2.addChild("R50");
    node2.addChild("V6 TDI");

    int i = 0;
    //    for (i=5; i<15; i++)
    //    {
    //      node = seriesRoot.addChild("Item" + i);
    //    }

    if (s_drillingDataList == null)
    {
      s_drillingDataList = new ArrayList<DrillingData>();
    }
    else
    {
      s_drillingDataList.clear();
    }
    addItem(SERIES1);
    addItem(SERIES2);
    addItem(SERIES3);
    addItem("Volkswagen");
    //    for (i=5; i<15; i++)
    //    {
    //      addItem("Item" + i);
    //    }
    AdfmfJavaUtilities.setELValue("#{pageFlowScope.drillBackGroupDisabled}", true);
    AdfmfJavaUtilities.setELValue("#{pageFlowScope.drillBackSeriesDisabled}", true);

  }

  public List<DrillingData> getDrillingData()
  {
    return s_drillingDataList;
  }

  public void setDrillingData(List<DrillingData> data)
  {
    s_drillingDataList = data;
  }

  public int getDrillingDataCount()
  {
    return s_drillingDataList.size();
  }

  public void BackSeries(ActionEvent actionEvent)
  {
    if (currentSeries.getParent() != null)
    {
      currentSeries = currentSeries.getParent();
    }
    updateSeries();
  }

  public void BackGroup(ActionEvent actionEvent)
  {
    if (currentGroup.getParent() != null)
    {
      currentGroup = currentGroup.getParent();
    }
    updateSeries();
  }

  private void addItem(String series)
  {
    for (int i = 0; i < currentGroup.getChildren().size(); i++)
    {
      DrillingDataList.s_drillingDataList.add(new DrillingData(currentGroup.getChildren().get(i).getData(),
                                                               currentGroup.getData(), series,
                                                               (int) (Math.floor(Math.random() * 60)) + 20));
    }
  }

  private void updateSeries()
  {
    try
    {
      s_drillingDataList.clear();

      List<Node<String>> seriesChildren = currentSeries.getChildren();
      for (int i = 0; i < seriesChildren.size(); i++)
      {
        addItem(seriesChildren.get(i).getData());
      }
      ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{bindings.drillingDataIterator}", Object.class);
      AmxAccessorIteratorBinding aib = (AmxAccessorIteratorBinding) ve.getValue(AdfmfJavaUtilities.getELContext());
      BasicIterator bi = (BasicIterator) aib.getIterator();
      bi.refresh(true);
      if (currentGroup.getLevel() == 2)
      {
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.title}", "Sales by city");
      }
      else if (currentGroup.getLevel() == 1)
      {
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.title}", "Total Sales");
      }
      AdfmfJavaUtilities.setELValue("#{pageFlowScope.subtitle}", currentSeries.getData());
      AdfmfJavaUtilities.setELValue("#{pageFlowScope.drillBackGroupDisabled}", currentGroup.getParent() == null);
      AdfmfJavaUtilities.setELValue("#{pageFlowScope.drillBackSeriesDisabled}", currentSeries.getParent() == null);
      if (currentGroup.getParent() != null)
      {
        Node<String> node = currentGroup.getParent();
        String previousGroup = node.getData();
        if ((node.getLevel() == 1) && (node.getData() == null))
        {
          previousGroup = "Total Sales";
        }
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.previousGroup}", previousGroup);
      }
      if (currentSeries.getParent() != null)
      {
        Node<String> node = currentSeries.getParent();
        String previousSeries = node.getData();
        if (node.getLevel() == 1)
        {
          previousSeries = "all brands";
        }
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.previousSeries}", previousSeries);
      }
      Node<String> node = currentSeries;
      List<String> path = new ArrayList<String>();
      while (node != null)
      {
        if (node.getData() == null)
        {
          path.add("All Brands");
        }
        else
        {
          path.add(node.getData());
        }
        node = node.getParent();
      }
      StringBuilder builder = new StringBuilder(200);
      Collections.reverse(path);
      for (int i = 0; i < path.size(); i++)
      {
        if (i > 0)
        {
          builder.append(" -> " + path.get(i));
        }
        else
        {
          builder.append(path.get(i));
        }
      }
      AdfmfJavaUtilities.setELValue("#{pageFlowScope.seriesPath}", builder.toString());
    }
    catch (Exception e)
    {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
    }
  }

  public void DrillHandler(ChartDrillEvent drillEvent)
  {
    try
    {
      String series = drillEvent.getSeries() != null? drillEvent.getSeries().toString().trim(): "";
      String group = drillEvent.getGroup() != null? drillEvent.getGroup().toString(): "";
      if (!group.isEmpty() && series.isEmpty())
      {
        // drill back
        if (group.equals(currentGroup.getData()) && currentGroup.getParent() != null)
        {
          currentGroup = currentGroup.getParent();
          updateSeries();
          return;
        }

        // Example: Total Sales -> London and Paris sales (level 2)
        Node<String> node = groupRoot.find(groupRoot, group);
        if (node == null)
        {
          throw new Exception("Unknown group '" + group + "'");
        }

        if ((node.getChildren() != null) && (node.getChildren().size() > 0))
        {
          currentGroup = node;
          updateSeries();
        }
      }
      else if (!series.isEmpty())
      {
        Node<String> node = seriesRoot.find(seriesRoot, series);
        if (node == null)
        {
          throw new Exception("Unknown series '" + node + "'");
        }

        if ((node.getChildren() != null) && (node.getChildren().size() > 0))
        {
          currentSeries = node;
          updateSeries();
        }
      }
    }
    catch (Exception e)
    {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
    }
  }
}
