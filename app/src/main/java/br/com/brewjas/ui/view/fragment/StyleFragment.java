package br.com.brewjas.ui.view.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.model.Style;
import br.com.brewjas.ui.adapter.StyleAdapter;
import br.com.brewjas.util.UIDialogsFragments;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class StyleFragment extends BaseFragment {

    private List<Style> styles;
    private RecyclerView mRecyclerView;
    private UIDialogsFragments uiDialogs;

    public StyleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_cervejas, container, false);

        uiDialogs = new UIDialogsFragments();
        uiDialogs.uiGetActivity(getActivity());

        styles = new ArrayList<>();

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
                StyleAdapter beerAdapter = (StyleAdapter) mRecyclerView.getAdapter();

                if(styles.size() == linearLayoutManager.findLastCompletelyVisibleItemPosition()+1){

                    uiDialogs.showLoading();

                    for(int i = 0; i < 2; i++){
                        Style beer = new Style( (styles.size()+1)+"Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
                        Log.v("Insert "+beer.getName(), styles.size()+"");

                        beerAdapter.insert(styles.size(), beer);
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

        Style beer1 = new Style("Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
        styles.add(beer1);

        Style beer2 = new Style("2 Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
        styles.add(beer2);

        Style beer3 = new Style("3 Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
        styles.add(beer3);

        Style beer4 = new Style("4 Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
        styles.add(beer4);

        Style beer5 = new Style("5 Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
        styles.add(beer5);

        Style beer6 = new Style("6 Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
        styles.add(beer6);

        Style beer7 = new Style("7 Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
        styles.add(beer7);

        Style beer8 = new Style("8 Guinness Draught", "This light- to medium-bodied deep copper to brown ale is characterized by a slight to strong lactic sourness, and with Reds sometimes a balanced degree of acetic acid");
        styles.add(beer8);

        StyleAdapter mAdapter = new StyleAdapter(getContext(), styles);
        mRecyclerView.setAdapter(mAdapter);
    }


}
