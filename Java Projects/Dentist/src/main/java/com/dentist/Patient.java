package com.dentist;

public class Patient {
    private String name;
    private String surname;
    private int age;
    private String taxId;
    private String issue;

    public Patient(String name, String surname, int age, String taxId, String issue){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.taxId = taxId;
        this.issue = issue;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public int getAge(){
        return this.age;
    }

    public String getTaxId(){
        return this.taxId;
    }

    public String getIssue(){
        return this.issue;
    }

}
