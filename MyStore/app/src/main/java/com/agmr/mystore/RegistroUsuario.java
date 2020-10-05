package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agmr.mystore.modelo.Persona;
import com.agmr.mystore.modelo.cliente;
import com.agmr.mystore.service.PostServiceCliente;
import com.agmr.mystore.service.PostServicePersona;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroUsuario extends AppCompatActivity {
    cliente cliente=new cliente();
    Persona persona=new Persona();
private EditText nombre, apellido, cedula, correo , telefono, foto, usuario,password;
private Button guarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        nombre=(EditText)findViewById(R.id.txt_nombre);
        apellido=(EditText)findViewById(R.id.txt_apellido);
        cedula=(EditText)findViewById(R.id.txt_cedula);
        correo=(EditText)findViewById(R.id.txt_correo);
        telefono=(EditText)findViewById(R.id.txt_telefono);
        foto=(EditText)findViewById(R.id.txt_foto);
        password=(EditText)findViewById(R.id.txt_password);
        usuario=(EditText)findViewById(R.id.txt_usuario);

        guarda=(Button) findViewById(R.id.btn_guardar);
        guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(clientedatos());
                createPersona(personadatos());
            }
        });

    }

    public cliente clientedatos(){
        cliente cliente=new cliente();
        cliente.setCli_descuento("0");
        cliente.setCli_password(password.getText().toString());
        cliente.setCli_usuario(usuario.getText().toString());
        return cliente;
    }

    private void createUser(cliente cliente){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceCliente postServiceCliente=retrofit.create(PostServiceCliente.class);
        Call<cliente> call=postServiceCliente.addCliente(cliente);
          call.enqueue(new Callback<com.agmr.mystore.modelo.cliente>() {
              @Override
              public void onResponse(Call<com.agmr.mystore.modelo.cliente> call, Response<com.agmr.mystore.modelo.cliente> response) {
                  if (response.isSuccessful()){
                      Toast.makeText(RegistroUsuario.this,"Se guardo correctamente",Toast.LENGTH_SHORT).show();
                  }else{
                      Toast.makeText(RegistroUsuario.this,"No se guardo correctamente",Toast.LENGTH_SHORT).show();
                  }
             }
             @Override
              public void onFailure(Call<com.agmr.mystore.modelo.cliente> call, Throwable t) {
                  Toast.makeText(RegistroUsuario.this,"A fallado la coneccion"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
              }
          });
    }

    public Persona personadatos(){
        persona.setPer_nombre(nombre.getText().toString());
        persona.setPer_apellido(apellido.getText().toString());
        persona.setPer_cedula(cedula.getText().toString());
        persona.setPer_correo(correo.getText().toString());
        persona.setPer_foto(foto.getText().toString());
        persona.setPer_telefono(telefono.getText().toString());
        persona.setPer_estado("true");
        persona.setPer_fecha_creacion("");
        return  persona;
    }
public  void createPersona(Persona persona){
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("http://192.168.56.1:9898")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
final  PostServicePersona postServicePersona=retrofit.create(PostServicePersona.class);
    Call<Persona> call=postServicePersona.addPersona(persona);
    call.enqueue(new Callback<Persona>() {
        @Override
        public void onResponse(Call<Persona> call, Response<Persona> response) {
            if (response.isSuccessful()){
                Toast.makeText(RegistroUsuario.this,"Se guardo correctamente",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(RegistroUsuario.this,"No se guardo correctamente",Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onFailure(Call<Persona> call, Throwable t) {
            Toast.makeText(RegistroUsuario.this,"A fallado la coneccion"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
        }
    });


    }

}
