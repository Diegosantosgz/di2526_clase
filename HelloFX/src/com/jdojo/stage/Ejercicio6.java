package com.jdojo.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio6 extends Application {

    public void start(Stage stage){


    ComboBox<String> comboModality = new ComboBox<>();
    
    comboModality.getItems().addAll("NONE","WINDOW_MODAL","APPLICATION_MODAL");
    
    Button abrirventana = new Button("AbrirVentana");


    abrirventana.setOnAction(e->{
        String seleccion = comboModality.getValue();
    });


        VBox root = new VBox(10,comboModality,abrirventana);
        Scene scene = new Scene(root, 400, 350);
		stage.setScene(scene);
		stage.setTitle("Gestor de modalidad");
		stage.show();
  

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
