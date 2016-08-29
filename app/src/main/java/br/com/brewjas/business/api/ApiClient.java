package br.com.brewjas.business.api;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import br.com.brewjas.Brewjas;
import br.com.brewjas.BuildConfig;
import br.com.brewjas.R;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class ApiClient extends OkHttpClient {

    private static ApiClient instance;
    private final static int TIMEOUT = Brewjas.getContext().getResources().getInteger(R.integer.api_time_out);

    private ApiClient(){}

    public static ApiClient getInstance() {

        if (instance == null) {

            instance = new ApiClient();
            instance.setConnectTimeout(TIMEOUT, TimeUnit.SECONDS);
            instance.setReadTimeout(TIMEOUT, TimeUnit.SECONDS);
            instance.setWriteTimeout(TIMEOUT, TimeUnit.SECONDS);

            if (BuildConfig.DEBUG) {
                instance.interceptors().add(getLogInterceptor());
            }

        }

        return instance;
    }

    private static HttpLoggingInterceptor getLogInterceptor(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger(){
                    @Override
                    public void log(String message) {
                        Log.d("OkHttp", message);
                    }
                }
        );
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return logging;
    }

}
