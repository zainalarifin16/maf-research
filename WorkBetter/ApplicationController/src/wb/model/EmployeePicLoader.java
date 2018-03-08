package wb.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.util.HashMap;

import javax.microedition.io.HttpConnection;

import oracle.maf.api.dc.ws.rest.RestServiceAdapterFactory;
import oracle.maf.api.dc.ws.rest.RestServiceAdapter;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.Model;

public class EmployeePicLoader implements Runnable {
    private Employee emp = null;
    private String localfile = null;
    private boolean isMgr = false;

    public EmployeePicLoader(Employee emp, String localfile, boolean isMgr) {
        this.emp = emp;
        this.localfile = localfile;
        this.isMgr = isMgr;
    }

    @Override
    public void run() {
        try {
            int empid;
            if( !isMgr ) {
                empid = emp.getEmpid();
            } else {
                empid = emp.getMgrid();
            }
            
            // The file doesn't exist so fetch it from the server
            RestServiceAdapterFactory factory = RestServiceAdapterFactory.newFactory();
            RestServiceAdapter rs = factory.createRestServiceAdapter();            // Clear any previously set request properties, if any
            rs.clearRequestProperties();

            // Set the connection name
            rs.setConnectionName("WBService");

            // Specify the type of request
            rs.setRequestMethod(RestServiceAdapter.REQUEST_TYPE_GET);   

            rs.addRequestProperty("Oracle-Mobile-Backend-Id", WBUtils.MBEID);
            rs.addRequestProperty("Authorization", WBUtils.MBESECRET);

            // Specify the number of retries
            rs.setRetryLimit(0);

            String request = WBUtils.imageURL + empid + ".png";

            HttpConnection conn = rs.getHttpConnection(RestServiceAdapter.REQUEST_TYPE_GET, request, new HashMap());
            InputStream is = rs.getInputStream(conn);

            ByteArrayOutputStream byStream = new ByteArrayOutputStream();

            int res = 0;
            int bufsize = 0, bufread = 0;

            byte[] data = (bufsize > 0) ? new byte[bufsize] : new byte[1024];

            // Use the input stream to read data
            while ((res = is.read(data)) > 0) {
                byStream.write(data, 0, res);
                bufread = bufread + res;
            }
            FileOutputStream outfile = new FileOutputStream(localfile);
            outfile.write(byStream.toByteArray());
            outfile.close();

            if( !isMgr ) {
                emp.setPic("file://" + localfile);
            } else {
                emp.setMgrPic("file://" + localfile);
            }
            AdfmfJavaUtilities.flushDataChangeEvent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
