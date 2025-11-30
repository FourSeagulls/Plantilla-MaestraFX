package org.maestra.controllers;


import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class SiguienteController {
    @FXML
    private Canvas drawingCanvas;
    @FXML
    private Button colorButton;

    private GraphicsContext gc;
    private boolean isDrawing = false;
    private Color currentColor = Color.BLACK;

    @FXML
    private void initialize() {
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setLineWidth(2);
        gc.setStroke(Color.BLACK);

        // Set up mouse events for drawing
        drawingCanvas.setOnMousePressed(this::startDrawing);
        drawingCanvas.setOnMouseDragged(this::draw);
        drawingCanvas.setOnMouseReleased(this::stopDrawing);
    }

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
        gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
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

}
