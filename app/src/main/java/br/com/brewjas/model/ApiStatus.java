package br.com.brewjas.model;

import br.com.brewjas.business.api.vo.response.ApiStatusResponse;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class ApiStatus {
    public int      code;
    public String   status;

    public ApiStatus(ApiStatusResponse response){
        this.code   = response.code;
        this.status = response.status;
    }
}
