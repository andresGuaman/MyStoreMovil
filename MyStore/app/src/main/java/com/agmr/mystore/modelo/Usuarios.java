package com.agmr.mystore.modelo;

public class Usuarios {

    private int usu_id;
    private int usu_estado;
    private int usu_per_id;

    public Usuarios() {  }

    public Usuarios(int usu_id, int usu_estado, int usu_per_id) {
        this.usu_id = usu_id;
        this.usu_estado = usu_estado;
        this.usu_per_id = usu_per_id;
    }

    public int getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }

    public int getUsu_estado() {
        return usu_estado;
    }

    public void setUsu_estado(int usu_estado) {
        this.usu_estado = usu_estado;
    }

    public int getUsu_per_id() {
        return usu_per_id;
    }

    public void setUsu_per_id(int usu_per_id) {
        this.usu_per_id = usu_per_id;
    }
}
