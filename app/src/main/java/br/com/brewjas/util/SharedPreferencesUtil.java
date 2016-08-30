package br.com.brewjas.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import br.com.brewjas.Brewjas;
import br.com.brewjas.model.Client;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class SharedPreferencesUtil {

    private static final String PREFERENCES = "BREWJAS_APP";

    private static final String TAG = "gcm";
    private static final String PROPERTY_REG_ID = "registration_id";
    private static final String CLIENT = Client.KEY;

    private static SharedPreferences getPreferences(){
        SharedPreferences sharedPreferences = Brewjas.getContext().getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public static boolean saveSession(Client client){

        SharedPreferences preferences   = getPreferences();
        SharedPreferences.Editor editor = preferences.edit();

        String persistence              = new Gson().toJson(client, Client.class);

        return editor.putString(CLIENT, persistence).commit();
    }

    public static boolean unsetSession(){
        SharedPreferences sharedPreferences = getPreferences();
        SharedPreferences.Editor editor     = sharedPreferences.edit();

        return editor.putString(CLIENT, null).commit();
    }

    public static Client getSession(){
        SharedPreferences sharedPreferences = getPreferences();
        String clientStr                    = sharedPreferences.getString(CLIENT, "");
        return new Gson().fromJson(clientStr, Client.class);
    }

}
