package br.com.brewjas.business.api;

import com.google.gson.Gson;

import br.com.brewjas.BuildConfig;
import br.com.brewjas.util.GsonUtil;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Api {

    private static AppBrewjas adapter;

    public static final String BASE_URL = BuildConfig.REST_SERVICE_URL;

    private Api() {
    }

    private static AppBrewjas creatRestAdapter() {

        Gson gson = GsonUtil.getGson();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(ApiClient.getInstance())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(AppBrewjas.class);
    }

    public static AppBrewjas getAdapter() {
        if (adapter == null)
            adapter = creatRestAdapter();

        return adapter;
    }

}
