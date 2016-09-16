package br.com.brewjas.ui.presenter;

import android.support.v7.widget.RecyclerView;

import br.com.brewjas.model.Brewery;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface BreweriesPresenter extends BasePresenter {

    void searchBreweries(String term);

    void loadMoreBreweries(RecyclerView mRecyclerView);

    void proccessMoreBreweries(Brewery brewery);
}
