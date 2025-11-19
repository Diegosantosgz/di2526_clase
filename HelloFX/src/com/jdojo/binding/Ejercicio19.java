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
        
        // Propiedades (valores numéricos que se pueden enlazar a controles)
        DoubleProperty precioUnitario = new SimpleDoubleProperty();
        DoubleProperty descuento = new SimpleDoubleProperty();
        IntegerProperty cantidad = new SimpleIntegerProperty();
       

        // Controles de interfaz
        TextField tfprecioUnitario = new TextField();
        TextField tfcantidad = new TextField();
        TextField tfdescuento = new TextField();
        Label lbPrecioUnitario = new Label("Precio Unitario:");
        Label lbcantidad = new Label("Cantidad:");
        Label lbdescuento = new Label("Descuento:");
        Label lbTotal = new Label();      // Aquí se mostrará el total calculado
        Label lbMensaje = new Label();    // Mensaje adicional según el total
    


        // Listeners para validar la entrada de texto en los TextField
        // Cuando cambie el texto, intenta convertirlo a número
        // Si falla, coloca 0 para evitar errores

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

        // Bindings bidireccionales: 
        // El valor del TextField y la propiedad siempre se mantienen sincronizados.
        tfprecioUnitario.textProperty().bindBidirectional(precioUnitario, new NumberStringConverter());
        tfcantidad.textProperty().bindBidirectional(cantidad, new NumberStringConverter());
        tfdescuento.textProperty().bindBidirectional(descuento, new NumberStringConverter());

        // Binding para calcular el total:
        // total = precioUnitario * cantidad - (precioUnitario * cantidad * descuento/100)
        DoubleBinding total = precioUnitario.multiply(cantidad)
                             .subtract(precioUnitario.multiply(cantidad)
                             .multiply(descuento.divide(100.0)));
        
        // Binding para formatear el total como texto con dos decimales
        StringBinding totalFormateado = (StringBinding) Bindings.format("Total: %.2f€", total);
        lbTotal.textProperty().bind(totalFormateado);
        
        // Mostrar mensaje si el total supera 100
        lbMensaje.textProperty().bind(
            Bindings.when(total.greaterThan(100))
            .then("precio alto")
            .otherwise("")
        );

       
        // Distribución visual
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


/* Imos crear unha calculadora en JavaFX que permita calcular o prezo total dun artigo a partir do prezo unitario, cantidade e desconto, empregando bindings bidireccionais para conectar os campos de entrada coas propiedades do modelo.

Requisitos da interface

Un campo para introducir o prezo unitario.
Un campo para introducir a cantidade.
Un campo para introducir un desconto en %.
Unha etiqueta que amose o prezo total formateado a 2 decimais.
Unha etiqueta que mostre "Prezo alto" se o total supera os 100€.

!. Atención
Como se comentou no apartado 1.18 Vinculacións unidireccionais e bidireccionais, nos bindings bidireccionais, as propiedades que se conectan deben ser do mesmo tipo.

Como TextField.textProperty() é un StringProperty e as nosas propiedades de modelo son DoubleProperty ou IntegerProperty, necesitamos un converter, como NumberStringConverter, para facer a conversión automática entre texto e número.
import javafx.util.converter.NumberStringConverter;
...
DoubleProperty prezoUnitario = new SimpleDoubleProperty();
TextField prezoUnitarioField = new TextField();

// Binding bidireccional con conversión automática entre String e Double
prezoUnitarioField.textProperty().bindBidirectional(prezoUnitario, new NumberStringConverter());


!. Pistas
Emprega bindBidirectional para conectar os TextField coas propiedades.
Usar NumberStringConverter para a conversión automática entre texto e número.
Usar Bindings para calcular o total e a mensaxe de "Prezo alto".
Non empregar listeners manuais para actualizar valores. */