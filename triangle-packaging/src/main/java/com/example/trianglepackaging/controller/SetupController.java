package com.example.trianglepackaging.controller;

import com.example.trianglepackaging.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetupController {
    public static int numberOfBoxes;
    public static double height;
    public static double width;

    @FXML
    private Button btn_fileChooser;
    @FXML
    private TextField box_numbers;
    @FXML
    private TextField box_height;
    @FXML
    private TextField box_width;

    public void initialize() {
        box_numbers.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    box_numbers.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        box_height.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    box_height.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });

        box_width.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!t1.matches("\\d*")) {
                    box_width.setText(t1.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    /**
     * btn-"Datei auswählen"
     */
    @FXML
    protected void chooseFile(){
        List<String> possibleFiles = new ArrayList<>();
        possibleFiles.add("*.txt");

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", possibleFiles));

        File f = fc.showOpenDialog(null);
        if (f != null){
            btn_fileChooser.setText(f.getName());
        }
        assert f != null;
        String fullPathOfTextfile =  f.getAbsolutePath();
        System.out.println(fullPathOfTextfile);
    }

    /**
     * btn-"Beenden"
     */
    @FXML
    protected void closeSetup(){
        System.out.println("Closing Program...");
        System.exit(0);
    }

    /**
     * btn-"Füllen"
     * validate textfields
     * create new stage
     * create new scene
     */
    @FXML
    protected void startFill(){

        if(box_numbers.getText() == null || box_numbers.getText().trim().isEmpty()){
            numberOfBoxes = 1;
        } else {
            numberOfBoxes = Integer.parseInt(box_numbers.getText());
        }

        if(box_height.getText() == null || box_height.getText().trim().isEmpty()){
            height = 300;
        } else {
            height = Double.parseDouble(box_height.getText());
        }

        if(box_width.getText() == null || box_width.getText().trim().isEmpty()){
            width = 400;
        } else {
            width = Double.parseDouble(box_width.getText());
        }

        System.out.println("Boxen werden gefüllt...");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("transportbox.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Transportboxen");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}