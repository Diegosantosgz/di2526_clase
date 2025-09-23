package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ejercicio2 {

    public void start(Stage stage) {

        // Creamos un nodo con VBox
        VBox nodo = new VBox();
        // Creamos una escena, le pasamos el nodo y le damos un tamaño de 300x200 píxeles
        Scene scene = new Scene(nodo,300,200);
        // Creamos 3 botones, uno para cada color dandoles su nombre
        Button rojo = new Button("Rojo");
        Button azul = new Button("Azul");
        Button verde = new Button("Verde");

        // Hacemos los eventos de los botones para que se cambien a sus respectivos colores     

        rojo.setOnAction(e -> {
            nodo.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        });
        verde.setOnAction(e -> {
            nodo.setBackground(new Background(new BackgroundFill(Color.GREEN,null,null)));
        });
        azul.setOnAction(e -> {
            nodo.setBackground(new Background(new BackgroundFill(Color.BLUE,null,null)));
        });
    }
        


    public static void main(String[] args){
        Application.launch(args);
    }
}
