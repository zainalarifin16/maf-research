package wb.model;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Attrition {
    private int aid;
    private int empid;
    private int anum;
    private String atype;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Attrition() {
        super();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setAid(int aid) {
        int oldAid = this.aid;
        this.aid = aid;
        propertyChangeSupport.firePropertyChange("aid", oldAid, aid);
    }

    public int getAid() {
        return aid;
    }

    public void setEmpid(int empid) {
        int oldEmpid = this.empid;
        this.empid = empid;
        propertyChangeSupport.firePropertyChange("empid", oldEmpid, empid);
    }

    public int getEmpid() {
        return empid;
    }

    public void setAnum(int anum) {
        int oldAnum = this.anum;
        this.anum = anum;
        propertyChangeSupport.firePropertyChange("anum", oldAnum, anum);
    }

    public int getAnum() {
        return anum;
    }

    public void setAtype(String atype) {
        String oldAtype = this.atype;
        this.atype = atype;
        propertyChangeSupport.firePropertyChange("atype", oldAtype, atype);
    }

    public String getAtype() {
        return atype;
    }


}
