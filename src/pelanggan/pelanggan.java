/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pelanggan;

import Supplier.Supplier;
import connection.newConnection;
import home.home;
import menu.menu;
import laporan.Laporan;
import inventaris.inventaris;
import karyawan.absenKaryawan;
import login.logout;

import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author CIAGamester
 */
public class pelanggan extends javax.swing.JFrame {

    public Connection conn = new newConnection().connect();
    private DefaultTableModel tabmode;
    
    /**
     * Creates new form pelanggan
     */
    public pelanggan() {
        initComponents();
        dataPelanggan();
        autoNumberMember();
    }

    protected void aktif(){
        idpel.setEnabled(true);
        namapel.setEnabled(true);
        sosmed.setEnabled(true);
        idpel.requestFocus();
    }
    
    protected void kosong(){
        idpel.setText("");
        namapel.setText("");
        sosmed.setText("");
    }
    
    private void dataPelanggan(){
        Object[] Baris = {"ID Pelanggan", "Nama Pelanggan", "Social Media"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelpelanggan.setModel(tabmode);
        String sql = "select * from pelanggan";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("id_pelanggan");
                String b = rs.getString("nama_pelanggan");
                String c = rs.getString("sosmed");
                
                String[] data = {a,b,c};
                tabmode.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
    private void autoNumberMember(){
        String noMenus = "Member000";
        int i = 0;
        try{
            String sql = "SELECT id_pelanggan FROM pelanggan";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                noMenus = rs.getString("id_pelanggan");
            }
            noMenus = noMenus.substring(6);
            i = Integer.parseInt(noMenus) + 1;
            noMenus = "00" + i;
            noMenus = "Member" + noMenus.substring(noMenus.length()-3);
            idpel.setText(noMenus);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Penomoran otomatis gagal! " + e);
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

        jPanel25 = new javax.swing.JPanel();
        userdd = new javax.swing.JPanel();
        userbar4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        homebar = new javax.swing.JLabel();
        stokbar = new javax.swing.JLabel();
        orderbar = new javax.swing.JLabel();
        mejabar = new javax.swing.JLabel();
        laporanbar = new javax.swing.JLabel();
        supplierbar = new javax.swing.JLabel();
        karyawanbar = new javax.swing.JLabel();
        userbar = new javax.swing.JLabel();
        panelRound1 = new PanelRound.PanelRound();
        panelRound2 = new PanelRound.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpelanggan = new jtable_custom.JTable_Custom();
        searchlabel = new javax.swing.JTextField();
        nama12 = new javax.swing.JLabel();
        idpel = new javax.swing.JTextField();
        nama7 = new javax.swing.JLabel();
        nama8 = new javax.swing.JLabel();
        namapel = new javax.swing.JTextField();
        nama9 = new javax.swing.JLabel();
        sosmed = new javax.swing.JTextField();
        inputbtn = new javax.swing.JButton();
        hapusbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        editbtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(1194, 834));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel25.add(userdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, -1, 10));

        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel25.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1246, -1));

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
        jPanel25.add(homebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, -1));

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
        jPanel25.add(stokbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, -1));

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
        jPanel25.add(orderbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, -1));

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
        jPanel25.add(mejabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 100, -1));

        laporanbar.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        laporanbar.setText("Laporan");
        laporanbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanbarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                laporanbarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                laporanbarMouseExited(evt);
            }
        });
        jPanel25.add(laporanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 80, -1));

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
        jPanel25.add(supplierbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 80, -1));

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
        jPanel25.add(karyawanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 100, -1));

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
        jPanel25.add(userbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 70, -1));

        panelRound1.setBackground(new java.awt.Color(206, 194, 182));
        panelRound1.setPreferredSize(new java.awt.Dimension(1141, 594));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(111, 72, 41));
        panelRound2.setPreferredSize(new java.awt.Dimension(1141, 38));
        panelRound2.setRoundTopLeft(25);
        panelRound2.setRoundTopRight(25);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pelanggan");
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/profile_optimized.png"))); // NOI18N
        panelRound2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabelpelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Pelanggan", "Nama Pelanggan", "Social Media"
            }
        ));
        tabelpelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpelangganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpelanggan);

        panelRound1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 710, 520));

        searchlabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchlabel.setForeground(new java.awt.Color(204, 204, 204));
        searchlabel.setText("Masukkan Data Pelanggan");
        searchlabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchlabelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchlabelFocusLost(evt);
            }
        });
        searchlabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchlabelActionPerformed(evt);
            }
        });
        searchlabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchlabelKeyReleased(evt);
            }
        });
        panelRound1.add(searchlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 360, -1));

        nama12.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama12.setForeground(new java.awt.Color(255, 255, 255));
        nama12.setText("Cari Data Pelanggan");
        panelRound1.add(nama12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        idpel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        idpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idpelActionPerformed(evt);
            }
        });
        panelRound1.add(idpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 330, 30));

        nama7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama7.setForeground(new java.awt.Color(255, 255, 255));
        nama7.setText("ID Pelanggan");
        panelRound1.add(nama7, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, -1, -1));

        nama8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama8.setForeground(new java.awt.Color(255, 255, 255));
        nama8.setText("Nama Pelanggan");
        panelRound1.add(nama8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, -1, -1));

        namapel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        namapel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namapelActionPerformed(evt);
            }
        });
        panelRound1.add(namapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 250, 330, 30));

        nama9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama9.setForeground(new java.awt.Color(255, 255, 255));
        nama9.setText("Social Media");
        panelRound1.add(nama9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, -1, -1));

        sosmed.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        sosmed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sosmedActionPerformed(evt);
            }
        });
        panelRound1.add(sosmed, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, 330, 30));

        inputbtn.setBackground(new java.awt.Color(219, 167, 57));
        inputbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        inputbtn.setForeground(new java.awt.Color(255, 255, 255));
        inputbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Insert_Table_optimized.png"))); // NOI18N
        inputbtn.setText("Tambah");
        inputbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputbtnActionPerformed(evt);
            }
        });
        panelRound1.add(inputbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 560, 330, 40));

        hapusbtn.setBackground(new java.awt.Color(111, 72, 41));
        hapusbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        hapusbtn.setForeground(new java.awt.Color(255, 255, 255));
        hapusbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Remove_optimized.png"))); // NOI18N
        hapusbtn.setText("Hapus");
        hapusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtnActionPerformed(evt);
            }
        });
        panelRound1.add(hapusbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 330, 40));

        editbtn.setBackground(new java.awt.Color(111, 72, 41));
        editbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        editbtn.setForeground(new java.awt.Color(255, 255, 255));
        editbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Edit_optimized.png"))); // NOI18N
        editbtn.setText("Ubah");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });
        panelRound1.add(editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 440, 330, 40));

        editbtn1.setBackground(new java.awt.Color(111, 72, 41));
        editbtn1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        editbtn1.setForeground(new java.awt.Color(255, 255, 255));
        editbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Refresh_optimized.png"))); // NOI18N
        editbtn1.setText("Muat Ulang");
        editbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtn1ActionPerformed(evt);
            }
        });
        panelRound1.add(editbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 330, 40));

        jPanel25.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userbar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbar4MouseClicked
        // TODO add your handling code here:
        logout Logout = new logout();
        Logout.setVisible(true);
        Logout.pack();
        Logout.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_userbar4MouseClicked

    private void homebarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homebarMouseClicked
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

    private void laporanbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanbarMouseClicked
        Laporan lap = new Laporan();
        lap.setVisible(true);
        lap.pack();
        lap.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_laporanbarMouseClicked

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

    private void searchlabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusGained
        if(searchlabel.getText().equals("Masukkan Data Pelanggan")){
            searchlabel.setText("");
            searchlabel.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_searchlabelFocusGained

    private void searchlabelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusLost
        if(searchlabel.getText().equals("")){
            searchlabel.setText("Masukkan Data Pelanggan");
            searchlabel.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_searchlabelFocusLost

    private void searchlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchlabelActionPerformed

    private void idpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idpelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idpelActionPerformed

    private void namapelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namapelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namapelActionPerformed

    private void sosmedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sosmedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sosmedActionPerformed

    private void inputbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputbtnActionPerformed
        String sql = "INSERT into pelanggan values (?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, idpel.getText());
            stat.setString(2, namapel.getText());
            stat.setString(3, sosmed.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dimasukkan!");
            kosong();
            idpel.requestFocus();
            dataPelanggan();
            autoNumberMember();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diinput! " + e);
        }
    }//GEN-LAST:event_inputbtnActionPerformed

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "delete", "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok == 0){
            String sql = "delete from pelanggan where id_pelanggan ='"+idpel.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                idpel.requestFocus();
                dataPelanggan();
                autoNumberMember();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Data failed to delete "+ e);
            }
        }
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        int bar = tabelpelanggan.getSelectedRow();
        String idd = (tabelpelanggan.getModel().getValueAt(bar, 0).toString());        
        try {
            String sql = "update pelanggan set nama_pelanggan=?,sosmed=? where id_pelanggan ='"+ idd +"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namapel.getText());
            stat.setString(2, sosmed.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diedit!");
            kosong();
            idpel.requestFocus();
            dataPelanggan();
            autoNumberMember();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data failed to edit!" + e);
        }
    }//GEN-LAST:event_editbtnActionPerformed

    private void tabelpelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpelangganMouseClicked
        int bar = tabelpelanggan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        idpel.setText(a);
        namapel.setText(b);
        sosmed.setText(c);
    }//GEN-LAST:event_tabelpelangganMouseClicked

    private void searchlabelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchlabelKeyReleased
        DefaultTableModel dt = (DefaultTableModel) tabelpelanggan.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(dt);
        tabelpelanggan.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(searchlabel.getText()));
    }//GEN-LAST:event_searchlabelKeyReleased

    private void editbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn1ActionPerformed
        kosong();
        autoNumberMember();
    }//GEN-LAST:event_editbtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editbtn;
    private javax.swing.JButton editbtn1;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JLabel homebar;
    private javax.swing.JTextField idpel;
    private javax.swing.JButton inputbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel karyawanbar;
    private javax.swing.JLabel laporanbar;
    private javax.swing.JLabel mejabar;
    private javax.swing.JLabel nama12;
    private javax.swing.JLabel nama7;
    private javax.swing.JLabel nama8;
    private javax.swing.JLabel nama9;
    private javax.swing.JTextField namapel;
    private javax.swing.JLabel orderbar;
    private PanelRound.PanelRound panelRound1;
    private PanelRound.PanelRound panelRound2;
    private javax.swing.JTextField searchlabel;
    private javax.swing.JTextField sosmed;
    private javax.swing.JLabel stokbar;
    private javax.swing.JLabel supplierbar;
    private jtable_custom.JTable_Custom tabelpelanggan;
    private javax.swing.JLabel userbar;
    private javax.swing.JLabel userbar4;
    private javax.swing.JPanel userdd;
    // End of variables declaration//GEN-END:variables
}
