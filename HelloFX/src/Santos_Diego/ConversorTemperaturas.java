package Santos_Diego;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConversorTemperaturas extends Application {

    public void start(Stage stage) {

        // Componentes
        TextField tfCelsius = new TextField();
        TextField tfFarenheit = new TextField();

        Label lbCelsius = new Label("Celsius:");
        Label lbFarenheit = new Label("Farenheit:");
        Label lbResultado = new Label();

        Button btnCaF = new Button("C a F");
        Button btnFaC = new Button("F a C");
        Button btnLimpar = new Button("Limpar");

        // Botones

        btnCaF.setOnAction(e -> {
            try {
                double C = Double.parseDouble(tfCelsius.getText());
                double F = (C * 9 / 5) + 32;
                lbResultado.setText(C + "ºC" + " = " + String.format("%.2f",F) + "ºF");
                lbResultado.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

            } catch (NumberFormatException ex) {
                lbResultado.setText("Introduce un valor válido");
                lbResultado.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

            }
        });

        btnFaC.setOnAction(e -> {
            try {
                double F = Double.parseDouble(tfFarenheit.getText());
                double C = (F - 32) * 5 / 9;
                lbResultado.setText(F + "ºF" + " = " + String.format("%.2f",C) + "ºC");
                lbResultado.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));

            } catch (NumberFormatException ex) {
                lbResultado.setText("Introduce un valor válido");
                lbResultado.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
               
            }
        });

        btnLimpar.setOnAction(e -> {
            tfCelsius.setText("");
            tfFarenheit.setText("");
            lbResultado.setText("");
        });

        // lbCelsius.setStyle("-fx-padding: 6");

        // Layout

        VBox root = new VBox();

        HBox rootHorizontal1 = new HBox(lbCelsius, tfCelsius);
        HBox rootHorizontal2 = new HBox(lbFarenheit, tfFarenheit);
        HBox rootHorizontal3 = new HBox(btnCaF, btnFaC, btnLimpar);

        root.getChildren().addAll(rootHorizontal1, rootHorizontal2, rootHorizontal3, lbResultado);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("Conversor de temperaturas");
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
