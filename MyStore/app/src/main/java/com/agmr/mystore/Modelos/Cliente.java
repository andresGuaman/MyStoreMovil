package com.agmr.mystore.Modelos;

public class Cliente {

    private long id;
    private double descuento;
    private String usuario;
    private String password;
    private long perId;

    public Cliente(long id, double descuento, String usuario, String password, long perId) {
        this.id = id;
        this.descuento = descuento;
        this.usuario = usuario;
        this.password = password;
        this.perId = perId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPerId() {
        return perId;
    }

    public void setPerId(long perId) {
        this.perId = perId;
    }
}