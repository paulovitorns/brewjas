package br.com.brewjas.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class GsonUtil {

    public static Gson getGson(){
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
    }

}
