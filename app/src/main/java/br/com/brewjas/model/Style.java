package br.com.brewjas.model;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class Style {

    public static final String KEY = "StyleKey";

    private String  id;
    private String  name;
    private String  description;

    public Style(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Style(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
