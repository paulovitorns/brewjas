package br.com.brewjas.ui.view;

import br.com.brewjas.api.general.request.Cliente;

/**
 * Created by PauloSales on 02/06/2016.
 */
public interface BaseView {

    void setupActionBar();

    void navigateToNextScreenWithSerializedCliente(Cliente cliente);

    void showDialog(String title, String description);

    void hideDialog();

    void showLoading();

    void hideLoading();
}
