package com.agmr.mystore.servicio;

import com.agmr.mystore.modelo.Cliente;
import com.agmr.mystore.modelo.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostServiceEmpleado {

    String API_ROUTE7 = "/api/v1/Empleado";

    //GET ALL
    @GET(API_ROUTE7)
    Call<List<Empleado>> getEmpleado();

    //GET BY ID

    //GET BY PER_ID
    @GET(API_ROUTE7 + "/per_id/{per_id}")
    Call<Empleado> getEmpleadoByPersonaId(@Path("per_id") long per_id);

    //GET BY USERNAME AND PASSWORD
    @GET(API_ROUTE7 + "/{emp_usuario}/{emp_password}")
    Call<Empleado> getEmpleadoByUserPass(@Path("emp_usuario") String emp_usuario, @Path("emp_password") String emp_password);

    //POST

    //UPDATE

    //DELETE
}
