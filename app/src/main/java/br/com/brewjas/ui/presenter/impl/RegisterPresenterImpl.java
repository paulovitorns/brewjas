package br.com.brewjas.ui.presenter.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.model.Cliente;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.services.brewjasapi.RegisterService;
import br.com.brewjas.services.brewjasapi.impl.RegisterServiceImpl;
import br.com.brewjas.ui.presenter.RegisterPresenter;
import br.com.brewjas.ui.view.RegisterView;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public class RegisterPresenterImpl implements RegisterPresenter, OnListenerGeneral {

    private RegisterView registerView;
    private RegisterService registerService;

    public RegisterPresenterImpl( RegisterView registerView){
        this.registerView = registerView;
        init();
    }

    @Override
    public void init() {
        registerService = new RegisterServiceImpl();
    }

    @Override
    public void onError(String title, String description) {
        this.registerView.hideLoading();
        this.registerView.errorRegister(title, description);
    }

    @Override
    public void onSuccess(Cliente cliente) {
        this.registerView.hideLoading();
        registerView.navigateToNextScreenWithSerializedCliente(cliente);
    }

    @Override
    public void onSubmitPressed(Cliente cliente) {
        this.registerView.showLoading();
        registerService.register(cliente, this);
    }

    @Override
    public void checkEmailIsRegistered(String email) {
        this.registerView.showLoading();
        registerService.checkEmail(email, this);
    }

    @Override
    public void checkIsOverAge(String dataNascimento) {
        if(verifyBirthDate(dataNascimento)){

        }else{
            this.registerView.errorRegister("Você é menor de idade", Brewjas.getContext().getResources().getString(R.string.err_is_underage));
        }
    }

    private boolean verifyBirthDate(String datanascimento){

        Date date = stringToDate(datanascimento);

        return false;
    }

    private Date stringToDate(String aDate) {

        if(aDate==null) return null;

        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/M/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date stringDate = simpledateformat.parse(aDate, pos);

        return stringDate;

    }
}
