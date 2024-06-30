/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author CIAGamester
 */
public class connection {
    private static Connection connection;
    public static Connection getConnection(){
        if(connection == null){
            try {
                String url = "jdbc:mysql://localhost:3306/cafe";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);
            } catch(SQLException ex) {
                Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//         try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Successful!");
//        } catch(ClassNotFoundException ex){
//            System.out.println("Not Connected!" + ex);
//        }
//        String url = "jdbc:mysql://localhost:3306/cafe";
//        String user = "root";
//        String pass = "";
//        try{
//            connection = DriverManager.getConnection(url, user, pass);
//            System.out.println("Database connected!");
//        } catch(SQLException ex){
//            System.out.println("Database not connected!");
//        }
        return connection;
    }

    public static PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
