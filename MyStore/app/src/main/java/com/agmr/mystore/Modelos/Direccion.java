package com.agmr.mystore.Modelos;

public class Direccion {

    private long id;
    private String cuidad;
    private String calle1;
    private String calle2;
    private String referencia;
    private String postal;
    private String latitud;
    private String longitud;
    private long perId;

    public Direccion(long id, String cuidad, String calle1, String calle2, String referencia, String postal, String latitud, String longitud, long perId) {
        this.id = id;
        this.cuidad = cuidad;
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.referencia = referencia;
        this.postal = postal;
        this.latitud = latitud;
        this.longitud = longitud;
        this.perId = perId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public long getPerId() {
        return perId;
    }

    public void setPerId(long perId) {
        this.perId = perId;
    }
}
