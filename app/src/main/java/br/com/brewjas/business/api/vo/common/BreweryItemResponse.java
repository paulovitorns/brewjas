package br.com.brewjas.business.api.vo.common;

import com.google.gson.annotations.SerializedName;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BreweryItemResponse {

    @SerializedName("id")           public String                   id;
    @SerializedName("name")         public String                   name;
    @SerializedName("image")        public String                   image;
    @SerializedName("country")      public String                   country;
    @SerializedName("independent")  public boolean                  independent;
    @SerializedName("beerCount")    public int                      beerCount;
    @SerializedName("contact")      public ContactResponse          contact;
    @SerializedName("type")         public String                   type;
    @SerializedName("typeId")       public int                      typeId;
    @SerializedName("location")     public LocationResponse         location;
    @SerializedName("rating")       public RatingBreweryResponse    rating;
    @SerializedName("description")  public String                   description;

}
