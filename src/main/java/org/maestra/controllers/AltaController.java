package org.maestra.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AltaController {
    @FXML
    TextField nombreTextField;
    @FXML
    TextField apodoTextField;
    @FXML
    Button altaConfirma_btn;
    @FXML
    Label confirmado_lbl;
    @FXML
    public void confirmarAlta() {
        System.out.println("Nombre: " + nombreTextField.getText());
        System.out.println("Apodo: " + apodoTextField.getText());
        confirmado_lbl.setText("Alta realizada con exito " + nombreTextField.getText() + " " + apodoTextField.getText());
    }


}
