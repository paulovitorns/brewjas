package br.com.brewjas.common;

import br.com.brewjas.api.general.request.Cliente;

/**
 * Created by Paulo Vitor on 06/06/2016.
 */
public interface OnListenerGeneral {


    void onError(String error);

    void onSuccess(Cliente cliente);


}
