package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio5 extends Application {

    
    public void start(Stage stage) throws Exception{
    // Creamos un nodo (la raiz vertical)
    VBox root = new VBox();
    // Creamos una escena le damos el nodo y el tamaño que queremos que use, en este caso 300 x 200
    Scene scene = new Scene(root,300,200);
    // Creamos 2 TextField para pedir al usuario que meta el ancho y el alto
    TextField tFielAncho = new TextField();
    TextField tFieldAlto = new TextField();
    // Aqui le metemos una pista dentro del TextField para que sepa el usuario lo que deba introducir
    tFielAncho.setPromptText("Indica o novo ancho...");
    tFieldAlto.setPromptText("Indica a nova altura...");
    // Creamos un botón para redimensionar los pixeles introducir por el usuario
    Button btnRedimensionar = new Button("Redimensionar");
    // Creamos 2 Label (etiquetas) para llamarles nuevo ancho y nuevo alto
    Label labelAncho = new Label("Novo ancho");
    Label labelAlto = new Label("Novo alto");

    // Creamos 2 HBox (horizontal) para cada ancho y alto 
    HBox rootHorizontal = new HBox();
    HBox rootHorizontal2 = new HBox();
    // Hacemos que cada HBox recoja lo que se quiera colocar de forma horizontal en orden de aparicion
    rootHorizontal.getChildren().addAll(labelAncho,tFielAncho);
    rootHorizontal2.getChildren().addAll(labelAlto,tFieldAlto);

    // Hacemos el evento del boton
    btnRedimensionar.setOnAction(e -> {
        // try para manejar errores
        try {
            // declaramos 2 ints que parsearan de Integer a int por que en el textField 
            // se meten Strings, y necesitamos enteros (int)
            int ancho = Integer.parseInt(tFielAncho.getText());
            int alto = Integer.parseInt(tFieldAlto.getText());
            // Mientras el alto y el ancho sea un numero positivo se dara su ancho y su alto
            if (ancho > 0 && alto > 0) {
                stage.setWidth(ancho);
                stage.setHeight(alto);
                // sino, dara error de numeros negativos
            } else {
                System.out.println("Error: Los valores deben ser positivos");
            }
            // Si metemos numeros no validos saltará esta excepcion
        } catch (NumberFormatException e2) {
            System.out.println("Error: Introduce solo numeros validos");
    }
});
     
    // Hacemos que el nodo(raiz) recoja a sus hijos en orden de aparacion 
    root.getChildren().addAll(rootHorizontal,rootHorizontal2,btnRedimensionar);
    // Le ponemos un nombre a la ventana
    stage.setTitle("Cambiar o tamaño da ventana");
    // creamos la escena en el escenario
    stage.setScene(scene);    
    // Mostramos la escena
    stage.show();  


          }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
