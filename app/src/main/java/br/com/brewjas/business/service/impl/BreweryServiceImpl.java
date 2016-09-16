package br.com.brewjas.business.service.impl;

import android.util.Log;

import br.com.brewjas.business.api.Api;
import br.com.brewjas.business.api.vo.request.BreweryRequest;
import br.com.brewjas.business.api.vo.response.BreweryResponse;
import br.com.brewjas.business.service.BreweryService;
import br.com.brewjas.common.OnBreweriesFinishedListener;
import br.com.brewjas.model.Brewery;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BreweryServiceImpl implements BreweryService {

    @Override
    public void getBreweries(final BreweryRequest request, final OnBreweriesFinishedListener listener) {

        Call<BreweryResponse> call = Api.getAdapter()
                .getBreweries(
                        request.term,
                        request.offset,
                        request.limit);

        call.enqueue(new Callback<BreweryResponse>() {

            @Override
            public void onResponse(Response<BreweryResponse> response, Retrofit retrofit) {
                if(response.body().response.code == 200){
                    Brewery brewery = new Brewery(response.body());
                    listener.onSuccess(brewery);
                }
                if(response.body().response.code == 404){
                    listener.onError("Error do servidor", "Sem dados para exibir");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("ERROR_BREWERY", t.getMessage());
                Log.d("ERROR_BREWERY", t.getStackTrace().toString());
                Log.d("ERROR_BREWERY", t.getCause().toString());
                listener.onError("Error do servidor", "Não foi possível completar a sua requisição no momento.");
            }

        });

    }

}
