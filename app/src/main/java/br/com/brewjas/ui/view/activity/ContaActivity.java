package br.com.brewjas.ui.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.model.Client;
import br.com.brewjas.ui.adapter.GenderAdapter;
import br.com.brewjas.ui.presenter.RegisterPresenter;
import br.com.brewjas.ui.presenter.impl.RegisterPresenterImpl;
import br.com.brewjas.ui.view.RegisterView;
import br.com.brewjas.ui.view.component.CustomDialog;
import br.com.brewjas.ui.view.component.ProgressDialog;
import br.com.brewjas.util.SharedPreferencesUtil;
import br.com.brewjas.util.StringUtils;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */

public class ContaActivity extends BaseActivity implements DatePickerDialog.OnDateSetListener, RegisterView {

    private LinearLayout        contentPanel;

    @Bind(R.id.toolbar)         Toolbar     toolbar;
    @Bind(R.id.HeaderTitle)     TextView    HeaderTitle;
    @Bind(R.id.txtIntro)        TextView    intro;
    @Bind(R.id.spinnerGenero)   Spinner     spinnerGenero;
    @Bind(R.id.edtNome)         EditText    edtNome;
    @Bind(R.id.edtLogin)        EditText    edtLogin;
    @Bind(R.id.btnDataNasc)     Button      btnDataNasc;


    private String[]            gender      = Brewjas.getContext().getResources().getStringArray(R.array.gender);
    private RegisterPresenter   presenter   = new RegisterPresenterImpl(this);

    private ProgressDialog      mProgressDialog;

    private Client              client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta);

        ButterKnife.bind(this);

        client = SharedPreferencesUtil.getSession();

        intro.setText(StringUtils.setLabel(intro.getText().toString(), client.getNome()));

        setupActionBar();
        loadContent();

        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        spinnerGenero.setLayoutParams(lp1);
        spinnerGenero.setAdapter(new GenderAdapter(this, gender));

        spinnerGenero.setSelection(client.getGenero());
        Log.d("GENDER", ""+client.getGenero());
    }

    @OnClick(R.id.btnEnviar)
    public void onSubmit(){

        Client client = new Client();

        client.setNome(edtNome.getText().toString());
        client.setEmail(edtLogin.getText().toString());
        client.setDataNascimento(StringUtils.parseStringToDate(btnDataNasc.getText().toString()));
        client.setGenero(spinnerGenero.getSelectedItemPosition());

        presenter.onSubmitPressed(client);
    }

    @Override
    public void setupActionBar() {

        toolbar.setTitle("");

        HeaderTitle.setText(getResources().getString(R.string.title_acc));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void loadContent(){

        contentPanel = (LinearLayout) findViewById(R.id.contentPanel);
        Animation showLogo  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacao_register);
        contentPanel.startAnimation(showLogo);

        edtNome.setText(client.getNome());
        edtLogin.setText(client.getEmail());
        btnDataNasc.setText(StringUtils.parseDateToString(client.getDataNascimento()));
    }

    @Override
    public void errorRegister(String title, String description) {

        showDialog(title, description);
    }

    @Override
    public void showDialog(String title, String msg) {

        try{
            new CustomDialog(getContext(), title, msg).show();
        } catch (Exception e){}
    }

    @Override
    public void navigateToNextScreenWithSerializedCliente(Client client) {
        Intent intent = new Intent(getContext(), DashBoardActivity.class);
        intent.putExtra("Client", client);

        startActivity(intent);
        finish();
    }

    @Override
    public void showLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            hideLoading();
        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @OnClick(R.id.btnDataNasc)
    public void setDataNasc(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                ContaActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setThemeDark(false);
        dpd.vibrate(true);
        dpd.dismissOnPause(true);
        int color = getResources().getColor(R.color.colorMarrom);
        dpd.setAccentColor(color);
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        btnDataNasc.setText(date);
    }

}
