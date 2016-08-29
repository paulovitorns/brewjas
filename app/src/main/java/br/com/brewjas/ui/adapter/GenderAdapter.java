package br.com.brewjas.ui.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.brewjas.R;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public class GenderAdapter extends BaseAdapter {

    private Context ctx;
    private String[] lista;

    public GenderAdapter(Context context, String[] lista){
        this.ctx = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return lista.length;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return lista[arg0];
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        TextView tv = new TextView(ctx);
        tv.setTextSize(20);
        tv.setText(lista[position]);
        int color = ctx.getResources().getColor(R.color.colorMarrom);
        tv.setTypeface(Typeface.DEFAULT);
        tv.setTextColor(color);
        tv.setPadding(32,20,32,20);

        return tv;
    }

}
