package br.com.brewjas.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.view.View;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.model.ApiError;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class UtilNetwork {

    public static boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) Brewjas.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }

    public static void showNetworkInfo(View view, final Context context, ApiError error){

        final Snackbar snackbar = Snackbar
                .make(view, error.getMsg(), Snackbar.LENGTH_LONG)
                .setActionTextColor(Brewjas.getContext().getResources().getColor(R.color.colorMarromEdtPressed))
                .setAction("CONECTAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        context.startActivity(intent);
                    }
                });

        snackbar.show();

    }

}
