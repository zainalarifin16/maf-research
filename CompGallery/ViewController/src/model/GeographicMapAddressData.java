package model;

public class GeographicMapAddressData {
    
    private String address;
    private String type;
    private String shortDesc;
    
    public GeographicMapAddressData(){}
    
    public GeographicMapAddressData(String address, String type,
            String shortDesc) {
        super();
        this.address = address;
        this.type = type;
        this.shortDesc = shortDesc;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getShortDesc() {
        return shortDesc;
    }
    
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
    
}