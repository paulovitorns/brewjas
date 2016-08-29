package br.com.brewjas.business.api.vo.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class ClientResponse {

    @SerializedName("id")               public long     id;
    @SerializedName("regId")            public String   regId;
    @SerializedName("facebookId")       public String   facebookId;
    @SerializedName("nome")             public String   nome;
    @SerializedName("email")            public String   email;
    @SerializedName("dataNascimento")   public Date     dataNascimento;
    @SerializedName("genero")           public int      genero;
    @SerializedName("dataCriacao")      public Date     dataCriacao;
}
