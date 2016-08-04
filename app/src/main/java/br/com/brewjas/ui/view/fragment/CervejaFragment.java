package br.com.brewjas.ui.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.model.Beer;
import br.com.brewjas.ui.adapter.BeerAdapter;
import br.com.brewjas.util.UIDialogsFragments;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class CervejaFragment extends Fragment {

    private List<Beer> beers;
    private RecyclerView mRecyclerView;
    private UIDialogsFragments uiDialogs;

    public CervejaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_cervejas, container, false);

        uiDialogs = new UIDialogsFragments();
        uiDialogs.uiGetActivity(getActivity());

        beers = new ArrayList<>();

        mRecyclerView  = (RecyclerView) view.findViewById(R.id.listaBrejas);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
                BeerAdapter beerAdapter = (BeerAdapter) mRecyclerView.getAdapter();

                if(beers.size() == linearLayoutManager.findLastCompletelyVisibleItemPosition()+1){

                    uiDialogs.showLoading();

                    for(int i = 0; i < 2; i++){
                        Beer beer = new Beer( (beers.size()+1)+" Guinness Draught", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", beers.size()+"%", beers.size()+"0");
                        Log.v("Insert "+beer.getName(), beers.size()+"");

                        beerAdapter.insert(beers.size(), beer);
                    }

                    uiDialogs.loadingDialog.dismiss();
                }
            }
        });

        loadBeers();

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        return view;
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

        BeerAdapter mAdapter = new BeerAdapter(getContext(), beers);
        mRecyclerView.setAdapter(mAdapter);
    }


}
