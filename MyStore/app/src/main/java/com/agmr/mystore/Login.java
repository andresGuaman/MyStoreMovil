package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.agmr.mystore.modelo.Cliente;
import com.agmr.mystore.servicio.ClienteServicio;

import java.nio.FloatBuffer;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtPass;
    private TextView estado_usuario;
    private TextView estado_pass;
    private TextView userNotFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        init();
    }

    public void init() {

        txtUsuario = findViewById(R.id.login_txtUsuario);
        txtPass = findViewById(R.id.login_txtPass);
        estado_usuario = findViewById(R.id.estado_login_usuario);
        estado_pass = findViewById(R.id.estado_login_pass);
        userNotFound = findViewById(R.id.viewUserNotFound);

        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegistrar = findViewById(R.id.btn_registrarse);
        ImageButton btnIngresar = findViewById(R.id.btn_ingresar_sin_id);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroUsuario.class);
                login();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroUsuario.class);
                startActivity(intent);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }

    public void login() {
        if (validacion()) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.103:9898").addConverterFactory(GsonConverterFactory.create()).build();
            final ClienteServicio clienteServicio = retrofit.create(ClienteServicio.class);
            Call<Cliente> cliente = clienteServicio.getClienteByUserPass(txtUsuario.getText().toString(), txtPass.getText().toString());

            cliente.enqueue(new Callback<Cliente>() {
                @Override
                public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(Login.this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Error de Servidor", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Cliente> call, Throwable t) {
                    Toast.makeText(Login.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                    userNotFound.setTextColor(Color.RED);
                }
            });
        }
    }

    public boolean validacion() {
        boolean respuesta = true;

        if (txtUsuario.getText().toString().isEmpty()) {
            setIconEstado(estado_usuario, true);
            respuesta = false;
        }else {
            setIconEstado(estado_usuario,false);
        }

        if (txtPass.getText().toString().isEmpty()) {
            setIconEstado(estado_pass, true);
            respuesta = false;
        } else {
            setIconEstado(estado_pass, false);
        }

        return respuesta;
    }

    public void setIconEstado(TextView icon, boolean estado) {
        if (estado) {
            icon.setBackgroundResource(R.drawable.ic_multiple);
            icon.getBackground().setTint(Color.RED);
        } else {
            icon.setBackgroundResource(R.drawable.ic_check);
            icon.getBackground().setTint(Color.GREEN);
        }
    }
}