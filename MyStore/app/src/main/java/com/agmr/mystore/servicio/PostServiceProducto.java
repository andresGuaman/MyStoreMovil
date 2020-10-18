package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Cliente;
import com.agmr.mystore.modelo.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostServiceProducto {
    //producto
    //GET
    String API_ROUTE = "/api/v1/Producto";

    @GET("/Producto")
    Call<List<Producto>> getProducto();

    //GET BY ID
    @GET("/detail/{id}")
    Call<Producto> getProductoById(@Path("id") int id);

    //POST
    @POST("/create")
    Call<Producto> addProducto(@Body Producto producto);

    //UPDATE
    @PUT("/update/{id}")
    Call<Producto> updateProucto(@Path("id") int id, @Body Producto producto);

    //DELETE
    @DELETE("/delete/{id}")
    Call<Producto> deleteProducto(@Path("id") int id);


}
