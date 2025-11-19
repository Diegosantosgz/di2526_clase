package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio17 extends Application {

    // CALCULADORA DE PRECIO TOTAL SIN BINDINGS (LISTENERS MANUALES)

    public void start(Stage stage) {

        // --- PROPIEDADES ---
        // Propiedad observable para el precio unitario (tipo double)
        DoubleProperty precioUnitario = new SimpleDoubleProperty();
        // Propiedad observable para la cantidad (tipo int)
        IntegerProperty cantidad = new SimpleIntegerProperty();
        // Si quisiéramos, podríamos tener también una propiedad "total", pero aquí se calcula directamente
        // DoubleProperty total = new SimpleDoubleProperty();


        // --- CONTROLES ---
        // Campo de texto donde el usuario introduce el precio unitario
        TextField tfPrecioUnitario = new TextField();
        // Campo de texto donde el usuario introduce la cantidad
        TextField tfCantidad = new TextField();
        // Etiqueta donde se mostrará el total calculado
        Label labelTotal = new Label();
        // Etiqueta con el texto "Precio Unitario:"
        Label lbPrecioUnitario = new Label("Precio Unitario:");
        // Etiqueta con el texto "Cantidad:"
        Label lbcantidad = new Label("Cantidad:");


        // --- LISTENERS SOBRE LOS TEXTFIELD ---
        // Este listener se activa cada vez que cambia el texto en el campo del precio unitario
        tfPrecioUnitario.textProperty().addListener((obs, viejoValor, nuevoValor) -> {
            try {
                // Intentamos convertir el texto introducido a número (double)
                precioUnitario.set(Double.parseDouble(nuevoValor));
            } catch (NumberFormatException ex) {
                // Si el usuario escribe algo no numérico, establecemos el valor a 0
                precioUnitario.set(0);
            }
        });

        // Listener para el campo de cantidad
        tfCantidad.textProperty().addListener((obs, viejoValor, nuevoValor) -> {
            try {
                // Intentamos convertir el texto introducido a número entero (int)
                cantidad.set(Integer.parseInt(nuevoValor));
            } catch (NumberFormatException ex) {
                // Si el texto no es un número válido, se pone a 0
                cantidad.set(0);
            }
        });


        // --- LISTENERS SOBRE LAS PROPIEDADES ---
        // Este listener se ejecuta cada vez que cambia el valor del precio unitario
        precioUnitario.addListener((obs, viejoValor, nuevoValor) -> {
            // Calculamos el total multiplicando precio por cantidad
            double total = precioUnitario.get() * cantidad.get();
            // Mostramos el total en el label, formateado con 2 decimales y el símbolo del euro
            labelTotal.setText(String.format("Total: %.2f €", total));
        });

        // Este listener se ejecuta cada vez que cambia la cantidad
        cantidad.addListener((obs, viejoValor, nuevoValor) -> {
            // Calculamos nuevamente el total
            double total = precioUnitario.get() * cantidad.get();
            // Actualizamos el texto del label con el nuevo total
            labelTotal.setText(String.format("Total: %.2f €", total));
        });


        // --- LAYOUT ---
        // Creamos un contenedor vertical (VBox) con separación de 10 píxeles entre los elementos
        VBox root = new VBox(10);

        // Añadimos los controles al contenedor, en el orden en que aparecerán
        root.getChildren().addAll(lbPrecioUnitario, tfPrecioUnitario, lbcantidad, tfCantidad, labelTotal);

        // Creamos la escena (ventana gráfica) con tamaño 250x150 píxeles
        Scene scene = new Scene(root, 250, 150);

        // Asignamos la escena a la ventana principal (stage)
        stage.setScene(scene);
        // Establecemos el título de la ventana
        stage.setTitle("Calculadora de precio total");
        // Mostramos la ventana
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}



/* Imos crear unha calculadora en JavaFX que permita calcular o prezo total dun artigo a partir do prezo unitario e da cantidade, empregando listeners manuais en lugar da API de Bindings de JavaFX.

A interface gráfica terá:

Un campo para introducir o prezo unitario.
Un campo para introducir a cantidade.
Unha etiqueta que amose o prezo total.
O prezo total debe actualizarse automáticamente cando se cambie xa sexa o prezo unitario ou a cantidade.

!. Pistas
Usa propiedades (DoubleProperty, IntegerProperty) para gardar o prezo unitario e a cantidade.
Engade listeners ás propiedades para recalcular o prezo total cando cambie calquera delas.
Engade tamén listeners ao texto dos TextField (textProperty()) para converter a entrada a número e actualizar as propiedades correspondentes.
Formatea o prezo total a 2 decimais antes de amosalo no Label.


!. Extras
Engadir un campo para introducir un desconto en % e aplicalo no cálculo do total.
Amosar unha mensaxe de "Prezo alto" se o total supera os 100€ (usando un if normal, non Bindings). */








/*Exercicio 17 (solucion Patricia)
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio17 extends Application {
	 @Override
	    public void start(Stage stage) {
	        // Modelo de datos
	        DoubleProperty prezo_unitario = new SimpleDoubleProperty();
	        IntegerProperty cantidade = new SimpleIntegerProperty();

	        // Campos de entrada
	        TextField prezo_unitarioField = new TextField();
	        TextField cantidadeField = new TextField();

	        // Etiqueta para o prezo total
	        Label prezoTotalField = new Label("Total: 0.00€");

	        // Listener manual para actualizar o total cando cambia o prezo_unitario
	        prezo_unitario.addListener((obs, oldVal, newVal) -> {
	            double total = newVal.doubleValue() * cantidade.get();
	            prezoTotalField.setText(String.format("Total: %.2f€", total));
	        });

	        // Listener para actualizar o total cando cambia a cantidade
	        cantidade.addListener((obs, oldVal, newVal) -> {
	            double total = prezo_unitario.get() * newVal.intValue();
	            prezoTotalField.setText(String.format("Total: %.2f€", total));
	        });

	        // Listener para entrada de texto no campo prezo_unitario
	        prezo_unitarioField.textProperty().addListener((obs, oldVal, newVal) -> {
	            try {
	                if (!newVal.isEmpty()) {
	                    prezo_unitario.set(Double.parseDouble(newVal));
	                }
	            } catch (NumberFormatException e) {
	                // Ignorar valores inválidos
	            }
	        });

	        // Listener para entrada de texto no campo cantidade
	        cantidadeField.textProperty().addListener((obs, oldVal, newVal) -> {
	            try {
	                if (!newVal.isEmpty()) {
	                    cantidade.set(Integer.parseInt(newVal));
	                }
	            } catch (NumberFormatException e) {
	                // Ignorar valores inválidos
	            }
	        });

	        VBox root = new VBox(
	            new Label("Precio unitario:"), prezo_unitarioField,
	            new Label("Cantidade:"), cantidadeField,
	            prezoTotalField
	        );

	        Scene scene = new Scene(root, 300, 200);
	        stage.setScene(scene);
	        stage.setTitle("Calculadora de prezo total (listeners manuais)");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch();
	    }
} */









/* Exercicio17_extra.java
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercicio_17_extra extends Application {
	@Override
    public void start(Stage stage) {
        // Modelo de datos
        DoubleProperty prezo_unitario = new SimpleDoubleProperty();
        IntegerProperty cantidade = new SimpleIntegerProperty();
        
        //- 1 Incorporamos o dato desconto
        DoubleProperty desconto = new SimpleDoubleProperty();

        // Campos de entrada
        TextField prezo_unitarioField = new TextField();
        TextField cantidadeField = new TextField();
        //- 2 Incorporamos o campo desconto
        TextField descontoField = new TextField();

        // Etiqueta para o prezo total
        Label prezoTotalField = new Label("Total: 0.00€");

        //- 5 Dependendo do valor do totalConDesconto mandamos a alerta ou non cun if normal
        Label alertLbl = new Label();

        //- 3 Agora o prezoTotal tamén deberá escoitar ao desconto por se cambia polo que engadimos un listener a desconto e refacer os outros listener para que no calculo teñan en conta o que vale desconto
                      
        desconto.addListener((obs, oldVal, newVal) -> {
        	double total = prezo_unitario.get() * cantidade.get();
        	double totalConDesconto = total * (1 - (newVal.doubleValue()/100));
            prezoTotalField.setText(String.format("Total: %.2f€", totalConDesconto));
            if (totalConDesconto > 100) alertLbl.setText("Prezo alto");
            else alertLbl.setText("");
        });
        

        // Listener manual para actualizar o total cando cambia o prezo_unitario
        prezo_unitario.addListener((obs, oldVal, newVal) -> {
            double total = newVal.doubleValue() * cantidade.get();
            double totalConDesconto = total * (1 - (desconto.get()/100));
            prezoTotalField.setText(String.format("Total: %.2f€", totalConDesconto));
            if (totalConDesconto > 100) alertLbl.setText("Prezo alto");
            else alertLbl.setText("");
        });

        // Listener para actualizar o total cando cambia a cantidade
        cantidade.addListener((obs, oldVal, newVal) -> {
            double total = prezo_unitario.get() * newVal.intValue();
            double totalConDesconto = total * (1 - (desconto.get()/100));
            prezoTotalField.setText(String.format("Total: %.2f€", totalConDesconto));
            if (totalConDesconto > 100) alertLbl.setText("Prezo alto");
            else alertLbl.setText("");
        });

        // Listener para entrada de texto no campo prezo_unitario
        prezo_unitarioField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                if (!newVal.isEmpty()) {
                    prezo_unitario.set(Double.parseDouble(newVal));
                }
            } catch (NumberFormatException e) {
                // Ignorar valores inválidos
            }
        });

        // Listener para entrada de texto no campo cantidade
        cantidadeField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                if (!newVal.isEmpty()) {
                    cantidade.set(Integer.parseInt(newVal));
                }
            } catch (NumberFormatException e) {
                // Ignorar valores inválidos
            }
        });
     
        //- 4 Listener para entrada de texto no campo desconto
        descontoField.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                if (!newVal.isEmpty()) {
                    desconto.set(Integer.parseInt(newVal));
                }
            } catch (NumberFormatException e) {
                // Ignorar valores inválidos
            }
        });

        
        VBox root = new VBox(
            new Label("Precio unitario:"), prezo_unitarioField,
            new Label("Cantidade:"), cantidadeField,
            new Label("Desconto:"), descontoField,
            prezoTotalField,
            alertLbl
        );

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Calculadora de prezo total (listeners manuais)");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    } */