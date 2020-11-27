package com.raphtech.databasejembatank10.view;

import com.raphtech.databasejembatank10.dao.jembatanDao;
import com.raphtech.databasejembatank10.domain.jembatanDomain;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class jembatanHapus extends javax.swing.JFrame {

    private ResultSet rs;
    private DefaultTableModel defaultTableModel;
    
    jembatanDao dao = new jembatanDao();
    jembatanDomain dom = new jembatanDomain();
    
    public jembatanHapus() {
        initComponents();
        showDatabase();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void showDatabase() {
        Object[] row = {"No. Ruas","Pangkal - Ujung","Kecamatan","Nama Jembatan","Jumlah","Panjang","Lebar","Lebar Total","Bangunan Atas","Bangunan Bawah","Kondisi","Akses","Koordinat"};
        defaultTableModel = new DefaultTableModel(null,row);
        jTableData.setModel(defaultTableModel);
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
                String[] data = {dom.getNo_ruas(),dom.getPangkal_ujung(),dom.getId_kec(),dom.getNama_jbt(),dom.getJml(),dom.getUk_panjang(),dom.getUk_lebar(),dom.getUk_lebartot(),
                dom.getBangun_atas(),dom.getBangun_bawah(),dom.getId_kondisi(),dom.getId_akses(),dom.getKoordinat()};
                defaultTableModel.addRow(data);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SHOW DATABASES ERROR! ("+ e +")");
        }
    }
    
    public void reset() {
        jLabelNoRuas.setText("");
        jLabelKecamatan.setText("");
        jLabelNama.setText("");
        jLabelJumlah.setText("");
        jLabelPangkal.setText("");
        jLabelPanjang.setText("");
        jLabelLebar.setText("");
        jLabelLebarTot.setText("");
        jLabelBangunAtas.setText("");
        jLabelBangunBawah.setText("");
        jLabelAkses.setText("");
        jLabelKondisi.setText("");
        jLabelKoordinat.setText("");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAkses = new javax.swing.ButtonGroup();
        buttonGroupKondisi = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelJudulNama = new javax.swing.JLabel();
        jLabelJudulPangkal = new javax.swing.JLabel();
        jLabelJudulKoodinat = new javax.swing.JLabel();
        jLabelJudulRuas = new javax.swing.JLabel();
        jLabelJudulLebar = new javax.swing.JLabel();
        jLabelJudulPanjang = new javax.swing.JLabel();
        jLabelJudulBangunBawah = new javax.swing.JLabel();
        jLabelJudulLebarTot = new javax.swing.JLabel();
        jLabelJudulJumlah = new javax.swing.JLabel();
        jLabelJudulBangunAtas = new javax.swing.JLabel();
        jLabelJudulKecamatan = new javax.swing.JLabel();
        jLabelJudulKondisi = new javax.swing.JLabel();
        jLabelJudulAkses = new javax.swing.JLabel();
        jLabelAkses = new javax.swing.JLabel();
        jLabelNoRuas = new javax.swing.JLabel();
        jLabelPangkal = new javax.swing.JLabel();
        jLabelNama = new javax.swing.JLabel();
        jLabelKecamatan = new javax.swing.JLabel();
        jLabelBangunAtas = new javax.swing.JLabel();
        jLabelBangunBawah = new javax.swing.JLabel();
        jLabelKoordinat = new javax.swing.JLabel();
        jLabelJumlah = new javax.swing.JLabel();
        jLabelPanjang = new javax.swing.JLabel();
        jLabelLebar = new javax.swing.JLabel();
        jLabelKondisi = new javax.swing.JLabel();
        jLabelLebarTot = new javax.swing.JLabel();
        jLabelReset = new javax.swing.JLabel();
        jLabelHapus = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableData.setBackground(new java.awt.Color(252, 191, 101));
        jTableData.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jTableData.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Ruas", "Pangkal - Ujung", "Kecamatan", "Nama Jembatan", "Jumlah", "Panjang", "Lebar Jalur", "Lebar Total", "Bangunan Atas", "Bangunan Bawah", "Kondisi", "Akses", "Koordinat", "Gambar"
            }
        ));
        jTableData.setGridColor(new java.awt.Color(191, 100, 17));
        jTableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableData);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 452, 1010, 200));

        jPanel1.setBackground(new java.awt.Color(252, 225, 190));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 123, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelJudulNama.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulNama.setText("Nama Jembatan");
        jPanel1.add(jLabelJudulNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 990, -1));

        jLabelJudulPangkal.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulPangkal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulPangkal.setText("Pangkal - Ujung");
        jPanel1.add(jLabelJudulPangkal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 240, -1));

        jLabelJudulKoodinat.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulKoodinat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulKoodinat.setText("Koordinat");
        jPanel1.add(jLabelJudulKoodinat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 240, -1));

        jLabelJudulRuas.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulRuas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulRuas.setText("No. Ruas");
        jPanel1.add(jLabelJudulRuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 240, -1));

        jLabelJudulLebar.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulLebar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulLebar.setText("Lebar Jalur");
        jPanel1.add(jLabelJudulLebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 240, -1));

        jLabelJudulPanjang.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulPanjang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulPanjang.setText("Panjang");
        jPanel1.add(jLabelJudulPanjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 240, -1));

        jLabelJudulBangunBawah.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulBangunBawah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulBangunBawah.setText("Bangunan Bawah");
        jPanel1.add(jLabelJudulBangunBawah, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 240, -1));

        jLabelJudulLebarTot.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulLebarTot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulLebarTot.setText("Lebar Total");
        jPanel1.add(jLabelJudulLebarTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 240, -1));

        jLabelJudulJumlah.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulJumlah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulJumlah.setText("Jumlah");
        jPanel1.add(jLabelJudulJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, 240, -1));

        jLabelJudulBangunAtas.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulBangunAtas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulBangunAtas.setText("Bangunan Atas");
        jPanel1.add(jLabelJudulBangunAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 240, -1));

        jLabelJudulKecamatan.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulKecamatan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulKecamatan.setText("Kecamatan");
        jPanel1.add(jLabelJudulKecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 240, -1));

        jLabelJudulKondisi.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulKondisi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulKondisi.setText("Kondisi");
        jPanel1.add(jLabelJudulKondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 240, -1));

        jLabelJudulAkses.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabelJudulAkses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJudulAkses.setText("Akses");
        jPanel1.add(jLabelJudulAkses, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 240, -1));

        jLabelAkses.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelAkses.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAkses.setText("....");
        jPanel1.add(jLabelAkses, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, 240, 30));

        jLabelNoRuas.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelNoRuas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoRuas.setText("....");
        jPanel1.add(jLabelNoRuas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 240, 30));

        jLabelPangkal.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelPangkal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPangkal.setText("....");
        jPanel1.add(jLabelPangkal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 240, 30));

        jLabelNama.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNama.setText("....");
        jPanel1.add(jLabelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 990, 30));

        jLabelKecamatan.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelKecamatan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelKecamatan.setText("....");
        jPanel1.add(jLabelKecamatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 240, 30));

        jLabelBangunAtas.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelBangunAtas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBangunAtas.setText("....");
        jPanel1.add(jLabelBangunAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 240, 30));

        jLabelBangunBawah.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelBangunBawah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBangunBawah.setText("....");
        jPanel1.add(jLabelBangunBawah, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 240, 30));

        jLabelKoordinat.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelKoordinat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelKoordinat.setText("....");
        jPanel1.add(jLabelKoordinat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 240, 30));

        jLabelJumlah.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelJumlah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelJumlah.setText("....");
        jPanel1.add(jLabelJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 240, 30));

        jLabelPanjang.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelPanjang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPanjang.setText("....");
        jPanel1.add(jLabelPanjang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 240, 30));

        jLabelLebar.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelLebar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLebar.setText("....");
        jPanel1.add(jLabelLebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 240, 30));

        jLabelKondisi.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelKondisi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelKondisi.setText("....");
        jPanel1.add(jLabelKondisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 240, 30));

        jLabelLebarTot.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jLabelLebarTot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLebarTot.setText("....");
        jPanel1.add(jLabelLebarTot, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 240, 30));

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
        jPanel1.add(jLabelReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 990, -1));

        jLabelHapus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
        jPanel1.add(jLabelHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 990, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 25, 1010, 420));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/popup.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, -1));

        setSize(new java.awt.Dimension(1068, 722));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseClicked
        reset();
    }//GEN-LAST:event_jLabelResetMouseClicked

    private void jLabelResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseEntered
        jLabelReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/resethover.png")));
    }//GEN-LAST:event_jLabelResetMouseEntered

    private void jLabelResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseExited
        jLabelReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reset.png")));
    }//GEN-LAST:event_jLabelResetMouseExited

    private void jLabelHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHapusMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?","Warning!",2) == JOptionPane.YES_NO_OPTION) {
            String id = "";
            try {
                dom.setNama_jbt(jLabelNama.getText());
                dao.deleteData(dom.getNama_jbt());
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus","Warning",JOptionPane.INFORMATION_MESSAGE);
                showDatabase();
                reset();
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus","Warning",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jLabelHapusMouseClicked

    private void jLabelHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHapusMouseEntered
        jLabelHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hapushover.png")));
    }//GEN-LAST:event_jLabelHapusMouseEntered

    private void jLabelHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHapusMouseExited
        jLabelHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hapus.png")));
    }//GEN-LAST:event_jLabelHapusMouseExited

    private void jTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDataMouseClicked
        try {
            int row = jTableData.rowAtPoint(evt.getPoint());
            
            String no_ruas = jTableData.getValueAt(row, 0).toString();
            String pangkal = jTableData.getValueAt(row, 1).toString();
            String kec = jTableData.getValueAt(row, 2).toString();
            String nama = jTableData.getValueAt(row, 3).toString();
            String jml = jTableData.getValueAt(row, 4).toString();
            String panjang = jTableData.getValueAt(row, 5).toString();
            String lebar = jTableData.getValueAt(row, 6).toString();
            String lebartot = jTableData.getValueAt(row, 7).toString();
            String atas = jTableData.getValueAt(row, 8).toString();
            String bawah = jTableData.getValueAt(row, 9).toString();
            String kondisi = jTableData.getValueAt(row, 10).toString();
            String akses = jTableData.getValueAt(row, 11).toString();
            String koordinat = jTableData.getValueAt(row, 12).toString();
            
            jLabelNoRuas.setText(String.valueOf(no_ruas));
            jLabelPangkal.setText(String.valueOf(pangkal));
            jLabelKecamatan.setText(String.valueOf(kec));
            jLabelNama.setText(String.valueOf(nama));
            jLabelJumlah.setText(String.valueOf(jml));
            jLabelPanjang.setText(String.valueOf(panjang));
            jLabelLebar.setText(String.valueOf(lebar));
            jLabelLebarTot.setText(String.valueOf(lebartot));
            jLabelBangunAtas.setText(String.valueOf(atas));
            jLabelBangunBawah.setText(String.valueOf(bawah));
            jLabelKondisi.setText(String.valueOf(kondisi));
            jLabelAkses.setText(String.valueOf(akses));
            jLabelKoordinat.setText(String.valueOf(koordinat));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTableDataMouseClicked
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
            java.util.logging.Logger.getLogger(jembatanHapus.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jembatanHapus.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jembatanHapus.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jembatanHapus.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jembatanHapus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.ButtonGroup buttonGroupAkses;
    private javax.swing.ButtonGroup buttonGroupKondisi;
    private javax.swing.JLabel jLabelAkses;
    private javax.swing.JLabel jLabelBangunAtas;
    private javax.swing.JLabel jLabelBangunBawah;
    private javax.swing.JLabel jLabelHapus;
    private javax.swing.JLabel jLabelJudulAkses;
    private javax.swing.JLabel jLabelJudulBangunAtas;
    private javax.swing.JLabel jLabelJudulBangunBawah;
    private javax.swing.JLabel jLabelJudulJumlah;
    private javax.swing.JLabel jLabelJudulKecamatan;
    private javax.swing.JLabel jLabelJudulKondisi;
    private javax.swing.JLabel jLabelJudulKoodinat;
    private javax.swing.JLabel jLabelJudulLebar;
    private javax.swing.JLabel jLabelJudulLebarTot;
    private javax.swing.JLabel jLabelJudulNama;
    private javax.swing.JLabel jLabelJudulPangkal;
    private javax.swing.JLabel jLabelJudulPanjang;
    private javax.swing.JLabel jLabelJudulRuas;
    private javax.swing.JLabel jLabelJumlah;
    private javax.swing.JLabel jLabelKecamatan;
    private javax.swing.JLabel jLabelKondisi;
    private javax.swing.JLabel jLabelKoordinat;
    private javax.swing.JLabel jLabelLebar;
    private javax.swing.JLabel jLabelLebarTot;
    private javax.swing.JLabel jLabelNama;
    private javax.swing.JLabel jLabelNoRuas;
    private javax.swing.JLabel jLabelPangkal;
    private javax.swing.JLabel jLabelPanjang;
    private javax.swing.JLabel jLabelReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableData;
    // End of variables declaration//GEN-END:variables
}
