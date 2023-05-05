package com.dentist;

import com.dentist.sqllite.SQL_methods;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;

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
        SQL_methods sql = new SQL_methods();
        sql.connectionHandle();
        launch();
    };

}
