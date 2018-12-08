/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class MybdConnection {
    
    
     String url="jdbc:mysql://localhost:3306/tmpidev";
     String login="root";
     String pwd="";
    
     Connection mycon; 
     static MybdConnection instanceBD;
     
    private MybdConnection(){
         try {
             mycon = DriverManager.getConnection(url, login, pwd);
             
             System.out.println("Connexion etablie !!! 😀 ");
         } catch (SQLException ex) {
             System.out.println(ex.getMessage());
         }
    }
    
    public static MybdConnection getInstanceBD(){
    
        if(instanceBD==null) 
        instanceBD=new MybdConnection();
        return instanceBD;
    }
    
    public Connection getConnection(){
    return mycon;
    }
    

}
