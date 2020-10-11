package com.agmr.mystore.modelo;

public class proveedor {
    private String empresa;
    private String ruc;

    public proveedor(String empresa, String ruc) {
        this.empresa = empresa;
        this.ruc = ruc;
    }

    public proveedor() {
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}
