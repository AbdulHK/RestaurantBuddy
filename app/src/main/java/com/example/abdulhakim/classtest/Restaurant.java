package com.example.abdulhakim.classtest;

/**
 * Created by abdulhakim on 04/03/2017.
 */

public class Restaurant {

    private int id;
    private String name;
    private String address1;
    private String address2;
    private  int phone;
    private float lat;
    private float lng;
    private int cost;
    private String menu_type;
    private float rate;
    private String offer;

    public Restaurant(int id, String name, String address1, String address2,
                      int phone, float lat, float lng, int cost, String menu_type,
                      float rate, String offer) {
        this.id = id;
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.phone = phone;
        this.lat = lat;
        this.lng = lng;
        this.cost = cost;
        this.menu_type = menu_type;
        this.rate = rate;
        this.offer = offer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }



}
