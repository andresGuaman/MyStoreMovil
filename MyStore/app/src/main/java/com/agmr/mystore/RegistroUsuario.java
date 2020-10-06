package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;
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
import com.agmr.mystore.modelo.Persona;
import com.agmr.mystore.servicio.ClienteServicio;
import com.agmr.mystore.servicio.PersonaServicio;
import java.util.Date;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistroUsuario extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtPass;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtTelefono;
    private EditText txtCorreo;
    private ImageButton btnRegresar;
    private Button btnSiguiente;
    private Button btnFoto;
    private TextView estado_usuario;
    private TextView estado_pass;
    private TextView estado_nombre;
    private TextView estado_apellido;
    private TextView estado_telefono;
    private TextView estado_correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        init();
    }

    public void init() {
        txtUsuario = findViewById(R.id.txtUsuario);
        txtPass = findViewById(R.id.txtPass);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        estado_usuario = findViewById(R.id.estado_usuario);
        estado_pass = findViewById(R.id.estado_pass);
        estado_nombre = findViewById(R.id.estado_nombre);
        estado_apellido = findViewById(R.id.estado_apellido);
        estado_telefono = findViewById(R.id.estado_telefono);
        estado_correo = findViewById(R.id.estado_correo);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });
    }

    public void regresar() {

    }

    public void siguiente() {
        if (valicacion()) {
            insertarPersona();
            insertarCliente();
        }
    }

    public void insertarPersona() {
        Date date = null;

        Persona p = new Persona(0, "9999999999", txtNombre.getText().toString(), txtApellido.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString(), date, "Activo", "http://photos/myphoto.png");

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.104:9898").addConverterFactory(GsonConverterFactory.create()).build();
        final PersonaServicio personaServicio = retrofit.create(PersonaServicio.class);
        Call<Persona> call = personaServicio.addPersona(p);

        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if (response.isSuccessful()) Toast.makeText(RegistroUsuario.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                else Toast.makeText(RegistroUsuario.this, "No se guardo correctamente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {
                Toast.makeText(RegistroUsuario.this, "A fallado la coneccion" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.println(Log.WARN, "Insert Person", t.getMessage());
            }
        });
    }

    public void insertarCliente() {

        Cliente c = new Cliente(0, 0, txtUsuario.getText().toString(), txtPass.getText().toString(), 0);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.104:9898").addConverterFactory(GsonConverterFactory.create()).build();
        final ClienteServicio clienteServicio = retrofit.create(ClienteServicio.class);
        Call<Cliente> call = clienteServicio.addCliente(c);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(RegistroUsuario.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistroUsuario.this, "No se guardo correctamente", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Toast.makeText(RegistroUsuario.this, "A fallado la coneccion" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.println(Log.WARN, "Insert Person", t.getMessage());
            }
        });
    }

    //Otros métodos

    public boolean valicacion() {

        boolean respuesta = true;

        if (txtUsuario.getText().toString().trim().isEmpty()) {
            setIconEstado(estado_usuario, true);
            respuesta = false;
        } else {
            setIconEstado(estado_usuario, false);
        }

        if (txtPass.getText().toString().trim().isEmpty()) {
            setIconEstado(estado_pass, true);
            respuesta = false;
        } else {
            setIconEstado(estado_pass, false);
        }

        if (txtNombre.getText().toString().trim().isEmpty()) {
            setIconEstado(estado_nombre, true);
            respuesta = false;
        } else {
            setIconEstado(estado_nombre, false);
        }

        if (txtApellido.getText().toString().trim().isEmpty()) {
            setIconEstado(estado_apellido, true);
            respuesta = false;
        } else {
            setIconEstado(estado_apellido, false);
        }

        if (txtTelefono.getText().toString().trim().isEmpty()) {
            setIconEstado(estado_telefono, true);
            respuesta = false;
        } else {
            setIconEstado(estado_telefono, false);
        }

        if (txtCorreo.getText().toString().trim().isEmpty()) {
            setIconEstado(estado_correo, true);
            respuesta = false;
        } else {
            setIconEstado(estado_correo, false);
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