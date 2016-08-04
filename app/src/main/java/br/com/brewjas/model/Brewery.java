package br.com.brewjas.model;

import java.io.Serializable;

import br.com.brewjas.model.common.Image;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Brewery implements Serializable {

    public static final String KEY = "BreweryKey";

    private String  id;
    private String  description;
    private String  name;
    private Image   images;
    private String  established;
    private String  website;

    public Brewery() {
    }

    public Brewery(String description, String name, Image images, String established, String website) {
        this.description = description;
        this.name = name;
        this.images = images;
        this.established = established;
        this.website = website;
    }

    public Brewery(String id, String description, String name, Image images, String established, String website) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.images = images;
        this.established = established;
        this.website = website;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Image getImages() {
        return images;
    }

    public String getEstablished() {
        return established;
    }

    public String getWebsite() {
        return website;
    }

}
