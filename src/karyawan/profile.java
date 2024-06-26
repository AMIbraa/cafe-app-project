/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package karyawan;

//import com.mysql.cj.jdbc.Blob;
import Supplier.Supplier;
import home.home;
import pelanggan.pelanggan;
import menu.menu;
import java.sql.PreparedStatement;
import connection.newConnection;
import inventaris.inventaris;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import login.logout;

/**
 *
 * @author CIAGamester
 */
public class profile extends javax.swing.JFrame {
    private String selectedImagePath;
    
    private ResultSet rs;
//    private PreparedStatement stat;

    public Connection conn = new newConnection().connect();
    
    /**
     * Creates new form profile
     */
    public profile(){
        initComponents();
    }
    
    protected void kosong(){
        pwlama.setText("");
        pwbaru.setText("");
    }
    
    private void tampilData(){
        try {
            emailAdd2.setText(rs.getString(1));
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data! " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        userdd = new javax.swing.JPanel();
        userbar4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        panelRound3 = new PanelRound.PanelRound();
        ubahpwbtn = new javax.swing.JButton();
        panelRound4 = new PanelRound.PanelRound();
        jLabel19 = new javax.swing.JLabel();
        emailAdd2 = new javax.swing.JTextField();
        nama = new javax.swing.JLabel();
        nama1 = new javax.swing.JLabel();
        nama8 = new javax.swing.JLabel();
        pwlama = new javax.swing.JPasswordField();
        pwbaru = new javax.swing.JPasswordField();
        pwbaru1 = new javax.swing.JPasswordField();
        nama9 = new javax.swing.JLabel();
        homebar = new javax.swing.JLabel();
        stokbar = new javax.swing.JLabel();
        orderbar = new javax.swing.JLabel();
        mejabar = new javax.swing.JLabel();
        laporanbar = new javax.swing.JLabel();
        supplierbar = new javax.swing.JLabel();
        karyawanbar = new javax.swing.JLabel();
        userbar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(1194, 76));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userdd.setBackground(new java.awt.Color(255, 255, 255));
        userdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userbar4.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        userbar4.setText("Logout");
        userbar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userbar4MouseClicked(evt);
            }
        });
        userdd.add(userbar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel3.add(userdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, -1, 10));

        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1200, 20));

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Project Cafe ©2024  -  by Group 1 ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 800, -1, -1));

        panelRound3.setBackground(new java.awt.Color(206, 194, 182));
        panelRound3.setDoubleBuffered(false);
        panelRound3.setPreferredSize(new java.awt.Dimension(246, 226));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ubahpwbtn.setBackground(new java.awt.Color(219, 167, 57));
        ubahpwbtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        ubahpwbtn.setForeground(new java.awt.Color(255, 255, 255));
        ubahpwbtn.setText("Ubah Password");
        ubahpwbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahpwbtnActionPerformed(evt);
            }
        });
        panelRound3.add(ubahpwbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 1030, 34));

        panelRound4.setBackground(new java.awt.Color(111, 72, 41));
        panelRound4.setName(""); // NOI18N
        panelRound4.setPreferredSize(new java.awt.Dimension(246, 38));
        panelRound4.setRoundTopLeft(30);
        panelRound4.setRoundTopRight(30);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ganti Password");
        panelRound4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        panelRound3.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, -1));

        emailAdd2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        panelRound3.add(emailAdd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 500, 30));

        nama.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setText("Email");
        panelRound3.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        nama1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama1.setForeground(new java.awt.Color(255, 255, 255));
        nama1.setText("Password Lama");
        panelRound3.add(nama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        nama8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama8.setForeground(new java.awt.Color(255, 255, 255));
        nama8.setText("Password Baru");
        panelRound3.add(nama8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));
        panelRound3.add(pwlama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 500, 30));
        panelRound3.add(pwbaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 500, 30));
        panelRound3.add(pwbaru1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, 500, 30));

        nama9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama9.setForeground(new java.awt.Color(255, 255, 255));
        nama9.setText("Konfirmasi Password Baru");
        panelRound3.add(nama9, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        jPanel3.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 1090, 280));

        homebar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        homebar.setText("Home");
        homebar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homebarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homebarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homebarMouseExited(evt);
            }
        });
        jPanel3.add(homebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, -1));

        stokbar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        stokbar.setText("Stok");
        stokbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stokbarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stokbarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stokbarMouseExited(evt);
            }
        });
        jPanel3.add(stokbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, -1));

        orderbar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        orderbar.setText("Order");
        orderbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderbarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                orderbarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                orderbarMouseExited(evt);
            }
        });
        jPanel3.add(orderbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, -1));

        mejabar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        mejabar.setText("Pelanggan");
        mejabar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mejabarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mejabarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mejabarMouseExited(evt);
            }
        });
        jPanel3.add(mejabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 100, -1));

        laporanbar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        laporanbar.setText("Laporan");
        laporanbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laporanbarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laporanbarMouseExited(evt);
            }
        });
        jPanel3.add(laporanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 80, -1));

        supplierbar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        supplierbar.setText("Supplier");
        supplierbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierbarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplierbarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                supplierbarMouseExited(evt);
            }
        });
        jPanel3.add(supplierbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 80, -1));

        karyawanbar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        karyawanbar.setText("Karyawan");
        karyawanbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                karyawanbarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                karyawanbarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                karyawanbarMouseExited(evt);
            }
        });
        jPanel3.add(karyawanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 100, -1));

        userbar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        userbar.setText("Owner");
        userbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userbarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userbarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userbarMouseExited(evt);
            }
        });
        jPanel3.add(userbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ubahpwbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahpwbtnActionPerformed
        String sql = "SELECT * FROM userlog WHERE email = '" + emailAdd2.getText() + "'" + "and password = '" + pwlama.getText() + "'";
        String sql1 = "UPDATE userlog SET password = '" + pwbaru.getText() + "' WHERE email = '" + emailAdd2.getText() + "'";
                
        try {
            java.sql.Statement stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(rs.getString("password").equals(pwlama.getText())){
                    pwlama.setText("");
                    emailAdd2.setText(emailAdd2.getText());
                    if(pwbaru.getText().equals(pwbaru1.getText())){
                        pwbaru.setText("");
                        pwbaru1.setText("");
                        stat.executeUpdate(sql1);
                        JOptionPane.showMessageDialog(null, "Password Berhasil Diubah!");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Password baru tidak sesuai!", "Error", JOptionPane.ERROR_MESSAGE);
                        pwbaru1.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Password lama salah!", "Error", JOptionPane.ERROR_MESSAGE);
                    pwlama.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Email salah!", "Error", JOptionPane.ERROR_MESSAGE);
                emailAdd2.requestFocus();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Password gagal diubah! " + e);
        }
    }//GEN-LAST:event_ubahpwbtnActionPerformed

    private void userbar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbar4MouseClicked
        // TODO add your handling code here:
        logout Logout = new logout();
        Logout.setVisible(true);
        Logout.pack();
        Logout.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_userbar4MouseClicked

    private void homebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebarMouseClicked
        // TODO add your handling code here:
        home Home = new home();
        Home.setVisible(true);
        Home.pack();
        Home.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_homebarMouseClicked

    private void homebarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebarMouseEntered
        homebar.setForeground(new Color(206,194,182));
    }//GEN-LAST:event_homebarMouseEntered

    private void homebarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebarMouseExited
        homebar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_homebarMouseExited

    private void stokbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stokbarMouseClicked
        inventaris stok = new inventaris();
        stok.setVisible(true);
        stok.pack();
        stok.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_stokbarMouseClicked

    private void stokbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stokbarMouseEntered
        stokbar.setForeground(new Color(206,194,182));
    }//GEN-LAST:event_stokbarMouseEntered

    private void stokbarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stokbarMouseExited
        stokbar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_stokbarMouseExited

    private void orderbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderbarMouseClicked
        menu or = new menu();
        or.setVisible(true);
        or.pack();
        or.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_orderbarMouseClicked

    private void orderbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderbarMouseEntered
        orderbar.setForeground(new Color(206,194,182));
    }//GEN-LAST:event_orderbarMouseEntered

    private void orderbarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderbarMouseExited
        orderbar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_orderbarMouseExited

    private void mejabarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mejabarMouseClicked
        pelanggan Meja = new pelanggan();
        Meja.setVisible(true);
        Meja.pack();
        Meja.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_mejabarMouseClicked

    private void mejabarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mejabarMouseEntered
        mejabar.setForeground(new Color(206,194,182));
    }//GEN-LAST:event_mejabarMouseEntered

    private void mejabarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mejabarMouseExited
        mejabar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_mejabarMouseExited

    private void laporanbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanbarMouseEntered
        laporanbar.setForeground(new Color(206,194,182));
    }//GEN-LAST:event_laporanbarMouseEntered

    private void laporanbarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanbarMouseExited
        laporanbar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_laporanbarMouseExited

    private void supplierbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierbarMouseClicked
        Supplier sup = new Supplier();
        sup.setVisible(true);
        sup.pack();
        sup.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_supplierbarMouseClicked

    private void supplierbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierbarMouseEntered
        supplierbar.setForeground(new Color(206,194,182));
    }//GEN-LAST:event_supplierbarMouseEntered

    private void supplierbarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierbarMouseExited
        supplierbar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_supplierbarMouseExited

    private void karyawanbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_karyawanbarMouseClicked
        absenKaryawan Kar = new absenKaryawan();
        Kar.setVisible(true);
        Kar.pack();
        Kar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_karyawanbarMouseClicked

    private void karyawanbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_karyawanbarMouseEntered
        karyawanbar.setForeground(new Color(206,194,182));
    }//GEN-LAST:event_karyawanbarMouseEntered

    private void karyawanbarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_karyawanbarMouseExited
        karyawanbar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_karyawanbarMouseExited

    private void userbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbarMouseClicked
        userdd.setSize(76, 40);
    }//GEN-LAST:event_userbarMouseClicked

    private void userbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbarMouseEntered
        userbar.setForeground(new Color(206,194,182));
    }//GEN-LAST:event_userbarMouseEntered

    private void userbarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbarMouseExited
        userbar.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_userbarMouseExited

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
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailAdd2;
    private javax.swing.JLabel homebar;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel karyawanbar;
    private javax.swing.JLabel laporanbar;
    private javax.swing.JLabel mejabar;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel nama1;
    private javax.swing.JLabel nama8;
    private javax.swing.JLabel nama9;
    private javax.swing.JLabel orderbar;
    private PanelRound.PanelRound panelRound3;
    private PanelRound.PanelRound panelRound4;
    private javax.swing.JPasswordField pwbaru;
    private javax.swing.JPasswordField pwbaru1;
    private javax.swing.JPasswordField pwlama;
    private javax.swing.JLabel stokbar;
    private javax.swing.JLabel supplierbar;
    private javax.swing.JButton ubahpwbtn;
    private javax.swing.JLabel userbar;
    private javax.swing.JLabel userbar4;
    private javax.swing.JPanel userdd;
    // End of variables declaration//GEN-END:variables
}
