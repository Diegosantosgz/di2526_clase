package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ejercicio21 extends Application {

    // VENTANA CON BINDING HELPER

    public void start(Stage stage) {

        // Creamos el botón y establecemos su texto
        Button btn = new Button("Presióname");

        // Creamos un contenedor y añadimos el botón en el centro
        VBox root = new VBox(btn);

        // Establecemos el fondo vacío (sin color por defecto)
        root.setBackground(null);

        // tamen podemos usar esto: 
        // root.setBackground(Background.EMPTY);

        // Creamos la escena con el contenedor y tamaño 300x250
        Scene scene = new Scene(root, 300, 250);

        /*
         * Enlazamos (binding) la propiedad 'fill' de la escena con la propiedad 'pressed' del botón.
         * 
         * Esto significa que el color de fondo de la escena cambiará automáticamente
         * según si el botón está siendo presionado o no.
         * 
         * Vamos a usar la opción 3: Bindings.when(...).then(...).otherwise(...)
         */

        scene.fillProperty().bind(
            Bindings.when(btn.pressedProperty()) // si btn.pressedProperty() es true
                    .then(Color.LIGHTGREEN)     // entonces el color será verde claro
                    .otherwise(Color.LIGHTGRAY) // en caso contrario será gris claro
        );

        // Configuramos la ventana (stage)
        stage.setTitle("Binding Helper");
        stage.setScene(scene);
        stage.show(); // Mostramos la ventana
    }

    public static void main(String[] args) {
        Application.launch(args); 
    }
}

/* Deberemos crear unha aplicación en JavaFX cunha xanela que conteña un único botón no centro. O fondo da xanela debe cambiar automaticamente de cor dependendo de se o botón está sendo presionado ou non.

Instrucións
1. Crea o botón e establece o seu texto.
2. Engade o botón a un contedor raíz, este contedor terá un background setBackground(Background.EMPTY)
3. Crea a escena será de 300x250.
4. Vincula (bind) a propiedade fill da escena á propiedade pressed do botón empregando unha das seguintes técnicas:
Opción 1: Crear unha clase anónima que extenda ObjectBinding<Paint> e que faga o bind() a btn.pressedProperty().
Opción 2: Empregar Bindings.createObjectBinding(...) cunha expresión lambda.
Opción 3: Empregar Bindings.when(...).then(...).otherwise(...).
5. Proba que o cambio de estado do botón (presionado / non presionado) actualiza o fondo automaticamente.

Requisitos técnicos:
Vincular a propiedade scene.fillProperty() á propiedade btn.pressedProperty() empregando algunha das técnicas de binding vistas.

!. Propiedades do Button que imos usar:
btn.pressedProperty(): é un observable, un obxecto que "emite" eventos cando o estado cambia. Non é directamente o valor true ou false, senón unha propiedade que pode ser observada.
btn.isPressed(): é o getter que devolve o valor booleano actual (true ou false) desa propiedade.
!. Propiedades da Scene
fillProperty() : define a cor ou o patrón de recheo do fondo da escena. Pode tomar valores do tipo Paint (por exemplo: Color.RED, Color.BLUE, etc.). */