package br.com.brewjas.services.brewjasapi;

import br.com.brewjas.model.Cliente;
import br.com.brewjas.common.OnListenerGeneral;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public interface RegisterService {

    void register(Cliente cliente, OnListenerGeneral listener);

    void checkEmail(String email, OnListenerGeneral listener);
}
