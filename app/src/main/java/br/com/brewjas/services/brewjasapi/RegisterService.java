package br.com.brewjas.services.brewjasapi;

import br.com.brewjas.api.general.request.Cliente;
import br.com.brewjas.common.OnListenerGeneral;

/**
 * Created by Paulo Vitor on 06/06/2016.
 */
public interface RegisterService {

    void register(Cliente cliente, OnListenerGeneral listener);

    void checkEmail(String email, OnListenerGeneral listener);
}
