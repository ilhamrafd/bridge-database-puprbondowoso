package com.raphtech.databasejembatank10.view;

import com.raphtech.databasejembatank10.connect.jembatanKoneksi;
import com.mysql.jdbc.Connection;
import com.raphtech.databasejembatank10.Main;
import com.raphtech.databasejembatank10.dao.jembatanDao;
import com.raphtech.databasejembatank10.domain.jembatanDomain;
import com.raphtech.databasejembatank10.service.jembatanService;
import com.raphtech.databasejembatank10.tablemodel.jembatanTableModel;
import com.raphtech.databasejembatank10.user.Login;
import com.raphtech.databasejembatank10.user.Session;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class jembatanSearch extends javax.swing.JFrame {

    DefaultTableModel defaultTableModel;
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet rs;
    Statement statement;
    jembatanTableModel jembatanTableModel1, jembatanTableModel2, jembatanTableModel3, jembatanTableModel4,
            jembatanTableModel5, jembatanTableModel6, jembatanTableModel7, jembatanTableModel8, jembatanTableModel9,
            jembatanTableModel10, jembatanTableModel11, jembatanTableModel12, jembatanTableModel13, jembatanTableModel14,
            jembatanTableModel15, jembatanTableModel16, jembatanTableModel17, jembatanTableModel18, jembatanTableModel19,
            jembatanTableModel20, jembatanTableModel21, jembatanTableModel22, jembatanTableModel23;
    jembatanService jembatanService;

    jembatanKoneksi koneksi = new jembatanKoneksi();
    jembatanDao dao = new jembatanDao();
    jembatanDomain dom = new jembatanDomain();
    Login login = new Login();
    
    public jembatanSearch() throws SQLException {
        if (Session.getStatusLogin() == "Activated") {
            initComponents();
            initTableBondowoso();
            initTableBotolinggo();
            initTableCermee();
            initTableCurahdami();
        } else {
            dispose();
            jembatanLogin Login = new jembatanLogin();
            Login.setVisible(true);
        }
    }

    private void initTableBondowoso() throws SQLException {

        jTableBondowoso.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    int row = jTableBondowoso.getSelectedRow();
                    jLabelRuas.setText(jTableBondowoso.getValueAt(row, 0).toString());
                    jLabelPangkal.setText(jTableBondowoso.getValueAt(row, 1).toString());
                    jLabelKec.setText(jTableBondowoso.getValueAt(row, 2).toString());
                    jLabelNamajbt.setText(jTableBondowoso.getValueAt(row, 3).toString());
                    jLabelJml.setText(jTableBondowoso.getValueAt(row, 4).toString());
                    jLabelPanjang.setText(jTableBondowoso.getValueAt(row, 5).toString());
                    jLabelLebar.setText(jTableBondowoso.getValueAt(row, 6).toString());
                    jLabelLebarTot.setText(jTableBondowoso.getValueAt(row, 7).toString());
                    jLabelBangunAtas.setText(jTableBondowoso.getValueAt(row, 8).toString());
                    jLabelBangunBwh.setText(jTableBondowoso.getValueAt(row, 9).toString());
                    jLabelKondisi.setText(jTableBondowoso.getValueAt(row, 10).toString());
                    jLabelAkses.setText(jTableBondowoso.getValueAt(row, 11).toString());
                    jLabelKoordinat.setText(jTableBondowoso.getValueAt(row, 12).toString());
                    jLabelNamaFileGambar1.setText(jTableBondowoso.getValueAt(row, 13).toString());
                    jLabelNamaFileGambar2.setText(jTableBondowoso.getValueAt(row, 14).toString());

                    jembatanDomain book = jembatanTableModel1.getData(row);
                    

                    Toolkit toolkit = Toolkit.getDefaultToolkit();

                    String path = new File(".").getCanonicalPath();
                    Image image = toolkit.getImage(path + "/image/" + book.getImage1());
                    Image imagedResized = image.getScaledInstance(550, 260, Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(imagedResized);
                    jLabelGambar1.setIcon(icon);

                    String path2 = new File(".").getCanonicalPath();
                    Image image2 = toolkit.getImage(path2 + "/image2/" + book.getImage2());
                    Image imagedResized2 = image2.getScaledInstance(550, 260, Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(imagedResized2);
                    jLabelGambar2.setIcon(icon2);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        jembatanService = Main.getBookService();
        jembatanTableModel1 = new jembatanTableModel(jembatanService.getAllBondowoso());
        jTableBondowoso.setModel(jembatanTableModel1);
    }

    private void initTableCurahdami() throws SQLException {

        jTableCurahdami.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    int row = jTableCurahdami.getSelectedRow();
                    jLabelRuas1.setText(jTableCurahdami.getValueAt(row, 0).toString());
                    jLabelPangkal1.setText(jTableCurahdami.getValueAt(row, 1).toString());
                    jLabelKec1.setText(jTableCurahdami.getValueAt(row, 2).toString());
                    jLabelNamajbt1.setText(jTableCurahdami.getValueAt(row, 3).toString());
                    jLabelJml1.setText(jTableCurahdami.getValueAt(row, 4).toString());
                    jLabelPanjang1.setText(jTableCurahdami.getValueAt(row, 5).toString());
                    jLabelLebar1.setText(jTableCurahdami.getValueAt(row, 6).toString());
                    jLabelLebarTot1.setText(jTableCurahdami.getValueAt(row, 7).toString());
                    jLabelBangunAtas1.setText(jTableCurahdami.getValueAt(row, 8).toString());
                    jLabelBangunBwh1.setText(jTableCurahdami.getValueAt(row, 9).toString());
                    jLabelKondisi1.setText(jTableCurahdami.getValueAt(row, 10).toString());
                    jLabelAkses1.setText(jTableCurahdami.getValueAt(row, 11).toString());
                    jLabelKoordinat1.setText(jTableCurahdami.getValueAt(row, 12).toString());
                    jLabelNamaFileGambar3.setText(jTableCurahdami.getValueAt(row, 13).toString());
                    jLabelNamaFileGambar4.setText(jTableCurahdami.getValueAt(row, 14).toString());

                    jembatanDomain book = jembatanTableModel2.getData(row);
                    

                    Toolkit toolkit = Toolkit.getDefaultToolkit();

                    String path = new File(".").getCanonicalPath();
                    Image image = toolkit.getImage(path + "/image/" + book.getImage1());
                    Image imagedResized = image.getScaledInstance(550, 260, Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(imagedResized);
                    jLabelGambar3.setIcon(icon);

                    String path2 = new File(".").getCanonicalPath();
                    Image image2 = toolkit.getImage(path2 + "/image2/" + book.getImage2());
                    Image imagedResized2 = image2.getScaledInstance(550, 260, Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(imagedResized2);
                    jLabelGambar4.setIcon(icon2);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        jembatanService = Main.getBookService();
        jembatanTableModel2 = new jembatanTableModel(jembatanService.getAllCurahdami());
        jTableCurahdami.setModel(jembatanTableModel2);
    }
    
    private void initTableBotolinggo() throws SQLException {

        jTableBotolinggo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    int row = jTableBotolinggo.getSelectedRow();
                    jLabelRuas.setText(jTableBotolinggo.getValueAt(row, 0).toString());
                    jLabelPangkal.setText(jTableBotolinggo.getValueAt(row, 1).toString());
                    jLabelKec.setText(jTableBotolinggo.getValueAt(row, 2).toString());
                    jLabelNamajbt.setText(jTableBotolinggo.getValueAt(row, 3).toString());
                    jLabelJml.setText(jTableBotolinggo.getValueAt(row, 4).toString());
                    jLabelPanjang.setText(jTableBotolinggo.getValueAt(row, 5).toString());
                    jLabelLebar.setText(jTableBotolinggo.getValueAt(row, 6).toString());
                    jLabelLebarTot.setText(jTableBotolinggo.getValueAt(row, 7).toString());
                    jLabelBangunAtas.setText(jTableBotolinggo.getValueAt(row, 8).toString());
                    jLabelBangunBwh.setText(jTableBotolinggo.getValueAt(row, 9).toString());
                    jLabelKondisi.setText(jTableBotolinggo.getValueAt(row, 10).toString());
                    jLabelAkses.setText(jTableBotolinggo.getValueAt(row, 11).toString());
                    jLabelKoordinat.setText(jTableBotolinggo.getValueAt(row, 12).toString());
                    jLabelNamaFileGambar1.setText(jTableBotolinggo.getValueAt(row, 13).toString());
                    jLabelNamaFileGambar2.setText(jTableBotolinggo.getValueAt(row, 14).toString());

                    jembatanDomain book = jembatanTableModel3.getData(row);
                    

                    Toolkit toolkit = Toolkit.getDefaultToolkit();

                    String path = new File(".").getCanonicalPath();
                    Image image = toolkit.getImage(path + "/image/" + book.getImage1());
                    Image imagedResized = image.getScaledInstance(550, 260, Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(imagedResized);
                    jLabelGambar1.setIcon(icon);

                    String path2 = new File(".").getCanonicalPath();
                    Image image2 = toolkit.getImage(path2 + "/image2/" + book.getImage2());
                    Image imagedResized2 = image2.getScaledInstance(550, 260, Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(imagedResized2);
                    jLabelGambar2.setIcon(icon2);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        jembatanService = Main.getBookService();
        jembatanTableModel3 = new jembatanTableModel(jembatanService.getAllBotolinggo());
        jTableBotolinggo.setModel(jembatanTableModel3);
    }

    private void initTableCermee() throws SQLException {

        jTableCermee.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    int row = jTableCermee.getSelectedRow();
                    jLabelRuas.setText(jTableCermee.getValueAt(row, 0).toString());
                    jLabelPangkal.setText(jTableCermee.getValueAt(row, 1).toString());
                    jLabelKec.setText(jTableCermee.getValueAt(row, 2).toString());
                    jLabelNamajbt.setText(jTableCermee.getValueAt(row, 3).toString());
                    jLabelJml.setText(jTableCermee.getValueAt(row, 4).toString());
                    jLabelPanjang.setText(jTableCermee.getValueAt(row, 5).toString());
                    jLabelLebar.setText(jTableCermee.getValueAt(row, 6).toString());
                    jLabelLebarTot.setText(jTableCermee.getValueAt(row, 7).toString());
                    jLabelBangunAtas.setText(jTableCermee.getValueAt(row, 8).toString());
                    jLabelBangunBwh.setText(jTableCermee.getValueAt(row, 9).toString());
                    jLabelKondisi.setText(jTableCermee.getValueAt(row, 10).toString());
                    jLabelAkses.setText(jTableCermee.getValueAt(row, 11).toString());
                    jLabelKoordinat.setText(jTableCermee.getValueAt(row, 12).toString());
                    jLabelNamaFileGambar1.setText(jTableCermee.getValueAt(row, 13).toString());
                    jLabelNamaFileGambar2.setText(jTableCermee.getValueAt(row, 14).toString());

                    jembatanDomain book = jembatanTableModel4.getData(row);
                    

                    Toolkit toolkit = Toolkit.getDefaultToolkit();

                    String path = new File(".").getCanonicalPath();
                    Image image = toolkit.getImage(path + "/image/" + book.getImage1());
                    Image imagedResized = image.getScaledInstance(550, 260, Image.SCALE_DEFAULT);
                    ImageIcon icon = new ImageIcon(imagedResized);
                    jLabelGambar1.setIcon(icon);

                    String path2 = new File(".").getCanonicalPath();
                    Image image2 = toolkit.getImage(path2 + "/image2/" + book.getImage2());
                    Image imagedResized2 = image2.getScaledInstance(550, 260, Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(imagedResized2);
                    jLabelGambar2.setIcon(icon2);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        jembatanService = Main.getBookService();
        jembatanTableModel4 = new jembatanTableModel(jembatanService.getAllCermee());
        jTableCermee.setModel(jembatanTableModel4);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabelHome = new javax.swing.JLabel();
        jLabelAdd = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelLogout = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelIcon = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabelJudulRuas = new javax.swing.JLabel();
        jLabelJudulPangkal = new javax.swing.JLabel();
        jLabelJudulKec = new javax.swing.JLabel();
        jLabelJudulJumlah = new javax.swing.JLabel();
        jLabelJudulPanjang = new javax.swing.JLabel();
        jLabelJudulJalur = new javax.swing.JLabel();
        jLabelJudulLebarTot = new javax.swing.JLabel();
        jLabelJudulBangunAtas = new javax.swing.JLabel();
        jLabelJudulBangunBawah = new javax.swing.JLabel();
        jLabelJudulKondisi = new javax.swing.JLabel();
        jLabelJudulAkses = new javax.swing.JLabel();
        jLabelJudulKoordinat = new javax.swing.JLabel();
        jLabelKec = new javax.swing.JLabel();
        jLabelRuas = new javax.swing.JLabel();
        jLabelPangkal = new javax.swing.JLabel();
        jLabelJml = new javax.swing.JLabel();
        jLabelPanjang = new javax.swing.JLabel();
        jLabelLebar = new javax.swing.JLabel();
        jLabelLebarTot = new javax.swing.JLabel();
        jLabelNamajbt = new javax.swing.JLabel();
        jLabelKoordinat = new javax.swing.JLabel();
        jLabelBangunAtas = new javax.swing.JLabel();
        jLabelBangunBwh = new javax.swing.JLabel();
        jLabelKondisi = new javax.swing.JLabel();
        jLabelAkses = new javax.swing.JLabel();
        jLabelNamaFileGambar2 = new javax.swing.JLabel();
        jLabelNamaFileGambar1 = new javax.swing.JLabel();
        jLabelGambar1 = new javax.swing.JLabel();
        jLabelGambar2 = new javax.swing.JLabel();
        jLabelButtonRefresh = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBondowoso = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabelJudulRuas1 = new javax.swing.JLabel();
        jLabelJudulPangkal1 = new javax.swing.JLabel();
        jLabelJudulKec1 = new javax.swing.JLabel();
        jLabelJudulJumlah1 = new javax.swing.JLabel();
        jLabelJudulPanjang1 = new javax.swing.JLabel();
        jLabelJudulJalur1 = new javax.swing.JLabel();
        jLabelJudulLebarTot1 = new javax.swing.JLabel();
        jLabelJudulBangunAtas1 = new javax.swing.JLabel();
        jLabelJudulBangunBawah1 = new javax.swing.JLabel();
        jLabelJudulKondisi1 = new javax.swing.JLabel();
        jLabelJudulAkses1 = new javax.swing.JLabel();
        jLabelJudulKoordinat1 = new javax.swing.JLabel();
        jLabelKec1 = new javax.swing.JLabel();
        jLabelRuas1 = new javax.swing.JLabel();
        jLabelPangkal1 = new javax.swing.JLabel();
        jLabelJml1 = new javax.swing.JLabel();
        jLabelPanjang1 = new javax.swing.JLabel();
        jLabelLebar1 = new javax.swing.JLabel();
        jLabelLebarTot1 = new javax.swing.JLabel();
        jLabelNamajbt1 = new javax.swing.JLabel();
        jLabelKoordinat1 = new javax.swing.JLabel();
        jLabelBangunAtas1 = new javax.swing.JLabel();
        jLabelBangunBwh1 = new javax.swing.JLabel();
        jLabelKondisi1 = new javax.swing.JLabel();
        jLabelAkses1 = new javax.swing.JLabel();
        jLabelNamaFileGambar3 = new javax.swing.JLabel();
        jLabelNamaFileGambar4 = new javax.swing.JLabel();
        jLabelGambar3 = new javax.swing.JLabel();
        jLabelGambar4 = new javax.swing.JLabel();
        jLabelButtonRefresh1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCurahdami = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabelJudulRuas2 = new javax.swing.JLabel();
        jLabelJudulPangkal2 = new javax.swing.JLabel();
        jLabelJudulKec2 = new javax.swing.JLabel();
        jLabelJudulJumlah2 = new javax.swing.JLabel();
        jLabelJudulPanjang2 = new javax.swing.JLabel();
        jLabelJudulJalur2 = new javax.swing.JLabel();
        jLabelJudulLebarTot2 = new javax.swing.JLabel();
        jLabelJudulBangunAtas2 = new javax.swing.JLabel();
        jLabelJudulBangunBawah2 = new javax.swing.JLabel();
        jLabelJudulKondisi2 = new javax.swing.JLabel();
        jLabelJudulAkses2 = new javax.swing.JLabel();
        jLabelJudulKoordinat2 = new javax.swing.JLabel();
        jLabelKec2 = new javax.swing.JLabel();
        jLabelRuas2 = new javax.swing.JLabel();
        jLabelPangkal2 = new javax.swing.JLabel();
        jLabelJml2 = new javax.swing.JLabel();
        jLabelPanjang2 = new javax.swing.JLabel();
        jLabelLebar2 = new javax.swing.JLabel();
        jLabelLebarTot2 = new javax.swing.JLabel();
        jLabelNamajbt2 = new javax.swing.JLabel();
        jLabelKoordinat2 = new javax.swing.JLabel();
        jLabelBangunAtas2 = new javax.swing.JLabel();
        jLabelBangunBwh2 = new javax.swing.JLabel();
        jLabelKondisi2 = new javax.swing.JLabel();
        jLabelAkses2 = new javax.swing.JLabel();
        jLabelNamaFileGambar5 = new javax.swing.JLabel();
        jLabelNamaFileGambar6 = new javax.swing.JLabel();
        jLabelGambar5 = new javax.swing.JLabel();
        jLabelGambar6 = new javax.swing.JLabel();
        jLabelButtonRefresh2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBotolinggo = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabelJudulRuas3 = new javax.swing.JLabel();
        jLabelJudulPangkal3 = new javax.swing.JLabel();
        jLabelJudulKec3 = new javax.swing.JLabel();
        jLabelJudulJumlah3 = new javax.swing.JLabel();
        jLabelJudulPanjang3 = new javax.swing.JLabel();
        jLabelJudulJalur3 = new javax.swing.JLabel();
        jLabelJudulLebarTot3 = new javax.swing.JLabel();
        jLabelJudulBangunAtas3 = new javax.swing.JLabel();
        jLabelJudulBangunBawah3 = new javax.swing.JLabel();
        jLabelJudulKondisi3 = new javax.swing.JLabel();
        jLabelJudulAkses3 = new javax.swing.JLabel();
        jLabelJudulKoordinat3 = new javax.swing.JLabel();
        jLabelKec3 = new javax.swing.JLabel();
        jLabelRuas3 = new javax.swing.JLabel();
        jLabelPangkal3 = new javax.swing.JLabel();
        jLabelJml3 = new javax.swing.JLabel();
        jLabelPanjang3 = new javax.swing.JLabel();
        jLabelLebar3 = new javax.swing.JLabel();
        jLabelLebarTot3 = new javax.swing.JLabel();
        jLabelNamajbt3 = new javax.swing.JLabel();
        jLabelKoordinat3 = new javax.swing.JLabel();
        jLabelBangunAtas3 = new javax.swing.JLabel();
        jLabelBangunBwh3 = new javax.swing.JLabel();
        jLabelKondisi3 = new javax.swing.JLabel();
        jLabelAkses3 = new javax.swing.JLabel();
        jLabelNamaFileGambar7 = new javax.swing.JLabel();
        jLabelNamaFileGambar8 = new javax.swing.JLabel();
        jLabelGambar7 = new javax.swing.JLabel();
        jLabelGambar8 = new javax.swing.JLabel();
        jLabelButtonRefresh3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableCermee = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabelJudulRuas4 = new javax.swing.JLabel();
        jLabelJudulPangkal4 = new javax.swing.JLabel();
        jLabelJudulKec4 = new javax.swing.JLabel();
        jLabelJudulJumlah4 = new javax.swing.JLabel();
        jLabelJudulPanjang4 = new javax.swing.JLabel();
        jLabelJudulJalur4 = new javax.swing.JLabel();
        jLabelJudulLebarTot4 = new javax.swing.JLabel();
        jLabelJudulBangunAtas4 = new javax.swing.JLabel();
        jLabelJudulBangunBawah4 = new javax.swing.JLabel();
        jLabelJudulKondisi4 = new javax.swing.JLabel();
        jLabelJudulAkses4 = new javax.swing.JLabel();
        jLabelJudulKoordinat4 = new javax.swing.JLabel();
        jLabelKec4 = new javax.swing.JLabel();
        jLabelRuas4 = new javax.swing.JLabel();
        jLabelPangkal4 = new javax.swing.JLabel();
        jLabelJml4 = new javax.swing.JLabel();
        jLabelPanjang4 = new javax.swing.JLabel();
        jLabelLebar4 = new javax.swing.JLabel();
        jLabelLebarTot4 = new javax.swing.JLabel();
        jLabelNamajbt4 = new javax.swing.JLabel();
        jLabelKoordinat4 = new javax.swing.JLabel();
        jLabelBangunAtas4 = new javax.swing.JLabel();
        jLabelBangunBwh4 = new javax.swing.JLabel();
        jLabelKondisi4 = new javax.swing.JLabel();
        jLabelAkses4 = new javax.swing.JLabel();
        jLabelNamaFileGambar9 = new javax.swing.JLabel();
        jLabelNamaFileGambar10 = new javax.swing.JLabel();
        jLabelGambar9 = new javax.swing.JLabel();
        jLabelGambar10 = new javax.swing.JLabel();
        jLabelButtonRefresh4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCermee1 = new javax.swing.JTable();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(null);

        jLabelHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png"))); // NOI18N
        jLabelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelHomeMouseExited(evt);
            }
        });
        jPanel2.add(jLabelHome);
        jLabelHome.setBounds(0, 380, 190, 100);

        jLabelAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        jLabelAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAddMouseExited(evt);
            }
        });
        jPanel2.add(jLabelAdd);
        jLabelAdd.setBounds(0, 490, 190, 120);

        jLabelSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/show.png"))); // NOI18N
        jLabelSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSearchMouseExited(evt);
            }
        });
        jPanel2.add(jLabelSearch);
        jLabelSearch.setBounds(0, 620, 190, 115);

        jLabel10.setFont(new java.awt.Font("Myriad Pro Cond", 1, 30)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tampilkan Data");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(0, 130, 190, 31);

        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jLabelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseExited(evt);
            }
        });
        jPanel2.add(jLabelLogout);
        jLabelLogout.setBounds(70, 200, 45, 50);

        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png"))); // NOI18N
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseExited(evt);
            }
        });
        jPanel2.add(jLabelClose);
        jLabelClose.setBounds(100, 250, 90, 50);

        jLabelIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png"))); // NOI18N
        jLabelIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIconMouseExited(evt);
            }
        });
        jPanel2.add(jLabelIcon);
        jLabelIcon.setBounds(0, 250, 90, 50);

        jPanel1.setBackground(new java.awt.Color(252, 225, 190));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 123, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelJudulRuas.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulRuas.setText("No. Ruas");
        jPanel1.add(jLabelJudulRuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 150, 30));

        jLabelJudulPangkal.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPangkal.setText("Pangkal - Ujung");
        jPanel1.add(jLabelJudulPangkal, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 150, 30));

        jLabelJudulKec.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKec.setText("Nama Kecamatan");
        jPanel1.add(jLabelJudulKec, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 150, 30));

        jLabelJudulJumlah.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJumlah.setText("Jumlah");
        jPanel1.add(jLabelJudulJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 150, 30));

        jLabelJudulPanjang.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPanjang.setText("Panjang");
        jPanel1.add(jLabelJudulPanjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 150, 30));

        jLabelJudulJalur.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJalur.setText("Lebar Jalur");
        jPanel1.add(jLabelJudulJalur, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 150, 30));

        jLabelJudulLebarTot.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulLebarTot.setText("Lebar Total");
        jPanel1.add(jLabelJudulLebarTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 150, 30));

        jLabelJudulBangunAtas.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunAtas.setText("Bangunan Atas");
        jPanel1.add(jLabelJudulBangunAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 150, 30));

        jLabelJudulBangunBawah.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunBawah.setText("Bangunan Bawah");
        jPanel1.add(jLabelJudulBangunBawah, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 270, -1, 30));

        jLabelJudulKondisi.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKondisi.setText("Kondisi");
        jPanel1.add(jLabelJudulKondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 150, 30));

        jLabelJudulAkses.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulAkses.setText("Akses");
        jPanel1.add(jLabelJudulAkses, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 150, 30));

        jLabelJudulKoordinat.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKoordinat.setText("Koordinat");
        jPanel1.add(jLabelJudulKoordinat, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 150, 30));

        jLabelKec.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKec.setText("........");
        jPanel1.add(jLabelKec, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 190, 30));

        jLabelRuas.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelRuas.setText("........");
        jPanel1.add(jLabelRuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 190, 30));

        jLabelPangkal.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPangkal.setText("........");
        jPanel1.add(jLabelPangkal, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 190, 30));

        jLabelJml.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelJml.setText("........");
        jPanel1.add(jLabelJml, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 190, 30));

        jLabelPanjang.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPanjang.setText("........");
        jPanel1.add(jLabelPanjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 190, 30));

        jLabelLebar.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebar.setText("........");
        jPanel1.add(jLabelLebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 190, 30));

        jLabelLebarTot.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebarTot.setText("........");
        jPanel1.add(jLabelLebarTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 190, 30));

        jLabelNamajbt.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 32)); // NOI18N
        jLabelNamajbt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamajbt.setText("NAMA JEMBATAN");
        jPanel1.add(jLabelNamajbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 460, 40));

        jLabelKoordinat.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKoordinat.setText("........");
        jPanel1.add(jLabelKoordinat, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 190, 30));

        jLabelBangunAtas.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunAtas.setText("........");
        jPanel1.add(jLabelBangunAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 190, 30));

        jLabelBangunBwh.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunBwh.setText("........");
        jPanel1.add(jLabelBangunBwh, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 190, 30));

        jLabelKondisi.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKondisi.setText("........");
        jPanel1.add(jLabelKondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 190, 30));

        jLabelAkses.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelAkses.setText("........");
        jPanel1.add(jLabelAkses, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 190, 30));

        jLabelNamaFileGambar2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar2.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar2.setText("Gambar 2");
        jPanel1.add(jLabelNamaFileGambar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 530, -1));

        jLabelNamaFileGambar1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar1.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar1.setText("Gambar 1");
        jPanel1.add(jLabelNamaFileGambar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 530, -1));

        jLabelGambar1.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelGambar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 260));

        jLabelGambar2.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelGambar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 550, 260));

        jLabelButtonRefresh.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelButtonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jLabelButtonRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonRefreshMouseExited(evt);
            }
        });
        jPanel1.add(jLabelButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 500, 110, 40));

        jTableBondowoso.setBackground(new java.awt.Color(252, 191, 101));
        jTableBondowoso.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTableBondowoso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Ruas", "Pangkal - Ujung", "Kecamatan", "Nama Jembatan", "Jumlah", "Panjang", "Lebar Jalur", "Lebar Total", "Bangunan Atas", "Bangunan Bawah", "Kondisi", "Akses", "Koordinat", "Gambar 1", "Gambar 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBondowoso.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableBondowoso.setGridColor(new java.awt.Color(191, 100, 17));
        jTableBondowoso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBondowosoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBondowoso);
        if (jTableBondowoso.getColumnModel().getColumnCount() > 0) {
            jTableBondowoso.getColumnModel().getColumn(0).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(1).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(2).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(3).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(4).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(5).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(6).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(7).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(8).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(9).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(10).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(11).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(12).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(13).setResizable(false);
            jTableBondowoso.getColumnModel().getColumn(14).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1130, 160));

        jTabbedPane1.addTab("Bondowoso", jPanel1);

        jPanel3.setBackground(new java.awt.Color(252, 225, 190));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 123, 0), 2));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelJudulRuas1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulRuas1.setText("No. Ruas");
        jPanel3.add(jLabelJudulRuas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 150, 30));

        jLabelJudulPangkal1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPangkal1.setText("Pangkal - Ujung");
        jPanel3.add(jLabelJudulPangkal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 150, 30));

        jLabelJudulKec1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKec1.setText("Nama Kecamatan");
        jPanel3.add(jLabelJudulKec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 150, 30));

        jLabelJudulJumlah1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJumlah1.setText("Jumlah");
        jPanel3.add(jLabelJudulJumlah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 150, 30));

        jLabelJudulPanjang1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPanjang1.setText("Panjang");
        jPanel3.add(jLabelJudulPanjang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 150, 30));

        jLabelJudulJalur1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJalur1.setText("Lebar Jalur");
        jPanel3.add(jLabelJudulJalur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 150, 30));

        jLabelJudulLebarTot1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulLebarTot1.setText("Lebar Total");
        jPanel3.add(jLabelJudulLebarTot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 150, 30));

        jLabelJudulBangunAtas1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunAtas1.setText("Bangunan Atas");
        jPanel3.add(jLabelJudulBangunAtas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 150, 30));

        jLabelJudulBangunBawah1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunBawah1.setText("Bangunan Bawah");
        jPanel3.add(jLabelJudulBangunBawah1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 270, -1, 30));

        jLabelJudulKondisi1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKondisi1.setText("Kondisi");
        jPanel3.add(jLabelJudulKondisi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 150, 30));

        jLabelJudulAkses1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulAkses1.setText("Akses");
        jPanel3.add(jLabelJudulAkses1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 150, 30));

        jLabelJudulKoordinat1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKoordinat1.setText("Koordinat");
        jPanel3.add(jLabelJudulKoordinat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 150, 30));

        jLabelKec1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKec1.setText("........");
        jPanel3.add(jLabelKec1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 190, 30));

        jLabelRuas1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelRuas1.setText("........");
        jPanel3.add(jLabelRuas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 190, 30));

        jLabelPangkal1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPangkal1.setText("........");
        jPanel3.add(jLabelPangkal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 190, 30));

        jLabelJml1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelJml1.setText("........");
        jPanel3.add(jLabelJml1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 190, 30));

        jLabelPanjang1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPanjang1.setText("........");
        jPanel3.add(jLabelPanjang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 190, 30));

        jLabelLebar1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebar1.setText("........");
        jPanel3.add(jLabelLebar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 190, 30));

        jLabelLebarTot1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebarTot1.setText("........");
        jPanel3.add(jLabelLebarTot1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 190, 30));

        jLabelNamajbt1.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 32)); // NOI18N
        jLabelNamajbt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamajbt1.setText("NAMA JEMBATAN");
        jPanel3.add(jLabelNamajbt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 460, 40));

        jLabelKoordinat1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKoordinat1.setText("........");
        jPanel3.add(jLabelKoordinat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 190, 30));

        jLabelBangunAtas1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunAtas1.setText("........");
        jPanel3.add(jLabelBangunAtas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 190, 30));

        jLabelBangunBwh1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunBwh1.setText("........");
        jPanel3.add(jLabelBangunBwh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 190, 30));

        jLabelKondisi1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKondisi1.setText("........");
        jPanel3.add(jLabelKondisi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 190, 30));

        jLabelAkses1.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelAkses1.setText("........");
        jPanel3.add(jLabelAkses1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 190, 30));

        jLabelNamaFileGambar3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar3.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar3.setText("Gambar 2");
        jPanel3.add(jLabelNamaFileGambar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 530, -1));

        jLabelNamaFileGambar4.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar4.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar4.setText("Gambar 1");
        jPanel3.add(jLabelNamaFileGambar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 530, -1));

        jLabelGambar3.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabelGambar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 260));

        jLabelGambar4.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabelGambar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 550, 260));

        jLabelButtonRefresh1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelButtonRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jLabelButtonRefresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh1MouseExited(evt);
            }
        });
        jPanel3.add(jLabelButtonRefresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 500, 110, 40));

        jTableCurahdami.setBackground(new java.awt.Color(252, 191, 101));
        jTableCurahdami.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTableCurahdami.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Ruas", "Pangkal - Ujung", "Kecamatan", "Nama Jembatan", "Jumlah", "Panjang", "Lebar Jalur", "Lebar Total", "Bangunan Atas", "Bangunan Bawah", "Kondisi", "Akses", "Koordinat", "Gambar 1", "Gambar 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCurahdami.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableCurahdami.setGridColor(new java.awt.Color(191, 100, 17));
        jTableCurahdami.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCurahdamiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCurahdami);
        if (jTableCurahdami.getColumnModel().getColumnCount() > 0) {
            jTableCurahdami.getColumnModel().getColumn(0).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(1).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(2).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(3).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(4).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(5).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(6).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(7).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(8).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(9).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(10).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(11).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(12).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(13).setResizable(false);
            jTableCurahdami.getColumnModel().getColumn(14).setResizable(false);
        }

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1130, 160));

        jTabbedPane1.addTab("Curahdami", jPanel3);

        jPanel4.setBackground(new java.awt.Color(252, 225, 190));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 123, 0), 2));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelJudulRuas2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulRuas2.setText("No. Ruas");
        jPanel4.add(jLabelJudulRuas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 150, 30));

        jLabelJudulPangkal2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPangkal2.setText("Pangkal - Ujung");
        jPanel4.add(jLabelJudulPangkal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 150, 30));

        jLabelJudulKec2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKec2.setText("Nama Kecamatan");
        jPanel4.add(jLabelJudulKec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 150, 30));

        jLabelJudulJumlah2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJumlah2.setText("Jumlah");
        jPanel4.add(jLabelJudulJumlah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 150, 30));

        jLabelJudulPanjang2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPanjang2.setText("Panjang");
        jPanel4.add(jLabelJudulPanjang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 150, 30));

        jLabelJudulJalur2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJalur2.setText("Lebar Jalur");
        jPanel4.add(jLabelJudulJalur2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 150, 30));

        jLabelJudulLebarTot2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulLebarTot2.setText("Lebar Total");
        jPanel4.add(jLabelJudulLebarTot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 150, 30));

        jLabelJudulBangunAtas2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunAtas2.setText("Bangunan Atas");
        jPanel4.add(jLabelJudulBangunAtas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 150, 30));

        jLabelJudulBangunBawah2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunBawah2.setText("Bangunan Bawah");
        jPanel4.add(jLabelJudulBangunBawah2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 270, -1, 30));

        jLabelJudulKondisi2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKondisi2.setText("Kondisi");
        jPanel4.add(jLabelJudulKondisi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 150, 30));

        jLabelJudulAkses2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulAkses2.setText("Akses");
        jPanel4.add(jLabelJudulAkses2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 150, 30));

        jLabelJudulKoordinat2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKoordinat2.setText("Koordinat");
        jPanel4.add(jLabelJudulKoordinat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 150, 30));

        jLabelKec2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKec2.setText("........");
        jPanel4.add(jLabelKec2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 190, 30));

        jLabelRuas2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelRuas2.setText("........");
        jPanel4.add(jLabelRuas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 190, 30));

        jLabelPangkal2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPangkal2.setText("........");
        jPanel4.add(jLabelPangkal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 190, 30));

        jLabelJml2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelJml2.setText("........");
        jPanel4.add(jLabelJml2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 190, 30));

        jLabelPanjang2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPanjang2.setText("........");
        jPanel4.add(jLabelPanjang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 190, 30));

        jLabelLebar2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebar2.setText("........");
        jPanel4.add(jLabelLebar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 190, 30));

        jLabelLebarTot2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebarTot2.setText("........");
        jPanel4.add(jLabelLebarTot2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 190, 30));

        jLabelNamajbt2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 32)); // NOI18N
        jLabelNamajbt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamajbt2.setText("NAMA JEMBATAN");
        jPanel4.add(jLabelNamajbt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 460, 40));

        jLabelKoordinat2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKoordinat2.setText("........");
        jPanel4.add(jLabelKoordinat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 190, 30));

        jLabelBangunAtas2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunAtas2.setText("........");
        jPanel4.add(jLabelBangunAtas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 190, 30));

        jLabelBangunBwh2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunBwh2.setText("........");
        jPanel4.add(jLabelBangunBwh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 190, 30));

        jLabelKondisi2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKondisi2.setText("........");
        jPanel4.add(jLabelKondisi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 190, 30));

        jLabelAkses2.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelAkses2.setText("........");
        jPanel4.add(jLabelAkses2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 190, 30));

        jLabelNamaFileGambar5.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar5.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar5.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar5.setText("Gambar 2");
        jPanel4.add(jLabelNamaFileGambar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 530, -1));

        jLabelNamaFileGambar6.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar6.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar6.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar6.setText("Gambar 1");
        jPanel4.add(jLabelNamaFileGambar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 530, -1));

        jLabelGambar5.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabelGambar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 260));

        jLabelGambar6.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabelGambar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 550, 260));

        jLabelButtonRefresh2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelButtonRefresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jLabelButtonRefresh2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh2MouseExited(evt);
            }
        });
        jPanel4.add(jLabelButtonRefresh2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 500, 110, 40));

        jTableBotolinggo.setBackground(new java.awt.Color(252, 191, 101));
        jTableBotolinggo.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTableBotolinggo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Ruas", "Pangkal - Ujung", "Kecamatan", "Nama Jembatan", "Jumlah", "Panjang", "Lebar Jalur", "Lebar Total", "Bangunan Atas", "Bangunan Bawah", "Kondisi", "Akses", "Koordinat", "Gambar 1", "Gambar 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBotolinggo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableBotolinggo.setGridColor(new java.awt.Color(191, 100, 17));
        jTableBotolinggo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBotolinggoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableBotolinggo);
        if (jTableBotolinggo.getColumnModel().getColumnCount() > 0) {
            jTableBotolinggo.getColumnModel().getColumn(0).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(1).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(2).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(3).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(4).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(5).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(6).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(7).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(8).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(9).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(10).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(11).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(12).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(13).setResizable(false);
            jTableBotolinggo.getColumnModel().getColumn(14).setResizable(false);
        }

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1130, 160));

        jTabbedPane1.addTab("Botolinggo", jPanel4);

        jPanel5.setBackground(new java.awt.Color(252, 225, 190));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 123, 0), 2));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelJudulRuas3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulRuas3.setText("No. Ruas");
        jPanel5.add(jLabelJudulRuas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 150, 30));

        jLabelJudulPangkal3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPangkal3.setText("Pangkal - Ujung");
        jPanel5.add(jLabelJudulPangkal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 150, 30));

        jLabelJudulKec3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKec3.setText("Nama Kecamatan");
        jPanel5.add(jLabelJudulKec3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 150, 30));

        jLabelJudulJumlah3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJumlah3.setText("Jumlah");
        jPanel5.add(jLabelJudulJumlah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 150, 30));

        jLabelJudulPanjang3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPanjang3.setText("Panjang");
        jPanel5.add(jLabelJudulPanjang3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 150, 30));

        jLabelJudulJalur3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJalur3.setText("Lebar Jalur");
        jPanel5.add(jLabelJudulJalur3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 150, 30));

        jLabelJudulLebarTot3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulLebarTot3.setText("Lebar Total");
        jPanel5.add(jLabelJudulLebarTot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 150, 30));

        jLabelJudulBangunAtas3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunAtas3.setText("Bangunan Atas");
        jPanel5.add(jLabelJudulBangunAtas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 150, 30));

        jLabelJudulBangunBawah3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunBawah3.setText("Bangunan Bawah");
        jPanel5.add(jLabelJudulBangunBawah3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 270, -1, 30));

        jLabelJudulKondisi3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKondisi3.setText("Kondisi");
        jPanel5.add(jLabelJudulKondisi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 150, 30));

        jLabelJudulAkses3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulAkses3.setText("Akses");
        jPanel5.add(jLabelJudulAkses3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 150, 30));

        jLabelJudulKoordinat3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKoordinat3.setText("Koordinat");
        jPanel5.add(jLabelJudulKoordinat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 150, 30));

        jLabelKec3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKec3.setText("........");
        jPanel5.add(jLabelKec3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 190, 30));

        jLabelRuas3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelRuas3.setText("........");
        jPanel5.add(jLabelRuas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 190, 30));

        jLabelPangkal3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPangkal3.setText("........");
        jPanel5.add(jLabelPangkal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 190, 30));

        jLabelJml3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelJml3.setText("........");
        jPanel5.add(jLabelJml3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 190, 30));

        jLabelPanjang3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPanjang3.setText("........");
        jPanel5.add(jLabelPanjang3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 190, 30));

        jLabelLebar3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebar3.setText("........");
        jPanel5.add(jLabelLebar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 190, 30));

        jLabelLebarTot3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebarTot3.setText("........");
        jPanel5.add(jLabelLebarTot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 190, 30));

        jLabelNamajbt3.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 32)); // NOI18N
        jLabelNamajbt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamajbt3.setText("NAMA JEMBATAN");
        jPanel5.add(jLabelNamajbt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 460, 40));

        jLabelKoordinat3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKoordinat3.setText("........");
        jPanel5.add(jLabelKoordinat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 190, 30));

        jLabelBangunAtas3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunAtas3.setText("........");
        jPanel5.add(jLabelBangunAtas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 190, 30));

        jLabelBangunBwh3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunBwh3.setText("........");
        jPanel5.add(jLabelBangunBwh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 190, 30));

        jLabelKondisi3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKondisi3.setText("........");
        jPanel5.add(jLabelKondisi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 190, 30));

        jLabelAkses3.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelAkses3.setText("........");
        jPanel5.add(jLabelAkses3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 190, 30));

        jLabelNamaFileGambar7.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar7.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar7.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar7.setText("Gambar 2");
        jPanel5.add(jLabelNamaFileGambar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 530, -1));

        jLabelNamaFileGambar8.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar8.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar8.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar8.setText("Gambar 1");
        jPanel5.add(jLabelNamaFileGambar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 530, -1));

        jLabelGambar7.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabelGambar7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 260));

        jLabelGambar8.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabelGambar8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 550, 260));

        jLabelButtonRefresh3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelButtonRefresh3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jLabelButtonRefresh3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh3MouseExited(evt);
            }
        });
        jPanel5.add(jLabelButtonRefresh3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 500, 110, 40));

        jTableCermee.setBackground(new java.awt.Color(252, 191, 101));
        jTableCermee.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTableCermee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Ruas", "Pangkal - Ujung", "Kecamatan", "Nama Jembatan", "Jumlah", "Panjang", "Lebar Jalur", "Lebar Total", "Bangunan Atas", "Bangunan Bawah", "Kondisi", "Akses", "Koordinat", "Gambar 1", "Gambar 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCermee.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableCermee.setGridColor(new java.awt.Color(191, 100, 17));
        jTableCermee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCermeeMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableCermee);
        if (jTableCermee.getColumnModel().getColumnCount() > 0) {
            jTableCermee.getColumnModel().getColumn(0).setResizable(false);
            jTableCermee.getColumnModel().getColumn(1).setResizable(false);
            jTableCermee.getColumnModel().getColumn(2).setResizable(false);
            jTableCermee.getColumnModel().getColumn(3).setResizable(false);
            jTableCermee.getColumnModel().getColumn(4).setResizable(false);
            jTableCermee.getColumnModel().getColumn(5).setResizable(false);
            jTableCermee.getColumnModel().getColumn(6).setResizable(false);
            jTableCermee.getColumnModel().getColumn(7).setResizable(false);
            jTableCermee.getColumnModel().getColumn(8).setResizable(false);
            jTableCermee.getColumnModel().getColumn(9).setResizable(false);
            jTableCermee.getColumnModel().getColumn(10).setResizable(false);
            jTableCermee.getColumnModel().getColumn(11).setResizable(false);
            jTableCermee.getColumnModel().getColumn(12).setResizable(false);
            jTableCermee.getColumnModel().getColumn(13).setResizable(false);
            jTableCermee.getColumnModel().getColumn(14).setResizable(false);
        }

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1130, 160));

        jTabbedPane1.addTab("Cermee", jPanel5);

        jPanel6.setBackground(new java.awt.Color(252, 225, 190));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 123, 0), 2));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelJudulRuas4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulRuas4.setText("No. Ruas");
        jPanel6.add(jLabelJudulRuas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 150, 30));

        jLabelJudulPangkal4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPangkal4.setText("Pangkal - Ujung");
        jPanel6.add(jLabelJudulPangkal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 150, 30));

        jLabelJudulKec4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKec4.setText("Nama Kecamatan");
        jPanel6.add(jLabelJudulKec4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 150, 30));

        jLabelJudulJumlah4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJumlah4.setText("Jumlah");
        jPanel6.add(jLabelJudulJumlah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 150, 30));

        jLabelJudulPanjang4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulPanjang4.setText("Panjang");
        jPanel6.add(jLabelJudulPanjang4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 150, 30));

        jLabelJudulJalur4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulJalur4.setText("Lebar Jalur");
        jPanel6.add(jLabelJudulJalur4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 150, 30));

        jLabelJudulLebarTot4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulLebarTot4.setText("Lebar Total");
        jPanel6.add(jLabelJudulLebarTot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 410, 150, 30));

        jLabelJudulBangunAtas4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunAtas4.setText("Bangunan Atas");
        jPanel6.add(jLabelJudulBangunAtas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 150, 30));

        jLabelJudulBangunBawah4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulBangunBawah4.setText("Bangunan Bawah");
        jPanel6.add(jLabelJudulBangunBawah4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 270, -1, 30));

        jLabelJudulKondisi4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKondisi4.setText("Kondisi");
        jPanel6.add(jLabelJudulKondisi4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 150, 30));

        jLabelJudulAkses4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulAkses4.setText("Akses");
        jPanel6.add(jLabelJudulAkses4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 140, 150, 30));

        jLabelJudulKoordinat4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelJudulKoordinat4.setText("Koordinat");
        jPanel6.add(jLabelJudulKoordinat4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 150, 30));

        jLabelKec4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKec4.setText("........");
        jPanel6.add(jLabelKec4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 190, 30));

        jLabelRuas4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelRuas4.setText("........");
        jPanel6.add(jLabelRuas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 190, 30));

        jLabelPangkal4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPangkal4.setText("........");
        jPanel6.add(jLabelPangkal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 190, 30));

        jLabelJml4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelJml4.setText("........");
        jPanel6.add(jLabelJml4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 190, 30));

        jLabelPanjang4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelPanjang4.setText("........");
        jPanel6.add(jLabelPanjang4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 190, 30));

        jLabelLebar4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebar4.setText("........");
        jPanel6.add(jLabelLebar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 190, 30));

        jLabelLebarTot4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelLebarTot4.setText("........");
        jPanel6.add(jLabelLebarTot4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 190, 30));

        jLabelNamajbt4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 32)); // NOI18N
        jLabelNamajbt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamajbt4.setText("NAMA JEMBATAN");
        jPanel6.add(jLabelNamajbt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 460, 40));

        jLabelKoordinat4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKoordinat4.setText("........");
        jPanel6.add(jLabelKoordinat4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, 190, 30));

        jLabelBangunAtas4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunAtas4.setText("........");
        jPanel6.add(jLabelBangunAtas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 190, 30));

        jLabelBangunBwh4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelBangunBwh4.setText("........");
        jPanel6.add(jLabelBangunBwh4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 190, 30));

        jLabelKondisi4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelKondisi4.setText("........");
        jPanel6.add(jLabelKondisi4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 190, 30));

        jLabelAkses4.setFont(new java.awt.Font("Myriad Pro", 0, 16)); // NOI18N
        jLabelAkses4.setText("........");
        jPanel6.add(jLabelAkses4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 170, 190, 30));

        jLabelNamaFileGambar9.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar9.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar9.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar9.setText("Gambar 2");
        jPanel6.add(jLabelNamaFileGambar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 530, -1));

        jLabelNamaFileGambar10.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNamaFileGambar10.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        jLabelNamaFileGambar10.setForeground(new java.awt.Color(94, 58, 6));
        jLabelNamaFileGambar10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNamaFileGambar10.setText("Gambar 1");
        jPanel6.add(jLabelNamaFileGambar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 530, -1));

        jLabelGambar9.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar9.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel6.add(jLabelGambar9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 260));

        jLabelGambar10.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar10.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(244, 153, 20), null));
        jLabelGambar10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel6.add(jLabelGambar10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 550, 260));

        jLabelButtonRefresh4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabelButtonRefresh4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png"))); // NOI18N
        jLabelButtonRefresh4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonRefresh4MouseExited(evt);
            }
        });
        jPanel6.add(jLabelButtonRefresh4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 500, 110, 40));

        jTableCermee1.setBackground(new java.awt.Color(252, 191, 101));
        jTableCermee1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTableCermee1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Ruas", "Pangkal - Ujung", "Kecamatan", "Nama Jembatan", "Jumlah", "Panjang", "Lebar Jalur", "Lebar Total", "Bangunan Atas", "Bangunan Bawah", "Kondisi", "Akses", "Koordinat", "Gambar 1", "Gambar 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCermee1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableCermee1.setGridColor(new java.awt.Color(191, 100, 17));
        jTableCermee1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCermee1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableCermee1);
        if (jTableCermee1.getColumnModel().getColumnCount() > 0) {
            jTableCermee1.getColumnModel().getColumn(0).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(1).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(2).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(3).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(4).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(5).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(6).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(7).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(8).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(9).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(10).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(11).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(12).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(13).setResizable(false);
            jTableCermee1.getColumnModel().getColumn(14).setResizable(false);
        }

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1130, 160));

        jTabbedPane1.addTab("Cermee", jPanel6);

        jPanel2.add(jTabbedPane1);
        jTabbedPane1.setBounds(200, 10, 1160, 750);

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/menu.png"))); // NOI18N
        jPanel2.add(bg);
        bg.setBounds(0, 0, 1366, 768);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableBondowosoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBondowosoMouseClicked
        try {
            int row = jTableBondowoso.rowAtPoint(evt.getPoint());

            String no_ruas = defaultTableModel.getValueAt(row, 0).toString();
            String pangkal_ujung = defaultTableModel.getValueAt(row, 1).toString();
            String kec = defaultTableModel.getValueAt(row, 2).toString();
            String nama_jbt = defaultTableModel.getValueAt(row, 3).toString();
            String jml = defaultTableModel.getValueAt(row, 4).toString();
            String panjang = defaultTableModel.getValueAt(row, 5).toString();
            String lebar = defaultTableModel.getValueAt(row, 6).toString();
            String lebartot = defaultTableModel.getValueAt(row, 7).toString();
            String bangun_atas = defaultTableModel.getValueAt(row, 8).toString();
            String bangun_bawah = defaultTableModel.getValueAt(row, 9).toString();
            String kondisi = defaultTableModel.getValueAt(row, 10).toString();
            String akses = defaultTableModel.getValueAt(row, 11).toString();
            String koordinat = defaultTableModel.getValueAt(row, 12).toString();

            jLabelRuas.setText(no_ruas);
            jLabelPangkal.setText(pangkal_ujung);
            jLabelKec.setText(kec);
            jLabelNamajbt.setText(nama_jbt);
            jLabelJml.setText(jml);
            jLabelPanjang.setText(panjang);
            jLabelLebar.setText(lebar);
            jLabelLebarTot.setText(lebartot);
            jLabelBangunAtas.setText(bangun_atas);
            jLabelBangunBwh.setText(bangun_bawah);
            jLabelKondisi.setText(kondisi);
            jLabelAkses.setText(akses);
            jLabelKoordinat.setText(koordinat);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTableBondowosoMouseClicked

    private void jLabelButtonRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshMouseClicked
        jLabelNamajbt.setText("NAMA JEMBATAN");
        jLabelRuas.setText("........");
        jLabelPangkal.setText("........");
        jLabelJml.setText("........");
        jLabelAkses.setText("........");
        jLabelKec.setText("........");
        jLabelKoordinat.setText("........");
        jLabelBangunAtas.setText("........");
        jLabelBangunBwh.setText("........");
        jLabelKondisi.setText("........");
        jLabelPanjang.setText("........");
        jLabelLebar.setText("........");
        jLabelLebarTot.setText("........");
        jLabelNamaFileGambar1.setText("........");
        jLabelNamaFileGambar2.setText("........");
        jLabelGambar1.setIcon(null);
        jLabelGambar2.setIcon(null);
    }//GEN-LAST:event_jLabelButtonRefreshMouseClicked

    private void jLabelButtonRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshMouseEntered
        jLabelButtonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshhover.png")));
    }//GEN-LAST:event_jLabelButtonRefreshMouseEntered

    private void jLabelButtonRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefreshMouseExited
        jLabelButtonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh.png")));
    }//GEN-LAST:event_jLabelButtonRefreshMouseExited

    private void jLabelIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseExited
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png")));
    }//GEN-LAST:event_jLabelIconMouseExited

    private void jLabelIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseEntered
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize-hover.png")));
    }//GEN-LAST:event_jLabelIconMouseEntered

    private void jLabelIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseClicked
        this.setExtendedState(jembatanSearch.ICONIFIED);
    }//GEN-LAST:event_jLabelIconMouseClicked

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png")));
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close-hover.png")));
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "Warning!", 2) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseExited
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png")));
    }//GEN-LAST:event_jLabelLogoutMouseExited

    private void jLabelLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseEntered
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout-hover.png")));
    }//GEN-LAST:event_jLabelLogoutMouseEntered

    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseClicked
        jembatanLogin Login = new jembatanLogin();
        if (JOptionPane.showConfirmDialog(null, "Anda akan logout dari akun ini, apakah anda yakin?", "Warning!", 2) == JOptionPane.YES_OPTION) {
            login.Logout(Session.getUser());
            dispose();
            Login.setVisible(true);
        }
    }//GEN-LAST:event_jLabelLogoutMouseClicked

    private void jLabelSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchMouseExited
        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/show.png")));
    }//GEN-LAST:event_jLabelSearchMouseExited

    private void jLabelSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchMouseEntered
        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/showhover.png")));
    }//GEN-LAST:event_jLabelSearchMouseEntered

    private void jLabelSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchMouseClicked
        try {
            dispose();
            jembatanSearch Search = new jembatanSearch();
            Search.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(jembatanSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelSearchMouseClicked

    private void jLabelAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMouseExited
        jLabelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png")));
    }//GEN-LAST:event_jLabelAddMouseExited

    private void jLabelAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMouseEntered
        jLabelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addhover.png")));
    }//GEN-LAST:event_jLabelAddMouseEntered

    private void jLabelAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMouseClicked
        try {
            dispose();
            jembatanAdd Add = new jembatanAdd();
            Add.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(jembatanHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelAddMouseClicked

    private void jLabelHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseExited
        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home.png")));
    }//GEN-LAST:event_jLabelHomeMouseExited

    private void jLabelHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseEntered
        jLabelHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/homehover.png")));
    }//GEN-LAST:event_jLabelHomeMouseEntered

    private void jLabelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomeMouseClicked
        dispose();
        jembatanHome Home = new jembatanHome();
        Home.setVisible(true);
    }//GEN-LAST:event_jLabelHomeMouseClicked

    private void jLabelButtonRefresh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh1MouseClicked

    private void jLabelButtonRefresh1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh1MouseEntered

    private void jLabelButtonRefresh1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh1MouseExited

    private void jTableCurahdamiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCurahdamiMouseClicked
        try {
            int row = jTableCurahdami.rowAtPoint(evt.getPoint());

            String no_ruas = defaultTableModel.getValueAt(row, 0).toString();
            String pangkal_ujung = defaultTableModel.getValueAt(row, 1).toString();
            String kec = defaultTableModel.getValueAt(row, 2).toString();
            String nama_jbt = defaultTableModel.getValueAt(row, 3).toString();
            String jml = defaultTableModel.getValueAt(row, 4).toString();
            String panjang = defaultTableModel.getValueAt(row, 5).toString();
            String lebar = defaultTableModel.getValueAt(row, 6).toString();
            String lebartot = defaultTableModel.getValueAt(row, 7).toString();
            String bangun_atas = defaultTableModel.getValueAt(row, 8).toString();
            String bangun_bawah = defaultTableModel.getValueAt(row, 9).toString();
            String kondisi = defaultTableModel.getValueAt(row, 10).toString();
            String akses = defaultTableModel.getValueAt(row, 11).toString();
            String koordinat = defaultTableModel.getValueAt(row, 12).toString();

            jLabelRuas.setText(no_ruas);
            jLabelPangkal.setText(pangkal_ujung);
            jLabelKec.setText(kec);
            jLabelNamajbt.setText(nama_jbt);
            jLabelJml.setText(jml);
            jLabelPanjang.setText(panjang);
            jLabelLebar.setText(lebar);
            jLabelLebarTot.setText(lebartot);
            jLabelBangunAtas.setText(bangun_atas);
            jLabelBangunBwh.setText(bangun_bawah);
            jLabelKondisi.setText(kondisi);
            jLabelAkses.setText(akses);
            jLabelKoordinat.setText(koordinat);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTableCurahdamiMouseClicked

    private void jLabelButtonRefresh2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh2MouseClicked

    private void jLabelButtonRefresh2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh2MouseEntered

    private void jLabelButtonRefresh2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh2MouseExited

    private void jTableBotolinggoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBotolinggoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableBotolinggoMouseClicked

    private void jLabelButtonRefresh3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh3MouseClicked

    private void jLabelButtonRefresh3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh3MouseEntered

    private void jLabelButtonRefresh3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh3MouseExited

    private void jTableCermeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCermeeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCermeeMouseClicked

    private void jLabelButtonRefresh4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh4MouseClicked

    private void jLabelButtonRefresh4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh4MouseEntered

    private void jLabelButtonRefresh4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelButtonRefresh4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelButtonRefresh4MouseExited

    private void jTableCermee1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCermee1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCermee1MouseClicked

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jembatanHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jembatanHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jembatanHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jembatanHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jembatanSearch().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(jembatanSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabelAdd;
    private javax.swing.JLabel jLabelAkses;
    private javax.swing.JLabel jLabelAkses1;
    private javax.swing.JLabel jLabelAkses2;
    private javax.swing.JLabel jLabelAkses3;
    private javax.swing.JLabel jLabelAkses4;
    private javax.swing.JLabel jLabelBangunAtas;
    private javax.swing.JLabel jLabelBangunAtas1;
    private javax.swing.JLabel jLabelBangunAtas2;
    private javax.swing.JLabel jLabelBangunAtas3;
    private javax.swing.JLabel jLabelBangunAtas4;
    private javax.swing.JLabel jLabelBangunBwh;
    private javax.swing.JLabel jLabelBangunBwh1;
    private javax.swing.JLabel jLabelBangunBwh2;
    private javax.swing.JLabel jLabelBangunBwh3;
    private javax.swing.JLabel jLabelBangunBwh4;
    private javax.swing.JLabel jLabelButtonRefresh;
    private javax.swing.JLabel jLabelButtonRefresh1;
    private javax.swing.JLabel jLabelButtonRefresh2;
    private javax.swing.JLabel jLabelButtonRefresh3;
    private javax.swing.JLabel jLabelButtonRefresh4;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelGambar1;
    private javax.swing.JLabel jLabelGambar10;
    private javax.swing.JLabel jLabelGambar2;
    private javax.swing.JLabel jLabelGambar3;
    private javax.swing.JLabel jLabelGambar4;
    private javax.swing.JLabel jLabelGambar5;
    private javax.swing.JLabel jLabelGambar6;
    private javax.swing.JLabel jLabelGambar7;
    private javax.swing.JLabel jLabelGambar8;
    private javax.swing.JLabel jLabelGambar9;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelJml;
    private javax.swing.JLabel jLabelJml1;
    private javax.swing.JLabel jLabelJml2;
    private javax.swing.JLabel jLabelJml3;
    private javax.swing.JLabel jLabelJml4;
    private javax.swing.JLabel jLabelJudulAkses;
    private javax.swing.JLabel jLabelJudulAkses1;
    private javax.swing.JLabel jLabelJudulAkses2;
    private javax.swing.JLabel jLabelJudulAkses3;
    private javax.swing.JLabel jLabelJudulAkses4;
    private javax.swing.JLabel jLabelJudulBangunAtas;
    private javax.swing.JLabel jLabelJudulBangunAtas1;
    private javax.swing.JLabel jLabelJudulBangunAtas2;
    private javax.swing.JLabel jLabelJudulBangunAtas3;
    private javax.swing.JLabel jLabelJudulBangunAtas4;
    private javax.swing.JLabel jLabelJudulBangunBawah;
    private javax.swing.JLabel jLabelJudulBangunBawah1;
    private javax.swing.JLabel jLabelJudulBangunBawah2;
    private javax.swing.JLabel jLabelJudulBangunBawah3;
    private javax.swing.JLabel jLabelJudulBangunBawah4;
    private javax.swing.JLabel jLabelJudulJalur;
    private javax.swing.JLabel jLabelJudulJalur1;
    private javax.swing.JLabel jLabelJudulJalur2;
    private javax.swing.JLabel jLabelJudulJalur3;
    private javax.swing.JLabel jLabelJudulJalur4;
    private javax.swing.JLabel jLabelJudulJumlah;
    private javax.swing.JLabel jLabelJudulJumlah1;
    private javax.swing.JLabel jLabelJudulJumlah2;
    private javax.swing.JLabel jLabelJudulJumlah3;
    private javax.swing.JLabel jLabelJudulJumlah4;
    private javax.swing.JLabel jLabelJudulKec;
    private javax.swing.JLabel jLabelJudulKec1;
    private javax.swing.JLabel jLabelJudulKec2;
    private javax.swing.JLabel jLabelJudulKec3;
    private javax.swing.JLabel jLabelJudulKec4;
    private javax.swing.JLabel jLabelJudulKondisi;
    private javax.swing.JLabel jLabelJudulKondisi1;
    private javax.swing.JLabel jLabelJudulKondisi2;
    private javax.swing.JLabel jLabelJudulKondisi3;
    private javax.swing.JLabel jLabelJudulKondisi4;
    private javax.swing.JLabel jLabelJudulKoordinat;
    private javax.swing.JLabel jLabelJudulKoordinat1;
    private javax.swing.JLabel jLabelJudulKoordinat2;
    private javax.swing.JLabel jLabelJudulKoordinat3;
    private javax.swing.JLabel jLabelJudulKoordinat4;
    private javax.swing.JLabel jLabelJudulLebarTot;
    private javax.swing.JLabel jLabelJudulLebarTot1;
    private javax.swing.JLabel jLabelJudulLebarTot2;
    private javax.swing.JLabel jLabelJudulLebarTot3;
    private javax.swing.JLabel jLabelJudulLebarTot4;
    private javax.swing.JLabel jLabelJudulPangkal;
    private javax.swing.JLabel jLabelJudulPangkal1;
    private javax.swing.JLabel jLabelJudulPangkal2;
    private javax.swing.JLabel jLabelJudulPangkal3;
    private javax.swing.JLabel jLabelJudulPangkal4;
    private javax.swing.JLabel jLabelJudulPanjang;
    private javax.swing.JLabel jLabelJudulPanjang1;
    private javax.swing.JLabel jLabelJudulPanjang2;
    private javax.swing.JLabel jLabelJudulPanjang3;
    private javax.swing.JLabel jLabelJudulPanjang4;
    private javax.swing.JLabel jLabelJudulRuas;
    private javax.swing.JLabel jLabelJudulRuas1;
    private javax.swing.JLabel jLabelJudulRuas2;
    private javax.swing.JLabel jLabelJudulRuas3;
    private javax.swing.JLabel jLabelJudulRuas4;
    private javax.swing.JLabel jLabelKec;
    private javax.swing.JLabel jLabelKec1;
    private javax.swing.JLabel jLabelKec2;
    private javax.swing.JLabel jLabelKec3;
    private javax.swing.JLabel jLabelKec4;
    private javax.swing.JLabel jLabelKondisi;
    private javax.swing.JLabel jLabelKondisi1;
    private javax.swing.JLabel jLabelKondisi2;
    private javax.swing.JLabel jLabelKondisi3;
    private javax.swing.JLabel jLabelKondisi4;
    private javax.swing.JLabel jLabelKoordinat;
    private javax.swing.JLabel jLabelKoordinat1;
    private javax.swing.JLabel jLabelKoordinat2;
    private javax.swing.JLabel jLabelKoordinat3;
    private javax.swing.JLabel jLabelKoordinat4;
    private javax.swing.JLabel jLabelLebar;
    private javax.swing.JLabel jLabelLebar1;
    private javax.swing.JLabel jLabelLebar2;
    private javax.swing.JLabel jLabelLebar3;
    private javax.swing.JLabel jLabelLebar4;
    private javax.swing.JLabel jLabelLebarTot;
    private javax.swing.JLabel jLabelLebarTot1;
    private javax.swing.JLabel jLabelLebarTot2;
    private javax.swing.JLabel jLabelLebarTot3;
    private javax.swing.JLabel jLabelLebarTot4;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelNamaFileGambar1;
    private javax.swing.JLabel jLabelNamaFileGambar10;
    private javax.swing.JLabel jLabelNamaFileGambar2;
    private javax.swing.JLabel jLabelNamaFileGambar3;
    private javax.swing.JLabel jLabelNamaFileGambar4;
    private javax.swing.JLabel jLabelNamaFileGambar5;
    private javax.swing.JLabel jLabelNamaFileGambar6;
    private javax.swing.JLabel jLabelNamaFileGambar7;
    private javax.swing.JLabel jLabelNamaFileGambar8;
    private javax.swing.JLabel jLabelNamaFileGambar9;
    private javax.swing.JLabel jLabelNamajbt;
    private javax.swing.JLabel jLabelNamajbt1;
    private javax.swing.JLabel jLabelNamajbt2;
    private javax.swing.JLabel jLabelNamajbt3;
    private javax.swing.JLabel jLabelNamajbt4;
    private javax.swing.JLabel jLabelPangkal;
    private javax.swing.JLabel jLabelPangkal1;
    private javax.swing.JLabel jLabelPangkal2;
    private javax.swing.JLabel jLabelPangkal3;
    private javax.swing.JLabel jLabelPangkal4;
    private javax.swing.JLabel jLabelPanjang;
    private javax.swing.JLabel jLabelPanjang1;
    private javax.swing.JLabel jLabelPanjang2;
    private javax.swing.JLabel jLabelPanjang3;
    private javax.swing.JLabel jLabelPanjang4;
    private javax.swing.JLabel jLabelRuas;
    private javax.swing.JLabel jLabelRuas1;
    private javax.swing.JLabel jLabelRuas2;
    private javax.swing.JLabel jLabelRuas3;
    private javax.swing.JLabel jLabelRuas4;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableBondowoso;
    private javax.swing.JTable jTableBotolinggo;
    private javax.swing.JTable jTableCermee;
    private javax.swing.JTable jTableCermee1;
    private javax.swing.JTable jTableCurahdami;
    // End of variables declaration//GEN-END:variables
}
