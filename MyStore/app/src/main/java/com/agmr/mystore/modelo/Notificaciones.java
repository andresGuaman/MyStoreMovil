package com.agmr.mystore.modelo;

public class Notificaciones {

    private int not_id;
    private String not_mensaje;
    private int not_estado;
    private int not_pro_id;
    private int usu_id;

    public Notificaciones() {  }

    public Notificaciones(int not_id, String not_mensaje, int not_estado, int not_pro_id, int usu_id) {
        this.not_id = not_id;
        this.not_mensaje = not_mensaje;
        this.not_estado = not_estado;
        this.not_pro_id = not_pro_id;
        this.usu_id = usu_id;
    }

    public int getNot_id() {
        return not_id;
    }

    public void setNot_id(int not_id) {
        this.not_id = not_id;
    }

    public String getNot_mensaje() {
        return not_mensaje;
    }

    public void setNot_mensaje(String not_mensaje) {
        this.not_mensaje = not_mensaje;
    }

    public int getNot_estado() {
        return not_estado;
    }

    public void setNot_estado(int not_estado) {
        this.not_estado = not_estado;
    }

    public int getNot_pro_id() {
        return not_pro_id;
    }

    public void setNot_pro_id(int not_pro_id) {
        this.not_pro_id = not_pro_id;
    }

    public int getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }
}
