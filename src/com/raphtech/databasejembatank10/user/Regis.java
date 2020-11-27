package com.raphtech.databasejembatank10.user;

import com.raphtech.databasejembatank10.connect.jembatanKoneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Regis {
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet res;
    private String query, user, password, message;
    
    public Regis() {
        jembatanKoneksi conn = new jembatanKoneksi();
        try {
            connection = conn.getKoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection failed");
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void Regis(String user, String password, String nama, String jeniskelamin, String alamat, String telepon) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO tbl_user (id_user, password, nama, jenis_kelamin, alamat, no_telp) VALUES (?,md5(?),?,?,?,?)");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, nama);
            preparedStatement.setString(4, jeniskelamin);
            preparedStatement.setString(5, alamat);
            preparedStatement.setString(6, telepon);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Regis Error! " + e);
        }
    }
}
