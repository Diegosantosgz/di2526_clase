package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Ejercicio1 extends Application {

	public void start(Stage stage) {
		// Creamos un Group para el nodo raíz.
		Group gr = new Group();
		// Creamos una escena en la que le pasamos los el nodo,la altura y la anchura en pixeles
		Scene scene = new Scene(gr, 400, 300);

		// Declaramos 2 Strings, uno para el título original de la ventana y otro para el titulo cambiado cuando se pulse el boton
		String tituloOriginal = "miña primeira xanela";
		String tituloCambiado = "titulo cambiado";

		// Creamos el botón y hacemos que ponga en este caso: "Cambiar título"
		Button cambioBtn = new Button("Cambiar Título");
		
		// Hacemos un evento donde el boton compare que titulo tiene, si es el original, pondrá el cambiado, sino pondrá el original de nuevo
		cambioBtn.setOnAction(e -> {
			if (stage.getTitle().equals(tituloOriginal)) {
				stage.setTitle(tituloCambiado);
			} else {
				stage.setTitle(tituloOriginal);
			}
		});

		// Hacemos que el nodo coja a los hijos creados, en este caso solo el botón
		gr.getChildren().addAll(cambioBtn);
 
		// Le damos por primera vez el titulo a la ventana, el original
		stage.setTitle(tituloOriginal);

		// Creamos la escena
		stage.setScene(scene);

		// Mostramos la escena
		stage.show();
	}

	
	public static void main(String[] args) {
		// Necesitamos que el main ejecute los parametros recibidos de Application y los lance
		Application.launch(args);
	}

}
