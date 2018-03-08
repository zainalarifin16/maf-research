package crudmodel;

import crud.application.DBConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.logging.Level;

import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class Service {
    List<Person> people = new ArrayList<Person>();
    protected transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    public Service() {
        super();
    }

    public void addProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.removeProviderChangeListener(l);
    }

    public List<Person> getPerson() {
        if( people.isEmpty()) {
            executeQuery();
        }
        return people;
    }

    public void executeQuery() {
        people.clear();
        try {
            Connection conn = DBConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE ORDER BY LASTNAME");

            rs.beforeFirst();
            while (rs.next()) {
                int id = rs.getInt("PERID");
                String first = rs.getString("FIRSTNAME");
                if (first.equals("null")) {
                    first = "";
                }
                String last = rs.getString("LASTNAME");
                if (last.equals("null")) {
                    last = "";
                }
                String email = rs.getString("EMAIL");
                if (email.equals("null")) {
                    email = "";
                }
                String phone = rs.getString("PHONE");
                if (phone.equals("null")) {
                    phone = "";
                }
                Date birth = rs.getDate("BIRTH_DATE");
                if (rs.wasNull()) {
                    birth = null;
                }
                String address = rs.getString("ADDRESS");
                if (address.equals("null")) {
                    address = "";
                }
                String city = rs.getString("CITY");
                if (city.equals("null")) {
                    city = "";
                }
                String state = rs.getString("STATE");
                if (state.equals("null")) {
                    state = "";
                }
                Person p = new Person(id, first, last, email, phone, birth, address, city, state);
                people.add(p);
            }
            providerChangeSupport.fireProviderRefresh("person");
        } catch (SQLException e) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Service.class, "executeQuery",
                      "##############SQL Exception:  " + e.getMessage());
            e.printStackTrace();
        } catch (Exception exception) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Service.class, "executeQuery",
                      "##############Exception:  " + exception.getMessage());

        }
    }

    // This method is called by the framework when the Create operation is called
    // The framework will take care of firing the provider change event for us
    public void addPerson(Person person) {
        try {
            Connection conn = DBConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();

            int newId = 1;

            ResultSet rs = stmt.executeQuery("SELECT MAX(PERID) FROM PEOPLE");
            rs.beforeFirst();
            if (rs.next()) {
                newId = rs.getInt(1) + 1;
            }
            person.setId(newId);
            
        } catch (SQLException e) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Service.class, "saveToStore",
                      "##############SQL Exception:  " + e.getMessage());
            e.printStackTrace();
        } catch (Exception exception) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Service.class, "saveToStore",
                      "##############Exception:  " + exception.getMessage());

        }
    }
    
    public void removePerson( Person person) {
        person.deleteFromStore();
    }
}
