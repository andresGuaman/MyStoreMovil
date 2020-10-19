package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostServiceChat {

    String API_ROUTE = "/Chat";
    //GET ALL
    @GET(API_ROUTE)
    Call<List<Chat>> getChat();

    //GET BY ID

    //GET ALL MESSAGES BY CLI_ID AND EMP_ID
    @GET(API_ROUTE + "/all/{cli_id}/{emp_id}")
    Call<List<Chat>> getAllChatsByCliEmpIds(@Path("cli_id") long cli_id, @Path("emp_id") long emp_id);

    //GET FINAL CHAT BY CLI_ID AND EMP_ID
    @GET(API_ROUTE + "/{cli_id}/{emp_id}")
    Call<Chat> getChatByCliEmpIds(@Path("cli_id") long cli_id, @Path("emp_id") long emp_id);

    //POST
    @POST(API_ROUTE + "/{cli_id}/{emp_id}")
    Call<Chat> insertChat(@Body Chat chat, @Path("cli_id") long cli_id, @Path("emp_id") long emp_id);

    //UPDATE

    //DELETE
}
