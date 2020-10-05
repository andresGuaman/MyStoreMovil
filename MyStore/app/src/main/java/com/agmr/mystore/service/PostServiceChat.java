package com.agmr.mystore.service;

import com.agmr.mystore.modelo.chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServiceChat {
    //Chat
    //GET
    String API_ROUTE2="/api/v1";
    @GET(API_ROUTE2+"/Chat")
    Call<List<chat>> getChat();
    //GET BY ID
    //POST
    //UPDATE
    //DELETE


}
