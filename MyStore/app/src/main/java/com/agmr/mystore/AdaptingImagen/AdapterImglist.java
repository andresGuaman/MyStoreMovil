package com.agmr.mystore.AdaptingImagen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.agmr.mystore.R;
import com.agmr.mystore.modelo.Producto;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_productos, null);
        ImageView imagenProducto = view.findViewById(R.id.img_producto);
        TextView descripcion = view.findViewById(R.id.txt_descrip);
        TextView precio = view.findViewById(R.id.txt_precio);
        Producto i = (Producto) datos.get(position);
        Picasso.with(context.getApplicationContext()).load(i.getPro_foto()).error(R.mipmap.ic_launcher).fit().centerInside().into(imagenProducto);
        descripcion.setText(i.getPro_descripcion());
        precio.setText("US$" + i.getPro_precio());
        return view;
    }
}
