package com.agmr.mystore.modelo;

import java.util.Date;

public class Persona {

    private long per_id;
    private String per_cedula;
    private String per_nombre;
    private String per_apellido;
    private String per_telefono;
    private String per_correo;
    private Date per_fecha_creacion;
    private String per_estado;
    private String per_foto;

    public Persona() {  }

    public Persona(long per_id, String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_correo, Date per_fecha_creacion, String per_estado, String per_foto) {
        this.per_id = per_id;
        this.per_cedula = per_cedula;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_telefono = per_telefono;
        this.per_correo = per_correo;
        this.per_fecha_creacion = per_fecha_creacion;
        this.per_estado = per_estado;
        this.per_foto = per_foto;
    }

    public long getPer_id() {
        return per_id;
    }

    public void setPer_id(long per_id) {
        this.per_id = per_id;
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    public String getPer_correo() {
        return per_correo;
    }

    public void setPer_correo(String per_correo) {
        this.per_correo = per_correo;
    }

    public Date getPer_fecha_creacion() {
        return per_fecha_creacion;
    }

    public void setPer_fecha_creacion(Date per_fecha_creacion) {
        this.per_fecha_creacion = per_fecha_creacion;
    }

    public String isPer_estado() {
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
}
