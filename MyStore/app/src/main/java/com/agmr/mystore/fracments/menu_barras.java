package com.agmr.mystore.fracments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.agmr.mystore.Login;
import com.agmr.mystore.MenuAdministrador;
import com.agmr.mystore.R;
import com.agmr.mystore.servicio.CnnSQLite;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link menu_barras#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menu_barras extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button iniciar_sesion, admin;
    View vista;

    public menu_barras() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static menu_barras newInstance(String param1, String param2) {
        menu_barras fragment = new menu_barras();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vista = inflater.inflate(R.layout.fragment_menu_barras, container, false);

        iniciar_sesion = (Button) vista.findViewById(R.id.btn_init_secion);
        admin = (Button) vista.findViewById(R.id.btn_admin);

        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MenuAdministrador.class);
                startActivity(intent);
            }
        });

        if (userIsRegistered()) {
            iniciar_sesion.setVisibility(View.GONE);
            if (getUsuRol().equalsIgnoreCase("cliente")) {
                admin.setVisibility(View.GONE);
            } else {
                admin.setVisibility(View.VISIBLE);
            }
        } else {
            admin.setVisibility(View.GONE);
        }

        return vista;
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

    public boolean userIsRegistered() {
        CnnSQLite cnn = new CnnSQLite(getContext());
        Cursor datos = cnn.selectUserByStatus();

        if (datos.getCount() > 0) {
            datos.moveToFirst();
        }

        return datos.getCount() > 0;
    }
}