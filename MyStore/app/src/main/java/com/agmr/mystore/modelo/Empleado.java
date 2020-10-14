package com.agmr.mystore.modelo;

public class Empleado {
    private String password;
            private double salario;
            private String usuario;

    public Empleado(String password, double salario, String usuario) {
        this.password = password;
        this.salario = salario;
        this.usuario = usuario;
    }

    public Empleado() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
