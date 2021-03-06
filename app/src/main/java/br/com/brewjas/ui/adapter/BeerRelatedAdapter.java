package br.com.brewjas.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class BeerRelatedAdapter extends PagerAdapter {

        private Context context;
        private List<ViewGroup> views;

        public BeerRelatedAdapter(Context context, List<ViewGroup> viewGroups){
            this.context = context;
            this.views = viewGroups;
        }

        @Override
        public int getCount() {
            return this.views.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(views.get(position));

            this.clickListener(views.get(position), position);

            return views.get(position);
        }

        private void clickListener(final ViewGroup viewGroup, final int position){
            viewGroup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ItemClicked", ""+position);
                }
            });
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object view) {
            container.removeView((View) view);
        }

}
