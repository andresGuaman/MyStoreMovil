package com.agmr.mystore.service;

import com.agmr.mystore.modelo.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface PostServicePersona {
    //persona
    //GET
    String API_ROUTE="/api/v1";
    @GET(API_ROUTE+"/Persona")
    Call<List<Persona>> getPersona();
    //GET BY ID
    @GET(API_ROUTE+"/Persona/{per_id}")
    Call<List<Persona>>getIdPersona(@Path("per_id") int id);
    //POST
    // @FormUrlEncoded
    @POST(API_ROUTE+"/Persona")
    Call<Persona>addPersona(@Body Persona persona);
    //UPDATE
    @PUT(API_ROUTE+"/Persona/{per_id}")
    Call<Persona> updatePersona(@Path("per_id") int id, @Body Persona persona);
    //DELETE
    @DELETE(API_ROUTE+"/Persona/{per_id}")
    Call<Persona>delePersona(@Path("per_id") int id);


}
