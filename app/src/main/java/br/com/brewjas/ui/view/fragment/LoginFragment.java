package br.com.brewjas.ui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import br.com.brewjas.Brewjas;
import br.com.brewjas.R;
import br.com.brewjas.model.Cliente;
import br.com.brewjas.ui.presenter.LoginPresenter;
import br.com.brewjas.ui.presenter.impl.LoginPresenterImpl;
import br.com.brewjas.ui.view.LoginFragmentView;
import br.com.brewjas.ui.view.activity.DashBoardActivity;
import br.com.brewjas.ui.view.activity.LoginActivity;
import br.com.brewjas.ui.view.activity.RegisterActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - paulovitorns@gmail.com
 * Empresa : Brewjas app.
 */
public class LoginFragment extends Fragment implements LoginFragmentView {

    @Bind(R.id.contentLogo) LinearLayout contentLogo;
    @Bind(R.id.edtLogin) EditText edtLogin;
    @Bind(R.id.contentEdt) LinearLayout contentEdt;
    @Bind(R.id.contentLogin) LinearLayout contentLogin;
    @Bind(R.id.contentregister) LinearLayout contentregister;

    private LoginPresenter presenter = new LoginPresenterImpl(this);
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
        // Inflate the layout for this fragment
        View view           = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

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

                                    Cliente cliente = new Cliente();

                                    if( object.has("name") &&  !object.getString("name").equals("")){

                                        cliente.setNome(object.getString("name"));
                                    }

                                    if( object.has("email") &&  !object.getString("email").equals("")){

                                        cliente.setEmail(object.getString("email"));
                                    }

                                    if( object.has("gender") &&  !object.getString("gender").equals("")){

                                        String gender = object.getString("gender");
                                        int genero = ((gender.equalsIgnoreCase("male")) ? 1 : 2);
                                        cliente.setGenero(genero);
                                    }

                                    if( object.has("birthday") &&  !object.getString("birthday").equals("")){

                                        String birth = object.getString("birthday");
                                        cliente.setDatanascimento(birth);
                                    }

                                    navigateToNextScreenWithSerializedCliente(cliente);

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

        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email","public_profile"));
    }

    @Override
    public void setUsernameError(String title, String description) {

        ((LoginActivity)getActivity()).showDialog(title, description);
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

        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        ((LoginActivity)getActivity()).navigateToNextScreen(intent);
    }

    @Override
    public void setupActionBar() {

    }

    @Override
    public void navigateToNextScreenWithSerializedCliente(Cliente cliente) {
        Intent intent = new Intent(getActivity(), DashBoardActivity.class);
        intent.putExtra("Cliente", cliente);

        ((LoginActivity)getActivity()).navigateToNextScreen(intent);
        getActivity().finish();
    }

    @Override
    public void showDialog(String title, String description) {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
