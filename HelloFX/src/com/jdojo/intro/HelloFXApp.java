package com.jdojo.intro;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

		// Crear un boton con el texto "Salir"
		Button exitBtn = new Button("Exit");

		// Usando una expresión lambda
		exitBtn.setOnAction(e -> Platform.exit());

		// Usando unha clase anónima
		exitBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				Platform.exit();
			}

		});

	}
}
