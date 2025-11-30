package org.maestra.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PrincipalController {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction() {
        label.setText("¡Botón pulsado!");
    }

    @FXML
    private void seguir() throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/maestra/SiguienteView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 600);

        // Create a new stage
        Stage stage = new Stage();
        stage.setScene(scene);

        // Establece el tamaño mínimo de la ventana
        stage.setMinWidth(800);
        stage.setMinHeight(600);

// Opcional: Establece el tamaño preferido
        stage.setWidth(800);
        stage.setHeight(600);

        // Show the new stage
        stage.show();
    }

}
