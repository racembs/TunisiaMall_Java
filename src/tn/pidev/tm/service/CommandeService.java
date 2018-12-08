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
import static jdk.nashorn.internal.runtime.Debug.id;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Commande;
import tn.pidev.tm.entite.LigneCommande;
import tn.pidev.tm.entite.Produit;

import tn.pidev.tm.utils.MybdConnection;


/**
 *
 * @author Asus
 */
public class CommandeService implements Iservice<Commande>{
Connection mycon;
    public CommandeService() {  

    
    mycon = MybdConnection.getInstanceBD().getConnection();

    }

    

    @Override
    public boolean inserer(Commande p) throws SQLException {
  String req1 = "INSERT INTO `commande`(`id`, `total`, `idClient`, `paiement`, `livraison`) VALUES ('"
                   + p.getId() + "', '" + p.getTotal()+ "', '" + p.getClient().getId()+ "', '" + p.getPaiment()+ "', '" + p.getLivraison()
                  
                    + "'); ";
       
       Statement ste = mycon.createStatement();
       int x = ste.executeUpdate(req1);
      
       
       
       return true;}
    
      public boolean insererC(int id) throws SQLException {

      String sql = "INSERT INTO commande (idClient)VALUES(?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement  = mycon.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
      }
    public boolean insererConnexion(int idclient,int idcommande) throws SQLException {

      String sql = "INSERT INTO connexion (idClient,idcommande)VALUES(?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement  = mycon.prepareStatement(sql);
            preparedStatement.setInt(1, idclient);
            preparedStatement.setInt(1, idcommande);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
      }
    
              
   public int getidc(int idclient)  {
int idcom=0 ;
       String requete = "SELECT id FROM `commande` WHERE `idClient` = ?;";
      
 PreparedStatement ps;
    try {
        ps = mycon.prepareStatement(requete);
         ps.setInt(1,idclient);
            ResultSet resultat = ps.executeQuery();

          if(resultat.next());
          {
                idcom=resultat.getInt(1);
                         return idcom;}
    } catch (SQLException ex) {
        Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
         
          return idcom;
          
          

        
    }
     
     
    

    @Override
    public boolean modifier(Commande p) throws SQLException {
        
      
            String sql = "UPDATE `commande` SET `id`=?,`total`=?,`idClient`=?,`paiement`=?,`livraison`=? WHERE id=? ;" ;

PreparedStatement statement = mycon.prepareStatement(sql);
statement.setInt(1,p.getId());
statement.setDouble(2,p.getTotal());
statement.setInt(3, p.getClient().getId());
statement.setInt(4, p.getPaiment());
statement.setInt(5, p.getLivraison());
statement.setInt(6, p.getId());
statement.executeUpdate();

        return false; 
    }

    @Override
    public boolean supprimer(Commande p) throws SQLException {
         String req = "delete from commande where "
                + "id= ? ";
        
       PreparedStatement ps = mycon.prepareStatement(req);
       ps.setInt(1, p.getId());
       ps.executeUpdate();
              return true;   
    }

    public List<Commande> getAll() throws SQLException {
     
Client h=new Client();
        List<Commande> commande = new ArrayList<>();
        String req = "select * from commande ";
        
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
               Commande c;
               ClientService cl=new ClientService();
              h=cl.chercherclient(Integer.toString(res.getInt("idclient")));
                c = new Commande(res.getInt("id")
                    ,res.getFloat("total")
                    ,h
                    ,res.getInt("paiement")
                    ,res.getInt("livraison"))
                 
                    ;
                commande.add(c);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commande;   
    }
   public ObservableList<Commande> getAllcommande(int idclient) throws SQLException {
     

            ObservableList<Commande> commande= FXCollections.observableArrayList();
     
Client h=new Client();
     
        String requete = "SELECT * FROM `commande` WHERE `idClient` = ?;";
      
 PreparedStatement ps;
    try {
        ps = mycon.prepareStatement(requete);
         ps.setInt(1,idclient);
            ResultSet res = ps.executeQuery();
         
         
           
            while (res.next()) {
               Commande c;
               ClientService cl=new ClientService();
              h=cl.chercherclient(Integer.toString(res.getInt("idClient")));
                c = new Commande(res.getInt("id")
                    ,res.getFloat("total")
                    ,h
                    ,res.getInt("paiement")
                    ,res.getInt("livraison"))
                 
                    ;
              commande.add(c);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commande;   
    }
    
    
    
    public double fgetTotal(int idcom)  {
double Total=0 ;
       String requete = "SELECT * FROM `commande` WHERE `id` = ?;";
      
 PreparedStatement ps;
    try {
        ps = mycon.prepareStatement(requete);
         ps.setInt(1,idcom);
            ResultSet resultat = ps.executeQuery();

          if(resultat.next());
          {
                Total=resultat.getDouble(2);
                         return Total;}
    } catch (SQLException ex) {
        Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
    }
         
          return -1;
          
          

        
    }
     
     
    


    @Override
    public void Afficher() throws SQLException {
  
    }
          public int verifCommande(int idCommande) throws SQLException {
     

        List<Commande> commande = new ArrayList<>();
        String req = "select * from commande ";
        int x=0;
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
               if (idCommande==res.getInt("idClient"))
               {x=x+1;}
               
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return x;   
    }
  
   
    
        public int CalculP() throws SQLException {
         String sql = "SELECT * FROM commande";
        
      
     Statement statement = mycon.createStatement(); 
     statement.setFetchSize(0);
     
     
ResultSet resultat = statement.executeQuery(sql); 

int n=0;
while (resultat.next()) {
   n=n+1;
  
}
 //System.out.println(n);
  
 return n;
 

    }  
    
    
    
    }

    
  
  

 
    
    

