package com.jdojo.binding;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ejercicio23 extends Application {

    // CIRCULO CONTROLADO POR SLIDERS 

     public void start(Stage stage) {

        // Creamos el contenedor principal (Pane)
        // Pane permite colocar los elementos en coordenadas exactas (x, y)
        Pane root = new Pane();

        // Creamos el círculo
        Circle circle = new Circle();
        circle.setCenterX(150);           // Posición X del centro
        circle.setCenterY(100);           // Posición Y del centro
        circle.setRadius(40);             // Radio inicial
        circle.setFill(Color.ANTIQUEWHITE); // Color de relleno
        circle.setStroke(Color.BLACK);    // Color del borde
        circle.setStrokeWidth(2);         // Grosor inicial del borde

        // --- Slider 1: controla el radio del círculo ---
        Slider sliderRadio = new Slider(0, 100, 40); // rango 0–100, valor inicial 40
        sliderRadio.setShowTickLabels(true);   // mostrar los valores
        sliderRadio.setShowTickMarks(true);    // mostrar las marcas
        sliderRadio.setMajorTickUnit(20);      // marca cada 20 unidades
        sliderRadio.setBlockIncrement(5);      // paso de movimiento

        // --- Slider 2: controla el grosor del borde ---
        Slider sliderBorde = new Slider(0, 10, 2); // rango 0–10, valor inicial 2
        sliderBorde.setShowTickLabels(true);
        sliderBorde.setShowTickMarks(true);
        sliderBorde.setMajorTickUnit(2);
        sliderBorde.setBlockIncrement(1);

        // --- Binding (enlaces) ---
        // Vinculamos las propiedades del círculo a las de los sliders
        circle.radiusProperty().bind(sliderRadio.valueProperty());
        circle.strokeWidthProperty().bind(sliderBorde.valueProperty());

        // --- Posicionamiento manual ---
        // Pane no organiza los elementos automáticamente, así que los colocamos con relocate()
        circle.relocate(100, 50);          // posición aproximada del círculo
        sliderRadio.relocate(50, 200);     // colocamos el slider del radio abajo
        sliderBorde.relocate(50, 220);     // el slider del borde justo debajo

        // Añadimos los elementos al Pane
        root.getChildren().addAll(circle, sliderRadio, sliderBorde);

        // Creamos la escena de tamaño 300x250 píxeles
        Scene scene = new Scene(root, 350, 350);

        // Configuramos y mostramos la ventana
        stage.setTitle("Círculo controlado por Sliders");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
