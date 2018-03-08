package wb.model;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

public class Employee {
    private boolean active = false;
    private boolean inOrg = false;
    private boolean loading = false;
    private int empid = 0;
    private String firstname;
    private String lastname;
    private String title;
    private String email;
    private String phone;
    private String mobile;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postal;
    private String twitter;
    private String facebook;
    private String linkedin;
    private Date hiredate;
    private int deptid;
    private int mgrid;
    private int rating;
    private int potential;
    private int lossrisk;
    private int lossimpact;
    private String jobcode;
    private String office;
    private int salary;
    private int bonus;
    private int commission;
    private int compratio;
    private String deptname;
    private String mgrFirstname;
    private String mgrLastname;
    private String mgrTitle;
    private String mgrPic;
    private int directs;
    private int tenure;
    private double teamAvgRating;
    private double teamAvgPotential;
    private int maxTeamComp;    
    private String pic;
    private Department dept = null;

    protected List<Compensation> compHistoryList = new ArrayList<Compensation>();
    protected List<Employee> directList = new ArrayList<Employee>();
    protected List<Employee> colleagueList = new ArrayList<Employee>();
    protected List<Skill> skillList = new ArrayList<Skill>();
    protected List<Performance> perfHistoryList = new ArrayList<Performance>();
    protected List<Event> eventList = new ArrayList<Event>();

    protected PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    public Employee() {
    }

    public void loadDetail() {
        EmployeeLoader empLoader = new EmployeeLoader(this);
        Thread worker = new Thread(empLoader);
        worker.start();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void addProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l) {
        providerChangeSupport.removeProviderChangeListener(l);
    }

    public List<Compensation> getCompHistory() {
        return compHistoryList;
    }

    public List<Performance> getPerfHistory() {
        return perfHistoryList;
    }

    public List<Employee> getDirectReports() {
        return directList;
    }

    public List<Employee> getColleagues() {
        return colleagueList;
    }

    public List<Event> getEvents() {
        return eventList;
    }

    public List<Skill> getSkills() {
        return skillList;
    }

    public boolean isDetailLoaded() {
        return (colleagueList.size() > 0);
    }

    public void setDept(Department dept) {
        Department oldDept = this.dept;
        this.dept = dept;
        propertyChangeSupport.firePropertyChange("dept", oldDept, dept);
    }

    public Department getDept() {
        return dept;
    }

    public void setEmpid(int empid) {
        int oldEmpid = this.empid;
        this.empid = empid;
        propertyChangeSupport.firePropertyChange("empid", oldEmpid, empid);
    }

    public int getEmpid() {
        return empid;
    }

