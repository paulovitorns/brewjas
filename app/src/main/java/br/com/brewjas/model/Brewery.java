package br.com.brewjas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.business.api.vo.common.BreweryItemResponse;
import br.com.brewjas.business.api.vo.response.BreweryResponse;
import br.com.brewjas.model.common.BreweryItem;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Brewery implements Serializable {

    public static final String KEY = "BreweryKey";

    private int registros;
    private List<BreweryItem> breweries;
    
    public Brewery(BreweryResponse response) {

        this.registros = response.response.registros;

        breweries = new ArrayList<>();

        for (BreweryItemResponse b : response.breweries) {
            BreweryItem brewery = new BreweryItem(b);
            breweries.add(brewery);
        }
        
    }

    public int getRegistros() {
        return registros;
    }

    public void setRegistros(int registros) {
        this.registros = registros;
    }

    public List<BreweryItem> getBreweries() {
        return breweries;
    }

    public void setBreweries(List<BreweryItem> breweries) {
        this.breweries = breweries;
    }
}
