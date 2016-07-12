package br.com.brewjas.ui.view;

import br.com.brewjas.model.Cliente;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface BaseView {

    void setupActionBar();

    void navigateToNextScreenWithSerializedCliente(Cliente cliente);

    void showDialog(String title, String description);

    void hideDialog();

    void showLoading();

    void hideLoading();
}
