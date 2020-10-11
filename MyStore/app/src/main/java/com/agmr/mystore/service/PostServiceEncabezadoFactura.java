package com.agmr.mystore.service;

import com.agmr.mystore.modelo.encabezadoFactura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceEncabezadoFactura {
    //encabezado factura
    //GET
    String API_ROUTE9="/api/v1";
    @GET(API_ROUTE9+"/EncabezadoFactura")
    Call<List<encabezadoFactura>> getEncabezadoFactura();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
