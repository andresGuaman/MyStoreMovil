package com.agmr.mystore.fracments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.agmr.mystore.AdapterImg;
import com.agmr.mystore.R;
import com.agmr.mystore.modelo.producto;
import com.agmr.mystore.service.PostServiceProducto;

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
    private ListView lvImgen;
    private ArrayList<producto> imagesProduco;
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
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_lista_productos, container, false);
        init();
        return vista;
    }

    public void init() {
        imagesProduco = new ArrayList<>();
        lvImgen = vista.findViewById(R.id.list_productos_menu);
        arrayAdapter = new AdapterImg(lista_productos.super.getActivity(), imagesProduco);
        lvImgen.setAdapter(arrayAdapter);
        getImgs();
    }

    public void getImgs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.1:9898")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final PostServiceProducto postServiceProducto = retrofit.create(PostServiceProducto.class);
        Call<List<producto>> call = postServiceProducto.getProducto();
        call.enqueue(new Callback<List<producto>>() {
            @Override
            public void onResponse(Call<List<producto>> call, Response<List<producto>> response) {
                assert response.body() != null;
                for (producto pro : response.body()) {
                    imagesProduco.add(new producto(pro.getPro_foto(), pro.getPro_descripcion(), pro.getPro_costo(), pro.getPro_precio(), pro.getPro_stock(), pro.getPro_codigo_barra(), pro.getPro_marca(), pro.getPro_modelo()));
                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<producto>> call, Throwable t) {

            }
        });

    }


}