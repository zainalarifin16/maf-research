package RestServiceProject;

import java.security.Principal;

import java.util.*;

import javax.security.auth.Subject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import oracle.security.jps.principals.JpsPrincipalType;
import oracle.security.jps.util.SubjectUtil;

@Path("/roles")
public class Service {

    static HashMap<String, UserObjects> UserObjectMap = new HashMap<String, UserObjects>();

    public Service() {
        super();

    }

    @Context
    private HttpServletRequest httpreq;

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public UserObjects getUserObject() throws Exception {
        
        Subject sub = SubjectUtil.getCurrentSubject();
        Set<Principal> roles = SubjectUtil.getJpsPrincipals(sub, JpsPrincipalType.JPS_APPLICATION_ROLE);
        
        String currentUser = SubjectUtil.getUserName(sub);
        System.out.println("UserId from Subject : " + currentUser + " : " + SubjectUtil.getUserUniqueIdentifier(sub));
        ArrayList<String> retRoles = new ArrayList();
        for (Principal p : roles) {
            System.out.println("JPS Application Role name: " + p.getName());
            retRoles.add(p.getName());
        }
        ArrayList<String> retPrivs = new ArrayList();
        
        UserObjects obj = new UserObjects(currentUser, retRoles, retPrivs);
        return obj;
    }



    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public UserObjects getUserObject(Request request) throws Exception {
        System.out.println(request.getFilterMask());
        System.out.println(request.getRoleFilter().get(0));
        System.out.println(request.getPrivilegeFilter());

        Subject sub = SubjectUtil.getCurrentSubject();
        String userId = SubjectUtil.getUserUniqueIdentifier(sub);
        System.out.println("UserId from Subject : " + userId);

        Set<Principal> roles = SubjectUtil.getJpsPrincipals(sub, JpsPrincipalType.JPS_APPLICATION_ROLE);
        for (Principal p : roles) {
            System.out.println("JPS Application Role name: " + p.getName());
        }

        UserObjects obj = new UserObjects(userId);

        if (request.getFilterMask().contains("role")) {
            System.out.println("Filtering roles");
            obj.filterRoles(request.getRoleFilter(), roles);
        }

        /*if (request.getFilterMask().contains("privilege"))
      {
        System.out.println(request.getPrivilegeFilter());
        obj.filterPrivileges(request.getPrivilegeFilter());
      }*/

        /*Cookie c[] = httpreq.getCookies();
        if (c != null) {
            for (int i = 0; i < c.length; i++) {
                obj.injectCookieResponse(c[i].getName());
            }
        }*/
        return obj;
    }

    /*private void printHashMap() {
        System.out.println("Number of entries = " + UserObjectMap.size());
        Set mapSet = UserObjectMap.entrySet();
        Iterator itr = mapSet.iterator();
        while (itr.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) itr.next();
            UserObjects userObjs = (UserObjects) mapEntry.getValue();
            if (null != userObjs) {
                String username = userObjs.getUserId();

                ArrayList<String> roles = userObjs.getRoles();
                ArrayList<String> privs = userObjs.getPrivileges();

                System.out.println("Username: " + username);
                System.out.println("  Roles:");
                for (int j = 0; j < roles.size(); j++) {
                    System.out.println("    " + roles.get(j));
                }

                System.out.println("  Privileges:");
                for (int j = 0; j < privs.size(); j++) {
                    System.out.println("    " + privs.get(j));
                }
            }
        }
    }*/
}
