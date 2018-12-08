/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.pidev.tm.entite.CarteFidelite;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author RBS
 */
public class CartefideliteService implements Iservice<CarteFidelite>{
    Connection mycon;

    public CartefideliteService() {
        mycon = MybdConnection.getInstanceBD().getConnection();
    }

   public boolean inserer(CarteFidelite carte) throws SQLException {
     
       
       String req1="INSERT INTO `cartefedalite` (`id`, `nbrpts`, `idClient`, `idEnseigne`) VALUES (NULL,?,?,?);";
        PreparedStatement preparedStatement;
   
       
            preparedStatement = mycon.prepareStatement(req1);
            preparedStatement.setInt(1,10);
            preparedStatement.setInt(2,carte.getClient().getId());
            preparedStatement.setInt(3,carte.getEnseigne().getId());
            
            
            int res = preparedStatement.executeUpdate();
      
        
       
      return true;
    }
    
     public boolean modifier(CarteFidelite carte) throws SQLException {
        
      
    
               /*  String req2="UPDATE `cartefedalite` SET `id` = '"+carte.getId()+"', `nbrpts` = '" +carte.getNombreDePoints()+"',"
                       + " `idClient` = '" +carte.getClient().getId()+"', `idEnseigne` = '" +carte.getEnseigne().getId()+"';";*/
                String req2=  "UPDATE `cartefedalite` SET `nbrpts` = '" +carte.getNombreDePoints()+"', `idClient` = '" +carte.getClient().getId()+"', `idEnseigne` = '" +carte.getEnseigne().getId()+"' WHERE `id` = "+carte.getId()+";";
               Statement ste2 = mycon.createStatement();
               int x = ste2.executeUpdate(req2);
   
        return true;
    }
     
     public boolean resetcarte(CarteFidelite carte) throws SQLException {
        
      
    
              
               String req2=  "UPDATE `cartefedalite` SET `nbrpts` = '0' WHERE `id` = "+carte.getId()+";";
               Statement ste2 = mycon.createStatement();
               int x = ste2.executeUpdate(req2);
   
        return true;
    }
     
     
      public boolean supprimer(CarteFidelite carte) throws SQLException {
        String req="delete from cartefedalite where id='" +carte.getId()+"';";
        Statement ste2 = mycon.createStatement();
               int x = ste2.executeUpdate(req);
        return true;
    }
      
      
    public void Afficher() throws SQLException {
           String req1 = "select * from cartefedalite";
       
       Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            System.out.println(res.getInt("id")
                    +" "+res.getInt("nbrpts")
                    +" "+ res.getInt("idClient")
                    +" "+ res.getInt("idEnseigne"));
            
        }
    }

    
 public ObservableList<CarteFidelite> getAll(int idclient) throws SQLException {
     ObservableList<CarteFidelite> cartes = FXCollections.observableArrayList();
     ClientService cs =new ClientService();
     ServiceEnseigne en=new ServiceEnseigne();
       
        String req = "SELECT * FROM `cartefedalite` where idClient='" +idclient+"';";
        
       try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
              
                CarteFidelite carte = new CarteFidelite(
                        res.getInt("id")
                    ,res.getInt("nbrpts")
                    ,en.chercherId(res.getInt("idEnseigne"))
                    ,cs.chercherId(res.getInt("idClient")));
                cartes.add(carte);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cartes;   
    }
 
  public ObservableList<String> getAllName() {
     ClientService cs =new ClientService();
     ServiceEnseigne en=new ServiceEnseigne();
        ObservableList<String> cartes = FXCollections.observableArrayList();
        String req = "select * from cartefedalite ";
        
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
              
                CarteFidelite carte = new CarteFidelite(
                        res.getInt("id")
                    ,res.getInt("ptsfidelite")
                    ,en.chercherId(res.getInt("idClient"))
                    ,cs.chercherId(res.getInt("idEnseigne")));
                cartes.add(carte.getEnseigne().getNom());
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cartes;   
    }
    public CarteFidelite chercherId(int id) {
      CarteFidelite carte = null;
          ClientService cs =new ClientService();
     ServiceEnseigne en=new ServiceEnseigne();
        String req = "select * from cartefedalite where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                
                  carte = new CarteFidelite(
                        res.getInt("id")
                    ,res.getInt("nbrpts")
                    ,en.chercherId(res.getInt("idClient"))
                    ,cs.chercherId(res.getInt("idEnseigne")));
                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return carte;   
    }
  public boolean ajouterpts(int id,int pts) throws SQLException{
         if(pts>0){
         CarteFidelite carte=chercherId(id);
         carte.setNombreDePoints(carte.getNombreDePoints()+pts);
         this.modifier(carte);
         return true;
         }
         return false;
     }
    
}
