package com.jdojo.binding;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

    // CLASE STUDENT DEL EJERCICIO 13 (CREACIÓN DE UNA CLASE CON PROPIEDADES JAVAFX)

    private ReadOnlyStringWrapper id = new ReadOnlyStringWrapper(this, "ID", "Unknown");
    private StringProperty nome = new SimpleStringProperty(this, "nome", "Unknown");
    private DoubleProperty averageGrade = new SimpleDoubleProperty(this, "nota promedio", 0.0);

    // Constructor vacío
    public Student() {
    }

    // Constructor con parámetros
    public Student(String id, String nome, double averageGrade){
        this.id.set(id);
        this.nome.set(nome);
        this.averageGrade.set(averageGrade);
    }

    public final String getId() {
        return id.get();
    }

    public final ReadOnlyStringProperty idProperty(){
        return id.getReadOnlyProperty();
    }

    
    public final String getNome() {
        return nome.get();
    }

    public final void setNome(String nome) {
        this.nome.set(nome);
    }

    public final StringProperty nomeProperty() {
        return nome;
    }

    public final double getAverageGrade() {
        return averageGrade.get();
    }

    public final void setAverageGrade(double averageGrade) {
        this.averageGrade.set(averageGrade);
    }

    public final DoubleProperty averageGradeProperty() {
        return averageGrade;
    }
}
