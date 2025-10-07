package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Ejercicio7 extends Application {

      public void start(Stage stage) throws Exception{
    // Creamos un nodo (la raiz vertical)
    VBox root = new VBox();
    // Creamos una escena le damos el nodo y el tamaño que queremos que use, en este caso 300 x 200
    Scene scene = new Scene(root,300,200);

    TextArea textTA = new TextArea();

    
  
    // Creamos 4 Label (etiquetas) para ponerles la pregunta y la respuesta
    Label pregunta = new Label();
   // TextField para que se introduzca la respuesta
   TextField txField = new TextField();
   // Un boton para enviar la respuesta
   Button boton = new Button("Enviar resposta");

    

    
    
    

    // Hacemos que el nodo(raiz) recoja a sus hijos en orden de aparacion 
    root.getChildren().addAll();
    // Le ponemos un nombre a la ventana
    stage.setTitle("Ciclo de vida con consola");
    // creamos la escena en el escenario
    stage.setScene(scene);    
    // Mostramos la escena
    stage.show();  


        }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
