/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;

/**
 *
 * @author CIAGamester
 */
public class newConnection {
    private Connection connection;
    public Connection connect(){
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Successful!");
        } catch(ClassNotFoundException ex){
            System.out.println("Not Connected!" + ex);
        }
        String url = "jdbc:mysql://localhost:3306/cafe";
        String user = "root";
        String pass = "";
        try{
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Database connected!");
        } catch(SQLException ex){
            System.out.println("Database not connected!");
        }
        return connection;
    }
}
