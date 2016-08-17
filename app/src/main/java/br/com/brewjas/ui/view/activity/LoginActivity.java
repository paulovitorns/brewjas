package br.com.brewjas.ui.view.activity;

import android.os.Bundle;

import br.com.brewjas.R;
import br.com.brewjas.model.Client;
import br.com.brewjas.ui.view.fragment.LoginFragment;
/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class LoginActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = new LoginFragment();

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frag_login, loginFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void showDialog(String title, String msg) {
        super.showDialog(title, msg);
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

}
