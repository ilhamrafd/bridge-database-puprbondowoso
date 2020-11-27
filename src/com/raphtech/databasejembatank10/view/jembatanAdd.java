package com.raphtech.databasejembatank10.view;

import com.raphtech.databasejembatank10.domain.jembatanDomain;
import com.raphtech.databasejembatank10.tablemodel.jembatanTableModel;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.apache.commons.io.FileUtils;
import com.raphtech.databasejembatank10.Main;
import com.raphtech.databasejembatank10.connect.jembatanKoneksi;
import com.raphtech.databasejembatank10.service.jembatanService;
import com.raphtech.databasejembatank10.user.Login;
import com.raphtech.databasejembatank10.user.Session;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jembatanAdd extends javax.swing.JFrame {

    Connection connection;
    Statement statement;

    Login login = new Login();
    jembatanKoneksi koneksi = new jembatanKoneksi();

    jembatanService jembatanService;
    jembatanTableModel jembatanTableModel;
    File file,file2;
    JFileChooser jfc,jfc2;

    public jembatanAdd() throws SQLException {
        if (Session.getStatusLogin() == "Activated") {
            initComponents();
            initTable();
        } else {
            dispose();
            jembatanLogin Login = new jembatanLogin();
            Login.setVisible(true);
        }
    }

    public void reset() {
        jTextFieldRuas.setText("");
        jTextFieldPanjang.setText("");
        jTextFieldPangkal.setText("");
        jTextFieldNamaJembatan.setText("");
        jTextFieldLebarTotal.setText("");
        jTextFieldLebar.setText("");
        jTextFieldKoordinat.setText("");
        jTextFieldJumlah.setText("");
        jTextFieldBangunBawah.setText("");
        jTextFieldBangunAtas.setText("");
        jComboBoxKecamatan.setSelectedIndex(0);
        buttonGroupAkses.clearSelection();
        buttonGroupKondisi.clearSelection();
        jLabelGambar.setIcon(null);
        jLabelGambar2.setIcon(null);
        jLabelNamaFileBuku.setText("Gambar");
        jLabelNamaFileBuku2.setText("Gambar");
    }

    private void initTable() throws SQLException {

        jTableBook.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    int row = jTableBook.getSelectedRow();
                    jTextFieldRuas.setText(jTableBook.getValueAt(row, 0).toString());
                    jTextFieldPangkal.setText(jTableBook.getValueAt(row, 1).toString());
                    String kec = jTableBook.getValueAt(row, 2).toString();
                    switch (kec) {
                        case "KECAMATAN":
                            jComboBoxKecamatan.setSelectedIndex(0);
                            break;
                        case "Bondowoso":
                            jComboBoxKecamatan.setSelectedIndex(1);
                            break;
                        case "Wringin":
                            jComboBoxKecamatan.setSelectedIndex(2);
                            break;
                        case "Pakem":
                            jComboBoxKecamatan.setSelectedIndex(3);
                            break;
                        case "Binakal":
                            jComboBoxKecamatan.setSelectedIndex(4);
                            break;
                        case "Curahdami":
                            jComboBoxKecamatan.setSelectedIndex(5);
                            break;
                        case "Pujer":
                            jComboBoxKecamatan.setSelectedIndex(6);
                            break;
                        case "Wonosari":
                            jComboBoxKecamatan.setSelectedIndex(7);
                            break;
                        case "Botolinggo":
                            jComboBoxKecamatan.setSelectedIndex(8);
                            break;
                        case "Prajekan":
                            jComboBoxKecamatan.setSelectedIndex(9);
                            break;
                        case "Grujugan":
                            jComboBoxKecamatan.setSelectedIndex(10);
                            break;
                        case "Sempol":
                            jComboBoxKecamatan.setSelectedIndex(11);
                            break;
                        case "Klabang":
                            jComboBoxKecamatan.setSelectedIndex(12);
                            break;
                        case "Tapen":
                            jComboBoxKecamatan.setSelectedIndex(13);
                            break;
                        case "Sukosari":
                            jComboBoxKecamatan.setSelectedIndex(14);
                            break;
                        case "Sumber Wringin":
                            jComboBoxKecamatan.setSelectedIndex(15);
                            break;
                        case "Maesan":
                            jComboBoxKecamatan.setSelectedIndex(16);
                            break;
                        case "Taman Krocok":
                            jComboBoxKecamatan.setSelectedIndex(17);
                            break;
                        case "Tegalampel":
                            jComboBoxKecamatan.setSelectedIndex(18);
                            break;
                        case "Tenggarang":
                            jComboBoxKecamatan.setSelectedIndex(19);
                            break;
                        case "Tlogosari":
                            jComboBoxKecamatan.setSelectedIndex(20);
                            break;
                        case "Jambesari":
                            jComboBoxKecamatan.setSelectedIndex(21);
                            break;
                        case "Cermee":
                            jComboBoxKecamatan.setSelectedIndex(22);
                            break;
                        case "Tamanan":
                            jComboBoxKecamatan.setSelectedIndex(23);
                            break;
                    }
                    jTextFieldNamaJembatan.setText(jTableBook.getValueAt(row, 3).toString());
                    jTextFieldJumlah.setText(jTableBook.getValueAt(row, 4).toString());
                    jTextFieldPanjang.setText(jTableBook.getValueAt(row, 5).toString());
                    jTextFieldLebar.setText(jTableBook.getValueAt(row, 6).toString());
                    jTextFieldLebarTotal.setText(jTableBook.getValueAt(row, 7).toString());
                    jTextFieldBangunAtas.setText(jTableBook.getValueAt(row, 8).toString());
                    jTextFieldBangunBawah.setText(jTableBook.getValueAt(row, 9).toString());

                    String jCheckBox = jTableBook.getValueAt(row, 10).toString();
                    try {
                        switch (jCheckBox) {
                            case "Baik":
                                jCheckBoxBaik.setSelected(true);
                                break;
                            case "Rusak Ringan":
                                jCheckBoxRusakRingan.setSelected(true);
                                break;
                            case "Rusak Sedang":
                                jCheckBoxRusakSedang.setSelected(true);
                                break;
                            case "Rusak Berat":
                                jCheckBoxRusakBerat.setSelected(true);
                                break;
                            default:
                                break;
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "JCheckBox error '" + ex + "'", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }

                    String jRadio = jTableBook.getValueAt(row, 11).toString();
                    try {
                        switch (jRadio) {
                            case "Negara":
                                jRadioButtonNegara.setSelected(true);
                                break;
                            case "Provinsi":
                                jRadioButtonProvinsi.setSelected(true);
                                break;
                            case "Kabupaten":
                                jRadioButtonKabupaten.setSelected(true);
                                break;
                            default:
                                break;
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "JRadio error '" + ex + "'", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    }

                    jTextFieldKoordinat.setText(jTableBook.getValueAt(row, 12).toString());

                    jembatanDomain book = jembatanTableModel.getData(row);

                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                   
                    String path1 = new File(".").getCanonicalPath();
                    Image image1 = toolkit.getImage(path1 + "/image/" + book.getImage1());
                    Image imagedResized1 = image1.getScaledInstance(430, 280, Image.SCALE_DEFAULT);
                    ImageIcon icon1 = new ImageIcon(imagedResized1);
                    jLabelGambar.setIcon(icon1);
                    
                    String path2 = new File(".").getCanonicalPath();
                    Image image2 = toolkit.getImage(path2 + "/image2/" + book.getImage2());
                    Image imagedResized2 = image2.getScaledInstance(430, 280, Image.SCALE_DEFAULT);
                    ImageIcon icon2 = new ImageIcon(imagedResized2);
                    jLabelGambar2.setIcon(icon2);
                   
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        jembatanService = Main.getBookService();
        jembatanTableModel = new jembatanTableModel(jembatanService.getAll());
        jTableBook.setModel(jembatanTableModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupKondisi = new javax.swing.ButtonGroup();
        buttonGroupAkses = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabelLogout = new javax.swing.JLabel();
        jLabelIcon = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelLebarTotal = new javax.swing.JLabel();
        jLabelRuas = new javax.swing.JLabel();
        jLabelPangkal = new javax.swing.JLabel();
        jLabelKecamatan = new javax.swing.JLabel();
        jLabelNamaJembatan = new javax.swing.JLabel();
        jLabelJumlahJembatan = new javax.swing.JLabel();
        jLabelPanjang = new javax.swing.JLabel();
        jLabelLebar = new javax.swing.JLabel();
        jLabelKoordinat = new javax.swing.JLabel();
        jLabelBangunanAtas = new javax.swing.JLabel();
        jLabelBangunanBawah = new javax.swing.JLabel();
        jLabelKondisi = new javax.swing.JLabel();
        jLabelAkses = new javax.swing.JLabel();
        jComboBoxKecamatan = new javax.swing.JComboBox<>();
        jTextFieldRuas = new javax.swing.JTextField();
        jTextFieldPangkal = new javax.swing.JTextField();
        jTextFieldNamaJembatan = new javax.swing.JTextField();
        jTextFieldJumlah = new javax.swing.JTextField();
        jTextFieldPanjang = new javax.swing.JTextField();
        jTextFieldLebar = new javax.swing.JTextField();
        jTextFieldLebarTotal = new javax.swing.JTextField();
        jTextFieldBangunAtas = new javax.swing.JTextField();
        jTextFieldBangunBawah = new javax.swing.JTextField();
        jTextFieldKoordinat = new javax.swing.JTextField();
        jRadioButtonNegara = new javax.swing.JRadioButton();
        jRadioButtonProvinsi = new javax.swing.JRadioButton();
        jRadioButtonKabupaten = new javax.swing.JRadioButton();
        jCheckBoxRusakSedang = new javax.swing.JCheckBox();
        jCheckBoxRusakBerat = new javax.swing.JCheckBox();
        jCheckBoxRusakRingan = new javax.swing.JCheckBox();
        jCheckBoxBaik = new javax.swing.JCheckBox();
        jLabelPilihGambar = new javax.swing.JLabel();
        jLabelGambar = new javax.swing.JLabel();
        jLabelNamaFileBuku = new javax.swing.JLabel();
        jLabelReset = new javax.swing.JLabel();
        jLabelSimpan = new javax.swing.JLabel();
        jLabelHapus = new javax.swing.JLabel();
        jLabelPilihGambar2 = new javax.swing.JLabel();
        jLabelGambar2 = new javax.swing.JLabel();
        jLabelNamaFileBuku2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBook = new javax.swing.JTable();
        jLabelHome = new javax.swing.JLabel();
        jLabelAdd = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

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
        jPanel1.add(jLabelClose);
        jLabelClose.setBounds(100, 250, 90, 50);

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
        jPanel1.add(jLabelLogout);
        jLabelLogout.setBounds(70, 200, 45, 50);

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
        jPanel1.add(jLabelIcon);
        jLabelIcon.setBounds(0, 250, 90, 50);

        jLabel10.setFont(new java.awt.Font("Myriad Pro Cond", 1, 30)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tambah Data");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(0, 130, 190, 31);

        jPanel2.setBackground(new java.awt.Color(252, 225, 190));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 123, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLebarTotal.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelLebarTotal.setText("Lebar Total Jembatan");
        jPanel2.add(jLabelLebarTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, -1));

        jLabelRuas.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelRuas.setText("No Ruas");
        jPanel2.add(jLabelRuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabelPangkal.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelPangkal.setText("Pangkal - Ujung");
        jPanel2.add(jLabelPangkal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jLabelKecamatan.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelKecamatan.setText("Kecamatan");
        jPanel2.add(jLabelKecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, -1));

        jLabelNamaJembatan.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelNamaJembatan.setText("Nama Jembatan");
        jPanel2.add(jLabelNamaJembatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabelJumlahJembatan.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelJumlahJembatan.setText("Jumlah");
        jPanel2.add(jLabelJumlahJembatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, -1, -1));

        jLabelPanjang.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelPanjang.setText("Panjang Jembatan");
        jPanel2.add(jLabelPanjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabelLebar.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelLebar.setText("Lebar Jalur Jembatan");
        jPanel2.add(jLabelLebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jLabelKoordinat.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelKoordinat.setText("Koordinat");
        jPanel2.add(jLabelKoordinat, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        jLabelBangunanAtas.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelBangunanAtas.setText("Bangunan Atas");
        jPanel2.add(jLabelBangunanAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabelBangunanBawah.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelBangunanBawah.setText("Bangunan Bawah");
        jPanel2.add(jLabelBangunanBawah, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabelKondisi.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelKondisi.setText("Kondisi Jembatan");
        jPanel2.add(jLabelKondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 160, -1, -1));

        jLabelAkses.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelAkses.setText("Akses");
        jPanel2.add(jLabelAkses, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, -1, -1));

        jComboBoxKecamatan.setBackground(new java.awt.Color(244, 153, 20));
        jComboBoxKecamatan.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jComboBoxKecamatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KECAMATAN", "- Bondowoso", "- Wringin", "- Pakem", "- Binakal", "- Curahdami", "- Pujer", "- Wonosari", "- Botolinggo", "- Prajekan", "- Grujugan", "- Sempol", "- Klabang", "- Tapen", "- Sukosari", "- Sumber Wringin", "- Maesan", "- Taman Krocok", "- Tegalampel", "- Tenggarang", "- Tlogosari", "- Jambesari", "- Cermee", "- Tamanan" }));
        jComboBoxKecamatan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jComboBoxKecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 230, 30));

        jTextFieldRuas.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldRuas.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldRuas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldRuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, 30));

        jTextFieldPangkal.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldPangkal.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldPangkal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldPangkal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 210, 30));

        jTextFieldNamaJembatan.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldNamaJembatan.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldNamaJembatan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldNamaJembatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 230, 30));

        jTextFieldJumlah.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldJumlah.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldJumlah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 120, 230, 30));

        jTextFieldPanjang.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldPanjang.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldPanjang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldPanjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 30));

        jTextFieldLebar.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldLebar.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldLebar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldLebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 210, 30));

        jTextFieldLebarTotal.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldLebarTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldLebarTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldLebarTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 230, 30));

        jTextFieldBangunAtas.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldBangunAtas.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldBangunAtas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldBangunAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 30));

        jTextFieldBangunBawah.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldBangunBawah.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldBangunBawah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldBangunBawah, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 210, 30));

        jTextFieldKoordinat.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldKoordinat.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        jTextFieldKoordinat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextFieldKoordinat, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 230, 30));

        jRadioButtonNegara.setBackground(new java.awt.Color(252, 225, 190));
        buttonGroupAkses.add(jRadioButtonNegara);
        jRadioButtonNegara.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        jRadioButtonNegara.setText("Negara");
        jRadioButtonNegara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNegaraActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButtonNegara, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 190, -1, 30));

        jRadioButtonProvinsi.setBackground(new java.awt.Color(252, 225, 190));
        buttonGroupAkses.add(jRadioButtonProvinsi);
        jRadioButtonProvinsi.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        jRadioButtonProvinsi.setText("Provinsi");
        jRadioButtonProvinsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonProvinsiActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButtonProvinsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 220, -1, 30));

        jRadioButtonKabupaten.setBackground(new java.awt.Color(252, 225, 190));
        buttonGroupAkses.add(jRadioButtonKabupaten);
        jRadioButtonKabupaten.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        jRadioButtonKabupaten.setText("Kabupaten");
        jRadioButtonKabupaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonKabupatenActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButtonKabupaten, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 250, -1, 30));

        jCheckBoxRusakSedang.setBackground(new java.awt.Color(252, 225, 190));
        buttonGroupKondisi.add(jCheckBoxRusakSedang);
        jCheckBoxRusakSedang.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        jCheckBoxRusakSedang.setText("Rusak Sedang");
        jCheckBoxRusakSedang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRusakSedangActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxRusakSedang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 250, -1, -1));

        jCheckBoxRusakBerat.setBackground(new java.awt.Color(252, 225, 190));
        buttonGroupKondisi.add(jCheckBoxRusakBerat);
        jCheckBoxRusakBerat.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        jCheckBoxRusakBerat.setText("Rusak Berat");
        jCheckBoxRusakBerat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRusakBeratActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxRusakBerat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 280, -1, -1));

        jCheckBoxRusakRingan.setBackground(new java.awt.Color(252, 225, 190));
        buttonGroupKondisi.add(jCheckBoxRusakRingan);
        jCheckBoxRusakRingan.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        jCheckBoxRusakRingan.setText("Rusak Ringan");
        jCheckBoxRusakRingan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxRusakRinganActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxRusakRingan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 220, 120, -1));

        jCheckBoxBaik.setBackground(new java.awt.Color(252, 225, 190));
        buttonGroupKondisi.add(jCheckBoxBaik);
        jCheckBoxBaik.setFont(new java.awt.Font("Tw Cen MT", 0, 16)); // NOI18N
        jCheckBoxBaik.setText("Baik");
        jCheckBoxBaik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxBaikActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBoxBaik, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 190, -1, -1));

        jLabelPilihGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pilihgambar.png"))); // NOI18N
        jLabelPilihGambar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPilihGambarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPilihGambarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPilihGambarMouseExited(evt);
            }
        });
        jPanel2.add(jLabelPilihGambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, -1, -1));

        jLabelGambar.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabelGambar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelGambar.setOpaque(true);
        jPanel2.add(jLabelGambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 430, 280));

        jLabelNamaFileBuku.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelNamaFileBuku.setText("Gambar 1");
        jPanel2.add(jLabelNamaFileBuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 430, 30));

        jLabelReset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reset.png"))); // NOI18N
        jLabelReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelResetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelResetMouseExited(evt);
            }
        });
        jPanel2.add(jLabelReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 420, 100, -1));

        jLabelSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/simpan.png"))); // NOI18N
        jLabelSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSimpanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSimpanMouseExited(evt);
            }
        });
        jPanel2.add(jLabelSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 340, -1, -1));

        jLabelHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hapus.png"))); // NOI18N
        jLabelHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHapusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelHapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelHapusMouseExited(evt);
            }
        });
        jPanel2.add(jLabelHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 380, -1, -1));

        jLabelPilihGambar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pilihgambar.png"))); // NOI18N
        jLabelPilihGambar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPilihGambar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPilihGambar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPilihGambar2MouseExited(evt);
            }
        });
        jPanel2.add(jLabelPilihGambar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, -1, -1));

        jLabelGambar2.setBackground(new java.awt.Color(244, 153, 20));
        jLabelGambar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabelGambar2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelGambar2.setOpaque(true);
        jPanel2.add(jLabelGambar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 430, 280));

        jLabelNamaFileBuku2.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelNamaFileBuku2.setText("Gambar 2");
        jPanel2.add(jLabelNamaFileBuku2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 430, 30));

        jTableBook.setBackground(new java.awt.Color(252, 191, 101));
        jTableBook.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTableBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Ruas", "Pangkal - Ujung", "Kecamatan", "Nama Jembatan", "Jumlah", "Panjang", "Lebar Jalur", "Lebar Total", "Bangunan Atas", "Bangunan Bawah", "Kondisi", "Akses", "Koordinat", "Gambar"
            }
        ));
        jTableBook.setGridColor(new java.awt.Color(191, 100, 17));
        jScrollPane1.setViewportView(jTableBook);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1140, 190));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(200, 10, 1160, 750);

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
        jPanel1.add(jLabelHome);
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
        jPanel1.add(jLabelAdd);
        jLabelAdd.setBounds(0, 490, 190, 121);

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
        jPanel1.add(jLabelSearch);
        jLabelSearch.setBounds(0, 620, 190, 115);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/menu.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 1366, 768);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        setSize(new java.awt.Dimension(1366, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxBaikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxBaikActionPerformed
        String kondisi;
        kondisi = "1";
    }//GEN-LAST:event_jCheckBoxBaikActionPerformed

    private void jCheckBoxRusakRinganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRusakRinganActionPerformed
        String kondisi;
        kondisi = "2";
    }//GEN-LAST:event_jCheckBoxRusakRinganActionPerformed

    private void jCheckBoxRusakSedangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRusakSedangActionPerformed
        String kondisi;
        kondisi = "3";
    }//GEN-LAST:event_jCheckBoxRusakSedangActionPerformed

    private void jCheckBoxRusakBeratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxRusakBeratActionPerformed
        String kondisi;
        kondisi = "4";
    }//GEN-LAST:event_jCheckBoxRusakBeratActionPerformed

    private void jRadioButtonNegaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNegaraActionPerformed
        String akses;
        akses = "1";
    }//GEN-LAST:event_jRadioButtonNegaraActionPerformed

    private void jRadioButtonProvinsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonProvinsiActionPerformed
        String akses;
        akses = "2";
    }//GEN-LAST:event_jRadioButtonProvinsiActionPerformed

    private void jRadioButtonKabupatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonKabupatenActionPerformed
        String akses;
        akses = "3";
    }//GEN-LAST:event_jRadioButtonKabupatenActionPerformed

    private void jLabelIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseClicked
        this.setExtendedState(jembatanSearch.ICONIFIED);
    }//GEN-LAST:event_jLabelIconMouseClicked

    private void jLabelIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseEntered
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize-hover.png")));
    }//GEN-LAST:event_jLabelIconMouseEntered

    private void jLabelIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseExited
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png")));
    }//GEN-LAST:event_jLabelIconMouseExited

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "Warning!", 2) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close-hover.png")));
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png")));
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jLabelResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseClicked
        reset();
    }//GEN-LAST:event_jLabelResetMouseClicked

    private void jLabelResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseEntered
        jLabelReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/resethover.png")));
    }//GEN-LAST:event_jLabelResetMouseEntered

    private void jLabelResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseExited
        jLabelReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reset.png")));
    }//GEN-LAST:event_jLabelResetMouseExited

    private void jLabelSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSimpanMouseClicked
        try {
            String akses;
            String kondisi;
            int kec;
            String kecamatan;

            jembatanDomain dom = new jembatanDomain();
            dom.setImage1(jLabelNamaFileBuku.getText());
            dom.setImage2(jLabelNamaFileBuku2.getText());
            dom.setNo_ruas(jTextFieldRuas.getText());
            dom.setPangkal_ujung(jTextFieldPangkal.getText());
            dom.setNama_jbt(jTextFieldNamaJembatan.getText());
            dom.setJml(jTextFieldJumlah.getText());
            dom.setUk_panjang(jTextFieldPanjang.getText());
            dom.setUk_lebar(jTextFieldLebar.getText());
            dom.setUk_lebartot(jTextFieldLebarTotal.getText());
            dom.setBangun_atas(jTextFieldBangunAtas.getText());
            dom.setBangun_bawah(jTextFieldBangunBawah.getText());
            dom.setKoordinat(jTextFieldKoordinat.getText());
            try {
                kec = jComboBoxKecamatan.getSelectedIndex();
                if (kec == 0) {
                    kecamatan = "";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 1) {
                    kecamatan = "1";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 2) {
                    kecamatan = "2";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 3) {
                    kecamatan = "3";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 4) {
                    kecamatan = "4";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 5) {
                    kecamatan = "5";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 6) {
                    kecamatan = "6";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 7) {
                    kecamatan = "7";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 8) {
                    kecamatan = "8";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 9) {
                    kecamatan = "9";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 10) {
                    kecamatan = "10";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 11) {
                    kecamatan = "11";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 12) {
                    kecamatan = "12";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 13) {
                    kecamatan = "13";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 14) {
                    kecamatan = "14";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 15) {
                    kecamatan = "15";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 16) {
                    kecamatan = "16";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 17) {
                    kecamatan = "17";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 18) {
                    kecamatan = "18";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 19) {
                    kecamatan = "19";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 20) {
                    kecamatan = "20";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 21) {
                    kecamatan = "21";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 22) {
                    kecamatan = "22";
                    dom.setId_kec(kecamatan);
                }
                if (kec == 23) {
                    kecamatan = "23";
                    dom.setId_kec(kecamatan);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ComboBox error! : " + e, "Info", JOptionPane.INFORMATION_MESSAGE);
            }

            if (jRadioButtonNegara.isSelected()) {
                akses = "1";
                dom.setId_akses(akses);
            }
            if (jRadioButtonProvinsi.isSelected()) {
                akses = "2";
                dom.setId_akses(akses);
            }
            if (jRadioButtonKabupaten.isSelected()) {
                akses = "3";
                dom.setId_akses(akses);
            }
            if (jCheckBoxBaik.isSelected()) {
                kondisi = "1";
                dom.setId_kondisi(kondisi);
            }
            if (jCheckBoxRusakRingan.isSelected()) {
                kondisi = "2";
                dom.setId_kondisi(kondisi);
            }
            if (jCheckBoxRusakSedang.isSelected()) {
                kondisi = "3";
                dom.setId_kondisi(kondisi);
            }
            if (jCheckBoxRusakBerat.isSelected()) {
                kondisi = "4";
                dom.setId_kondisi(kondisi);
            }

            jembatanService.saveData(dom);
            jembatanTableModel.save(dom);
            
            String path1 = new File(".").getCanonicalPath();
            FileUtils.copyFileToDirectory(file, new File(path1 + "/image"));

            String path2 = new File(".").getCanonicalPath();
            FileUtils.copyFileToDirectory(file2, new File(path2 + "/image2"));

            JOptionPane.showMessageDialog(null, "Data Saved!", "Warning", JOptionPane.INFORMATION_MESSAGE);

            initTable();

        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while Saving! " + ex, "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabelSimpanMouseClicked

    private void jLabelSimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSimpanMouseEntered
        jLabelSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/simpanhover.png")));
    }//GEN-LAST:event_jLabelSimpanMouseEntered

    private void jLabelSimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSimpanMouseExited
        jLabelSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/simpan.png")));
    }//GEN-LAST:event_jLabelSimpanMouseExited

    private void jLabelHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHapusMouseClicked
        jembatanHapus hapus = new jembatanHapus();
        hapus.setVisible(true);
    }//GEN-LAST:event_jLabelHapusMouseClicked

    private void jLabelHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHapusMouseEntered
        jLabelHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hapushover.png")));
    }//GEN-LAST:event_jLabelHapusMouseEntered

    private void jLabelHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHapusMouseExited
        jLabelHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hapus.png")));
    }//GEN-LAST:event_jLabelHapusMouseExited

    private void jLabelPilihGambarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPilihGambarMouseClicked
        jfc = new JFileChooser();
        if (jfc.showOpenDialog(jLabelGambar) == JFileChooser.APPROVE_OPTION) {

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.getImage(jfc.getSelectedFile().getAbsolutePath());
            Image imagedResized = image.getScaledInstance(430, 280, Image.SCALE_DEFAULT);
            ImageIcon imageIcon = new ImageIcon(imagedResized);

            jLabelGambar.setIcon(imageIcon);
            jLabelNamaFileBuku.setText(jfc.getSelectedFile().getName());

            file = new File(jfc.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_jLabelPilihGambarMouseClicked

    private void jLabelPilihGambarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPilihGambarMouseEntered
        jLabelPilihGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pilihgambarhover.png")));
    }//GEN-LAST:event_jLabelPilihGambarMouseEntered

    private void jLabelPilihGambarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPilihGambarMouseExited
        jLabelPilihGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pilihgambar.png")));
    }//GEN-LAST:event_jLabelPilihGambarMouseExited

    private void jLabelPilihGambar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPilihGambar2MouseClicked
        jfc2 = new JFileChooser();
        if (jfc2.showOpenDialog(jLabelGambar2) == JFileChooser.APPROVE_OPTION) {

            Toolkit toolkit2 = Toolkit.getDefaultToolkit();
            Image image2 = toolkit2.getImage(jfc2.getSelectedFile().getAbsolutePath());
            Image imagedResized2 = image2.getScaledInstance(430, 280, Image.SCALE_DEFAULT);
            ImageIcon imageIcon2 = new ImageIcon(imagedResized2);

            jLabelGambar2.setIcon(imageIcon2);
            jLabelNamaFileBuku2.setText(jfc2.getSelectedFile().getName());

            file2 = new File(jfc2.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_jLabelPilihGambar2MouseClicked

    private void jLabelPilihGambar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPilihGambar2MouseEntered
        jLabelPilihGambar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pilihgambarhover.png")));
    }//GEN-LAST:event_jLabelPilihGambar2MouseEntered

    private void jLabelPilihGambar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPilihGambar2MouseExited
        jLabelPilihGambar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pilihgambar.png")));
    }//GEN-LAST:event_jLabelPilihGambar2MouseExited

    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseClicked
        jembatanLogin Login = new jembatanLogin();
        if (JOptionPane.showConfirmDialog(null, "Anda akan logout dari akun ini, apakah anda yakin?", "Warning!", 2) == JOptionPane.YES_NO_OPTION) {
            login.Logout(Session.getUser());
            dispose();
            Login.setVisible(true);
        }
    }//GEN-LAST:event_jLabelLogoutMouseClicked

    private void jLabelLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseEntered
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout-hover.png")));
    }//GEN-LAST:event_jLabelLogoutMouseEntered

    private void jLabelLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseExited
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png")));
    }//GEN-LAST:event_jLabelLogoutMouseExited

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
            java.util.logging.Logger.getLogger(jembatanAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jembatanAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jembatanAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jembatanAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new jembatanAdd().setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "");
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.ButtonGroup buttonGroupAkses;
    private javax.swing.ButtonGroup buttonGroupKondisi;
    private javax.swing.JCheckBox jCheckBoxBaik;
    private javax.swing.JCheckBox jCheckBoxRusakBerat;
    private javax.swing.JCheckBox jCheckBoxRusakRingan;
    private javax.swing.JCheckBox jCheckBoxRusakSedang;
    private javax.swing.JComboBox<String> jComboBoxKecamatan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabelAdd;
    private javax.swing.JLabel jLabelAkses;
    private javax.swing.JLabel jLabelBangunanAtas;
    private javax.swing.JLabel jLabelBangunanBawah;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelGambar;
    private javax.swing.JLabel jLabelGambar2;
    private javax.swing.JLabel jLabelHapus;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelJumlahJembatan;
    private javax.swing.JLabel jLabelKecamatan;
    private javax.swing.JLabel jLabelKondisi;
    private javax.swing.JLabel jLabelKoordinat;
    private javax.swing.JLabel jLabelLebar;
    private javax.swing.JLabel jLabelLebarTotal;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelNamaFileBuku;
    private javax.swing.JLabel jLabelNamaFileBuku2;
    private javax.swing.JLabel jLabelNamaJembatan;
    private javax.swing.JLabel jLabelPangkal;
    private javax.swing.JLabel jLabelPanjang;
    private javax.swing.JLabel jLabelPilihGambar;
    private javax.swing.JLabel jLabelPilihGambar2;
    private javax.swing.JLabel jLabelReset;
    private javax.swing.JLabel jLabelRuas;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JLabel jLabelSimpan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonKabupaten;
    private javax.swing.JRadioButton jRadioButtonNegara;
    private javax.swing.JRadioButton jRadioButtonProvinsi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBook;
    private javax.swing.JTextField jTextFieldBangunAtas;
    private javax.swing.JTextField jTextFieldBangunBawah;
    private javax.swing.JTextField jTextFieldJumlah;
    private javax.swing.JTextField jTextFieldKoordinat;
    private javax.swing.JTextField jTextFieldLebar;
    private javax.swing.JTextField jTextFieldLebarTotal;
    private javax.swing.JTextField jTextFieldNamaJembatan;
    private javax.swing.JTextField jTextFieldPangkal;
    private javax.swing.JTextField jTextFieldPanjang;
    private javax.swing.JTextField jTextFieldRuas;
    // End of variables declaration//GEN-END:variables
}
