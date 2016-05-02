package br.com.brewjas.ui.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.brewjas.R;

public class RecuperAcessoActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView HeaderTitle;

    private LinearLayout contentPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuper_acesso);

        setupActionBar();
        loadContent();
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        HeaderTitle = (TextView) findViewById(R.id.HeaderTitle);
        toolbar.setTitle("");

        HeaderTitle.setText(getResources().getString(R.string.txt_title_recuperar));
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
}
