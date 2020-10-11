package com.agmr.mystore.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Persona {
    @SerializedName("per_apellido")
    @Expose
    private String per_apellido;
    @SerializedName("per_cedula")
    @Expose
    private String per_cedula;
    @SerializedName("per_correo")
    @Expose
    private String per_correo;
    @SerializedName("per_estado")
    @Expose
    private String per_estado;
    @SerializedName("per_foto")
    @Expose
    private String per_foto;
    @SerializedName("per_nombre")
    @Expose
    private String per_nombre;
    @SerializedName("per_telefono")
    @Expose
    private String per_telefono;
    @SerializedName("per_fecha_creacion")
    @Expose
    private String per_fecha_creacion;


    public Persona(String per_apellido,String per_fecha_creacion, String per_cedula, String per_correo, String per_estado, String per_foto, String per_nombre, String per_telefono) {
        this.per_apellido = per_apellido;
        this.per_cedula = per_cedula;
        this.per_fecha_creacion=per_fecha_creacion;
        this.per_correo = per_correo;
        this.per_estado = per_estado;
        this.per_foto = per_foto;
        this.per_nombre = per_nombre;
        this.per_telefono = per_telefono;
    }

    public Persona() {
    }


    public String getPer_fecha_creacion() {
        return per_fecha_creacion;
    }

    public void setPer_fecha_creacion(String per_fecha_creacion) {
        this.per_fecha_creacion = per_fecha_creacion;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_correo() {
        return per_correo;
    }

    public void setPer_correo(String per_correo) {
        this.per_correo = per_correo;
    }

    public String getPer_estado() {
        return per_estado;
    }

    public void setPer_estado(String per_estado) {
        this.per_estado = per_estado;
    }

    public String getPer_foto() {
        return per_foto;
    }

    public void setPer_foto(String per_foto) {
        this.per_foto = per_foto;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }
}
