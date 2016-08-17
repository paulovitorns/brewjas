package br.com.brewjas.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.brewjas.model.Client;
import br.com.brewjas.ui.view.BaseView;
import br.com.brewjas.ui.view.component.CustomDialog;
import br.com.brewjas.ui.view.component.DialogLoading;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private DialogLoading loadingDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public void startActivity(Intent intent) {

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        super.startActivity(intent);
    }

    @Override
    public void navigateToNextScreenWithSerializedCliente(Client client) {
        Intent intent = new Intent(getContext(), DashBoardActivity.class);

        intent.putExtra("Client", client);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:

                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        super.onBackPressed();
    }

    @Override
    public void setupActionBar() {

    }

    @Override
    public void showDialog(String title, String msg){

        try{
            new CustomDialog(this, title, msg).show();
        } catch (Exception e){}
        /*FragmentManager fragmentManager = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("description", msg);

        dialogAlert = new DialogAlert();
        dialogAlert.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, dialogAlert)
                .addToBackStack(null).commit();
        */
    }

    @Override
    public void showLoading(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        loadingDialog = new DialogLoading();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, loadingDialog)
                .addToBackStack(null).commit();

    }

    @Override
    public void hideLoading(){

        loadingDialog.dismiss();
        loadingDialog = null;
    }

    @Override
    public Context getContext() {
        return this;
    }
}
