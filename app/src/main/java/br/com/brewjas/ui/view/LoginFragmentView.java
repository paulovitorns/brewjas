package br.com.brewjas.ui.view;

import br.com.brewjas.model.Client;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface LoginFragmentView {

    void navigateToNextScreenWithSerializedCliente(Client client);

    void setUsernameError(String title, String description);

}
