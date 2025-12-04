package com.jdojo.stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;
import static javafx.stage.StageStyle.*;



public class Ejercicio4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Button decoredBtn = new Button("DECORATED");
        Button undecoredBtn = new Button("UNDECORATED");
        Button transparentBtn = new Button("TRANSPARENT");
        Button utilityBtn = new Button("UTILITY");
        Button unifiedBtn = new Button("UNIFIED");

        // Manejar las acciones de los botones llamando al metodo
        decoredBtn.setOnAction(e -> abrirVentana(DECORATED));
        undecoredBtn.setOnAction(e -> abrirVentana(UNDECORATED));
        transparentBtn.setOnAction(e -> abrirVentana(TRANSPARENT));
        utilityBtn.setOnAction(e -> abrirVentana(UTILITY));
        unifiedBtn.setOnAction(e -> abrirVentana(UNIFIED));

        // el VBox y el scene principal
        VBox root = new VBox(10, decoredBtn, undecoredBtn, transparentBtn, utilityBtn, unifiedBtn);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Gestor de estilos de Stage");
        stage.setScene(scene);
        stage.show();
    }

    // Metodo para abrir una nueva ventana cuando al pulsar en un boton de la escena
    // principal
    private void abrirVentana(StageStyle estilo) {
        Stage secundario = new Stage();
        secundario.initStyle(estilo); // Llamarlo siempre antes del show

        Label estiloLb = new Label();
        estiloLb.setText(estilo.toString());

        Button cerrarBtn = new Button("Cerrar");
        cerrarBtn.setOnAction(e -> secundario.close());

        VBox layout = new VBox(10, estiloLb, cerrarBtn);
        Scene escena = new Scene(layout, 300, 200);

        if (estilo == TRANSPARENT) {
            // Hacer la escena transparente
            escena.setFill(null);

            // Aplicar estilo CSS transparente al nodo raiz
            escena.getRoot().setStyle("-fx-background-color: transparent");
        } else if (estilo == UNIFIED) {
            escena.setFill(Color.TRANSPARENT);
        }

        secundario.setScene(escena);
        secundario.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}