package com.agmr.mystore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.agmr.mystore.dialogs.Welcome;
import com.agmr.mystore.fracments.chats;
import com.agmr.mystore.fracments.favoritos;
import com.agmr.mystore.fracments.lista_productos;
import com.agmr.mystore.fracments.menu_barras;
import com.agmr.mystore.fracments.notificaciones;
import com.agmr.mystore.servicio.CnnSQLite;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuPrincipal extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        bottomNavigationView = findViewById(R.id.nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(naviListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new lista_productos()).commit();

        if (!userIsRegistered()) {
            Welcome welcome = new Welcome();
            welcome.setCancelable(false);
            welcome.show(getSupportFragmentManager(), "Buen día");
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectorFracment = null;
            switch (item.getItemId()) {
                case R.id.inicio_product:
                    selectorFracment = new lista_productos();
                    break;
                case R.id.mensage:
                    if (userIsRegistered()) {
                        selectorFracment = new chats();
                    } else {
                        selectorFracment = new NonRegistered();
                    }
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
            assert selectorFracment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectorFracment).commit();
            return true;
        }
    };

    public boolean userIsRegistered() {
        CnnSQLite cnn = new CnnSQLite(getApplicationContext());
        Cursor datos = cnn.selectUserByStatus();

        if (datos.getCount() > 0) {
            datos.moveToFirst();
        }

        return datos.getCount() > 0;
    }
}
