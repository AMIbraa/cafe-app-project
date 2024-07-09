/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inventaris;

import Supplier.Supplier;
import connection.newConnection;
import home.home;
import karyawan.absenKaryawan;
import login.logout;
import pelanggan.pelanggan;
import menu.menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import javax.swing.table.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import laporan.Laporan;

/**
 *
 * @author lookitautowork
 */
public class inventaris extends javax.swing.JFrame {

    public Connection conn = new newConnection().connect();
    private DefaultTableModel tabmode;
    private String path2;
    
    public inventaris() {
        initComponents();
        datatable();
//        autoNumberMenu();
        autoNumberKodeMenu();
        setTableRenderer();
    }
//    
//    private void autoNumberMenu(){
//        String noMenu = "00";
//        int i = 0;
//        try{
//            String sql = "SELECT no FROM tambahmenu";
//            PreparedStatement stat = conn.prepareStatement(sql);
//            ResultSet rs = stat.executeQuery();
//            while(rs.next()){
//                noMenu = rs.getString("no");
//            }
//            i = Integer.parseInt(noMenu) + 1;
//            noMenu = "0" + i;
//            no.setText(noMenu);
//        } catch(SQLException e) {
//            JOptionPane.showMessageDialog(null, "Penomoran otomatis gagal! " + e);
//        }
//    }
    
