package com.agmr.mystore.modelo;

public class detalleCarrito {
    private int cantidad;
    private int descuento;
    private int iva;
    private double subtotal;
    private double valor_total;
    private double valor_unitario;

    public detalleCarrito(int cantidad, int descuento, int iva, double subtotal, double valor_total, double valor_unitario) {
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.iva = iva;
        this.subtotal = subtotal;
        this.valor_total = valor_total;
        this.valor_unitario = valor_unitario;
    }

    public detalleCarrito() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
}
