package com.agmr.mystore.fracments;

import android.database.Cursor;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.agmr.mystore.AdaptingImagen.AdapterImgListContactos;
import com.agmr.mystore.AdaptingImagen.AdapterImgListMensajes;
import com.agmr.mystore.Local;
import com.agmr.mystore.R;
import com.agmr.mystore.modelo.Chat;
import com.agmr.mystore.modelo.Contacto;
import com.agmr.mystore.servicio.CnnSQLite;
import com.agmr.mystore.servicio.PostServiceChat;
import com.squareup.picasso.Picasso;

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
 * Use the {@link mensajes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mensajes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    private static Contacto contacto;
    private ListView lvMessages;
    private ArrayList<Chat> messagesList;
    private ArrayAdapter arrayAdapter;
    private EditText txtMensaje;

    public mensajes(Contacto contacto) {
        mensajes.contacto = contacto;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mensajes.
     */
    // TODO: Rename and change types and number of parameters
    public static mensajes newInstance(String param1, String param2) {
        mensajes fragment = new mensajes(contacto);
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
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mensajes, container, false);
        init();
        return view;
    }

    public void init() {
        ImageView imgContacto = view.findViewById(R.id.imgContactoMensaje);
        TextView txtContactoNombre = view.findViewById(R.id.txtContactoNombre);
        ImageButton btnRegresar = view.findViewById(R.id.btnRegresarToContacts);
        ImageButton btnSend = view.findViewById(R.id.btnSendMensaje);
        txtMensaje = view.findViewById(R.id.txtMensajeSend);

        txtContactoNombre.setText(contacto.getUsuario());
        Picasso.with(getContext()).load(contacto.getFoto()).error(R.mipmap.ic_launcher).fit().centerInside().into(imgContacto);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new chats()).commit();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        messagesList = new ArrayList<>();
        lvMessages = view.findViewById(R.id.lvMensajes);
        arrayAdapter = new AdapterImgListMensajes(mensajes.super.getActivity(), messagesList, contacto);
        lvMessages.setAdapter(arrayAdapter);
        getMessages();
    }

    public void getMessages() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
        PostServiceChat service = retrofit.create(PostServiceChat.class);

        Call<List<Chat>> call = service.getAllChatsByCliEmpIds(contacto.getCli_id(), contacto.getEmp_id());
        call.enqueue(new Callback<List<Chat>>() {
            @Override
            public void onResponse(Call<List<Chat>> call, Response<List<Chat>> response) {

                if (response.isSuccessful()) {
                    assert response.body() != null;

                    messagesList.clear();
                    for (Chat c:response.body()) {
                        messagesList.add(new Chat(c.getCha_id(), c.getCha_mensajes(), c.getCha_imagenes(), c.getCha_rol_emisor()));
                    }
                    arrayAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<List<Chat>> call, Throwable t) {  }
        });
    }

    public void sendMessage() {
        if (getUsuRol().equalsIgnoreCase("cliente")) {
            if (!txtMensaje.getText().toString().trim().isEmpty()) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
                PostServiceChat service = retrofit.create(PostServiceChat.class);
                Chat chat = new Chat(0, txtMensaje.getText().toString(), "NA", "cliente");
                Call<Chat> call = service.insertChat(chat, contacto.getCli_id(), contacto.getEmp_id());
                call.enqueue(new Callback<Chat>() {
                    @Override
                    public void onResponse(Call<Chat> call, Response<Chat> response) {

                        if (response.isSuccessful()) {
                            Chat chat = response.body();
                            if (chat != null) {
                                txtMensaje.setText("");
                                getMessages();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<Chat> call, Throwable t) {
                    }
                });
            } else {
                Toast.makeText(getContext(), "Campo Vacío", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (!txtMensaje.getText().toString().trim().isEmpty()) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl(Local.IP_SERVER).addConverterFactory(GsonConverterFactory.create()).build();
                PostServiceChat service = retrofit.create(PostServiceChat.class);
                Chat chat = new Chat(0, txtMensaje.getText().toString(), "NA", "empleado");
                Call<Chat> call = service.insertChat(chat, contacto.getCli_id(), contacto.getEmp_id());
                call.enqueue(new Callback<Chat>() {
                    @Override
                    public void onResponse(Call<Chat> call, Response<Chat> response) {

                        if (response.isSuccessful()) {
                            Chat chat = response.body();
                            if (chat != null) {
                                txtMensaje.setText("");
                                getMessages();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<Chat> call, Throwable t) {
                    }
                });
            } else {
                Toast.makeText(getContext(), "Campo Vacío", Toast.LENGTH_SHORT).show();
            }
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
}