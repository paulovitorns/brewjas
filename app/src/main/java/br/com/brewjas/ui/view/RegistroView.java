package br.com.brewjas.ui.view;

/**
 * Created by PauloSales on 03/06/2016.
 */
public interface RegistroView extends BaseView {

    void loadContent();
    void errorNameUser(String error);
    void errorEmailUser(String error);
    void errorDataNascimento(String error);
    void errorGenero(String error);

}
