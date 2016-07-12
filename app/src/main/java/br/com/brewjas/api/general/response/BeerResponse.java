package br.com.brewjas.api.general.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BeerResponse implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("cervejaria")
    private String cervejaria;

    @SerializedName("pais")
    private String pais;

    @SerializedName("estilo")
    private String estilo;

    @SerializedName("abv")
    private String abv;

    @SerializedName("ibu")
    private String ibu;

    public BeerResponse(String name, String cervejaria, String pais, String estilo, String abv, String ibu) {
        this.name = name;
        this.cervejaria = cervejaria;
        this.pais = pais;
        this.estilo = estilo;
        this.abv = abv;
        this.ibu = ibu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCervejaria() {
        return cervejaria;
    }

    public void setCervejaria(String cervejaria) {
        this.cervejaria = cervejaria;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }
}
