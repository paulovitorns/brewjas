package br.com.brewjas.business.service;

import br.com.brewjas.model.Client;
import br.com.brewjas.common.OnListenerGeneral;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface RegisterService {

    void register(Client client, OnListenerGeneral listener);

    void registerByFb(Client client, OnListenerGeneral listener);

    void checkEmail(String email, OnListenerGeneral listener);
}
