package br.com.brewjas.services.brewjasapi.impl;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import br.com.brewjas.api.general.request.Cliente;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.services.brewjasapi.RegisterService;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public class RegisterServiceImpl implements RegisterService {

    @Override
    public void register(Cliente cliente, OnListenerGeneral listener) {

        String erros = "";

        if(TextUtils.isEmpty(cliente.getNome()))
            erros+= "\nSeu nome";

        if(TextUtils.isEmpty(cliente.getEmail()))
            erros+= "\nSeu e-mail";

        if(TextUtils.isEmpty(cliente.getDatanascimento()))
            erros+= "\nSua data de nascimento";

        if(cliente.getGenero() == 0)
            erros+= "\nSeu gênero";

        if(!TextUtils.isEmpty(erros)){

            Log.d("CAMPOS_VAZIOS", "Por favor preencha os seguintes campos: "+erros);
            listener.onError("Erro de validação =/", "Por favor, preencha este(s) campo(s): "+erros);
            return;
        }else{

            String user = new Gson().toJson(cliente, Cliente.class);

            Log.d("USER", user);

            listener.onSuccess(cliente);
            return;
        }
    }

    @Override
    public void checkEmail(String email, OnListenerGeneral listener) {

    }
}
