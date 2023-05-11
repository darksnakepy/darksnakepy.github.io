package com.dentist.sqllite;
import com.dentist.Patient;

import java.sql.*;
import java.util.ArrayList;

public class SQL_methods {
    static Connection connection = null;
    static String db_path = "jdbc:sqlite:C:\\db\\dentist.db";

    public static void createNewDatabase() {


        try (Connection conn = DriverManager.getConnection(db_path)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void connectionHandle() {
        try {
            connection = DriverManager.getConnection(db_path);
            //createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean createTable() {

        // preparing SQL statement to create a new table
        String table = "CREATE TABLE IF NOT EXISTS dentist (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + " surname text NOT NULL,\n"
                + "	age integer,\n"
                + "	taxid text \n"
                + "	issue text \n"
                + ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(table);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
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

    public StringBuilder getData() throws SQLException { // get all data from all patients
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
            System.out.println(sb);
            return sb;

        } catch (SQLException e) {
            return null;
        }
    }

    public void deleteData(){
        String deleteQuery = "DELETE FROM dentist WHERE type = 'table'";
        try {
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.executeQuery();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
