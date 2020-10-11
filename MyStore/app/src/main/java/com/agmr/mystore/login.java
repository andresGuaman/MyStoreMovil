package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.nio.FloatBuffer;

public class Login extends AppCompatActivity {
    private ImageButton ingresarflecha;
    private Button registrasebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registrasebtn = (Button) findViewById(R.id.btn_registrarse);
        registrasebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroUsuario.class);
                startActivity(intent);
            }
        });
        ingresarflecha = (ImageButton) findViewById(R.id.btn_ingresar_sin_id);
        ingresarflecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(intent);
            }
        });


    }


}