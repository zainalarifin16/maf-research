package RestServiceProject;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Request {
    public Request() {
        super();
    }
    
    private String userId;
    private ArrayList<String> filterMask = new ArrayList<String>();
    private ArrayList<String> privilegeFilter = new ArrayList<String>();
    private ArrayList<String> roleFilter = new ArrayList<String>();

    public void setUserId(String UserId) {
        this.userId = UserId;
    }

    public String getUserId() {
        return userId;
    }

    public void setFilterMask(ArrayList<String> FilterMask) {
        this.filterMask = FilterMask;
    }

    public ArrayList<String> getFilterMask() {
        return filterMask;
    }

    public void setPrivilegeFilter(ArrayList<String> PrivilegeFilter) {
        this.privilegeFilter = PrivilegeFilter;
    }

    public ArrayList<String> getPrivilegeFilter() {
        return privilegeFilter;
    }

    public void setRoleFilter(ArrayList<String> RoleFilter) {
        this.roleFilter = RoleFilter;
    }

    public ArrayList<String> getRoleFilter() {
        return roleFilter;
    }
}
