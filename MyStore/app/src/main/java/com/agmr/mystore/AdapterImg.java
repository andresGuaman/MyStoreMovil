package com.agmr.mystore;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.agmr.mystore.modelo.producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterImg extends ArrayAdapter {

    Activity context;
    ArrayList<producto> datos;

    public AdapterImg(Activity context, ArrayList<producto> datos) {
        super(context, R.layout.list_productos, datos);
        this.context = context;
        this.datos = datos;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_productos, null);

        ImageView imagenProduct = view.findViewById(R.id.Img_produ_list);
        TextView descripcionProduc = view.findViewById(R.id.txt_descrip_list);
        TextView precioProduc = view.findViewById(R.id.txt_precio_list);
        TextView modeloProd = view.findViewById(R.id.txt_modelo_list);
        TextView marcaProd = view.findViewById(R.id.txt_marca_list);

        producto i = (producto) datos.get(position);
        Picasso.with(context.getApplicationContext()).load(i.getPro_foto()).error(R.mipmap.ic_launcher).fit().centerInside().into(imagenProduct);
        descripcionProduc.setText(i.getPro_descripcion());
        precioProduc.setText("US$" + (i.getPro_precio()));
        modeloProd.setText(i.getPro_modelo());
        marcaProd.setText(i.getPro_marca());
        return view;
    }
}
