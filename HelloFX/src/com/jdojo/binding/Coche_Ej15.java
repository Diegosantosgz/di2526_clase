package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// Clase principal de la aplicación que representa un coche en JavaFX
// Extiende Application porque necesitamos crear una interfaz gráfica
public class Coche_Ej15 extends Application { 

    // COCHE DINÁMICO CON JAVAFX

    // Propiedad que almacena la marca del coche (StringProperty permite "enlazar" con elementos de la interfaz)
    private StringProperty marca = new SimpleStringProperty(this,"marca","");
    
    // Propiedad que almacena la velocidad del coche (IntegerProperty permite "enlazar" con elementos de la interfaz)
    private IntegerProperty velocidad = new SimpleIntegerProperty(this,"velocidad",0);

    // Constructor vacío de la clase Coche_Ej15
    public Coche_Ej15() { }

    // Método para cambiar la marca del coche
    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    // Método para obtener la marca del coche
    public String getMarca() {
        return marca.get();
    }

    // Método para cambiar la velocidad del coche
    public void setVelocidad(int velocidad) {
        this.velocidad.set(velocidad);
    }

    // Método para obtener la velocidad del coche
    public int getVelocidad() {
        return velocidad.get();
    }

    // Método que devuelve la propiedad marca (útil para vincular la marca con etiquetas de la interfaz)
    public StringProperty marcaProperty() {
        return marca;
    }

    // Método que devuelve la propiedad velocidad (útil para vincular la velocidad con etiquetas de la interfaz)
    public IntegerProperty velocidadProperty(){
        return velocidad;
    }

    // Método que aumenta la velocidad del coche en el valor que se le pase
    public void acelerar(int aumento) {
       setVelocidad(getVelocidad() + aumento);
    }

    // Método principal de JavaFX donde se crea la interfaz gráfica
    public void start(Stage stage){

        // Crear un objeto Coche_Ej15 y establecer su marca y velocidad inicial
        Coche_Ej15 coche = new Coche_Ej15();
        coche.setMarca("McLaren");
        coche.setVelocidad(100);

        // Crear etiquetas (Label) que mostrarán la marca y la velocidad del coche
        Label lblMarca = new Label();
        Label lblVelocidad = new Label();

        // Vincular las etiquetas con las propiedades del coche
        // Así, si la propiedad cambia, la etiqueta se actualiza automáticamente
        lblMarca.textProperty().bind(coche.marcaProperty());
        lblVelocidad.textProperty().bind(coche.velocidadProperty().asString());

        // Crear un botón que al pulsarlo acelera el coche
        Button btnAcelerar = new Button("Acelerar (+25 km/h)");
        btnAcelerar.setOnAction(e -> coche.acelerar(25)); // Al hacer clic, aumenta la velocidad

        // Crear un VBox (contenedor vertical) para organizar los elementos de la interfaz
        VBox root = new VBox(10); // 10 píxeles de espacio entre elementos
        root.getChildren().addAll(lblMarca, lblVelocidad, btnAcelerar); // Añadir los elementos al VBox
        root.setStyle("-fx-padding: 20; -fx-font-size: 16; -fx-alignment: center;"); 
        // Estilo: padding, tamaño de fuente y alineación centrada

        // Crear la escena y mostrar la ventana
        Scene scene = new Scene(root, 300, 200); // Escena de 300x200 píxeles
        stage.setTitle("Coche FX"); // Título de la ventana
        stage.setScene(scene); // Asignar la escena al stage
        stage.show(); // Mostrar la ventana
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
/* 
Adapta a clase Coche do Exercicio 11 e usar as súas propiedades observables en JavaFX para crear unha interface de usuario que se actualice automaticamente.

Instrucións:

1. Modifica a clase Coche (Exercicio 11) e chámaa CocheFx:

Modifica os campos privados como private String marca e private int velocidade para que usen as clases de propiedades de JavaFX:
Asegúrate de que os métodos getMarca(), setMarca(), getVelocidade() e setVelocidade() usen os novos campos de propiedade.
Engade os dous novos métodos necesarios para a vinculación en JavaFX.

public StringProperty marcaProperty() que devolva a propiedade da marca.
public IntegerProperty velocidadeProperty() que devolva a propiedade da velocidade.


Adapta o método acelerar(int aumento) para que chame ao método set da propiedade velocidade.
2. Crea a aplicación JavaFX:

Dentro do método start(Stage stage):
Crea unha instancia da túa clase Coche.
Asigna un valor inicial para a marca ("McLaren") e a velocidade (100).
Crea un Label para mostrar a marca e outro para a velocidade.
Vincula o texto do Label da marca á propiedade marcaProperty() do teu obxecto Coche.
Vincula o texto do Label da velocidade á propiedade velocidadeProperty(), usando .asString() para converter o número en texto.
Crea un Button cunha etiqueta "Acelerar (+25 km/h)".
Programa a acción do botón para que chame ao método acelerar(25) do teu obxecto Coche.
Organiza os compoñentes nun contedor (VBox ou similar), crea a Scene e mostra a ventá.
!. Preguntas para reflexionar:
Se non tivésemos modificado a clase Coche para usar propiedades de JavaFX, que teríamos que facer no setOnAction do botón "Acelerar" para que o Label da velocidade se actualizase?
Explica porque, despois de usar bind(), non necesitamos actualizar manualmente o Label da velocidade cando o coche acelera.
!. A ter en conta
Do mesmo xeito que no exemplo do circulo a clase Circle ten tres propiedades — centerXProperty, centerYProperty, e radiusProperty — a clase Label ten as propiedades :

textProperty() - Propiedade do texto mostrado.
fontProperty() - Propiedade da fonte do texto (un ObjectProperty<Font>).
visibleProperty() - Propiedade booleana para visibilidade. entre outras */
