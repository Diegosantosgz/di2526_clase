package com.jdojo.intro;


import java.util.InputMismatchException;

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

public class Ejercicio4 extends Application {

    private int contador = 0;
    private int numeroSecreto;
    private int intento;

    public void start(Stage stage) throws Exception{
    // Creamos un nodo (la raiz)
    VBox root = new VBox();
    // Creamos una escena le damos el nodo y el tamaño que queremos que use, en este caso 300 x 200
    Scene scene = new Scene(root,300,200);
    // Generamos de forma aleatoria un numero entre el 1 y el 100
    numeroSecreto =  (int) (Math.random() * 100);
    System.out.println(numeroSecreto);
    // Creamos una etiqueta(Label) donde indique que el usuario deba adivinar un numero entre 0 y 100
    Label nameLabel = new Label("Adiviña o número comprendido entre 0 e 100");
    // Creamos un TextField para que el usuario pueda introducir un numero
    TextField tField = new TextField();    
    // Creamos un botón donde compruebe el numero introducido por el usuario    
    Button btnProbar = new Button("Probar");
    // Creamos otro botón donde reinicie el juego, generando un numero nuevo limpiando el label    
    Button btnReiniciar = new Button("Reiniciar Xogo");
    // Creamos otro botón donde el usuario pueda rendirse y se muestre el numero secreto con fondo naranja   
    Button btnRendirse = new Button("Rendirse");
    // Creamos una etiqueta(Label) donde diga si el numero secreto es mas alto,mas bajo etc
    Label nameLabel2 = new Label();
    // Creamos un label donde aparezcan los intentos hechos con un contador    
    Label nameLabel3 = new Label();

     
    try{
    btnProbar.setOnAction(e ->{
        intento = Integer.parseInt(tField.getText()); // "89" -> 89 el 89 String pasa a ser un entero 
        if (intento < numeroSecreto){ // Si es un numero menor
            nameLabel2.setText("O numero e mais alto.");
            contador++;
            nameLabel3.setText("Intentos: " + contador);
        }
        if (intento > numeroSecreto){ // Si es un numero mayor
            nameLabel2.setText("O numero e mais baixo.");
            contador++;
            nameLabel3.setText("Intentos: " + contador);
        }if(intento == numeroSecreto){ // Si el numero es correcto
            nameLabel2.setText("Correcto o numero e: " + numeroSecreto);
            nameLabel2.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, null, null)));
           // nameLabel2.setStyle("-fx-background-color: transparent;");
            contador++;
            nameLabel3.setText("Intentos: " + contador);

    }
    else if(intento < 0 || intento > 100){
        nameLabel2.setText("El numero está fuera de rango");
        
    }
});
        btnReiniciar.setOnAction(e2 ->{
          //  start(stage) seria llamarlo recursivamente y se reiniciaria
          numeroSecreto = (int) Math.random() * 100;  
          contador = 0;
          nameLabel2.setText("Xogo reiniciado");  
        });
        btnRendirse.setOnAction(e3 ->{
            nameLabel2.setText("O numero secreto era: " + numeroSecreto);
            nameLabel2.setBackground(new Background(new BackgroundFill(Color.LIGHTCORAL, null, null)));
         //   nameLabel2.setStyle("-fx-background-color: orange;");
         //   nameLabel2.setStyle("-fx-background-color: transparent;");
        });
    }catch(InputMismatchException e4){
        System.out.println("Error: Debe introducir solo numeros(no letras ni simbolos)");

    }
        
    // Hacemos que el nodo(raiz) recoja a sus hijos en este caso el textfield, el label y los hijos   
    root.getChildren().addAll(nameLabel,tField,btnProbar,btnReiniciar,btnRendirse,nameLabel2,nameLabel3);
    // Le ponemos un nombre a la ventana
    stage.setTitle("Adiviña o número");
    // creamos la escena en el escenario
    stage.setScene(scene);    
    // Mostramos la escena
    stage.show();    

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
