package com.dentist;

import com.dentist.sqllite.SQL_methods;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
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
            System.out.println("Error");
            status.setText("You must fill all the fields");
        }
    }

    public void insertDataTxt(){
        SaveFile savefile;
        {
            try {
                savefile = new SaveFile("patients.txt");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(checkFields()) {
            patients.add(new Patient(name.getText(), surname.getText(), Integer.parseInt(age.getText()), taxid.getText(), issue.getText()));
            try{
                savefile.register(patients);
                status.setText("Registered over txt file!");
            }catch (IOException e){
                System.out.println(e);
            }
        }
        else status.setText("Fill all the fields!");
    }

    public void resetData(){
        name.setText("");
        surname.setText("");
        age.setText("");
        taxid.setText("");
        issue.setText("");
    }

    public boolean checkFields(){
        return !name.getText().isEmpty() && !surname.getText().isEmpty() && !age.getText().isEmpty() && !taxid.getText().isEmpty() && !issue.getText().isEmpty();
    }

    public void exitHandle(){
        Stage stage;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setContentText("Do you want to save data before leaving?");

        if (alert.showAndWait().orElse(null) == ButtonType.OK) {
            if(checkFields()){
                insertData();
                status.setText("Registered!");
            }else status.setText("Fill all fields!");
        }
    }

}
