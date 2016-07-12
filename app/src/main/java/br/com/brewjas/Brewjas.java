package br.com.brewjas;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;

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
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        Brewjas.context = context;
    }
}
