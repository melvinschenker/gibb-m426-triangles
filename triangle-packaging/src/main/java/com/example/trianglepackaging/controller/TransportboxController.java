package com.example.trianglepackaging.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TransportboxController {
    private final int numberOfBoxes = SetupController.numberOfBoxes;
    private final double boxHeight = SetupController.height;
    private final double boxWidth= SetupController.width;

    @FXML
    public Pane TransportboxenPane;
    @FXML
    public TabPane TransportboxenTabPane;
    /**
     * initialize
     */
    public void initialize() {
        System.out.println("Anzahl Boxen: " + numberOfBoxes);
        System.out.println("Grösse der Boxen: " + boxHeight + " x " + boxWidth);
        createPane(boxHeight,boxWidth);
        createTabpane(boxHeight,boxWidth);
    }

    /**
     * create pane
     */
    private void createPane(double boxHeight, double boxWidth) {
        TransportboxenPane.setPrefSize(boxWidth,boxHeight+100);
    }

    /**
     * create tabpane
     */
    private void createTabpane(double boxHeight, double boxWidth) {
        TransportboxenTabPane.setPrefSize(boxWidth,boxHeight+67);
        addTabs(numberOfBoxes);
    }

    /**
     * adding boxes
     */
    private void addTabs(int numberOfBoxes) {
        for (int i = 1; i <= numberOfBoxes; i++){
            Tab tab = new Tab("Box: " + i);
            tab.setContent(createCanvas());
            TransportboxenTabPane.getTabs().add(tab);
            TransportboxenTabPane.getSelectionModel().select(tab);
        }
    }

    /**
     * create canvas for drawing the triangles
     */
    private Node createCanvas() {
        Canvas canvas = new Canvas(boxWidth, boxHeight);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(204, 255, 255));
        gc.fillRect(0, 0, boxWidth, boxHeight);
        draw(canvas);
        return canvas;
    }

    /**
     * drawing triangles
     */
    private void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int firstX = 0;
        int secondX = 200;
        int thirdX = 100;

        int firstY =0;
        int secondY =0;
        int thirdY =150;

        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.fillPolygon(new double[]{firstX, secondX,thirdX},
                new double[]{firstY, secondY, thirdY}, 3);

        gc.strokePolygon(new double[]{firstX, secondX,thirdX},
                new double[]{firstY, secondY, thirdY}, 3);

        gc.setFill(javafx.scene.paint.Color.BLACK);
        gc.fillText("1", firstX - 3, firstY - 4);
        gc.fillText("2", secondX - 3, secondY - 4);
        gc.fillText("3", thirdX - 3, thirdY - 4);
    }

    /**
     * btn-"Exportieren"
     */
    public void exportFile(ActionEvent actionEvent) {
        System.out.println("Dateien werden exportiert...");
    }

    /**
     * btn-"Abbrechen"
     */
    public void cancel(ActionEvent actionEvent) {
        System.out.println("Schliesse Transportboxen");
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
}
