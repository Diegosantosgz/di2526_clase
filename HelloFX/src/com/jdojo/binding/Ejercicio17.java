package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio17 extends Application {

    // Método principal de inicio de la interfaz gráfica
    public void start(Stage stage) {

        // --- PROPIEDADES ---
        // Propiedad observable para el precio unitario (tipo double)
        DoubleProperty precioUnitario = new SimpleDoubleProperty();
        // Propiedad observable para la cantidad (tipo int)
        IntegerProperty cantidad = new SimpleIntegerProperty();
        // Si quisiéramos, podríamos tener también una propiedad "total", pero aquí se calcula directamente
        // DoubleProperty total = new SimpleDoubleProperty();


        // --- CONTROLES ---
        // Campo de texto donde el usuario introduce el precio unitario
        TextField tfPrecioUnitario = new TextField();
        // Campo de texto donde el usuario introduce la cantidad
        TextField tfCantidad = new TextField();
        // Etiqueta donde se mostrará el total calculado
        Label labelTotal = new Label();
        // Etiqueta con el texto "Precio Unitario:"
        Label lbPrecioUnitario = new Label("Precio Unitario:");
        // Etiqueta con el texto "Cantidad:"
        Label lbcantidad = new Label("Cantidad:");


        // --- LISTENERS SOBRE LOS TEXTFIELD ---
        // Este listener se activa cada vez que cambia el texto en el campo del precio unitario
        tfPrecioUnitario.textProperty().addListener((obs, viejoValor, nuevoValor) -> {
            try {
                // Intentamos convertir el texto introducido a número (double)
                precioUnitario.set(Double.parseDouble(nuevoValor));
            } catch (NumberFormatException ex) {
                // Si el usuario escribe algo no numérico, establecemos el valor a 0
                precioUnitario.set(0);
            }
        });

        // Listener para el campo de cantidad
        tfCantidad.textProperty().addListener((obs, viejoValor, nuevoValor) -> {
            try {
                // Intentamos convertir el texto introducido a número entero (int)
                cantidad.set(Integer.parseInt(nuevoValor));
            } catch (NumberFormatException ex) {
                // Si el texto no es un número válido, se pone a 0
                cantidad.set(0);
            }
        });


        // --- LISTENERS SOBRE LAS PROPIEDADES ---
        // Este listener se ejecuta cada vez que cambia el valor del precio unitario
        precioUnitario.addListener((obs, viejoValor, nuevoValor) -> {
            // Calculamos el total multiplicando precio por cantidad
            double total = precioUnitario.get() * cantidad.get();
            // Mostramos el total en el label, formateado con 2 decimales y el símbolo del euro
            labelTotal.setText(String.format("Total: %.2f €", total));
        });

        // Este listener se ejecuta cada vez que cambia la cantidad
        cantidad.addListener((obs, viejoValor, nuevoValor) -> {
            // Calculamos nuevamente el total
            double total = precioUnitario.get() * cantidad.get();
            // Actualizamos el texto del label con el nuevo total
            labelTotal.setText(String.format("Total: %.2f €", total));
        });


        // --- LAYOUT ---
        // Creamos un contenedor vertical (VBox) con separación de 10 píxeles entre los elementos
        VBox root = new VBox(10);

        // Añadimos los controles al contenedor, en el orden en que aparecerán
        root.getChildren().addAll(lbPrecioUnitario, tfPrecioUnitario, lbcantidad, tfCantidad, labelTotal);

        // Creamos la escena (ventana gráfica) con tamaño 250x150 píxeles
        Scene scene = new Scene(root, 250, 150);

        // Asignamos la escena a la ventana principal (stage)
        stage.setScene(scene);
        // Establecemos el título de la ventana
        stage.setTitle("Calculadora de precio total");
        // Mostramos la ventana
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}