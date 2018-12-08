/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author RBS
 */
public class AdminService {  
    Connection mycon;

    public AdminService() {
        mycon = MybdConnection.getInstanceBD().getConnection();
    }
    public String verifierAdmin(String login,String mdp) throws SQLException
    {   String req = "select * from personne ";
       
       Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
        while (res.next()) {
         if(res.getString("username").equals(login)&&res.getString("password").equals(mdp))
         {
            return res.getString("role");
         }   
        }
        
        
        
        
        return "false";
    }
   
    public int idclientfind(String login) throws SQLException
    {   String req = "select * from personne ";
       
       Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
        while (res.next()) {
         if(res.getString("username").equals(login))
         {
            return res.getInt("id");
         }   
        }
        
        
        
        return -1;
    }   

    public int idclient(String login) throws SQLException
    {   String req = "select * from personne";
       
       Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
        while (res.next()) {
         if(res.getString("username").equals(login))
        
            return res.getInt("id");
       
         
         
           
        }
        return -1;
}
}
       
   
    
    
          
    

