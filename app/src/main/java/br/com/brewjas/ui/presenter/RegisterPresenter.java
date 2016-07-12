package br.com.brewjas.ui.presenter;

import br.com.brewjas.model.Client;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface RegisterPresenter extends BasePresenter {

    void onSubmitPressed(Client client);

    void checkEmailIsRegistered(String email);

    void checkIsOverAge(String dataNascimento);
}
