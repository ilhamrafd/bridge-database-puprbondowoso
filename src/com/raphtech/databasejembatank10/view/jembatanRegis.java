package com.raphtech.databasejembatank10.view;

import com.raphtech.databasejembatank10.user.Login;
import com.raphtech.databasejembatank10.user.Regis;
import com.raphtech.databasejembatank10.user.Session;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class jembatanRegis extends javax.swing.JFrame {

    private String message;

    public jembatanRegis() {
        initComponents();
    }

    public void reset() {
        jTextAreaAlamat.setText("");
        jTextFieldNama.setText("");
        jTextFieldTelepon.setText("");
        jPasswordField.setText("");
        jTextFieldUser.setText("");
        jRadioButtonPria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pria.png")));
        jRadioButtonWanita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wanita.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupJenisKel = new javax.swing.ButtonGroup();
        jRadioButtonPria = new javax.swing.JRadioButton();
        jRadioButtonWanita = new javax.swing.JRadioButton();
        jLabelSignIn = new javax.swing.JLabel();
        jLabelSignUp = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelIcon = new javax.swing.JLabel();
        jLabelReset = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldTelepon = new javax.swing.JTextField();
        jTextFieldUser = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAlamat = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroupJenisKel.add(jRadioButtonPria);
        jRadioButtonPria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pria.png"))); // NOI18N
        jRadioButtonPria.setOpaque(false);
        jRadioButtonPria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonPriaMouseClicked(evt);
            }
        });
        jRadioButtonPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPriaActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonPria, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 510, 60, 30));

        buttonGroupJenisKel.add(jRadioButtonWanita);
        jRadioButtonWanita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wanita.png"))); // NOI18N
        jRadioButtonWanita.setOpaque(false);
        jRadioButtonWanita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonWanitaMouseClicked(evt);
            }
        });
        jRadioButtonWanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonWanitaActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonWanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, 80, 30));

        jLabelSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsigninregis.png"))); // NOI18N
        jLabelSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSignInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSignInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSignInMouseExited(evt);
            }
        });
        getContentPane().add(jLabelSignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 660, -1, -1));

        jLabelSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsignupregis.png"))); // NOI18N
        jLabelSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSignUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSignUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSignUpMouseExited(evt);
            }
        });
        getContentPane().add(jLabelSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 560, -1, -1));

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
        getContentPane().add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, -1, -1));

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
        getContentPane().add(jLabelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, -1, -1));

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
        getContentPane().add(jLabelReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 560, -1, -1));

        jTextFieldNama.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldNama.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jTextFieldNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldNama.setBorder(null);
        jTextFieldNama.setOpaque(false);
        jTextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 450, 190, 30));

        jTextFieldTelepon.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldTelepon.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jTextFieldTelepon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTelepon.setBorder(null);
        jTextFieldTelepon.setOpaque(false);
        getContentPane().add(jTextFieldTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, 190, 30));

        jTextFieldUser.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldUser.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jTextFieldUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUser.setBorder(null);
        jTextFieldUser.setOpaque(false);
        getContentPane().add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 190, 30));

        jPasswordField.setBackground(new java.awt.Color(244, 153, 20));
        jPasswordField.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField.setBorder(null);
        jPasswordField.setOpaque(false);
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 190, 30));

        jTextAreaAlamat.setBackground(new java.awt.Color(244, 153, 20));
        jTextAreaAlamat.setColumns(20);
        jTextAreaAlamat.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jTextAreaAlamat.setLineWrap(true);
        jTextAreaAlamat.setRows(5);
        jTextAreaAlamat.setWrapStyleWord(true);
        jTextAreaAlamat.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaAlamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 330, 240, 150));

        jPanel1.setLayout(null);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/signup.png"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 1280, 770);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 770));

        setSize(new java.awt.Dimension(1280, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPriaActionPerformed
        String jeniskelamin;
        jeniskelamin = "1";
    }//GEN-LAST:event_jRadioButtonPriaActionPerformed

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close-hover.png")));
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/close.png")));
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jLabelIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseEntered
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize-hover.png")));
    }//GEN-LAST:event_jLabelIconMouseEntered

    private void jLabelIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseExited
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png")));
    }//GEN-LAST:event_jLabelIconMouseExited

    private void jLabelSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignUpMouseEntered
        jLabelSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsignuphover.png")));
    }//GEN-LAST:event_jLabelSignUpMouseEntered

    private void jLabelSignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignUpMouseExited
        jLabelSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsignupregis.png")));
    }//GEN-LAST:event_jLabelSignUpMouseExited

    private void jLabelSignInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignInMouseEntered
        jLabelSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsigninhover.png")));
    }//GEN-LAST:event_jLabelSignInMouseEntered

    private void jLabelSignInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignInMouseExited
        jLabelSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsigninregis.png")));
    }//GEN-LAST:event_jLabelSignInMouseExited

    private void jLabelSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignUpMouseClicked
        String jeniskelamin;
        jembatanLogin Login = new jembatanLogin();
        Regis reg = new Regis();

        try {
            if (jTextFieldUser.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Username harus diisi!");
                jTextFieldUser.requestFocus();
            } else if (jPasswordField.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Password harus diisi!");
                jPasswordField.requestFocus();
            } else if (jTextFieldNama.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Lengkap harus diisi!");
                jTextFieldNama.requestFocus();
            } else if (jTextFieldTelepon.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Nomor Telepon harus diisi!");
                jTextFieldTelepon.requestFocus();
            } else {
                Session.setUser(jTextFieldUser.getText());
                Session.setPassword(jPasswordField.getText());
                Session.setNama(jTextFieldNama.getText());
                try {
                    if (jRadioButtonPria.isSelected()) {
                        jeniskelamin = "Pria";
                        Session.setJeniskelamin(jeniskelamin);
                    }
                    if (jRadioButtonWanita.isSelected()) {
                        jeniskelamin = "Wanita";
                        Session.setJeniskelamin(jeniskelamin);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Jenis Kelamin error!");
                }
                Session.setAlamat(jTextAreaAlamat.getText());
                Session.setTelepon(jTextFieldTelepon.getText());
            }
            reg.Regis(Session.getUser(), Session.getPassword(), Session.getNama(), Session.getJeniskelamin(), Session.getAlamat(), Session.getTelepon());
            JOptionPane.showMessageDialog(null, "Register Succesfully! Welcome!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            reset();
            dispose();
            Login.setVisible(true);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Register failed! " + e);
            jembatanRegis Regis = new jembatanRegis();
            Regis.setVisible(true);
        }
    }//GEN-LAST:event_jLabelSignUpMouseClicked

    private void jLabelSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignInMouseClicked
        dispose();
        jembatanLogin Login = new jembatanLogin();
        Login.setVisible(true);
    }//GEN-LAST:event_jLabelSignInMouseClicked

    private void jRadioButtonWanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonWanitaActionPerformed
        String jeniskelamin;
        jeniskelamin = "2";
    }//GEN-LAST:event_jRadioButtonWanitaActionPerformed

    private void jLabelResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseClicked
        reset();
    }//GEN-LAST:event_jLabelResetMouseClicked

    private void jLabelResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseEntered
        jLabelReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/resethover.png")));
    }//GEN-LAST:event_jLabelResetMouseEntered

    private void jLabelResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelResetMouseExited
        jLabelReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reset.png")));
    }//GEN-LAST:event_jLabelResetMouseExited

    private void jRadioButtonPriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonPriaMouseClicked
        jRadioButtonPria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/priahover.png")));
        jRadioButtonWanita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wanita.png")));
    }//GEN-LAST:event_jRadioButtonPriaMouseClicked

    private void jRadioButtonWanitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonWanitaMouseClicked
        jRadioButtonWanita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/wanitahover.png")));
        jRadioButtonPria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pria.png")));
    }//GEN-LAST:event_jRadioButtonWanitaMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar?", "Warning!", 2) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseClicked
        this.setExtendedState(jembatanHome.ICONIFIED);
    }//GEN-LAST:event_jLabelIconMouseClicked

    private void jTextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jembatanLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jembatanLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jembatanLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jembatanLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jembatanRegis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.ButtonGroup buttonGroupJenisKel;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelReset;
    private javax.swing.JLabel jLabelSignIn;
    private javax.swing.JLabel jLabelSignUp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JRadioButton jRadioButtonPria;
    private javax.swing.JRadioButton jRadioButtonWanita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAlamat;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldTelepon;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
