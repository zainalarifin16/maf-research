package wb.model;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Skill {
    private int skillid;
    private int rating;
    private String skillname;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Skill() {
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setSkillid(int skillid) {
        this.skillid = skillid;
    }

    public int getSkillid() {
        return skillid;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public String getSkillname() {
        return skillname;
    }
}
