package br.com.brewjas;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Brewjas extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        FacebookSdk.sdkInitialize(context);

        //TODO: Picasso lib for download images and save in cache
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, Integer.MAX_VALUE));

        Picasso built = builder.build();
        built.setIndicatorsEnabled(false);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        Brewjas.context = context;
    }
}
