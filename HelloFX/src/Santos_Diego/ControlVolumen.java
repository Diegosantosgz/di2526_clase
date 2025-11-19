package Santos_Diego;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ControlVolumen extends Application {

    public void start(Stage stage) {

        // Propiedades 

        SimpleIntegerProperty volumen = new SimpleIntegerProperty();
        NumberStringConverter converter = new NumberStringConverter();

        // Componentes

        Slider slider = new Slider(0, 100, 50);

        Label lbVolumen = new Label("Volume: X%");
        Label lbIndicador = new Label();



        slider.valueProperty().bindBidirectional(volumen);
  

        // Layout

        Pane root = new Pane(lbVolumen,lbIndicador,slider);

        lbVolumen.relocate(100, 50);
        lbIndicador.relocate(50, 200);
        slider.relocate(70, 100);

        
        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("Control de volume");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
