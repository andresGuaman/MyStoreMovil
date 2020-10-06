package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.EncabezadoFactura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceEncabezadoFactura {
    //encabezado factura
    //GET
    String API_ROUTE9="/api/v1";
    @GET(API_ROUTE9+"/EncabezadoFactura")
    Call<List<EncabezadoFactura>> getEncabezadoFactura();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
