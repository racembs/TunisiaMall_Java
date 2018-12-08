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
import tn.pidev.tm.entite.Paiement;

import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author Asus
 */
public class PaiementService {
  Connection mycon=MybdConnection.getInstanceBD().getConnection();;  
     public Paiement verifierAdmin(String carte,String mdp) throws SQLException
    {  
    String req = " SELECT * FROM paiement ";
       Paiement p =new Paiement();
       Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
        while (res.next())
        {
         if((res.getString("carterip").equals(carte))&& (res.getString("motdepass").equals(mdp)))
         {p.setCarte(res.getString("carterip"));
         p.setMdp(res.getString("motdepass"));
         p.setTotal(res.getDouble("Sold"));
      } 
        }
         return p;
        } }
        
        
        
        
    
    
    
    

