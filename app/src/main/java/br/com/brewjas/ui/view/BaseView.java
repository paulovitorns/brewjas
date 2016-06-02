package br.com.brewjas.ui.view;

import android.content.Context;
import android.content.Intent;

/**
 * Created by PauloSales on 02/06/2016.
 */
public interface BaseView {

    void showDialog();

    void navigateToNextScreen();

    Context getActivityContect();
}
