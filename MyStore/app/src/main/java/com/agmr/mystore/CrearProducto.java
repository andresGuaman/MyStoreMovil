package com.agmr.mystore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.agmr.mystore.modelo.Producto;
import com.agmr.mystore.servicio.PostServiceProducto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CrearProducto extends AppCompatActivity {

    private ImageButton regresa;
    private FloatingActionButton buscarImage;
    private Button guardar;

    private ArrayList<Producto> imagesProducto;
    private ArrayAdapter arrayAdapter;
    Activity context;

    private EditText link, descrip, costo, precio, cantidad, codBarras, marca, modelo;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_producto);
        regresa = (ImageButton) findViewById(R.id.btnRegresar);
        regresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuProductos.class);
                startActivity(intent);
            }
        });
        //loadImageURL();
        buscarImage = (FloatingActionButton) findViewById(R.id.btnMostrarFoto);
        buscarImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImageURL();
            }
        });
        guardar = (Button) findViewById(R.id.btnCrearProducto);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createProduct(datosproducto());
            }
        });
        link = (EditText) findViewById(R.id.txtLinkFoto);
        descrip = (EditText) findViewById(R.id.txtDescripcion);
        costo = (EditText) findViewById(R.id.txtCosto);
        precio = (EditText) findViewById(R.id.txtPrecio);
        cantidad = (EditText) findViewById(R.id.txtCantidad);
        codBarras = (EditText) findViewById(R.id.txtCodigoBarras);
        marca = (EditText) findViewById(R.id.txtMarca);
        modelo = (EditText) findViewById(R.id.txtModelo);
    }


    public Producto datosproducto() {
        Producto produc = new Producto();
        produc.setPro_foto(link.getText().toString());
        produc.setPro_descripcion(descrip.getText().toString());
        produc.setPro_costo(Double.parseDouble(costo.getText().toString()));
        produc.setPro_precio(Double.parseDouble(precio.getText().toString()));
        produc.setPro_stock(Integer.parseInt(precio.getText().toString()));
        produc.setPro_codigo_barra(codBarras.getText().toString());
        produc.setPro_marca(marca.getText().toString());
        produc.setPro_modelo(modelo.getText().toString());
        return produc;
    }

    private void createProduct(Producto producto) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProducto = retrofit.create(PostServiceProducto.class);
        Call<Producto> call = postServiceProducto.addProducto(producto);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CrearProducto.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MenuProductos.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CrearProducto.this, "No se guardo correctamente", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Toast.makeText(CrearProducto.this, "A fallado la coneccion" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadImageURL() {
        foto = (ImageView) findViewById(R.id.imgProductosCreate);
        String URLimg;
        if (link == null) {
            URLimg = "https://us.123rf.com/450wm/tkacchuk/tkacchuk1411/tkacchuk141100019/34156944-bolso-agregar-bienes-sencillo-icono-en-el-fondo-blanco-.jpg?ver=6";
            Picasso.with(this).load(URLimg)
                    .error(R.mipmap.ic_launcher).fit().centerInside().into(foto);
            Toast.makeText(CrearProducto.this, "A fallado la coneccion" + link.getText().toString(), Toast.LENGTH_SHORT).show();
        } else {
            Picasso.with(this).load(link.getText().toString())
                    .error(R.mipmap.ic_launcher).fit().centerInside().into(foto);
        }
    }
}