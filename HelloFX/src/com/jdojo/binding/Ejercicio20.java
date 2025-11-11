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

public class Ejercicio20 extends Application{
    
    public void start(Stage stage){

        IntegerProperty numero = new SimpleIntegerProperty();

        TextField tfNumero = new TextField();

        Label labelTexto = new Label("Número:");
        Label label = new Label();

        StringBinding binding = new StringBinding() {{
            this.bind(numero);
        }

        @Override
        protected String computeValue() {
            int valor = numero.get();
            return  (valor % 2 == 0) ? "PAR" : "IMPAR";

        }

    };

    VBox root = new VBox();
    root.getChildren().addAll(labelTexto,tfNumero,label);
    Scene scene = new Scene(root,300,200);
    stage.setScene(scene);
    stage.setTitle("Indicador de numero par ou impar");
    stage.show();


    }

    public static void main(String[] args) {
    Application.launch(args);
    }
}
