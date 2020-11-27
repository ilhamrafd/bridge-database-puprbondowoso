package com.raphtech.databasejembatank10.user;

import com.raphtech.databasejembatank10.connect.jembatanKoneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login {

    private Connection connection;
    private PreparedStatement preparedStatment;
    private ResultSet res;
    private String query, user, password, message;

    public Login() {
        jembatanKoneksi conn = new jembatanKoneksi();
        try {
            connection = conn.getKoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection failed!");
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

    public String cekLogin(String user, String password) {
        try {
            preparedStatment = connection.prepareStatement("SELECT nama FROM tbl_user WHERE id_user=? AND password=md5(?)");
            preparedStatment.setString(1, user);
            preparedStatment.setString(2, password);
            res = preparedStatment.executeQuery();

            try {
                res.next();
                Session.setUser(user);
                Session.setNama(res.getString("nama"));
                Session.setStatusLogin("Activated");

                try {
                    preparedStatment = connection.prepareStatement("INSERT INTO tbl_log (id_user) VALUES (?)");
                    preparedStatment.setString(1, user);
                    preparedStatment.executeUpdate();
                    preparedStatment.close();
                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(null, "Gagal simpan Log Login " + e);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Username atau Password salah!");
            }
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Gagal Login, Query Error " + e);
        }
        return message;
    }

    public void Logout(String user) {
        try {
            preparedStatment = connection.prepareStatement("UPDATE tbl_log SET logout=CURRENT_TIMESTAMP() WHERE id_user=? ORDER BY id DESC LIMIT 1");
            preparedStatment.setString(1, user);
            preparedStatment.executeUpdate();
            preparedStatment.close();

            connection.close();

            Session.setUser(null);
            Session.setNama(null);
            Session.setStatusLogin(null);
        } catch (SQLException e) {
            message = "Logout gagal";
        }
    }
}
