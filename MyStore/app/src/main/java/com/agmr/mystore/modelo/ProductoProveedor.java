package com.agmr.mystore.modelo;

public class ProductoProveedor {
    private String estado;
    private int cantidad;

    public ProductoProveedor(String estado, int cantidad) {
        this.estado = estado;
        this.cantidad = cantidad;
    }

    public ProductoProveedor() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
