package com.raphtech.databasejembatank10.view;

import com.raphtech.databasejembatank10.user.Login;
import com.raphtech.databasejembatank10.user.Session;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class jembatanLogin extends javax.swing.JFrame {

    private String message;
    Login login = new Login();

    public jembatanLogin() {
        initComponents();
    }

    public void reset() {
        jTextFieldUsername.setText("");
        jPasswordField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelClose = new javax.swing.JLabel();
        jLabelIcon = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabelSignIn = new javax.swing.JLabel();
        jLabelSignUp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png"))); // NOI18N
        jLabelIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIconMouseExited(evt);
            }
        });
        getContentPane().add(jLabelIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jTextFieldUsername.setBackground(new java.awt.Color(244, 153, 20));
        jTextFieldUsername.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jTextFieldUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsername.setBorder(null);
        jTextFieldUsername.setOpaque(false);
        getContentPane().add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 190, 30));

        jPasswordField.setBackground(new java.awt.Color(244, 153, 20));
        jPasswordField.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPasswordField.setBorder(null);
        jPasswordField.setOpaque(false);
        getContentPane().add(jPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 190, 30));

        jPanel1.setLayout(null);

        jLabelSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsignin.png"))); // NOI18N
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
        jPanel1.add(jLabelSignIn);
        jLabelSignIn.setBounds(180, 430, 104, 31);

        jLabelSignUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsignup.png"))); // NOI18N
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
        jPanel1.add(jLabelSignUp);
        jLabelSignUp.setBounds(160, 580, 160, 32);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/login.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 460, 770);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 770));

        setSize(new java.awt.Dimension(458, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jLabelIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseEntered
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize-hover.png")));
    }//GEN-LAST:event_jLabelIconMouseEntered

    private void jLabelIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseExited
        jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize.png")));
    }//GEN-LAST:event_jLabelIconMouseExited

    private void jLabelSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignInMouseClicked
        try {
            login.setUser(jTextFieldUsername.getText());
            login.setPassword(jPasswordField.getText());
            message = login.cekLogin(login.getUser(), login.getPassword());

            if (Session.getStatusLogin() == "Activated") {
                dispose();
                jembatanHome Home = new jembatanHome();
                Home.setVisible(true);
            } else {
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Login failed, '" + e + "'", "Warning!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabelSignInMouseClicked

    private void jLabelSignInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignInMouseEntered
        jLabelSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsigninhover.png")));
    }//GEN-LAST:event_jLabelSignInMouseEntered

    private void jLabelSignInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignInMouseExited
        jLabelSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsignin.png")));
    }//GEN-LAST:event_jLabelSignInMouseExited

    private void jLabelSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignUpMouseClicked
        dispose();
        jembatanRegis Regis = new jembatanRegis();
        Regis.setVisible(true);
    }//GEN-LAST:event_jLabelSignUpMouseClicked

    private void jLabelSignUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignUpMouseEntered
        jLabelSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsignuphover.png")));
    }//GEN-LAST:event_jLabelSignUpMouseEntered

    private void jLabelSignUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignUpMouseExited
        jLabelSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/inputsignup.png")));
    }//GEN-LAST:event_jLabelSignUpMouseExited

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
                new jembatanLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelSignIn;
    private javax.swing.JLabel jLabelSignUp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
