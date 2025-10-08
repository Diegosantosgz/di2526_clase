package com.jdojo.intro;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio7 extends Application {

    TextArea textarea = new TextArea();
    String fecha = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    public Ejercicio7() {
        // Declaramos una variable para pasarle el nombre
        // Usaremos el atributo fecha para pasarle la fecha directamente desde fuera del metodo
        
        String name = Thread.currentThread().getName();
        textarea.appendText("[" + fecha + "] " + "O fio do constructor: " + "(" + name + ")" + "\n");
    }

    public void init() {
        // Declaramos una variable para pasarle el nombre
        // Usaremos el atributo fecha para pasarle la fecha directamente desde fuera del metodo
        
        String name = Thread.currentThread().getName();
        fecha = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        textarea.appendText("[" + fecha + "] " + "O fio do init(): " + "(" + name + ")" + "\n");
    }

    public void start(Stage stage) {

        stage.setTitle("Ciclo de vida con consola");
        // Declaramos una variable para pasarle el nombre
        // Usaremos el atributo fecha para pasarle la fecha directamente desde fuera del metodo
        String name = Thread.currentThread().getName();
        fecha = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        // El estilo del textArea con un margen(padding) de 5px y color de fondo claro
        textarea.setStyle("-fx-padding: 5px; -fx-background-color:#eef;");
        textarea.appendText("[" + fecha + "] " + "O fio do start(): " + "(" + name + ")");
        // textarea.setText(textTA.get(2);
        Button btnCerrar = new Button("Cerrar aplicacion");

        // Creamos una etiqueta y le ponemos un color de rojo
        Label label = new Label("Pecha a aplicación e comproba na consola a mensaxe");
        label.setStyle("-fx-text-fill: red;");
        VBox root = new VBox();
        root.getChildren().addAll(textarea, label, btnCerrar);

        // controlar botones
        btnCerrar.setOnAction(
                e -> {
                    Platform.exit();
                });

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
    // Solo hacemos que el textAREA diga "proba"
    public void stop() {
        textarea.appendText("Proba");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
