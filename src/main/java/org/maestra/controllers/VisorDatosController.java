package org.maestra.controllers;


import org.maestra.datos.DatosCompartidos;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VisorDatosController {

    @FXML private TextField txtNombre;
    @FXML private Label lblResumen;
    @FXML private Label lblLogros;

    // Se ejecuta automáticamente al cargar la ventana
    @FXML
    private void initialize() {
        actualizarDatosEnPantalla();
    }

    @FXML
    private void GuardarNombre() {
        String nombre = txtNombre.getText().trim();
        DatosCompartidos.getInstance().setNombreJugador(nombre);
        actualizarDatosEnPantalla();
    }

    @FXML
    private void sumar100() {
        DatosCompartidos.getInstance().sumarPuntos(100);
        actualizarDatosEnPantalla();
    }

    private void actualizarDatosEnPantalla() {
        lblResumen.setText(DatosCompartidos.getInstance().getResumen());

        StringBuilder sb = new StringBuilder("Logros:\n");
        for (String logro : DatosCompartidos.getInstance().getLogros()) {
            sb.append("• ").append(logro).append("\n");
        }
        lblLogros.setText(sb.toString());
    }
}