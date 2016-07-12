package br.com.brewjas.model.common;

import java.io.Serializable;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Image implements Serializable {

    private String medium;
    private String large;
    private String icon;

    public Image(String medium, String large, String icon) {
        this.medium = medium;
        this.large  = large;
        this.icon   = icon;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }

    public String getIcon() {
        return icon;
    }
}
