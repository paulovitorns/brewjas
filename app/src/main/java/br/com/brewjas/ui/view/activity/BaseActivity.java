package br.com.brewjas.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import br.com.brewjas.model.ApiError;
import br.com.brewjas.model.Client;
import br.com.brewjas.ui.view.component.ProgressDialog;
import br.com.brewjas.util.UtilNetwork;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ProgressDialog      mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showNetworkInfo();
    }

    @Override
    public void startActivity(Intent intent) {

        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        super.startActivity(intent);
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
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public void showLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            hideLoading();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.show();
    }

    public void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    public void showNetworkInfo(){
        if(!UtilNetwork.isNetworkAvailable()){
            View view = this.getWindow().getDecorView().findViewById(android.R.id.content);
            UtilNetwork.showNetworkInfo(view, this, new ApiError(0));
        }

    }

}
