/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu;

import connection.newConnection;

import Supplier.Supplier;
import home.home;
import laporan.Laporan;
import inventaris.inventaris;
import karyawan.absenKaryawan;
import login.logout;
import pelanggan.pelanggan;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.sql.*;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import pelanggan.cariPelanggan;

/**
 *
 * @author KANDIAS
 */
public class menu extends javax.swing.JFrame {

    public Connection conn = new newConnection().connect();
    private DefaultTableModel tabmode;
    private DefaultTableModel tabpilih;
    private DefaultTableModel model;
    private double total;
//    private String path2;
    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
        datatable();
        setTableRenderer();
        autoNumberID();
        tabelkeranjang();
        totalBayar();
        datatableBayar();
        totalBayar1();
    }
    
    protected void kosong(){
        nofaktur.setText("");
        np.setText("");
        tanggaltransaksi.setText("");
        metode.setSelectedIndex(0);
        order.setSelectedIndex(0);
        totalbyr.setText("");
    }
    
    protected void kosongMenu(){
        nama_menu.setText("");
        qty.setText("");
    }
    
    private void datatabletes(){
        Object[] Baris = {"Gambar", "Kode Menu", "Kategori", "Nama Menu", "Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelmenu.setModel(tabmode);
        tabelmenu.setRowHeight(100);
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
                String e = rs.getString("harga_jual");
                
                Object[] data = {im,a,c,d,e};
                tabmode.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
    private void datatable(){
        Object[] Baris = {"Gambar", "Kode Menu", "Kategori", "Nama Menu", "Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelmenu.setModel(tabmode);
        tabelmenu.setRowHeight(100);
        String sql = "select * from tambahmenu where kategori='"+ kat.getSelectedItem().toString() +"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                byte[] imageData = rs.getBytes("gambar");
                ImageIcon im = new ImageIcon(imageData);
                String a = rs.getString("kode_menu");
                String c = rs.getString("kategori");
                String d = rs.getString("nama_menu");
                String e = rs.getString("harga_jual");
                
                Object[] data = {im,a,c,d,e};
                tabmode.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
    private void datatableBayar(){
        Object[] Baris = {"Kode Menu", "Nama Menu", "Jumlah", "Harga"};
        tabpilih = new DefaultTableModel(null, Baris);
        tabelbyr.setModel(tabpilih);
        String sql = "select * from keranjang where no_faktur like '"+ no_faktur1.getText() +"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("kode_menu");
                String b = rs.getString("nama_menu");
                String c = rs.getString("jumlah");
                String d = rs.getString("total_harga");
                
                Object[] data = {a,b,c,d};
                tabpilih.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
    private void tabelkeranjang(){
        Object[] Baris = {"Kode Menu", "Nama Menu", "Jumlah", "Harga"};
        tabpilih = new DefaultTableModel(null, Baris);
        tabelker.setModel(tabpilih);
        String sql = "select * from keranjang where no_faktur like '"+ nofaktur.getText() +"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("kode_menu");
                String b = rs.getString("nama_menu");
                String c = rs.getString("jumlah");
                String d = rs.getString("total_harga");
                Object[] data = {a,b,c,d};
                tabpilih.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
    public String namaPel;
    
    public String getNamaPel(){
        return namaPel;
    }
    
    public void pelangganTerpilih(){
        cariPelanggan cari = new cariPelanggan();
        cari.member = this;
        np.setText(namaPel);
    }
    
    private void autoNumberID(){
        String noFaktur = "NOTA000";
        int i = 0;
        try{
            String sql = "SELECT no_faktur FROM keranjang";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                noFaktur = rs.getString("no_faktur");
            }
            noFaktur = noFaktur.substring(4);
            i = Integer.parseInt(noFaktur) + 1;
            noFaktur = "00" + i;
            noFaktur= "NOTA" + noFaktur.substring(noFaktur.length()-3);
            nofaktur.setText(noFaktur);
            no_faktur1.setText(noFaktur);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Penomoran otomatis gagal! " + e);
        }
    }
    
    private void totalBayar(){
        int jumlahBaris = tabelker.getRowCount();
        double totalBiaya = 0.0;
        double hargaBarang;
        for(int i = 0; i < jumlahBaris; i++){
            hargaBarang = Double.parseDouble(tabelker.getValueAt(i, 3).toString());
            totalBiaya += hargaBarang;
        }
        
        totalbyr.setText(String.valueOf(totalBiaya));
    }
    
    private void totalBayar1(){
        int jumlahBaris = tabelker.getRowCount();
        double totalHarga = 0.0;
        double hargaBarang;
        for(int i = 0; i < jumlahBaris; i++){
            hargaBarang = Double.parseDouble(tabelker.getValueAt(i, 3).toString());
            totalHarga += hargaBarang;
        }
        
        double totalBiaya = totalHarga;
        
        if(member.isSelected()){
            double totalDiskon = 10 * (totalBiaya/100); 
            double totalBayar = totalBiaya - totalDiskon;
            totalbyr1.setText(String.valueOf(totalBayar));
        }else{
            totalbyr1.setText(String.valueOf(totalBiaya));
        }
    }
    
    
    public boolean isProductExist(String nofktr, String namap){
        try {
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM keranjang where no_faktur=? AND pelanggan=?");
            stat.setString(1, nofktr);
            stat.setString(2, namap);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger(keranjang.class.getName()).log(Level.SEVERE, null, e);
        }   
        return false;
    }
    
    
    // FOTO PRODUK
    
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
        tabelmenu.getColumnModel().getColumn(0).setCellRenderer(new customRenderer());
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

        dateChooser = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel23 = new javax.swing.JPanel();
        userdd = new javax.swing.JPanel();
        userbar2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        homebar = new javax.swing.JLabel();
        stokbar = new javax.swing.JLabel();
        orderbar = new javax.swing.JLabel();
        mejabar = new javax.swing.JLabel();
        laporanbar = new javax.swing.JLabel();
        supplierbar = new javax.swing.JLabel();
        karyawanbar = new javax.swing.JLabel();
        userbar = new javax.swing.JLabel();
        Tab = new raven.tabbed.TabbedPaneCustom();
        panelRound3 = new PanelRound.PanelRound();
        panelRound6 = new PanelRound.PanelRound();
        panelRound7 = new PanelRound.PanelRound();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        np = new javax.swing.JTextField();
        order = new javax.swing.JComboBox<>();
        metode = new javax.swing.JComboBox<>();
        simpanbtn = new PanelRound.PanelRound();
        lsimpan = new javax.swing.JLabel();
        totalbyr = new javax.swing.JTextField();
        nofaktur = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelker = new jtable_custom.JTable_Custom();
        datebtn = new javax.swing.JButton();
        tanggaltransaksi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        nonmember = new javax.swing.JRadioButton();
        member = new javax.swing.JRadioButton();
        cariPelanggan = new javax.swing.JButton();
        panelRound1 = new PanelRound.PanelRound();
        panelRound2 = new PanelRound.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kat = new javax.swing.JComboBox<>();
        searchlabel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelmenu = new jtable_custom.JTable_Custom();
        nama_menu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        tmbh = new javax.swing.JButton();
        hapusbtn = new javax.swing.JButton();
        kode_menu = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        searchbtn = new javax.swing.JButton();
        panelRound4 = new PanelRound.PanelRound();
        panelRound5 = new PanelRound.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelbyr = new jtable_custom.JTable_Custom();
        jLabel18 = new javax.swing.JLabel();
        tgl = new javax.swing.JTextField();
        batalbtn = new javax.swing.JButton();
        np1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        no_faktur1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        metode1 = new javax.swing.JTextField();
        order1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        totalbyr1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        bayarbtn = new javax.swing.JButton();
        diskon = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cetakbtn = new javax.swing.JButton();
        selesaibtn = new javax.swing.JButton();

        dateChooser.setForeground(new java.awt.Color(111, 72, 41));
        dateChooser.setDateFormat("yyyy-MM-dd");
        dateChooser.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChooser.setTextRefernce(tanggaltransaksi);
        dateChooser.getAccessibleContext().setAccessibleParent(datebtn);

        jLabel27.setText("jLabel27");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1433, 1473));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(1433, 1473));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel23.add(userdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, -1, 10));

        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel23.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 68, 1246, -1));

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
        jPanel23.add(homebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, -1));

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
        jPanel23.add(stokbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, -1));

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
        jPanel23.add(orderbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, -1));

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
        jPanel23.add(mejabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 100, -1));

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
        jPanel23.add(laporanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 80, -1));

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
        jPanel23.add(supplierbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 80, -1));

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
        jPanel23.add(karyawanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 100, -1));

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
        jPanel23.add(userbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 20, 70, -1));

        Tab.setBackground(new java.awt.Color(111, 72, 41));
        Tab.setForeground(new java.awt.Color(255, 255, 255));
        Tab.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        Tab.setSelectedColor(new java.awt.Color(111, 72, 41));
        Tab.setUnselectedColor(new java.awt.Color(111, 72, 41));
        Tab.setVerifyInputWhenFocusTarget(false);

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setPreferredSize(new java.awt.Dimension(1140, 700));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound6.setBackground(new java.awt.Color(206, 194, 182));
        panelRound6.setMinimumSize(new java.awt.Dimension(393, 582));
        panelRound6.setPreferredSize(new java.awt.Dimension(393, 582));
        panelRound6.setRoundBottomLeft(30);
        panelRound6.setRoundBottomRight(30);
        panelRound6.setRoundTopLeft(30);
        panelRound6.setRoundTopRight(30);
        panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound7.setBackground(new java.awt.Color(111, 72, 41));
        panelRound7.setPreferredSize(new java.awt.Dimension(393, 38));
        panelRound7.setRoundTopRight(30);
        panelRound7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("KERANJANG");
        panelRound7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 6, 115, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/cart_optimized.png"))); // NOI18N
        panelRound7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, -1, 20));

        panelRound6.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setText("NO . FAKTUR");
        panelRound6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Poppins", 2, 12)); // NOI18N
        jLabel8.setText("*List item");
        panelRound6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setText("Pembayaran");
        panelRound6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel10.setText("Tanggal");
        panelRound6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 30));

        jLabel11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel11.setText("Total Bayar");
        panelRound6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, 30));

        np.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        np.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npActionPerformed(evt);
            }
        });
        panelRound6.add(np, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 210, 30));

        order.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        order.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ditempat", "Take away" }));
        panelRound6.add(order, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 290, 30));

        metode.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        metode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tunai", "QRIS", "Debit Card", "Credit Card" }));
        panelRound6.add(metode, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 290, 30));

        simpanbtn.setBackground(new java.awt.Color(219, 167, 57));
        simpanbtn.setRoundBottomLeft(20);
        simpanbtn.setRoundBottomRight(20);
        simpanbtn.setRoundTopLeft(20);
        simpanbtn.setRoundTopRight(20);
        simpanbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simpanbtnMouseClicked(evt);
            }
        });
        simpanbtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lsimpan.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        lsimpan.setForeground(new java.awt.Color(255, 255, 255));
        lsimpan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Save_optimized.png"))); // NOI18N
        lsimpan.setText("Simpan Transaksi");
        lsimpan.setIconTextGap(6);
        lsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsimpanMouseClicked(evt);
            }
        });
        simpanbtn.add(lsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 380, 40));

        panelRound6.add(simpanbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 400, -1));

        totalbyr.setBackground(new java.awt.Color(228, 228, 228));
        totalbyr.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        totalbyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalbyrActionPerformed(evt);
            }
        });
        panelRound6.add(totalbyr, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 290, 30));

        nofaktur.setBackground(new java.awt.Color(228, 228, 228));
        nofaktur.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nofaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nofakturActionPerformed(evt);
            }
        });
        panelRound6.add(nofaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 290, 30));

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel13.setText("Metode");
        panelRound6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 20));

        tabelker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Menu", "Nama", "Jumlah", "Harga"
            }
        ));
        tabelker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkerMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelker);

        panelRound6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 460, 220));

        datebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Calendar_4_optimized.png"))); // NOI18N
        datebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datebtnActionPerformed(evt);
            }
        });
        panelRound6.add(datebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 40, 30));

        tanggaltransaksi.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tanggaltransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggaltransaksiActionPerformed(evt);
            }
        });
        panelRound6.add(tanggaltransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 240, 30));

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel14.setText("Order");
        panelRound6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, 30));

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setText("STATUS");
        panelRound6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        jLabel25.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel25.setText("PELANGGAN");
        panelRound6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        buttonGroup1.add(nonmember);
        nonmember.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        nonmember.setText("Non-Member");
        nonmember.setToolTipText("");
        nonmember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nonmemberActionPerformed(evt);
            }
        });
        panelRound6.add(nonmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 140, 30));

        buttonGroup1.add(member);
        member.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        member.setText("Member");
        member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberActionPerformed(evt);
            }
        });
        panelRound6.add(member, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 90, 30));

        cariPelanggan.setBackground(new java.awt.Color(219, 167, 57));
        cariPelanggan.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        cariPelanggan.setForeground(new java.awt.Color(255, 255, 255));
        cariPelanggan.setText("Cari");
        cariPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariPelangganActionPerformed(evt);
            }
        });
        panelRound6.add(cariPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 70, -1));

        panelRound3.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 459, 670));

        panelRound1.setBackground(new java.awt.Color(206, 194, 182));
        panelRound1.setPreferredSize(new java.awt.Dimension(725, 900));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        panelRound2.setBackground(new java.awt.Color(111, 72, 41));
        panelRound2.setPreferredSize(new java.awt.Dimension(733, 38));
        panelRound2.setRoundTopLeft(30);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATA MENU");
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 2, 128, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        panelRound2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 25, 30));

        kat.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        kat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minuman", "Makanan", "Snack" }));
        kat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                katActionPerformed(evt);
            }
        });

        searchlabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchlabel.setForeground(new java.awt.Color(204, 204, 204));
        searchlabel.setText("Masukkan Data Menu");
        searchlabel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchlabelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchlabelFocusLost(evt);
            }
        });

        tabelmenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Gambar", "Kode Menu", "Kategori", "Nama Menu", "Harga"
            }
        ));
        tabelmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelmenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelmenu);

        nama_menu.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_menuActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setText("Nama Menu");

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setText("Qty");

        qty.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });

        tmbh.setBackground(new java.awt.Color(219, 167, 57));
        tmbh.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        tmbh.setForeground(new java.awt.Color(255, 255, 255));
        tmbh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Add_optimized.png"))); // NOI18N
        tmbh.setText("Tambah Menu");
        tmbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmbhActionPerformed(evt);
            }
        });

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

        kode_menu.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        kode_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_menuActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel17.setText("Kode Menu");

        searchbtn.setBackground(new java.awt.Color(219, 167, 57));
        searchbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        searchbtn.setForeground(new java.awt.Color(255, 255, 255));
        searchbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Search_optimized.png"))); // NOI18N
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(kode_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(nama_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelRound1Layout.createSequentialGroup()
                                    .addComponent(hapusbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tmbh, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(kat, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(searchlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nama_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound1Layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kode_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tmbh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(kat, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(searchlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(searchbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelRound3.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 733, -1));

        Tab.addTab("Pesan", panelRound3);

        panelRound4.setBackground(new java.awt.Color(206, 194, 182));
        panelRound4.setPreferredSize(new java.awt.Dimension(725, 900));
        panelRound4.setRoundBottomLeft(30);
        panelRound4.setRoundBottomRight(30);
        panelRound4.setRoundTopLeft(30);
        panelRound4.setRoundTopRight(30);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound5.setBackground(new java.awt.Color(111, 72, 41));
        panelRound5.setPreferredSize(new java.awt.Dimension(733, 38));
        panelRound5.setRoundTopLeft(30);
        panelRound5.setRoundTopRight(30);
        panelRound5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DATA TRANSAKSI");
        panelRound5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 8, 128, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        panelRound5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 25, 30));

        panelRound4.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, -1));

        tabelbyr.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Kode Menu", "Nama Menu", "Jumlah", "Harga"
            }
        ));
        tabelbyr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbyrMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelbyr);

        panelRound4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 740, 640));

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel18.setText("Tanggal Transaksi");
        panelRound4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        tgl.setBackground(new java.awt.Color(228, 228, 228));
        tgl.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tgl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglActionPerformed(evt);
            }
        });
        panelRound4.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 230, 30));

        batalbtn.setBackground(new java.awt.Color(111, 72, 41));
        batalbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        batalbtn.setForeground(new java.awt.Color(255, 255, 255));
        batalbtn.setText("Batalkan Transaksi");
        batalbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalbtnActionPerformed(evt);
            }
        });
        panelRound4.add(batalbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 290, 30));

        np1.setBackground(new java.awt.Color(228, 228, 228));
        np1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        np1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                np1ActionPerformed(evt);
            }
        });
        panelRound4.add(np1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 230, 30));

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel19.setText("*List Menu Pesanan");
        panelRound4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, -1, -1));

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel20.setText("Nama Pelanggan");
        panelRound4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        no_faktur1.setBackground(new java.awt.Color(228, 228, 228));
        no_faktur1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        no_faktur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_faktur1ActionPerformed(evt);
            }
        });
        panelRound4.add(no_faktur1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 230, 30));

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel21.setText("No. Faktur");
        panelRound4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel22.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel22.setText("Metode Pembayaran");
        panelRound4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        metode1.setBackground(new java.awt.Color(228, 228, 228));
        metode1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        metode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metode1ActionPerformed(evt);
            }
        });
        panelRound4.add(metode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 230, 30));

        order1.setBackground(new java.awt.Color(228, 228, 228));
        order1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        order1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order1ActionPerformed(evt);
            }
        });
        panelRound4.add(order1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 230, 30));

        jLabel23.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel23.setText("Order");
        panelRound4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        totalbyr1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        totalbyr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalbyr1ActionPerformed(evt);
            }
        });
        panelRound4.add(totalbyr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 290, 50));

        jLabel24.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel24.setText("Total Harga");
        panelRound4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        bayarbtn.setBackground(new java.awt.Color(219, 167, 57));
        bayarbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        bayarbtn.setForeground(new java.awt.Color(255, 255, 255));
        bayarbtn.setText("Bayar");
        bayarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarbtnActionPerformed(evt);
            }
        });
        panelRound4.add(bayarbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 290, 30));

        diskon.setBackground(new java.awt.Color(228, 228, 228));
        diskon.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        diskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diskonActionPerformed(evt);
            }
        });
        panelRound4.add(diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 230, 30));

        jLabel26.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel26.setText("Diskon");
        panelRound4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        cetakbtn.setBackground(new java.awt.Color(219, 167, 57));
        cetakbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        cetakbtn.setForeground(new java.awt.Color(255, 255, 255));
        cetakbtn.setText("Cetak");
        cetakbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakbtnActionPerformed(evt);
            }
        });
        panelRound4.add(cetakbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 290, 30));

        selesaibtn.setBackground(new java.awt.Color(219, 167, 57));
        selesaibtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        selesaibtn.setForeground(new java.awt.Color(255, 255, 255));
        selesaibtn.setText("Selesai");
        selesaibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaibtnActionPerformed(evt);
            }
        });
        panelRound4.add(selesaibtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 750, 740, 40));

        Tab.addTab("Pembayaran", panelRound4);

        jPanel23.add(Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1210, 970));

        jScrollPane2.setViewportView(jPanel23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void npActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npActionPerformed

    private void totalbyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalbyrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalbyrActionPerformed

    private void nofakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nofakturActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nofakturActionPerformed

    private void simpanbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanbtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_simpanbtnMouseClicked

    private void lsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsimpanMouseClicked
        try {
            String sql = "insert into penjualan values (?,?,?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, nofaktur.getText());
                stat.setString(2, np.getText());

                String dm = "";
                if(member.isSelected()) dm = "Member";
                else dm = "Non-Member";
                stat.setString(3, dm);
                stat.setString(4, metode.getSelectedItem().toString());
                stat.setString(5, order.getSelectedItem().toString());
                stat.setString(6, diskon.getText());

                double totals = Double.parseDouble(totalbyr.getText());
                stat.setDouble(7, totals);

                stat.setString(8, tanggaltransaksi.getText());
                stat.executeUpdate();

                JOptionPane.showMessageDialog(null, "Menu berhasil ditambahkan!");
                kosongMenu();
                nofaktur.requestFocus();
                datatableBayar();
                totalBayar1();
                
                no_faktur1.setText(nofaktur.getText());
                np1.setText(np.getText());
                tgl.setText(tanggaltransaksi.getText());
                metode1.setText(metode.getSelectedItem().toString());
                order1.setText(order.getSelectedItem().toString());
                
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Menu gagal ditambahkan! " + e.getMessage());
        }
    }//GEN-LAST:event_lsimpanMouseClicked

    private void userbar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userbar2MouseClicked
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

    private void tabelmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelmenuMouseClicked
        int bar = tabelmenu.getSelectedRow();
        String a = tabmode.getValueAt(bar, 3).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        nama_menu.setText(a);
        kode_menu.setText(b);
    }//GEN-LAST:event_tabelmenuMouseClicked

    private void laporanbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanbarMouseClicked
        Laporan lap = new Laporan();
        lap.setVisible(true);
        lap.pack();
        lap.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_laporanbarMouseClicked

    private void datebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datebtnActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_datebtnActionPerformed

    private void tanggaltransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggaltransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggaltransaksiActionPerformed

    private void nama_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_menuActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyActionPerformed

    private void tmbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmbhActionPerformed
        model = (DefaultTableModel) tabelmenu.getModel();
        tabpilih = (DefaultTableModel) tabelker.getModel();
        int rowIndex = tabelmenu.getSelectedRow();
        try {
//            if(isProductExist(nofak, namam)){
//                    JOptionPane.showMessageDialog(this, "Menu ini sudah ada, silakan ubah jumlahnya saja", "Warning",2);
//                } else {
            String nofak = nofaktur.getText().trim();
            String namap = np.getText().trim();
            String namam = nama_menu.getText().trim();
            String kodmen = kode_menu.getText().trim();
            int jml = Integer.parseInt(qty.getText().trim());

            double harga = Double.parseDouble(model.getValueAt(rowIndex, 4).toString());
            double totalPerItem = harga * jml;  

            if("".equals(nama_menu.getText())){
                JOptionPane.showMessageDialog(this, "Anda belum memasukkan menu apapun", "Warning",2);
            } else if("".equals(qty.getText())){
                JOptionPane.showMessageDialog(this, "Masukkan jumlah menu", "Warning",2);
            } else {
                String sql = "insert into keranjang values (?,?,?,?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, nofak);
                stat.setString(2, namap);
                stat.setString(3, kodmen);
                stat.setString(4, namam);
                stat.setInt(5, jml);
                stat.setDouble(6, totalPerItem);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Menu berhasil ditambahkan!");
                kosongMenu();
                nofaktur.requestFocus();
                tabelkeranjang();
                totalBayar();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "" + e, "Warning",2);
        }
    }//GEN-LAST:event_tmbhActionPerformed

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "delete", "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok == 0){
            String sql = "delete from keranjang where nama_menu='"+nama_menu.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Menu berhasil dihapus");
                kosongMenu();
                nama_menu.requestFocus();
                tabelkeranjang();
                totalBayar();
                autoNumberID();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Menu gagal dihapus "+ e);
            }
        }
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void searchlabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusGained
         if(searchlabel.getText().equals("Masukkan Data Menu")){
            searchlabel.setText("");
            searchlabel.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_searchlabelFocusGained

    private void searchlabelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusLost
          if(searchlabel.getText().equals("")){
            searchlabel.setText("Masukkan Data Menu");
            searchlabel.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_searchlabelFocusLost

    private void tabelkerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkerMouseClicked
        int bar = tabelker.getSelectedRow();
        String a = tabpilih.getValueAt(bar, 0).toString();
        String b = tabpilih.getValueAt(bar, 1).toString();
        String c = tabpilih.getValueAt(bar, 2).toString();
        kode_menu.setText(a);
        nama_menu.setText(b);
        qty.setText(c);
    }//GEN-LAST:event_tabelkerMouseClicked

    private void kode_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_menuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_menuActionPerformed

    private void tabelbyrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbyrMouseClicked
        //        int bar = tabelbyr.getSelectedRow();
        //        String a = tabmode.getValueAt(bar, 3).toString();
        //        String b = tabmode.getValueAt(bar, 1).toString();
        //        fullname.setText(b);
    }//GEN-LAST:event_tabelbyrMouseClicked

    private void tglActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tglActionPerformed

    private void batalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalbtnActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "batalkan transaksi?", "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok == 0){
            String sql = "delete from keranjang where no_faktur='"+no_faktur1.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Transaksi dibatalkan!");
                kosong();
                no_faktur1.requestFocus();
                datatable();
                autoNumberID();
                
                // kembali ke tampilan pemilihan pesanan (order)
                menu or = new menu();
                or.setVisible(true);
                or.pack();
                or.setLocationRelativeTo(null);
                this.dispose();
                
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Transaksi tidak bisa dibatalkan!"+ e);
            }
        }
    }//GEN-LAST:event_batalbtnActionPerformed

    private void np1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_np1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_np1ActionPerformed

    private void no_faktur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_faktur1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_no_faktur1ActionPerformed

    private void metode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metode1ActionPerformed

    private void order1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order1ActionPerformed

    private void totalbyr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalbyr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalbyr1ActionPerformed

    private void bayarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarbtnActionPerformed
        tabmode = (DefaultTableModel) tabelbyr.getModel();
        try {
            if("".equals(no_faktur1.getText())){
                JOptionPane.showMessageDialog(this, "Tidak ada transaksi apapun", "Warning",2);
            } else if("".equals(totalbyr1.getText())){
                JOptionPane.showMessageDialog(this, "Nol - Tidak ada transaksi ", "Warning",2);
            } else {
                String sql = "insert into pembayaran values (?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.setString(1, nofaktur.getText());
                stat.setString(2, tanggaltransaksi.getText());
                stat.setString(3, totalbyr1.getText());
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Menu berhasil ditambahkan!");
                nofaktur.requestFocus();
                tabelkeranjang();
                totalBayar();
                totalBayar1();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, "" + e, "Warning",2);
        }
    }//GEN-LAST:event_bayarbtnActionPerformed

    private void nonmemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nonmemberActionPerformed
        diskon.setText("0%");
    }//GEN-LAST:event_nonmemberActionPerformed

    private void memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberActionPerformed
        diskon.setText("10%");
    }//GEN-LAST:event_memberActionPerformed

    private void diskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diskonActionPerformed

    private void cariPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariPelangganActionPerformed
        cariPelanggan cd =new cariPelanggan();
        cd.member = this;
        cd.setVisible(true);
        cd.setResizable(false);
        np.setEnabled(false);
    }//GEN-LAST:event_cariPelangganActionPerformed

    private void cetakbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakbtnActionPerformed
        try {
            String reportPath = "src/menu/FakturPenjualan.jasper";
            Connection conc = new newConnection().connect();
            HashMap parameter = new HashMap();
            File reportFile = new File(reportPath);
            JasperReport jr = (JasperReport) JRLoader.loadObject(reportFile);
            JasperPrint print = JasperFillManager.fillReport(jr,parameter,conc);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
//            viewer.setVisible(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Error displaying report" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cetakbtnActionPerformed

    private void selesaibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaibtnActionPerformed
        menu or = new menu();
        or.setVisible(true);
        or.pack();
        or.setLocationRelativeTo(null);
        this.dispose();
        autoNumberID();
    }//GEN-LAST:event_selesaibtnActionPerformed

    private void katActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_katActionPerformed
        String selectedOption = (String) kat.getSelectedItem();
                if (selectedOption!= null &&!selectedOption.equals("Select an option")) {
                    datatable();
                    setTableRenderer();
                }
    }//GEN-LAST:event_katActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        Object[] Baris = {"Gambar", "Kode Menu", "Kategori", "Nama Menu", "Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelmenu.setModel(tabmode);
        String sql = "SELECT * FROM tambahmenu WHERE kode_menu OR nama_menu like '%" + searchlabel.getText() + "%'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                byte[] imageData = rs.getBytes("gambar");
                ImageIcon im = new ImageIcon(imageData);
                String a = rs.getString("kode_menu");
                String c = rs.getString("kategori");
                String d = rs.getString("nama_menu");
                String e = rs.getString("harga_jual");
                
                Object[] data = {im,a,c,d,e};
                tabmode.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }//GEN-LAST:event_searchbtnActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.tabbed.TabbedPaneCustom Tab;
    private javax.swing.JButton batalbtn;
    private javax.swing.JButton bayarbtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cariPelanggan;
    private javax.swing.JButton cetakbtn;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JButton datebtn;
    private javax.swing.JTextField diskon;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JLabel homebar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel karyawanbar;
    private javax.swing.JComboBox<String> kat;
    private javax.swing.JTextField kode_menu;
    private javax.swing.JLabel laporanbar;
    private javax.swing.JLabel lsimpan;
    private javax.swing.JLabel mejabar;
    private javax.swing.JRadioButton member;
    private javax.swing.JComboBox<String> metode;
    private javax.swing.JTextField metode1;
    private javax.swing.JTextField nama_menu;
    private javax.swing.JTextField no_faktur1;
    private javax.swing.JTextField nofaktur;
    private javax.swing.JRadioButton nonmember;
    private javax.swing.JTextField np;
    private javax.swing.JTextField np1;
    private javax.swing.JComboBox<String> order;
    private javax.swing.JTextField order1;
    private javax.swing.JLabel orderbar;
    private PanelRound.PanelRound panelRound1;
    private PanelRound.PanelRound panelRound2;
    private PanelRound.PanelRound panelRound3;
    private PanelRound.PanelRound panelRound4;
    private PanelRound.PanelRound panelRound5;
    private PanelRound.PanelRound panelRound6;
    private PanelRound.PanelRound panelRound7;
    private javax.swing.JTextField qty;
    private javax.swing.JButton searchbtn;
    private javax.swing.JTextField searchlabel;
    private javax.swing.JButton selesaibtn;
    private PanelRound.PanelRound simpanbtn;
    private javax.swing.JLabel stokbar;
    private javax.swing.JLabel supplierbar;
    private jtable_custom.JTable_Custom tabelbyr;
    private jtable_custom.JTable_Custom tabelker;
    private jtable_custom.JTable_Custom tabelmenu;
    private javax.swing.JTextField tanggaltransaksi;
    private javax.swing.JTextField tgl;
    private javax.swing.JButton tmbh;
    private javax.swing.JTextField totalbyr;
    private javax.swing.JTextField totalbyr1;
    private javax.swing.JLabel userbar;
    private javax.swing.JLabel userbar2;
    private javax.swing.JPanel userdd;
    // End of variables declaration//GEN-END:variables
}
