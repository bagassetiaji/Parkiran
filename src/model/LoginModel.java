package model;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class LoginModel extends KoneksiDB{
    
    public LoginModel(){
        
    }
    
    public boolean loginHandler(String user, String pass){
        int totalData = 0;
        try{
            String query = "SELECT * FROM `users` WHERE "
                    + "`username`='" + user + "' AND "
                    + "`password`='" + pass + "'";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            
            statement.close();
            if (totalData > 0){
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
            } 
    }
}
