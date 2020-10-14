package com.agmr.mystore.modelo;

public class Favoritos {

    private int fav_id;
    private int fav_estado;
    private int fav_pro_id;
    private int usu_id;

    public Favoritos() {  }

    public Favoritos(int fav_id, int fav_estado, int fav_pro_id, int usu_id) {
        this.fav_id = fav_id;
        this.fav_estado = fav_estado;
        this.fav_pro_id = fav_pro_id;
        this.usu_id = usu_id;
    }

    public int getFav_id() {
        return fav_id;
    }

    public void setFav_usu(int fav_id) {
        this.fav_id = fav_id;
    }

    public int getFav_estado() {
        return fav_estado;
    }

    public void setFav_estado(int fav_estado) {
        this.fav_estado = fav_estado;
    }

    public int getFav_pro_id() {
        return fav_pro_id;
    }

    public void setFav_pro_id(int fav_pro_id) {
        this.fav_pro_id = fav_pro_id;
    }

    public int getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(int usu_id) {
        this.usu_id = usu_id;
    }
}
