package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ejercicio8 extends Application {

    public void start(Stage stage) throws Exception {
        TextField tfNumero1 = new TextField();
        TextField tfNumero2 = new TextField();

        tfNumero1.setPromptText("Operando 1");
        tfNumero2.setPromptText("Operando 2");

        Label labelResultado = new Label("Resultado: ");

        Button sumar = new Button("+");
        Button restar = new Button("-");
        Button multiplicar = new Button("*");
        Button dividir = new Button("/");

        // Cada botón realiza la operación correspondiente al hacer clic
        sumar.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(tfNumero1.getText());
                double num2 = Double.parseDouble(tfNumero2.getText());
                double total = num1 + num2;
                labelResultado.setText("Resultado: " + total);
            } catch (NumberFormatException ex) {
                labelResultado.setText("Error: Introduce números válidos");
            }
        });

        restar.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(tfNumero1.getText());
                double num2 = Double.parseDouble(tfNumero2.getText());
                double total = num1 - num2;
                labelResultado.setText("Resultado: " + total);
            } catch (NumberFormatException ex) {
                labelResultado.setText("Error: Introduce números válidos");
            }
        });

        multiplicar.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(tfNumero1.getText());
                double num2 = Double.parseDouble(tfNumero2.getText());
                double total = num1 * num2;
                labelResultado.setText("Resultado: " + total);
            } catch (NumberFormatException ex) {
                labelResultado.setText("Error: Introduce números válidos");
            }
        });

        dividir.setOnAction(e -> {
            try {
                double num1 = Double.parseDouble(tfNumero1.getText());
                double num2 = Double.parseDouble(tfNumero2.getText());
                if (num2 == 0) {
                    labelResultado.setText("Error: División por cero");
                    return;
                }
                double total = num1 / num2;
                labelResultado.setText("Resultado: " + total);
            } catch (NumberFormatException ex) {
                labelResultado.setText("Error: Introduce números válidos");
            }
        });

        HBox root = new HBox(10); // Agrega espacio entre elementos
        root.getChildren().addAll(tfNumero1, tfNumero2, sumar, restar, multiplicar, dividir, labelResultado);

        Scene scene = new Scene(root, 600, 50);
        stage.setTitle("Mini Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
