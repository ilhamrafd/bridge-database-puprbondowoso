package com.raphtech.databasejembatank10.connect;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jembatanKoneksi {

    private Connection koneksi;
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://" + "localhost:" + "3306/" + "db_jembatan";
    private final String username = "root";
    private final String password = "";

    public Connection getKoneksi() throws SQLException {
        if (koneksi == null) {
            try {
                Class.forName(driver);
//                System.out.println("Driver founded!");
                try {
                    koneksi = (Connection) DriverManager.getConnection(url, username, password);
//                    System.out.println("Database connection success!");
                } catch (SQLException e) {
                    System.out.println("Database connection failed! : " + e);
                    System.exit(0);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Driver not found! error : " + e);
                System.exit(0);
            }
        }
        return koneksi;
    }
}
