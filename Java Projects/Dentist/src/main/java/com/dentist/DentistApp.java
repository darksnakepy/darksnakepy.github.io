package com.dentist;

import com.dentist.sqllite.SQL_methods;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;


public class DentistApp extends Application {
    final int WIDTH = 600;
    final int HEIGHT = 400;

    @Override
    public void start(Stage stage) throws IOException {
        SaveFile saveFile = new SaveFile("patients.txt");
        FXMLLoader fxmlLoader = new FXMLLoader(DentistApp.class.getResource("dentist-main.fxml"));
        stage.setResizable(false);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dentist");
        stage.setScene(scene);
        stage.show();
        String data[] = saveFile.viewData();
        for (String patient : data) {
            System.out.println(patient); // print to debug
        }
    }

    public static void main(String[] args) throws SQLException {
        SQL_methods sql = new SQL_methods();
        sql.connectionHandle();
        sql.getData();
        launch();
    };
    // sql.getData();


}
