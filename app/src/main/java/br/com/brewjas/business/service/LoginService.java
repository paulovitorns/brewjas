package br.com.brewjas.business.service;

import br.com.brewjas.common.OnListenerGeneral;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface LoginService {

    void login(String email, OnListenerGeneral listener);

}
