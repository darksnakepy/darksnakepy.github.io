package com.dentist;

import javafx.scene.control.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                sb.append("Name = ").append(patient.getName()).append(",Surname = ").append(patient.getSurname()).append(",Age = ").append(patient.getAge()).append(",Tax ID = ").append(patient.getTaxId()).append(",Issue = ").append(patient.getIssue());
                bufferedWriter.write(sb.toString());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String[] viewData() throws IOException {
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
        return patientsNames;
    }


    public void callPatient() throws IOException {
        ArrayList<String> lines = new ArrayList<>();

        // Read all lines from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        // Overwrite the first line with an empty string
        if (!lines.isEmpty()) {
            lines.set(0, "");
        }

        // Write the modified lines back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
