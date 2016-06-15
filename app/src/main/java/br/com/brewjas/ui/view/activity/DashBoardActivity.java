package br.com.brewjas.ui.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.brewjas.R;
import br.com.brewjas.ui.view.fragment.ListaCervejariasFragment;
import br.com.brewjas.ui.view.fragment.ListaCervejasFavoritasFragment;
import br.com.brewjas.ui.view.fragment.ListaCervejasFragment;
import br.com.brewjas.ui.view.fragment.ListaEstilosFragment;

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

        ListaCervejasFragment listaCervejasFragment = new ListaCervejasFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_dash, listaCervejasFragment);
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
                
                ListaCervejasFragment listaCervejasFragment = new ListaCervejasFragment();

                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_dash, listaCervejasFragment);
                fragmentTransaction.commit();

                break;

            case R.id.nav_favoritas:

                ListaCervejasFavoritasFragment listaCervejasFavoritasFragment = new ListaCervejasFavoritasFragment();

                android.support.v4.app.FragmentTransaction fragFavs = getSupportFragmentManager().beginTransaction();
                fragFavs.replace(R.id.frame_dash, listaCervejasFavoritasFragment);
                fragFavs.commit();

                break;

            case R.id.nav_cervejarias:

                ListaCervejariasFragment listaCervejariasFragment = new ListaCervejariasFragment();

                android.support.v4.app.FragmentTransaction fragCerve = getSupportFragmentManager().beginTransaction();
                fragCerve.replace(R.id.frame_dash, listaCervejariasFragment);
                fragCerve.commit();

                break;

            case R.id.nav_estilos:

                ListaEstilosFragment listaEstilosFragment = new ListaEstilosFragment();

                android.support.v4.app.FragmentTransaction fragEstilos = getSupportFragmentManager().beginTransaction();
                fragEstilos.replace(R.id.frame_dash, listaEstilosFragment);
                fragEstilos.commit();

                break;

            case R.id.nav_conta:

                navigateToNextScreen(new Intent(this, ContaActivity.class));

                break;

            case R.id.nav_logout:

                navigateToNextScreen(new Intent(this, LoginActivity.class));
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
