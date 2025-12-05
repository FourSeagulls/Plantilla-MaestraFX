package org.maestra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vistas/PrincipalView.fxml"));
        Scene scene = new Scene(loader.load(), 600, 400);
//        scene.getStylesheets().add(MainApp.class.getResource("estilos.css").toExternalForm());
        // 1. Aplica la hoja de estilos GLOBALMENTE para toda la aplicación.
        Application.setUserAgentStylesheet(MainApp.class.getResource("estilos.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("MaestraFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
