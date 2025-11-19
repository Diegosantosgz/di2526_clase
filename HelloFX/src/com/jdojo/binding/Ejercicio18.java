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
    // Método principal de la interfaz. Aquí se arma toda la ventana.

    // Propiedades (almacenan valores numéricos observables)
    DoubleProperty precioUnitario = new SimpleDoubleProperty();
    // Propiedad double para guardar el precio unitario.

    DoubleProperty descuento = new SimpleDoubleProperty();
    // Propiedad double para guardar el descuento (%).

    IntegerProperty cantidad = new SimpleIntegerProperty();
    // Propiedad int para guardar la cantidad de productos.


    // Controles (elementos visuales)
    TextField tfprecioUnitario = new TextField();
    // Campo donde se escribe el precio unitario.

    TextField tfcantidad = new TextField();
    // Campo donde se escribe la cantidad.

    TextField tfdescuento = new TextField();
    // Campo donde se escribe el descuento.

    Label lbPrecioUnitario = new Label("Precio Unitario:");
    // Etiqueta para identificar el campo del precio.

    Label lbcantidad = new Label("Cantidad:");
    // Etiqueta para identificar el campo de cantidad.

    Label lbdescuento = new Label("Descuento:");
    // Etiqueta para identificar el campo del descuento.

    Label lbTotal = new Label();
    // Aquí se mostrará el total calculado.

    Label lbMensaje = new Label();
    // Aquí se mostrará un mensaje si el total supera 100.


    // LISTENERS (se ejecutan cuando cambia el texto de un TextField)
    tfprecioUnitario.textProperty().addListener((obs,viejoValor,nuevoValor) -> {
        // Listener para precio unitario
        try {
            precioUnitario.set(Double.parseDouble(nuevoValor));
            // Convierte el texto a double y lo guarda.
        } catch (NumberFormatException ex){
            precioUnitario.set(0);
            // Si el usuario escribe algo no numérico, se usa 0.
        }
    });

    tfdescuento.textProperty().addListener((obs, viejoValor, nuevoValor) -> {
        // Listener para descuento
        try {
            descuento.set(Double.parseDouble(nuevoValor));
            // Convierte el texto a número.
        } catch (NumberFormatException ex) {
            descuento.set(0);
            // Si falla, pone 0.
        }
    });
    
    tfcantidad.textProperty().addListener((obs,viejoValor,nuevoValor) -> {
        // Listener para cantidad
        try {
            cantidad.set(Integer.parseInt(nuevoValor));
            // Intenta convertir a entero.
        }catch (NumberFormatException ex){
            cantidad.set(0);
            // Si falla, usa 0.
        }
    });


    // BINDINGS UNIDIRECCIONALES
    // Se calcula el total automáticamente a partir de las propiedades.

    DoubleBinding total = precioUnitario.multiply(cantidad)
                        .subtract(precioUnitario.multiply(cantidad)
                        .multiply(descuento.divide(100.0)));
    // Fórmula:
    // total = precioUnitario * cantidad - (precioUnitario * cantidad * descuento/100)


    StringBinding totalFormateado = (StringBinding) Bindings.format("Total: %.2f€", total);
    // Formatea el total en un String con dos decimales.

    lbTotal.textProperty().bind(totalFormateado);
    // La etiqueta mostrará siempre el total actualizado.


    lbMensaje.textProperty().bind(
        Bindings.when(total.greaterThan(100))
        .then("precio alto")
        .otherwise("")
    );
    // Si el total > 100 muestra "precio alto", si no muestra vacío.


    // Layout visual (VBox = elementos en columna)
    VBox root = new VBox(10);
    // VBox con espacio de 10 píxeles entre elementos.

    root.getChildren().addAll(
        lbPrecioUnitario, tfprecioUnitario,
        lbcantidad, tfcantidad,
        lbdescuento, tfdescuento,
        lbTotal, lbMensaje
    );
    // Agrega los controles al layout.


    Scene scene = new Scene(root,300,250);
    // Crea la escena con tamaño 300x250 px.

    stage.setScene(scene);
    // Coloca la escena dentro de la ventana.

    stage.setTitle("Calculadora con Bindings unidireccionales");
    // Título de la ventana.

    stage.show();
    // Muestra la ventana al usuario.
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