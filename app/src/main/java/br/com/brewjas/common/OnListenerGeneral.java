package br.com.brewjas.common;

import br.com.brewjas.model.Client;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface OnListenerGeneral extends OnApiErrorListener {


    void onError(String title, String description);

    void onSuccess(Client client);


}
