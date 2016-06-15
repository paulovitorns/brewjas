package br.com.brewjas.api.general.response;

import java.io.Serializable;

/**
 * Created by Paulo Vitor on 02/05/2016.
 */
public class BeerResponse implements Serializable {

    private String name;

    private String cervejaria;

    private String pais;

    private String estilo;

    private String abv;

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
