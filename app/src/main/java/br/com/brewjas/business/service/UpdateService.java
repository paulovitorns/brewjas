package br.com.brewjas.business.service;

import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.model.Client;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface UpdateService {

    void update(Client client, OnListenerGeneral listener);

    void checkEmail(String email, OnListenerGeneral listener);
}
