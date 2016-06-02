package br.com.brewjas.ui.view;

import android.content.Intent;

import br.com.brewjas.api.general.request.Cliente;

/**
 * Created by PauloSales on 02/06/2016.
 */
public interface LoginFragmentView {

    void setUsernameError(String error);

    void navigateToNextScreen(Cliente cliente);

}