package com.agmr.mystore.service;

import com.agmr.mystore.modelo.proveedor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceProveedor {
    //proveedor
    //GET
    String API_ROUTE14="/api/v1";
    @GET(API_ROUTE14+"/Proveedor")
    Call<List<proveedor>> getProveedor();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
