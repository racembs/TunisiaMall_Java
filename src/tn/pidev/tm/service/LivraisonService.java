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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import tn.pidev.tm.entite.Commande;
import tn.pidev.tm.entite.Livraison;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author HP-PC
 */
public class LivraisonService implements  Iservice <Livraison>{
   
    Connection mycon;

    public LivraisonService() {
       
    mycon = MybdConnection.getInstanceBD().getConnection();
}

    @Override
    public boolean inserer(Livraison p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Livraison p) throws SQLException {
        try {
            String req1="UPDATE `commande` SET adresse=?, dateLivraison=?, Etat=? WHERE id=?";
            
            PreparedStatement ps= mycon.prepareStatement(req1); 
            ps.setString(1, p.getAdresse());
            ps.setDate(2,p.convert(p.getDateLivraison()));
            ps.setString(3, p.getEtat());
            ps.setInt(4, p.getId());
            
            
            ps.executeUpdate();
            
            return true;
        } catch (ParseException ex) {
            Logger.getLogger(LivraisonService.class.getName()).log(Level.SEVERE, null, ex);
        }
           return false;
    }

    @Override
    public boolean supprimer(Livraison p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Afficher() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
      public ObservableList<Livraison> getAll() {
     ObservableList<Livraison> livraison = FXCollections.observableArrayList();

       
        String req = "select * from commande where livraison=1  ";
        ClientService cs= new ClientService();
        
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
             Livraison L;
             L = new Livraison(res.getInt("id"),res.getDouble("total"),cs.chercherclient(res.getInt("idClient")),res.getInt("paiement") ,res.getInt("livraison"),res.getString("adresse"),res.getString("dateLivraison"),res.getString("Etat")) ;
                livraison.add(L);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return livraison;   
    }
          public ObservableList<Livraison> getAll1() {
     ObservableList<Livraison> livraison = FXCollections.observableArrayList();

       
        String req = "select * from commande where livraison=1  ";
        ClientService cs= new ClientService();
        
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
             Livraison L;
                L = new Livraison(res.getInt("id"),res.getDouble("total"),cs.chercherclient(res.getInt("idClient")),res.getInt("paiement") ,res.getInt("livraison"),res.getString("adresse"),res.getString("dateLivraison"),res.getString("Etat")) ;
                livraison.add(L);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return livraison;   
    }
          
          
          
                 public List<String>  getAllEtat() {
     List<String> livraison = new ArrayList<>();

       
        String req = "select * from `commande`";
        ClientService cs= new ClientService();
         PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
             Livraison L;
                L = new Livraison(res.getInt("id"),res.getDouble("total"),cs.chercherclient(res.getInt("idClient")),res.getInt("paiement") ,res.getInt("livraison"),res.getString("adresse"),res.getString("dateLivraison"),res.getString("Etat")) ;
                livraison.add(L.getEtat());
                System.out.println(L);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return livraison;   
    }
    
}
