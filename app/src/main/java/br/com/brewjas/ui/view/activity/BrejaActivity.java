package br.com.brewjas.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.model.Beer;
import br.com.brewjas.model.Client;
import br.com.brewjas.ui.adapter.BeerRelatedAdapter;
import br.com.brewjas.ui.view.BaseView;
import br.com.brewjas.ui.view.component.BrejaRelacionadaView;
import br.com.brewjas.ui.view.component.CustomDialog;
import br.com.brewjas.ui.view.component.ProgressDialog;
import butterknife.Bind;
import butterknife.ButterKnife;
/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BrejaActivity extends BaseActivity implements BaseView {

    @Bind(R.id.collapsingToolBar)   CollapsingToolbarLayout collapsingToolbarLayout = null;
    @Bind(R.id.toolbar)             Toolbar toolbar = null;
    @Bind(R.id.txDesc)              TextView descBeer = null;
    @Bind(R.id.vpBrejas)            ViewPager viewPager;

    private List<Beer> beers;
    private Beer beer;

    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breja);

        ButterKnife.bind(this);

        beer = (Beer) getIntent().getSerializableExtra(Beer.KEY);

        CharSequence desc = "Is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        setSupportActionBar(toolbar);

        descBeer.setText(desc);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setTitle(beer.getName());

        toolbarTextAppearence();

        beers = new ArrayList<>();

        loadBeers();

        BrejaRelacionadaView brejaRelacionadaView = new BrejaRelacionadaView(this, beers);

        viewPager.setAdapter(new BeerRelatedAdapter(this, brejaRelacionadaView.getViewGroup()));


    }

    private void loadBeers(){

        Beer beer1 = new Beer("Guinness Draught", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "5%", "50");
        beers.add(beer1);
        Beer beer2 = new Beer("Guinness Draught light", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "6%", "60");
        beers.add(beer2);
        Beer beer3 = new Beer("Guinness Draught mediun", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "7%", "70");
        beers.add(beer3);
        Beer beer4 = new Beer("Guinness Draught light strong", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "8%", "80");
        beers.add(beer4);
        Beer beer5 = new Beer("Guinness Draught hardcore", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "9%", "90");
        beers.add(beer5);
        Beer beer6 = new Beer("Guinness Draught Badass", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "10%", "90");
        beers.add(beer6);
        Beer beer7 = new Beer("Guinness Draught punk", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "11%", "95");
        beers.add(beer7);
        Beer beer8 = new Beer("Guinness Draught X-X", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "12%", "100");
        beers.add(beer8);

    }

    private void toolbarTextAppearence() {

        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.brejas_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case R.id.action_fav:
                item.setIcon(getResources().getDrawable(R.drawable.ic_favorite_white_48dp));
            break;

            default:
                super.onOptionsItemSelected(item);
            break;

        }
        return true;
    }

    @Override
    public void setupActionBar() {

    }

    @Override
    public void showDialog(String title, String description) {

        try{
            new CustomDialog(getContext(), title, description).show();
        } catch (Exception e){}
    }

    @Override
    public void navigateToNextScreenWithSerializedCliente(Client client) {

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

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}
