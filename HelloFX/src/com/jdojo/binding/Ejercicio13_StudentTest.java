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

/* 1. Crea unha clase Student con propiedades JavaFX para id, nome e nota media.
id (ReadOnlyStringProperty).
nome (StringProperty).
averageGrade (DoubleProperty).
2. Constructores:
Un constructor baleiro seguindo a convención JavaBeans.
Un constructor con parámetros que inicializará id, name e averageGrade cando se instancie.
3. Implementa os métodos públicos de acceso para:
Para id:
Accesor clásico getter para retrocompatibilidade (o setter non procede por ser só lectura).
Accesor de JavaFx devolve a propiedade de só lectura (getReadOnlyProperty() do wrapper).
Para name e averageGrade:
Accesores clásicos getter e setter.
Accesores JavaFx para devolver os obxecto-propiedade.
4. Noutra clase denominada StudentTest.java:
Implementa un método utilitario estático printDetails(ReadOnlyProperty<?> property) que para cada propiedade:
Imprima o nome da propiedade.
Imprima o valor actual da propiedade.
Imprima a clase do bean.
Nos indique o tipo concreto da propiedade.
Método main de proba:
Instancia un Student e dalle os valores iniciais: "S000","Descoñecido" e 0.0.
Imprime os detalles das propiedades cos valores iniciais.
Modifica os valores facendo uso do accesores das propiedades JavaFx (Ollo: non as clásicas).
name = "Ana"
averageGrade = 10.0
Volve a imprimir os detalles das propiedades para ver os cambios.
Intenta modificar o id facendo uso os accesor da propiedade JavaFX, ¿que ocorre?.

!. Pistas:
Usa as clases SimpleStringProperty, SimpleIntegerProperty e SimpleDoubleProperty.
Lembra usar os métodos get(), set() e XXXProperty() para cada propiedade. */