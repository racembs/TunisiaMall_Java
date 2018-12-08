/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import tn.pidev.tm.entite.Personnel;

import tn.pidev.tm.service.PersonnelService;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author RBS
 */
public class TestPersonnel {
    static Connection mycon;
    public static void main(String[] args)  {
         mycon = MybdConnection.getInstanceBD().getConnection();
     
            Personnel c=new Personnel(22.52, "ff", 5, "azer", "zzhhhz", "zzhhz", "zzzk", "zz");
            
           PersonnelService ps=new PersonnelService();
        try {
            
//          ps.inserer(c);
             //ps.Afficher();
             //c.setId(10);
             System.out.println("***********modifer************");
       ps.modifier(c);
           ps.Afficher();
             System.out.println("************supprimer***********");
             //ps.supprimer(c);
             //ps.Afficher();
        } catch (SQLException ex) {
            Logger.getLogger(TestPersonnel.class.getName()).log(Level.SEVERE, null, ex);
            //ex.getMessage();
        } 
       
        
    }
}
