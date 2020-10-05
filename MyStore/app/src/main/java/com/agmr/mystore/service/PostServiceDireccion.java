package com.agmr.mystore.service;

import com.agmr.mystore.modelo.direccion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceDireccion {
    //direccion
    //GET
    String API_ROUTE6="/api/v1";
    @GET(API_ROUTE6+"/Direccion")
    Call<List<direccion>> getDireccion();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
