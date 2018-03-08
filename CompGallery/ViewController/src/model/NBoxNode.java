package model;

public class NBoxNode
{
  private String id;
  private String potential;
  private String performance;
  private String name;
  private String position;
  private String role;
  private String department;
  private String experience;
  

  public NBoxNode(String id, String potential, String performance, String name, String position, String role, String department, String experience) 
  {
    this.id = id;
    this.potential = potential;
    this.performance = performance;
    this.name = name;
    this.position = position;
    this.role = role;
    this.department = department;
    this.experience = experience;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getId()
  {
    return id;
  }

  public void setPotential(String potential)
  {
    this.potential = potential;
  }

  public String getPotential()
  {
    return potential;
  }

  public void setPerformance(String performance)
  {
    this.performance = performance;
  }

  public String getPerformance()
  {
    return performance;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setPosition(String position)
  {
    this.position = position;
  }

  public String getPosition()
  {
    return position;
  }

  public void setRole(String role)
  {
    this.role = role;
  }

  public String getRole()
  {
    return role;
  }

  public void setDepartment(String department)
  {
    this.department = department;
  }

  public String getDepartment()
  {
    return department;
  }

  public void setExperience(String experience)
  {
    this.experience = experience;
  }

  public String getExperience()
  {
    return experience;
  }
}
