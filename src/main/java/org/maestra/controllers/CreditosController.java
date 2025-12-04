package org.maestra.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.maestra.controllers.form.FormController_1;

public class CreditosController {
    @FXML
    public Label creditos_lbl;

    @FXML
    public void initialize() {
        String textoIntroForm = "Zona de formularios conectados.";
        creditos_lbl.setText(textoIntroForm);
        creditos_lbl.setTextFill(Color.RED);
    }
    @FXML
    public void abrirFormularios() throws Exception{
        System.out.println("abrirFormularios");

        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/maestra/form/FormView_1.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 400, 600);

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("Formulario 1");
        stage.setScene(scene);

        // Establece el tamaño mínimo de la ventana
        stage.setMinWidth(400);
        stage.setMinHeight(600);

        // Opcional: Establece el tamaño preferido
        stage.setWidth(400);
        stage.setHeight(600);

        // Show the new stage
        stage.show();

    }
}

