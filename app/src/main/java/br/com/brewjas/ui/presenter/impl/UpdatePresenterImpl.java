package br.com.brewjas.ui.presenter.impl;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.brewjas.R;
import br.com.brewjas.business.service.UpdateService;
import br.com.brewjas.business.service.impl.UpdateServiceImpl;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.model.Client;
import br.com.brewjas.ui.presenter.UpdatePresenter;
import br.com.brewjas.ui.view.RegisterView;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class UpdatePresenterImpl implements UpdatePresenter, OnListenerGeneral {

    private RegisterView    registerView;
    private UpdateService   updateService;

    public UpdatePresenterImpl(RegisterView registerView){
        this.registerView = registerView;
        init();
    }

    @Override
    public void init() {
        updateService = new UpdateServiceImpl();
    }

    @Override
    public void onError(String title, String description) {
        this.registerView.hideLoading();
        this.registerView.errorRegister(title, description);
    }

    @Override
    public void onSuccess(Client client) {
        this.registerView.hideLoading();
        registerView.navigateToNextScreenWithSerializedCliente(client);
    }

    @Override
    public void onSubmitPressed(Client client) {
        this.registerView.showLoading();
        updateService.update(client, this);
    }

    @Override
    public void checkIsOverAge(String dataNascimento) {
        if(verifyBirthDate(dataNascimento)){

        }else{
            this.registerView.errorRegister(registerView.getContext().getString(R.string.err_title_underage), registerView.getContext().getString(R.string.err_is_underage));
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
