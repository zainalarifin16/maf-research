package crudmodel;

import crud.application.DBConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;

import java.util.logging.Level;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

public class Person {
    protected int id = -1;
    protected String first;
    protected String last;
    protected String email;
    protected String phone;
    protected Date birthDate;
    protected String address;
    protected String city;
    protected String state;
    private transient PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Person() {
    }

    public Person(Person newper) {
        copy(newper);
    }

    public Person(int id, String first, String last, String email, String phone, Date birthDate, String address,
                  String city, String state) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    private void copy(Person newper) {
        setId(newper.id);
        setFirst(newper.first);
        setLast(newper.last);
        setEmail(newper.email);
        setPhone(newper.phone);
        setBirthDate(newper.birthDate);
        setAddress(newper.address);
        setCity(newper.city);
        setState(newper.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public int getId() {
        return id;
    }

    public void setFirst(String first) {
        String oldFirst = this.first;
        this.first = first;
        propertyChangeSupport.firePropertyChange("first", oldFirst, first);
    }

    public String getFirst() {
        return first;
    }

    public void setLast(String last) {
        String oldLast = this.last;
        this.last = last;
        propertyChangeSupport.firePropertyChange("last", oldLast, last);
    }

    public String getLast() {
        return last;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        propertyChangeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getEmail() {
        return email;
    }

    public void setBirthDate(Date birthDate) {
        Date oldBirthDate = this.birthDate;
        this.birthDate = birthDate;
        propertyChangeSupport.firePropertyChange("birthDate", oldBirthDate, birthDate);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        propertyChangeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        propertyChangeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
        propertyChangeSupport.firePropertyChange("state", oldState, state);
    }

    public String getState() {
        return state;
    }

    public void reloadFromStore() {
        try {
            Connection conn = DBConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE WHERE PERID = " + this.id);

            rs.beforeFirst();
            if (rs.next()) {
                this.setFirst(rs.getString("FIRSTNAME"));
                this.setLast(rs.getString("LASTNAME"));
                this.setEmail(rs.getString("EMAIL"));
                if (getEmail().equals("null")) {
                    this.setEmail("");
                }
                this.setPhone(rs.getString("PHONE"));
                if (getPhone().equals("null")) {
                    this.setPhone("");
                }
                this.setBirthDate(rs.getDate("BIRTH_DATE"));
                if (rs.wasNull()) {
                    this.setBirthDate(null);
                }
                this.setAddress(rs.getString("ADDRESS"));
                if (getAddress().equals("null")) {
                    this.setAddress("");
                }
                this.setCity(rs.getString("CITY"));
                if (getCity().equals("null")) {
                    this.setCity("");
                }
                this.setState(rs.getString("STATE"));
                if (getState().equals("null")) {
                    this.setState("");
                }
            }
        } catch (SQLException e) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Person.class, "reloadFromStore",
                      "##############SQL Exception:  " + e.getMessage());
            e.printStackTrace();
        } catch (Exception exception) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Person.class, "reloadFromStore",
                      "##############Exception:  " + exception.getMessage());

        }
    }

    public void saveToStore() {
        try {
            Connection conn = DBConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "";
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE WHERE PERID = " + this.id);
            rs.beforeFirst();
            if (rs.next()) {
                sql =
                    "UPDATE PEOPLE SET FIRSTNAME='" + this.getFirst() + "', LASTNAME='" + this.getLast() +
                    "', EMAIL='" + this.getEmail() + "', PHONE='" + this.getPhone() + "', BIRTH_DATE='" +
                    formatDate(this.getBirthDate()) + "', ADDRESS='" + this.getAddress() + "', CITY='" +
                    this.getCity() + "', STATE='" + this.getState() + "' WHERE PERID=" + this.getId();
            } else {
                sql =
                    "INSERT INTO PEOPLE (PERID,FIRSTNAME,LASTNAME,EMAIL,PHONE,BIRTH_DATE,ADDRESS,CITY,STATE) VALUES (" +
                    this.getId() + ",'" + this.getFirst() + "','" + this.getLast() + "','" + this.getEmail() + "','" +
                    this.getPhone() + "','" + formatDate(this.getBirthDate()) + "','" + this.getAddress() + "','" +
                    this.getCity() + "','" + this.getState() + "')";
            } 
            
           
                int updateCount = stmt.executeUpdate(sql);
                if (updateCount == 0) {
                    Trace.log(Utility.ApplicationLogger, Level.SEVERE, Person.class, "saveToStore", "Update Failed!");
                }
            
            
            conn.commit();
        } catch (SQLException e) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Person.class, "saveToStore",
                      "##############SQL Exception:  " + e.getMessage());
            e.printStackTrace();
        } catch (Exception exception) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Person.class, "saveToStore",
                      "##############Exception:  " + exception.getMessage());

        }
    }

    public void deleteFromStore() {
        try {
            Connection conn = DBConnectionFactory.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE WHERE PERID = " + this.id);
            rs.beforeFirst();
            if (rs.next()) {
                String sql = "DELETE FROM PEOPLE WHERE PERID = " + this.id;

                int updateCount = stmt.executeUpdate(sql);
                if (updateCount == 0) {
                    Trace.log(Utility.ApplicationLogger, Level.SEVERE, Person.class, "deleteFromStore",
                              "Delete Failed!");
                }
            }
            conn.commit();
        } catch (SQLException e) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Person.class, "deleteFromStore",
                      "##############SQL Exception:  " + e.getMessage());
            e.printStackTrace();
        } catch (Exception exception) {
            Trace.log(Utility.ApplicationLogger, Level.SEVERE, Person.class, "deleteFromStore",
                      "##############Exception:  " + exception.getMessage());

        }
        
    }

    private String formatDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = "null";
        if (d != null) {
            formattedDate = sdf.format(d);
        }
        return formattedDate;
    }
}


