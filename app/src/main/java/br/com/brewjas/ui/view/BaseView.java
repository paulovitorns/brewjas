package br.com.brewjas.ui.view;

import android.content.Context;
import android.content.Intent;

import br.com.brewjas.api.general.request.Cliente;

/**
 * Created by PauloSales on 02/06/2016.
 */
public interface BaseView {

    void setupActionBar();

    void showDialog(String title, String msg);

    void navigateToNextScreen();

    void navigateToNextScreenWithSerializedCliente(Cliente cliente);

    Context getActivityContect();
}
