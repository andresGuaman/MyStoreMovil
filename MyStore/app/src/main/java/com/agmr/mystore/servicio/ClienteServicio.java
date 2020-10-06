package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Cliente;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ClienteServicio {
    //Cliente
    //GET
    String API_ROUTE3 = "/api/v1/Cliente";

    /*   @GET(API_ROUTE3+"/Cliente")
       Call<List<cliente>> getCliente();
       //GET BY ID
       @GET(API_ROUTE+"/Cliente/{cli_id}")
       Call<List<cliente>>getIdCliente(@Path("cli_id") int id);
       //POST
      */ // @FormUrlEncoded
    @POST(API_ROUTE3)
    Call<Cliente> addCliente(@Body Cliente cliente);
    //UPDATE
   /* @PUT(API_ROUTE+"/Cliente/{cli_id}")
    Call<cliente> updateCliente(@Path("cli_id") int id, @Body cliente cliente);
    //DELETE
    @DELETE(API_ROUTE+"/Cliente/{cli_id}")
    Call<cliente>deleCliente(@Path("cli_id") int id);
*/

}
