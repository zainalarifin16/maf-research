package wb.model;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

public class OrgSummary {
    private int empid;
    private int empmeetings;
    private int emptimeoffs;
    private int empevents;
    private int emptrainings;
    private int teammeetings;
    private int teamtimeoffs;
    private int teamevents;
    private int teamtrainings;
    private int orgsize;
    private int teamsize;
    private int orgcompratioabove;
    private int orgcompratioin;
    private int orgcompratiobelow;
    private double orgavgrating;
    private double orgavgpotential;
    private int totalattrition;
    protected List<Department> orgDeptList = new ArrayList<Department>();
    protected List<Attrition> attritionList = new ArrayList<Attrition>();
    protected Employee user = null;

    protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    public OrgSummary() {
        super();
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
        providerChangeSupport.removeProviderChangeListener(l);
    }

    public void setUser(Employee user) {
        Employee oldUser = this.user;
        this.user = user;
        propertyChangeSupport.firePropertyChange("user", oldUser, user);
    }

    public Employee getUser() {
        return user;
    }

    public List<Attrition> getAttrition() {
        return attritionList;
    }

    public List<Department> getOrgDepartments() {
        return orgDeptList;
    }

    public void setEmpid(int empid) {
        int oldEmpid = this.empid;
        this.empid = empid;
        propertyChangeSupport.firePropertyChange("empid", oldEmpid, empid);
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpmeetings(int empmeetings) {
        int oldEmpmeetings = this.empmeetings;
        this.empmeetings = empmeetings;
        propertyChangeSupport.firePropertyChange("empmeetings", oldEmpmeetings, empmeetings);
    }

    public int getEmpmeetings() {
        return empmeetings;
    }

    public void setEmptimeoffs(int emptimeoffs) {
        int oldEmptimeoffs = this.emptimeoffs;
        this.emptimeoffs = emptimeoffs;
        propertyChangeSupport.firePropertyChange("emptimeoffs", oldEmptimeoffs, emptimeoffs);
    }

    public int getEmptimeoffs() {
        return emptimeoffs;
    }

    public void setEmpevents(int empevents) {
        int oldEmpevents = this.empevents;
        this.empevents = empevents;
        propertyChangeSupport.firePropertyChange("empevents", oldEmpevents, empevents);
    }

    public int getEmpevents() {
        return empevents;
    }

    public void setEmptrainings(int emptrainings) {
        int oldEmptrainings = this.emptrainings;
        this.emptrainings = emptrainings;
        propertyChangeSupport.firePropertyChange("emptrainings", oldEmptrainings, emptrainings);
    }

    public int getEmptrainings() {
        return emptrainings;
    }

    public void setTeammeetings(int teammeetings) {
        int oldTeammeetings = this.teammeetings;
        this.teammeetings = teammeetings;
        propertyChangeSupport.firePropertyChange("teammeetings", oldTeammeetings, teammeetings);
    }

    public int getTeammeetings() {
        return teammeetings;
    }

    public void setTeamtimeoffs(int teamtimeoffs) {
        int oldTeamtimeoffs = this.teamtimeoffs;
        this.teamtimeoffs = teamtimeoffs;
        propertyChangeSupport.firePropertyChange("teamtimeoffs", oldTeamtimeoffs, teamtimeoffs);
    }

    public int getTeamtimeoffs() {
        return teamtimeoffs;
    }

    public void setTeamevents(int teamevents) {
        int oldTeamevents = this.teamevents;
        this.teamevents = teamevents;
        propertyChangeSupport.firePropertyChange("teamevents", oldTeamevents, teamevents);
    }

    public int getTeamevents() {
        return teamevents;
    }

    public void setTeamtrainings(int teamtrainings) {
        int oldTeamtrainings = this.teamtrainings;
        this.teamtrainings = teamtrainings;
        propertyChangeSupport.firePropertyChange("teamtrainings", oldTeamtrainings, teamtrainings);
    }

    public int getTeamtrainings() {
        return teamtrainings;
    }

    public void setOrgsize(int orgsize) {
        int oldOrgsize = this.orgsize;
        this.orgsize = orgsize;
        propertyChangeSupport.firePropertyChange("orgsize", oldOrgsize, orgsize);
    }

    public int getOrgsize() {
        return orgsize;
    }

    public void setTeamsize(int teamsize) {
        int oldTeamsize = this.teamsize;
        this.teamsize = teamsize;
        propertyChangeSupport.firePropertyChange("teamsize", oldTeamsize, teamsize);
    }

    public int getTeamsize() {
        return teamsize;
    }

    public void setOrgcompratioabove(int orgcompratioabove) {
        int oldOrgcompratioabove = this.orgcompratioabove;
        this.orgcompratioabove = orgcompratioabove;
        propertyChangeSupport.firePropertyChange("orgcompratioabove", oldOrgcompratioabove, orgcompratioabove);
    }

    public int getOrgcompratioabove() {
        return orgcompratioabove;
    }

    public void setOrgcompratioin(int orgcompratioin) {
        int oldOrgcompratioin = this.orgcompratioin;
        this.orgcompratioin = orgcompratioin;
        propertyChangeSupport.firePropertyChange("orgcompratioin", oldOrgcompratioin, orgcompratioin);
    }

    public int getOrgcompratioin() {
        return orgcompratioin;
    }

    public void setOrgcompratiobelow(int orgcompratiobelow) {
        int oldOrgcompratiobelow = this.orgcompratiobelow;
        this.orgcompratiobelow = orgcompratiobelow;
        propertyChangeSupport.firePropertyChange("orgcompratiobelow", oldOrgcompratiobelow, orgcompratiobelow);
    }

    public int getOrgcompratiobelow() {
        return orgcompratiobelow;
    }

    public void setOrgavgrating(double orgavgrating) {
        double oldOrgavgrating = this.orgavgrating;
        this.orgavgrating = orgavgrating;
        propertyChangeSupport.firePropertyChange("orgavgrating", oldOrgavgrating, orgavgrating);
    }

    public double getOrgavgrating() {
        return orgavgrating;
    }

    public void setOrgavgpotential(double orgavgpotential) {
        double oldOrgavgpotential = this.orgavgpotential;
        this.orgavgpotential = orgavgpotential;
        propertyChangeSupport.firePropertyChange("orgavgpotential", oldOrgavgpotential, orgavgpotential);
    }

    public double getOrgavgpotential() {
        return orgavgpotential;
    }

    public void setTotalattrition(int totalattrition) {
        int oldTotalattrition = this.totalattrition;
        this.totalattrition = totalattrition;
        propertyChangeSupport.firePropertyChange("totalattrition", oldTotalattrition, totalattrition);
    }

    public int getTotalattrition() {
        return totalattrition;
    }

}
