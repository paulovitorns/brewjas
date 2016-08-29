package br.com.brewjas.business.service.impl;

import android.text.TextUtils;
import android.util.Log;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.business.api.Api;
import br.com.brewjas.business.api.vo.request.ClienteRequest;
import br.com.brewjas.business.api.vo.response.ClientFullResponseVO;
import br.com.brewjas.business.api.vo.response.ClientResponse;
import br.com.brewjas.model.ApiStatus;
import br.com.brewjas.model.Client;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.business.service.LoginService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public void login(String email, final OnListenerGeneral listener) {

        if(TextUtils.isEmpty(email)){

            Log.d("LOGIN_EMPTY", "O e-mail esta vazio");
            listener.onError(Brewjas.getContext().getString(R.string.err_login_title_register), Brewjas.getContext().getString(R.string.err_login_is_empty));
            return;
        }else{

            ClienteRequest clienteRequest   = new ClienteRequest();
            clienteRequest.email            = email;

            Call<ClientFullResponseVO> call = Api.getAdapter()
                    .login(clienteRequest.email);

            call.enqueue(new Callback<ClientFullResponseVO>() {
                @Override
                public void onResponse(Response<ClientFullResponseVO> response, Retrofit retrofit) {
                    ApiStatus apiStatus = new ApiStatus(response.body().response);

                    if(apiStatus.code == 200){
                        listener.onSuccess(new Client(response.body().clientResponse));
                    }

                    if(apiStatus.code == 404){
                        listener.onError(Brewjas.getContext().getString(R.string.err_login_title_register), Brewjas.getContext().getString(R.string.err_login_user));
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.d("ERROR LOGIN CLIENT", t.getMessage());
                    Log.d("ERROR LOGIN CLIENT", t.getCause().toString());
                    Log.d("ERROR LOGIN CLIENT", t.getStackTrace().toString());
                    listener.onError(Brewjas.getContext().getString(R.string.err_login_title_register), Brewjas.getContext().getString(R.string.err_server_500));
                }
            });

        }

    }
}
