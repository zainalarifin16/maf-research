package model;

public class MasonryLayoutNode
{

  private String id;
  private String row;
  private String column;
  private String name;
  private String job;
  private String department;
  private String costCenter;
  private String site;


  public MasonryLayoutNode(String id, String row, String column, String name, String job, String department,
                     String costCenter, String site)
  {
    this.id = id;
    this.row = row;
    this.column = column;
    this.name = name;
    this.job = job;
    this.department = department;
    this.costCenter = costCenter;
    this.site = site;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getId()
  {
    return id;
  }

  public void setRow(String row)
  {
    this.row = row;
  }

  public String getRow()
  {
    return row;
  }

  public void setColumn(String column)
  {
    this.column = column;
  }

  public String getColumn()
  {
    return column;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setJob(String job)
  {
    this.job = job;
  }

  public String getJob()
  {
    return job;
  }

  public void setDepartment(String department)
  {
    this.department = department;
  }

  public String getDepartment()
  {
    return department;
  }

  public void setCostCenter(String costCenter)
  {
    this.costCenter = costCenter;
  }

  public String getCostCenter()
  {
    return costCenter;
  }

  public void setSite(String site)
  {
    this.site = site;
  }

  public String getSite()
  {
    return site;
  }
}
