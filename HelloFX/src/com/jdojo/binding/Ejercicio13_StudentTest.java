package com.jdojo.binding;

import javafx.beans.property.ReadOnlyProperty;

public class Ejercicio13_StudentTest {

    public static void main(String[] args) {
        Student e1 = new Student("1","Diego",9.99);

        printDetails(e1.idProperty());
        printDetails(e1.nomeProperty());
        printDetails(e1.averageGradeProperty());
    }


    public static void printDetails(ReadOnlyProperty<?> p){
        String nome = p.getName();
        Object value = p.getValue();
        Object bean = p.getBean();
        String beanClassName = (bean == null) ? "null" : bean.getClass().getSimpleName();
        String propClassName = p.getClass().getSimpleName();

        System.out.println(propClassName);
        System.out.println("[Nome:]" + nome);
        System.out.println(", Bean Class:" + beanClassName);
        System.out.println(", Value:" + value + "]");
    }
}
