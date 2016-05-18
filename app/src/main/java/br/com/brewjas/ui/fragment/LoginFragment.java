package br.com.brewjas.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import br.com.brewjas.R;
import br.com.brewjas.ui.activity.DashBoardActivity;
import br.com.brewjas.util.UIDialogsFragments;

public class LoginFragment extends Fragment {

    private LinearLayout contentLogo;
    private LinearLayout contentPanel;

    private EditText edtLogin;

    private ImageButton btnLogin;
    private Button btnFacebook;
    private Button btnRegistrar;
    private ImageButton btnLoginFb;

    private UIDialogsFragments uiDialogs;

    private LinearLayout contentEdt;
    private LinearLayout contentLogin;
    private LinearLayout contentregister;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view           = inflater.inflate(R.layout.fragment_login, container, false);

        uiDialogs           = new UIDialogsFragments();
        uiDialogs.uiGetActivity(getActivity());

        contentLogo         = (LinearLayout) view.findViewById(R.id.contentLogo);
        contentPanel        = (LinearLayout) view.findViewById(R.id.contentPanel);
        edtLogin            = (EditText) view.findViewById(R.id.edtLogin);
        btnLogin            = (ImageButton) view.findViewById(R.id.btnLogin);
        btnFacebook         = (Button) view.findViewById(R.id.btnFacebook);
        btnLoginFb          = (ImageButton) view.findViewById(R.id.btnLoginFb);
        btnRegistrar        = (Button) view.findViewById(R.id.btnRegistrar);

        contentEdt          = (LinearLayout) view.findViewById(R.id.contentEdt);
        contentLogin        = (LinearLayout) view.findViewById(R.id.contentLogin);
        contentregister     = (LinearLayout) view.findViewById(R.id.contentregister);

        loadElements();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHelp();
            }
        });

        btnLoginFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton();
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton();
            }
        });

        return view;
    }

    private void loginButton(){
        startActivity(new Intent(getActivity(), DashBoardActivity.class));
    }

    private void loadElements(){

        Animation showLogo  = AnimationUtils.loadAnimation(getContext(), R.anim.animacao_logo);

        showLogo.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Animation showLogin = AnimationUtils.loadAnimation(getContext(), R.anim.animacao_login);
                contentEdt.startAnimation(showLogin);

                Animation showFacebookBtn = AnimationUtils.loadAnimation(getContext(), R.anim.animacao_password);
                contentLogin.startAnimation(showFacebookBtn);

                Animation showHelp = AnimationUtils.loadAnimation(getContext(), R.anim.animacao_btn_help);
                contentregister.startAnimation(showHelp);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        contentLogo.startAnimation(showLogo);

    }

    public void showHelp(){
        uiDialogs.showHelpDialog();
    }

}
