package com.raphtech.databasejembatank10.user;

public class Session {
    private static String user, nama, password, statusLogin, alamat, jeniskelamin, telepon;

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Session.user = user;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        Session.nama = nama;
    }

    public static String getStatusLogin() {
        return statusLogin;
    }

    public static void setStatusLogin(String statusLogin) {
        Session.statusLogin = statusLogin;
    }

    public static String getAlamat() {
        return alamat;
    }

    public static void setAlamat(String alamat) {
        Session.alamat = alamat;
    }

    public static String getJeniskelamin() {
        return jeniskelamin;
    }

    public static void setJeniskelamin(String jeniskelamin) {
        Session.jeniskelamin = jeniskelamin;
    }

    public static String getTelepon() {
        return telepon;
    }

    public static void setTelepon(String telepon) {
        Session.telepon = telepon;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Session.password = password;
    }
    
}
