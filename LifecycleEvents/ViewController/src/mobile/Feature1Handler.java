package mobile;

import java.util.logging.Level;

import oracle.adfmf.feature.LifeCycleListener;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class Feature1Handler implements LifeCycleListener {
    public Feature1Handler() {
        super();
    }

    public void activate() {
        Trace.log(Utility.ApplicationLogger, Level.SEVERE, Feature1Handler.class, "activate",
                  "!!!!!!!!!!Feature 1 Activate!!!!!!!!!!");
    }

    public void deactivate() {
        Trace.log(Utility.ApplicationLogger, Level.SEVERE, Feature1Handler.class, "deactivate",
                  "!!!!!!!!!!Feature 1 Deactivate!!!!!!!!!!");
    }
}
