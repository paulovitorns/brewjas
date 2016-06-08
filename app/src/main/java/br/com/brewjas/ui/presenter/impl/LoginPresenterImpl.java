package br.com.brewjas.ui.presenter.impl;

import br.com.brewjas.api.general.request.Cliente;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.services.brewjasapi.LoginService;
import br.com.brewjas.services.brewjasapi.impl.LoginServiceImpl;
import br.com.brewjas.ui.presenter.LoginPresenter;
import br.com.brewjas.ui.view.LoginFragmentView;

/**
 * Created by PauloSales on 02/06/2016.
 */
public class LoginPresenterImpl implements LoginPresenter, OnListenerGeneral {

    private LoginFragmentView loginView;
    private LoginService loginService;

    public LoginPresenterImpl(LoginFragmentView loginView){
        this.loginView = loginView;
        init();
    }

    //Inicio os serviços responsaveis pelo login do usuário
    @Override
    public void init() {

        loginService = new LoginServiceImpl();
    }

    @Override
    public void onError(String title, String description) {
        this.loginView.hideLoading();
        this.loginView.setUsernameError(title, description);
    }

    @Override
    public void onSuccess(Cliente cliente) {
        this.loginView.hideLoading();
        loginView.navigateToNextScreenWithSerializedCliente(cliente);
    }


    @Override
    public void onSubmitPressed(String email) {
        this.loginView.showLoading();
        loginService.login(email, this);
    }

}
