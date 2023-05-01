package com.dentist.sqllite;
import com.dentist.Patient;

import java.sql.*;
import java.util.ArrayList;

public class SQL_methods {
    static Connection connection = null;
    static String db_path = "jdbc:sqlite:C:\\Users\\darksnake\\Desktop\\school\\darksnakepy.github.io\\Java Projects\\Dentist\\src\\main\\java\\com.dentist\\sqllite\\users.db";

    public static boolean connectionHandle() {
        try {
            connection = DriverManager.getConnection(db_path);
            createTable();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void createTable() {

        // preparing SQL statement to create a new table
        String table = "CREATE TABLE IF NOT EXISTS dentist (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + " surname text NOT NULL,\n"
                + "	age int NOT NULL,\n"
                + "	taxID text NOT NULL, \n"
                + "	issue text NOT NULL, \n"
                + ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(table);
        } catch (SQLException e) {
        }
    }

    public boolean registerPatient(ArrayList<Patient> patientsList) {
        String insert_data = "INSERT INTO dentist(name,surname, age, taxId, issue) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(insert_data);
            for(Patient patient : patientsList){
                statement.setString(1, patient.getName());
                statement.setString(2, patient.getSurname());
                statement.setInt(3, patient.getAge());
                statement.setString(4, patient.getTaxId());
                statement.setString(5, patient.getIssue());
                statement.executeUpdate();
        }
            return true;
        }catch (SQLException e) {
            return false;
        }
    }

    public boolean getData() throws SQLException { // get all data from all patients
        String get_data = "SELECT * FROM dentist";
        try {
            PreparedStatement statement = connection.prepareStatement(get_data);
            ResultSet rs = statement.executeQuery();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int age = rs.getInt("age");
                String taxId = rs.getString("taxId");
                String issue = rs.getString("issue");
                sb.append("Patient ID = ").append(id).append(", Name = ").append(name).append(", Surname = ").append(surname).append(", Age = ").append(age).append(", Tax ID = ").append(taxId).append(", Issue = ").append(issue).append("\n");
            }
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
