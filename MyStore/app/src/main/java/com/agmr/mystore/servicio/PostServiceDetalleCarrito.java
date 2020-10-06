package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.DetalleCarrito;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceDetalleCarrito {
    //detalle carrito
    //GET
    String API_ROUTE4="/api/v1";
    @GET(API_ROUTE4+"/DetalleCarrito")
    Call<List<DetalleCarrito>> getDetalleCarrito();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
