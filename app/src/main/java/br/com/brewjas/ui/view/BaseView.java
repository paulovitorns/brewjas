package br.com.brewjas.ui.view;

import android.content.Context;

import br.com.brewjas.model.Client;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface BaseView {

    void setupActionBar();

    void showDialog(String title, String description);

    void navigateToNextScreenWithSerializedCliente(Client client);

    void showLoading();

    void hideLoading();

    Context getContext();
}
