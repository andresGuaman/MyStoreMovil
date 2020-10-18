package com.agmr.mystore.modelo;

public class Chat {

    private long cha_id;
    private String cha_mensajes;
    private String cha_imagenes;

    public Chat() {  }

    public Chat(long cha_id, String cha_mensajes, String cha_imagenes) {
        this.cha_id = cha_id;
        this.cha_mensajes = cha_mensajes;
        this.cha_imagenes = cha_imagenes;
    }

    public long getCha_id() {
        return cha_id;
    }

    public void setCha_id(long cha_id) {
        this.cha_id = cha_id;
    }

    public String getCha_mensajes() {
        return cha_mensajes;
    }

    public void setCha_mensajes(String cha_mensajes) {
        this.cha_mensajes = cha_mensajes;
    }

    public String getCha_imagenes() {
        return cha_imagenes;
    }

    public void setCha_imagenes(String cha_imagenes) {
        this.cha_imagenes = cha_imagenes;
    }
}
