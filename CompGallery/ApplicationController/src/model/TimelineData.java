package model;

import java.util.Date;

public class TimelineData {
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String fillColor;
    private String durationFillColor;
    
    public TimelineData(String title, String description, Date startDate, Date endDate, String fillColor, String durationFillColor) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fillColor = fillColor;
        this.durationFillColor = durationFillColor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setDurationFillColor(String durationFillColor) {
        this.durationFillColor = durationFillColor;
    }

    public String getDurationFillColor() {
        return durationFillColor;
    }
}
