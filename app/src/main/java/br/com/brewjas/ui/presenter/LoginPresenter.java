package br.com.brewjas.ui.presenter;

import android.support.v4.app.FragmentActivity;

/**
 * Created by PauloSales on 02/06/2016.
 */
public interface LoginPresenter extends BasePresenter {

    void onSubmitPressed(String email);
}
