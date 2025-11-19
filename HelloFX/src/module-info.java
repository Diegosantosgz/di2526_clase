module HelloFX {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.swing;
	requires javafx.media;
	requires javafx.web;
	requires javafx.fxml;
    requires javafx.base;
	

	opens com.jdojo.intro to javafx.graphics, javafx.base;
	opens com.jdojo.binding to javafx.graphics, javafx.base;
	opens Santos_Diego to javafx.graphics, javafx.base;
	opens com.jdojo.stage to javafx.graphics, javafx.base;
}
