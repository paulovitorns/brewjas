package br.com.brewjas.model.common;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import br.com.brewjas.business.api.vo.common.BreweryItemResponse;
import br.com.brewjas.business.api.vo.common.ContactResponse;
import br.com.brewjas.business.api.vo.common.LocationResponse;
import br.com.brewjas.business.api.vo.common.RatingBreweryResponse;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BreweryItem implements Serializable {

    public static final String KEY = "BreweryItemKey";

    private String          id;
    private String          name;
    private String          image;
    private String          country;
    private boolean         independent;
    private int             beerCount;
    private Contact         contact;
    private String          type;
    private int             typeId;
    private Location        location;
    private RatingBrewery   rating;
    private String          description;

    public BreweryItem() {
    }

    public BreweryItem(BreweryItemResponse brewery) {

        this.id             = brewery.id;
        this.name           = brewery.name;
        this.image          = brewery.image;
        this.country        = brewery.country;
        this.independent    = brewery.independent;
        this.beerCount      = brewery.beerCount;
        this.contact        = new Contact(brewery.contact.twitter, brewery.contact.facebook, brewery.contact.instragram, brewery.contact.url);
        this.type           = brewery.type;
        this.typeId         = brewery.typeId;
        this.location       = new Location(brewery.location.address, brewery.location.city, brewery.location.state, brewery.location.lat, brewery.location.lng);
        this.rating         = new RatingBrewery(brewery.rating.count, brewery.rating.score);
        this.description    = brewery.description;

    }

    public BreweryItem(String id, String name, String image, String country, boolean independent, int beerCount, Contact contact, String type, int typeId, Location location, RatingBrewery rating, String description) {
        this.id             = id;
        this.name           = name;
        this.image          = image;
        this.country        = country;
        this.independent    = independent;
        this.beerCount      = beerCount;
        this.contact        = contact;
        this.type           = type;
        this.typeId         = typeId;
        this.location       = location;
        this.rating         = rating;
        this.description    = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }

    public int getBeerCount() {
        return beerCount;
    }

    public void setBeerCount(int beerCount) {
        this.beerCount = beerCount;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public RatingBrewery getRating() {
        return rating;
    }

    public void setRating(RatingBrewery rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
