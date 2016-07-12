package br.com.brewjas.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Cliente implements Serializable {

    @SerializedName("id")
    private long id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("email")
    private String email;

    @SerializedName("datanascimento")
    private String datanascimento;

    @SerializedName("genero")
    private int genero;

    public Cliente() {
    }

    public Cliente(String nome, String email, String datanascimento, int genero) {
        this.nome = nome;
        this.email = email;
        this.datanascimento = datanascimento;
        this.genero = genero;
    }

    public Cliente(long id, String nome, String email, String datanascimento, int genero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.datanascimento = datanascimento;
        this.genero = genero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
}
