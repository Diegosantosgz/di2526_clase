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

public class Ejercicio18 extends Application{

    // CALCULADORA CON BINDINGS UNIDIRECCIONALES

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
        DoubleBinding total = precioUnitario.multiply(cantidad).subtract(precioUnitario.multiply(cantidad).multiply(descuento.divide(100.0)));
        
        StringBinding totalFormateado = (StringBinding) Bindings.format("Total: %.2f€", total);
        lbTotal.textProperty().bind(totalFormateado);
        
        lbMensaje.textProperty().bind(Bindings.when(total.greaterThan(100)).then("precio alto").otherwise(""));

       
        VBox root = new VBox(10);
        root.getChildren().addAll(lbPrecioUnitario,tfprecioUnitario,lbcantidad,tfcantidad,lbdescuento,tfdescuento,lbTotal,lbMensaje);
        Scene scene = new Scene(root,300,250);
        stage.setScene(scene);
        stage.setTitle("Calculadora con Bindings unidireccionales");
        stage.show();


    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}


/* Imos modificar o exercicio anterior e en vez de usar listeners manuais empregaremos a Binding API de JavaFX para que o total se actualice automaticamente cando cambien os valores.

Requisitos da interface gráfica

Un campo para introducir o prezo unitario.
Un campo para introducir a cantidade.
Un campo para introducir un desconto en %.
Unha etiqueta que amose o prezo total.
O prezo total debe actualizarse automaticamente cando se cambie calquera dos tres valores.
Mostrar unha mensaxe de "Prezo alto" se o total supera os 100€, empregando Bindings.when(...).then(...).otherwise(...).

!. Pistas
Emprega propiedades (DoubleProperty, IntegerProperty) para o prezo unitario, cantidade e desconto.
Crea un DoubleBinding que calcule o total con desconto:
DoubleBinding total = prezoUnitario.multiply(cantidade)
                                 .subtract(prezoUnitario.multiply(cantidade).multiply(desconto.divide(100)));


Formatea a saída a 2 decimais usando Bindings.format("Total: %.2f€", total) e castea a StringBinding
Emprega Bindings.when(...).then(...).otherwise(...) para a mensaxe de prezo alto.
Para a actualización dos campos de propiedades dependentes do textProperty() dos TextField deberás de seguir empregando listener manuais. */