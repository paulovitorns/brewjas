package br.com.brewjas.business.api.vo.common;

import com.google.gson.annotations.SerializedName;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class ContactResponse {
    @SerializedName("twitter")      public String  twitter;
    @SerializedName("facebook")     public String  facebook;
    @SerializedName("instragram")   public String  instragram;
    @SerializedName("url")          public String  url;
}
