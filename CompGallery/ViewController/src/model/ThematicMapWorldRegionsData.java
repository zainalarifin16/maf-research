package model;

public class ThematicMapWorldRegionsData {

    private String name;
    private String cat;
    private String shortDesc;


    public ThematicMapWorldRegionsData(String name,String cat,String shortDesc) {
        this.name = name;
        this.cat = cat;
        this.shortDesc = shortDesc;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String val) {
        this.name = val;
    }

    public String getCat() {
        return this.cat;
    }

    public void setCat(String val) {
        this.cat = val;
    }

    public String getShortDesc() {
        return this.shortDesc;
    }

    public void setShortDesc(String val) {
        this.shortDesc = val;
    }

}