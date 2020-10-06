package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.ProductoProveedor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceProductoProveedor {
    //producto proveedor
    //GET
    String API_ROUTE13="/api/v1";
    @GET(API_ROUTE13+"/ProductoProovedor")
    Call<List<ProductoProveedor>> getProductoProveedor();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
