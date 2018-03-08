package Contacts;

import java.util.ArrayList;
import java.util.List;

import javax.el.ValueExpression;

import oracle.adf.model.datacontrols.device.DeviceManager;
import oracle.adf.model.datacontrols.device.DeviceManagerFactory;

import oracle.adf.model.datacontrols.device.Contact;

import oracle.adfmf.amx.event.ValueChangeEvent;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class ContactBean {
    String contactFields = "birthday,displayname,id,nickname,note,addresses,categories,emails,ims,name,organizations,phoneNumbers,photos,urls";
    
    String filter = "";
    boolean multiple = true;
    
    List<ContactField> contactFieldsList ;
    ContactField birthday;
    ContactField displayname;
    ContactField nickname;
    ContactField note;
    ContactField addresses;    
    ContactField categories;
    ContactField emails;
    ContactField ims;
    ContactField name;
    ContactField organizations;
    ContactField phoneNumbers;
    ContactField photos;
    ContactField urls;
    ContactField id;
    
    
    
    

    public void setContactFieldsList(List<ContactField> contactFieldsList) {
        List<ContactField> oldContactFieldsList = this.contactFieldsList;
        this.contactFieldsList = contactFieldsList;
        propertyChangeSupport.firePropertyChange("contactFieldsList", oldContactFieldsList, contactFieldsList);
    }

    public List<ContactField> getContactFieldsList() {
        return contactFieldsList;
    }

    public void setBirthday(ContactField birthday) {
        ContactField oldBirthday = this.birthday;
        this.birthday = birthday;
        propertyChangeSupport.firePropertyChange("birthday", oldBirthday, birthday);
    }

    public ContactField getBirthday() {
        return birthday;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        PropertyChangeSupport oldPropertyChangeSupport = this.propertyChangeSupport;
        this.propertyChangeSupport = propertyChangeSupport;
        propertyChangeSupport.firePropertyChange("propertyChangeSupport", oldPropertyChangeSupport,
                                                 propertyChangeSupport);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }


    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ContactBean() {
        super();
        contactFieldsList=new ArrayList();
        
        birthday=new ContactField("birthday",true);
        displayname=new ContactField("displayname",true);
        nickname=new ContactField("nickname",true);
        note=new ContactField("note",true);
        addresses=new ContactField("addresses",true);
        categories=new ContactField("categories",true);
        emails=new ContactField("emails",true);
        ims=new ContactField("ims",true);
        name=new ContactField("name",true);
        organizations=new ContactField("organizations",true);
        phoneNumbers=new ContactField("phoneNumbers",true);
        photos=new ContactField("photos",true);
        urls=new ContactField("urls",true);
        id=new ContactField("id",true);
      
        contactFieldsList.add(birthday);
        contactFieldsList.add(displayname);
        contactFieldsList.add(nickname);
        contactFieldsList.add(note);
        contactFieldsList.add(addresses);
        contactFieldsList.add(categories);
        contactFieldsList.add(emails);
        contactFieldsList.add(ims);
        contactFieldsList.add(name);
        contactFieldsList.add(organizations);
        contactFieldsList.add(phoneNumbers);
        contactFieldsList.add(photos);
        contactFieldsList.add(urls);
        contactFieldsList.add(id);
        
        
        
    }

    public void setContactFields(String contactFields) {
        String oldContactFields = this.contactFields;
        this.contactFields = contactFields;
        propertyChangeSupport.firePropertyChange("contactFields", oldContactFields, contactFields);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getContactFields() {
        String list="";
        int size=contactFieldsList.size();
        for(int i=0;i<size;i++){
            ContactField contactFieldObj=(ContactField)contactFieldsList.get(i);
            boolean status=contactFieldObj.isFieldStatus();
            String fieldName=contactFieldObj.getFieldName();
            if(status && i!=(size-1)){
              list+=fieldName+",";
            }else{
              list+=fieldName;
            }
        }
        
        return list;
    }

    public void setFilter(String filter) {
        String oldFilter = this.filter;
        this.filter = filter;
        propertyChangeSupport.firePropertyChange("filter", oldFilter, filter);
    }

    public String getFilter() {
        return filter;
    }

    public void setMultiple(boolean multiple) {
        boolean oldMultiple = this.multiple;
        this.multiple = multiple;
        propertyChangeSupport.firePropertyChange("multiple", oldMultiple, multiple);
    }

    public boolean isMultiple() {
        return multiple;
    }
    
  
    
    public void findContacts() {
        DeviceManager deviceManager = DeviceManagerFactory.getDeviceManager();
        Contact[] cons = deviceManager.findContacts(contactFields, filter, multiple);
    }

    public void valueChangeHandler(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
       String newvalue= (String)valueChangeEvent.getNewValue();
       AdfmfJavaUtilities.setELValue("#{pageFlowScope.valuechange}", newvalue); 
    }
}
