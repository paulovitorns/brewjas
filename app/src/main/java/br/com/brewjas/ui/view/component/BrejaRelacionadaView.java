package br.com.brewjas.ui.view.component;

import android.content.Context;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.api.general.response.BeerResponse;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by PauloSales on 09/06/2016.
 */
public class BrejaRelacionadaView {

    private List<ViewGroup> views;

    public BrejaRelacionadaView(Context context, List<BeerResponse> beers){
        LayoutInflater li = LayoutInflater.from(context);
        GridLayout gridLayout = (GridLayout) li.inflate(R.layout.view_breja_relacionada_grid, null);
        this.views = new ArrayList<>();

        for (BeerResponse beer : beers){

            //Faço a validação se o grid já possue 2 itens
            //para inserção e instanciar uma nova para inserir novos elementos

            if(gridLayout.getChildCount() == 2){
                views.add(gridLayout);
                gridLayout = (GridLayout) li.inflate(R.layout.view_breja_relacionada_grid, null);
            }

            View brejaView              = li.inflate(R.layout.item_breja_relacionado, gridLayout, false);

            CircleImageView imgBreja    = (CircleImageView) brejaView.findViewById(R.id.imgBeer);
            TextView nameBeer           = (TextView) brejaView.findViewById(R.id.nameBeer);
            TextView nameBrewer         = (TextView) brejaView.findViewById(R.id.nameBrewer);
            TextView typeBeer           = (TextView) brejaView.findViewById(R.id.typeBeer);

            nameBeer.setText(beer.getName());
            nameBrewer.setText(beer.getCervejaria());
            typeBeer.setText(beer.getEstilo());

            gridLayout.addView(brejaView);

            //views.add(gridLayout);
        }

    }

    public List<ViewGroup> getViewGroup(){
        return views;
    }

}
