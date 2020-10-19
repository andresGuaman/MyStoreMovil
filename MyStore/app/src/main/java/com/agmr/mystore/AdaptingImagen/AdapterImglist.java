package com.agmr.mystore.AdaptingImagen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.agmr.mystore.R;
import com.agmr.mystore.modelo.Favoritos;
import com.agmr.mystore.modelo.Producto;
import com.agmr.mystore.servicio.CnnSQLite;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterImglist extends ArrayAdapter {
    Activity context;
    ArrayList<Producto> datos;


    public AdapterImglist(Activity context, ArrayList<Producto> datos) {
        super(context, R.layout.list_productos, datos);
        this.context = context;
        this.datos = datos;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_productos, null);

        ImageView imagenProducto = view.findViewById(R.id.img_producto);
        TextView descripcion = view.findViewById(R.id.txt_descrip);
        TextView precio = view.findViewById(R.id.txt_precio);
        TextView idProd=view.findViewById(R.id.txt_datoFalso);
         final Producto i = (Producto) datos.get(position);

        Picasso.with(context.getApplicationContext()).load(i.getPro_foto()).error(R.mipmap.ic_launcher).fit().centerInside().into(imagenProducto);
        descripcion.setText(i.getPro_descripcion());
        precio.setText("USD$" + i.getPro_precio());
        idProd.setText(i.getPro_id()+"");


        FloatingActionButton favorit=(FloatingActionButton)view.findViewById(R.id.btn_favorit);
        FloatingActionButton carrit=(FloatingActionButton)view.findViewById(R.id.btn_carrit);
        favorit.setOnClickListener(new View.OnClickListener() {
       final CnnSQLite conectar=new CnnSQLite(getContext());
            @Override
            public void onClick(View view) {
                String idF=i.getPro_id()+"";
                String estado="1";
                String idUSU="1";
                String fotoss=i.getPro_foto();
                String descrip=i.getPro_descripcion();
                String prec=i.getPro_precio()+"";

                Favoritos favoritos=new Favoritos(idF, estado, idUSU, fotoss, descrip, prec);
                Boolean mensaje=conectar.insertFavourite(favoritos);
                if(mensaje==true){
                    Toast.makeText(getContext(),"Se agrego a favoritos",Toast.LENGTH_SHORT).show();
                 }
            }
        });
        carrit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String idF=i.getPro_id()+"";


                Toast.makeText(getContext(),"carrito"+idF,Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }
}
