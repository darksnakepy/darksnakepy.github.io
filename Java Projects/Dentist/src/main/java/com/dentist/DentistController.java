package com.dentist;

import com.dentist.sqllite.SQL_methods;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class DentistController {
    @FXML
    Label viewPatients;
    SQL_methods sql = new SQL_methods();

    ListView<String> patientListView = new ListView<>();
    String[] data = sql.getData();
    public DentistController() throws SQLException, IOException {
    }

    @FXML
    protected void register() throws IOException { // opens the register form
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register-form.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setWidth(750);
        stage.setHeight(540);
        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }


}