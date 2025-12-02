package com.jdojo.stage;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Ejercicio2 {

    public void start(Stage stage) {

        // Propiedades
        TextField tfx = new TextField();
        TextField tfy = new TextField();
        Label lbx = new Label("Introduzca coordenada X: ");
        Label lby = new Label("Introduzca coordenada Y: ");
        Label resuLabel = new Label();
        tfx.setPromptText("Introduce o valor de X");
        tfy.setPromptText("Introduce o valor de Y");
        

        Button btn = new Button("Mover");

         Rectangle2D primaryScreen = Screen.getPrimary().getVisualBounds();

        // Action listener usando addEventHandler
        btn.addEventHandler(javafx.event.ActionEvent.ACTION, e -> {
            try {
                double x = Double.parseDouble(tfx.getText().trim());
                double y = Double.parseDouble(tfy.getText().trim());
                stage.setX(x);
                stage.setY(y);
                resuLabel.setText("Ventana movida a (" + x + ", " + y + ")");
            } catch (NumberFormatException ex) {
                resuLabel.setText("Introduce valores numéricos válidos.");
            }
        });

        // Listeners en los TextField para habilitar/deshabilitar el botón según validación
        javafx.beans.value.ChangeListener<String> validator = (obs, oldVal, newVal) -> {
            try {
                Double.parseDouble(tfx.getText().trim());
                Double.parseDouble(tfy.getText().trim());
                btn.setDisable(false);
            } catch (Exception ex) {
                btn.setDisable(true);
            }
        };
        tfx.textProperty().addListener(validator);
        tfy.textProperty().addListener(validator);
        btn.setDisable(true);
        btn.setOnAction(e -> {
            try {
                double x = Double.parseDouble(tfx.getText().trim());
                double y = Double.parseDouble(tfy.getText().trim());
                stage.setX(x);
                stage.setY(y);
                resuLabel.setText("Ventana movida a (" + x + ", " + y + ")");
            } catch (NumberFormatException ex) {
                resuLabel.setText("Introduce valores numéricos válidos.");
            }
        });
       





        // Layout
        HBox horizontal1 = new HBox(lbx,tfx);
        HBox horizontal2 = new HBox(lby,tfy);
        VBox root = new VBox(horizontal1,horizontal2,btn,resuLabel);

        Scene scene = new Scene(root,300,200);
        stage.setScene(scene);
        stage.setTitle("Mover la ventana");
        stage.show();
    }

    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
