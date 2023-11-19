package models;

import java.util.List;

public class ContactDetailsInfo {
    private String street1;
    private String street2;
    private String state;
    private String city;

//    private List<String> country;
    private String homeNumberTelephone;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeNumberTelephone() {
        return homeNumberTelephone;
    }

    public void setHomeNumberTelephone(String homeNumberTelephone) {
        this.homeNumberTelephone = homeNumberTelephone;
    }
}
