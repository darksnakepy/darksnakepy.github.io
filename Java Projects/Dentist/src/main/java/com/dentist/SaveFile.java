package com.dentist;

import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;

public class SaveFile {
    private final BufferedWriter bufferedWriter;

    public SaveFile(String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename, true);
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    public void register(ArrayList<Patient> patients) throws IOException {
        try {
            for (Patient patient : patients) {
                StringBuilder sb = new StringBuilder();
                sb.append("Name = ").append(patient.getName()).append(", Surname = ").append(patient.getSurname()).append(", Age = ").append(patient.getAge()).append(", Tax ID = ").append(patient.getTaxId()).append(", Issue = ").append(patient.getIssue()).append("\n");
                bufferedWriter.write(sb.toString());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String[] viewData(Label label) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("patients.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = reader.readLine();
        String[] patientsNames = new String[0];

        if (line == null) {
            System.out.println("No patients");
        } else {
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = reader.readLine();

            }
        }
        patientsNames = stringBuilder.toString().split(",");
        reader.close();
        label.setText(String.valueOf(patientsNames));
        return patientsNames;
    }

}
