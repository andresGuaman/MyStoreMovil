package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostServiceProducto {
    //producto
    //GET
    String API_ROUTE="/api/v1/Producto";
    @GET(API_ROUTE)
    Call<List<Producto>> getProducto();
    //GET BY ID
    //POST
    @POST(API_ROUTE)
    Call<Producto>addProducto(@Body Producto producto);

    //UPDATE
    //DELETE


}
