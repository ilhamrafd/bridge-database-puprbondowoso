package com.raphtech.databasejembatank10.view;

import com.mysql.jdbc.Connection;
import com.raphtech.databasejembatank10.view.jembatanSearch;
import com.raphtech.databasejembatank10.connect.jembatanKoneksi;
import com.raphtech.databasejembatank10.dao.jembatanDao;
import com.raphtech.databasejembatank10.domain.jembatanDomain;
import com.raphtech.databasejembatank10.user.Login;
import com.raphtech.databasejembatank10.user.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class jembatanHome extends javax.swing.JFrame {

    DefaultTableModel defaultTableModel;
    jembatanKoneksi koneksi = new jembatanKoneksi();
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    jembatanDomain dom = new jembatanDomain();
    Login login = new Login();
    jembatanDao dao = new jembatanDao();

    public jembatanHome() {
        if (Session.getStatusLogin() == "Activated") {
            initComponents();
            setSessionNama();
            showDatabase();
        } else {
            dispose();
            jembatanLogin Login = new jembatanLogin();
            Login.setVisible(true);
        }
    }

    public void showDatabase() {
        Object[] row = {"No. Ruas", "Pangkal - Ujung", "Kecamatan", "Nama Jembatan", "Jumlah", "Panjang", "Lebar", "Lebar Total", "Bangunan Atas", "Bangunan Bawah", "Kondisi", "Akses", "Koordinat"};
        defaultTableModel = new DefaultTableModel(null, row);
        jTable.setModel(defaultTableModel);
        try {
            rs = dao.showDefaultTableModel();
            while (rs.next()) {
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
                String[] data = {dom.getNo_ruas(), dom.getPangkal_ujung(), dom.getId_kec(), dom.getNama_jbt(), dom.getJml(), dom.getUk_panjang(), dom.getUk_lebar(), dom.getUk_lebartot(),
                    dom.getBangun_atas(), dom.getBangun_bawah(), dom.getId_kondisi(), dom.getId_akses(), dom.getKoordinat()};
                defaultTableModel.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SHOW DATABASES ERROR! (" + e + ")");
        }

    }

    private void setSessionNama() {
        jLabelNama.setText("Hai " + Session.getNama());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelLog = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelIcon = new javax.swing.JLabel();
        jLabelHome = new javax.swing.JLabel();
        jLabelAdd = new javax.swing.JLabel();
        jLabelSearch = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelExport = new javax.swing.JLabel();
        jLabelPrint = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelNama = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Myriad Pro Cond", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Home");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 130, 180, 31);

        jLabelLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png"))); // NOI18N
        jLabelLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLogMouseExited(evt);
            }
        });
        jPanel2.add(jLabelLog);
        jLabelLog.setBounds(70, 200, 45, 50);

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
        jPanel2.add(jLabelSearch);
        jLabelSearch.setBounds(0, 620, 190, 115);

        jPanel1.setBackground(new java.awt.Color(252, 225, 190));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 123, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setText("Tahun Anggaran");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText(": 2017");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel7.setText("Lokasi");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Gambaran Umum Data Jembatan");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1140, 40));

        jLabelExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/export-excel.png"))); // NOI18N
        jLabelExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExportMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelExportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelExportMouseExited(evt);
            }
        });
        jPanel1.add(jLabelExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 620, -1, -1));

        jLabelPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print-database.png"))); // NOI18N
        jLabelPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPrintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPrintMouseExited(evt);
            }
        });
        jPanel1.add(jLabelPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 620, -1, -1));

        jTable.setBackground(new java.awt.Color(252, 191, 101));
        jTable.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable.setGridColor(new java.awt.Color(191, 100, 17));
        jScrollPane1.setViewportView(jTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 1140, 400));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel6.setText("Nama Kegiatan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel9.setText(": Penyusunan Updating Database Jembatan");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel10.setText(": 23 (Dua Puluh Tiga) Kecamatan");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        jPanel2.add(jPanel1);
        jPanel1.setBounds(200, 10, 1160, 750);

        jLabelNama.setFont(new java.awt.Font("Myriad Pro Cond", 0, 24)); // NOI18N
        jLabelNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNama.setText("Hai ..........");
        jPanel2.add(jLabelNama);
        jLabelNama.setBounds(0, 310, 190, 40);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/menu.png"))); // NOI18N
        jPanel2.add(background);
        background.setBounds(0, 0, 1366, 768);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        setSize(new java.awt.Dimension(1367, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseEntered
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize-hover.png")));
    }//GEN-LAST:event_jLabelIconMouseEntered

    private void jLabelIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseExited
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png")));
    }//GEN-LAST:event_jLabelIconMouseExited

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close-hover.png")));
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png")));
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "Warning!", 2) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseClicked
        this.setExtendedState(jembatanHome.ICONIFIED);
    }//GEN-LAST:event_jLabelIconMouseClicked

    private void jLabelLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogMouseClicked
        jembatanLogin Login = new jembatanLogin();
        if (JOptionPane.showConfirmDialog(null, "Anda akan logout dari akun ini, apakah anda yakin?", "Warning!", 2) == JOptionPane.YES_OPTION) {
            login.Logout(Session.getUser());
            dispose();
            Login.setVisible(true);
        }
    }//GEN-LAST:event_jLabelLogMouseClicked

    private void jLabelLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogMouseEntered
        jLabelLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout-hover.png")));
    }//GEN-LAST:event_jLabelLogMouseEntered

    private void jLabelLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogMouseExited
        jLabelLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout.png")));
    }//GEN-LAST:event_jLabelLogMouseExited

    private void jLabelSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchMouseExited
        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/show.png")));
    }//GEN-LAST:event_jLabelSearchMouseExited

    private void jLabelSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchMouseEntered
        jLabelSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/showhover.png")));
    }//GEN-LAST:event_jLabelSearchMouseEntered

    private void jLabelSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchMouseClicked
        try {
            jembatanSearch show = new jembatanSearch();
            show.setVisible(true);
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(jembatanHome.class.getName()).log(Level.SEVERE, null, ex);
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

    private void jLabelPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPrintMouseExited
        jLabelPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print-database.png")));
    }//GEN-LAST:event_jLabelPrintMouseExited

    private void jLabelPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPrintMouseEntered
        jLabelPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print-database-hover.png")));
    }//GEN-LAST:event_jLabelPrintMouseEntered

    private void jLabelPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPrintMouseClicked
        popUpJasper jasper = new popUpJasper();
        jasper.setVisible(true);
    }//GEN-LAST:event_jLabelPrintMouseClicked

    private void jLabelExportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExportMouseExited
        jLabelExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/export-excel.png")));
    }//GEN-LAST:event_jLabelExportMouseExited

    private void jLabelExportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExportMouseEntered
        jLabelExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/export-excel-hover.png")));
    }//GEN-LAST:event_jLabelExportMouseEntered

    private void jLabelExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExportMouseClicked
        popUpExport export = new popUpExport();
        export.setVisible(true);
    }//GEN-LAST:event_jLabelExportMouseClicked

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jembatanHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdd;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelExport;
    private javax.swing.JLabel jLabelHome;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelLog;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelPrint;
    private javax.swing.JLabel jLabelSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
