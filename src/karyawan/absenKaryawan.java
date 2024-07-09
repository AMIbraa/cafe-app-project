/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karyawan;

import connection.newConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

import login.logout;
import pelanggan.pelanggan;
import menu.menu;
import home.home;
import Supplier.Supplier;
import inventaris.inventaris;
import laporan.Laporan;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class absenKaryawan extends javax.swing.JFrame {
    public Connection conn = new newConnection().connect();
    public absenKaryawan karyawan = null;
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode1;
   
    public absenKaryawan() {
        initComponents();
        datatable();
        datatablein();
        autoNumberID();
    }
    
    // FUNCTION FOR ABSEN KARYAWAN
    protected void aktif(){
        id_karyawan.setEnabled(true);
        fullname.setEnabled(true);
        shiftabsen.setEnabled(true);
        tanggalabsen.setEnabled(true);
        id_karyawan.requestFocus();
    }
    
    protected void kosong(){
        id_karyawan.setText("");
        fullname.setText("");
        shiftabsen.setSelectedIndex(0);
        tanggalabsen.setText("");
    }
    
    private void datatable(){
        Object[] Baris = { "ID Karyawan", "Nama Karyawan", "Shift", "Tanggal"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelkar.setModel(tabmode);
        String sql = "select * from absen_karyawan";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("id_karyawan");
                String b = rs.getString("fullname");
                String c = rs.getString("shift");
                String d = rs.getString("tanggal_absen");

                String[] data = {a,b,c,d};
                tabmode.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
    // FUNCTION FOR INPUT DATA KARYAWAN
    protected void aktifin(){
        iname.setEnabled(true);
        itelp.setEnabled(true);
        imail.setEnabled(true);
        itelahir.setEnabled(true);
        italahir.setEnabled(true);
        ialamat.setEnabled(true);
        iname.requestFocus();
    }
    
    private void kosongin(){
        iname.setText("");
        itelp.setText("");
        imail.setText("");
        itelahir.setText("");
        italahir.setText("");
        laki.setSelected(true);
        ialamat.setText("");
    }
    
    private void datatablein(){
        Object[] Baris = {"ID Karyawan","Nama", "No. Telp", "Email", "Tempat Lahir", "Tanggal Lahir", "Jenis Kelamin", "Alamat"};
        tabmode1 = new DefaultTableModel(null, Baris);
        tabelkar1.setModel(tabmode1);
        String sql = "select * from karyawan";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String ids = rs.getString("id_karyawan");
                String a = rs.getString("fullname");
                String b = rs.getString("notelp");
                String c = rs.getString("email");
                String d = rs.getString("tempat_lahir");
                String e = rs.getString("tanggal_lahir");
                String f = rs.getString("jenis_kelamin");
                String g = rs.getString("alamat");
                
                Object[] data = {ids,a,b,c,d,e,f,g};
                tabmode1.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }
    
    private void autoNumberID(){
        String noID = "ID000";
        int i = 0;
        try{
            String sql = "SELECT id_karyawan FROM karyawan";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                noID = rs.getString("id_karyawan");
            }
            noID = noID.substring(2);
            i = Integer.parseInt(noID) + 1;
            noID = "00" + i;
            noID = "ID" + noID.substring(noID.length()-3);
            id.setText(noID);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Penomoran otomatis gagal! " + e);
        }
    }
    
    public String idkar, namkar;
    
    public String getIdKar(){
        return idkar;
    }
    
    public String getNamKar(){
        return namkar;
    }

    public void karyawanTerpilih(){
        tabelKaryawan tk = new tabelKaryawan();
        tk.karyawan = this;
        id_karyawan.setText(idkar);
        fullname.setText(namkar);
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
        dateChooser1 = new com.raven.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        userdd = new javax.swing.JPanel();
        userbar2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        homebar = new javax.swing.JLabel();
        stokbar = new javax.swing.JLabel();
        orderbar = new javax.swing.JLabel();
        mejabar = new javax.swing.JLabel();
        laporanbar = new javax.swing.JLabel();
        supplierbar = new javax.swing.JLabel();
        karyawanbar = new javax.swing.JLabel();
        userbar = new javax.swing.JLabel();
        Tab = new raven.tabbed.TabbedPaneCustom();
        panelRound1 = new PanelRound.PanelRound();
        panelRound2 = new PanelRound.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        searchlabel = new javax.swing.JTextField();
        caribtn = new javax.swing.JButton();
        tanggalabsen = new javax.swing.JTextField();
        nama4 = new javax.swing.JLabel();
        id_karyawan = new javax.swing.JTextField();
        fullname = new javax.swing.JTextField();
        nama5 = new javax.swing.JLabel();
        nama6 = new javax.swing.JLabel();
        nama7 = new javax.swing.JLabel();
        absenbtn = new javax.swing.JButton();
        hapusbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        datebtn = new javax.swing.JButton();
        cariId = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelkar = new jtable_custom.JTable_Custom();
        shiftabsen = new javax.swing.JComboBox<>();
        editbtn2 = new javax.swing.JButton();
        editbtn3 = new javax.swing.JButton();
        panelRound3 = new PanelRound.PanelRound();
        panelRound4 = new PanelRound.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        italahir = new javax.swing.JTextField();
        nama8 = new javax.swing.JLabel();
        iname = new javax.swing.JTextField();
        itelp = new javax.swing.JTextField();
        nama9 = new javax.swing.JLabel();
        nama10 = new javax.swing.JLabel();
        nama11 = new javax.swing.JLabel();
        simpanbtn = new javax.swing.JButton();
        imail = new javax.swing.JTextField();
        datelahirbtn = new javax.swing.JButton();
        nama12 = new javax.swing.JLabel();
        itelahir = new javax.swing.JTextField();
        perem = new javax.swing.JRadioButton();
        nama13 = new javax.swing.JLabel();
        laki = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ialamat = new javax.swing.JTextArea();
        nama14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelkar1 = new jtable_custom.JTable_Custom();
        id = new javax.swing.JTextField();
        nama15 = new javax.swing.JLabel();
        resetbtn1 = new javax.swing.JButton();
        editbtn1 = new javax.swing.JButton();
        hapusbtn1 = new javax.swing.JButton();

        dateChooser.setForeground(new java.awt.Color(111, 72, 41));
        dateChooser.setDateFormat("yyyy-MM-dd");
        dateChooser.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChooser.setTextRefernce(tanggalabsen);

        dateChooser1.setForeground(new java.awt.Color(111, 72, 41));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        dateChooser1.setTextRefernce(italahir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1194, 834));
        jPanel1.setPreferredSize(new java.awt.Dimension(1194, 834));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(userdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, -1, 10));

        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1200, 20));

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
        jPanel1.add(homebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, -1));

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
        jPanel1.add(stokbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, -1));

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
        jPanel1.add(orderbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, -1));

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
        jPanel1.add(mejabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 100, -1));

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
        jPanel1.add(laporanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 80, -1));

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
        jPanel1.add(supplierbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 80, -1));

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
        jPanel1.add(karyawanbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 100, -1));

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
        jPanel1.add(userbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 70, -1));

        Tab.setBackground(new java.awt.Color(111, 72, 41));
        Tab.setForeground(new java.awt.Color(255, 255, 255));
        Tab.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        Tab.setSelectedColor(new java.awt.Color(111, 72, 41));
        Tab.setUnselectedColor(new java.awt.Color(111, 72, 41));
        Tab.setVerifyInputWhenFocusTarget(false);

        panelRound1.setBackground(new java.awt.Color(206, 194, 182));
        panelRound1.setPreferredSize(new java.awt.Dimension(1140, 700));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(111, 72, 41));
        panelRound2.setPreferredSize(new java.awt.Dimension(1140, 38));
        panelRound2.setRoundTopRight(30);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Data Absensi Karyawan");
        panelRound2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Data_Backup_optimized.png"))); // NOI18N
        panelRound2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 40));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, -1));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Cari Karyawan");
        panelRound1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 56, -1, -1));

        searchlabel.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        searchlabel.setForeground(new java.awt.Color(204, 204, 204));
        searchlabel.setText("Masukkan Nama Karyawan");
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
        panelRound1.add(searchlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 404, 30));

        caribtn.setBackground(new java.awt.Color(219, 167, 57));
        caribtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        caribtn.setForeground(new java.awt.Color(255, 255, 255));
        caribtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Search_optimized.png"))); // NOI18N
        caribtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribtnActionPerformed(evt);
            }
        });
        panelRound1.add(caribtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 70, 30));

        tanggalabsen.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tanggalabsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalabsenActionPerformed(evt);
            }
        });
        panelRound1.add(tanggalabsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, 250, 30));

        nama4.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama4.setForeground(new java.awt.Color(255, 255, 255));
        nama4.setText("ID Karyawan");
        panelRound1.add(nama4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, -1, -1));

        id_karyawan.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        id_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_karyawanActionPerformed(evt);
            }
        });
        panelRound1.add(id_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 200, 30));

        fullname.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameActionPerformed(evt);
            }
        });
        panelRound1.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, 300, 30));

        nama5.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama5.setForeground(new java.awt.Color(255, 255, 255));
        nama5.setText("Nama Karyawan");
        panelRound1.add(nama5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, -1, -1));

        nama6.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama6.setForeground(new java.awt.Color(255, 255, 255));
        nama6.setText("Shift");
        panelRound1.add(nama6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, -1, -1));

        nama7.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama7.setForeground(new java.awt.Color(255, 255, 255));
        nama7.setText("Tanggal");
        panelRound1.add(nama7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, -1, -1));

        absenbtn.setBackground(new java.awt.Color(219, 167, 57));
        absenbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        absenbtn.setForeground(new java.awt.Color(255, 255, 255));
        absenbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Check_All_optimized.png"))); // NOI18N
        absenbtn.setText("Absen");
        absenbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absenbtnActionPerformed(evt);
            }
        });
        panelRound1.add(absenbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 450, 140, 30));

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
        panelRound1.add(hapusbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 500, 140, -1));

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
        panelRound1.add(editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, 140, -1));

        datebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Calendar_4_optimized.png"))); // NOI18N
        datebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datebtnActionPerformed(evt);
            }
        });
        panelRound1.add(datebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 380, 40, 30));

        cariId.setBackground(new java.awt.Color(219, 167, 57));
        cariId.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        cariId.setForeground(new java.awt.Color(255, 255, 255));
        cariId.setText("Cari");
        cariId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariIdActionPerformed(evt);
            }
        });
        panelRound1.add(cariId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 170, 80, -1));

        tabelkar.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID Karyawan", "Nama", "Shift", "Tanggal Absen"
            }
        ));
        tabelkar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkarMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelkar);

        panelRound1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 700, 400));

        shiftabsen.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        shiftabsen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Shift 1", "Shift 2", "Shift 3" }));
        panelRound1.add(shiftabsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 300, 30));

        editbtn2.setBackground(new java.awt.Color(111, 72, 41));
        editbtn2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        editbtn2.setForeground(new java.awt.Color(255, 255, 255));
        editbtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Refresh_optimized.png"))); // NOI18N
        editbtn2.setText("Muat Ulang");
        editbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtn2ActionPerformed(evt);
            }
        });
        panelRound1.add(editbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, -1, 30));

        editbtn3.setBackground(new java.awt.Color(111, 72, 41));
        editbtn3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        editbtn3.setForeground(new java.awt.Color(255, 255, 255));
        editbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Refresh_optimized.png"))); // NOI18N
        editbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtn3ActionPerformed(evt);
            }
        });
        panelRound1.add(editbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 40, 30));

        Tab.addTab("Absen", panelRound1);

        panelRound3.setBackground(new java.awt.Color(206, 194, 182));
        panelRound3.setRoundBottomLeft(30);
        panelRound3.setRoundBottomRight(30);
        panelRound3.setRoundTopLeft(30);
        panelRound3.setRoundTopRight(30);
        panelRound3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound4.setBackground(new java.awt.Color(111, 72, 41));
        panelRound4.setPreferredSize(new java.awt.Dimension(1140, 38));
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Input Data Karyawan");
        panelRound4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Insert_Table_optimized.png"))); // NOI18N
        panelRound4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 40));

        panelRound3.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, -1));

        italahir.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        panelRound3.add(italahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 250, 30));

        nama8.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama8.setForeground(new java.awt.Color(255, 255, 255));
        nama8.setText("Nama");
        panelRound3.add(nama8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        iname.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        panelRound3.add(iname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 300, 30));

        itelp.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        panelRound3.add(itelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 300, 30));

        nama9.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama9.setForeground(new java.awt.Color(255, 255, 255));
        nama9.setText("No. Telp");
        panelRound3.add(nama9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        nama10.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama10.setForeground(new java.awt.Color(255, 255, 255));
        nama10.setText("Email");
        panelRound3.add(nama10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        nama11.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama11.setForeground(new java.awt.Color(255, 255, 255));
        nama11.setText("Alamat");
        panelRound3.add(nama11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, -1, -1));

        simpanbtn.setBackground(new java.awt.Color(219, 167, 57));
        simpanbtn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        simpanbtn.setForeground(new java.awt.Color(255, 255, 255));
        simpanbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Save_optimized.png"))); // NOI18N
        simpanbtn.setText("Simpan");
        simpanbtn.setIconTextGap(6);
        simpanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbtnActionPerformed(evt);
            }
        });
        panelRound3.add(simpanbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 300, 30));

        imail.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        panelRound3.add(imail, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 300, 30));

        datelahirbtn.setText("...");
        datelahirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datelahirbtnActionPerformed(evt);
            }
        });
        panelRound3.add(datelahirbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 40, 30));

        nama12.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama12.setForeground(new java.awt.Color(255, 255, 255));
        nama12.setText("Tempat Lahir");
        panelRound3.add(nama12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, -1));

        itelahir.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        panelRound3.add(itelahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 300, 30));

        buttonGroup1.add(perem);
        perem.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        perem.setForeground(new java.awt.Color(255, 255, 255));
        perem.setText("Perempuan");
        panelRound3.add(perem, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 90, -1, 30));

        nama13.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama13.setForeground(new java.awt.Color(255, 255, 255));
        nama13.setText("Tanggal Lahir");
        panelRound3.add(nama13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        buttonGroup1.add(laki);
        laki.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        laki.setForeground(new java.awt.Color(255, 255, 255));
        laki.setText("Laki-laki");
        panelRound3.add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, -1, 30));

        ialamat.setColumns(20);
        ialamat.setRows(5);
        jScrollPane1.setViewportView(ialamat);

        panelRound3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 300, 100));

        nama14.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama14.setForeground(new java.awt.Color(255, 255, 255));
        nama14.setText("Jenis Kelamin");
        panelRound3.add(nama14, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, -1));

        tabelkar1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
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
                "ID Karyawan", "Nama", "No. Telp", "Email", "Tempat Lahir", "Tempat Lahir", "Jenis Kelamin", "Alamat"
            }
        ));
        tabelkar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelkar1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelkar1);

        panelRound3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 1060, 360));

        id.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        panelRound3.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 300, 30));

        nama15.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        nama15.setForeground(new java.awt.Color(255, 255, 255));
        nama15.setText("ID Karyawan");
        panelRound3.add(nama15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        resetbtn1.setBackground(new java.awt.Color(219, 167, 57));
        resetbtn1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        resetbtn1.setForeground(new java.awt.Color(255, 255, 255));
        resetbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Data_Backup_optimized.png"))); // NOI18N
        resetbtn1.setText("Atur Ulang");
        resetbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtn1ActionPerformed(evt);
            }
        });
        panelRound3.add(resetbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 140, -1));

        editbtn1.setBackground(new java.awt.Color(219, 167, 57));
        editbtn1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        editbtn1.setForeground(new java.awt.Color(255, 255, 255));
        editbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Edit_optimized.png"))); // NOI18N
        editbtn1.setText("Ubah");
        editbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtn1ActionPerformed(evt);
            }
        });
        panelRound3.add(editbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 140, -1));

        hapusbtn1.setBackground(new java.awt.Color(111, 72, 41));
        hapusbtn1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        hapusbtn1.setForeground(new java.awt.Color(255, 255, 255));
        hapusbtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/Remove_optimized.png"))); // NOI18N
        hapusbtn1.setText("Hapus");
        hapusbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtn1ActionPerformed(evt);
            }
        });
        panelRound3.add(hapusbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 140, -1));

        Tab.addTab("Input Data", panelRound3);

        jPanel1.add(Tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 760));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 830));

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

    private void stokbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stokbarMouseClicked
        inventaris stok = new inventaris();
        stok.setVisible(true);
        stok.pack();
        stok.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_stokbarMouseClicked

    private void supplierbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierbarMouseClicked
        Supplier sup = new Supplier();
        sup.setVisible(true);
        sup.pack();
        sup.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_supplierbarMouseClicked

    private void searchlabelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusGained
        if(searchlabel.getText().equals("Masukkan Nama Karyawan")){
            searchlabel.setText("");
            searchlabel.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_searchlabelFocusGained

    private void searchlabelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchlabelFocusLost
        if(searchlabel.getText().equals("")){
            searchlabel.setText("Masukkan Nama Karyawan");
            searchlabel.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_searchlabelFocusLost

    private void searchlabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchlabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchlabelActionPerformed

    private void caribtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribtnActionPerformed
        Object[] Baris = {"ID Karyawan", "Nama Karyawan", "Shift", "Tanggal"};
        tabmode = new DefaultTableModel(null, Baris);
        tabelkar.setModel(tabmode);
        String sql = "SELECT * FROM absen_karyawan WHERE id_karyawan OR fullname like '%" + searchlabel.getText() + "%'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("id_karyawan");
                String b = rs.getString("fullname");
                String c = rs.getString("shift");
                String d = rs.getString("tanggal_absen");

                String[] data = {a,b,c,d};
                tabmode.addRow(data);
            }
        } catch(Exception e) {
            System.err.println("DB Error!" + e.getMessage());
        }
    }//GEN-LAST:event_caribtnActionPerformed

    private void tanggalabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalabsenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalabsenActionPerformed

    private void id_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_karyawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_karyawanActionPerformed

    private void fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullnameActionPerformed

    private void absenbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absenbtnActionPerformed
        String sql = "insert into absen_karyawan values (?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, id_karyawan.getText());
            stat.setString(2, fullname.getText());
            stat.setString(3, shiftabsen.getSelectedItem().toString());
            stat.setString(4, tanggalabsen.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data saved successfully!");
            kosong();
            id_karyawan.requestFocus();
            datatable();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data failed to save! " + e);
        }
    }//GEN-LAST:event_absenbtnActionPerformed

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "delete", "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok == 0){
            String sql = "delete from absen_karyawan where id_karyawan ='"+id_karyawan.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data deleted successfully");
                kosong();
                id_karyawan.requestFocus();
                datatable();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Data failed to delete "+ e);
            }
        }
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        int bar =tabelkar.getSelectedRow();
        String kliks = (tabelkar.getModel().getValueAt(bar, 0).toString());        
        try {
            String sql = "update absen_karyawan set fullname=?,shift=?,tanggal_absen=? where id_karyawan ='"+kliks+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, fullname.getText());
            stat.setString(2, shiftabsen.getSelectedItem().toString());
            stat.setString(3, tanggalabsen.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data edited successfully!");
            kosong();
            id_karyawan.requestFocus();
            datatable();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data failed to edit!" + e);
        }
    }//GEN-LAST:event_editbtnActionPerformed

    private void datebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datebtnActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_datebtnActionPerformed

    private void cariIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariIdActionPerformed
