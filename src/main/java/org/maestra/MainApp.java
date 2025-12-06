package org.maestra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.maestra.datos.DatosCompartidos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vistas/PrincipalView.fxml"));
        Scene scene = new Scene(loader.load(), 600, 500);
//        scene.getStylesheets().add(MainApp.class.getResource("estilos.css").toExternalForm());
        // 1. Aplica la hoja de estilos GLOBALMENTE para toda la aplicación.
        Application.setUserAgentStylesheet(MainApp.class.getResource("estilos.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("MaestraFX");

        // ¡¡IMPORTANTE!! Guardar todo al cerrar la ventana
        primaryStage.setOnCloseRequest(event -> {
            DatosCompartidos.getInstance().guardarSesion();
            System.out.println("Aplicación cerrada – datos guardados.");
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
