package br.com.brewjas.model;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class ApiError {

    public static String KEY = ApiError.class.getSimpleName();

    private int     code;
    private String  msg;

    public ApiError(int code) {
        this.code = code;
        this.setApiError();
    }

    private void setApiError(){

        switch (this.code){
            case 400:
                this.msg = Brewjas.getContext().getString(R.string.error_bad_resquest);
                break;
            case 401:
                this.msg = Brewjas.getContext().getString(R.string.error_unauthorized);
                break;
            case 402:
                this.msg = Brewjas.getContext().getString(R.string.error_access_limit);
                break;
            case 404:
                this.msg = Brewjas.getContext().getString(R.string.error_not_found);
                break;
            case 500:
                this.msg = Brewjas.getContext().getString(R.string.error_server_error);
                break;
            default:
                this.msg = Brewjas.getContext().getString(R.string.error_internet_conection);
                break;
        }

    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
