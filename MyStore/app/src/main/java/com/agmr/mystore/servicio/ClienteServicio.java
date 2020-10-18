package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Cliente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ClienteServicio {

    String API_ROUTE = "/Cliente";

    @GET(API_ROUTE)
    Call<List<Cliente>> getClientes();

    //GET BY ID
    @GET(API_ROUTE + "/{cli_id}")
    Call<List<Cliente>> getClienteById(@Path("cli_id") int id);

    //GET BY PERSONA ID
    @GET(API_ROUTE + "/per_id/{per_id}")
    Call<Cliente> getClienteByPerId(@Path("per_id") long per_id);

    //GET BY USERNAME AND PASSWORD
    @GET(API_ROUTE + "/{cli_usuario}/{cli_password}")
    Call<Cliente> getClienteByUserPass(@Path("cli_usuario") String cli_usuario, @Path("cli_password") String cli_password);

    //POST
    @POST(API_ROUTE)
    Call<Cliente> addCliente(@Body Cliente cliente);

    //UPDATE
    @PUT(API_ROUTE + "/{cli_id}")
    Call<Cliente> updateCliente(@Path("cli_id") int id, @Body Cliente cliente);

    //DELETE
    @DELETE(API_ROUTE + "/{cli_id}")
    Call<Cliente> deleteCliente(@Path("cli_id") int id);
}
