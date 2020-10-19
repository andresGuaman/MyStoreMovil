package com.agmr.mystore.fracments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.agmr.mystore.AdaptingImagen.AdapterImglist;
import com.agmr.mystore.DescripcionProducto;
import com.agmr.mystore.R;
import com.agmr.mystore.modelo.Favoritos;
import com.agmr.mystore.servicio.CnnSQLite;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link favoritos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class favoritos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView listaf;
    private ArrayAdapter<Favoritos> datosfavoritos;
    private ArrayAdapter arrayAdapter;
    String ocultabtn;
    View vista;
    View vista1;
    Context context;
    private TextView datoFalos;

    public favoritos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment favoritos.
     */
    // TODO: Rename and change types and number of parameters
    public static favoritos newInstance(String param1, String param2) {
        favoritos fragment = new favoritos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_favoritos, container, false);
        String esconde = "esconde";
        final CnnSQLite conectar = new CnnSQLite(getContext());
         Cursor cursor = conectar.selectFavouritesDETALL();

        ImageView imga=(ImageView)vista.findViewById(R.id.img_producto);
        final ListView listass = (ListView) vista.findViewById(R.id.lista_favoritos);

        String[] desde = new String[]{"fav_id","fav_pro_id", "fav_fot", "fav_des", "fav_precio"};
        int[] hasta = new int[]{R.id.txt_datoFalso,R.id.txt_idProductoList,R.id.img_producto, R.id.txt_descrip, R.id.txt_precio};
        final CursorAdapter adapter = new SimpleCursorAdapter(getContext(),
                R.layout.list_productos, cursor, desde, hasta, 0);
        listass.setAdapter(adapter);



       listass.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               Cursor cursor1=(Cursor)listass.getItemAtPosition(i);
               String idprod=cursor1.getString(0);
               Boolean mensaje=conectar.deleteFavourite(idprod);
               if (mensaje==true){
                   adapter.swapCursor(conectar.selectFavouritesDETALL());
                   listass.setAdapter(adapter);
                   Toast.makeText(getContext(),"Producto eliminado"+mensaje,Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getContext(),"No se elimino el producto"+mensaje,Toast.LENGTH_SHORT).show();
               }

               return false;
           }
       });
        listass.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor2=(Cursor)listass.getItemAtPosition(i);
                String iddatos=cursor2.getString(0);
                Intent intent = new Intent(getContext(),DescripcionProducto.class);
                intent.putExtra("id",iddatos);
            }
        });



        return vista;
    }
}