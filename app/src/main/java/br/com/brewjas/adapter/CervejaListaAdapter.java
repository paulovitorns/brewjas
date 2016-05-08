package br.com.brewjas.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.api.general.response.BeerResponse;

/**
 * Created by Paulo Vitor on 01/05/2016.
 */
public class CervejaListaAdapter extends RecyclerView.Adapter<CervejaListaAdapter.ViewHolder> {

    private int lastPosition = -1;
    private Context context;
    private List<BeerResponse> data;


    public CervejaListaAdapter(Context context, List<BeerResponse> lista){

        if(this.data == null)
            this.data = new ArrayList<>();

        this.context = context;
        this.data = lista;
    }

    @Override
    public CervejaListaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.item_breja, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final BeerResponse beer = data.get(position);

        if(beer != null){

            if(position % 2 == 0){
                holder.containerImage.setVisibility(View.GONE);
            }else{
                holder.containerImage.setVisibility(View.VISIBLE);
            }

            holder.nameBeer.setText(beer.getName());
            holder.nameBrewer.setText(beer.getCervejaria());
            holder.nameCountry.setText(beer.getPais());
            holder.typeBeer.setText(beer.getEstilo());
            holder.varAbv.setText("ABV "+beer.getAbv());
            holder.varIbu.setText("IBU "+beer.getIbu());

            holder.btnFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.btnFav.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_white_48dp));
                }
            });

            //animate(holder);
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

    public void updateList(List<BeerResponse> beers) {
        data = beers;
        notifyDataSetChanged();
    }

    public void insert(int position, BeerResponse beer) {

        Log.v("Insert "+beer.getName(), "All positions: "+(data.size()-1)+". New Position: "+position);

        data.add(position, beer);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(BeerResponse beer) {
        int position = data.indexOf(beer);
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void animate(RecyclerView.ViewHolder viewHolder){
        final Animation animation = AnimationUtils.loadAnimation(context, R.anim.bounce_interpolar);
        viewHolder.itemView.setAnimation(animation);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private CardView container;
        private LinearLayout containerImage;
        private ImageView imgBeer;
        private ImageButton btnFav;
        private TextView nameBeer;
        private TextView nameBrewer;
        private TextView nameCountry;
        private TextView typeBeer;
        private TextView varAbv;
        private TextView varIbu;

        public ViewHolder(View itemView) {
            super(itemView);

            container       = (CardView) itemView.findViewById(R.id.container);
            containerImage  = (LinearLayout) itemView.findViewById(R.id.containerImage);
            imgBeer         = (ImageView) itemView.findViewById(R.id.imgBeer);
            btnFav          = (ImageButton) itemView.findViewById(R.id.btnFav);
            nameBeer        = (TextView) itemView.findViewById(R.id.nameBeer);
            nameBrewer      = (TextView) itemView.findViewById(R.id.nameBrewer);
            nameCountry     = (TextView) itemView.findViewById(R.id.nameCountry);
            typeBeer        = (TextView) itemView.findViewById(R.id.typeBeer);
            varAbv          = (TextView) itemView.findViewById(R.id.varAbv);
            varIbu          = (TextView) itemView.findViewById(R.id.varIbu);

        }
    }

}
