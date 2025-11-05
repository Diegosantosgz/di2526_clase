package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Ejercicio17 extends Application {

    public void start(Stage stage) {

        DoubleProperty precio = new SimpleDoubleProperty();
        IntegerProperty cantidad = new SimpleIntegerProperty();
        
        Label label = new Label();

        

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
