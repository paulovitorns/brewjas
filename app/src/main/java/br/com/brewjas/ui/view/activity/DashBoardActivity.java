package br.com.brewjas.ui.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import br.com.brewjas.R;
import br.com.brewjas.model.Client;
import br.com.brewjas.ui.view.fragment.CervejariaFragment;
import br.com.brewjas.ui.view.fragment.CervejaFavoritaFragment;
import br.com.brewjas.ui.view.fragment.CervejaFragment;
import br.com.brewjas.ui.view.fragment.EstiloFragment;
import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */

public class DashBoardActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)         Toolbar     toolbar;
    @Bind(R.id.HeaderTitle)     TextView    HeaderTitle;

    private int pressed = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);


        ButterKnife.bind(this);

        toolbar.setTitle("");

        HeaderTitle.setText(getResources().getString(R.string.title_beer));

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        CervejaFragment cervejaFragment = new CervejaFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_dash, cervejaFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            pressed = 1;
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(pressed == 2) {
                super.onBackPressed();
            }else {
                pressed++;
                Toast.makeText(DashBoardActivity.this, "Toque mais uma vez para sair", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.dash_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        pressed = 1;
        switch (id){
            case R.id.nav_lista_brewjas:
                
                CervejaFragment cervejaFragment = new CervejaFragment();

                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_dash, cervejaFragment);
                fragmentTransaction.commit();

                HeaderTitle.setText(getResources().getString(R.string.title_beer));

                break;

            case R.id.nav_favoritas:

                CervejaFavoritaFragment cervejaFavoritaFragment = new CervejaFavoritaFragment();

                android.support.v4.app.FragmentTransaction fragFavs = getSupportFragmentManager().beginTransaction();
                fragFavs.replace(R.id.frame_dash, cervejaFavoritaFragment);
                fragFavs.commit();

                HeaderTitle.setText(getResources().getString(R.string.title_fav));

                break;

            case R.id.nav_cervejarias:

                CervejariaFragment cervejariaFragment = new CervejariaFragment();

                android.support.v4.app.FragmentTransaction fragCerve = getSupportFragmentManager().beginTransaction();
                fragCerve.replace(R.id.frame_dash, cervejariaFragment);
                fragCerve.commit();

                HeaderTitle.setText(getResources().getString(R.string.title_brew));

                break;

            case R.id.nav_estilos:

                EstiloFragment estiloFragment = new EstiloFragment();

                android.support.v4.app.FragmentTransaction fragEstilos = getSupportFragmentManager().beginTransaction();
                fragEstilos.replace(R.id.frame_dash, estiloFragment);
                fragEstilos.commit();

                HeaderTitle.setText(getResources().getString(R.string.title_sty));

                break;

            case R.id.nav_conta:

                startActivity(new Intent(this, ContaActivity.class));
                break;

            case R.id.nav_logout:

                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;

            default:

                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
