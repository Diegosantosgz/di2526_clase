package com.jdojo.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Ejercicio4 extends Application {

    public void start(Stage stage) {

        Button btnDecorated = new Button("DECORATED");
        Button btnUndecorated = new Button("UNDECORATED");
        Button btnTransparent = new Button("TRANSPARENT");
        Button btnUtility = new Button("UTILITY");
        Button btnUnified = new Button("UNIFIED");


        btnDecorated.setOnAction(e -> abrirVentana(DECORATED));
        btnDecorated.setOnAction(e -> abrirVentana(UNDECORATED));
        btnDecorated.setOnAction(e -> abrirVentana(TRANSPARENT));
        btnDecorated.setOnAction(e -> abrirVentana(UTILITY));
        btnDecorated.setOnAction(e -> abrirVentana(UNIFIED));


        

        btnUndecorated.setOnAction(e ->{

        });
        
        btnTransparent.setOnAction(e ->{

        });
        btnUtility.setOnAction(e -> {

        });
        btnUnified.setOnAction(e ->{

        });

    

        VBox root = new VBox(10);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
    
        private void abrirVentana(StageStyle estilo){
                Stage secundario = new Stage();
                secundario.initStyle(estilo);

                Label estiloLbl = new Label();
                estiloLbl.setText(estilo.toString());

                Button btnPechar = new Button("Pechar");
                btnPechar.setOnAction(e -> secundario.close());

                VBox root = new VBox(10,estiloLbl,btnPechar);
                
        
    }   
        

    public static void main(String[] args) {
        Application.launch(args);
    }

}
