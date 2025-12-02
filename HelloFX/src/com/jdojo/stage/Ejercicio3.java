package com.jdojo.stage;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio3 extends Application {

    public void start(Stage stage) {

        // Propiedades
        TextField tfx = new TextField();
        TextField tfy = new TextField();
        Label lbx = new Label();
        Label lby = new Label();
        Label widthLabel = new Label();
        Label heightlabel = new Label();
        Label resuLabel = new Label();

        lbx.textProperty().bind(Bindings.concat("X: ", stage.xProperty()));
        lby.textProperty().bind(Bindings.concat("X: ", stage.yProperty()));
        widthLabel.textProperty().bind(Bindings.concat("X: ", stage.widthProperty()));
        heightlabel.textProperty().bind(Bindings.concat("X: ", stage.heightProperty()));


           // Layout
      VBox root = new VBox(10,lbx,lby,widthLabel,heightlabel);
      Scene scene = new Scene(root,300,200);
      stage.setScene(scene);
      stage.show();



    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
