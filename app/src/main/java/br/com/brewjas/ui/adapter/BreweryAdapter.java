package br.com.brewjas.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.model.Brewery;
import br.com.brewjas.model.common.BreweryItem;
import br.com.brewjas.util.StringUtils;
import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BreweryAdapter extends RecyclerView.Adapter<BreweryAdapter.ViewHolder> {

    private Context             context;
    private List<BreweryItem>   data;

    public BreweryAdapter(Context context, List<BreweryItem> data) {

        if(this.data == null)
            this.data = new ArrayList<>();

        this.context    = context;
        this.data       = data;
    }

    @Override
    public BreweryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.item_cervejaria, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final BreweryItem brewery = data.get(position);

        if(brewery != null){

            Picasso.with(context)
                    .load(brewery.getImage())
                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(holder.imgBeer, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            Picasso.with(context)
                                    .load(brewery.getImage())
                                    .into(holder.imgBeer, new Callback() {
                                        @Override
                                        public void onSuccess() {

                                        }

                                        @Override
                                        public void onError() {
                                            Log.v("PICASSO_ERROR", "Couldn't not fetch image");
                                        }
                                    });
                        }
                    });

            holder.brewery.setText(brewery.getName());
            holder.country.setText(brewery.getCountry());

            holder.countBeer.setText(brewery.getBeerCount()+" cerveja(s)");

            animate(holder);
            holder.setParams(this.context, brewery);

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void insert(int position, BreweryItem brewery) {

        data.add(brewery);
        notifyItemInserted(position);
    }

    public void animate(RecyclerView.ViewHolder viewHolder){
        final Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        viewHolder.itemView.setAnimation(animation);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.cnImage)         LinearLayout    containerImage;
        @Bind(R.id.imBeer)          ImageView       imgBeer;
        @Bind(R.id.containerInfos)  LinearLayout    containerInfos;
        @Bind(R.id.txBrewery)       TextView        brewery;
        @Bind(R.id.txCountry)       TextView        country;
        @Bind(R.id.txCountBeer)     TextView        countBeer;

        private Context     context;
        private BreweryItem breweryObj;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        public void setParams(Context context, BreweryItem brewery){
            this.context    = context;
            this.breweryObj = brewery;
        }

        @Override
        public void onClick(View view) {
            //TODO: implements the click action here
        }
    }
}
