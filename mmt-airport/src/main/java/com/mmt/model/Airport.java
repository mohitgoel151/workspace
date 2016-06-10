package com.mmt.model;

public class Airport {
    
    private int id;
    
    private String code; 
    private String lat;
    private String lon;
    private String name;
    private float rating; 
    private String city; 
    private String state;
    private String country;
    private String tz;
    private String type; 
    private String url;
    private String elev;
    private String direct_flights;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLon() {
        return lon;
    }
    public void setLon(String lon) {
        this.lon = lon;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getTz() {
        return tz;
    }
    public void setTz(String tz) {
        this.tz = tz;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getElev() {
        return elev;
    }
    public void setElev(String elev) {
        this.elev = elev;
    }
    public String getDirect_flights() {
        return direct_flights;
    }
    public void setDirect_flights(String direct_flights) {
        this.direct_flights = direct_flights;
    }

    @Override
    public String toString() {
        return String.format(
                "Airport[id=%d, code='%s', name='%s']", 
                id, code, name);
    }

}
