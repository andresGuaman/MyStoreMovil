package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.agmr.mystore.modelo.producto;
import com.agmr.mystore.service.PostServiceProducto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Productos_menu extends AppCompatActivity {
    private Button create_prod, menu_princi;

    private ListView lvImgen;
    private ArrayList<producto> imagesProduco;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_menu);
        init();
        create_prod = (Button) findViewById(R.id.btn_create_produc);
        create_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Crear_Producto.class);
                startActivity(intent);
            }
        });
        menu_princi = (Button) findViewById(R.id.btn_house);
        menu_princi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }

    public void init() {
        imagesProduco = new ArrayList<>();
        lvImgen = (ListView) findViewById(R.id.list_productos_menu);
        arrayAdapter = new AdapterImg(this, imagesProduco);
        lvImgen.setAdapter(arrayAdapter);
        getImgs();
    }

    public void getImgs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProducto = retrofit.create(PostServiceProducto.class);
        Call<List<producto>> call = postServiceProducto.getProducto();
        call.enqueue(new Callback<List<producto>>() {
            @Override
            public void onResponse(Call<List<producto>> call, Response<List<producto>> response) {
                assert response.body() != null;
                for (producto pro : response.body()) {
                    imagesProduco.add(new producto(pro.getPro_foto(), pro.getPro_descripcion(), pro.getPro_costo(), pro.getPro_precio(), pro.getPro_stock(), pro.getPro_codigo_barra(), pro.getPro_marca(), pro.getPro_modelo()));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<producto>> call, Throwable t) {

            }
        });

    }

}