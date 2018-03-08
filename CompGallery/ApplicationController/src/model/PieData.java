package model;

public class PieData {
    private String label;
    private double value;
    private int explode;

    public PieData() {
        super();
    }
    
    public PieData(String label, double value, int explode) {
        this.label = label;
        this.value = value;
        this.explode = explode;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getExplode() {
        return explode;
    }

    public void setExplode(int explode) {
        this.explode = explode;
    }
}
