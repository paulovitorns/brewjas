package br.com.brewjas.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.adapter.CervejaListaAdapter;
import br.com.brewjas.api.general.response.BeerResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaCervejasFragment extends Fragment {

    private List<BeerResponse> beers;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ListaCervejasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_cervejas, container, false);

        mRecyclerView  = (RecyclerView) view.findViewById(R.id.listaBrejas);
        mRecyclerView.setHasFixedSize(true);

        beers = new ArrayList<>();

        loadBeers();

        mLayoutManager = new LinearLayoutManager(getActivity());
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

        mAdapter = new CervejaListaAdapter(getContext(), beers);
        mRecyclerView.setAdapter(mAdapter);
    }

}
