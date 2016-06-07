package br.com.brewjas.ui.presenter.impl;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.brewjas.api.general.request.Cliente;
import br.com.brewjas.common.OnListenerGeneral;
import br.com.brewjas.services.brewjasapi.RegisterService;
import br.com.brewjas.services.brewjasapi.impl.RegisterServiceImpl;
import br.com.brewjas.ui.presenter.RegisterPresenter;
import br.com.brewjas.ui.view.RegisterView;

/**
 * Created by Paulo Vitor on 06/06/2016.
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
    public void onError(String error) {
        this.registerView.errorRegister(error);
    }

    @Override
    public void onSuccess(Cliente cliente) {
        registerView.navigateToNextScreenWithSerializedCliente(cliente);
    }

    @Override
    public void onSubmitPressed(Cliente cliente) {
        registerService.register(cliente, this);
    }

    @Override
    public void checkEmailIsRegistered(String email) {
        registerService.checkEmail(email, this);
    }

    @Override
    public void checkIsOverAge(String dataNascimento) {
        if(verifyBirthDate(dataNascimento)){

        }else{
            this.registerView.errorRegister("Você ainda é menor de idade.");
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
