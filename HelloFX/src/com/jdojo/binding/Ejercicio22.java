package com.jdojo.binding;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio22 extends Application {
    // SLIDERS E BINDING BIDIRECCIONAL EN JAVAFX

public void start(Stage stage) {

        // Creamos el primer slider en horizontal
        // Rango: de 0 a 100, valor inicial: 40
        Slider sliderHorizontal = new Slider(/*inicio*/0, /*Final*/100,/*valor inicial*/ 40);

        // Creamos el segundo slider en vertical con el mismo rango e inicio
        Slider sliderVertical = new Slider(0, 100, 40);
        sliderVertical.setOrientation(Orientation.VERTICAL); // lo ponemos vertical

        // Establecemos un binding bidireccional entre los dos sliders
        // Esto hace que cuando cambie uno, el otro se actualice automáticamente
        sliderHorizontal.valueProperty().bindBidirectional(sliderVertical.valueProperty());

        // Mostramos por consola si cada slider tiene su propiedad "value" ligada (bound)
        // Debe devolver true para ambos, ya que están vinculados entre sí
        System.out.println("sliderHorizontal.valueProperty().isBound() = " +
                sliderHorizontal.valueProperty().isBound());
        System.out.println("sliderVertical.valueProperty().isBound() = " +
                sliderVertical.valueProperty().isBound());

        // Colocamos los dos sliders en un contenedor horizontal
        VBox root = new VBox(20, sliderVertical, sliderHorizontal);
        

        // Creamos la escena de 200x150 píxeles
        Scene scene = new Scene(root, 300, 250);

        // Configuramos la ventana (Stage)
        stage.setTitle("Sliders y Binding Bidireccional");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args); 
    }
}


/* !. Contexto: que é un Slider?
En JavaFX, un Slider é un control gráfico que permite seleccionar un valor dentro dun rango, movendo unha barra ou manilla horizontal ou vertical.

Constructor principal:

Slider(min, max, valorInicial)

min → valor mínimo permitido.
max → valor máximo permitido.
valorInicial → valor no que comeza o slider.

Propiedades útiles:

valueProperty(): valor actual do slider (tipo DoubleProperty).
setOrientation(Orientation.VERTICAL): pon o slider en vertical.
setOrientation(Orientation.HORIZONTAL): pon o slider en horizontal (por defecto).

Instruccións
Crea unha aplicación JavaFx que

1. Teña un slider en horizontal e outro en vertical:
2. Ámbolos dous deben ter un rango entre 0 e 100 e un valor inicial de 40.
3. Os Sliders deben estar sincronizados mediante un binding bidireccional.
4. A xanela terá un tamaño de 200x150 píxeles.
5. Mostra por consola o resultado valueProperty().isBound() de cada slider. Que resultado amosa e por que?
*/