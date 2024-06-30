/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laporan;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

import login.logout;
import pelanggan.pelanggan;
import menu.menu;
import home.home;
import Supplier.Supplier;
import connection.newConnection;
import inventaris.inventaris;
import java.awt.Color;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import karyawan.absenKaryawan;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author CIAGamester
 */
public class Laporan extends javax.swing.JFrame {

    
    public Connection conn = new newConnection().connect();
    private DefaultTableModel tabmode1;
    private DefaultTableModel tabmode2;
    private DefaultTableModel tabmode3;
    
    /**
     * Creates new form Laporan
     */
    public Laporan() {
        initComponents();
        tabelkaryawan();
        tabelpenjualan();
        tabelsupplier();
    }
    
    private void tabelkaryawan(){
        Object[] Baris = { "ID Karyawan", "Nama Karyawan", "Shift", "Tanggal"};
        tabmode1 = new DefaultTableModel(null, Baris);
        tabelkar.setModel(tabmode1);
        String sql = "select * from absen_karyawan where tanggal_absen BETWEEN '"+ tanggalabsenk1.getText() +"' AND '"+ tanggalabsenk2.getText() +"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("id_karyawan");
                String b = rs.getString("fullname");
                String c = rs.getString("shift");
                String d = rs.getString("tanggal_absen");

                String[] data = {a,b,c,d};
                tabmode1.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
     private void tabelpenjualan(){
        Object[] Baris = {"Tanggal Transaksi", "Pelanggan", "Status", "Kode Menu", "Nama Menu", "Jumlah", "Total Harga"};
        tabmode2 = new DefaultTableModel(null, Baris);
        tabelpen.setModel(tabmode2);
        String sql = "select keranjang.pelanggan, "
                + "penjualan.tanggal_transaksi, keranjang.kode_menu, "
                + "keranjang.jumlah, keranjang.nama_menu, "
                + "keranjang.total_harga, penjualan.status_member "
                + "from keranjang inner join penjualan on keranjang.no_faktur = penjualan.no_faktur "
                + "and keranjang.pelanggan = penjualan.pelanggan "
                + "inner join pembayaran on penjualan.no_faktur = pembayaran.no_faktur "
                + "and penjualan.tanggal_transaksi = pembayaran.tanggal_transaksi "
                + "where penjualan.tanggal_transaksi BETWEEN '"+ tanggalabsenp1.getText() +"' AND '"+ tanggalabsenp2.getText() +"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("tanggal_transaksi");
                String b = rs.getString("pelanggan");
                String c = rs.getString("status_member");
                String d = rs.getString("kode_menu");
                String e = rs.getString("nama_menu");
                String f = rs.getString("jumlah");
                String g = rs.getString("total_harga");
                
                Object[] data = {a,b,c,d,e,f,g};
                tabmode2.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
     
     private void tabelsupplier(){
        Object[] Baris = { "ID Supplier", "Supplier", "Kode Menu", "Nama Menu", "Jumlah", "Harga", "Tanggal"};
        tabmode3 = new DefaultTableModel(null, Baris);
        tabelsup.setModel(tabmode3);
        String sql = "select * from supplier where tanggal BETWEEN '"+ tanggalabsens1.getText() +"' AND '"+ tanggalabsens2.getText() +"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("id_supplier");
                String b = rs.getString("supplier");
                String c = rs.getString("kode_menu");
                String d = rs.getString("nama_menu");
                String e = rs.getString("jumlah");
                String f = rs.getString("harga_beli");
                String g = rs.getString("tanggal");

                String[] data = {a,b,c,d,e,f,g};
                tabmode3.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
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

        dateChooserk1 = new com.raven.datechooser.DateChooser();
        dateChoosers1 = new com.raven.datechooser.DateChooser();
        dateChooserp1 = new com.raven.datechooser.DateChooser();
        dateChoosers2 = new com.raven.datechooser.DateChooser();
        dateChooserk2 = new com.raven.datechooser.DateChooser();
        dateChooserp2 = new com.raven.datechooser.DateChooser();
        jPanel24 = new javax.swing.JPanel();
        userdd1 = new javax.swing.JPanel();
        userbar3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        userbar1 = new javax.swing.JLabel();
        Tab = new raven.tabbed.TabbedPaneCustom();
        panelRound10 = new PanelRound.PanelRound();
        jLabel15 = new javax.swing.JLabel();
        caribtn = new javax.swing.JButton();
        panelRound3 = new PanelRound.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        searchlabelp = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tanggalabsenp1 = new javax.swing.JTextField();
        datebtnp1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelpen = new jtable_custom.JTable_Custom();
        cetaklpbtn = new javax.swing.JButton();
        tanggalabsenp2 = new javax.swing.JTextField();
        datebtnp2 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        panelRound11 = new PanelRound.PanelRound();
        jLabel22 = new javax.swing.JLabel();
        panelRound4 = new PanelRound.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        searchlabels = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tanggalabsens1 = new javax.swing.JTextField();
        datebtns1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelsup = new jtable_custom.JTable_Custom();
        caribtn2 = new javax.swing.JButton();
        cetaklsbtn = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        tanggalabsens2 = new javax.swing.JTextField();
        datebtns2 = new javax.swing.JButton();
        panelRound9 = new PanelRound.PanelRound();
        jLabel14 = new javax.swing.JLabel();
        panelRound2 = new PanelRound.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        searchlabel = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        tanggalabsenk1 = new javax.swing.JTextField();
        datebtnk1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelkar = new jtable_custom.JTable_Custom();
        caribtn1 = new javax.swing.JButton();
        cetaklkbtn = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        datebtnk2 = new javax.swing.JButton();
        tanggalabsenk2 = new javax.swing.JTextField();
        laporanbar = new javax.swing.JLabel();
        supplierbar = new javax.swing.JLabel();
        karyawanbar = new javax.swing.JLabel();
        mejabar = new javax.swing.JLabel();
        stokbar = new javax.swing.JLabel();
        homebar = new javax.swing.JLabel();
        orderbar = new javax.swing.JLabel();

        dateChooserk1.setForeground(new java.awt.Color(111, 72, 41));
        dateChooserk1.setDateFormat("yyyy-MM-dd");
        dateChooserk1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChooserk1.setTextRefernce(tanggalabsenk1);
        dateChooserk1.getAccessibleContext().setAccessibleParent(datebtnk1);

        dateChoosers1.setForeground(new java.awt.Color(111, 72, 41));
        dateChoosers1.setDateFormat("yyyy-MM-dd");
        dateChoosers1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChoosers1.setTextRefernce(tanggalabsens1);
        dateChoosers1.getAccessibleContext().setAccessibleParent(datebtns1);

        dateChooserp1.setForeground(new java.awt.Color(111, 72, 41));
        dateChooserp1.setDateFormat("yyyy-MM-dd");
        dateChooserp1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChooserp1.setTextRefernce(tanggalabsenp1);
        dateChooserp1.getAccessibleContext().setAccessibleParent(datebtnp1);

        dateChoosers2.setForeground(new java.awt.Color(111, 72, 41));
        dateChoosers2.setDateFormat("yyyy-MM-dd");
        dateChoosers2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChoosers2.setTextRefernce(tanggalabsens2);
        dateChoosers2.getAccessibleContext().setAccessibleParent(datebtns2);

        dateChooserk2.setForeground(new java.awt.Color(111, 72, 41));
        dateChooserk2.setDateFormat("yyyy-MM-dd");
        dateChooserk2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChooserk2.setTextRefernce(tanggalabsenk2);
        dateChooserk2.getAccessibleContext().setAccessibleParent(datebtnk2);

        dateChooserp2.setForeground(new java.awt.Color(111, 72, 41));
        dateChooserp2.setDateFormat("yyyy-MM-dd");
        dateChooserp2.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChooserp2.setTextRefernce(tanggalabsenp2);
        dateChooserp2.getAccessibleContext().setAccessibleParent(datebtnp2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(1194, 834));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userdd1.setBackground(new java.awt.Color(255, 255, 255));
        userdd1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userbar3.setFont(new java.awt.Font("Poppins", 0, 16)); // NOI18N
        userbar3.setText("Logout");
        userbar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userbar3MouseClicked(evt);
            }
        });
        userdd1.add(userbar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel24.add(userdd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, -1, 10));

        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel24.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1246, -1));

        userbar1.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        userbar1.setText("Owner");
        userbar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userbar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userbar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userbar1MouseExited(evt);
            }
        });
        jPanel24.add(userbar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 70, -1));

        Tab.setBackground(new java.awt.Color(111, 72, 41));
        Tab.setForeground(new java.awt.Color(255, 255, 255));
        Tab.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        Tab.setSelectedColor(new java.awt.Color(111, 72, 41));
        Tab.setUnselectedColor(new java.awt.Color(111, 72, 41));
        Tab.setVerifyInputWhenFocusTarget(false);

        panelRound10.setBackground(new java.awt.Color(206, 194, 182));
        panelRound10.setRoundBottomLeft(30);
        panelRound10.setRoundBottomRight(30);
        panelRound10.setRoundTopRight(30);
        panelRound10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tanggal");
        panelRound10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        caribtn.setBackground(new java.awt.Color(219, 167, 57));
        caribtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        caribtn.setForeground(new java.awt.Color(255, 255, 255));
        caribtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Search_optimized.png"))); // NOI18N
        caribtn.setText("Cari");
        caribtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribtnActionPerformed(evt);
            }
        });
        panelRound10.add(caribtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 100, 30));

        panelRound3.setBackground(new java.awt.Color(111, 72, 41));
        panelRound3.setPreferredSize(new java.awt.Dimension(1140, 38));
        panelRound3.setRoundTopRight(30);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Laporan Penjualan");
        panelRound3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/report_optimized.png"))); // NOI18N
        panelRound3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 40));

        panelRound10.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        searchlabelp.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchlabelp.setForeground(new java.awt.Color(204, 204, 204));
        searchlabelp.setText("Masukkan Data Penjualan");
        searchlabelp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchlabelpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchlabelpFocusLost(evt);
            }
        });
        searchlabelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchlabelpActionPerformed(evt);
            }
        });
        panelRound10.add(searchlabelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 320, 30));

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Data Penjualan");
        panelRound10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        tanggalabsenp1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tanggalabsenp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalabsenp1ActionPerformed(evt);
            }
        });
        panelRound10.add(tanggalabsenp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, 30));

        datebtnp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Calendar_4_optimized.png"))); // NOI18N
        datebtnp1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        datebtnp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datebtnp1ActionPerformed(evt);
            }
        });
        panelRound10.add(datebtnp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 40, 30));

        tabelpen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal Transaksi", "Pelanggan", "Status", "Kode Menu", "Nama Menu", "Jumlah", "Total Harga"
            }
        ));
        jScrollPane3.setViewportView(tabelpen);

        panelRound10.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1080, 550));

        cetaklpbtn.setBackground(new java.awt.Color(111, 72, 41));
        cetaklpbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        cetaklpbtn.setForeground(new java.awt.Color(255, 255, 255));
        cetaklpbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Print_optimized.png"))); // NOI18N
        cetaklpbtn.setText("Cetak");
        cetaklpbtn.setIconTextGap(6);
        cetaklpbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetaklpbtnActionPerformed(evt);
            }
        });
        panelRound10.add(cetaklpbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 120, 30));

        tanggalabsenp2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tanggalabsenp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalabsenp2ActionPerformed(evt);
            }
        });
        panelRound10.add(tanggalabsenp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 150, 30));

        datebtnp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Calendar_4_optimized.png"))); // NOI18N
        datebtnp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datebtnp2ActionPerformed(evt);
            }
        });
        panelRound10.add(datebtnp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 40, 30));

        jLabel27.setFont(new java.awt.Font("Poppins", 3, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("s/d");
        panelRound10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 30, 30));

        Tab.addTab("Penjualan", panelRound10);

        panelRound11.setBackground(new java.awt.Color(206, 194, 182));
        panelRound11.setRoundBottomLeft(30);
        panelRound11.setRoundBottomRight(30);
        panelRound11.setRoundTopRight(30);
        panelRound11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Poppins", 3, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("s/d");
        panelRound11.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 30, 30));

        panelRound4.setBackground(new java.awt.Color(111, 72, 41));
        panelRound4.setPreferredSize(new java.awt.Dimension(1140, 38));
        panelRound4.setRoundTopRight(30);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Laporan Pembelian Barang");
        panelRound4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/report_optimized.png"))); // NOI18N
        panelRound4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 40));

        panelRound11.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        searchlabels.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchlabels.setForeground(new java.awt.Color(204, 204, 204));
        searchlabels.setText("Masukkan Data Supplier");
        searchlabels.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchlabelsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchlabelsFocusLost(evt);
            }
        });
        searchlabels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchlabelsActionPerformed(evt);
            }
        });
        panelRound11.add(searchlabels, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 320, 30));

        jLabel24.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Data Supplier");
        panelRound11.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        tanggalabsens1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tanggalabsens1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalabsens1ActionPerformed(evt);
            }
        });
        panelRound11.add(tanggalabsens1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, 30));

        datebtns1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Calendar_4_optimized.png"))); // NOI18N
        datebtns1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datebtns1ActionPerformed(evt);
            }
        });
        panelRound11.add(datebtns1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 40, 30));

        tabelsup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Supplier", "Supplier", "Kode", "Nama", "Jumlah", "Harga Beli", "No.Telp", "Tanggal"
            }
        ));
        jScrollPane4.setViewportView(tabelsup);

        panelRound11.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1080, 550));

        caribtn2.setBackground(new java.awt.Color(219, 167, 57));
        caribtn2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        caribtn2.setForeground(new java.awt.Color(255, 255, 255));
        caribtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Search_optimized.png"))); // NOI18N
        caribtn2.setText("Cari");
        caribtn2.setMargin(new java.awt.Insets(2, 10, 3, 10));
        caribtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribtn2ActionPerformed(evt);
            }
        });
        panelRound11.add(caribtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 100, 30));

        cetaklsbtn.setBackground(new java.awt.Color(111, 72, 41));
        cetaklsbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        cetaklsbtn.setForeground(new java.awt.Color(255, 255, 255));
        cetaklsbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Print_optimized.png"))); // NOI18N
        cetaklsbtn.setText("Cetak");
        cetaklsbtn.setIconTextGap(6);
        cetaklsbtn.setMargin(new java.awt.Insets(2, 8, 3, 8));
        cetaklsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetaklsbtnActionPerformed(evt);
            }
        });
        panelRound11.add(cetaklsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 120, 30));

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Tanggal");
        panelRound11.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        tanggalabsens2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tanggalabsens2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalabsens2ActionPerformed(evt);
            }
        });
        panelRound11.add(tanggalabsens2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 150, 30));

        datebtns2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Calendar_4_optimized.png"))); // NOI18N
        datebtns2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datebtns2ActionPerformed(evt);
            }
        });
        panelRound11.add(datebtns2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 40, 30));

        Tab.addTab("Supplier", panelRound11);

        panelRound9.setBackground(new java.awt.Color(206, 194, 182));
        panelRound9.setRoundBottomLeft(30);
        panelRound9.setRoundBottomRight(30);
        panelRound9.setRoundTopRight(30);
        panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tanggal");
        panelRound9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        panelRound2.setBackground(new java.awt.Color(111, 72, 41));
        panelRound2.setPreferredSize(new java.awt.Dimension(1140, 38));
        panelRound2.setRoundTopRight(30);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Laporan Karyawan");
        panelRound2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/report_optimized.png"))); // NOI18N
        panelRound2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 40));

        panelRound9.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, -1));

        searchlabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchlabel.setForeground(new java.awt.Color(204, 204, 204));
        searchlabel.setText("Masukkan Data Karyawan");
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
        panelRound9.add(searchlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 320, 30));

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Data Karyawan");
        panelRound9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        tanggalabsenk1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tanggalabsenk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalabsenk1ActionPerformed(evt);
            }
        });
        panelRound9.add(tanggalabsenk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 150, 30));

        datebtnk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Calendar_4_optimized.png"))); // NOI18N
        datebtnk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datebtnk1ActionPerformed(evt);
            }
        });
        panelRound9.add(datebtnk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 40, 30));

        tabelkar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Nama Karyawan", "Shift", "Tanggal"
            }
        ));
        jScrollPane1.setViewportView(tabelkar);

        panelRound9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1080, 550));

        caribtn1.setBackground(new java.awt.Color(219, 167, 57));
        caribtn1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        caribtn1.setForeground(new java.awt.Color(255, 255, 255));
        caribtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Search_optimized.png"))); // NOI18N
        caribtn1.setText("Cari");
        caribtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribtn1ActionPerformed(evt);
            }
        });
        panelRound9.add(caribtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 100, 30));

        cetaklkbtn.setBackground(new java.awt.Color(111, 72, 41));
        cetaklkbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        cetaklkbtn.setForeground(new java.awt.Color(255, 255, 255));
        cetaklkbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Print_optimized.png"))); // NOI18N
        cetaklkbtn.setText("Cetak");
        cetaklkbtn.setIconTextGap(6);
        cetaklkbtn.setMargin(new java.awt.Insets(2, 10, 3, 10));
        cetaklkbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetaklkbtnActionPerformed(evt);
            }
        });
        panelRound9.add(cetaklkbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 90, 120, 30));

        jLabel26.setFont(new java.awt.Font("Poppins", 3, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("s/d");
        panelRound9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 30, 30));

        datebtnk2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Calendar_4_optimized.png"))); // NOI18N
        datebtnk2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datebtnk2ActionPerformed(evt);
            }
        });
        panelRound9.add(datebtnk2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 40, 30));

        tanggalabsenk2.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tanggalabsenk2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalabsenk2ActionPerformed(evt);
            }
        });
        panelRound9.add(tanggalabsenk2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 150, 30));

        Tab.addTab("Karyawan", panelRound9);

        jPanel24.add(Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 1180, 760));

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
        jPanel24.add(laporanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 19, 80, -1));

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
        jPanel24.add(supplierbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 19, 80, -1));

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
        jPanel24.add(karyawanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 19, 100, -1));

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
        jPanel24.add(mejabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 19, 102, -1));

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
        jPanel24.add(stokbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 19, 50, -1));

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
        jPanel24.add(homebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 19, 60, -1));

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
        jPanel24.add(orderbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 19, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userbar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbar3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userbar3MouseClicked

    private void userbar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userbar1MouseClicked

    private void userbar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userbar1MouseEntered

    private void userbar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userbar1MouseExited

    private void searchlabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusGained
        if(searchlabel.getText().equals("Masukkan Data Karyawan")){
            searchlabel.setText("");
            searchlabel.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_searchlabelFocusGained

    private void searchlabelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusLost
        if(searchlabel.getText().equals("")){
            searchlabel.setText("Masukkan Data Karyawan");
            searchlabel.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_searchlabelFocusLost

    private void searchlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchlabelActionPerformed

    private void tanggalabsenk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalabsenk1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalabsenk1ActionPerformed

    private void datebtnk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datebtnk1ActionPerformed
        dateChooserk1.showPopup();
        tabelkaryawan();
    }//GEN-LAST:event_datebtnk1ActionPerformed

    private void caribtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caribtn1ActionPerformed

    private void cetaklkbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetaklkbtnActionPerformed
     
        
        try {
            String reportPath = "src/laporan/LaporanKaryawans.jasper";
            
//            Connection conc = new newConnection().connect();
            HashMap parameter = new HashMap();
            
            parameter.put("datek1", tanggalabsenk1.getText());
            parameter.put("datek2", tanggalabsenk2.getText());
            
            File reportFile = new File(reportPath);
            JasperReport jr = (JasperReport) JRLoader.loadObject(reportFile);
            JasperPrint print = JasperFillManager.fillReport(jr,parameter,conn);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
//            viewer.setVisible(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error displaying report" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cetaklkbtnActionPerformed

    private void caribtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caribtnActionPerformed

    private void searchlabelpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelpFocusGained
        if(searchlabelp.getText().equals("Masukkan Data Penjualan")){
            searchlabelp.setText("");
            searchlabelp.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_searchlabelpFocusGained

    private void searchlabelpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelpFocusLost
        if(searchlabelp.getText().equals("")){
            searchlabelp.setText("Masukkan Data Penjualan");
            searchlabelp.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_searchlabelpFocusLost

    private void searchlabelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchlabelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchlabelpActionPerformed

    private void cetaklpbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetaklpbtnActionPerformed
        try {
            String reportPath = "src/laporan/LaporanPenjualan.jasper";
            Connection conc = new newConnection().connect();
            HashMap parameter = new HashMap();
            
            parameter.put("datep1", tanggalabsenp1.getText());
            parameter.put("datep2", tanggalabsenp2.getText());
            
            File reportFile = new File(reportPath);
            JasperReport jr = (JasperReport) JRLoader.loadObject(reportFile);
            JasperPrint print = JasperFillManager.fillReport(jr,parameter,conc);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
//            viewer.setVisible(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error displaying report" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cetaklpbtnActionPerformed

    private void searchlabelsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelsFocusGained
        if(searchlabels.getText().equals("Masukkan Data Supplier")){
            searchlabels.setText("");
            searchlabels.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_searchlabelsFocusGained

    private void searchlabelsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelsFocusLost
        if(searchlabels.getText().equals("")){
            searchlabels.setText("Masukkan Data Supplier");
            searchlabels.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_searchlabelsFocusLost

    private void searchlabelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchlabelsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchlabelsActionPerformed

    private void tanggalabsens1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalabsens1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalabsens1ActionPerformed

    private void datebtns1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datebtns1ActionPerformed
        dateChoosers1.showPopup();
        tabelsupplier();
    }//GEN-LAST:event_datebtns1ActionPerformed

    private void caribtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caribtn2ActionPerformed

    private void cetaklsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetaklsbtnActionPerformed
        try {
            String reportPath = "src/laporan/LaporanSupplier.jasper";
            Connection conc = new newConnection().connect();
            HashMap parameter = new HashMap();
            
            parameter.put("dates1", tanggalabsens1.getText());
            parameter.put("dates2", tanggalabsens2.getText());
            
            File reportFile = new File(reportPath);
            JasperReport jr = (JasperReport) JRLoader.loadObject(reportFile);
            JasperPrint print = JasperFillManager.fillReport(jr,parameter,conc);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
//            viewer.setVisible(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error displaying report" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cetaklsbtnActionPerformed

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

    private void tanggalabsens2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalabsens2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalabsens2ActionPerformed

    private void datebtns2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datebtns2ActionPerformed
        dateChoosers2.showPopup();
        tabelsupplier();
    }//GEN-LAST:event_datebtns2ActionPerformed

    private void datebtnk2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datebtnk2ActionPerformed
        dateChooserk2.showPopup();
        tabelkaryawan();
    }//GEN-LAST:event_datebtnk2ActionPerformed

    private void tanggalabsenk2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalabsenk2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalabsenk2ActionPerformed

    private void datebtnp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datebtnp2ActionPerformed
        dateChooserp2.showPopup();
        tabelpenjualan();
    }//GEN-LAST:event_datebtnp2ActionPerformed

    private void tanggalabsenp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalabsenp2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalabsenp2ActionPerformed

    private void datebtnp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datebtnp1ActionPerformed
        dateChooserp1.showPopup();
        tabelpenjualan();
    }//GEN-LAST:event_datebtnp1ActionPerformed

    private void tanggalabsenp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalabsenp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalabsenp1ActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.tabbed.TabbedPaneCustom Tab;
    private javax.swing.JButton caribtn;
    private javax.swing.JButton caribtn1;
    private javax.swing.JButton caribtn2;
    private javax.swing.JButton cetaklkbtn;
    private javax.swing.JButton cetaklpbtn;
    private javax.swing.JButton cetaklsbtn;
    private com.raven.datechooser.DateChooser dateChooserk1;
    private com.raven.datechooser.DateChooser dateChooserk2;
    private com.raven.datechooser.DateChooser dateChooserp1;
    private com.raven.datechooser.DateChooser dateChooserp2;
    private com.raven.datechooser.DateChooser dateChoosers1;
    private com.raven.datechooser.DateChooser dateChoosers2;
    private javax.swing.JButton datebtnk1;
    private javax.swing.JButton datebtnk2;
    private javax.swing.JButton datebtnp1;
    private javax.swing.JButton datebtnp2;
    private javax.swing.JButton datebtns1;
    private javax.swing.JButton datebtns2;
    private javax.swing.JLabel homebar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel karyawanbar;
    private javax.swing.JLabel laporanbar;
    private javax.swing.JLabel mejabar;
    private javax.swing.JLabel orderbar;
    private PanelRound.PanelRound panelRound10;
    private PanelRound.PanelRound panelRound11;
    private PanelRound.PanelRound panelRound2;
    private PanelRound.PanelRound panelRound3;
    private PanelRound.PanelRound panelRound4;
    private PanelRound.PanelRound panelRound9;
    private javax.swing.JTextField searchlabel;
    private javax.swing.JTextField searchlabelp;
    private javax.swing.JTextField searchlabels;
    private javax.swing.JLabel stokbar;
    private javax.swing.JLabel supplierbar;
    private jtable_custom.JTable_Custom tabelkar;
    private jtable_custom.JTable_Custom tabelpen;
    private jtable_custom.JTable_Custom tabelsup;
    private javax.swing.JTextField tanggalabsenk1;
    private javax.swing.JTextField tanggalabsenk2;
    private javax.swing.JTextField tanggalabsenp1;
    private javax.swing.JTextField tanggalabsenp2;
    private javax.swing.JTextField tanggalabsens1;
    private javax.swing.JTextField tanggalabsens2;
    private javax.swing.JLabel userbar1;
    private javax.swing.JLabel userbar3;
    private javax.swing.JPanel userdd1;
    // End of variables declaration//GEN-END:variables
}
