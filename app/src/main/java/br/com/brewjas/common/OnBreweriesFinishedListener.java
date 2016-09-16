package br.com.brewjas.common;

import br.com.brewjas.model.Brewery;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface OnBreweriesFinishedListener extends OnApiErrorListener {

    void onError(String title, String description);

    void onSuccess(Brewery brewery);

}
