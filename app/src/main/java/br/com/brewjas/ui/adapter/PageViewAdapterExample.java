package br.com.brewjas.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public class PageViewAdapterExample extends PagerAdapter {

    private Context context;
    private int[] images;

    public PageViewAdapterExample(Context context, int[] images){

        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout li = new LinearLayout(context);
        li.setOrientation(LinearLayout.VERTICAL);
        li.setLayoutParams(lp);

        container.addView(li);

        ImageView img = new ImageView(context);
        img.setImageResource(images[position]);
        li.addView(img);

        TextView tv = new TextView(context);
        tv.setText("Position: "+position);
        li.addView(tv);

        Log.i("PAGERVIEW", "Bulid view: "+(position +1));

        return li;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);

        Log.i("PAGERVIEW", "Destroy view: "+(position +1));

        //super.destroyItem(container, position, view );
    }
}
