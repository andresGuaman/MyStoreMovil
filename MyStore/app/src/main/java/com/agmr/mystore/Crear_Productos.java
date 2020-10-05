package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.agmr.mystore.modelo.producto;
import com.agmr.mystore.service.PostServiceCliente;
import com.agmr.mystore.service.PostServiceProducto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Crear_Productos extends AppCompatActivity {
EditText foto, descrip, costo, precio, stock, marca, modelo ;
Button crear, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear__productos);
    foto=(EditText)findViewById(R.id.txt_foto);
    descrip=(EditText)findViewById(R.id.txt_descripcion);
    costo=(EditText)findViewById(R.id.txt_costo);
    precio=(EditText)findViewById(R.id.txt_precio);
    stock=(EditText)findViewById(R.id.txt_stock);
    marca=(EditText)findViewById(R.id.txt_Marca);
    modelo=(EditText)findViewById(R.id.txt_Modelo);

    crear=(Button)findViewById(R.id.btn_create);
    cancelar=(Button)findViewById(R.id.btn_cancelar);

    crear.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            createProduct(productoDatos());
        }
    });
    cancelar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),Productos.class);
            startActivity(intent);
        }
    });

    }


    public producto productoDatos(){
        producto producto=new producto();
        producto.setPro_foto(foto.getText().toString());
        producto.setPro_descripcion(descrip.getText().toString());
        producto.setPro_costo(Integer.parseInt(costo.getText().toString()));
        producto.setPro_precio(Integer.parseInt(precio.getText().toString()));
        producto.setPro_stock(Integer.parseInt(stock.getText().toString()));
        producto.setPro_codigo_barra("null");
        producto.setPro_marca(marca.getText().toString());
        producto.setPro_modelo(modelo.getText().toString());
        return producto;
    }

    private  void createProduct(producto producto){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProducto=retrofit.create(PostServiceProducto.class);
        Call<producto> call=postServiceProducto.addProducto(producto);
        call.enqueue(new Callback<com.agmr.mystore.modelo.producto>() {
            @Override
            public void onResponse(Call<com.agmr.mystore.modelo.producto> call, Response<com.agmr.mystore.modelo.producto> response) {
                if (response.isSuccessful()){
                    Toast.makeText(Crear_Productos.this,"Se guardo correctamente",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Crear_Productos.this,"No se guardo correctamente",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<com.agmr.mystore.modelo.producto> call, Throwable t) {
                Toast.makeText(Crear_Productos.this,"A fallado la coneccion"+t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }

}