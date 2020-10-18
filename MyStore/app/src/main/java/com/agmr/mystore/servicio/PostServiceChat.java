package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostServiceChat {

    String API_ROUTE = "/Chat";
    //GET ALL
    @GET(API_ROUTE)
    Call<List<Chat>> getChat();

    //GET BY ID

    //GET BY CLI_ID AND EMP_ID
    @GET(API_ROUTE + "/{cli_id}/{emp_id}")
    Call<Chat> getChatByCliEmpIds(@Path("cli_id") long cli_id, @Path("emp_id") long emp_id);

    //POST

    //UPDATE

    //DELETE
}
