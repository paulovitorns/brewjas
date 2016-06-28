package br.com.brewjas.ui.view.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.api.general.response.BeerResponse;
import br.com.brewjas.ui.adapter.BrejasRelacionadasAdapter;
import br.com.brewjas.ui.view.component.BrejaRelacionadaView;
import butterknife.Bind;
import butterknife.ButterKnife;

public class BrejaActivity extends BaseActivity {

    @Bind(R.id.collapsingToolBar)   CollapsingToolbarLayout collapsingToolbarLayout = null;
    @Bind(R.id.toolbar)             Toolbar toolbar = null;
    @Bind(R.id.txDesc)              TextView descBeer = null;
    @Bind(R.id.vpBrejas)            ViewPager viewPager;

    private List<BeerResponse> beers;
    private BeerResponse beer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breja);

        ButterKnife.bind(this);

        beer = (BeerResponse) getIntent().getSerializableExtra("Breja");

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

        viewPager.setAdapter(new BrejasRelacionadasAdapter(this, brejaRelacionadaView.getViewGroup()));


    }


    private void loadBeers(){

        BeerResponse beer1 = new BeerResponse("Guinness Draught", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "5%", "50");
        beers.add(beer1);
        BeerResponse beer2 = new BeerResponse("Guinness Draught light", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "6%", "60");
        beers.add(beer2);
        BeerResponse beer3 = new BeerResponse("Guinness Draught mediun", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "7%", "70");
        beers.add(beer3);
        BeerResponse beer4 = new BeerResponse("Guinness Draught light strong", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "8%", "80");
        beers.add(beer4);
        BeerResponse beer5 = new BeerResponse("Guinness Draught hardcore", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "9%", "90");
        beers.add(beer5);
        BeerResponse beer6 = new BeerResponse("Guinness Draught Badass", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "10%", "90");
        beers.add(beer6);
        BeerResponse beer7 = new BeerResponse("Guinness Draught punk", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "11%", "95");
        beers.add(beer7);
        BeerResponse beer8 = new BeerResponse("Guinness Draught X-X", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", "12%", "100");
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
                item.setIcon(getResources().getDrawable(R.drawable.ic_favorite_white_36dp));
            break;

            default:

                super.onOptionsItemSelected(item);
                break;

        }
        return true;
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
    }

    @Override
    public void navigateToNextScreen(Intent intent) {
        super.navigateToNextScreen(intent);
    }
}
