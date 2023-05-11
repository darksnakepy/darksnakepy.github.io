package com.dentist;

import com.dentist.sqllite.SQL_methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class RegisterController {
    SQL_methods sql = new SQL_methods();
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField age;
    @FXML
    private TextField taxid;
    @FXML
    private TextArea issue;
    @FXML
    private Label status;

    ArrayList<Patient> patients = new ArrayList<>();

    public void insertData(){
        if(checkFields()) {
            patients.add(new Patient(name.getText(), surname.getText(), Integer.parseInt(age.getText()), taxid.getText(), issue.getText()));
            sql.registerPatient(patients);
            status.setText("Registered!");
        }
        else{
            System.out.println("Errore");
            status.setText("You must fill all the fields");
        }
    }

    public void resetData(){
        name.setText("");
        surname.setText("");
        age.setText("");
        taxid.setText("");
        issue.setText("");
    }

    public boolean checkFields(){
        if(name.getText().isEmpty() || surname.getText().isEmpty() || age.getText().isEmpty() || taxid.getText().isEmpty() || issue.getText().isEmpty()){
            return false;
        }
        else return true;
    }

    public void exitHandle(){
        Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setContentText("Do you want to save data before leaving?");

        if (alert.showAndWait().orElse(null) == ButtonType.OK) {
            insertData();
            status.setText("Registered!");
        }
    }

}
