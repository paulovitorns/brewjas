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
import br.com.brewjas.api.general.response.BeerResponse;
import br.com.brewjas.ui.adapter.CervejaListaAdapter;
import br.com.brewjas.util.UIDialogsFragments;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public class ListaCervejasFavoritasFragment extends Fragment {

    private List<BeerResponse> beers;
    private RecyclerView mRecyclerView;
    private UIDialogsFragments uiDialogs;

    public ListaCervejasFavoritasFragment() {
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
                CervejaListaAdapter cervejaListaAdapter = (CervejaListaAdapter) mRecyclerView.getAdapter();

                if(beers.size() == linearLayoutManager.findLastCompletelyVisibleItemPosition()+1){

                    uiDialogs.showLoading();

                    for(int i = 0; i < 2; i++){
                        BeerResponse beer = new BeerResponse( (beers.size()+1)+" Guinness Draught", "Guinness", "Irlanda", "Classic Irish-Style Dry Stout", beers.size()+"%", beers.size()+"0");
                        Log.v("Insert "+beer.getName(), beers.size()+"");

                        cervejaListaAdapter.insert(beers.size(), beer);
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

        CervejaListaAdapter mAdapter = new CervejaListaAdapter(getContext(), beers);
        mRecyclerView.setAdapter(mAdapter);
    }


}
