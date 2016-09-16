package br.com.brewjas.ui.view.fragment;

/*
 * © Copyright 2015 Rede S.A.
 * Autor : Ismael Di Vita Costa - ismael.costa@userede.com.br
 * Empresa : Rede S.A.
 */

import android.support.v4.app.Fragment;

import br.com.brewjas.model.ApiError;
import br.com.brewjas.util.UtilNetwork;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onResume() {
        super.onResume();

        showNetworkInfo();
    }


    public void showNetworkInfo(){
        if(!UtilNetwork.isNetworkAvailable()){
            UtilNetwork.showNetworkInfo(getView(), getActivity(), new ApiError(0));
        }

    }

}
