package br.com.brewjas.model;

import java.io.Serializable;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Client implements Serializable {

    private long id;

    private String nome;

    private String email;

    private String datanascimento;

    private int genero;

    public Client() {
    }

    public Client(String nome, String email, String datanascimento, int genero) {
        this.nome = nome;
        this.email = email;
        this.datanascimento = datanascimento;
        this.genero = genero;
    }

    public Client(long id, String nome, String email, String datanascimento, int genero) {
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
