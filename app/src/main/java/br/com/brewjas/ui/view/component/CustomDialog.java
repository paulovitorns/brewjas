package br.com.brewjas.ui.view.component;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import br.com.brewjas.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomDialog implements View.OnClickListener{

    @Bind(R.id.txtTitleDialog)  TextView    txtTitleDialog;
    @Bind(R.id.txtTextDialog)   TextView    txtTextDialog;
    @Bind(R.id.btnOk)           Button      btnOk;

    private Dialog  dialog;
    private Context context;
    private String  title;
    private String  msg;

    public CustomDialog(Context context, String title, String msg){
        this.context    = context;
        this.title      = title;
        this.msg        = msg;
    }

    public void show(){
        dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_fragment);
        dialog.setCancelable(false);

        ButterKnife.bind(this, dialog);

        txtTitleDialog.setText(title);
        txtTextDialog.setText(msg);

        btnOk.setOnClickListener(this);
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        dialog.cancel();
    }
}