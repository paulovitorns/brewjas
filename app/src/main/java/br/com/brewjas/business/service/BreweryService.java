package br.com.brewjas.business.service;

import br.com.brewjas.business.api.vo.request.BreweryRequest;
import br.com.brewjas.common.OnBreweriesFinishedListener;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface BreweryService {

    void getBreweries(BreweryRequest request, OnBreweriesFinishedListener listener);

}
