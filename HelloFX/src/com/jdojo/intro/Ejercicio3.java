package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio3 extends Application {
    // Declaramos un atributo para el contador
    private int contador = 0;

    public void start(Stage stage) {

        // Creamos un label por que va a mostrar un contador que empezará en 0
        Label nameLabel = new Label("Contador: 0");
        // Creamos un boton que incrementará el contador
        Button btnIncremento = new Button("Incrementar");

        btnIncremento.setOnAction(e -> {
            contador++;
            nameLabel.setText("Contador: " + contador);
        });


        // Creamos un nodo con VBox
        VBox root = new VBox(10);

        // Hacemos que el nodo (la raíz) recoja a los hijos, en este caso el label y el botón
        root.getChildren().addAll(nameLabel,btnIncremento);

        // Creamos la escena y le pasamos el nodo root y le damos el tamaño de 300x300
        Scene scene = new Scene(root, 300, 300);

        // Le damos un nombre a la ventana
        stage.setTitle("Click Me!");
        // Creamos la escena
        stage.setScene(scene);
        // Mostramos el escenario
        stage.show();
    }

    public static void main(String[] args) {
        // Necesitamos que el main ejecute los parametros recibidos de Application y los
        // lance
        Application.launch(args);
    }
}
