package org.maestra.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class PrincipalController {

    @FXML
    private Label label;

    @FXML
    private void pulsamePulsado() {

        // Crear un cuadro de diálogo de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null); // Opcional: para que no se muestre el encabezado
        alert.setContentText("¿Estás seguro de que quieres realizar esta acción?");

        // Mostrar el diálogo y esperar la respuesta del usuario
        Optional<ButtonType> result = alert.showAndWait();

        // Comprobar qué botón ha pulsado el usuario
        if (result.isPresent() && result.get() == ButtonType.OK) {
            System.out.println("El usuario ha confirmado la acción.");
            label.setText("¡Te has atrevido a hacerlo!");
        } else {
            System.out.println("El usuario ha cancelado la acción.");
            label.setText("¡Demasiado tarde para arrepentimientos!");
        }
    }

    @FXML
    private void abrirPizarrin() throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/maestra/PizarrinView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 600);

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("El Pizarrín");
        stage.setScene(scene);

        // Establece el tamaño mínimo de la ventana
        stage.setMinWidth(800);
        stage.setMinHeight(700);

        // Opcional: Establece el tamaño preferido
        stage.setWidth(800);
        stage.setHeight(700);

        // Show the new stage
        stage.show();
    }


    @FXML
    private void abrirFiguras() throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/maestra/FigurasView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800, 600);

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("Creador de figuras");
        stage.setScene(scene);

        // Establece el tamaño mínimo de la ventana
        stage.setMinWidth(800);
        stage.setMinHeight(700);

        // Opcional: Establece el tamaño preferido
        stage.setWidth(800);
        stage.setHeight(700);

        // Show the new stage
        stage.show();
    }

    @FXML
    Button alta_btn;
    @FXML
    public void abrirAlta() throws IOException {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/maestra/AltaView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("Panel solo se socios");
        stage.setScene(scene);

        // Establece el tamaño mínimo de la ventana
        stage.setMinWidth(600);
        stage.setMinHeight(200);

        // Opcional: Establece el tamaño preferido
        stage.setWidth(600);
        stage.setHeight(300);

        // Show the new stage
        stage.show();

    }

    @FXML
    Button creditos_btn;
    @FXML
    public void abrirCreditos() throws IOException {
        System.out.println("¿Cuál es el problema?");
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/maestra/CreditosView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("Créditos");
        stage.setScene(scene);

        // Establece el tamaño mínimo de la ventana
        stage.setMinWidth(600);
        stage.setMinHeight(200);

        // Opcional: Establece el tamaño preferido
        stage.setWidth(600);
        stage.setHeight(300);

        // Show the new stage
        stage.show();
    }


}
