package model;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

public class ContactList
{
  public ContactList()
  {
    if (_contacts == null)
    {
      _contacts = _getDefaultContactsList();
    }
  }

  public List<Contact> getContacts()
  {
    return _contacts;
  }

  public int getContactCount()
  {
    return _contacts.size();
  }

  /**
   * Reset methodAction from the pageDef to restore the original contacts.
   */
  public void resetViaInserts()
  {
    // Perform an insert for each default contact that doesn't exist in the contact list:
    List<Contact> defaultContacts = _getDefaultContactsList();
    int count = defaultContacts.size();
    for (int d=0; d<count; ++d)
    {
      boolean added = false;
      Contact defaultContact = defaultContacts.get(d);
      String defaultContactKey = defaultContact.getKey();
      if (d >= getContactCount())
      {
        getContacts().add(defaultContact);
        added = true;
      }
      else
      {
        Contact existingContact = getContacts().get(d);
        if (!defaultContactKey.equals(existingContact.getKey()))
        {
          getContacts().add(d, defaultContact);
          added = true;
        }
      }

      if (added) // this was a contact that we needed to insert
      {
        _providerChangeSupport.fireProviderCreate(
          "contacts", defaultContactKey, defaultContact); // trigger change
      }
    }
  }

  /**
   * Reset methodAction from the pageDef to restore the original contacts.
   */
  public void reset()
  {
    _contacts = _getDefaultContactsList();
    _providerChangeSupport.fireProviderRefresh("contacts"); // trigger change
  }

  public void addProviderChangeListener(ProviderChangeListener pcl)
  {
    _providerChangeSupport.addProviderChangeListener(pcl);
  }

  public void removeProviderChangeListener(ProviderChangeListener pcl)
  {
    _providerChangeSupport.removeProviderChangeListener(pcl);
  }

  private List<Contact> _getDefaultContactsList()
  {
    List<Contact> contacts = new ArrayList<Contact>();
    contacts.add(new Contact(1, "Bob", "Billings", "123 Anywhere Dr", "Redwood City", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(2, "Dan", "Dublin", "66 Anywhere Dr", "Palo Alto", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(3, "Julia", "Jiles", "11 Anywhere Dr", "Pleasanton", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(4, "Bruce", "Johnson", "232 Anywhere Dr", "Milpitas", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(5, "Kent", "Kindling", "33 Anywhere Dr", "Millbrae", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(6, "Larry", "Leering", "3232 Anywhere Dr", "Tracy", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(7, "John", "Smith", "344 Anywhere Dr", "San Mateo", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(8, "Jane", "Smith", "55 Anywhere Dr", "Livermore", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(9, "Ted", "Tooling", "44 Anywhere Dr", "Los Angeles", "CA", "94065", "6503456789", "6501234567"));
    contacts.add(new Contact(10, "Travis", "Trails", "22 Anywhere Dr", "Dublin", "CA", "94065", "6503456789", "6501234567"));
    return contacts;
  }

  private static List<Contact> _contacts = null;
  private ProviderChangeSupport _providerChangeSupport = new ProviderChangeSupport(this);
}
