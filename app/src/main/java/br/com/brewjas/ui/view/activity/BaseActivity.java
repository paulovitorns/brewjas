package br.com.brewjas.ui.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import br.com.brewjas.ui.view.component.DialogAlert;
import br.com.brewjas.ui.view.component.DialogLoading;

/**
 * Created by PauloSales on 06/06/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private DialogAlert dialogAlert;
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

    public void showDialog(String title, String msg){
        FragmentManager fragmentManager = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("description", msg);

        dialogAlert = new DialogAlert();
        dialogAlert.setArguments(bundle);

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, dialogAlert)
                .addToBackStack(null).commit();

    }

    public void hideDialog(){
        dialogAlert.dismiss();
        dialogAlert = null;
    }

    public void showLoading(){

        FragmentManager fragmentManager = getSupportFragmentManager();
        loadingDialog = new DialogLoading();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, loadingDialog)
                .addToBackStack(null).commit();

    }

    public void hideLoading(){

        loadingDialog.dismiss();
        loadingDialog = null;
    }

    public void navigateToNextScreen(Intent intent){
        startActivity(intent);
    }

}
