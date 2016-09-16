package br.com.brewjas.business.api.vo.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import br.com.brewjas.business.api.vo.common.BreweryItemResponse;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BreweryResponse {

    @SerializedName("response") public ApiStatusResponse            response;
    @SerializedName("data")     public List<BreweryItemResponse>    breweries;
}
