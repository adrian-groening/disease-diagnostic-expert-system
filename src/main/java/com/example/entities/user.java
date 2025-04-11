package com.example.entities;


public class user {
    int userID;
    private String role, username, password, firstname, surname, dob, sex, address, phone, email, notes;

    public user() {

    }

    public user(int userID, String role, String username, String password, String firstname, String surname, String dob,
            String sex, String address, String phone, String email, String notes) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.notes = notes;
    }

    public void setID(int userID) {
        this.userID = userID;
    }

    public int getID() {
        return userID;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setDOB(String dob) {
        this.dob = dob;
    }

    public String getDOB() {
        return dob;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

}
