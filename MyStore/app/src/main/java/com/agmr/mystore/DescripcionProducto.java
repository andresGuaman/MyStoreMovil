package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.agmr.mystore.AdaptingImagen.AdapterImglist;
import com.agmr.mystore.modelo.Producto;
import com.agmr.mystore.servicio.PostServiceProducto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DescripcionProducto extends AppCompatActivity {
    private ListView lista;
    private ArrayList<Producto> imagesProducto;
    private ArrayAdapter arrayAdapter;

    private TextView descripcion, precio, marca, modelo;
    private ImageView imgProDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_producto);
        descripcion = (TextView) findViewById(R.id.TXTDescripD);
        precio = (TextView) findViewById(R.id.TXTprecioDes);
        marca = (TextView) findViewById(R.id.TXTmarcDes);
        modelo = (TextView) findViewById(R.id.TXTmodelDes);
        imgProDes = (ImageView) findViewById(R.id.ImgDetalle);
        init();
        int idProd = Integer.parseInt(getIntent().getStringExtra("id"));
        getImgsDetall(idProd);
    }

    public void init() {
        imagesProducto = new ArrayList<>();
        lista = (ListView) findViewById(R.id.LISdesripcionP);
        arrayAdapter = new AdapterImglist(this, imagesProducto);
        lista.setAdapter(arrayAdapter);
        getImgs();
    }


    protected void getImgsDetall(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProductoD = retrofit.create(PostServiceProducto.class);
        Call<Producto> call = postServiceProductoD.getProductoById(id + 1);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                try {
                    if (response.isSuccessful()) {
                        Producto producDes = response.body();
                        String URLIMG = producDes.getPro_foto();
                        descripcion.setText(producDes.getPro_descripcion());
                        precio.setText("USD$ " + producDes.getPro_precio());
                        marca.setText(producDes.getPro_marca());
                        modelo.setText(producDes.getPro_modelo());
                        Picasso.with(DescripcionProducto.this).load(URLIMG)
                                .error(R.mipmap.ic_launcher).fit().centerInside().into(imgProDes);
                    }
                } catch (Exception e) {
                    Toast.makeText(DescripcionProducto.this, "Eroro " + e, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Toast.makeText(DescripcionProducto.this, "a ocurrido un error de conexion ", Toast.LENGTH_SHORT).show();

            }
        });
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
                //    Toast.makeText(DescripcionProducto.this, "init "+arrayAdapter, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }


}