package com.agmr.mystore.AdaptingImagen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
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
import com.agmr.mystore.servicio.CnnSQLite;
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
        if (getUsuRol().equalsIgnoreCase("cliente")) {
            if (c.getCha_rol_emisor().equalsIgnoreCase("cliente")) {
                photo.setBackgroundResource(R.drawable.tu);
            } else {
                if (contacto.getFoto().contains("http")) {
                    Picasso.with(context.getApplicationContext()).load(contacto.getFoto()).error(R.mipmap.ic_launcher).fit().centerInside().into(photo);
                } else {
                    photo.setImageBitmap(StringToBitMap(contacto.getFoto()));
                }
            }
        } else {
            if (c.getCha_rol_emisor().equalsIgnoreCase("empleado")) {
                photo.setBackgroundResource(R.drawable.tu);
            } else {
                if (contacto.getFoto().contains("http")) {
                    Picasso.with(context.getApplicationContext()).load(contacto.getFoto()).error(R.mipmap.ic_launcher).fit().centerInside().into(photo);
                } else {
                    photo.setImageBitmap(StringToBitMap(contacto.getFoto()));
                }
            }
        }

        return view;
    }

    public String getUsuRol() {
        CnnSQLite cnn = new CnnSQLite(getContext());
        Cursor usuario = cnn.selectUserByStatus();

        if (usuario.getCount() > 0) {
            usuario.moveToFirst();
            return usuario.getString(4);
        } else {
            return "NA";
        }
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
