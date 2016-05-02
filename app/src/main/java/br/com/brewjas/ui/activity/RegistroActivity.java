package br.com.brewjas.ui.activity;


import android.graphics.Color;
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

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import br.com.brewjas.R;
import br.com.brewjas.adapter.GenderAdapter;

public class RegistroActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private LinearLayout contentPanel;

    private Toolbar toolbar;
    private TextView HeaderTitle;
    private Spinner spinnerGenero;
    private String[] gender = new String[]{"Seu gênero", "Masculino", "Feminino"};

    private EditText edtNome;
    private EditText edtLogin;
    private EditText edtSenha;
    private EditText edtConfSenha;
    private Button btnDataNasc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        setupActionBar();
        loadContent();

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtConfSenha = (EditText) findViewById(R.id.edtConfSenha);
        btnDataNasc = (Button) findViewById(R.id.btnDataNasc);

        spinnerGenero = (Spinner) findViewById(R.id.spinnerGenero);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        spinnerGenero.setLayoutParams(lp1);
        spinnerGenero.setAdapter(adapter1);
        spinnerGenero.setAdapter(new GenderAdapter(this, gender));

        btnDataNasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        HeaderTitle = (TextView) findViewById(R.id.HeaderTitle);
        toolbar.setTitle("");

        HeaderTitle.setText(getResources().getString(R.string.txt_title_registro));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
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

    private void loadContent(){

        contentPanel = (LinearLayout) findViewById(R.id.contentPanel);

        Animation showLogo  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacao_register);

        contentPanel.startAnimation(showLogo);

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        btnDataNasc.setText(date);
    }
}
