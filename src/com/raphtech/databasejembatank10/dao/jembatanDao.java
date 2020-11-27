package com.raphtech.databasejembatank10.dao;

import com.raphtech.databasejembatank10.connect.jembatanKoneksi;
import com.raphtech.databasejembatank10.domain.jembatanDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author awanlabs
 */
public class jembatanDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet rs;

    DataSource dataSource;

    public jembatanDao() {
        try {
            jembatanKoneksi conn = new jembatanKoneksi();
            connection = conn.getKoneksi();
        } catch (Exception e) {
        }
    }

    public ResultSet showDefaultTableModel() {
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                    + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                    + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR CODE 102: CAN'T SHOW DATABASE (" + e + ")");
        }
        return rs;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void save(jembatanDomain dom) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO tbl_utama (no_ruas, pangkal_ujung, id_kec, nama_jbt, jml, uk_panjang, uk_lebar, uk_lebartot, bangun_atas, "
                    + "bangun_bawah, id_kondisi, id_akses, koordinat, image, image2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, dom.getNo_ruas());
            preparedStatement.setString(2, dom.getPangkal_ujung());
            preparedStatement.setString(3, dom.getId_kec());
            preparedStatement.setString(4, dom.getNama_jbt());
            preparedStatement.setString(5, dom.getJml());
            preparedStatement.setString(6, dom.getUk_panjang());
            preparedStatement.setString(7, dom.getUk_lebar());
            preparedStatement.setString(8, dom.getUk_lebartot());
            preparedStatement.setString(9, dom.getBangun_atas());
            preparedStatement.setString(10, dom.getBangun_bawah());
            preparedStatement.setString(11, dom.getId_kondisi());
            preparedStatement.setString(12, dom.getId_akses());
            preparedStatement.setString(13, dom.getKoordinat());
            preparedStatement.setString(14, dom.getImage1());
            preparedStatement.setString(15, dom.getImage2());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR CODE 101: CAN'T SAVE DATA (" + e + ")");
        }
    }

    public void update(jembatanDomain dom) throws SQLException {
        try {
            preparedStatement = connection.prepareStatement("UPDATE tbl_utama SET no_ruas=?,pangkal_ujung=?,id_kec=?,jml=?,uk_panjang=?,uk_lebar=?,uk_lebartot=?,"
                    + "bangun_atas=?,bangun_bawah=?,id_kondisi=?,id_akses=?,koordinat=?,image=?,image2=? WHERE nama_jbt");
            preparedStatement.setString(1, dom.getNo_ruas());
            preparedStatement.setString(2, dom.getPangkal_ujung());
            preparedStatement.setString(3, dom.getId_kec());
            preparedStatement.setString(4, dom.getJml());
            preparedStatement.setString(5, dom.getUk_panjang());
            preparedStatement.setString(6, dom.getUk_lebar());
            preparedStatement.setString(7, dom.getUk_lebartot());
            preparedStatement.setString(8, dom.getBangun_atas());
            preparedStatement.setString(9, dom.getBangun_bawah());
            preparedStatement.setString(10, dom.getId_kondisi());
            preparedStatement.setString(11, dom.getId_akses());
            preparedStatement.setString(12, dom.getKoordinat());
            preparedStatement.setString(13, dom.getImage1());
            preparedStatement.setString(14, dom.getImage2());
            preparedStatement.setString(15, dom.getNama_jbt());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR CODE 103: CAN'T UPDATE DATA (" + e + ")");
        }
    }

    public void deleteData(String nama_jbt) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM tbl_utama WHERE nama_jbt=?");
            preparedStatement.setString(1, nama_jbt);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR 104: CAN'T DELETE DATA (" + e + ")");
        }
    }

    public jembatanDomain findOne(String nama_jbt) throws SQLException {
        jembatanDomain dom = new jembatanDomain();
        try {
            preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                    + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                    + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses OR nama_jbt=?");
            preparedStatement.setString(1, nama_jbt);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                dom.setNo_ruas(rs.getString("no_ruas"));
                dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
                dom.setId_kec(rs.getString("nama_kec"));
                dom.setJml(rs.getString("jml"));
                dom.setUk_panjang(rs.getString("uk_panjang"));
                dom.setUk_lebar(rs.getString("uk_lebar"));
                dom.setUk_lebartot(rs.getString("uk_lebartot"));
                dom.setBangun_atas(rs.getString("bangun_atas"));
                dom.setBangun_bawah(rs.getString("bangun_bawah"));
                dom.setId_kondisi(rs.getString("kondisi"));
                dom.setId_akses(rs.getString("akses"));
                dom.setKoordinat(rs.getString("koordinat"));
                dom.setImage1(rs.getString("image"));
                dom.setImage1(rs.getString("image2"));
                dom.setNama_jbt(rs.getString("nama_jbt"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR CODE 102: CAN'T SHOW DATABASE (" + e + ")");
        }
        return dom;
    }

    public List<jembatanDomain> findAll() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllBondowoso() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Bondowoso'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllCurahdami() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Curahdami'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllTenggarang() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Tenggarang'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllBinakal() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Binakal'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllPakem() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Pakem'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllTamanKrocok() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Taman Krocok'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllTegalampel() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Tegalampel'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllWringin() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Wringin'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllSumberWringin() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Sumber Wringin'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllSukosari() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Sukosari'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllTapen() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Tapen'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllTlogosari() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Tlogosari'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllWonosari() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Wonosari'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllGrujugan() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Grujugan'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllJambesari() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Jambersari'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllMaesan() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Maesan'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllPujer() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Pujer'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllTamanan() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Tamanan'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllBotolinggo() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Botolinggo'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllCermee() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Cermee'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllKlabang() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Klabang'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllPrajekan() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Prajekan'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public List<jembatanDomain> findAllIjen() throws SQLException {
        List<jembatanDomain> ListofData = new ArrayList<jembatanDomain>();
        preparedStatement = connection.prepareStatement("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, "
                + "u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image, u.image2 FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses AND k.nama_kec='Ijen'");
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            jembatanDomain dom = new jembatanDomain();
            dom.setNo_ruas(rs.getString("no_ruas"));
            dom.setPangkal_ujung(rs.getString("pangkal_ujung"));
            dom.setId_kec(rs.getString("nama_kec"));
            dom.setNama_jbt(rs.getString("nama_jbt"));
            dom.setJml(rs.getString("jml"));
            dom.setUk_panjang(rs.getString("uk_panjang"));
            dom.setUk_lebar(rs.getString("uk_lebar"));
            dom.setUk_lebartot(rs.getString("uk_lebartot"));
            dom.setBangun_atas(rs.getString("bangun_atas"));
            dom.setBangun_bawah(rs.getString("bangun_bawah"));
            dom.setId_kondisi(rs.getString("kondisi"));
            dom.setId_akses(rs.getString("akses"));
            dom.setKoordinat(rs.getString("koordinat"));
            dom.setImage1(rs.getString("image"));
            dom.setImage2(rs.getString("image2"));
            ListofData.add(dom);
        }
        return ListofData;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
