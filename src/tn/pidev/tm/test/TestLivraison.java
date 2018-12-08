/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.pidev.tm.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.pidev.tm.entite.Livraison;
import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.service.LivraisonService;
import tn.pidev.tm.service.ProduitService;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author HP-PC
 */
public class TestLivraison {
    
  
    
    public static Connection mycon;
    
    public static void main(String[] args) {
        
        
//      try {
         mycon = MybdConnection.getInstanceBD().getConnection();
       
           List<Livraison> livraisons = new ArrayList<>();
      
          
           Livraison l2= new Livraison ();     
          
         
         l2.setAdresse("Tunis");
        // l2.setDateLivraison(12/12/2010);
         l2.setEtat("");
                 
         
          LivraisonService livService = new LivraisonService();
          
//           livService.modifier(l2);
          
        livraisons = livService.getAll() ;
           for (int i = 0 ; i < livraisons.size() ; i++) {
               System.out.println(livraisons.get(i)+"\n");}
           
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
           
          
        
          
     
        
    }
    
    
    
}
