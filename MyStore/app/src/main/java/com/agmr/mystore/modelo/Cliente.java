package com.agmr.mystore.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class cliente {
    @SerializedName("cli_descuento")
    @Expose
    private String cli_descuento;
    @SerializedName("cli_password")
    @Expose
    private String cli_password;
    @SerializedName("cli_usuario")
    @Expose
    private String cli_usuario;

    public cliente(String cli_descuento, String cli_password, String cli_usuario) {
        this.cli_descuento = cli_descuento;
        this.cli_password = cli_password;
        this.cli_usuario = cli_usuario;
    }

    public cliente() {
    }

    public String getCli_descuento() {
        return cli_descuento;
    }

    public void setCli_descuento(String cli_descuento) {
        this.cli_descuento = cli_descuento;
    }

    public String getCli_password() {
        return cli_password;
    }

    public void setCli_password(String cli_password) {
        this.cli_password = cli_password;
    }

    public String getCli_usuario() {
        return cli_usuario;
    }

    public void setCli_usuario(String cli_usuario) {
        this.cli_usuario = cli_usuario;
    }
}