    public void setFirstname(String firstname) {
        String oldFirstname = this.firstname;
        this.firstname = firstname;
        propertyChangeSupport.firePropertyChange("firstname", oldFirstname, firstname);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        String oldLastname = this.lastname;
        this.lastname = lastname;
        propertyChangeSupport.firePropertyChange("lastname", oldLastname, lastname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        propertyChangeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getTitle() {
        return title;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getEmail() {
        String ret = "";
        if (email != null) {
            ret = email.toLowerCase() + "@example.net";
        }
        return ret;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        propertyChangeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getPhone() {
        return phone;
    }

    public void setMobile(String mobile) {
        String oldMobile = this.mobile;
        this.mobile = mobile;
        propertyChangeSupport.firePropertyChange("mobile", oldMobile, mobile);
    }

    public String getMobile() {
        return mobile;
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

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
        propertyChangeSupport.firePropertyChange("country", oldCountry, country);
    }

    public String getCountry() {
        return country;
    }

    public void setPostal(String postal) {
        String oldPostal = this.postal;
        this.postal = postal;
        propertyChangeSupport.firePropertyChange("postal", oldPostal, postal);
    }

    public String getPostal() {
        return postal;
    }

    public void setTwitter(String twitter) {
        String oldTwitter = this.twitter;
        this.twitter = twitter;
        propertyChangeSupport.firePropertyChange("twitter", oldTwitter, twitter);
    }

    public String getTwitter() {
        return twitter;
    }

    public void setFacebook(String facebook) {
        String oldFacebook = this.facebook;
        this.facebook = facebook;
        propertyChangeSupport.firePropertyChange("facebook", oldFacebook, facebook);
    }

    public String getFacebook() {
        return facebook;
    }

    public void setLinkedin(String linkedin) {
        String oldLinkedin = this.linkedin;
        this.linkedin = linkedin;
        propertyChangeSupport.firePropertyChange("linkedin", oldLinkedin, linkedin);
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setHiredate(Date hiredate) {
        Date oldHiredate = this.hiredate;
        this.hiredate = hiredate;
        propertyChangeSupport.firePropertyChange("hiredate", oldHiredate, hiredate);
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setDeptid(int deptid) {
        int oldDeptid = this.deptid;
        this.deptid = deptid;
        propertyChangeSupport.firePropertyChange("deptid", oldDeptid, deptid);
    }

    public int getDeptid() {
        return deptid;
    }

    public void setMgrid(int mgrid) {
        int oldMgrid = this.mgrid;
        this.mgrid = mgrid;
        propertyChangeSupport.firePropertyChange("mgrid", oldMgrid, mgrid);
    }

    public int getMgrid() {
        return mgrid;
    }

    public void setRating(int rating) {
        int oldRating = this.rating;
        this.rating = rating;
        propertyChangeSupport.firePropertyChange("rating", oldRating, rating);
    }

    public int getRating() {
        return rating;
    }
    
    public String getNboxPotential() {
        return calcNboxString(potential);
    }

    public String getNboxRating() {
        return calcNboxString(rating);
    }

    private String calcNboxString(int value) {
        String ret = "low";
        if (value == 3 || value == 4) {
            ret = "med";
        } else if (value == 5) {
            ret = "high";
        }
        return ret;
    }        

    public void setPotential(int potential) {
        int oldPotential = this.potential;
        this.potential = potential;
        propertyChangeSupport.firePropertyChange("potential", oldPotential, potential);
    }

    public int getPotential() {
        return potential;
    }

    public void setLossrisk(int lossrisk) {
        int oldLossrisk = this.lossrisk;
        this.lossrisk = lossrisk;
        propertyChangeSupport.firePropertyChange("lossrisk", oldLossrisk, lossrisk);
    }

    public int getLossrisk() {
        return lossrisk;
    }

    public String getLossriskstr() {
        return new Integer(lossrisk).toString();
    }

    public void setLossimpact(int lossimpact) {
        int oldLossimpact = this.lossimpact;
        this.lossimpact = lossimpact;
        propertyChangeSupport.firePropertyChange("lossimpact", oldLossimpact, lossimpact);
    }

    public int getLossimpact() {
        return lossimpact;
    }

    public String getLossimpactstr() {
        return new Integer(lossimpact).toString();
    }

    public void setJobcode(String jobcode) {
        String oldJobcode = this.jobcode;
        this.jobcode = jobcode;
        propertyChangeSupport.firePropertyChange("jobcode", oldJobcode, jobcode);
    }

    public String getJobcode() {
        return jobcode;
    }

    public void setOffice(String office) {
        String oldOffice = this.office;
        this.office = office;
        propertyChangeSupport.firePropertyChange("office", oldOffice, office);
    }

    public String getOffice() {
        return office;
    }

    public void setSalary(int salary) {
        int oldSalary = this.salary;
        this.salary = salary;
        propertyChangeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setBonus(int bonus) {
        int oldBonus = this.bonus;
        this.bonus = bonus;
        propertyChangeSupport.firePropertyChange("bonus", oldBonus, bonus);
    }

    public int getBonus() {
        return bonus;
    }

    public void setCommission(int commission) {
        int oldCommission = this.commission;
        this.commission = commission;
        propertyChangeSupport.firePropertyChange("commission", oldCommission, commission);
    }

    public int getCommission() {
        return commission;
    }

    public void setCompratio(int compratio) {
        int oldCompratio = this.compratio;
        this.compratio = compratio;
        propertyChangeSupport.firePropertyChange("compratio", oldCompratio, compratio);
    }

    public int getCompratio() {
        return compratio;
    }

    public void setDeptname(String deptname) {
        String oldDeptname = this.deptname;
        this.deptname = deptname;
        propertyChangeSupport.firePropertyChange("deptname", oldDeptname, deptname);
    }

    public String getDeptname() {
        return deptname;
    }

    public void setMgrFirstname(String mgrFirstname) {
        String oldMgrFirstname = this.mgrFirstname;
        this.mgrFirstname = mgrFirstname;
        propertyChangeSupport.firePropertyChange("mgrFirstname", oldMgrFirstname, mgrFirstname);
    }

    public String getMgrFirstname() {
        return mgrFirstname;
    }

    public void setMgrLastname(String mgrLastname) {
        String oldMgrLastname = this.mgrLastname;
        this.mgrLastname = mgrLastname;
        propertyChangeSupport.firePropertyChange("mgrLastname", oldMgrLastname, mgrLastname);
    }

    public String getMgrLastname() {
        return mgrLastname;
    }


    public void setDirects(int directs) {
        int oldDirects = this.directs;
        this.directs = directs;
        propertyChangeSupport.firePropertyChange("directs", oldDirects, directs);
    }

    public int getDirects() {
        return directs;
    }

    public void setTenure(int tenure) {
        int oldTenure = this.tenure;
        this.tenure = tenure;
        propertyChangeSupport.firePropertyChange("tenure", oldTenure, tenure);
    }

    public int getTenure() {
        return tenure;
    }

    public void setTeamAvgRating(double teamAvgRating) {
        double oldTeamAvgRating = this.teamAvgRating;
        this.teamAvgRating = teamAvgRating;
        propertyChangeSupport.firePropertyChange("teamAvgRating", oldTeamAvgRating, teamAvgRating);
    }

    public double getTeamAvgRating() {
        return teamAvgRating;
    }

    public void setTeamAvgPotential(double teamAvgPotential) {
        double oldTeamAvgPotential = this.teamAvgPotential;
        this.teamAvgPotential = teamAvgPotential;
        propertyChangeSupport.firePropertyChange("teamAvgPotential", oldTeamAvgPotential, teamAvgPotential);
    }

    public double getTeamAvgPotential() {
        return teamAvgPotential;
    }

    public void setLoading(boolean loading) {
        boolean oldLoading = this.loading;
        this.loading = loading;
        propertyChangeSupport.firePropertyChange("loading", oldLoading, loading);
    }

    public boolean isLoading() {
        return loading;
    }

    public void setInOrg(boolean inOrg) {
        boolean oldInOrg = this.inOrg;
        this.inOrg = inOrg;
        propertyChangeSupport.firePropertyChange("inOrg", oldInOrg, inOrg);
    }

    public boolean isInOrg() {
        return inOrg;
    }

    public void setPic(String pic) {
        String oldPic = this.pic;
        this.pic = pic;
        propertyChangeSupport.firePropertyChange("pic", oldPic, pic);
    }

    public String getPic() {
        if (pic == null) {
            pic = WBUtils.loadPicture(this, false);
        }
        return pic;
    }

    public void setActive(boolean active) {
        boolean oldActive = this.active;
        this.active = active;
        propertyChangeSupport.firePropertyChange("active", oldActive, active);
    }

    public boolean isActive() {
        return active;
    }

    public void setMgrPic(String mgrPic) {
        String oldMgrPic = this.mgrPic;
        this.mgrPic = mgrPic;
        propertyChangeSupport.firePropertyChange("mgrPic", oldMgrPic, mgrPic);
    }

    public String getMgrPic() {
        if (mgrPic == null) {
            mgrPic = WBUtils.loadPicture(this, true);
        }
        return mgrPic;
    }

    public void setMgrTitle(String mgrTitle) {
        String oldMgrTitle = this.mgrTitle;
        this.mgrTitle = mgrTitle;
        propertyChangeSupport.firePropertyChange("mgrTitle", oldMgrTitle, mgrTitle);
    }

    public String getMgrTitle() {
        return mgrTitle;
    }

    public void setMaxTeamComp(int maxTeamComp) {
        this.maxTeamComp = maxTeamComp;
    }

    public int getMaxTeamComp() {
        return maxTeamComp;
    }
}


