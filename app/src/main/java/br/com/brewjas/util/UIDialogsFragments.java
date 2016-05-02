package br.com.brewjas.util;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import br.com.brewjas.ui.fragment.DialogHelpLogin;

/**
 * Created by Paulo on 14/04/2016.
 */
public class UIDialogsFragments extends Fragment {

    FragmentActivity fragmentActivity;

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

}
