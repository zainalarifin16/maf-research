package application;

import java.util.logging.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import oracle.adfmf.application.LifeCycleListener;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class LifeCycleListenerImpl implements LifeCycleListener
{
  public LifeCycleListenerImpl()
  {
  }

  /**
   * The start method will be called at the start of the application. Only the
   * Application Lifecycle Event listener will be called on start up.
   */
  public void start()
  {
    // Add code here...
  }

  /**
   * The stop method will be called at the termination of the application. Only
   * the Application Lifecycle Event listener will be called on start up.
   * 
   * NOTE: Depending on how the application is being shutdown, this method may 
   * or may not be called. Features should save off their state in the deactivate
   * handler.
   */
  public void stop()
  {
    // Add code here...
  }

  /**
   * The activate method will be called when the feature is activated. The
   * Application Lifecycle Event listener will be called on application
   * being started and resumed.
   */
  public void activate() {
      Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "activate",
                "##############activate Start");
      ClassLoader cl = Thread.currentThread().getContextClassLoader();

      String files[] =
      { "doc.doc", "mp4.mp4", "pdf.pdf", "ppt.pptx", "xls.xlsx","png.png" };

      for (int x = 0; x < files.length; x++) {

          try {
              String outFile =
                  AdfmfJavaUtilities.getDirectoryPathRoot(AdfmfJavaUtilities.DownloadDirectory) + "/" + files[x];
              

              // If the file already exists, just continue to the next one
              // We do this in a scoped section so that the File goes out of scope and releases itself
              {
                  File f = new File(outFile);
                  if (f != null && f.exists()) {
                      continue;
                  }
              }

              InputStream in = cl.getResourceAsStream(".adf/META-INF/" + files[x]);
              FileOutputStream out = new FileOutputStream(outFile);
              
              int totalBytesAvailable=in.available();
              
              byte[] buffer = new byte[totalBytesAvailable];
                           int result = 0;
                           while ((result = in.read(buffer)) > 0)
                           {
                             out.write(buffer, 0, result);
                           }

              
              
              in.close();
              out.close();

              Trace.log(Utility.ApplicationLogger, Level.INFO, LifeCycleListenerImpl.class, "InitDB",
                        "##############InitDB Complete");
          } catch (FileNotFoundException e) {
              Trace.log(Utility.ApplicationLogger, Level.SEVERE, LifeCycleListenerImpl.class, "copyDB",
                        "##############Exception:  " + e.getMessage());
          } catch (IOException e) {
              Trace.log(Utility.ApplicationLogger, Level.SEVERE, LifeCycleListenerImpl.class, "copyDB",
                        "##############Exception:  " + e.getMessage());
          }
      }
  }

  /**
   * The deactivate method will be called when the feature is deactivated. The
   * Application Lifecycle Event listener will be called on application
   * being hibernated.
   */
  public void deactivate()
  {
    // Add code here...
  }
}
