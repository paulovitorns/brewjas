package br.com.brewjas.ui.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.model.ApiError;
import br.com.brewjas.model.Client;
import br.com.brewjas.ui.presenter.LoginPresenter;
import br.com.brewjas.ui.presenter.impl.LoginPresenterImpl;
import br.com.brewjas.ui.view.LoginFragmentView;
import br.com.brewjas.ui.view.activity.BaseActivity;
import br.com.brewjas.ui.view.activity.DashBoardActivity;
import br.com.brewjas.ui.view.activity.RegisterActivity;
import br.com.brewjas.ui.view.component.CustomDialog;
import br.com.brewjas.util.SharedPreferencesUtil;
import br.com.brewjas.util.StringUtils;
import br.com.brewjas.util.UtilNetwork;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */

public class LoginFragment extends BaseFragment implements LoginFragmentView {

    @Bind(R.id.contentLogo)     LinearLayout    contentLogo;
    @Bind(R.id.edtLogin)        EditText        edtLogin;
    @Bind(R.id.contentEdt)      LinearLayout    contentEdt;
    @Bind(R.id.contentLogin)    LinearLayout    contentLogin;
    @Bind(R.id.contentregister) LinearLayout    contentregister;

    private LoginPresenter  presenter;
    private CallbackManager mCallbackManager;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCallbackManager = CallbackManager.Factory.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view           = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        presenter = new LoginPresenterImpl(view, this);

        loadElementsWithAnimation();

        LoginManager.getInstance().registerCallback(
                mCallbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback(){

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {

                                try {

                                    Log.d("DATA_FACEBOOK", object.toString());

                                    Client client = new Client();

                                    client.setFacebookId(object.getString("id"));

                                    if( object.has("name") &&  !object.getString("name").equals("")){

                                        client.setNome(object.getString("name"));
                                    }

                                    if( object.has("email") &&  !object.getString("email").equals("")){

                                        client.setEmail(object.getString("email"));
                                    }

                                    if( object.has("gender") &&  !object.getString("gender").equals("")){

                                        String gender = object.getString("gender");
                                        int genero = ((gender.equalsIgnoreCase("male")) ? 1 : 2);
                                        client.setGenero(genero);
                                    }

                                    if( object.has("birthday") &&  !object.getString("birthday").equals("")){

                                        String birth = object.getString("birthday");
                                        client.setDataNascimento(StringUtils.parseStringFbToDate(birth));
                                    }

                                    Log.d("CLIENT_FB", new Gson().toJson(client, Client.class));

                                    presenter.registerByLogin(client);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });

                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id,name,email,gender,birthday");
                        request.setParameters(parameters);
                        request.executeAsync();
                        Log.d("BUNDLE_PARAMS", parameters.toString());

                    }

                    @Override
                    public void onCancel() {

                        setUsernameError("Oops!", Brewjas.getContext().getString(R.string.err_login_facebook_cancel));
                    }

                    @Override
                    public void onError(FacebookException error) {

                        setUsernameError("Erro interno!", error.getMessage());
                    }
                }
        );

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.btnLogin)
    public void loginButton(){
        presenter.onSubmitPressed(edtLogin.getText().toString());
    }

    @OnClick({R.id.btnFacebook, R.id.btnLoginFb})
    public void loginWithfacebook(){
        if(UtilNetwork.isNetworkAvailable()){
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","public_profile", "user_birthday"));
        }else{
            UtilNetwork.showNetworkInfo(this.getView(), this.getContext(), new ApiError(0));
        }
    }

    @Override
    public void setUsernameError(String title, String description) {
        showDialog(title, description);
    }

    public void loadElementsWithAnimation() {

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

    @OnClick(R.id.btnRegistrar)
    public void register() {

        if(UtilNetwork.isNetworkAvailable()){
            Intent intent = new Intent(getActivity(), RegisterActivity.class);
            getActivity().startActivity(intent);
        }else{
            UtilNetwork.showNetworkInfo(this.getView(), this.getContext(), new ApiError(0));
        }

    }

    @Override
    public void setupActionBar() {

    }

    @Override
    public void showDialog(String title, String description) {

        try{
            new CustomDialog(getContext(), title, description).show();
        } catch (Exception e){}
    }

    @Override
    public void navigateToNextScreenWithSerializedCliente(Client client) {

        SharedPreferencesUtil.saveSession(client);

        Intent intent = new Intent(getActivity(), DashBoardActivity.class);
        getActivity().startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void showLoading() {
        try{
            ((BaseActivity) this.getActivity()).showLoading();
        }catch (Exception e) {

        }
    }

    @Override
    public void hideLoading() {
        try{
            ((BaseActivity) this.getActivity()).hideLoading();
        }catch (Exception e) {

        }
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

}
