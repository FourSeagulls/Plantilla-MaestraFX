package org.maestra.controllers;


import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PizarrinController {

    @FXML
    private Canvas pizarrinCanvas;
    @FXML
    private Button elegirColor_btn;

    private GraphicsContext gc;
    private boolean isDrawing = false;
    private Color currentColor = Color.BLACK;

    @FXML
    private void initialize() {
        gc = pizarrinCanvas.getGraphicsContext2D();
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);

        // Set up mouse events for drawing
        pizarrinCanvas.setOnMousePressed(this::startDrawing);
        pizarrinCanvas.setOnMouseDragged(this::draw);
        pizarrinCanvas.setOnMouseReleased(this::stopDrawing);
    }

    @FXML
    private void elegirColor() {
        ColorPicker colorPicker = new ColorPicker(currentColor);

        // Create a new stage for the color picker
        Stage colorStage = new Stage();
        colorStage.initModality(Modality.APPLICATION_MODAL); // Makes it a modal dialog
        colorStage.setTitle("Choose Color");

        // Set the scene with the color picker
        Scene scene = new Scene(colorPicker);
        colorStage.setScene(scene);

        colorPicker.setOnAction(event -> {
            currentColor = colorPicker.getValue();
            gc.setStroke(currentColor);
            colorStage.close(); // Close the color picker after selection
        });

        // Show the color picker
        colorStage.showAndWait(); // This makes the window wait for user interaction
    }


    /*
    @FXML
    private void handleColorButton() {
        ColorPicker colorPicker = new ColorPicker(currentColor);
        colorPicker.setOnAction(event -> {
            currentColor = colorPicker.getValue();
            gc.setStroke(currentColor);
        });

        // You can show the color picker in a dialog or as a popup
        // For simplicity, here's a basic implementation:
        colorPicker.show();
    }
*/
    private void startDrawing(MouseEvent event) {
        isDrawing = true;
        gc.beginPath();
        gc.moveTo(event.getX(), event.getY());
    }

    private void draw(MouseEvent event) {
        if (isDrawing) {
            gc.lineTo(event.getX(), event.getY());
            gc.stroke();
        }
    }

    private void stopDrawing(MouseEvent event) {
        isDrawing = false;
    }

    // Optional: Method to clear the canvas
    public void clearCanvas() {
        gc.clearRect(0, 0, pizarrinCanvas.getWidth(), pizarrinCanvas.getHeight());
    }

    // Optional: Method to change drawing color
    public void setDrawingColor(Color color) {
        gc.setStroke(color);
    }

    // Optional: Method to change line width
    public void setLineWidth(double width) {
        gc.setLineWidth(width);
    }

    @FXML
    private void setColorRed() {
        currentColor = Color.RED;
        gc.setStroke(currentColor);
    }

    @FXML
    private void setColorBlue() {
        currentColor = Color.BLUE;
        gc.setStroke(currentColor);
    }

    @FXML
    private void setColorGreen() {
        currentColor = Color.GREEN;
        gc.setStroke(currentColor);
    }

    @FXML
    private void setColorBlack() {
        currentColor = Color.BLACK;
        gc.setStroke(currentColor);
    }

}
