package com.agmr.mystore.modelo;

public class Empleado {

    private long emp_id;
    private double emp_salario;
    private String emp_usuario;
    private String emp_password;
    private long per_id;
    private long rol_id;

    public Empleado() {  }

    public Empleado(long emp_id, double emp_salario, String emp_usuario, String emp_password, long per_id, long rol_id) {
        this.emp_id = emp_id;
        this.emp_salario = emp_salario;
        this.emp_usuario = emp_usuario;
        this.emp_password = emp_password;
        this.per_id = per_id;
        this.rol_id = rol_id;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public double getEmp_salario() {
        return emp_salario;
    }

    public void setEmp_salario(double emp_salario) {
        this.emp_salario = emp_salario;
    }

    public String getEmp_usuario() {
        return emp_usuario;
    }

    public void setEmp_usuario(String emp_usuario) {
        this.emp_usuario = emp_usuario;
    }

    public String getEmp_password() {
        return emp_password;
    }

    public void setEmp_password(String emp_password) {
        this.emp_password = emp_password;
    }

    public long getPer_id() {
        return per_id;
    }

    public void setPer_id(long per_id) {
        this.per_id = per_id;
    }

    public long getRol_id() {
        return rol_id;
    }

    public void setRol_id(long rol_id) {
        this.rol_id = rol_id;
    }
}
