package com.raphtech.databasejembatank10.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    public static Connection getConnection() {
        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/db_jembatan";
        String user = "root";
        String password = "";
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                System.exit(0);
            }
        }
        return connection;
    }
}
