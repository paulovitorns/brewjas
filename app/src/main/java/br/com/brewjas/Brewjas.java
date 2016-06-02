package br.com.brewjas;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;

/**
 * Created by PauloSales on 02/06/2016.
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
