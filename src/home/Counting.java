/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package home;

import connection.newConnection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author CIAGamester
 */
public class Counting extends newConnection{

    public Connection conn = new newConnection().connect();
    
        public void tampilCountName(){
           try {
                String sql = "SELECT COUNT(nama_menu) from tambahmenu";
                java.sql.Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    home.totalNamaBrg.setText(rs.getString(1));
                }
            } catch (SQLException ex) {
            Logger.getLogger(Counting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
       public void tampilCountTrx(){
            try {
                String sql = "SELECT COUNT(no_faktur) from penjualan";
                java.sql.Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    home.totalTrx.setText(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Counting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
        public void tampilCountBrg(){
            try {
                String sql = "SELECT SUM(stok) FROM tambahmenu";
                java.sql.Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    home.StokBrg.setText(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Counting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        public void tampilCountPlg(){
            try {
                String sql = "SELECT COUNT(id_pelanggan) FROM pelanggan";
                java.sql.Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    home.totalPlg.setText(rs.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Counting.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
