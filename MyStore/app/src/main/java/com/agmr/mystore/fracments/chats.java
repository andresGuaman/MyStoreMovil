package com.agmr.mystore.fracments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.agmr.mystore.AdaptingImagen.AdapterImgListContactos;
import com.agmr.mystore.Local;
import com.agmr.mystore.R;
import com.agmr.mystore.modelo.Chat;
import com.agmr.mystore.modelo.Cliente;
import com.agmr.mystore.modelo.Contacto;
import com.agmr.mystore.modelo.Empleado;
import com.agmr.mystore.modelo.Persona;
import com.agmr.mystore.servicio.ClienteServicio;
import com.agmr.mystore.servicio.CnnSQLite;
import com.agmr.mystore.servicio.PersonaServicio;
import com.agmr.mystore.servicio.PostServiceChat;
import com.agmr.mystore.servicio.PostServiceEmpleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link chats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class chats extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView lvChats;
    private ArrayList<Contacto> contactsList;
    private ArrayAdapter arrayAdapter;
    private View view;
    private long cli_id;
    private long emp_id;

    public chats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Chats.
     */
    // TODO: Rename and change types and number of parameters
    public static chats newInstance(String param1, String param2) {
        chats fragment = new chats();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_chats, container, false);
        init();
        Thread refresh = new Refresh();
        //refresh.start();
        return view;
    }

    public void init() {

        cli_id = getPerId();
        emp_id = getPerId();
        contactsList = new ArrayList<>();
        lvChats = view.findViewById(R.id.lvChats);
        arrayAdapter = new AdapterImgListContactos(chats.super.getActivity(), contactsList);
        lvChats.setAdapter(arrayAdapter);
        getImgs();

        lvChats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new mensajes(contactsList.get(position))).commit();
            }
        });
    }

    public void getImgs() {
        if (getUsuRol().equalsIgnoreCase("cliente")) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
            PersonaServicio service = retrofit.create(PersonaServicio.class);
            Call<List<Persona>> call = service.getContactsByClientId(this.cli_id);

            call.enqueue(new Callback<List<Persona>>() {
                @Override
                public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {

                    assert response.body() != null;
                    for (Persona p : response.body()) {
                        contactsList.add(new Contacto(p.getPer_id(), 0, cli_id, p.getPer_foto(), "", ""));
                        addEmployeeDates(p.getPer_id());
                    }
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<Persona>> call, Throwable t) {
                }
            });
        } else if (getUsuRol().equalsIgnoreCase("empleado")) {

            Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
            PersonaServicio service = retrofit.create(PersonaServicio.class);
            Call<List<Persona>> call = service.getContactsByEmployeeId(this.emp_id);

            call.enqueue(new Callback<List<Persona>>() {
                @Override
                public void onResponse(Call<List<Persona>> call, Response<List<Persona>> response) {

                    if(response.isSuccessful()) {
                        assert response.body() != null;
                        for (Persona p : response.body()) {
                            contactsList.add(new Contacto(p.getPer_id(), emp_id, 0, p.getPer_foto(), "", ""));
                            addClientDates(p.getPer_id());
                        }
                        arrayAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getContext(),"Error 3", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<List<Persona>> call, Throwable t) {
                    Toast.makeText(getContext(),"Error 4", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void addEmployeeDates(final long per_id) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
        PostServiceEmpleado service = retrofit.create(PostServiceEmpleado.class);
        Call<Empleado> call = service.getEmpleadoByPersonaId(per_id);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (response.isSuccessful()) {
                    Empleado empleado = response.body();
                    if (empleado != null) {
                        for (int i = 0; i < contactsList.size(); i++) {
                            if (contactsList.get(i).getPer_id() == per_id) {
                                contactsList.get(i).setUsuario(empleado.getEmp_usuario());
                                contactsList.get(i).setEmp_id(empleado.getEmp_id());
                            }
                        }
                        addChatsDates(cli_id, empleado.getEmp_id());
                        //arrayAdapter.notifyDataSetChanged();
                    }
                }
            }
            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {  }
        });
    }

    private void addClientDates(final long per_id) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
        ClienteServicio service = retrofit.create(ClienteServicio.class);
        Call<Cliente> call = service.getClienteByPersonaId(per_id);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                if (response.isSuccessful()) {
                    Cliente cliente = response.body();
                    if (cliente != null) {
                        for (int i = 0; i < contactsList.size(); i++) {
                            if (contactsList.get(i).getPer_id() == per_id) {
                                contactsList.get(i).setUsuario(cliente.getCli_usuario());
                                contactsList.get(i).setCli_id(cliente.getCli_id());
                            }
                        }
                        addChatsDates(cliente.getCli_id(), emp_id);
                    }
                }
            }
            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {  }
        });
    }

    private void addChatsDates(final long cli_id, final long emp_id) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
        PostServiceChat service = retrofit.create(PostServiceChat.class);

        Call<Chat> call = service.getChatByCliEmpIds(cli_id, emp_id);
        call.enqueue(new Callback<Chat>() {
            @Override
            public void onResponse(Call<Chat> call, Response<Chat> response) {

                if (response.isSuccessful()) {
                    Chat chat = response.body();
                    if (chat != null) {
                        for (int i = 0; i < contactsList.size(); i++) {
                            if (contactsList.get(i).getCli_id() == cli_id && contactsList.get(i).getEmp_id() == emp_id) {
                                contactsList.get(i).setUltimoMensaje(chat.getCha_mensajes());
                            }
                        }
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
            }
            @Override
            public void onFailure(Call<Chat> call, Throwable t) {  }
        });
    }

    public long getPerId() {
        CnnSQLite cnn = new CnnSQLite(getContext());
        Cursor usuario = cnn.selectUserByStatus();

        if (usuario.getCount() > 0) {
            usuario.moveToFirst();
            return (long) usuario.getInt(3);
        } else {
            return -1;
        }
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

    class Refresh extends Thread {

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getImgs();
        }
    }
}