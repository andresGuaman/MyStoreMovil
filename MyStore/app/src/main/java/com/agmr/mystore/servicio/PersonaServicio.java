package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Persona;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PersonaServicio {

    String API_ROUTE = "/api/v1/Persona";

    //GET
    @GET(API_ROUTE)
    Call<List<Persona>> getPersona();

    //GET BY ID
    @GET(API_ROUTE + "/{per_id}")
    Call<List<Persona>> getIdPersona(@Path("per_id") int id);

    //GET CONTACTS OF CHAT BY CLI_ID
    @GET(API_ROUTE + "/contactos-cliente/{cli_id}")
    Call<List<Persona>> getContactsByClientId(@Path("cli_id") long cli_id);

    //GET CONTACTS OF CHAT BY CLI_ID
    @GET(API_ROUTE + "/contactos-cliente/{emp_id}")
    Call<List<Persona>> getContactsByEmployeeId(@Path("emp_id") long emp_id);

    //POST
    @POST(API_ROUTE)
    Call<Persona> addPersona(@Body Persona persona);

    //UPDATE
    @PUT(API_ROUTE + "/{per_id}")
    Call<Persona> updatePersona(@Path("per_id") int id, @Body Persona persona);

    //DELETE
    @DELETE(API_ROUTE + "/{per_id}")
    Call<Persona> deletePersona(@Path("per_id") int id);
}
