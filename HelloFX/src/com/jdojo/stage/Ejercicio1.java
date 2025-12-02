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

public class Ejercicio1 extends Application {

    @Override
    public void start(Stage stage){

        // Propiedades
        TextField tfx = new TextField();
        TextField tfy = new TextField();
        Label lbx = new Label("Introduzca coordenada X: ");
        Label lby = new Label("Introduzca coordenada Y: ");
        Label resuLabel = new Label();
        Button boton = new Button("Mover Stage");


        Rectangle2D primaryScreen = Screen.getPrimary().getVisualBounds();


        boton.setOnAction(e -> {
            double x = Double.parseDouble(tfx.getText());
            double y = Double.parseDouble(tfy.getText());

            if(Integer.parseInt(tfx.getText()) < 0 || Integer.parseInt(tfx.getText()) > primaryScreen.getWidth()){
                resuLabel.setText("ERROR mal");
            } else if (Integer.parseInt(tfy.getText()) < 0 || Integer.parseInt(tfy.getText()) > primaryScreen.getHeight()){
                resuLabel.setText("ERROR mal");
            }else {
                stage.setX(x);
                stage.setY(y);
                System.out.println("Todo funciona correctamente");
            }
        });
              
        
        // Layout
        HBox horizontal1 = new HBox(lbx,tfx);
        HBox horizontal2 = new HBox(lby,tfy);
        VBox root = new VBox(horizontal1,horizontal2,boton,resuLabel);

        Scene scene = new Scene(root,300,200);
        stage.setScene(scene);
        stage.setTitle("Mover la ventana");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

 
}
