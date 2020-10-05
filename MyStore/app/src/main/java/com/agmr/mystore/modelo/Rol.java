package com.agmr.mystore.modelo;

public class Rol {
    private String departamento;
    private String estado;
    private String nombre;

    public Rol(String departamento, String estado, String nombre) {
        this.departamento = departamento;
        this.estado = estado;
        this.nombre = nombre;
    }

    public Rol() {
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
