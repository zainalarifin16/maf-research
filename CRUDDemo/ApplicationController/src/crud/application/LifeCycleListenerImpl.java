package crud.application;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import oracle.adfmf.application.LifeCycleListener;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

/**
 * The application life cycle listener provides the basic structure for developers needing
 * to include their own functionality during the different stages of the application life
 * cycle.  Please note that there is <b>no user</b> associated with any of the following
 * methods.
 *
 * Common examples of functionality that might be added:
 *
 * start:
 *   1. determine if the application has updates
 *   2. determine if there already exists a local application database image
 *   3. setup any one time state for the application
 *
 * activate:
 *   1. read any application cache stores and re-populate state (if needed)
 *   2. establish/re-establish any database connections and cursors
 *   3. process any pending web-service requests
 *   4. obtain any required resources
 *
 * deactivate:
 *   1. write any restorable state to an application cache store
 *   2. close any database cursors and connections
 *   3. defer any pending web-service requests
 *   4. release held resources
 *
 * stop:
 *   1. logoff any remote services
 *
 * NOTE:
 * 1. In order for the system to recognize an application life cycle listener
 *    it must be registered in the maf-application.xml file.
 * 2. Application assemblers must implement this interface if they would like to
 *    receive notification of application start, hibernation, and application resume.
 *    If a secure web service is needed, you will need to do this from your 'default'
 *    feature where you will have an associated user.
 *
 * @see oracle.adfmf.application.LifeCycleListener
 */
public class LifeCycleListenerImpl implements LifeCycleListener {
    public LifeCycleListenerImpl() {
    }

    /**
     * The start method will be called at the start of the application.
     *
     * NOTE:
     * 1. This is a <b>blocking</b> call and will freeze the user interface
     *    while the method is being executed.  If you have any longer running
     *    items you should create a background thread and do the work there.
     * 2. Only the application controller's classes will be available in this
     *    method.
     * 3. At this stage, only an anonymous user is associated with the application
     *    so do not attempt to call any secure web services in this method.
     */
    public void start() {
        Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "start",
                  "##############App Start");
        try {
            Connection connection = DBConnectionFactory.getConnection();
            Statement stat = DBConnectionFactory.getConnection().createStatement();
            ResultSet rs = stat.executeQuery("SELECT PERID FROM PEOPLE WHERE PERID = -1;");
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "start",
                      "##############Database does not exist, creating it");
            InitDB();
        } catch (Exception e) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, LifeCycleListenerImpl.class, "start",
                      "##############Exception:  " + e.getMessage());
        }
        Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "start",
                  "##############App Start Complete");
    }

    /**
     * The stop method will be called at the termination of the application.
     *
     * NOTE:
     * 1. Depending on how the application is being shutdown, this method may
     *    or may not be called. For example, if a user kills the Application from
     *    the iOS multitask UI then stop will not be called.  Because of this, each
     *    feature should save off their state in the deactivate handler.
     * 2. Only the application controller's classes will be available in this
     *    method.
     * 3. At this stage, only an anonymous user is associated with the application
     *    so do not attempt to call any secure web services in this method.
     */
    public void stop() {
        // Add code here...
    }

    /**
     * The activate method will be called when the application is started (post
     * the start method) and when an application is resumed by the operating
     * system.  If the application supports checkpointing, this is a place where
     * the application should read the checkpoint information and resume the process.
     *
     * NOTE:
     * 1. This is a <b>blocking</b> call and will freeze the user interface
     *    while the method is being executed.  If you have any longer running
     *    items you should create a background thread and do the work there.
     * 2. Only the application controller's classes will be available in this
     *    method.
     * 3. At this stage, only an anonymous user is associated with the application
     *    so do not attempt to call any secure web services in this method.
     * 4. Once an application is activated, the visible feature's activate lifecycle
     *    method will be executed (if configured) post this method being called.
     */
    public void activate() {
        // Add code here...
    }

    /**
     * The deactivate method will be called as part of the application shutdown
     * process or when the application is being deactivated/hibernated by the
     * operating system.  This is the place where application developers would
     * write application checkpoint information in either a database or a "device
     * only" file so if the application is terminated while in the background
     * the application can resume the process when the application is reactivated.
     *
     * NOTE:
     * 1. This is a <b>blocking</b> call and will freeze the user interface
     *    while the method is being executed.  If you have any longer running
     *    items you should create a background thread and do the work there.
     * 2. Only the application controller's classes will be available in this
     *    method.
     * 3. At this stage, only an anonymous user is associated with the application
     *    so do not attempt to call any secure web services in this method.
     * 4. When an application is being deactivated, the visible feature's
     *    deactivate lifecycle method will be executed (if configured) prior to
     *    this method being called.
     */
    public void deactivate() {
        // Add code here...
    }

    private void InitDB() {
        try {
            Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "InitDB",
                      "##############initDB Start");
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            InputStream is = cl.getResourceAsStream(".adf/META-INF/people.sql");
            if (is == null) {
                Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "InitDB",
                          "##############Could not look up : /META-INF/people.sql");
                return;
            }

            BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
            List<String> stmts = new ArrayList<String>();
            String strstmt = "";
            String ln = bReader.readLine();
            while (ln != null) {
                if (ln.startsWith("REM") || ln.startsWith("COMMIT")) {
                    ln = bReader.readLine();
                    continue;
                }
                strstmt = strstmt + ln;
                if (strstmt.endsWith(";")) {
                    Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "InitDB",
                              "##############" + strstmt);
                    stmts.add(strstmt);
                    strstmt = "";
                    ln = bReader.readLine();
                    continue;
                }
                ln = bReader.readLine();

            }

            for (int i = 0; i < stmts.size(); i++) {
                Statement pStmt = DBConnectionFactory.getConnection().createStatement();
                pStmt.executeUpdate((String) stmts.get(i));

            }
            DBConnectionFactory.getConnection().commit();
            Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "InitDB",
                      "##############InitDB Complete");
        } catch (Exception e) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, LifeCycleListenerImpl.class, "InitDB",
                      "##############Exception:  " + e.getMessage());
        }

    }

}
