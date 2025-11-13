package com.jdojo.binding; 
import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

    // INDICADOR DE NUMERO PAR O IMPAR

public class Ejercicio20 extends Application{
    
    public void start(Stage stage){
 // Propiedad entera que almacenará el número introducido por el usuario
        IntegerProperty numero = new SimpleIntegerProperty();

        // Campo de texto donde el usuario escribirá el número
        TextField tfNumero = new TextField();

        // Etiquetas para mostrar texto y resultado
        Label lbTexto = new Label("Número:");
        Label lbEtiqueta = new Label();

        // Conversor para vincular un número con una cadena (texto)
        // Esto permite que el TextField y la propiedad IntegerProperty se sincronicen automáticamente
        NumberStringConverter converter = new NumberStringConverter();

        // Enlace bidireccional entre el texto del campo y la propiedad entera
        // Cuando cambia el texto, cambia el número, y viceversa
        tfNumero.textProperty().bindBidirectional(numero, converter);

        // Creamos un binding personalizado (una vinculación)
        // que depende de la propiedad 'numero' y calcula si es PAR o IMPAR
        StringBinding binding = new StringBinding() {{
            this.bind(numero); // Vinculamos este binding a la propiedad 'numero'
        }

        @Override
        protected String computeValue() {
            // Este método se ejecuta automáticamente cada vez que cambia 'numero'
            int valor = numero.get(); // Obtenemos el valor actual del número
            // Devolvemos "PAR" si es divisible por 2, o "IMPAR" si no lo es

            // Esto es si lo ponemos de manera ternaria
            // return  (valor % 2 == 0) ? "PAR" : "IMPAR";

            // Lo mismo pero de la manera tradicional
            if (valor % 2 == 0){
                return "PAR";
            }else {
                return "IMPAR";
            }
        }

    };

    // Enlazamos el texto de la etiqueta al binding que calcula PAR o IMPAR
    // Así la etiqueta se actualizará automáticamente al cambiar el número
    lbEtiqueta.textProperty().bind(binding);

    // Creamos un contenedor vertical (VBox) y añadimos los componentes
    VBox root = new VBox();
    root.getChildren().addAll(lbTexto, tfNumero, lbEtiqueta);

    // Creamos la escena (ventana) 300x200 pixeles (ancho y alto)
    Scene scene = new Scene(root, 300, 200);

    // Configuramos la ventana principal
    stage.setScene(scene);
    stage.setTitle("Indicador de número par o impar");

    // Mostramos la ventana
    stage.show();
    }

    // Método main: lanza la aplicación JavaFX
    public static void main(String[] args) {
        Application.launch(args);
    }
}


/* Crea unha aplicación gráfica en JavaFX que:

1. Teña unha propiedade IntegerProperty para almacenar un número enteiro.
2. Mostre un campo de texto (TextField) no que o usuario poida introducir o número.
3. Mostre nunha etiqueta (Label) se o número é PAR ou IMPAR.
4. Para determinar a paridade, crea un binding personalizado mediante unha subclase anónima de StringBinding, ligando esta ao IntegerProperty e sobreescribindo computeValue().
5. Establece un bind bidireccional entre o campo de texto e a propiedade IntegerProperty empregando un NumberStringConverter, de modo que ao modificar o texto se actualice o número e viceversa.
6. Faga que a etiqueta se actualice automaticamente a PAR ou IMPAR ao cambiar o valor do número grazas ao binding. */