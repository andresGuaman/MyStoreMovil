package com.agmr.mystore.modelo;

public class Contacto {

    private long per_id;
    private long emp_id;
    private long cli_id;
    private String foto;
    private String usuario;
    private String ultimoMensaje;

    public  Contacto() {  }

    public Contacto(long per_id, long emp_id, long cli_id, String foto, String usuario, String ultimoMensaje) {
        this.per_id = per_id;
        this.emp_id = emp_id;
        this.cli_id = cli_id;
        this.foto = foto;
        this.usuario = usuario;
        this.ultimoMensaje = ultimoMensaje;
    }

    public long getPer_id() {
        return per_id;
    }

    public void setPer_id(long per_id) {
        this.per_id = per_id;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public long getCli_id() {
        return cli_id;
    }

    public void setCli_id(long cli_id) {
        this.cli_id = cli_id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUltimoMensaje() {
        return ultimoMensaje;
    }

    public void setUltimoMensaje(String ultimoMensaje) {
        this.ultimoMensaje = ultimoMensaje;
    }
}
