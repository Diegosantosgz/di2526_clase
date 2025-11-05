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


