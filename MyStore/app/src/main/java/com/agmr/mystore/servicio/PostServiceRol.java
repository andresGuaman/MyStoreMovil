package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Rol;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceRol {
    //rol
    //GET
    String API_ROUTE15="/api/v1";
    @GET(API_ROUTE15+"/Rol")
    Call<List<Rol>> getRol();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE

}
