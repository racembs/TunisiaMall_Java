package tn.pidev.tm.test;


import tn.pidev.tm.utils.MybdConnection;
import tn.pidev.tm.entite.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tn.pidev.tm.service.ProduitService;


public class TestProduit {
 

    
    public static Connection mycon;
    
    public static void main(String[] args) {
        
      try {
         mycon = MybdConnection.getInstanceBD().getConnection();
       
        Produit p =new Produit();
         Produit p1= new Produit();
    
//         Produit p =new Produit(200, "ons", 1, "ons", 500d, "ons", 0.2f, "aaa");
//        
//          insererProduit(p);
          
         
          
           List<Produit> produits = new ArrayList<>();
          
//         p1.setId(1);x
//         p1.setPrix(2);
          ProduitService produitService = new ProduitService();
//          produitService.supprimer(p1);
//          produitService.inserer(p);
//          produitService.modifier(p1);
            produitService.Afficher();
            
            System.out.println("----------------------------------------");
            produitService.CalculP();
          
                     

        
        produits=produitService.getRef("nom") ;
           for (int i = 0 ; i < produits.size() ; i++) {
               System.out.println(produits.get(i)+"\n");}
        
         produits=produitService.getAll() ;
           for (int i = 0 ; i < produits.size() ; i++) {
               System.out.println(produits.get(i)+"\n");}

           
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
        
    }
    
    
    
}
