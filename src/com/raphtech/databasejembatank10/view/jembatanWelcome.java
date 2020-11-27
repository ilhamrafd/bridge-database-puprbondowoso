package com.raphtech.databasejembatank10.view;

import javax.swing.JOptionPane;

public class jembatanWelcome extends javax.swing.JFrame {

    public jembatanWelcome() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_start = new javax.swing.JLabel();
        btn_quit = new javax.swing.JLabel();
        bgwelocme = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/getstarted.png"))); // NOI18N
        btn_start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_startMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_startMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_startMouseExited(evt);
            }
        });
        getContentPane().add(btn_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 310, 80));

        btn_quit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/quit.png"))); // NOI18N
        btn_quit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_quitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_quitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_quitMouseExited(evt);
            }
        });
        getContentPane().add(btn_quit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 550, 130, 80));

        bgwelocme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background/welcome.png"))); // NOI18N
        bgwelocme.setMaximumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().add(bgwelocme, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        setSize(new java.awt.Dimension(900, 768));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_quitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitMouseClicked
        if (JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar?", "Warning!", 2) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_quitMouseClicked

    private void btn_startMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_startMouseClicked
        dispose();
        jembatanLogin Login = new jembatanLogin();
        Login.setVisible(true);
    }//GEN-LAST:event_btn_startMouseClicked

    private void btn_startMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_startMouseEntered
        btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/getstartedhover.png")));
    }//GEN-LAST:event_btn_startMouseEntered

    private void btn_startMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_startMouseExited
        btn_start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/getstarted.png")));
    }//GEN-LAST:event_btn_startMouseExited

    private void btn_quitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitMouseEntered
        btn_quit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/quithover.png")));
    }//GEN-LAST:event_btn_quitMouseEntered

    private void btn_quitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_quitMouseExited
        btn_quit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/quit.png")));
    }//GEN-LAST:event_btn_quitMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

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
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jembatanWelcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgwelocme;
    private javax.swing.JLabel btn_quit;
    private javax.swing.JLabel btn_start;
    // End of variables declaration//GEN-END:variables
}
