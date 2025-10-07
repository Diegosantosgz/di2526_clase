package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ejercicio6 extends Application {

    String respuestaCorrecta = "Santiago de Compostela";
    
    
    public void start(Stage stage) throws Exception{
    // Creamos un nodo (la raiz vertical)
    VBox root = new VBox();
    // Creamos una escena le damos el nodo y el tamaño que queremos que use, en este caso 300 x 200
    Scene scene = new Scene(root,300,200);
  
    // Creamos 4 Label (etiquetas) para ponerles la pregunta y la respuesta
    Label pregunta = new Label("Cal é a capital de Galicia?");
    Label respuesta1 = new Label("-A Coruña");
    Label respuesta2 = new Label("-Santiago de Compostela");
    Label respuesta3 = new Label("-Vigo");    
   // TextField para que se introduzca la respuesta
   TextField txField = new TextField();
   // Un boton para enviar la respuesta
   Button boton = new Button("Enviar resposta");

   
    boton.setOnAction(e1 -> {
    try {    
    
        String respuestaUsuario = txField.getText().trim();
         // Comparamos los strings convirtiendolos por ejemplo a minusculas y no habrá problema de Mayusculas/minusculas
        if(respuestaCorrecta.toLowerCase().equals(respuestaUsuario.toLowerCase())) {
                root.setBackground(new Background(new BackgroundFill(Color.GREEN,null,null)));
        }else {
            root.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
        }
    }

    catch(Exception ex){
        System.out.println("Error: " + ex.getMessage());
    
    }});

    // Hacemos que el nodo(raiz) recoja a sus hijos en orden de aparacion 
    root.getChildren().addAll(pregunta,respuesta1,respuesta2,respuesta3,txField,boton);
    // Le ponemos un nombre a la ventana
    stage.setTitle("Mini Cuestionario");
    // creamos la escena en el escenario
    stage.setScene(scene);    
    // Mostramos la escena
    stage.show();  


        }
    
    public static void main(String[] args) {
        Application.launch(args);
    
    }
}
