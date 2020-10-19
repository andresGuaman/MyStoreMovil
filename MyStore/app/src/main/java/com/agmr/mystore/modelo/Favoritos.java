package com.agmr.mystore.modelo;

public class Favoritos {

    private String fav_pro_id;
    private String fav_estado;
    private String usu_id;
    private String fav_descripcion;
    private String fav_precio;
    private String fav_foto;

    public Favoritos() {
    }

    public Favoritos(String fav_pro_id, String fav_estado, String usu_id, String fav_foto, String fav_descripcion, String fav_precio) {
        this.fav_pro_id = fav_pro_id;
        this.fav_estado = fav_estado;
        this.usu_id = usu_id;
        this.fav_descripcion = fav_descripcion;
        this.fav_precio = fav_precio;
        this.fav_foto = fav_foto;
    }

    public String getFav_descripcion() {
        return fav_descripcion;
    }

    public void setFav_descripcion(String fav_descripcion) {
        this.fav_descripcion = fav_descripcion;
    }

    public String getFav_precio() {
        return fav_precio;
    }

    public void setFav_precio(String fav_precio) {
        this.fav_precio = fav_precio;
    }

    public String getFav_foto() {
        return fav_foto;
    }

    public void setFav_foto(String fav_foto) {
        this.fav_foto = fav_foto;
    }


    public String getFav_pro_id() {
        return fav_pro_id;
    }

    public void setFav_pro_id(String fav_pro_id) {
        this.fav_pro_id = fav_pro_id;
    }

    public String getFav_estado() {
        return fav_estado;
    }

    public void setFav_estado(String fav_estado) {
        this.fav_estado = fav_estado;
    }

    public String getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(String usu_id) {
        this.usu_id = usu_id;
    }
}
