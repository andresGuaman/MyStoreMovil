package com.agmr.mystore.AdaptingImagen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.agmr.mystore.R;
import com.agmr.mystore.modelo.Chat;
import com.agmr.mystore.modelo.Contacto;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class AdapterImgListMensajes extends ArrayAdapter {

    Activity context;
    ArrayList<Chat> datos;
    Contacto contacto;

    public AdapterImgListMensajes(Activity context, ArrayList<Chat> datos, Contacto contacto) {
        super(context, R.layout.list_contactos, datos);
        this.context = context;
        this.datos = datos;
        this.contacto = contacto;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_mensajes, null);

        ImageView photo = view.findViewById(R.id.imgFotoChat);
        TextView mensaje = view.findViewById(R.id.txtMensajes);
        LinearLayout containerMenssage = view.findViewById(R.id.contaiderMensajes);

        photo.setBackground(null);
        photo.setImageDrawable(null);

        Chat c = (Chat) datos.get(position);

        mensaje.setText(c.getCha_mensajes());
        if (c.getCha_rol_emisor().equalsIgnoreCase("cliente")) {
            photo.setBackgroundResource(R.drawable.tu);
        } else {
            Picasso.with(context.getApplicationContext()).load(contacto.getFoto()).error(R.mipmap.ic_launcher).fit().centerInside().into(photo);
        }

        return view;
    }
}
