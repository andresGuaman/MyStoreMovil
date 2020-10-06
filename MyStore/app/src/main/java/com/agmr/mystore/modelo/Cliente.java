package com.agmr.mystore.modelo;

public class Cliente {

    private long cli_id;
    private double cli_descuento;
    private String cli_usuario;
    private String cli_password;
    private long per_id;

    public Cliente() {  }

    public Cliente(long cli_id, double cli_descuento, String cli_usuario, String cli_password, long per_id) {
        this.cli_id = cli_id;
        this.cli_descuento = cli_descuento;
        this.cli_usuario = cli_usuario;
        this.cli_password = cli_password;
        this.per_id = per_id;
    }

    public long getCli_id() {
        return cli_id;
    }

    public void setCli_id(long cli_id) {
        this.cli_id = cli_id;
    }

    public double getCli_descuento() {
        return cli_descuento;
    }

    public void setCli_descuento(double cli_descuento) {
        this.cli_descuento = cli_descuento;
    }

    public String getCli_usuario() {
        return cli_usuario;
    }

    public void setCli_usuario(String cli_usuario) {
        this.cli_usuario = cli_usuario;
    }

    public String getCli_password() {
        return cli_password;
    }

    public void setCli_password(String cli_password) {
        this.cli_password = cli_password;
    }

    public long getPer_id() {
        return per_id;
    }

    public void setPer_id(long per_id) {
        this.per_id = per_id;
    }
}