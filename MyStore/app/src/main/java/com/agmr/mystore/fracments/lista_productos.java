package com.agmr.mystore.fracments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.agmr.mystore.AdaptingImagen.AdapterImglist;
import com.agmr.mystore.DescripcionProducto;
import com.agmr.mystore.R;
import com.agmr.mystore.modelo.Producto;
import com.agmr.mystore.servicio.PostServiceProducto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link lista_productos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class lista_productos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private ListView listaDatos;
    private ArrayList<Producto> imagesProducto;
    private ArrayAdapter arrayAdapter;
    View vista;

    private String mParam1;
    private String mParam2;

    public lista_productos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment lista_productos.
     */
    // TODO: Rename and change types and number of parameters
    public static lista_productos newInstance(String param1, String param2) {
        lista_productos fragment = new lista_productos();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_lista_productos, container, false);
        init();
        listaDatos = (ListView) vista.findViewById(R.id.lstMenuPrincipal);
       listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent=new Intent(getContext(), DescripcionProducto.class);
               intent.putExtra("id",i+"");
               startActivity(intent);
           }
       });
        return vista;
    }

    public void init() {
        imagesProducto = new ArrayList<>();
        listaDatos = (ListView) vista.findViewById(R.id.lstMenuPrincipal);
        arrayAdapter = new AdapterImglist(lista_productos.super.getActivity(), imagesProducto);
        listaDatos.setAdapter(arrayAdapter);
        getImgs();
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
                    imagesProducto.add(new Producto(pro.getPro_id(), pro.getPro_foto(), pro.getPro_descripcion(), pro.getPro_costo(), pro.getPro_precio(), pro.getPro_stock(), pro.getPro_codigo_barra(), pro.getPro_marca(), pro.getPro_modelo()));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });
    }


}