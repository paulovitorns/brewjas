package br.com.brewjas.ui.view;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface RegisterView extends BaseView {

    void loadContent();
    void errorRegister(String title, String description);
    void noConectionWithNetWork();

}
