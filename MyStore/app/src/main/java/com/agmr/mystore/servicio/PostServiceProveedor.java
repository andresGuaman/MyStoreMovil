package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Proveedor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceProveedor {
    //proveedor
    //GET
    String API_ROUTE14="/api/v1";
    @GET(API_ROUTE14+"/Proveedor")
    Call<List<Proveedor>> getProveedor();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
