package br.com.brewjas.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brewjas.R;
import br.com.brewjas.model.Style;
import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class StyleAdapter extends RecyclerView.Adapter<StyleAdapter.ViewHolder> {

    private Context     context;
    private List<Style> data;

    public StyleAdapter(Context context, List<Style> data) {

        if(this.data == null)
            this.data = new ArrayList<>();

        this.context    = context;
        this.data       = data;
    }

    @Override
    public StyleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(context).inflate(R.layout.item_estilo, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Style style = data.get(position);

        if(style != null){

            holder.txStyle.setText(style.getName());
            holder.description.setText(style.getDescription());

            holder.setParams(this.context, style);
            animate(holder);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void insert(int position, Style style) {

        data.add(style);
        notifyItemInserted(position);
    }

    public void animate(RecyclerView.ViewHolder viewHolder){
        final Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        viewHolder.itemView.setAnimation(animation);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.txStyle)     TextView    txStyle;
        @Bind(R.id.txShortDesc) TextView    description;

        private Context context;
        private Style   style;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        public void setParams(Context context, Style style){
            this.context    = context;
            this.style      = style;
        }

        @Override
        public void onClick(View view) {
            //TODO: implements the click action here
        }
    }
}
