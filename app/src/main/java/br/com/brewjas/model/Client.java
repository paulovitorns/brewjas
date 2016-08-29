package br.com.brewjas.model;

import java.io.Serializable;
import java.util.Date;

import br.com.brewjas.business.api.vo.response.ClientResponse;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Client implements Serializable {

    public static final String KEY = "ClientKey";

    private long id;
    private String regId;
    private String facebookId;
    private String nome;
    private String email;
    private Date dataNascimento;
    private int genero;
    private Date dataCriacao;

    public Client() {
    }

    public Client(ClientResponse clientResponse) {
        this.id             = clientResponse.id;
        this.regId          = clientResponse.regId;
        this.facebookId     = clientResponse.facebookId;
        this.nome           = clientResponse.nome;
        this.email          = clientResponse.email;
        this.dataNascimento = clientResponse.dataNascimento;
        this.genero         = clientResponse.genero;
        this.dataCriacao    = clientResponse.dataCriacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
