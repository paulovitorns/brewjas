package br.com.brewjas.business.api;

import br.com.brewjas.business.api.vo.response.ClientFullResponseVO;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */
public interface AppBrewjas {

    @GET("api/client/login/{data}")
    Call<ClientFullResponseVO> login(@Path("data") String email);

    @GET("api/client/register/{data}")
    Call<ClientFullResponseVO> register(@Path("data") String data);

    @GET("api/client/update/{data}")
    Call<ClientFullResponseVO> update(@Path("data") String data);

}
