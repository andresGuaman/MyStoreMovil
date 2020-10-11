package com.agmr.mystore.service;

import com.agmr.mystore.modelo.detalleFactura;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceDetalleFactura {
    //detalle factura
    //GET
    String API_ROUTE5="/api/v1";
    @GET(API_ROUTE5+"/DetalleFactura")
    Call<List<detalleFactura>> getDetalleFactura();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
