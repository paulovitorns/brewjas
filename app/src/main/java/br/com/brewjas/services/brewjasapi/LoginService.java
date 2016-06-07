package br.com.brewjas.services.brewjasapi;

import br.com.brewjas.common.OnListenerGeneral;

/**
 * Created by PauloSales on 02/06/2016.
 */
public interface LoginService {

    void login(String email, OnListenerGeneral listener);

}
