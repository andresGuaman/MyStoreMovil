package com.agmr.mystore.service;

import com.agmr.mystore.modelo.metodoPago;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceMetodoPago {
    //metodo de pago
    //GET
    String API_ROUTE10="/api/v1";
    @GET(API_ROUTE10+"/MetodoPago")
    Call<List<metodoPago>> getMetodoPago();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
