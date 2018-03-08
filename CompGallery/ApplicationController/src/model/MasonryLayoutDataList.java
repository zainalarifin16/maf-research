package model;

import javax.el.ValueExpression;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.MasonryReorderEvent;
import oracle.adfmf.bindings.dbf.AmxExecutableBinding;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;


public class MasonryLayoutDataList
{
  private static MasonryLayoutNode[] nodes;
  private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

  public MasonryLayoutDataList()
  {
    if (nodes == null)
      nodes = new MasonryLayoutNode[]
      {
        new MasonryLayoutNode("1", "low", "low", "Nina Evans", "Product Management Director", "IT", "5TD1", "PRG1"),
        new MasonryLayoutNode("2", "low", "medium", "Diana Lorentz", "Principal Product Manager", "Finance", "5TP3",
                              "SFO"),
        new MasonryLayoutNode("3", "low", "medium", "Lucy Whalen", "Principal Marketing Manager", "IT", "1TR2", "DEN"),
        new MasonryLayoutNode("4", "low", "high", "Laura Bissot", "Senior Product Manager", "Cloud", "5TD1", "PRG2"),
        new MasonryLayoutNode("5", "low", "high", "Susan Higgins", "Principal Technical Writer", "IT", "1TW5", "BRV"),
        new MasonryLayoutNode("6", "low", "high", "Kelly Sullivan", "Principal Marketing Manager", "Cloud", "5TP3",
                              "DEN"),
        new MasonryLayoutNode("7", "medium", "low", "Julia Chen", "Principal Product Manager", "Finance", "1TR2",
                              "BRV"),
        new MasonryLayoutNode("8", "medium", "low", "Alaina Walsh", "Senior Marketing Manager", "Apps", "5TD1", "PRG1"),
        new MasonryLayoutNode("9", "medium", "low", "Nancy Green", "Senior Documentation Manager", "IT", "5TD1", "DEN"),
        new MasonryLayoutNode("10", "medium", "low", "Steven King", "Vice President", "Finance:", "1TW5", "SFO"),
        new MasonryLayoutNode("11", "medium", "medium", "Alex Hunold", "Software Development Senior Director", "IT",
                              "1TW5", "CHK"),
        new MasonryLayoutNode("12", "medium", "medium", "Curtis Davies", "Principal Product Manager", "Cloud", "5TP3",
                              "DEN")
      };
  }

  public MasonryLayoutNode[] getMasonryLayoutNodesDataList()
  {
    return nodes;
  }

  private static BarData[] turnoverBasicDataList;

  public BarData[] getTurnoverBasicDataList()
  {
    if (turnoverBasicDataList == null)
      turnoverBasicDataList = new BarData[]
      {
        new BarData("Voluntary", "", 4), new BarData("Involuntary", "", 7)
      };
    return turnoverBasicDataList;
  }

  private static BarData[] turnoverExpandedDataList;

  public BarData[] getTurnoverExpandedDataList()
  {
    if (turnoverExpandedDataList == null)
      turnoverExpandedDataList = new BarData[]
      {
        new BarData("Voluntary", "", 4), new BarData("Involuntary", "", 7), new BarData("Voluntary", "", 2),
        new BarData("Involuntary", "", 6), new BarData("Voluntary", "", 5), new BarData("Involuntary", "", 9),
        new BarData("Voluntary", "", 4), new BarData("Involuntary", "", 8), new BarData("Voluntary", "", 3),
        new BarData("Involuntary", "", 6)
      };
    return turnoverExpandedDataList;
  }

  public void reorderListener(MasonryReorderEvent masonryReorderEvent)
  {
    order = masonryReorderEvent.getItemOrder();
    //ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{pageFlowScope.componentProperties.order}", Object.class);
    //ve.setValue(AdfmfJavaUtilities.getAdfELContext(), order);
  }

  public void restore (ActionEvent event)
  {
    setOrder("");
    setMyTeam(true);
    setMyTeamExpanded(true);
    setSocial(true);
    setSocialExpanded(false);
    setAboutMe(true);
    setAboutMeExpanded(false);
    setTime(true);
    setTimeExpanded(true);
    setTurnover(true);
    setTurnoverExpanded(true);
    setPTOLiability(true);
    setPTOLiabilityExpanded(true);
    setDirectory(true);
    setDirectoryExpanded(false);
    setNotifications(true);
    setNotificationsExpanded(false);
  }

  private Object order = "";

  public Object getOrder()
  {
    return order;
  }

  public void setOrder(Object order)
  {
    Object old = this.order;
    this.order = order;
    pcs.firePropertyChange("order", old, order);
  }

  private Object myTeam = true;

  public Object getMyTeam()
  {
    return myTeam;
  }

  public void setMyTeam(Object myTeam)
  {
    Object old = this.myTeam;
    this.myTeam = myTeam;
    pcs.firePropertyChange("myTeam", old, myTeam);
   // ValueExpression ve = AdfmfJavaUtilities.getValueExpression("#{MasonryLayoutBean.myTeam}", Object.class);
   // ((AmxExecutableBinding) ve.getValue(AdfmfJavaUtilities.getAdfELContext())).refresh();
  }

  private Object myTeamExpanded = true;

