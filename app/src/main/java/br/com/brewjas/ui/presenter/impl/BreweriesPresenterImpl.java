package br.com.brewjas.ui.presenter.impl;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.business.api.vo.request.BreweryRequest;
import br.com.brewjas.business.service.BreweryService;
import br.com.brewjas.business.service.impl.BreweryServiceImpl;
import br.com.brewjas.common.OnBreweriesFinishedListener;
import br.com.brewjas.model.ApiError;
import br.com.brewjas.model.Brewery;
import br.com.brewjas.model.common.BreweryItem;
import br.com.brewjas.ui.adapter.BreweryAdapter;
import br.com.brewjas.ui.presenter.BreweriesPresenter;
import br.com.brewjas.ui.view.BreweryView;
import br.com.brewjas.util.UtilNetwork;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BreweriesPresenterImpl implements BreweriesPresenter, OnBreweriesFinishedListener {

    private BreweryView         breweryView;
    private BreweryService      service;
    private BreweryRequest      request;
    private List<BreweryItem>   breweries;
    private BreweryAdapter      adapter;
    private RecyclerView        mRecyclerView;
    private View                view;

    private int                 offset  = 0;
    private int                 limit   = 15;
    private int                 nPages  = 0;

    public BreweriesPresenterImpl(View view, BreweryView breweryView){
        this.breweryView   = breweryView;
        this.view           = view;
        init();
    }

    @Override
    public void init() {

        request         = new BreweryRequest();
        breweries       = new ArrayList<>();
        this.service    = new BreweryServiceImpl();

        this.breweryView.loadBreweriesAdapter();
    }

    @Override
    public void searchBreweries(String term) {

        if(!UtilNetwork.isNetworkAvailable()){
            this.onInternetError(new ApiError(0));
        }else {
            this.breweryView.showLoading();
            request.term = term;
            request.offset = this.offset;
            request.limit = this.limit;
            this.service.getBreweries(request, this);
        }
    }

    @Override
    public void loadMoreBreweries(RecyclerView mRecyclerView) {

        if(!UtilNetwork.isNetworkAvailable()){

            this.onInternetError(new ApiError(0));
        }else {

            this.breweryView.showLoading();

            this.mRecyclerView = mRecyclerView;

            if(this.nPages > 0){

                this.offset = this.offset + this.limit;
                request.offset  = this.offset;
                request.limit   = this.limit;

                this.service.getBreweries(request, this);

                this.nPages--;
            }else{

                Toast.makeText(this.view.getContext(), "Carregamos todas as crevejarias", Toast.LENGTH_LONG).show();
            }

        }

    }

    @Override
    public void proccessMoreBreweries(Brewery brewery) {
        LinearLayoutManager manager = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        BreweryAdapter      adapter = (BreweryAdapter) this.mRecyclerView.getAdapter();

        if(breweries.size() > manager.getItemCount()){
            for (BreweryItem brew : brewery.getBreweries()){
                adapter.insert(breweries.size(), brew);
            }
        }

    }

    @Override
    public void onError(String title, String description) {
        this.breweryView.hideLoading();
        this.offset = 0;
        Log.d("ERROR_BREWERY", description);
    }

    @Override
    public void onSuccess(Brewery brewery) {
        this.breweryView.hideLoading();

        breweries.addAll(brewery.getBreweries());

        if(this.nPages == 0){
            this.nPages = (brewery.getRegistros() > this.limit) ? Math.round((float) brewery.getRegistros() / this.limit) : 1;

            adapter = new BreweryAdapter(view.getContext(), brewery.getBreweries());
            this.breweryView.showCardsBreweries(adapter);

        }else{

            if(brewery.getBreweries().size() > 0){
                this.proccessMoreBreweries(brewery);
            }

        }

    }

    @Override
    public void onApiError(ApiError error) {

    }

    @Override
    public void onInternetError(ApiError error) {
        UtilNetwork.showNetworkInfo(this.view, this.breweryView.getContext(), error);
    }

}
