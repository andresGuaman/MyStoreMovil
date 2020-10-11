package com.agmr.mystore.service;

import com.agmr.mystore.modelo.cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import static com.agmr.mystore.service.PostServiceCategoria.API_ROUTE;

public interface PostServiceCliente {
    //Cliente
    //GET
    String API_ROUTE3="/api/v1/Cliente";
    /*   @GET(API_ROUTE3+"/Cliente")
       Call<List<cliente>> getCliente();
       //GET BY ID
       @GET(API_ROUTE+"/Cliente/{cli_id}")
       Call<List<cliente>>getIdCliente(@Path("cli_id") int id);
       //POST
      */ // @FormUrlEncoded
    @POST(API_ROUTE3)
    Call<cliente>addCliente(@Body cliente cliente);
    //UPDATE
   /* @PUT(API_ROUTE+"/Cliente/{cli_id}")
    Call<cliente> updateCliente(@Path("cli_id") int id, @Body cliente cliente);
    //DELETE
    @DELETE(API_ROUTE+"/Cliente/{cli_id}")
    Call<cliente>deleCliente(@Path("cli_id") int id);
*/

}
