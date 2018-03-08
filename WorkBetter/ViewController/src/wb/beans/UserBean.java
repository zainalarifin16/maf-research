package wb.beans;

import java.util.Date;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.amx.event.SelectionEvent;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class UserBean {
    private int userEmpid = -1;
    private String firstname;
    private String lastname;
    private String title;
    private String activitiesSize = "small";
    private String riskSize = "small";
    private String outcome = "profile";
    private String detailTab = "summary";
    private String orgListTab = "summary";
    private String orgListFilter = "alpha";
    private String directoryListMode = "rows";
    private static final long day = (long) (1000 * 60 * 60 * 24);
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);


    public UserBean() {
        super();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void Login(ActionEvent actionEvent) {
        try {
            AdfmfJavaUtilities.getELValue("#{bindings.login.execute}");
            AdfmfJavaUtilities.getELValue("#{bindings.resetAndGotoDashboard.execute}");
            AdfmfJavaUtilities.getELValue("#{bindings.resetMyOrg.execute}");
            AdfmfJavaUtilities.getELValue("#{bindings.resetMyProfile.execute}");
        }
        catch(AdfException e) {
            e.printStackTrace();
        }
    }

    public void Logout(ActionEvent actionEvent) {
        this.setUserEmpid(-1);
        this.setFirstname("");
        this.setLastname("");
        this.setTitle("");
    }

    public void setUserEmpid(int userEmpid) {
        int oldUserEmpid = this.userEmpid;
        this.userEmpid = userEmpid;
        propertyChangeSupport.firePropertyChange("userEmpid", oldUserEmpid, userEmpid);
    }

    public int getUserEmpid() {
        return userEmpid;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        propertyChangeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        propertyChangeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        propertyChangeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getTitle() {
        return title;
    }

    public void setOutcome(String outcome) {
        String oldOutcome = this.outcome;
        this.outcome = outcome;
        propertyChangeSupport.firePropertyChange("outcome", oldOutcome, outcome);
    }

    public String getOutcome() {
        return outcome;
    }
    
    public String fromOutcome() {
        return outcome;
    }

    public void setActivitiesSize(String activitiesSize) {
        String oldActivitiesSize = this.activitiesSize;
        this.activitiesSize = activitiesSize;
        propertyChangeSupport.firePropertyChange("activitiesSize", oldActivitiesSize, activitiesSize);
    }

    public String getActivitiesSize() {
        return activitiesSize;
    }

    public void setRiskSize(String riskSize) {
        String oldRiskSize = this.riskSize;
        this.riskSize = riskSize;
        propertyChangeSupport.firePropertyChange("riskSize", oldRiskSize, riskSize);
    }

    public String getRiskSize() {
        return riskSize;
    }

    public void setDetailTab(String detailTab) {
        String oldDetailTab = this.detailTab;
        this.detailTab = detailTab;
        propertyChangeSupport.firePropertyChange("detailTab", oldDetailTab, detailTab);
    }

    public String getDetailTab() {
        return detailTab;
    }

    public void setOrgListTab(String orgListTab) {
        String oldOrgListTab = this.orgListTab;
        this.orgListTab = orgListTab;
        propertyChangeSupport.firePropertyChange("orgListTab", oldOrgListTab, orgListTab);
    }

    public String getOrgListTab() {
        return orgListTab;
    }

    public void setOrgListFilter(String orgListFilter) {
        String oldOrgListFilter = this.orgListFilter;
        this.orgListFilter = orgListFilter;
        propertyChangeSupport.firePropertyChange("orgListFilter", oldOrgListFilter, orgListFilter);
    }

    public String getOrgListFilter() {
        return orgListFilter;
    }

    public void setDirectoryListMode(String directoryListMode) {
        String oldDirectoryListMode = this.directoryListMode;
        this.directoryListMode = directoryListMode;
        propertyChangeSupport.firePropertyChange("directoryListMode", oldDirectoryListMode, directoryListMode);
    }

    public String getDirectoryListMode() {
        return directoryListMode;
    }

    public void nBoxSelectionHandler(SelectionEvent selectionEvent) {
        AdfmfJavaUtilities.setELValue("#{pageFlowScope.drillEmpid}", selectionEvent.getSelectedRowKeys()[0]);
        
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureId(),
                                                                   "adf.mf.api.amx.doNavigation", new Object[] { "empDrill" });        
    }
    
    public Date getTimelineStart() {
        return new Date(new Date().getTime() - (7 * day));
    }

    public Date getTimelineEnd() {
        return new Date(getTimelineStart().getTime() + (180 * day));
    }
    
    public Date getTimelineViewportEnd() {
        return new Date(getTimelineStart().getTime() + (60 * day));        
    }

}