  public Object getMyTeamExpanded()
  {
    return myTeamExpanded;
  }

  public void setMyTeamExpanded(Object myTeamExpanded)
  {
    Object old = this.myTeamExpanded;
    this.myTeamExpanded = myTeamExpanded;
    pcs.firePropertyChange("myTeamExpanded", old, myTeamExpanded);
  }

  private Object social = true;

  public Object getSocial()
  {
    return social;
  }

  public void setSocial(Object social)
  {
    Object old = this.social;
    this.social = social;
    pcs.firePropertyChange("social", old, social);
  }

  private Object socialExpanded = false;

  public Object getSocialExpanded()
  {
    return socialExpanded;
  }

  public void setSocialExpanded(Object socialExpanded)
  {
    Object old = this.socialExpanded;
    this.socialExpanded = socialExpanded;
    pcs.firePropertyChange("socialExpanded", old, socialExpanded);
  }

  private Object aboutMe = true;

  public Object getAboutMe()
  {
    return aboutMe;
  }

  public void setAboutMe(Object aboutMe)
  {
    Object old = this.aboutMe;
    this.aboutMe = aboutMe;
    pcs.firePropertyChange("aboutMe", old, aboutMe);
  }

  private Object aboutMeExpanded = false;

  public Object getAboutMeExpanded()
  {
    return aboutMeExpanded;
  }

  public void setAboutMeExpanded(Object aboutMeExpanded)
  {
    Object old = this.aboutMeExpanded;
    this.aboutMeExpanded = aboutMeExpanded;
    pcs.firePropertyChange("aboutMeExpanded", old, aboutMeExpanded);
  }

  private Object time = true;

  public Object getTime()
  {
    return time;
  }

  public void setTime(Object time)
  {
    Object old = this.time;
    this.time = time;
    pcs.firePropertyChange("time", old, time);
  }

  private Object timeExpanded = true;

  public Object getTimeExpanded()
  {
    return timeExpanded;
  }

  public void setTimeExpanded(Object timeExpanded)
  {
    Object old = this.timeExpanded;
    this.timeExpanded = timeExpanded;
    pcs.firePropertyChange("timeExpanded", old, timeExpanded);
  }

  private Object turnover = true;

  public Object getTurnover()
  {
    return turnover;
  }

  public void setTurnover(Object turnover)
  {
    Object old = this.turnover;
    this.turnover = turnover;
    pcs.firePropertyChange("turnover", old, turnover);
  }

  private Object turnoverExpanded = true;

  public Object getTurnoverExpanded()
  {
    return turnoverExpanded;
  }

  public void setTurnoverExpanded(Object turnoverExpanded)
  {
    Object old = this.turnoverExpanded;
    this.turnoverExpanded = turnoverExpanded;
    pcs.firePropertyChange("turnoverExpanded", old, turnoverExpanded);
  }

  private Object ptoLiability = true;

  public Object getPTOLiability()
  {
    return ptoLiability;
  }

  public void setPTOLiability(Object ptoLiability)
  {
    Object old = this.ptoLiability;
    this.ptoLiability = ptoLiability;
    pcs.firePropertyChange("PTOLiability", old, ptoLiability);
  }

  private Object ptoLiabilityExpanded = true;

  public Object getPTOLiabilityExpanded()
  {
    return ptoLiabilityExpanded;
  }

  public void setPTOLiabilityExpanded(Object ptoLiabilityExpanded)
  {
    Object old = this.ptoLiabilityExpanded;
    this.ptoLiabilityExpanded = ptoLiabilityExpanded;
    pcs.firePropertyChange("PTOLiabilityExpanded", old, ptoLiabilityExpanded);
  }

  private Object directory = true;

  public Object getDirectory()
  {
    return directory;
  }

  public void setDirectory(Object directory)
  {
    Object old = this.directory;
    this.directory = directory;
    pcs.firePropertyChange("directory", old, directory);
  }

  private Object directoryExpanded = false;

  public Object getDirectoryExpanded()
  {
    return directoryExpanded;
  }

  public void setDirectoryExpanded(Object directoryExpanded)
  {
    Object old = this.directoryExpanded;
    this.directoryExpanded = directoryExpanded;
    pcs.firePropertyChange("directoryExpanded", old, directoryExpanded);
  }

  private Object notifications = true;

  public Object getNotifications()
  {
    return notifications;
  }

  public void setNotifications(Object notifications)
  {
    Object old = this.notifications;
    this.notifications = notifications;
    pcs.firePropertyChange("notifications", old, notifications);
  }

  private Object notificationsExpanded = false;

  public Object getNotificationsExpanded()
  {
    return notificationsExpanded;
  }

  public void setNotificationsExpanded(Object notificationsExpanded)
  {
    Object old = this.notificationsExpanded;
    this.notificationsExpanded = notificationsExpanded;
    pcs.firePropertyChange("notificationsExpanded", old, notificationsExpanded);
  }

  public void addPropertyChangeListener(PropertyChangeListener l)
  {
    pcs.addPropertyChangeListener(l);
  }

  public void removePropertyChangeListener(PropertyChangeListener l)
  {
    pcs.removePropertyChangeListener(l);
  }
}
