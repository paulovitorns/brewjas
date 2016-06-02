package br.com.brewjas.common;

import br.com.brewjas.api.general.request.Cliente;

/**
 * Created by PauloSales on 02/06/2016.
 */
public interface OnLoginListenerFinished {

    void onEmailErro(String erro);

    void onSuccess(Cliente cliente);

}
