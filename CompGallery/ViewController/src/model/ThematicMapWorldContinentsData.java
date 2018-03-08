package model;

public class ThematicMapWorldContinentsData {

    private String name;
    private String cat;


    public ThematicMapWorldContinentsData(String name,String cat) {
        this.name = name;
        this.cat = cat;
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

}