package br.com.brewjas.ui.view.component;

import android.os.Bundle;
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
public class DialogFragment extends android.support.v4.app.DialogFragment implements DialogView {

    @Bind(R.id.txtTitleDialog)  TextView txtTitleDialog;
    @Bind(R.id.txtTextDialog)   TextView txtTextDialog;

    public DialogFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.popup_login, container, false);
        // Inflate the layout to use as dialog or embedded fragment
        ButterKnife.bind(this, view);

        return view;
    }

    private void loadData(){

    }

    @OnClick(R.id.btnOk)
    @Override
    public void dismiss() {
        super.dismiss();
    }
}
