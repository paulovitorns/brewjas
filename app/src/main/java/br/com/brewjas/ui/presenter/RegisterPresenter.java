package br.com.brewjas.ui.presenter;

import br.com.brewjas.model.Cliente;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public interface RegisterPresenter extends BasePresenter {

    void onSubmitPressed(Cliente cliente);

    void checkEmailIsRegistered(String email);

    void checkIsOverAge(String dataNascimento);
}
