package br.com.brewjas.services.brewjasapi.impl;

import android.text.TextUtils;
import android.util.Log;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.api.general.request.Cliente;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.services.brewjasapi.LoginService;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public void login(String email, OnListenerGeneral listener) {

        if(TextUtils.isEmpty(email)){

            Log.d("LOGIN_EMPTY", "O e-mail esta vazio");
            listener.onError("Hmmmm!", Brewjas.getContext().getString(R.string.err_login_is_empty));
            return;
        }else{

            Cliente cliente = new Cliente("Usuário Estático", email, "11/11/1111", 0);
            listener.onSuccess(cliente);
        }

    }
}
