package model;

import java.sql.*;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import java.sql.Statement;
/**
 *
 * @author april
 */
public class KoneksiDB {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test"; //untuk mengkoneksikan program dengan database
    static final String USER = "root";
    static final String PASS = ""; 
    public java.sql.Connection koneksi;
    public Statement statement;
    
    public KoneksiDB(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (java.sql.Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            statement = koneksi.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public java.sql.Connection getConnection(){
        return koneksi;
    }
 
}
