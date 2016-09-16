package br.com.brewjas.ui.view.component.scroll;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {

    public static String TAG        = EndlessRecyclerOnScrollListener.class.getSimpleName();

    private int previousTotal       = 0; // The total number of items in the dataset after the last load
    private boolean loading         = true; // True if we are still waiting for the last set of data to load.
    private int minimumItens        = 15; // The minimum amount of items to have below your current scroll position before loading more.
    private int visibleThreshold    = 3; // The minimum amount of items to have below your current scroll position before loading more.
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private int current_page = 1;

    private LinearLayoutManager layoutManager;

    public EndlessRecyclerOnScrollListener(LinearLayoutManager layoutManager){
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount    = recyclerView.getChildCount();
        totalItemCount      = layoutManager.getItemCount();
        firstVisibleItem    = layoutManager.findFirstVisibleItemPosition();

        if(totalItemCount >= minimumItens){

            if(loading){
                if(totalItemCount > previousTotal){
                    loading = false;
                    previousTotal = totalItemCount;
                }
            }

            if(!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold) ){

                // End has been reached

                // Do something

                current_page ++;
                onLoadMore();

                loading = true;
            }

        }


    }

    public abstract void onLoadMore();

}
