package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agmr.mystore.modelo.cliente;
import com.agmr.mystore.modelo.producto;
import com.agmr.mystore.service.PostServiceCliente;
import com.agmr.mystore.service.PostServiceProducto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Crear_Producto extends AppCompatActivity {

    Button guardar, cancelar;
    EditText fotos, codig_barras, marca, modelo, descrip, costo, precio, stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__producto);

        guardar = (Button) findViewById(R.id.btn_guardar_producto);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createProduct(datosProducto());
            }
        });

        cancelar = (Button) findViewById(R.id.btn_cancelar_prod);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Productos_menu.class);
                startActivity(intent);
            }
        });

        fotos = (EditText) findViewById(R.id.txt_foto);
        codig_barras = (EditText) findViewById(R.id.txt_cod_barras);
        marca = (EditText) findViewById(R.id.txt_mrca);
        modelo = (EditText) findViewById(R.id.txt_model);
        descrip = (EditText) findViewById(R.id.txt_descripcion);
        costo = (EditText) findViewById(R.id.txt_costo);
        precio = (EditText) findViewById(R.id.txt_precio);
        stock = (EditText) findViewById(R.id.txt_cantidad);
    }

    public producto datosProducto() {
        producto produc = new producto();
        produc.setPro_foto(fotos.getText().toString());
        produc.setPro_codigo_barra(codig_barras.getText().toString());
        produc.setPro_marca(marca.getText().toString());
        produc.setPro_modelo(modelo.getText().toString());
        produc.setPro_descripcion(descrip.getText().toString());
        produc.setPro_costo(costo.getAlpha());
        produc.setPro_precio(precio.getAlpha());
        produc.setPro_stock(stock.getAccessibilityLiveRegion());
        return produc;
    }

    private void createProduct(producto producto) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProducto = retrofit.create(PostServiceProducto.class);
        Call<producto> call = postServiceProducto.addProducto(producto);
        call.enqueue(new Callback<com.agmr.mystore.modelo.producto>() {
            @Override
            public void onResponse(Call<com.agmr.mystore.modelo.producto> call, Response<com.agmr.mystore.modelo.producto> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Crear_Producto.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Crear_Producto.this, "No se guardo correctamente", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<com.agmr.mystore.modelo.producto> call, Throwable t) {
                Toast.makeText(Crear_Producto.this, "A fallado la coneccion" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}

