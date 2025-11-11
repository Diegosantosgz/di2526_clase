package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ejercicio21 extends Application {

    // VENTANA CON BINDING HELPER

    public void start(Stage stage) {

        // Creamos el botón y establecemos su texto
        Button btn = new Button("Presióname");

        // Creamos un contenedor y añadimos el botón en el centro
        VBox root = new VBox(btn);

        // Establecemos el fondo vacío (sin color por defecto)
        root.setBackground(null);

        // Creamos la escena con el contenedor y tamaño 300x250
        Scene scene = new Scene(root, 300, 250);

        /*
         * Enlazamos (binding) la propiedad 'fill' de la escena con la propiedad 'pressed' del botón.
         * 
         * Esto significa que el color de fondo de la escena cambiará automáticamente
         * según si el botón está siendo presionado o no.
         * 
         * Vamos a usar la opción 3: Bindings.when(...).then(...).otherwise(...)
         */

        scene.fillProperty().bind(
            Bindings.when(btn.pressedProperty()) // si btn.pressedProperty() es true
                    .then(Color.LIGHTGREEN)     // entonces el color será verde claro
                    .otherwise(Color.LIGHTGRAY) // en caso contrario será gris claro
        );

        // Configuramos la ventana (stage)
        stage.setTitle("Binding Helper");
        stage.setScene(scene);
        stage.show(); // Mostramos la ventana
    }

    public static void main(String[] args) {
        Application.launch(args); 
    }
}

