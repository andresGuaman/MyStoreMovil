package com.agmr.mystore.modelo;

public class EncabezadoFactura {
    private  double descuento;
    private String fecha;
    private double iva;
    private  double subtotal;
    private double total;

    public EncabezadoFactura(double descuento, String fecha, double iva, double subtotal, double total) {
        this.descuento = descuento;
        this.fecha = fecha;
        this.iva = iva;
        this.subtotal = subtotal;
        this.total = total;
    }

    public EncabezadoFactura() {
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
