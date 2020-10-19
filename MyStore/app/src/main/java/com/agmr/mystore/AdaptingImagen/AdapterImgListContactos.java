package com.agmr.mystore.AdaptingImagen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
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

public class AdapterImgListContactos extends ArrayAdapter {

    Activity context;
    ArrayList<Contacto> datos;

    public AdapterImgListContactos(Activity context, ArrayList<Contacto> datos) {
        super(context, R.layout.list_contactos, datos);
        this.context = context;
        this.datos = datos;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.list_contactos, null);

        ImageView photo = view.findViewById(R.id.imgFotoChat);
        TextView contacto = view.findViewById(R.id.txtContacto);
        TextView ultimoMensaje = view.findViewById(R.id.txtUltimoMensaje);

        Contacto c = (Contacto) datos.get(position);

        if (c.getFoto().contains("http")) {
            Picasso.with(context.getApplicationContext()).load(c.getFoto()).error(R.mipmap.ic_launcher).fit().centerInside().into(photo);
        } else {
            photo.setImageBitmap(StringToBitMap(c.getFoto()));
        }
        contacto.setText(c.getUsuario());
        ultimoMensaje.setText((c.getUltimoMensaje()));

        return view;
    }

    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
