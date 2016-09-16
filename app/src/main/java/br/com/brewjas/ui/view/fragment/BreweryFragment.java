package br.com.brewjas.ui.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.brewjas.R;
import br.com.brewjas.ui.presenter.BreweriesPresenter;
import br.com.brewjas.ui.presenter.impl.BreweriesPresenterImpl;
import br.com.brewjas.ui.view.BreweryView;
import br.com.brewjas.ui.view.activity.BaseActivity;
import br.com.brewjas.ui.view.component.scroll.EndlessRecyclerOnScrollListener;
import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BreweryFragment extends BaseFragment implements BreweryView {


    @Bind(R.id.listaBrejas) RecyclerView mRecyclerView;
    private BreweriesPresenter presenter;
    LinearLayoutManager mLayoutManager;

    public BreweryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_cervejas, container, false);

        ButterKnife.bind(this, view);

        presenter = new BreweriesPresenterImpl(view, this);

        presenter.searchBreweries("all");

        mRecyclerView.setOnScrollListener(new EndlessRecyclerOnScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore() {
                presenter.loadMoreBreweries(mRecyclerView);
            }
        });


        return view;
    }

    @Override
    public void loadBreweriesAdapter() {

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void showEmptyState() {

    }

    @Override
    public void showCardsBreweries(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        try{
            ((BaseActivity) this.getActivity()).showLoading();
        }catch (Exception e) {

        }
    }

    @Override
    public void hideLoading() {
        try{
            ((BaseActivity) this.getActivity()).hideLoading();
        }catch (Exception e) {

        }
    }

    @Override
    public void showNetworkInfo() {
        super.showNetworkInfo();
    }
}
