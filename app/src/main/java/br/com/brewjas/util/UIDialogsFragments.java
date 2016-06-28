package br.com.brewjas.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import br.com.brewjas.ui.view.component.DialogAlert;
import br.com.brewjas.ui.view.component.DialogHelpLogin;
import br.com.brewjas.ui.view.component.DialogLoading;

/**
 * Created by Paulo on 14/04/2016.
 */
public class UIDialogsFragments extends Fragment {

    FragmentActivity fragmentActivity;
    public DialogLoading loadingDialog;

    public void uiGetActivity( FragmentActivity fragmentActivity){

        this.fragmentActivity = fragmentActivity;
    }

    public void showHelpDialog() {
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        DialogHelpLogin newFragment = new DialogHelpLogin();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, newFragment)
                .addToBackStack(null).commit();
    }

    public void showLoading(){

        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        loadingDialog = new DialogLoading();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, loadingDialog)
                .addToBackStack(null).commit();
    }


    public void showDialog(String title, String msg){

        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("description", msg);

        DialogAlert dialogAlert = new DialogAlert();
        dialogAlert.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, dialogAlert)
                .addToBackStack(null).commit();
    }

    public void showDialogFragment(String title, String msg){

        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("description", msg);

        DialogAlert dialogAlert = new DialogAlert();
        dialogAlert.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, dialogAlert)
                .addToBackStack(null).commit();
    }

}
