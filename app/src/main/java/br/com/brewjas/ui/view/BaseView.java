package br.com.brewjas.ui.view;

import br.com.brewjas.api.general.request.Cliente;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
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
