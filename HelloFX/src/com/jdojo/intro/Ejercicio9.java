package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio9 extends Application {

    int contador = 1;

    public void start(Stage stage){
        VBox root = new VBox();
        
        TextField tField = new TextField();

        Button btnTarea = new Button("Nova Tarefa");

        root.getChildren().addAll(tField,btnTarea);

        btnTarea.setOnAction(e -> {
            // Si el texto es vacío sacará un texto en rojo diciendo que es un campo obligatorio de rellenar
            if(tField.getText().equals("")){
                tField.setStyle("-fx-prompt-text-fill: red");
                tField.setPromptText("Este campo es obligatorio");
            } else {
                // Una etiqueta donde manejamos un contador(int) para concatenar cada numero de tarea 
                // Con el texto del TextField
        Label label = new Label("Tarefa_" + contador + ": " + tField.getText());
            // Margen de 6 pixeles
        label.setStyle("-fx-padding: 6;");
         // Aumentamos contador en 1 por cada tarea
           contador++;
           // Añadimos el label dentro del boton debido a que es un label creado dentro del propio botón
            root.getChildren().add(label);
            // Limpiamos el TextField
            tField.clear();
            }
        });
       
        Scene scene = new Scene(root, 300, 400);
        stage.setTitle("To-Do List");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
