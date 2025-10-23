package com.jdojo.binding;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class FluentTest {

    public static void main(String[] args) {

        // Crear unha propiedade para o radio

        DoubleProperty radius = new SimpleDoubleProperty(7.0);

        // Crear un binding que concatene método multiply() para a formula r.r.PI

        // Creamos un DoubleBinding que calcula a área.
        // Observa como se encadean os métodos .multiply().
        DoubleBinding area = radius.multiply(radius).multiply(Math.PI);

        // Mostrar o resultado
        System.out.println("Radio = " + radius.get() + ", Área = " + area.get());

        // Cambiar o radio
        radius.set(14.0);

        // Mostrar o resultado
        System.out.println("Radio = " + radius.get() + ", Área = " + area.get());
    }
}
