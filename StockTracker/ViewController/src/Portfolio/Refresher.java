package Portfolio;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.MafExecutorService;

public class Refresher implements Runnable {

    public Refresher() {
        super();
    }

    Portfolio p = null;

    public Refresher(Portfolio p) {
        this.p = p;
    }

    boolean go = false;

    public void run()
    {
      Thread.currentThread().setName("DataUpdateThread");
      while (true)
      {
        if (go)
        {
          MafExecutorService.execute(new Runnable()
          {
            public void run()
            {
              p.doChange();
              AdfmfJavaUtilities.flushDataChangeEvent();
            }
          });
        }

        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          System.out.print(e);
        }
      }
    }    
    
}
