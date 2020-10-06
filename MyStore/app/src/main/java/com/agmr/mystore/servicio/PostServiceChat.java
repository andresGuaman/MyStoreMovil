package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceChat {
    //Chat
    //GET
    String API_ROUTE2="/api/v1";
    @GET(API_ROUTE2+"/Chat")
    Call<List<Chat>> getChat();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
