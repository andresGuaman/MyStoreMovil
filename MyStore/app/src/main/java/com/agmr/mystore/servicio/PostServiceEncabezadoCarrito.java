package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.EncabezadoCarrito;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceEncabezadoCarrito {
    //encabezado carrito
    //GET
    String API_ROUTE8="/api/v1";
    @GET(API_ROUTE8+"/EncabezadoCarrito")
    Call<List<EncabezadoCarrito>> getEncabezadoCarrito();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
