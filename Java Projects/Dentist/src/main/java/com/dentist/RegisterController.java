package com.dentist;

import com.dentist.sqllite.SQL_methods;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

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
    private TextField issue;

    ArrayList<Patient> patients = new ArrayList<>();

    public void InsertData(){
        if(checkFields()) {
            patients.add(new Patient(name.getText(), surname.getText(), Integer.parseInt(age.getText()), taxid.getText(), issue.getText()))
            sql.registerPatient(patients);
        }
        else{
            //handle the error
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

    }

}
