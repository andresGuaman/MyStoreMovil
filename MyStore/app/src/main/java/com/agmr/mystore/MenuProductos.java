package com.agmr.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
        lista = (ListView) findViewById(R.id.listMenuProduct);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent descrip = new Intent(getApplicationContext(), DescripcionProducto.class);
                descrip.putExtra("id", i + "");
                startActivity(descrip);
            }
        });
        registerForContextMenu(lista);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floatmenu, menu);
        menu.setHeaderTitle("Seleccione una A");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if (item.getItemId() == R.id.actualizar) {
            Toast.makeText(this, "actualizar" + info.position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), CrearProducto.class);
            String idDat = info.position + "";
            intent.putExtra("id", idDat);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.eliminar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MenuProductos.this);
            builder.setTitle("Eliminar Producto");
            builder.setMessage("Usted desea eliminar este producto")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            EliminarPro((info.position + 1));
                        }
                    })
                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MenuProductos.this, "OK sera para la proxima", Toast.LENGTH_SHORT).show();
                        }
                    }).show();

            return true;
        }

        return super.onContextItemSelected(item);
    }

    public void init() {
        imagesProducto = new ArrayList<>();
        lista = (ListView) findViewById(R.id.listMenuProduct);
        arrayAdapter = new AdapterImglist(this, imagesProducto);
        lista.setAdapter(arrayAdapter);
        getImgs();
    }

    public void EliminarPro(final int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProducto = retrofit.create(PostServiceProducto.class);
        Call<Producto> call = postServiceProducto.deleteProducto(id);
        Toast.makeText(MenuProductos.this, "RESPONSE" + id, Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MenuProductos.this, "Se elimino correctamente" + id, Toast.LENGTH_SHORT).show();
                    init();
                } else {
                    Toast.makeText(MenuProductos.this, "No se elimino correctamente" + id, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Toast.makeText(MenuProductos.this, "A fallado la coneccion" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
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
                    imagesProducto.add(new Producto(pro.getPro_id(),pro.getPro_foto(), pro.getPro_descripcion(), pro.getPro_costo(), pro.getPro_precio(), pro.getPro_stock(), pro.getPro_codigo_barra(), pro.getPro_marca(), pro.getPro_modelo()));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }

}