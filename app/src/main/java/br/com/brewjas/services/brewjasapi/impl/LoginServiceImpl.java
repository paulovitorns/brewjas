package br.com.brewjas.services.brewjasapi.impl;

import android.text.TextUtils;
import android.util.Log;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.api.general.request.Cliente;
import br.com.brewjas.services.brewjasapi.LoginService;
import br.com.brewjas.common.OnLoginListenerFinished;

/**
 * Created by PauloSales on 02/06/2016.
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public void login(String email, OnLoginListenerFinished loginListenerFinished) {

        if(TextUtils.isEmpty(email)){

            Log.d("LOGIN_EMPTY", "O e-mail esta vazio");
            loginListenerFinished.onEmailErro(Brewjas.getContext().getString(R.string.err_login_is_empty));
            return;
        }else{

            Cliente cliente = new Cliente("Usuário Estático", email, "11/11/1111", 0);
            loginListenerFinished.onSuccess(cliente);
        }



    }
}
