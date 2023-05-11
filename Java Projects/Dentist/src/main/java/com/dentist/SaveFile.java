package com.dentist;

import java.io.*;
import java.util.ArrayList;

public class SaveFile {
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private String filename;

    public SaveFile(String filename) throws IOException {
        this.filename = filename;
        fileWriter = new FileWriter(filename, true);
        bufferedWriter = new BufferedWriter(fileWriter);
    }

    public boolean register(ArrayList<Patient> patients) throws IOException {
        try {
            for (Patient patient : patients) {
                StringBuilder sb = new StringBuilder();
                sb.append("Name = ").append(patient.getName()).append(", Surname = ").append(patient.getSurname()).append(", Age = ").append(patient.getAge()).append(", Tax ID = ").append(patient.getTaxId()).append(", Issue = ").append(patient.getIssue()).append("\n");
                bufferedWriter.write(sb.toString());
            }
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

}
