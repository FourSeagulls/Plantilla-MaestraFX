package org.maestra.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class CreditosController {
    @FXML
    public Label creditos_lbl;

    @FXML
    public void initialize() {
        String textoLargo = "Este es un texto dinámico escrito y controlado desde el contolador del créditos View...";
        creditos_lbl.setText(textoLargo);
        creditos_lbl.setTextFill(Color.RED);
    }
}

