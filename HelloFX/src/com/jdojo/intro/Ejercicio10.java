package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio10 extends Application {
    // Declaramos un atributo contador(int) para usarlo en el boton y cuente tarea por tarea
    int contador = 1;

    public void start(Stage stage) {
        VBox root = new VBox();

        TextField tField = new TextField();

        Button btnTarea = new Button("Nova Tarefa");

        root.getChildren().addAll(tField, btnTarea);

        btnTarea.setOnAction(e -> {
            // Si el texto es vacío sacará un texto en rojo diciendo que es un campo
            // obligatorio de rellenar
            if (tField.getText().equals("")) {
                tField.setStyle("-fx-prompt-text-fill: red");
                tField.setPromptText("Este campo es obligatorio");
            } else {
                HBox hRoot = new HBox();
                // Una etiqueta donde manejamos un contador(int) para concatenar cada numero de
                // tarea
                // Con el texto del TextField

                CheckBox box = new CheckBox();
                Label label = new Label("Tarefa_" + contador + ": " + tField.getText());
                // Margen de 6 pixeles
                label.setStyle("-fx-padding: 6;");
                // Aumentamos contador en 1 por cada tarea
                contador++;
                Button btnBorrar = new Button("Borrar");
                // Propiedad para que si el checkbox no está marcado, el boton de borrar esté deshabilitado
                box.selectedProperty().addListener((obs, antes, agora) -> {
                btnBorrar.setDisable(!agora);
                });
                //
               btnBorrar.setOnAction(e2 -> root.getChildren().remove(btnBorrar.getParent()));
                // Añadimos el label dentro del boton debido a que es un label creado dentro del
                // propio botón
                // Primero ponemos los componentes que irian en horizontal
                hRoot.getChildren().addAll(box, label,btnBorrar);
                // Y luego ponemos el root del horizontal dentro del vertical
                root.getChildren().addAll(hRoot);

                // Limpiamos el TextField
                tField.clear();
            }
        });


        Scene scene = new Scene(root, 300, 400);
        stage.setTitle("To-Do List con borrado");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
