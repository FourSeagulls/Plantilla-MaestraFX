package org.maestra.controllers.form;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FormController_2 {


    @FXML
    Button form_3_btn;
    @FXML
    public void abrirFormulario3() throws Exception {
        System.out.println("abrirFormulario3");

        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/maestra/form/FormView_3.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 400, 600);

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("Formulario 3");
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
