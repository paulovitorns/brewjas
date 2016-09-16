package br.com.brewjas.model.common;

import java.io.Serializable;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class RatingBrewery implements Serializable {

    public static final String KEY = "RatingKey";

    private int     count;
    private Double  score;

    public RatingBrewery() {
    }

    public RatingBrewery(int count, Double score) {
        this.count = count;
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public Double getScore() {
        return score;
    }

}
