package com.jdojo.binding;

import javafx.beans.property.ReadOnlyProperty;

public class Ejercicio13_StudentTest {

    // CREACIÓN DE UNA CLASE CON PROPIEDADES JAVAFX
    
    public static void printDetails(ReadOnlyProperty<?> p){
        String nome = p.getName();
        Object value = p.getValue();
        Object bean = p.getBean();
        String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
        String propClassName = p.getClass().getSimpleName();

        System.out.print(propClassName);
        System.out.print("[Nome:]" + nome);
        System.out.print(", Bean Class:" + beanClassName);
        System.out.println(", Value:" + value + "]");
    }
    
    public static void main(String[] args) {
        Student estudiante = new Student("1","Diego",9.99);

        // Imprimimos detalles de las propiedades
        printDetails(estudiante.idProperty());
        printDetails(estudiante.nomeProperty());
        printDetails(estudiante.averageGradeProperty());

        // Cambiamos las propiedades
        estudiante.nomeProperty().set("Ana");
        estudiante.averageGradeProperty().set(5.0);

        // Imprimimos las propiedades cambiadas
        printDetails(estudiante.idProperty());
        printDetails(estudiante.nomeProperty());
        printDetails(estudiante.averageGradeProperty());
    }
}
