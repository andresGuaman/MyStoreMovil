package com.agmr.mystore.service;

import com.agmr.mystore.modelo.categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostServiceCategoria {
    //Categoria
    //GET
    String API_ROUTE="/api/v1";
    @GET(API_ROUTE+"/Categoria")
    Call<List<categoria>> getCategoria();
    //GET BY ID
    @GET(API_ROUTE+"/Categoria/{cat_id}")
    Call<List<categoria>>getIdCategoria(@Path("cat_id") int id);
    //POST
    // @FormUrlEncoded
    @POST(API_ROUTE+"/Categoria")
    Call<categoria>addCategoria(@Body categoria categoria);
    //UPDATE
    @PUT(API_ROUTE+"/Categoria/{cat_id}")
    Call<categoria> updateCategoria(@Path("cat_id") int id, @Body categoria categoria);
    //DELETE
    @DELETE(API_ROUTE+"/Categoria/{cat_id}")
    Call<categoria>deleCategoria(@Path("cat_id") int id);

}
