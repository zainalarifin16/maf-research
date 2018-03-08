package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimelineDataList {
    private static Calendar calendar = Calendar.getInstance();
    private static List<TimelineData> series1DataList = null;
    private static List<TimelineData> series2DataList = null;
    
    public TimelineDataList() {
        String winColor = "rgb(255,255,70)"; 
        String grassCourtColor = "green"; 
        String clayCourtColor = "orange"; 
        String outdoorHardCourtColor = "blue"; 
        String indoorHardCourtColor = "red"; 
        
        if(series1DataList == null) {
            series1DataList = new ArrayList<TimelineData>();
            series1DataList.add(new TimelineData("ATP VTR Open", "Finalist: 3-1", getDate(2013, 1, 4), getDate(2013, 1, 10), null, clayCourtColor)); 
            series1DataList.add(new TimelineData("ATP Brasil Open", "Champion: 4-0", getDate(2013, 1, 11), getDate(2013, 1, 17), winColor, clayCourtColor)); 
            series1DataList.add(new TimelineData("ATP Abierto Mexicano Telcel", "Champion: 5-0", getDate(2013, 1, 25), getDate(2013, 2, 2), winColor, clayCourtColor)); 
            series1DataList.add(new TimelineData("ATP BNP Paribas Open", "Champion: 6-0", getDate(2013, 2, 7), getDate(2013, 2, 17), winColor, outdoorHardCourtColor)); 
            series1DataList.add(new TimelineData("ATP Monte-Carlo Rolex Masters", "Finalist: 4-1", getDate(2013, 3, 14), getDate(2013, 3, 21), null, clayCourtColor)); 
            series1DataList.add(new TimelineData("ATP Barcelona Open BancSabadell", "Champion: 5-0", getDate(2013, 3, 22), getDate(2013, 3, 28), winColor, clayCourtColor)); 
            series1DataList.add(new TimelineData("ATP Mutua Madrid Open", "Champion: 5-0", getDate(2013, 4, 5), getDate(2013, 4, 11), winColor, clayCourtColor)); 
            series1DataList.add(new TimelineData("ATP Internazionali BNL d'Italia", "Champion: 5-0", getDate(2013, 4, 12), getDate(2013, 4, 19), winColor, clayCourtColor)); 
            series1DataList.add(new TimelineData("FRENCH OPEN", "Champion: 7-0", getDate(2013, 4, 26), getDate(2013, 5, 9), winColor, clayCourtColor)); 
            series1DataList.add(new TimelineData("WIMBLEDON", "1st Round Loss: 0-1", getDate(2013, 5, 24), getDate(2013, 6, 7), null, grassCourtColor)); 
            series1DataList.add(new TimelineData("ATP Rogers Cup presented by National Bank", "Champion: 5-0", getDate(2013, 7, 5), getDate(2013, 7, 10), winColor, outdoorHardCourtColor)); 
            series1DataList.add(new TimelineData("ATP Western & Southern Open", "Champion: 5-0", getDate(2013, 7, 11), getDate(2013, 7, 18), winColor, outdoorHardCourtColor)); 
            series1DataList.add(new TimelineData("US OPEN", "Champion: 7-0", getDate(2013, 7, 26), getDate(2013, 8, 9), winColor, outdoorHardCourtColor)); 
            series1DataList.add(new TimelineData("ATP China Open", "Finalist: 4-1", getDate(2013, 8, 30), getDate(2013, 9, 5), null, outdoorHardCourtColor)); 
            series1DataList.add(new TimelineData("Shanghai Rolex Masters", "Semi-Finalist: 3-1", getDate(2013, 9, 6), getDate(2013, 9, 13), null, outdoorHardCourtColor)); 
            series1DataList.add(new TimelineData("ATP BNP Paribas Masters", "Semi-Finalist: 3-1", getDate(2013, 9, 28), getDate(2013, 10, 3), null, indoorHardCourtColor)); 
            series1DataList.add(new TimelineData("Barclays ATP World Tour Finals", "Finalist: 4-1", getDate(2013, 10, 4), getDate(2013, 10, 11), null, indoorHardCourtColor));
        }
        
        if(series2DataList == null) {
            series2DataList = new ArrayList<TimelineData>();
            series2DataList.add(new TimelineData("AUSTRALIAN OPEN", "Champion: 7-0", getDate(2013, 0, 14), getDate(2013, 0, 27), winColor, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("Davis Cup World Group Round 1", "Results: 1-0", getDate(2013, 1, 1), getDate(2013, 1, 3), null, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("ATP Dubai Duty Free Tennis Championships", "Champion: 5-0", getDate(2013, 1, 25), getDate(2013, 2, 2), winColor, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("ATP BNP Paribas Open", "Semi-Finalist: 4-1", getDate(2013, 2, 7), getDate(2013, 2, 17), null, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("ATP Sony Open Tennis", "4th Round Loss: 2-1", getDate(2013, 2, 20), getDate(2013, 2, 31), null, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("Davis Cup World Group Quarter-Final", "Results: 2-0", getDate(2013, 3, 5), getDate(2013, 3, 7), null, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("ATP Monte-Carlo Rolex Masters", "Champion: 5-0", getDate(2013, 3, 14), getDate(2013, 3, 21), winColor, clayCourtColor)); 
            series2DataList.add(new TimelineData("ATP Mutua Madrid Open", "2nd Round Loss: 0-1", getDate(2013, 4, 5), getDate(2013, 4, 11), null, clayCourtColor)); 
            series2DataList.add(new TimelineData("ATP Internazionali BNL d'Italia", "Quarter-Finalist: 2-1", getDate(2013, 4, 12), getDate(2013, 4, 19), null, clayCourtColor)); 
            series2DataList.add(new TimelineData("FRENCH OPEN", "Semi-Finalist: 5-1", getDate(2013, 4, 26), getDate(2013, 5, 9), null, clayCourtColor)); 
            series2DataList.add(new TimelineData("WIMBLEDON", "Finalist: 6-1", getDate(2013, 5, 24), getDate(2013, 6, 7), null, grassCourtColor)); 
            series2DataList.add(new TimelineData("ATP Rogers Cup presented by National Bank", "Semi-Finalist: 3-1", getDate(2013, 7, 5), getDate(2013, 7, 10), null, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("ATP Western & Southern Open", "Quarter-Finalist: 2-1", getDate(2013, 7, 11), getDate(2013, 7, 18), null, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("US OPEN", "Finalist: 6-1", getDate(2013, 7, 26), getDate(2013, 8, 9), null, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("Davis Cup World Group Semi-Final", "Results: 2-0", getDate(2013, 8, 13), getDate(2013, 8, 15), null, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("ATP China Open", "Champion: 5-0", getDate(2013, 8, 30), getDate(2013, 9, 5), winColor, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("Shanghai Rolex Masters", "Champion: 5-0", getDate(2013, 9, 6), getDate(2013, 9, 13), winColor, outdoorHardCourtColor)); 
            series2DataList.add(new TimelineData("ATP BNP Paribas Masters", "Champion: 5-0", getDate(2013, 9, 28), getDate(2013, 10, 3), winColor, indoorHardCourtColor)); 
            series2DataList.add(new TimelineData("Barclays ATP World Tour Finals", "Champion: 5-0", getDate(2013, 10, 4), getDate(2013, 10, 11), winColor, indoorHardCourtColor)); 
            series2DataList.add(new TimelineData("Davis Cup World Group Final", "Results: 2-0", getDate(2013, 10, 15), getDate(2013, 10, 17), null, outdoorHardCourtColor));
        }
    }

    public List<TimelineData> getSeries1Data() {
        return series1DataList;
    }
    
    public List<TimelineData> getSeries2Data() {
        return series2DataList;
    }

    private Date getDate(int year, int month, int day) {
        calendar.set(year, month, day);
        return calendar.getTime(); 
    }
}
