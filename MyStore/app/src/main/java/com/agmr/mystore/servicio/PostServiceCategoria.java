package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Categoria;

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
    Call<List<Categoria>> getCategoria();
    //GET BY ID
    @GET(API_ROUTE+"/Categoria/{cat_id}")
    Call<List<Categoria>>getIdCategoria(@Path("cat_id") int id);
    //POST
    // @FormUrlEncoded
    @POST(API_ROUTE+"/Categoria")
    Call<Categoria>addCategoria(@Body Categoria categoria);
    //UPDATE
    @PUT(API_ROUTE+"/Categoria/{cat_id}")
    Call<Categoria> updateCategoria(@Path("cat_id") int id, @Body Categoria categoria);
    //DELETE
    @DELETE(API_ROUTE+"/Categoria/{cat_id}")
    Call<Categoria>deleCategoria(@Path("cat_id") int id);

}
