package com.agmr.mystore.modelo;

public class DetalleFactura {
    private int cantidad;
    private int descuento;
    private int iva;
    private double subtotal;
    private double valor_total;
    private double total;
    private double valor_unitario;

    public DetalleFactura(int cantidad, int descuento, int iva, double subtotal, double valor_total, double total, double valor_unitario) {
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.iva = iva;
        this.subtotal = subtotal;
        this.valor_total = valor_total;
        this.total = total;
        this.valor_unitario = valor_unitario;
    }

    public DetalleFactura() {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }
}
