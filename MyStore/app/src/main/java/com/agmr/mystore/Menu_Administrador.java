package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Administrador extends AppCompatActivity {
    Button menu_product, crear_PRO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__administrador);

        crear_PRO = (Button) findViewById(R.id.btn_ventas);
        crear_PRO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Crear_Producto.class);
                startActivity(intent);
            }
        });
        menu_product = (Button) findViewById(R.id.btn_productos);
        menu_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Productos_menu.class);
                startActivity(intent);
            }
        });

    }
}