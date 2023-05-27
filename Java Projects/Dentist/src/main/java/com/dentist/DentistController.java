package com.dentist;

import com.dentist.sqllite.SQL_methods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DentistController {

    SQL_methods sql = new SQL_methods();
    @FXML
    ListView patientList;
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

    public void updateList() throws IOException {
        try {
            ObservableList patientsL = FXCollections.observableArrayList();

            SaveFile savefile;
            {
                try {
                    savefile = new SaveFile("patients.txt");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            String[] patients = savefile.viewData();
            //String[] patientInfoArray = patients.toString().split(";");

        if(patients != null) {
            for (String patient : patients) {
                patientsL.add(patient);
            }
            patientList.setItems(patientsL);
        }else{
            System.out.println("no patients");
            //label.setText("No patients");
        }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void updateListSQL() throws SQLException {
        ObservableList patientsL = FXCollections.observableArrayList();
        String[] patients = sql.getData();

        for (String patient : patients) {
            patientsL.add(patient);
        }
        patientList.setItems(patientsL);

    }

    public void callPatient(){

    }

    public void callPatientSQL() throws SQLException {
        sql.callPatient();
        updateListSQL();
    }


}