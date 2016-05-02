package br.com.brewjas.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.brewjas.R;

/**
 * Created by Roque on 18/10/2015.
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
        tv.setTextSize(18);
        tv.setText(lista[position]);
        int color = ctx.getResources().getColor(R.color.colorMarrom);
        tv.setTextColor(color);
        tv.setPadding(20,20,20,20);

        return tv;
    }

}
