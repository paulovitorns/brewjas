package br.com.brewjas.ui.view.component;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.brewjas.R;
import br.com.brewjas.ui.view.DialogView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Paulo Vitor on 12/03/2016.
 */
public class DialogAlert extends DialogFragment implements DialogView {

    @Bind(R.id.txtTitleDialog)  TextView txtTitleDialog;
    @Bind(R.id.txtTextDialog)   TextView txtTextDialog;

    public DialogAlert(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.dialog_fragment, container, false);
        // Inflate the layout to use as dialog or embedded fragment
        ButterKnife.bind(this, view);

        loadData();

        return view;
    }

    private void loadData(){

        String titulo   = getArguments().getString("title");
        String conteudo = getArguments().getString("description");

        txtTitleDialog.setText(titulo);
        txtTextDialog.setText(conteudo);
    }

    @OnClick({R.id.btnOk, R.id.containerHelp})
    @Override
    public void dismiss() {
        super.dismiss();
    }
}
