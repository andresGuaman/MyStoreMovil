package com.agmr.mystore.service;

import com.agmr.mystore.modelo.producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostServiceProducto {
    //producto
    //GET
    String API_ROUTE="/Producto";
    @GET(API_ROUTE)
    Call<List<producto>> getProducto();
    //GET BY ID
    //POST
    @POST("/create")
    Call<producto>addProducto(@Body producto producto);

    //UPDATE
    //DELETE


}