    private void autoNumberKodeMenu(){
        String noMenus = "MENU000";
        int i = 0;
        try{
            String sql = "SELECT kode_menu FROM tambahmenu";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                noMenus = rs.getString("kode_menu");
            }
            noMenus = noMenus.substring(4);
            i = Integer.parseInt(noMenus) + 1;
            noMenus = "00" + i;
            noMenus = "MENU" + noMenus.substring(noMenus.length()-3);
            kode_menu.setText(noMenus);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Penomoran otomatis gagal! " + e);
        }
    }

    protected void aktif(){
        gambar.setEnabled(true);
        kode_menu.setEnabled(true);
        kategori.setEnabled(true);
        nama_menu.setEnabled(true);
        harga_pokok.setEnabled(true);
        harga_jual.setEnabled(true);
        stok.setEnabled(true);
        stokmin.setEnabled(true);
        kode_menu.requestFocus();
    }
    
    private void kosong(){
        gambar.setText("");
        kode_menu.setText("");
        kategori.setSelectedIndex(0);
        nama_menu.setText("");
        harga_pokok.setText("");
        harga_jual.setText("");
        stok.setText("");
        stokmin.setText("");
    }
    
    private void datatable(){
        Object[] Baris = {"Kode Menu", "Gambar", "Kategori", "Nama Menu", "Harga Pokok", "Harga Jual", "Stok", "Stok Min."};
        tabmode = new DefaultTableModel(null, Baris);
        tabelsup.setModel(tabmode);        
        tabelsup.setRowHeight(100);
        String sql = "select * from tambahmenu";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                byte[] imageData = rs.getBytes("gambar");
                ImageIcon im = new ImageIcon(imageData);
                String a = rs.getString("kode_menu");
                String c = rs.getString("kategori");
                String d = rs.getString("nama_menu");
                String e = rs.getString("harga_pokok");
                String f = rs.getString("harga_jual");
                String g = rs.getString("stok");
                String h = rs.getString("stokmin");
                
                Object[] data = {a,im,c,d,e,f,g,h};
                tabmode.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
    private void setTableRenderer(){
        class customRenderer extends DefaultTableCellRenderer{

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof ImageIcon){
                    ImageIcon icon = (ImageIcon) value;
                    Image originalImage = icon.getImage();
                    
                    int desireWidth = 180;
                    int desireHeight = 180;
                    
                    Image resizedImage = originalImage.getScaledInstance(desireWidth, desireHeight, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(resizedImage);
                    
                    JLabel label = new JLabel(resizedIcon);
                    label.setHorizontalAlignment(JLabel.CENTER);
                    
                    return label;
                }
                return getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        }
        tabelsup.getColumnModel().getColumn(1).setCellRenderer(new customRenderer());
    }
    
    class ImageRender extends DefaultTableCellRenderer{

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if(value instanceof ImageIcon){
                    ImageIcon icon = (ImageIcon) value;
                    JLabel label = new JLabel(icon);
                    label.setHorizontalAlignment(JLabel.CENTER);
                    return label;
                }
                return getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        userdd = new javax.swing.JPanel();
        userbar2 = new javax.swing.JLabel();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        searchlabel = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelsup = new jtable_custom.JTable_Custom();
        panelRound3 = new PanelRound.PanelRound();
        kategori = new javax.swing.JComboBox<>();
        panelRound4 = new PanelRound.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        nama_menu = new javax.swing.JTextField();
        gambar = new javax.swing.JTextField();
        kode_menu = new javax.swing.JTextField();
        nama5 = new javax.swing.JLabel();
        nama6 = new javax.swing.JLabel();
        nama7 = new javax.swing.JLabel();
        pilih = new javax.swing.JButton();
        harga_pokok = new javax.swing.JTextField();
        nama8 = new javax.swing.JLabel();
        harga_jual = new javax.swing.JTextField();
        nama9 = new javax.swing.JLabel();
        stok = new javax.swing.JTextField();
        nama10 = new javax.swing.JLabel();
        stokmin = new javax.swing.JTextField();
        nama11 = new javax.swing.JLabel();
        inputbtn = new javax.swing.JButton();
        nama12 = new javax.swing.JLabel();
        hapusbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        editbtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1433, 1473));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(1433, 1473));

        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 15));

        userdd.setBackground(new java.awt.Color(255, 255, 255));
        userdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userbar2.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        userbar2.setText("Logout");
        userbar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userbar2MouseClicked(evt);
            }
        });
        userdd.add(userbar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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

        panelRound1.setBackground(new java.awt.Color(206, 194, 182));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        panelRound2.setBackground(new java.awt.Color(111, 72, 41));
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data Menu");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        searchlabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchlabel.setForeground(new java.awt.Color(204, 204, 204));
        searchlabel.setText("Cari Menu");
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

        tabelsup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Menu", "Gambar", "Kategori", "Nama Menu", "Harga Pokok", "Harga Jual", "Stok", "Stok Min."
            }
        ));
        tabelsup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelsupMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelsup);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(206, 194, 182));
        panelRound3.setPreferredSize(new java.awt.Dimension(1140, 700));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kategori.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minuman", "Makanan", "Snack" }));
        panelRound3.add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 450, -1));

        panelRound4.setBackground(new java.awt.Color(111, 72, 41));
        panelRound4.setPreferredSize(new java.awt.Dimension(1140, 38));
        panelRound4.setRoundTopLeft(30);
        panelRound4.setRoundTopRight(30);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tambah Menu");
        panelRound4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 5, -1, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Insert_Table_optimized.png"))); // NOI18N
        panelRound4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 40));

        panelRound3.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, -1));

        nama_menu.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_menuActionPerformed(evt);
            }
        });
        panelRound3.add(nama_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 450, 30));

        gambar.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        gambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gambarActionPerformed(evt);
            }
        });
        panelRound3.add(gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 290, 30));

        kode_menu.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        kode_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_menuActionPerformed(evt);
            }
        });
        panelRound3.add(kode_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 450, 30));

        nama5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama5.setForeground(new java.awt.Color(255, 255, 255));
        nama5.setText("Kode Menu");
        panelRound3.add(nama5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        nama6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama6.setForeground(new java.awt.Color(255, 255, 255));
        nama6.setText("Kategori");
        panelRound3.add(nama6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        nama7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama7.setForeground(new java.awt.Color(255, 255, 255));
        nama7.setText("Nama Menu");
        panelRound3.add(nama7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        pilih.setBackground(new java.awt.Color(219, 167, 57));
        pilih.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        pilih.setForeground(new java.awt.Color(255, 255, 255));
        pilih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/report_optimized.png"))); // NOI18N
        pilih.setText("Pilih Gambar");
        pilih.setMargin(new java.awt.Insets(2, 6, 3, 6));
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });
        panelRound3.add(pilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 140, 30));

        harga_pokok.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        harga_pokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_pokokActionPerformed(evt);
            }
        });
        panelRound3.add(harga_pokok, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 450, 30));

        nama8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama8.setForeground(new java.awt.Color(255, 255, 255));
        nama8.setText("Harga Pokok");
        panelRound3.add(nama8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, -1, -1));

        harga_jual.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        harga_jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harga_jualActionPerformed(evt);
            }
        });
        panelRound3.add(harga_jual, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 450, 30));

        nama9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama9.setForeground(new java.awt.Color(255, 255, 255));
        nama9.setText("Harga Jual");
        panelRound3.add(nama9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, -1, -1));

        stok.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokActionPerformed(evt);
            }
        });
        panelRound3.add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 450, 30));

        nama10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama10.setForeground(new java.awt.Color(255, 255, 255));
        nama10.setText("Stok");
        panelRound3.add(nama10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

        stokmin.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        stokmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokminActionPerformed(evt);
            }
        });
        panelRound3.add(stokmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 450, 30));

        nama11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama11.setForeground(new java.awt.Color(255, 255, 255));
        nama11.setText("Stok Minimal");
        panelRound3.add(nama11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, -1, -1));

        inputbtn.setBackground(new java.awt.Color(219, 167, 57));
        inputbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        inputbtn.setForeground(new java.awt.Color(255, 255, 255));
        inputbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Add_optimized.png"))); // NOI18N
        inputbtn.setText("Tambah");
        inputbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputbtnActionPerformed(evt);
            }
        });
        panelRound3.add(inputbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 280, 40));

        nama12.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama12.setForeground(new java.awt.Color(255, 255, 255));
        nama12.setText("Gambar");
        panelRound3.add(nama12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

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
        panelRound3.add(hapusbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, 210, 40));

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
        panelRound3.add(editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 210, 40));

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
        panelRound3.add(editbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 140, 40));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(homebar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(stokbar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(orderbar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(mejabar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(laporanbar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(supplierbar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(karyawanbar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(482, 482, 482)
                        .addComponent(userbar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(1110, 1110, 1110)
                        .addComponent(userdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homebar)
                    .addComponent(stokbar)
                    .addComponent(orderbar)
                    .addComponent(mejabar)
                    .addComponent(laporanbar)
                    .addComponent(supplierbar)
                    .addComponent(karyawanbar)
                    .addComponent(userbar))
                .addGap(5, 5, 5)
                .addComponent(userdd, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1361, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1317, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userbar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbar2MouseClicked
        // TODO add your handling code here:
        logout Logout = new logout();
        Logout.setVisible(true);
        Logout.pack();
        Logout.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_userbar2MouseClicked

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
        inventaris stoks = new inventaris();
        stoks.setVisible(true);
        stoks.pack();
        stoks.setLocationRelativeTo(null);
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

    private void searchlabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusGained
        if(searchlabel.getText().equals("Cari Menu")){
            searchlabel.setText("");
            searchlabel.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_searchlabelFocusGained

    private void searchlabelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusLost
        if(searchlabel.getText().equals("")){
            searchlabel.setText("Cari Menu");
            searchlabel.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_searchlabelFocusLost

    private void searchlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchlabelActionPerformed

    private void nama_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_menuActionPerformed

    private void gambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gambarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gambarActionPerformed

    private void kode_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_menuActionPerformed

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String path = f.getAbsolutePath();
        try {
            BufferedImage bi = ImageIO.read(new File(path));
            gambar.setText(path);
            path2 = path;
//            Image img = bi.getScaledInstance(134, 172, Image.SCALE_SMOOTH);
//            ImageIcon icon = new ImageIcon(img);
//            labelgambar.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(inventaris.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pilihActionPerformed

    private void harga_pokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_pokokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_pokokActionPerformed

    private void harga_jualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harga_jualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harga_jualActionPerformed

    private void stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokActionPerformed

    private void stokminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokminActionPerformed

    private void inputbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputbtnActionPerformed
        String sql = "INSERT into tambahmenu values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            InputStream is = new FileInputStream(new File(path2));
            stat.setBlob(1, is);
            stat.setString(2, kode_menu.getText());
            stat.setString(3, kategori.getSelectedItem().toString());
            stat.setString(4, nama_menu.getText());
            stat.setString(5, harga_pokok.getText());
            stat.setString(6, harga_jual.getText());
            stat.setString(7, stok.getText());
            stat.setString(8, stokmin.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data saved successfully!");
//            autoNumberMenu();
            autoNumberKodeMenu();
            kosong();
            kode_menu.requestFocus();
            datatable();
            autoNumberKodeMenu();
            setTableRenderer();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal diinput! " + e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(inventaris.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inputbtnActionPerformed

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "delete", "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok == 0){
            String sql = "delete from tambahmenu where kode_menu ='"+kode_menu.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                kode_menu.requestFocus();
                datatable();
                setTableRenderer();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Data failed to delete "+ e);
            }
        }
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        int bar =tabelsup.getSelectedRow();
        String klik = (tabelsup.getModel().getValueAt(bar, 0).toString());
        try {
            String sql = "update tambahmenu set kategori=?,nama_menu=?,harga_pokok=?,harga_jual=?,stok=?,stokmin=? where kode_menu ='"+klik+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kategori.getSelectedItem().toString());
            stat.setString(2, nama_menu.getText());
            stat.setString(3, harga_pokok.getText());
            stat.setString(4, harga_jual.getText());
            stat.setString(5, stok.getText());
            stat.setString(6, stokmin.getText());
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diedit!");
            kosong();
            kode_menu.requestFocus();
            autoNumberKodeMenu();
            datatable();
            setTableRenderer();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data failed to edit!" + e);
        }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(inventaris.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_editbtnActionPerformed

    private void tabelsupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelsupMouseClicked
        int bar = tabelsup.getSelectedRow();
//        String click =  (tabelsup.getModel().getValueAt(bar, 0).toString());
//        String sql = "select * from tambahmenu where kode_menu='" + click +"'";
//        try{
//            PreparedStatement stat = conn.prepareStatement(sql);
//            ResultSet rs = stat.executeQuery();
//            if(rs.next()){
////                String a = rs.getString(0);
//                Blob b = rs.getBlob(1);
//                String path = "C:\\Users\\CIAGamester\\Desktop\\cafe-app-project\\src\\img\\kopi\\img.jpg";
//                byte[] bytea = b.getBytes(1, (int)b.length());
//                FileOutputStream fos = new FileOutputStream(path);
//                fos.write(bytea);
//                ImageIcon icon = new ImageIcon(bytea);
//                
//                
//                
//                String c = rs.getString(2);
//                String d = rs.getString(3);
//                String e = rs.getString(4);
//                String f = rs.getString(5);
//                String g = rs.getString(6);
//                String h = rs.getString(7);
//                
//                nama12.setIcon(icon);
////                kode_menu.setText(a);
//                kategori.setSelectedItem(c);
//                nama_menu.setText(d);
//                harga_pokok.setText(e);
//                harga_jual.setText(f);
//                stok.setText(g);
//                stokmin.setText(h);
//            }
//        }catch(SQLException e){
//            JOptionPane.showMessageDialog(null, "" + e);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(inventaris.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(inventaris.class.getName()).log(Level.SEVERE, null, ex);
//        }
        String a = tabmode.getValueAt(bar, 0).toString();
//        String b = tabmode.getValueAt(bar, 1).toString();

//        ImageIcon image = (ImageIcon) tabmode.getValueAt(bar, 1);
        
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        String h = tabmode.getValueAt(bar, 7).toString();
        
//        gambar.setText(b);
        kode_menu.setText(a);
        kategori.setSelectedItem(c);
        nama_menu.setText(d);
        harga_pokok.setText(e);
        harga_jual.setText(f);
        stok.setText(g);
        stokmin.setText(h);
    }//GEN-LAST:event_tabelsupMouseClicked

    private void laporanbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanbarMouseClicked
        Laporan lap = new Laporan();
        lap.setVisible(true);
        lap.pack();
        lap.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_laporanbarMouseClicked

    private void searchlabelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchlabelKeyReleased
        DefaultTableModel dt = (DefaultTableModel) tabelsup.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(dt);
        tabelsup.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(searchlabel.getText()));
    }//GEN-LAST:event_searchlabelKeyReleased

    private void editbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn1ActionPerformed
        kosong();
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
            java.util.logging.Logger.getLogger(inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventaris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editbtn;
    private javax.swing.JButton editbtn1;
    private javax.swing.JTextField gambar;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JTextField harga_jual;
    private javax.swing.JTextField harga_pokok;
    private javax.swing.JLabel homebar;
    private javax.swing.JButton inputbtn;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel karyawanbar;
    private javax.swing.JComboBox<String> kategori;
    private javax.swing.JTextField kode_menu;
    private javax.swing.JLabel laporanbar;
    private javax.swing.JLabel mejabar;
    private javax.swing.JLabel nama10;
    private javax.swing.JLabel nama11;
    private javax.swing.JLabel nama12;
    private javax.swing.JLabel nama5;
    private javax.swing.JLabel nama6;
    private javax.swing.JLabel nama7;
    private javax.swing.JLabel nama8;
    private javax.swing.JLabel nama9;
    private javax.swing.JTextField nama_menu;
    private javax.swing.JLabel orderbar;
    private PanelRound.PanelRound panelRound1;
    private PanelRound.PanelRound panelRound2;
    private PanelRound.PanelRound panelRound3;
    private PanelRound.PanelRound panelRound4;
    private javax.swing.JButton pilih;
    private javax.swing.JTextField searchlabel;
    private javax.swing.JTextField stok;
    private javax.swing.JLabel stokbar;
    private javax.swing.JTextField stokmin;
    private javax.swing.JLabel supplierbar;
    private jtable_custom.JTable_Custom tabelsup;
    private javax.swing.JLabel userbar;
    private javax.swing.JLabel userbar2;
    private javax.swing.JPanel userdd;
    // End of variables declaration//GEN-END:variables
}
