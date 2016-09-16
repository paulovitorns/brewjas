package br.com.brewjas.business.api.vo.common;

import com.google.gson.annotations.SerializedName;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class LocationResponse {
    @SerializedName("address")  public String   address;
    @SerializedName("city")     public String  city;
    @SerializedName("state")    public String  state;
    @SerializedName("lat")      public Double  lat;
    @SerializedName("lng")      public Double  lng;
}
