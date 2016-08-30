package br.com.brewjas.ui.presenter.impl;

import br.com.brewjas.business.service.RegisterService;
import br.com.brewjas.business.service.impl.RegisterServiceImpl;
import br.com.brewjas.model.Client;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.business.service.LoginService;
import br.com.brewjas.business.service.impl.LoginServiceImpl;
import br.com.brewjas.ui.presenter.LoginPresenter;
import br.com.brewjas.ui.view.LoginFragmentView;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class LoginPresenterImpl implements LoginPresenter, OnListenerGeneral {

    private LoginFragmentView   loginView;
    private LoginService        loginService;
    private RegisterService     registerService;

    public LoginPresenterImpl(LoginFragmentView loginView){
        this.loginView = loginView;
        init();
    }

    //Inicio os serviços responsaveis pelo login do usuário
    @Override
    public void init() {
        loginService    = new LoginServiceImpl();
        registerService = new RegisterServiceImpl();
    }

    @Override
    public void onError(String title, String description) {
        loginView.hideLoading();
        this.loginView.setUsernameError(title, description);
    }

    @Override
    public void onSuccess(Client client) {
        loginView.hideLoading();
        loginView.navigateToNextScreenWithSerializedCliente(client);
    }


    @Override
    public void onSubmitPressed(String email) {
        loginView.showLoading();
        loginService.login(email, this);
    }

    @Override
    public void registerByLogin(Client client) {
        registerService.registerByFb(client, this);
    }

}
