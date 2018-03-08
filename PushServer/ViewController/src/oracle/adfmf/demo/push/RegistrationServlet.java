package oracle.adfmf.demo.push;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.http.*;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.client.Configuration;
import oracle.jbo.server.ViewObjectImpl;

@SuppressWarnings("oracle.jdeveloper.java.serialversionuid-field-missing")
public class RegistrationServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private transient Logger LOGGER = Logger.getLogger(this.getClass().getName());

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        String userId = request.getParameter("userId");
        String senderId = request.getParameter("senderId");
        String deviceToken = request.getParameter("deviceToken");
        String deviceType = request.getParameter("deviceType");
        
        LOGGER.log(Level.SEVERE, "Registration invoked for : " + deviceToken + " : " + userId + " : " + deviceType);
        System.out.println("Registration invoked for : " + deviceToken + " : " + userId + " : " + deviceType);        
        
        boolean status = true;
        ApplicationModule applicationModule = null;
        
        try
        {
            if (deviceToken == null || deviceType == null || userId == null) {
                throw new Exception("Invalid registration params: " + deviceToken + " : " + userId + " : " + deviceType);    
            }

            applicationModule = Configuration.createRootApplicationModule("oracle.adfmf.demo.push.model.RegistrationModule",
                                                                          "RegistrationModuleLocal");
            
            if (applicationModule == null) {
                LOGGER.log(Level.SEVERE, "AM is null ");
                status = false;
            }
            
            ViewObjectImpl regVO = (ViewObjectImpl)applicationModule.findViewObject("RegistrationsView1");
            
            Row row = regVO.createRow();
            row.setAttribute("DeviceToken", deviceToken);
            row.setAttribute("DeviceModel", deviceType);
            row.setAttribute("UserId", userId);
            row.setAttribute("SenderId", senderId);
            row.setAttribute("ApplicationId", "com.oraclecorp.internal.maf.PushSample");
            
            regVO.insertRow(row);
            
            applicationModule.getTransaction().commit();
            
        }
        catch(Exception e) {
            status = false;
            LOGGER.log(Level.SEVERE, "Registration failed " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            if (applicationModule != null) {
              Configuration.releaseRootApplicationModule(applicationModule, false);
            }
        }
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>RegistrationServlet</title></head>");
        out.println("<body>");
        if (status) {
          out.println("<p>Successfully registered the user & device.</p>");
        } else {
          out.println("<p>Failed to register the user & device.</p>");
        }
        out.println("</body></html>");
        out.close();
    }
}
