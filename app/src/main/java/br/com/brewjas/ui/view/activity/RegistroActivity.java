package br.com.brewjas.ui.view.activity;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import br.com.brewjas.R;
import br.com.brewjas.adapter.GenderAdapter;
import br.com.brewjas.api.general.request.Cliente;
import br.com.brewjas.ui.view.RegistroView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistroActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, RegistroView {

    private LinearLayout contentPanel;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.HeaderTitle) TextView HeaderTitle;
    @Bind(R.id.spinnerGenero) Spinner spinnerGenero;
    private String[] gender = new String[]{"Seu gênero", "Masculino", "Feminino"};

    @Bind(R.id.edtNome) EditText edtNome;
    @Bind(R.id.edtLogin) EditText edtLogin;
    @Bind(R.id.btnDataNasc) Button btnDataNasc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ButterKnife.bind(this);

        setupActionBar();
        loadContent();

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        spinnerGenero.setLayoutParams(lp1);
        spinnerGenero.setAdapter(adapter1);
        spinnerGenero.setAdapter(new GenderAdapter(this, gender));

    }

    @Override
    public void setupActionBar() {

        toolbar.setTitle("");

        HeaderTitle.setText(getResources().getString(R.string.txt_title_registro));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadContent(){

        contentPanel = (LinearLayout) findViewById(R.id.contentPanel);
        Animation showLogo  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacao_register);
        contentPanel.startAnimation(showLogo);
    }

    @OnClick(R.id.btnDataNasc)
    public void setDataNasc(){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                RegistroActivity.this,
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

    @Override
    public void errorNameUser(String error) {
        Toast.makeText(RegistroActivity.this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorEmailUser(String error) {
        Toast.makeText(RegistroActivity.this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorDataNascimento(String error) {
        Toast.makeText(RegistroActivity.this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorGenero(String error) {
        Toast.makeText(RegistroActivity.this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDialog(String title, String msg) {

    }

    @Override
    public void navigateToNextScreen() {

    }

    @Override
    public void navigateToNextScreenWithSerializedCliente(Cliente cliente) {

        Intent intent = new Intent(RegistroActivity.this, DashBoardActivity.class);

        intent.putExtra("Cliente", cliente);
        startActivity(intent);
    }

    @Override
    public Context getActivityContect() {
        return getApplicationContext();
    }
}
