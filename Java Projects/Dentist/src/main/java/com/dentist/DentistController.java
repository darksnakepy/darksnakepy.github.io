package com.dentist;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class DentistController {

    @FXML
    ImageView imageviewer;
    Image img = new Image("file:dentist.png");

    public void displayImage(){
        imageviewer.setImage(img);
    }


    @FXML
    protected void register() throws IOException { // opens the register form
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register-form.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setWidth(600);
        stage.setHeight(400);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }

}