//        String sql = "SELECT * FROM karyawan WHERE id_karyawan like '%" + id_karyawan.getText() + "%'";
//        try {
//            java.sql.Statement stat = conn.createStatement();
//            ResultSet rs = stat.executeQuery(sql);
//            while(rs.next()){
//                String a = rs.getString("id_karyawan");
//                String b = rs.getString("fullname");
//
//                id_karyawan.setText(a);
//                fullname.setText(b);
//
//                id_karyawan.setEnabled(false);
//                fullname.setEnabled(false);
//            }
//        } catch(Exception e) {
//            System.err.println("DB Error!" + e.getMessage());
//        }
        tabelKaryawan cd =new tabelKaryawan();
        cd.karyawan = this;
        cd.setVisible(true);
        cd.setResizable(false);
        id_karyawan.setEnabled(false);
        fullname.setEnabled(false);
    }//GEN-LAST:event_cariIdActionPerformed

    private void tabelkarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkarMouseClicked
        int bar = tabelkar.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        
        id_karyawan.setText(a);
        fullname.setText(b);
        shiftabsen.setSelectedItem(c);
        tanggalabsen.setText(d);
    }//GEN-LAST:event_tabelkarMouseClicked

    private void simpanbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanbtnActionPerformed
        String sql = "insert into karyawan values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, id.getText());
            stat.setString(2, iname.getText());
            stat.setString(3, itelp.getText());
            stat.setString(4, imail.getText());
            stat.setString(5, itelahir.getText());
            stat.setString(6, italahir.getText());
            
            String jk = "";
            if(laki.isSelected()) jk = "Laki-laki";
            else jk = "Perempuan";
            stat.setString(7, jk);
            
