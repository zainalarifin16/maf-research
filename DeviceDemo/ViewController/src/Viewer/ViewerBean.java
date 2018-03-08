package Viewer;

import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;

import java.nio.charset.Charset;

import java.util.logging.Level;

import oracle.adf.model.datacontrols.device.DeviceManager;

import oracle.adf.model.datacontrols.device.DeviceManagerFactory;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.util.Utility;

public class ViewerBean {
    String document = "doc.doc";
    String file;
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ViewerBean() {
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        String oldDocument = this.document;
        this.document = document;
        propertyChangeSupport.firePropertyChange("document", oldDocument, document);
    }

    public void setFile(String file) {
        String oldFile = this.file;
        this.file = file;
        propertyChangeSupport.firePropertyChange("file", oldFile, file);
    }

    public String getFile() {
        return file;
    }

    public void viewerHandler(ActionEvent actionEvent) {
        String dir = AdfmfJavaUtilities.getDirectoryPathRoot(AdfmfJavaUtilities.DownloadDirectory);
        try {
            // encode file name
            String encodedDoc = URLEncoder.encode(document, Charset.defaultCharset().toString());
            String path = "file://" + dir + "/" + encodedDoc;
            // Some encoding is necessary on the URL so it doesn't have spaces
            // replace " " with "%20"
            StringBuffer buffer = new StringBuffer();
            String replacedString = " ";
            String replacement = "%20";
            int index = 0, previousIndex = 0;
            index = path.indexOf(replacedString, index);
            while (index != -1) {
                buffer.append(path.substring(previousIndex, index)).append(replacement);
                previousIndex = index + 1;
                index = path.indexOf(replacedString, index + replacedString.length());
            }
            buffer.append(path.substring(previousIndex, path.length()));

            setFile(buffer.toString());

            DeviceManager dm = DeviceManagerFactory.getDeviceManager();
            dm.displayFile(buffer.toString(), document);

        } catch (UnsupportedEncodingException e) {
            Utility.ApplicationLogger.logp(Level.SEVERE, this.getClass().getName(), "viewerHandler", e.getMessage());
        }
    }

}
