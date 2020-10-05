package com.agmr.mystore.modelo;

public class direccion {

    private String calle1;
    private String calle2;
    private String ciudad;
    private String latitud;
    private String logitud;
    private String referencia;

    public direccion(String calle1, String calle2, String ciudad, String latitud, String logitud, String referencia) {
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.ciudad = ciudad;
        this.latitud = latitud;
        this.logitud = logitud;
        this.referencia = referencia;
    }

    public direccion() {
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLogitud() {
        return logitud;
    }

    public void setLogitud(String logitud) {
        this.logitud = logitud;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
