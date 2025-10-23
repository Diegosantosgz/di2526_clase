package com.jdojo.binding;

public class Ejercicio11  {


    public static void main(String[] args) {
        Coche coche = new Coche();
        coche.setMarca("Ford");
       System.out.println("La marca del coche es: " + coche.getMarca());
        coche.setVelocidad(50);
        coche.acelerar(20);
        System.out.println("La velocidad del coche es: " + coche.getVelocidad());


    }
}
