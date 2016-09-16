package br.com.brewjas.model.common;

import java.io.Serializable;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Contact implements Serializable {

    public static final String KEY = "ContactKey";

    private String  twitter;
    private String  facebook;
    private String  instragram;
    private String  url;

    public Contact() {
    }

    public Contact(String twitter, String facebook, String instragram, String url) {
        this.twitter = twitter;
        this.facebook = facebook;
        this.instragram = instragram;
        this.url = url;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstragram() {
        return instragram;
    }

    public String getUrl() {
        return url;
    }

}
