package br.com.brewjas.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.model.Beer;
import br.com.brewjas.model.Brewery;
import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BreweryAdapter extends RecyclerView.Adapter<BreweryAdapter.ViewHolder> {

    private Context         context;
    private List<Brewery>   data;

    public BreweryAdapter(Context context, List<Brewery> data) {

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
    public void onBindViewHolder(ViewHolder holder, int position) {
        Brewery brewery = data.get(position);

        if(brewery != null){

            if(position % 2 == 0){

                LinearLayout.LayoutParams adjust = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 2.0f);
                holder.containerInfos.setLayoutParams(adjust);
                holder.containerImage.setVisibility(View.GONE);
            }else{
                LinearLayout.LayoutParams adjust = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.4f);
                holder.containerInfos.setLayoutParams(adjust);
                holder.containerImage.setVisibility(View.VISIBLE);
            }

            holder.brewery.setText(brewery.getName());
            holder.country.setText("Irlanda");

            String lblCountBeers = holder.countBeer.getText().toString();
            lblCountBeers.replace("{var}", 10+"");
            holder.countBeer.setText(lblCountBeers);

            String lblCountStyles = holder.countStyles.getText().toString();
            lblCountStyles.replace("{var}", 10+"");
            holder.countStyles.setText(lblCountStyles);

            animate(holder);
            holder.setParams(this.context, brewery);

        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void insert(int position, Brewery brewery) {

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
        @Bind(R.id.txCountStyles)   TextView        countStyles;

        private Context context;
        private Brewery breweryObj;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        public void setParams(Context context, Brewery brewery){
            this.context    = context;
            this.breweryObj = brewery;
        }

        @Override
        public void onClick(View view) {
            //TODO: implements the click action here
        }
    }
}
