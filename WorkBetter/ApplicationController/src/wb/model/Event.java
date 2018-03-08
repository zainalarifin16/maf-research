package wb.model;

import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Event {
    private int eventId;
    private int eventType;
    private String eventName;
    private String description;
    private Date eventStart;
    private Date eventEnd;
    private String color;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Event() {
        super();
    }

    public Event(int eventId, int eventType, String description, Date eventStart, Date eventEnd) {
        this.eventId = eventId;
        this.eventType = eventType;
        this.description = description;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setEventId(int eventId) {
        int oldEventId = this.eventId;
        this.eventId = eventId;
        propertyChangeSupport.firePropertyChange("eventId", oldEventId, eventId);
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventType(int eventType) {
        int oldEventType = this.eventType;
        this.eventType = eventType;
        propertyChangeSupport.firePropertyChange("eventType", oldEventType, eventType);
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventName(String eventName) {
        String oldEventName = this.eventName;
        this.eventName = eventName;
        propertyChangeSupport.firePropertyChange("eventName", oldEventName, eventName);
    }

    public String getEventName() {
        return eventName;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        propertyChangeSupport.firePropertyChange("description", oldDescription, description);
    }

    public String getDescription() {
        return description;
    }


    public void setEventStart(Date eventStart) {
        Date oldEventStart = this.eventStart;
        this.eventStart = eventStart;
        propertyChangeSupport.firePropertyChange("eventStart", oldEventStart, eventStart);
    }

    public Date getEventStart() {
        return eventStart;
    }

    public void setEventEnd(Date eventEnd) {
        Date oldEventEnd = this.eventEnd;
        this.eventEnd = eventEnd;
        propertyChangeSupport.firePropertyChange("eventEnd", oldEventEnd, eventEnd);
    }

    public Date getEventEnd() {
        return eventEnd;
    }

    public void setColor(String color) {
        String oldColor = this.color;
        this.color = color;
        propertyChangeSupport.firePropertyChange("color", oldColor, color);
    }

    public String getColor() {
        return color;
    }

}
