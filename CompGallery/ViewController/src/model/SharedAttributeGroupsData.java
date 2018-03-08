package model;

public class SharedAttributeGroupsData {
    private Integer year;
    private String author;
    private Integer count;
    
    public SharedAttributeGroupsData(Integer year, String author, Integer count) {
        this.year = year;
        this.author = author;
        this.count = count;
    }

    public Integer getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getCount() {
        return count;
    }
}
