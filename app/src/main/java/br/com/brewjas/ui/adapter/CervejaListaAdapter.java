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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.api.general.response.BeerResponse;
import br.com.brewjas.ui.view.activity.BrejaActivity;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Paulo Vitor on 01/05/2016.
 */
public class CervejaListaAdapter extends RecyclerView.Adapter<CervejaListaAdapter.ViewHolder> {

    private static Context context;
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
    public void onBindViewHolder(final CervejaListaAdapter.ViewHolder holder, int position) {
        final BeerResponse beer = data.get(position);

        if(beer != null){

            if(position % 2 == 0){

                LinearLayout.LayoutParams adjust = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 2.9f);
                float margin = Brewjas.getContext().getResources().getDimension(R.dimen.card_horizontal_margin_small);
                adjust.setMarginEnd((int) margin);
                holder.containerInfos.setLayoutParams(adjust);
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
                    holder.btnFav.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_favorite_white_36dp));
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

    public void insert(int position, BeerResponse beer) {

        data.add(beer);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(BeerResponse beer) {
        int position = data.indexOf(beer);
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void animate(RecyclerView.ViewHolder viewHolder){
        final Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        viewHolder.itemView.setAnimation(animation);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private LinearLayout containerImage;
        private LinearLayout containerInfos;
        private CircleImageView imgBeer;
        private ImageButton btnFav;
        private TextView nameBeer;
        private TextView nameBrewer;
        private TextView nameCountry;
        private TextView typeBeer;
        private TextView varAbv;
        private TextView varIbu;

        public ViewHolder(View itemView) {
            super(itemView);

            containerImage  = (LinearLayout) itemView.findViewById(R.id.containerImage);
            containerInfos  = (LinearLayout) itemView.findViewById(R.id.containerInfos);
            imgBeer         = (CircleImageView) itemView.findViewById(R.id.imgBeer);
            btnFav          = (ImageButton) itemView.findViewById(R.id.btnFav);
            nameBeer        = (TextView) itemView.findViewById(R.id.nameBeer);
            nameBrewer      = (TextView) itemView.findViewById(R.id.nameBrewer);
            nameCountry     = (TextView) itemView.findViewById(R.id.nameCountry);
            typeBeer        = (TextView) itemView.findViewById(R.id.typeBeer);
            varAbv          = (TextView) itemView.findViewById(R.id.varAbv);
            varIbu          = (TextView) itemView.findViewById(R.id.varIbu);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            goToCoupon();
        }

        public void goToCoupon(){
            Intent intent = new Intent(context, BrejaActivity.class);
            context.startActivity(intent);
        }
    }

}
