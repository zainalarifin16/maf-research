package model;

public class PictoChartData
{
  private int id;
  private String name;
  private String site;
  private String department;
  private String jobTitle;

  public PictoChartData(int id, String name, String site, String department, String jobTitle)
  {
    this.id = id;
    this.name = name;
    this.site = site;
    this.department = department;
    this.jobTitle = jobTitle;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSite() {
    return site;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }
}