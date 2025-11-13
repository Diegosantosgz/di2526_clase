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
Pistas:
Usa as clases SimpleStringProperty, SimpleIntegerProperty e SimpleDoubleProperty.
Lembra usar os métodos get(), set() e XXXProperty() para cada propiedade. */