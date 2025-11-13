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
        circle.setCenterY(150);           // Posición Y del centro
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


/* !. Que é un Circle?
En JavaFX, un Circle é unha forma gráfica que se mostra nun VBox, un Pane ou outro layout. Ten varias propiedades que podemos modificar:

radius: radio do círculo (canto mide desde o centro ata a orla).
fill: cor do interior do círculo.
stroke: cor do borde do círculo.
strokeWidth: grosor do borde.
Podemos cambiar estas propiedades directamente con métodos como setRadius(), setFill() ou, mellor aínda, vincular propiedades a controis como sliders para que se actualicen automaticamente.

Instruccións
1. Crea unha aplicación JavaFX cun Pane como raíz (é o mesmo cun VBox ou un HBox).
2. Engade un Circle centrado aproximadamente no medio do pane:
Posición inicial: (150, 150)
Radio inicial: 40
Cor de recheo (fill): ANTIQUEWHITE
Cor do borde (stroke): BLACK
3. Engade dous Sliders:
Slider 1 : Radio do círculo
Rango de 0 a 100
Valor inicial 40
Mostra as etiquetas de tick e marcas cada 20 unidades.
Slider 2 – Grosor do borde
Rango de 0 a 10
Valor inicial 2
Mostra as etiquetas de tick e marcas cada 2 unidades.
4. Vincula os sliders ás propiedades correspondentes do círculo usando bindings:
circle.radiusProperty() debe estar vinculado ao slider do radio.
circle.strokeWidthProperty() debe estar vinculado ao slider do grosor do borde.
5. Posiciona os sliders no pane para que non se sobrepoñan co círculo.
6. Crea unha escena de tamaño 300 x 250 píxeles e móstraa nunha xanela.
Exercicio23

!. Posicionamento dos elementos
Pane é un Layout que a diferenza de VBox non xestiona a disposición dos elementos. Para colocar os elementos debes empregar o método relocate da Class Node

slider1.relocate(150,0)
circle2.relocate(150, 100); // posición (150,100) */