package org.maestra.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction() {
        label.setText("¡Botón pulsado!");
    }
}
