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
import br.com.brewjas.model.Brewery;
import br.com.brewjas.model.common.Image;
import br.com.brewjas.ui.adapter.BreweryAdapter;
import br.com.brewjas.util.UIDialogsFragments;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class CervejariaFragment extends Fragment {

    private List<Brewery> breweries;
    private RecyclerView mRecyclerView;
    private UIDialogsFragments uiDialogs;

    public CervejariaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_cervejas, container, false);

        uiDialogs = new UIDialogsFragments();
        uiDialogs.uiGetActivity(getActivity());

        breweries = new ArrayList<>();

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
                BreweryAdapter cervejariaAdapter        = (BreweryAdapter) mRecyclerView.getAdapter();

                if(breweries.size() == linearLayoutManager.findLastCompletelyVisibleItemPosition()+1){

                    uiDialogs.showLoading();

                    for(int i = 0; i < 2; i++){
                        Brewery brewery = new Brewery("KR4X6i", "The fact that D.C. has become a world-class beer town", "DC Brau Brewing "+(breweries.size()+1), new Image(null, null, null), "2009", "http://www.dcbrau.com");
                        Log.v("Insert "+brewery.getName(), breweries.size()+"");

                        cervejariaAdapter.insert(breweries.size(), brewery);
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

        Brewery brewery = new Brewery("KR4X6i", "The fact that D.C. has become a world-class beer town", "DC Brau Brewing", new Image(null, null, null), "2009", "http://www.dcbrau.com");
        breweries.add(brewery);

        Brewery brewery1 = new Brewery("KR4X6i", "The fact that D.C. has become a world-class beer town", "DC Brau Brewing 2", new Image(null, null, null), "2010", "http://www.dcbrau.com");
        breweries.add(brewery1);

        Brewery brewery2 = new Brewery("KR4X6i", "The fact that D.C. has become a world-class beer town", "DC Brau Brewing 3", new Image(null, null, null), "2011", "http://www.dcbrau.com");
        breweries.add(brewery2);

        Brewery brewery3 = new Brewery("KR4X6i", "The fact that D.C. has become a world-class beer town", "DC Brau Brewing 4", new Image(null, null, null), "2012", "http://www.dcbrau.com");
        breweries.add(brewery3);

        Brewery brewery4 = new Brewery("KR4X6i", "The fact that D.C. has become a world-class beer town", "DC Brau Brewing 5", new Image(null, null, null), "2013", "http://www.dcbrau.com");
        breweries.add(brewery4);

        Brewery brewery5 = new Brewery("KR4X6i", "The fact that D.C. has become a world-class beer town", "DC Brau Brewing 6", new Image(null, null, null), "2014", "http://www.dcbrau.com");
        breweries.add(brewery5);

        BreweryAdapter mAdapter = new BreweryAdapter(getContext(), breweries);
        mRecyclerView.setAdapter(mAdapter);

    }


}
