package com.agmr.mystore.service;

import com.agmr.mystore.modelo.empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceEmpleado {
    //empleado
    //GET
    String API_ROUTE7="/api/v1";
    @GET(API_ROUTE7+"/Empleado")
    Call<List<empleado>> getEmpleado();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
