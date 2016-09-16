package br.com.brewjas.ui.view;

import android.content.Context;

import br.com.brewjas.model.Client;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface BaseFragmentView {

    void showLoading();

    void hideLoading();

    Context getContext();

    void showNetworkInfo();
}
