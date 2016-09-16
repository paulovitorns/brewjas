package br.com.brewjas.common;

import br.com.brewjas.model.ApiError;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface OnApiErrorListener {

    void onApiError(ApiError error);

    void onInternetError(ApiError error);

}
