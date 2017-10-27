package data.client.domain;

public class Address {
    private String userId;
    private String city;
    private String street;
    private String streetId;

    public Address() {
    }

    public Address(String userId, String city, String street, String streetId) {
        this.userId = userId;
        this.city = city;
        this.street = street;
        this.streetId = streetId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId;
    }
}
