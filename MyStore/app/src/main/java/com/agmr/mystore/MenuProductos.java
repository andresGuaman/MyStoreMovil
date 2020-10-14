package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.agmr.mystore.AdaptingImagen.AdapterImglist;
import com.agmr.mystore.modelo.Producto;
import com.agmr.mystore.servicio.PostServiceProducto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuProductos extends AppCompatActivity {
    private Button home, createProd;
    private ListView lista;
    private ArrayList<Producto> imagesProducto;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_productos);
        init();
        home = (Button) findViewById(R.id.btnInicio);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
                startActivity(intent);
            }
        });

        createProd = (Button) findViewById(R.id.btnCrearProduct);
        createProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CrearProducto.class);
                startActivity(intent);
            }
        });
        lista=(ListView)findViewById(R.id.listMenuProduct);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuProductos.this, "i"+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void init() {
        imagesProducto = new ArrayList<>();
        lista = (ListView) findViewById(R.id.listMenuProduct);
        arrayAdapter = new AdapterImglist(this, imagesProducto);
        lista.setAdapter(arrayAdapter);
        getImgs();
    }

    public void getImgs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProducto = retrofit.create(PostServiceProducto.class);
        Call<List<Producto>> call = postServiceProducto.getProducto();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                assert response.body() != null;
                for (Producto pro : response.body()) {
                    imagesProducto.add(new Producto(pro.getPro_foto(), pro.getPro_descripcion(), pro.getPro_costo(), pro.getPro_precio(), pro.getPro_stock(), pro.getPro_codigo_barra(), pro.getPro_marca(), pro.getPro_modelo()));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }

}