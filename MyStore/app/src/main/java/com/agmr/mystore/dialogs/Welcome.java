package com.agmr.mystore.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import com.agmr.mystore.Login;
import com.agmr.mystore.R;
import com.agmr.mystore.RegistroUsuario;

public class Welcome extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_welcome, null);
        builder.setView(view);
        builder.setCancelable(true);
        builder.setNeutralButton("Omitir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        Button btnLogin = view.findViewById(R.id.btnLoginDialog);
        Button btnRegister = view.findViewById(R.id.btnRegisterDialog);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegistroUsuario.class);
                startActivity(intent);
            }
        });

        return builder.create();
    }
}
