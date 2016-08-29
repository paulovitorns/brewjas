package br.com.brewjas.business.service.impl;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.model.Client;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.business.service.RegisterService;
import br.com.brewjas.util.StringUtils;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class RegisterServiceImpl implements RegisterService {

    @Override
    public void register(Client client, OnListenerGeneral listener) {

        String erros = "";

        if(TextUtils.isEmpty(client.getNome()))
            erros+= "\nseu nome";

        if(TextUtils.isEmpty(client.getEmail()))
            erros+= "\nseu e-mail";

        if(TextUtils.isEmpty(StringUtils.parseDateToString(client.getDataNascimento())))
            erros+= "\nsua data de nascimento";

        if(client.getGenero() == 0)
            erros+= "\nseu gênero";

        if(!TextUtils.isEmpty(erros)){

            String erroTitle = Brewjas.getContext().getString(R.string.err_register_general);

            Log.d("CAMPOS_VAZIOS", erroTitle+" "+erros);
            listener.onError(Brewjas.getContext().getString(R.string.err_register_general_title), erroTitle+" "+erros);

        }else{

            String user = new Gson().toJson(client, Client.class);

            Log.d("USER", user);

            listener.onSuccess(client);
        }
    }

    @Override
    public void checkEmail(String email, OnListenerGeneral listener) {

    }
}
