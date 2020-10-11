package com.agmr.mystore.modelo;

public class empleado {
    private String password;
            private double salario;
            private String usuario;

    public empleado(String password, double salario, String usuario) {
        this.password = password;
        this.salario = salario;
        this.usuario = usuario;
    }

    public empleado() {
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
