package com.agmr.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;

import com.agmr.mystore.fracments.favoritos;
import com.agmr.mystore.fracments.lista_productos;
import com.agmr.mystore.fracments.mensajes;
import com.agmr.mystore.fracments.menu_barras;
import com.agmr.mystore.fracments.notificaciones;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuPrincipal extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(naviListener);
        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_container, new lista_productos()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectorFracment = null;
                    switch (item.getItemId()) {
                        case R.id.inicio_product:
                            selectorFracment = new lista_productos();
                            break;
                        case R.id.mensage:
                            selectorFracment = new mensajes();
                            break;
                        case R.id.favoritos:
                            selectorFracment = new favoritos();
                            break;
                        case R.id.notificaciones:
                            selectorFracment = new notificaciones();
                            break;
                        case R.id.barras:
                            selectorFracment = new menu_barras();
                    }
                    getSupportFragmentManager().beginTransaction().replace(
                            R.id.fragment_container,
                            selectorFracment).commit();
                    return true;
                }

            };
}
