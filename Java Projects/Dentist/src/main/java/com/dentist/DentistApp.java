package com.dentist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

public class DentistApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DentistApp.class.getResource("dentist-main.fxml"));
        stage.setResizable(false);
        stage.setWidth(600);
        stage.setHeight(400);
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dentist");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}