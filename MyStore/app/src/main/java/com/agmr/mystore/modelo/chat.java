package com.agmr.mystore.modelo;

public class chat {
    private String imagenes;
    private String mensaje;

    public chat(String imagenes, String mensaje) {
        this.imagenes = imagenes;
        this.mensaje = mensaje;
    }

    public chat() {
    }

    public String getImagenes() {
        return imagenes;
    }

    public void setImagenes(String imagenes) {
        this.imagenes = imagenes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
