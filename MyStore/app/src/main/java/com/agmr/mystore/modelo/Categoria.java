package com.agmr.mystore.modelo;

public class categoria {
    private String categoria;
    private String color;
    private int edad;
    private String genero;
    private String marca;

    public categoria(String categoria, String color, int edad, String genero, String marca) {
        this.categoria = categoria;
        this.color = color;
        this.edad = edad;
        this.genero = genero;
        this.marca = marca;
    }

    public categoria() {

    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
