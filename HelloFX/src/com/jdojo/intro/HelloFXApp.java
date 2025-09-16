package com.jdojo.intro;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFXApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		// Establecer un título para o escenario
		stage.setTitle("Aplicación JavaFX de Exemplo");
		// Amosar o escenario
		stage.show();
		// Crear un nodo VBox
		VBox root = new VBox();
		// Crear un nodo Text
		Text msg = new Text("Hello JavaFX");

		// Engadir o nodo Text ao VBox como fillo
		root.getChildren().add(msg);

		// Creamos unha escena especificando nó e tamaño
		Scene scene = new Scene(root, 300, 50);
		// Establecer a escena no escenario
		stage.setScene(scene);
		stage.setTitle("Aplicación JavaFX con unha escena");
		stage.show();
			
	}

}
