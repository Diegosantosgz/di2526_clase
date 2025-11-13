package com.jdojo.binding;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ejercicio16 extends Application{

    // VINCULACIÓN BIDIRECCIONAL EN JAVAFX

    public void start(Stage stage){

    // 1. Crear la propiedad 'nome' que almacenará un texto.
    // StringProperty es observable, lo que permite que se vincule a controles de JavaFX
    StringProperty nome = new SimpleStringProperty(); // inicialmente está vacío

    // 2. Crear el campo de texto (TextField) donde el usuario escribirá el nombre
    TextField campoTexto = new TextField();

    // 3. Vincular bidireccionalmente el campo de texto con la propiedad 'nome'
    // Esto significa que si el usuario escribe en el TextField, la propiedad 'nome' cambia,
    // y si cambiamos 'nome' desde código, el TextField también se actualiza automáticamente
    campoTexto.textProperty().bindBidirectional(nome);

    // 4. Crear un Label que también esté vinculado a la propiedad 'nome'
    // Esto permite que el Label muestre automáticamente el valor de 'nome'
    Label label = new Label();
    label.textProperty().bind(nome); // vinculación unidireccional: la propiedad 'nome' actualiza el Label

    // 5. Crear un botón que cambie el valor de 'nome' a "Invitado"
    Button botonCambiar = new Button("Cambiar a Invitado");
    botonCambiar.setOnAction(e -> {
        // Al hacer clic, se cambia la propiedad 'nome'
        // Esto actualizará automáticamente el TextField y el Label gracias a la vinculación
        nome.setValue("Invitado");
    });

    // 6. Organizar los controles en un VBox (columna vertical) con separación de 10px
    VBox root = new VBox(10);

    root.getChildren().addAll(campoTexto,label,botonCambiar);

    // 7. Crear la escena y asignarla al escenario (ventana)
    Scene scene = new Scene(root, 300, 100);

    stage.setScene(scene);
    stage.setTitle("Ejercicio Vinculación Bidireccional");
    stage.show(); 
}

public static void main(String[] args) {
    Application.launch(args); 
    }
}


/* Como se indicou no apartado 1.10 Que é un Binding no que se explicou as vinculacións, nas aplicacións de interface gráfica empregase a vinculación bidireccional para manter sincronizados os valores do modelo de datos e o valor da interface gráfica.

Imos crear unha pequena aplicación JavaFX con un campo de texto para introducir o nome dun usuario. Este campo estará vinculado bidireccionalmente cunha propiedade do modelo de datos.

Instruccións
Crear unha propiedade StringProperty chamada nome.
Crear un TextField que permita modificar o valor da propiedade nome.
Vincular bidireccionalmente o TextField coa propiedade nome.
Crear un Label que estea vinculado unidireccionalmente á propiedade nome.
Engadir un botón que ao ser premido cambie o valor da propiedade nome a un texto fixo (exemplo: "Invitado") vendo así a bidireccionalidade, xa que ao cambiar a propiedade nome debería tamén cambiar o texto do TextField.
Observar como o campo de texto se actualiza automaticamente cando cambia a propiedade.

Dase un código inicial (esqueleto):

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExercicioY extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Crear a propiedade nome
        StringProperty nome = /* Completar aquí */;

        // 2. Crear o campo de texto
        // TextField campoTexto = new TextField();

        // 3. Vincular bidireccionalmente o campo de texto coa propiedade nome
        /* Completar aquí */

        //4. Crea un Label que estea vinculado á propiedade nome
        /* Completar aquí */

        // 5. Crear un botón para cambiar o valor de nome a "Invitado"
        // Button botonCambiar = new Button("Cambiar a Invitado");
        // botonCambiar.setOnAction(e -> {
            /* Completar aquí */
    /*     });

        VBox root = new VBox(10, campoTexto, botonCambiar);
        Scene scene = new Scene(root, 300, 100);

        stage.setScene(scene);
        stage.setTitle("Exercicio Vinculación Bidireccional");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

Preguntas:

Completa o código para que funcione a vinculación bidireccional.
Que pasa cando o usuario escribe no campo de texto?
Que pasa cando premes o botón?  */