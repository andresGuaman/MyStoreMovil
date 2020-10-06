package com.agmr.mystore.modelo;

public class Chat {
    private String imagenes;
    private String mensaje;

    public Chat(String imagenes, String mensaje) {
        this.imagenes = imagenes;
        this.mensaje = mensaje;
    }

    public Chat() {
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
