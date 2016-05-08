package br.com.brewjas.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.adapter.CervejaListaAdapter;
import br.com.brewjas.api.general.response.BeerResponse;
import br.com.brewjas.services.scroll.EndlessScrollListener;
import br.com.brewjas.services.scroll.EndlessScrollView;
import br.com.brewjas.util.UIDialogsFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaCervejasFragment extends Fragment implements EndlessScrollListener {

    private List<BeerResponse> beers;

    private RecyclerView mRecyclerView;
    private CervejaListaAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.ItemAnimator itemAnimator;

    private EndlessScrollView scrollView;

    private UIDialogsFragments uiDialogs;

    public ListaCervejasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_cervejas, container, false);

        uiDialogs = new UIDialogsFragments();
        uiDialogs.uiGetActivity(getActivity());

        mRecyclerView  = (RecyclerView) view.findViewById(R.id.listaBrejas);
        mRecyclerView.setHasFixedSize(true);

        beers = new ArrayList<>();

        loadBeers();

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);

        scrollView = (EndlessScrollView) view.findViewById(R.id.scrollView);
        scrollView.setScrollViewListener(this);

        return view;
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

        mAdapter = new CervejaListaAdapter(getContext(), beers);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(itemAnimator);
    }

    private void addItem(){
        BeerResponse beer = new BeerResponse( beers.size()+" Guinness Draught", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", beers.size()+"%", beers.size()+"0");
        beers.add(beer);

        Log.v("Insert "+beer.getName(), beers.size()-1+"");

        //Update adapter.
        mAdapter.insert(beers.size()-1, beer);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onScrollChanged(EndlessScrollView scrollView, int x, int y, int oldx, int oldy) {
        View view = scrollView.getChildAt(scrollView.getChildCount() - 1);
        int distanceToEnd = (view.getBottom() - (scrollView.getHeight() + scrollView.getScrollY()));

        if ( ( distanceToEnd ) == 0) {

            uiDialogs.showLoading();
            Log.v("Distance to end", distanceToEnd+"");

            for (int i = 1; i < 2; i++){
                addItem();
            }

            uiDialogs.loadingDialog.dismiss();

        }
    }
}
