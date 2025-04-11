package com.example.application.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.entities.diagnostics;
import com.example.entities.user;

public class DatabaseOBJ {
    Connection con;
    PreparedStatement p;
    Statement s;
    String url, username, password;

    public DatabaseOBJ() throws SQLException {
        url = "jdbc:mariadb://q0h7yf5pynynaq54.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/ofatfn0is53ovpvt";
        username = "g8b5phb9ky9w8mfj";
        password = "dkbl5cm9rhwbfm98";
        openConnection();
    }

    public void openConnection() throws SQLException {
        // URI jdbUri = new
        // URI(System.getenv("mysql://g8b5phb9ky9w8mfj:dkbl5cm9rhwbfm98@q0h7yf5pynynaq54.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/ofatfn0is53ovpvt"));
        // String username = jdbUri.getUserInfo().split(":")[0];
        // String password = jdbUri.getUserInfo().split(":")[1];
        // String port = String.valueOf(jdbUri.getPort());
        // String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port +
        // jdbUri.getPath();
        con = DriverManager.getConnection(url, username, password);
    }

    public void connectionClose() throws SQLException {
        con.close();
    }

    public void updateUsername(int id, String username) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET username=? WHERE userID=?");
        stmt.setString(1, username);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        stmt.close();
    }

    public void updatePassword(int id, String password) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET password=? WHERE userID=?");
        stmt.setString(1, password);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    public void updateFirstname(int id, String firstname) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET firstname=? WHERE userID=?");
        stmt.setString(1, firstname);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    public void updateSurname(int id, String surname) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET surname=? WHERE userID=?");
        stmt.setString(1, surname);
        stmt.setInt(2, id);
        stmt.executeUpdate();

    }

    public void updateDOB(int id, String dob) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET dob=? WHERE userID=?");
        stmt.setString(1, dob);
        stmt.setInt(2, id);
        stmt.executeUpdate();

    }

    public void updateSex(int id, String sex) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET sex=? WHERE userID=?");
        stmt.setString(1, sex);
        stmt.setInt(2, id);
        stmt.executeUpdate();

    }

    public void updateAddress(int id, String address) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET address=? WHERE userID=?");
        stmt.setString(1, address);
        stmt.setInt(2, id);
        stmt.executeUpdate();

    }

    public void updatePhone(int id, String phone) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET phone=? WHERE userID=?");
        stmt.setString(1, phone);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    public void updateEmail(int id, String email) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET email=? WHERE userID=?");
        stmt.setString(1, email);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    public void updateNotes(int id, String notes) throws SQLException {
        openConnection();
        PreparedStatement stmt = con.prepareStatement("UPDATE user SET notes=? WHERE userID=?");
        stmt.setString(1, notes);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    public void insertUser(int id, String role, String username, String password, String firstname, String surname,
            String dob, String sex, String address, String phone, String email, String notes) throws SQLException {

        p = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

        p.setInt(1, id);
        p.setString(2, role);
        p.setString(3, username);
        p.setString(4, password);
        p.setString(5, firstname);
        p.setString(6, surname);
        p.setString(7, dob);
        p.setString(8, sex);
        p.setString(9, address);
        p.setString(10, phone);
        p.setString(11, email);
        p.setString(12, notes);
        p.executeUpdate();

    }

    public void insertUserMedicalHistory(int medID, String data, int userID) throws SQLException {
        p = con.prepareStatement("INSERT INTO medicalhistory VALUES (?,?,?)");
        p.setInt(1, medID);
        p.setString(2, data);
        p.setInt(3, userID);
        p.executeUpdate();

    }

    public void insertDiagnostic(int diagnosticID, String date, String desc, int userID, int diseaseID)
            throws SQLException {
        p = con.prepareStatement("INSERT INTO diagnostics VALUES (?,?,?,?,?)");
        p.setInt(1, diagnosticID);
        p.setString(2, date);
        p.setString(3, desc);
        p.setInt(4, userID);
        p.setInt(5, diseaseID);
        p.executeUpdate();

    }

    public String getPassword(int id) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT password FROM user WHERE userID = " + id);
        if (rs.next()) {
            return rs.getString("password");
        } else {
            return "Not Found";
        }
    }

    public String getUsername(int id) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username FROM user WHERE userID = " + id);
        if (rs.next()) {
            return rs.getString("username");
        } else {
            return "Not Found";
        }
    }

    public String getFirstName(int id) throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT firstname FROM user WHERE userID = " + id);
        if (rs.next()) {
            return rs.getString("firstname");
        } else {
            return "Not Found";
        }
    }

    public String getSurname(int id) throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT surname FROM user WHERE userID = " + id);
        if (rs.next()) {
            return rs.getString("surname");
        } else {
            return "Not Found";
        }
    }

    public String getRole(int id) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT role FROM user WHERE userID = " + id);
        if (rs.next()) {
            return rs.getString("role");
        } else {
            return "Not Found";
        }
    }

    public String getDOB(int id) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT dob FROM user WHERE userID = " + id);
        if (rs.next()) {
            return rs.getString("dob");
        } else {
            return "Not Found";
        }
    }

    public String getSex(int id) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT sex FROM user WHERE userID = " + id);
        if (rs.next()) {

            return rs.getString("sex");
        } else {
            return "Not Found";
        }
    }

    public String getAddress(int id) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT address FROM user WHERE userID = " + id);
        if (rs.next()) {

            return rs.getString("address");
        } else {

            return "Not Found";
        }
    }

    public String getPhone(int id) throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT phone FROM user WHERE userID = " + id);
        if (rs.next()) {

            return rs.getString("phone");
        } else {

            return "Not Found";
        }

    }

    public String getEmail(int id) throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT email FROM user WHERE userID = " + id);
        if (rs.next()) {

            return rs.getString("email");
        } else {

            return "Not Found";
        }
    }

    public String getNotes(int id) throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT notes FROM user WHERE userID = " + id);
        if (rs.next()) {

            return rs.getString("notes");
        } else {

            return "Not Found";
        }
    }

    public String getMedialHistory(int id) throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT medData FROM medicalhistory WHERE userID = " + id);
        if (rs.next()) {

            return rs.getString("medData");

        } else {

            return "Not Found";
        }
    }

    public String getFluInfo() throws SQLException {
        String name, desc, sym, lh;
        name = "Influenza";

        Statement stmt = con.createStatement();

        ResultSet description = stmt.executeQuery("SELECT description FROM disease WHERE diseaseID = " + 1);
        if (description.next()) {
            desc = description.getString("description");
        } else {
            desc = "Not Found";
        }

        ResultSet symptoms = stmt.executeQuery("SELECT symptoms FROM disease WHERE diseaseID = " + 1);
        if (symptoms.next()) {
            sym = symptoms.getString("symptoms");
        } else {
            sym = "Not Found";
        }

        ResultSet lifestylehabits = stmt.executeQuery("SELECT lifestylehabits FROM disease WHERE diseaseID = " + 1);
        if (lifestylehabits.next()) {
            lh = lifestylehabits.getString("lifestylehabits");
        } else {
            lh = "Not Found";
        }

        return "\nName: " + name + "\nDescription: " + desc + "\nSymptoms: " + sym + "\nLifestyle Habits: " + lh;

    }

    public String getCCInfo() throws SQLException {
        String name, desc, sym, lh;
        name = "Common Cold";

        Statement stmt = con.createStatement();

        ResultSet description = stmt.executeQuery("SELECT description FROM disease WHERE diseaseID = " + 2);
        if (description.next()) {
            desc = description.getString("description");
        } else {
            desc = "Not Found";
        }

        ResultSet symptoms = stmt.executeQuery("SELECT symptoms FROM disease WHERE diseaseID = " + 2);
        if (symptoms.next()) {
            sym = symptoms.getString("symptoms");
        } else {
            sym = "Not Found";
        }

        ResultSet lifestylehabits = stmt.executeQuery("SELECT lifestylehabits FROM disease WHERE diseaseID = " + 2);
        if (lifestylehabits.next()) {
            lh = lifestylehabits.getString("lifestylehabits");
        } else {
            lh = "Not Found";
        }

        return "\nName: " + name + "\nDescription: " + desc + "\nSymptoms: " + sym + "\nLifestyle Habits: " + lh;

    }

    public String getAsthmaInfo() throws SQLException {
        String name, desc, sym, lh;
        name = "Asthma";

        Statement stmt = con.createStatement();

        ResultSet description = stmt.executeQuery("SELECT description FROM disease WHERE diseaseID = " + 3);
        if (description.next()) {
            desc = description.getString("description");
        } else {
            desc = "Not Found";
        }

        ResultSet symptoms = stmt.executeQuery("SELECT symptoms FROM disease WHERE diseaseID = " + 3);
        if (symptoms.next()) {
            sym = symptoms.getString("symptoms");
        } else {
            sym = "Not Found";
        }

        ResultSet lifestylehabits = stmt.executeQuery("SELECT lifestylehabits FROM disease WHERE diseaseID = " + 3);
        if (lifestylehabits.next()) {
            lh = lifestylehabits.getString("lifestylehabits");
        } else {
            lh = "Not Found";
        }

        return "\nName: " + name + "\nDescription: " + desc + "\nSymptoms: " + sym + "\nLifestyle Habits: " + lh;

    }

    public String getDiabetesInfo() throws SQLException {
        String name, desc, sym, lh;
        name = "Diabetes";

        Statement stmt = con.createStatement();

        ResultSet description = stmt.executeQuery("SELECT description FROM disease WHERE diseaseID = " + 4);
        if (description.next()) {
            desc = description.getString("description");
        } else {
            desc = "Not Found";
        }

        ResultSet symptoms = stmt.executeQuery("SELECT symptoms FROM disease WHERE diseaseID = " + 4);
        if (symptoms.next()) {
            sym = symptoms.getString("symptoms");
        } else {
            sym = "Not Found";
        }

        ResultSet lifestylehabits = stmt.executeQuery("SELECT lifestylehabits FROM disease WHERE diseaseID = " + 4);
        if (lifestylehabits.next()) {
            lh = lifestylehabits.getString("lifestylehabits");
        } else {
            lh = "Not Found";
        }

        return "\nName: " + name + "\nDescription: " + desc + "\nSymptoms: " + sym + "\nLifestyle Habits: " + lh;

    }

    public String getHypertensionInfo() throws SQLException {
        String name, desc, sym, lh;
        name = "Hypertension";

        Statement stmt = con.createStatement();

        ResultSet description = stmt.executeQuery("SELECT description FROM disease WHERE diseaseID = " + 5);
        if (description.next()) {
            desc = description.getString("description");
        } else {
            desc = "Not Found";
        }

        ResultSet symptoms = stmt.executeQuery("SELECT symptoms FROM disease WHERE diseaseID = " + 5);
        if (symptoms.next()) {
            sym = symptoms.getString("symptoms");
        } else {
            sym = "Not Found";
        }

        ResultSet lifestylehabits = stmt.executeQuery("SELECT lifestylehabits FROM disease WHERE diseaseID = " + 5);
        if (lifestylehabits.next()) {
            lh = lifestylehabits.getString("lifestylehabits");
        } else {
            lh = "Not Found";
        }

        return "\nName: " + name + "\nDescription: " + desc + "\nSymptoms: " + sym + "\nLifestyle Habits: " + lh;

    }

    public List<user> getUsers() throws SQLException {

        List<user> patients = new ArrayList<>();
        Statement st = con.createStatement();

        ResultSet r = st.executeQuery("SELECT * from user");
        while (r.next()) {
            user u = new user();
            u.setID(r.getInt("userID"));
            u.setRole(r.getString("role"));
            u.setUsername(r.getString("username"));
            u.setPassword(r.getString("password"));
            u.setFirstname(r.getString("firstname"));
            u.setSurname(r.getString("surname"));
            u.setDOB(r.getString("dob"));
            u.setSex(r.getString("sex"));
            u.setAddress(r.getString("address"));
            u.setPhone(r.getString("phone"));
            u.setEmail(r.getString("email"));
            u.setNotes(r.getString("notes"));
            patients.add(u);

        }

        return patients;

    }

    public List<diagnostics> getDiagnostics(int id) throws SQLException {

        List<diagnostics> diagnosticList = new ArrayList<>();
        Statement st = con.createStatement();

        ResultSet r = st.executeQuery("SELECT * from diagnostics WHERE userID = " + id);
        while (r.next()) {
            diagnostics d = new diagnostics();
            d.setDiagnosticID(r.getInt("diagnosticID"));
            d.setUserID(r.getInt("userID"));
            d.setDiseaseID(r.getInt("diseaseID"));
            d.setDate(r.getString("date"));
            d.setDescription(r.getString("description"));
            diagnosticList.add(d);

        }

        return diagnosticList;

    }

}
