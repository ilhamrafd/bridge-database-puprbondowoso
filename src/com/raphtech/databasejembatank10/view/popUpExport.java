/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raphtech.databasejembatank10.view;

import com.raphtech.databasejembatank10.connect.jembatanKoneksi;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class popUpExport extends javax.swing.JFrame {
    
    Connection connection;
    Statement statement;
    jembatanKoneksi koneksi = new jembatanKoneksi();
    
    public popUpExport() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void export() throws SQLException, FileNotFoundException, IOException {
        try {
            connection = koneksi.getKoneksi();
            statement = connection.createStatement();

            FileOutputStream fileOut;
            fileOut = new FileOutputStream("C:\\Users\\LENOVO\\Documents\\Project\\DBJembatanK10\\report\\laporandatabasejembatan.xls");
            HSSFWorkbook workBook = new HSSFWorkbook();
            HSSFSheet workSheet = workBook.createSheet("Sheet 0");

            Row row1 = workSheet.createRow((short) 0);
            row1.createCell(0).setCellValue("No. Ruas");
            row1.createCell(1).setCellValue("Pangkal - Ujung");
            row1.createCell(2).setCellValue("Kecamatan");
            row1.createCell(3).setCellValue("Nama Jembatan");
            row1.createCell(4).setCellValue("Jumlah");
            row1.createCell(5).setCellValue("Panjang");
            row1.createCell(6).setCellValue("Lebar");
            row1.createCell(7).setCellValue("Lebar Total");
            row1.createCell(8).setCellValue("Bangunan Atas");
            row1.createCell(9).setCellValue("Bangunan Bawah");
            row1.createCell(10).setCellValue("Kondisi");
            row1.createCell(11).setCellValue("Akses");
            row1.createCell(12).setCellValue("Koordinat");
            row1.createCell(13).setCellValue("Gambar");

            Row row2;
            try (ResultSet rs = statement.executeQuery("SELECT u.no_ruas, u.pangkal_ujung, k.nama_kec, u.nama_jbt, u.jml, u.uk_panjang, u.uk_lebar, u.uk_lebartot, u.bangun_atas, u.bangun_bawah, ko.kondisi, a.akses, u.koordinat, u.image "
                    + "FROM tbl_utama u, tbl_kecamatan k, tbl_kondisi ko, tbl_akses a "
                    + "WHERE u.id_kec=k.id_kec AND u.id_kondisi=ko.id_kondisi AND u.id_akses=a.id_akses")) {
                while (rs.next()) {
                    int row = rs.getRow();
                    row2 = workSheet.createRow((short) row);
                    row2.createCell(0).setCellValue(rs.getString(1));
                    row2.createCell(1).setCellValue(rs.getString(2));
                    row2.createCell(2).setCellValue(rs.getString(3));
                    row2.createCell(3).setCellValue(rs.getString(4));
                    row2.createCell(4).setCellValue(rs.getString(5));
                    row2.createCell(5).setCellValue(rs.getString(6));
                    row2.createCell(6).setCellValue(rs.getString(7));
                    row2.createCell(7).setCellValue(rs.getString(8));
                    row2.createCell(8).setCellValue(rs.getString(9));
                    row2.createCell(9).setCellValue(rs.getString(10));
                    row2.createCell(10).setCellValue(rs.getString(11));
                    row2.createCell(11).setCellValue(rs.getString(12));
                    row2.createCell(12).setCellValue(rs.getString(13));
                    row2.createCell(13).setCellValue(rs.getString(14));
                }
                workBook.write(fileOut);
                fileOut.flush();
                fileOut.close();
            }
            statement.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Export Success!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (HeadlessException | IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Export Fail, error! '" + e + "'", "Warning!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelLanjutkan = new javax.swing.JLabel();
        jLabelBatal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setLayout(null);

        jLabelLanjutkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lanjutkan.png"))); // NOI18N
        jLabelLanjutkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLanjutkanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLanjutkanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLanjutkanMouseExited(evt);
            }
        });
        jPanel1.add(jLabelLanjutkan);
        jLabelLanjutkan.setBounds(180, 250, 104, 31);

        jLabelBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/batal.png"))); // NOI18N
        jLabelBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBatalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBatalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBatalMouseExited(evt);
            }
        });
        jPanel1.add(jLabelBatal);
        jLabelBatal.setBounds(180, 290, 105, 32);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/export.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 460, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelLanjutkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLanjutkanMouseClicked
        try {
            export();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(popUpExport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelLanjutkanMouseClicked

    private void jLabelBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBatalMouseClicked
        dispose();
    }//GEN-LAST:event_jLabelBatalMouseClicked

    private void jLabelLanjutkanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLanjutkanMouseEntered
        jLabelLanjutkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lanjutkanhover.png")));
    }//GEN-LAST:event_jLabelLanjutkanMouseEntered

    private void jLabelLanjutkanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLanjutkanMouseExited
        jLabelLanjutkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lanjutkan.png")));
    }//GEN-LAST:event_jLabelLanjutkanMouseExited

    private void jLabelBatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBatalMouseEntered
        jLabelBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/batalhover.png")));
    }//GEN-LAST:event_jLabelBatalMouseEntered

    private void jLabelBatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelBatalMouseExited
        jLabelBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/batal.png")));
    }//GEN-LAST:event_jLabelBatalMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(popUpExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popUpExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popUpExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popUpExport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popUpExport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelBatal;
    private javax.swing.JLabel jLabelLanjutkan;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
