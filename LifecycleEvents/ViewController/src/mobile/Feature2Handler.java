package mobile;

import java.util.logging.Level;

import oracle.adfmf.feature.LifeCycleListener;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class Feature2Handler implements LifeCycleListener {
    public Feature2Handler() {
        super();
    }

    public void activate() {
        Trace.log(Utility.ApplicationLogger, Level.SEVERE, Feature2Handler.class, "activate",
                  "!!!!!!!!!!Feature 2 Activate!!!!!!!!!!");
    }

    public void deactivate() {
        Trace.log(Utility.ApplicationLogger, Level.SEVERE, Feature2Handler.class, "deactivate",
                  "!!!!!!!!!!Feature 2 Deactivate!!!!!!!!!!");
    }
}
