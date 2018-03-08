package RestServiceProject;

import java.security.Principal;

import java.util.ArrayList;

import java.util.Set;

import javax.security.auth.Subject;

import javax.xml.bind.annotation.XmlRootElement;

import oracle.security.jps.util.SubjectUtil;

@XmlRootElement
public class UserObjects {
    public UserObjects() {
        super();

    }

    private String UserId;
    private ArrayList<String> Privileges = new ArrayList<String>();
    private ArrayList<String> Roles = new ArrayList<String>();

    public UserObjects(String name, ArrayList<String> roles, ArrayList<String> privs) {
        super();
        this.UserId = name;
        this.Roles = roles;
        this.Privileges = privs;

    }

    public UserObjects(String userId) {
        super();
        this.UserId = userId;
    }

    public void setUserId(String name) {
        this.UserId = name;
    }

    public String getUserId() {
        return UserId;
    }

    public void setRoles(ArrayList<String> roles) {
        this.Roles = roles;
    }

    public ArrayList<String> getRoles() {
        return Roles;
    }

    public void setPrivileges(ArrayList<String> privileges) {
        this.Privileges = privileges;
    }

    public ArrayList<String> getPrivileges() {
        return Privileges;
    }

    public void filterPrivileges(ArrayList<String> filter) {
        ArrayList<String> filteredPrivileges = new ArrayList<String>();

        for (String item : filter) {
            if (Privileges.contains(item)) {
                filteredPrivileges.add(item);
            }
        }
        Privileges = filteredPrivileges;
    }

    public void filterRoles(ArrayList<String> filter, Set<Principal> roles) {
        ArrayList<String> filteredRoles = new ArrayList<String>();
        Subject sub = SubjectUtil.getCurrentSubject();
        if (filter == null || filter.isEmpty()) {
            System.out.println("Role filter is null");
            for (Principal role : roles) {
                filteredRoles.add(role.getName());
            }
        } else {
            for (String fRole : filter) {
                System.out.println("Checking for role: " + fRole);
                if (SubjectUtil.isUserInAppRole(sub, fRole)) {
                    System.out.println("Found role:" + fRole);
                    filteredRoles.add(fRole);
                }
            }
        }
        try {

            // Due to an issue with getting current user principals from JPS hardcoding the roles
            if (!filteredRoles.contains("IC_ROLE") && !filteredRoles.contains("MGR_ROLE")) {
                if (SubjectUtil.getUserUniqueIdentifier(sub).equalsIgnoreCase("james")) {
                    System.out.println("Adding role: IC_ROLE");
                    filteredRoles.add("IC_ROLE");
                } else {
                    System.out.println("Adding role: MGR_ROLE");
                    filteredRoles.add("MGR_ROLE");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Roles = filteredRoles;
    }

    void injectCookieResponse(String cookieName) {
        Roles.add("COOKIE___" + cookieName);
    }
}
