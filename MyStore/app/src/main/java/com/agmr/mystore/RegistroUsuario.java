package com.agmr.mystore;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.agmr.mystore.modelo.Cliente;
import com.agmr.mystore.modelo.Persona;
import com.agmr.mystore.modelo.Usuarios;
import com.agmr.mystore.servicio.ClienteServicio;
import com.agmr.mystore.servicio.CnnSQLite;
import com.agmr.mystore.servicio.PersonaServicio;

import java.io.ByteArrayOutputStream;
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
    private ImageButton btnFoto;
    private TextView estado_usuario;
    private TextView estado_pass;
    private TextView estado_nombre;
    private TextView estado_apellido;
    private TextView estado_telefono;
    private TextView estado_correo;
    private Bitmap photo = null;
    CnnSQLite cnn;

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
        ImageButton btnRegresar = findViewById(R.id.btnRegresarRegistroUsuario);
        Button btnSiguiente = findViewById(R.id.btnSiguiente);
        btnFoto = findViewById(R.id.btnFoto);
        estado_usuario = findViewById(R.id.estado_usuario);
        estado_pass = findViewById(R.id.estado_pass);
        estado_nombre = findViewById(R.id.estado_nombre);
        estado_apellido = findViewById(R.id.estado_apellido);
        estado_telefono = findViewById(R.id.estado_telefono);
        estado_correo = findViewById(R.id.estado_correo);
        cnn = new CnnSQLite(getApplicationContext());

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(intent);
            }
        });
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent take = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(take, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        photo = (Bitmap) data.getExtras().get("data");
        btnFoto.setBackground(null);
        btnFoto.setImageBitmap(photo);
    }

    public void siguiente() {
        if (valicacion()) {
            insertarPersona();
        }
    }

    public void insertarPersona() {

        String foto = BitMapToString(photo);
        Log.println(Log.ERROR, "Foto -> ", foto);
        Date date = null;
        Persona p = new Persona(0, "9999999999", txtNombre.getText().toString(), txtApellido.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString(), date, "Activo", foto);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
        final PersonaServicio personaServicio = retrofit.create(PersonaServicio.class);
        Call<Persona> call = personaServicio.addPersona(p);

        call.enqueue(new Callback<Persona>() {
            @Override
            public void onResponse(Call<Persona> call, Response<Persona> response) {
                if (response.isSuccessful()) {

                    Persona per = response.body();
                    assert per != null;
                    insertarCliente(per.getPer_id());
                    cnn.insertUsuario(new Usuarios(0, 1, (int) per.getPer_id(), "cliente"));
                }
            }

            @Override
            public void onFailure(Call<Persona> call, Throwable t) {  }
        });
    }

    public void insertarCliente(long per_id) {

        Cliente c = new Cliente(0, 0, txtUsuario.getText().toString(), txtPass.getText().toString(), per_id);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
        final ClienteServicio clienteServicio = retrofit.create(ClienteServicio.class);
        Call<Cliente> call = clienteServicio.insertCliente(c, per_id);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(RegistroUsuario.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Toast.makeText(RegistroUsuario.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
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

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
}