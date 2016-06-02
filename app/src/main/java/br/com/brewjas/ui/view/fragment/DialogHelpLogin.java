package br.com.brewjas.ui.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import br.com.brewjas.R;
import br.com.brewjas.ui.view.BaseView;
import br.com.brewjas.ui.view.DialogHelpLoginView;
import br.com.brewjas.ui.view.activity.RegistroActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Paulo Vitor on 12/03/2016.
 */
public class DialogHelpLogin extends DialogFragment implements DialogHelpLoginView {

    public DialogHelpLogin(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.popup_login, container, false);
        // Inflate the layout to use as dialog or embedded fragment
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.btnRegister, R.id.txtTitleRegister, R.id.txtSubRegister})
    @Override
    public void navigateToNextScreen() {
        getActivity().startActivity(new Intent(getContext(), RegistroActivity.class));
    }

    @OnClick(R.id.containerHelp)
    @Override
    public void dismiss() {
        super.dismiss();
    }
}
