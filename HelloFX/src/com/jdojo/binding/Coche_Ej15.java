package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Coche_Ej15 extends Application {

    private StringProperty marca = new SimpleStringProperty(this,"marca","");
    private IntegerProperty velocidad = new SimpleIntegerProperty(this,"velocidad",0);

    public Coche_Ej15() {

    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public String getMarca() {
        return marca.get();
    }

    public void setVelocidad(int velocidad) {
        this.velocidad.set(velocidad);
    }

    public int getVelocidad() {
        return velocidad.get();
    }

    public StringProperty marcaProperty() {
        return marca;
    }

    public IntegerProperty velocidadProperty(){
        return velocidad;
    }

    public void acelerar(int aumento) {
       setVelocidad(getVelocidad() + aumento);

    }

    public void start(Stage stage){

        // Creamos el objeto coche 
        Coche_Ej15 coche = new Coche_Ej15();
        coche.setMarca("McLaren");
        coche.setVelocidad(100);

        // Creamos etiquetas (Labels)
        Label lblMarca = new Label();
        Label lblVelocidad = new Label();


        // Vinculacion de las etiquetas con laspropiedades del coche 
        lblMarca.textProperty().bind(coche.marcaProperty());
        lblVelocidad.textProperty().bind(coche.velocidadProperty().asString());

        // Botón para acelerar 
        Button btnAcelerar = new Button("Acelerar (+25 km/h)");
        btnAcelerar.setOnAction(e -> coche.acelerar(25));

        // Organizar nun VBox
        VBox root = new VBox(10, lblMarca, lblVelocidad, btnAcelerar);
        root.setStyle("-fx-padding: 20; -fx-font-size: 16; -fx-alignment: center;");

        // Crear a escena e amosar a ventá
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Coche FX");
        stage.setScene(scene);
        stage.show();
    }


    

    public static void main(String[] args) {
        Application.launch(args);
    }

}

