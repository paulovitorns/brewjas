package br.com.brewjas.business.api.vo.common;

import com.google.gson.annotations.SerializedName;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class RatingBreweryResponse {
    @SerializedName("count") public int     count;
    @SerializedName("score") public Double  score;
}
