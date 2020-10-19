package com.agmr.mystore.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Producto {
    @SerializedName("pro_id")
    @Expose
    private long pro_id;
    @SerializedName("pro_foto")
    @Expose
    private String pro_foto;
    @SerializedName("pro_descripcion")
    @Expose
    private String pro_descripcion;
    @SerializedName("pro_costo")
    @Expose
    private double pro_costo;
    @SerializedName("pro_precio")
    @Expose
    private double pro_precio;
    @SerializedName("pro_stock")
    @Expose
    private int pro_stock;
    @SerializedName("pro_codigo_barra")
    @Expose
    private String pro_codigo_barra;
    @SerializedName("pro_marca")
    @Expose
    private String pro_marca;
    @SerializedName("pro_modelo")
    @Expose
    private String pro_modelo;

    public Producto(long pro_id, String pro_foto, String pro_descripcion, double pro_costo, double pro_precio, int pro_stock, String pro_codigo_barra, String pro_marca, String pro_modelo) {
        this.pro_id=pro_id;
        this.pro_foto = pro_foto;
        this.pro_descripcion = pro_descripcion;
        this.pro_costo = pro_costo;
        this.pro_precio = pro_precio;
        this.pro_stock = pro_stock;
        this.pro_codigo_barra = pro_codigo_barra;
        this.pro_marca = pro_marca;
        this.pro_modelo = pro_modelo;
    }

    public Producto() {
    }

    public long getPro_id() {
        return pro_id;
    }

    public void setPro_id(long pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_foto() {
        return pro_foto;
    }

    public void setPro_foto(String pro_foto) {
        this.pro_foto = pro_foto;
    }

    public String getPro_descripcion() {
        return pro_descripcion;
    }

    public void setPro_descripcion(String pro_descripcion) {
        this.pro_descripcion = pro_descripcion;
    }

    public double getPro_costo() {
        return pro_costo;
    }

    public void setPro_costo(double pro_costo) {
        this.pro_costo = pro_costo;
    }

    public double getPro_precio() {
        return pro_precio;
    }

    public void setPro_precio(double pro_precio) {
        this.pro_precio = pro_precio;
    }

    public int getPro_stock() {
        return pro_stock;
    }

    public void setPro_stock(int pro_stock) {
        this.pro_stock = pro_stock;
    }

    public String getPro_codigo_barra() {
        return pro_codigo_barra;
    }

    public void setPro_codigo_barra(String pro_codigo_barra) {
        this.pro_codigo_barra = pro_codigo_barra;
    }

    public String getPro_marca() {
        return pro_marca;
    }

    public void setPro_marca(String pro_marca) {
        this.pro_marca = pro_marca;
    }

    public String getPro_modelo() {
        return pro_modelo;
    }

    public void setPro_modelo(String pro_modelo) {
        this.pro_modelo = pro_modelo;
    }
}
