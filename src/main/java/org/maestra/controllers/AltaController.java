package org.maestra.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AltaController {
    @FXML
    TextField campoNombre;
    @FXML
    TextField campoApodo;
    @FXML
    Button altaConfirma_btn;
    @FXML
    Label confirmado_lbl;
    @FXML
    public void confirmarAlta() {
        System.out.println("Nombre: " + campoNombre.getText());
        System.out.println("Apodo: " + campoApodo.getText());
        confirmado_lbl.setText("Alta realizada con exito " + campoNombre.getText() + " " + campoApodo.getText());
    }


}
