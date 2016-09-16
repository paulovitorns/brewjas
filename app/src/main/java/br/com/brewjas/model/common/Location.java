package br.com.brewjas.model.common;

import java.io.Serializable;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Location implements Serializable {

    public static final String KEY = "LocationKey";

    private String  address;
    private String  city;
    private String  state;
    private Double  lat;
    private Double  lng;

    public Location() {
    }

    public Location(String address, String city, String state, Double lat, Double lng) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.lat = lat;
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLng() {
        return lng;
    }

}
