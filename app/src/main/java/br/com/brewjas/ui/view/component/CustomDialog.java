package br.com.brewjas.ui.view.component;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.brewjas.R;
import butterknife.Bind;
import butterknife.ButterKnife;

//how to use
//new CustomDialog(apiError, this).show();

public class CustomDialog implements View.OnClickListener{

    private Dialog dialog;
    private Context context;

    public CustomDialog(Context context){
        this.context = context;
    }

    public void show(){
        dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //dialog.setContentView(R.layout.dialog_error);
        dialog.setCancelable(false);

        ButterKnife.bind(this, dialog);

        //btDialog.setOnClickListener(this);
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        dialog.cancel();
    }
}