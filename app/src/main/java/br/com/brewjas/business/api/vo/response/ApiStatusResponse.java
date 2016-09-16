package br.com.brewjas.business.api.vo.response;

import com.google.gson.annotations.SerializedName;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class ApiStatusResponse {
    @SerializedName("code")         public int      code;
    @SerializedName("status")       public String   status;
    @SerializedName("registros")    public int      registros;
}
