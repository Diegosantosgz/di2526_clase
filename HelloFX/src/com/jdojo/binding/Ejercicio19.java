package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Ejercicio19 extends Application{

    // CALCULADORA CON BINDINGS BIDIRECCIONALES

    public void start(Stage stage){
        
        // Propiedades
        DoubleProperty precioUnitario = new SimpleDoubleProperty();
        DoubleProperty descuento = new SimpleDoubleProperty();
        IntegerProperty cantidad = new SimpleIntegerProperty();
       

        // Controles
        TextField tfprecioUnitario = new TextField();
        TextField tfcantidad = new TextField();
        TextField tfdescuento = new TextField();
        Label lbPrecioUnitario = new Label("Precio Unitario:");
        Label lbcantidad = new Label("Cantidad:");
        Label lbdescuento = new Label("Descuento:");
        Label lbTotal = new Label();
        Label lbMensaje = new Label();
    


        // Listeners 

        tfprecioUnitario.textProperty().addListener((obs,viejoValor,nuevoValor) -> {
            try {
                precioUnitario.set(Double.parseDouble(nuevoValor));
            } catch (NumberFormatException ex){
                precioUnitario.set(0);
            }
        });

        tfdescuento.textProperty().addListener((obs, viejoValor, nuevoValor) -> {
            try {
                descuento.set(Double.parseDouble(nuevoValor));
            } catch (NumberFormatException ex) {
                descuento.set(0);
            }
        });
        
        tfcantidad.textProperty().addListener((obs,viejoValor,nuevoValor) -> {
            try {
                cantidad.set(Integer.parseInt(nuevoValor));
            }catch (NumberFormatException ex){
                cantidad.set(0);
            }
        });

        // Bindings
        tfprecioUnitario.textProperty().bindBidirectional(precioUnitario, new NumberStringConverter());
        tfcantidad.textProperty().bindBidirectional(cantidad, new NumberStringConverter());
        tfdescuento.textProperty().bindBidirectional(descuento, new NumberStringConverter());

        DoubleBinding total = precioUnitario.multiply(cantidad).subtract(precioUnitario.multiply(cantidad).multiply(descuento.divide(100.0)));
        
         StringBinding totalFormateado = (StringBinding) Bindings.format("Total: %.2f€", total);
         lbTotal.textProperty().bind(totalFormateado);
        
         lbMensaje.textProperty().bind(Bindings.when(total.greaterThan(100)).then("precio alto").otherwise(""));

       
        VBox root = new VBox(10);
        root.getChildren().addAll(lbPrecioUnitario,tfprecioUnitario,lbcantidad,tfcantidad,lbdescuento,tfdescuento,lbTotal,lbMensaje);
        Scene scene = new Scene(root,300,250);
        stage.setScene(scene);
        stage.setTitle("Calculadora con Bindings bidireccionales");
        stage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}