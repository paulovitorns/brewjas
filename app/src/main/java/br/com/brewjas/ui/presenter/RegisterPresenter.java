package br.com.brewjas.ui.presenter;

import br.com.brewjas.api.general.request.Cliente;

/**
 * Created by Paulo Vitor on 06/06/2016.
 */
public interface RegisterPresenter extends BasePresenter {

    void onSubmitPressed(Cliente cliente);

    void checkEmailIsRegistered(String email);

    void checkIsOverAge(String dataNascimento);
}
