package com.jdojo.binding;

public class Coche {

    // CLASE COCHE DEL EJERCICIO 11 (CREACIÓN DE UNA CLASE COCHE CON PROPIEDADES)

    private String marca;
    private int velocidad;

    public Coche() {

    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void acelerar(int aumento) {
      velocidad = velocidad + aumento;

    }
}
