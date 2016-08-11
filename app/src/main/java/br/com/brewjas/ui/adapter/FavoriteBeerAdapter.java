package br.com.brewjas.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.model.Beer;
import br.com.brewjas.ui.view.activity.BrejaActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class FavoriteBeerAdapter extends RecyclerView.Adapter<FavoriteBeerAdapter.ViewHolder> {

    private static Context context;
    private static List<Beer> data;


    public FavoriteBeerAdapter(Context context, List<Beer> lista){

        if(this.data == null)
            this.data = new ArrayList<>();

        this.context = context;
        this.data = lista;
    }

    @Override
    public FavoriteBeerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.item_breja, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(final FavoriteBeerAdapter.ViewHolder holder, int position) {
        final Beer beer = data.get(position);

        if(beer != null){

            holder.btFav.setImageResource(R.drawable.ic_favorite_white_36dp);
            holder.btFavTw.setImageResource(R.drawable.ic_favorite_white_36dp);

            if(position % 2 == 0){

                LinearLayout.LayoutParams adjust = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 2.0f);
                holder.cn.setLayoutParams(adjust);
                holder.cnImg.setVisibility(View.GONE);
                holder.cnImgFav.setVisibility(View.VISIBLE);
            }else{

                LinearLayout.LayoutParams adjust = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.2f);
                holder.cn.setLayoutParams(adjust);
                holder.cnImg.setVisibility(View.VISIBLE);
                holder.cnImgFav.setVisibility(View.GONE);
            }

            holder.beer.setText(beer.getName());
            holder.brewery.setText(beer.getCervejaria());
            holder.country.setText(beer.getPais());
            holder.style.setText(beer.getEstilo());
            holder.abv.setText("ABV "+beer.getAbv());
            holder.ibu.setText("IBU "+beer.getIbu());

            holder.btFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(beer, holder);
                }
            });

            holder.btFavTw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    remove(beer, holder);
                }
            });

            animate(holder);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void insert(int position, Beer beer) {

        data.add(beer);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Beer beer, RecyclerView.ViewHolder viewHolder) {
        animateRemove(viewHolder);
        int position = data.indexOf(beer);
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void animateRemove(RecyclerView.ViewHolder viewHolder){
        final Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
        viewHolder.itemView.setAnimation(animation);
    }

    public void animate(RecyclerView.ViewHolder viewHolder){
        final Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        viewHolder.itemView.setAnimation(animation);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.content)         LinearLayout    cn;
        @Bind(R.id.containerImage)  RelativeLayout  cnImg;
        @Bind(R.id.imBeer)          ImageView       imBeer;
        @Bind(R.id.txBeer)          TextView        beer;
        @Bind(R.id.txBrewery)       TextView        brewery;
        @Bind(R.id.txCountry)       TextView        country;
        @Bind(R.id.txStyle)         TextView        style;
        @Bind(R.id.txAbv)           TextView        abv;
        @Bind(R.id.txIbu)           TextView        ibu;
        @Bind(R.id.cnImgFav)        RelativeLayout  cnImgFav;
        @Bind(R.id.btFav)           ImageButton     btFav;
        @Bind(R.id.btFavTw)         ImageButton     btFavTw;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Beer beer = data.get(getAdapterPosition());

            goToCoupon(beer);
        }

        public void goToCoupon(Beer beer){
            Intent intent = new Intent(context, BrejaActivity.class);
            intent.putExtra("Breja", beer);
            context.startActivity(intent);
        }
    }

}