//            if(laki.isSelected()) jk = "Laki-laki";
            
            stat.setString(8, ialamat.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data saved successfully!");
            autoNumberID();
            kosongin();
            iname.requestFocus();
            datatablein();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data failed to save! " + e);
        }
    }//GEN-LAST:event_simpanbtnActionPerformed

    private void datelahirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datelahirbtnActionPerformed
        dateChooser1.showPopup();
    }//GEN-LAST:event_datelahirbtnActionPerformed

    private void laporanbarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanbarMouseClicked
        Laporan lap = new Laporan();
        lap.setVisible(true);
        lap.pack();
        lap.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_laporanbarMouseClicked

    private void resetbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtn1ActionPerformed
        kosongin();
        datatablein();
    }//GEN-LAST:event_resetbtn1ActionPerformed

    private void editbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn1ActionPerformed
        int bar =tabelkar1.getSelectedRow();
        String klik = (tabelkar1.getModel().getValueAt(bar, 0).toString());
        try {
            String sql = "update karyawan set fullname=?,notelp=?,email=?,tempat_lahir=?,tanggal_lahir=?,jenis_kelamin=?,alamat=? where id_karyawan ='"+klik+"'";
            PreparedStatement stat = conn.prepareStatement(sql);
            
            stat.setString(1, fullname.getText());
            stat.setString(2, itelp.getText());
            stat.setString(3, imail.getText());
            stat.setString(4, itelahir.getText());
            stat.setString(5, italahir.getText());            
            String jke1 = "";
            if(laki.isSelected()) jke1 = "Laki-laki";
            else jke1 = "Perempuan";
            stat.setString(6, jke1);
            stat.setString(7, ialamat.getText());

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data edited successfully!");
            kosongin();
            id_karyawan.requestFocus();
            datatablein();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Data failed to edit!" + e);
        }
    }//GEN-LAST:event_editbtn1ActionPerformed

    private void hapusbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtn1ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "delete", "Confirm Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ok == 0){
            String sql = "delete from karyawan where id_karyawan ='"+id.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data deleted successfully");
                kosongin();
                id_karyawan.requestFocus();
                datatablein();
                autoNumberID();
            } catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Data failed to delete "+ e);
            }
        }
    }//GEN-LAST:event_hapusbtn1ActionPerformed

    private void editbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn2ActionPerformed
        kosong();
    }//GEN-LAST:event_editbtn2ActionPerformed

    private void editbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtn3ActionPerformed
        datatable();
    }//GEN-LAST:event_editbtn3ActionPerformed

    private void tabelkar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelkar1MouseClicked
        int bar = tabelkar1.getSelectedRow();
        String a = tabmode1.getValueAt(bar, 0).toString();
        String b = tabmode1.getValueAt(bar, 1).toString();
        String c = tabmode1.getValueAt(bar, 2).toString();
        String d = tabmode1.getValueAt(bar, 3).toString();
        String e = tabmode1.getValueAt(bar, 4).toString();
        String f = tabmode1.getValueAt(bar, 5).toString();
        String g = tabmode1.getValueAt(bar, 6).toString();
        String h = tabmode1.getValueAt(bar, 6).toString();
        
        id.setText(a);
        iname.setText(b);
        itelp.setText(c);
        imail.setText(d);
        itelahir.setText(e);
        italahir.setText(f);
        if(g.equals("Laki-laki")) {laki.setSelected(true); perem.setSelected(false);}
        else {laki.setSelected(false); perem.setSelected(true);}
        ialamat.setText(h);
    }//GEN-LAST:event_tabelkar1MouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

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
            java.util.logging.Logger.getLogger(absenKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(absenKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(absenKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(absenKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new absenKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.tabbed.TabbedPaneCustom Tab;
    private javax.swing.JButton absenbtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cariId;
    private javax.swing.JButton caribtn;
    private com.raven.datechooser.DateChooser dateChooser;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JButton datebtn;
    private javax.swing.JButton datelahirbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JButton editbtn1;
    private javax.swing.JButton editbtn2;
    private javax.swing.JButton editbtn3;
    private javax.swing.JTextField fullname;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JButton hapusbtn1;
    private javax.swing.JLabel homebar;
    private javax.swing.JTextArea ialamat;
    private javax.swing.JTextField id;
    private javax.swing.JTextField id_karyawan;
    private javax.swing.JTextField imail;
    private javax.swing.JTextField iname;
    private javax.swing.JTextField italahir;
    private javax.swing.JTextField itelahir;
    private javax.swing.JTextField itelp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel karyawanbar;
    private javax.swing.JRadioButton laki;
    private javax.swing.JLabel laporanbar;
    private javax.swing.JLabel mejabar;
    private javax.swing.JLabel nama10;
    private javax.swing.JLabel nama11;
    private javax.swing.JLabel nama12;
    private javax.swing.JLabel nama13;
    private javax.swing.JLabel nama14;
    private javax.swing.JLabel nama15;
    private javax.swing.JLabel nama4;
    private javax.swing.JLabel nama5;
    private javax.swing.JLabel nama6;
    private javax.swing.JLabel nama7;
    private javax.swing.JLabel nama8;
    private javax.swing.JLabel nama9;
    private javax.swing.JLabel orderbar;
    private PanelRound.PanelRound panelRound1;
    private PanelRound.PanelRound panelRound2;
    private PanelRound.PanelRound panelRound3;
    private PanelRound.PanelRound panelRound4;
    private javax.swing.JRadioButton perem;
    private javax.swing.JButton resetbtn1;
    private javax.swing.JTextField searchlabel;
    private javax.swing.JComboBox<String> shiftabsen;
    private javax.swing.JButton simpanbtn;
    private javax.swing.JLabel stokbar;
    private javax.swing.JLabel supplierbar;
    private jtable_custom.JTable_Custom tabelkar;
    private jtable_custom.JTable_Custom tabelkar1;
    private javax.swing.JTextField tanggalabsen;
    private javax.swing.JLabel userbar;
    private javax.swing.JLabel userbar2;
    private javax.swing.JPanel userdd;
    // End of variables declaration//GEN-END:variables
}
