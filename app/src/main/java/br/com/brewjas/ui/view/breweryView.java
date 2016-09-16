package br.com.brewjas.ui.view;

import android.support.v7.widget.RecyclerView;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface BreweryView extends BaseFragmentView {

    void loadBreweriesAdapter();
    void showEmptyState();
    void showCardsBreweries(RecyclerView.Adapter adapter);

}
