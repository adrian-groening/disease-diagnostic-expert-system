package com.example.entities;

public class diagnostics {
    int diagnosticID, userID, diseaseID;
    String date, description;

    public diagnostics() {

    }

    public diagnostics(int diagnosticID, int userID, int diseaseID, String date, String description) {
        this.diagnosticID = diagnosticID;
        this.userID = userID;
        this.diseaseID = diseaseID;
        this.date = date;
        this.description = description;
    }

    public void setDiagnosticID(int diagnosticID) {
        this.diagnosticID = diagnosticID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setDiseaseID(int diseaseID) {
        this.diseaseID = diseaseID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDiagnosticID() {
        return diagnosticID;
    }

    public int getUserID() {
        return userID;
    }

    public int getDiseaseID() {
        return diseaseID;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
