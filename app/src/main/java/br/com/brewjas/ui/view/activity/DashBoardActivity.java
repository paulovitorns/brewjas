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

import br.com.brewjas.R;
import br.com.brewjas.model.Client;
import br.com.brewjas.ui.view.fragment.CervejariaFragment;
import br.com.brewjas.ui.view.fragment.CervejaFavoritaFragment;
import br.com.brewjas.ui.view.fragment.CervejaFragment;
import br.com.brewjas.ui.view.fragment.EstiloFragment;
/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class DashBoardActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private TextView HeaderTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        HeaderTitle = (TextView) findViewById(R.id.HeaderTitle);
        toolbar.setTitle("");

        HeaderTitle.setText(getResources().getString(R.string.app_name));

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
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        //getMenuInflater().inflate(R.menu.dash_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_lista_brewjas:
                
                CervejaFragment cervejaFragment = new CervejaFragment();

                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_dash, cervejaFragment);
                fragmentTransaction.commit();

                break;

            case R.id.nav_favoritas:

                CervejaFavoritaFragment cervejaFavoritaFragment = new CervejaFavoritaFragment();

                android.support.v4.app.FragmentTransaction fragFavs = getSupportFragmentManager().beginTransaction();
                fragFavs.replace(R.id.frame_dash, cervejaFavoritaFragment);
                fragFavs.commit();

                break;

            case R.id.nav_cervejarias:

                CervejariaFragment cervejariaFragment = new CervejariaFragment();

                android.support.v4.app.FragmentTransaction fragCerve = getSupportFragmentManager().beginTransaction();
                fragCerve.replace(R.id.frame_dash, cervejariaFragment);
                fragCerve.commit();

                break;

            case R.id.nav_estilos:

                EstiloFragment estiloFragment = new EstiloFragment();

                android.support.v4.app.FragmentTransaction fragEstilos = getSupportFragmentManager().beginTransaction();
                fragEstilos.replace(R.id.frame_dash, estiloFragment);
                fragEstilos.commit();

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
