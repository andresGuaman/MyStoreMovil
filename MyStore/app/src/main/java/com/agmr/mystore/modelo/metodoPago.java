package com.agmr.mystore.modelo;

public class metodoPago {
    private String metodo;
    private String nro_tarjeta;
            private String tipo;

    public metodoPago(String metodo, String nro_tarjeta, String tipo) {
        this.metodo = metodo;
        this.nro_tarjeta = nro_tarjeta;
        this.tipo = tipo;
    }

    public metodoPago() {
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
