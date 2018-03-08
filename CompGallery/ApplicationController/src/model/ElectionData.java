package model;

public class ElectionData {
    
    private float value;
    private String label;
    
    public ElectionData() {
        super();
    }

    public ElectionData(float value, String label) {
        this.value = value;
        this.label = label;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
