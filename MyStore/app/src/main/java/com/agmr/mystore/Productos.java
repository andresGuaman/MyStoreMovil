package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.agmr.mystore.modelo.producto;
import com.agmr.mystore.service.PostServiceProducto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Productos extends AppCompatActivity {
ArrayList<String>arrayList=new ArrayList<>();
ArrayAdapter arrayAdapter;
ListView lista;
    Button regProducto;
    FloatingActionButton  home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

    regProducto=(Button)findViewById(R.id.btn);
    regProducto.setOnClickListener(new View.OnClickListener() {
       @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),Crear_Productos.class);
            startActivity(intent);
        }
    });

    home=(FloatingActionButton)findViewById(R.id.btn_home);
    home.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(),MenuPrincipal.class);
            startActivity(intent);
        }
    });

    lista=(ListView)findViewById(R.id.lsv_lista);

   // final Cursor cursor;
 //   String[]desde=new String[]{}

    //final CursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),
      //      R.layout.list_productos,cursor)

    arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
    lista.setAdapter(arrayAdapter);
    ListProduct();
    }


    private  void ListProduct(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProducto=retrofit.create(PostServiceProducto.class);
        Call<List<producto>> call=postServiceProducto.getProducto();
        call.enqueue(new Callback<List<producto>>() {
            @Override
            public void onResponse(Call<List<producto>> call, Response<List<producto>> response) {
                for (producto producto:response.body()){
                    arrayList.add(producto.getPro_foto()+producto.getPro_descripcion()+
                            producto.getPro_costo()+producto.getPro_precio()+
                            producto.getPro_stock()+producto.getPro_marca()+producto.getPro_modelo());
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<producto>> call, Throwable t) {

            }
        });

    }


}