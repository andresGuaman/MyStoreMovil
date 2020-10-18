package com.agmr.mystore.AdaptingImagen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.agmr.mystore.R;
import com.agmr.mystore.modelo.Contacto;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class AdapterImgListChat extends ArrayAdapter {

    Activity context;
    ArrayList<Contacto> datos;

    public AdapterImgListChat(Activity context, ArrayList<Contacto> datos) {
        super(context, R.layout.list_chats, datos);
        this.context = context;
        this.datos = datos;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_chats, null);

        ImageView photo = view.findViewById(R.id.imgFotoChat);
        TextView contacto = view.findViewById(R.id.txtContacto);
        TextView ultimoMensaje = view.findViewById(R.id.txtUltimoMensaje);

        Contacto c = (Contacto) datos.get(position);

        Picasso.with(context.getApplicationContext()).load(c.getFoto()).error(R.mipmap.ic_launcher).fit().centerInside().into(photo);
        contacto.setText(c.getUsuario());
        ultimoMensaje.setText((c.getUltimoMensaje()));

        return view;
    }
}
