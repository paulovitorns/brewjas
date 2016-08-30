package br.com.brewjas.business.service.impl;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.business.api.Api;
import br.com.brewjas.business.api.vo.response.ClientFullResponseVO;
import br.com.brewjas.business.service.RegisterService;
import br.com.brewjas.business.service.UpdateService;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.model.ApiStatus;
import br.com.brewjas.model.Client;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class UpdateServiceImpl implements UpdateService {

    @Override
    public void update(Client client, final OnListenerGeneral listener) {

        String erros = "";

        if(TextUtils.isEmpty(client.getNome()))
            erros+= "\nseu nome";

        if(TextUtils.isEmpty(client.getEmail()))
            erros+= "\nseu e-mail";

        if(client.getDataNascimento() == null)
            erros+= "\nsua data de nascimento";

        if(client.getGenero() == 0)
            erros+= "\nseu gênero";

        if(!TextUtils.isEmpty(erros)){

            String erroTitle = Brewjas.getContext().getString(R.string.err_register_general);

            Log.d("CAMPOS_VAZIOS", erroTitle+" "+erros);
            listener.onError(Brewjas.getContext().getString(R.string.err_register_general_title), erroTitle+" "+erros);

        }else{

            String clientJson = new Gson().toJson(client, Client.class);

            Call<ClientFullResponseVO> call = Api.getAdapter().update(clientJson);

            call.enqueue(new Callback<ClientFullResponseVO>() {
                @Override
                public void onResponse(Response<ClientFullResponseVO> response, Retrofit retrofit) {

                    ApiStatus apiStatus = new ApiStatus(response.body().response);

                    if(apiStatus.code == 200){
                        listener.onSuccess(new Client(response.body().clientResponse));
                    }

                    if(apiStatus.code == 401){
                        listener.onError(Brewjas.getContext().getString(R.string.err_login_title_register), Brewjas.getContext().getString(R.string.err_register_email_exists));
                    }

                    if(apiStatus.code == 500){
                        listener.onError(Brewjas.getContext().getString(R.string.err_login_title_register), Brewjas.getContext().getString(R.string.err_register_fails));
                    }

                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("ERROR CLIENT", t.getMessage());
                    listener.onError(Brewjas.getContext().getString(R.string.err_login_title_register), Brewjas.getContext().getString(R.string.err_server_500));
                }
            });

        }
    }

    @Override
    public void checkEmail(String email, OnListenerGeneral listener) {

    }
}
