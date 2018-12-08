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
import tn.pidev.tm.entite.LigneCommande;
import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author Asus
 */
public class LigneCommandeservice implements Iservice<LigneCommande> {

    Connection mycon;

    public LigneCommandeservice() {
        mycon = MybdConnection.getInstanceBD().getConnection();
    }

    @Override
    public boolean inserer(LigneCommande p) throws SQLException {
        String req1 = "INSERT INTO `lignecommande` (`idProduit`, `idcommande`, `quantite`, `total`)  VALUES ( '" + p.getIdcommande() + "', '" + p.getProduit().getId() + "', '" + p.getQuantite() + "', '" + p.getTotal()
                + "'); ";

        Statement ste = mycon.createStatement();
        int x = ste.executeUpdate(req1);

        return true;
    }
//        private int idcommande;
//     private int idproduit;
//      private int quantite;
//     private double total;

    public boolean insererp(int ref, int comd, int quantite, double total, double prix, double promo) {
        String sql = "INSERT INTO lignecommande (idProduit,idcommande,quantite,total,promo,prix)VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement  = mycon.prepareStatement(sql);
            preparedStatement.setInt(1, ref);
            preparedStatement.setInt(2, comd);
            preparedStatement.setInt(3, quantite);
            preparedStatement.setDouble(4, total);
            preparedStatement.setDouble(5, prix);
            preparedStatement.setDouble(6, promo);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

        return true;
    }

    @Override
    public boolean modifier(LigneCommande p) throws SQLException {
        String sql = "UPDATE `lignecommande` SET `id`=?,`idProduit`=?,`idcommande`=?,`quantite`=?,`total`=? WHERE id=? ;";


        PreparedStatement statement = mycon.prepareStatement(sql);
        statement.setInt(1, p.getId());
        statement.setInt(3 ,p.getIdcommande());
        statement.setInt(2, p.getProduit().getId());
        statement.setInt(4, p.getQuantite());
        statement.setDouble(5, p.getTotal());
        statement.setInt(6, p.getId());

      statement.executeUpdate();
           
        return false;
    }

    
    
    
    @Override
    public boolean supprimer(LigneCommande p) throws SQLException {
        String req = "delete from lignecommande where "
                + "id= ? ";

        PreparedStatement ps = mycon.prepareStatement(req);
        ps.setInt(1, p.getId());
        ps.executeUpdate();
        return true;
    }

    @Override
    public void Afficher() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ObservableList<LigneCommande> getAll() {
            ObservableList<LigneCommande>  lignecommande= FXCollections.observableArrayList();
          try {
        String req = "select * from lignecommande ";
        Produit p=new Produit();
        ProduitService ps=new ProduitService();

        
   
            Statement ste = mycon.createStatement();
            ResultSet res = ste.executeQuery(req);
            p=ps.chercheproduit(res.getInt("idproduit"));
            while (res.next()) {
                LigneCommande c;
                c = new LigneCommande(res.getInt("id"),
                        res.getInt("idcommande"),
                         p,
                         res.getInt("quantite"),
                         res.getDouble("total"),res.getFloat("prix"));

                lignecommande.add(c);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lignecommande;
    }



    public ObservableList<LigneCommande> getAll(int idcommande) {
            ObservableList<LigneCommande>  lignecommande= FXCollections.observableArrayList();
     
        String requete = "SELECT * FROM `lignecommande` WHERE `idcommande` = ?;";
      
 PreparedStatement ps;
    try {
        ps = mycon.prepareStatement(requete);
         ps.setInt(1,idcommande);
            ResultSet res = ps.executeQuery();
            Produit p=new Produit();
            ProduitService pS=new ProduitService();
           
          
            while (res.next()) {
                p= pS.chercheproduit(res.getInt("idproduit"));
                LigneCommande c;
                c = new LigneCommande(res.getInt("id"),
                        res.getInt("idcommande"),
                         p,
                         res.getInt("quantite"),
                         res.getDouble("total"),res.getFloat("prix"));

                lignecommande.add(c);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lignecommande;
    }

             
//   public int getidc(int idclient)  {
//int idcom=0 ;
//       String requete = "SELECT id FROM `commande` WHERE `idClient` = ?;";
//      
// PreparedStatement ps;
//    try {
//        ps = mycon.prepareStatement(requete);
//         ps.setInt(1,idclient);
//            ResultSet resultat = ps.executeQuery();
//
//          if(resultat.next());
//          {
//                idcom=resultat.getInt(1);
//                         return idcom;}
//    } catch (SQLException ex) {
//        Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex);
//    }
//         
//          return idcom;
//          
//          
//
//        
//    }
  public void supprimerP(int produit) {
          String req = "delete from lignecommande where "
                + "id= ? ";
        
       PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(req);
            ps.setInt(1,produit);
       ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeservice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
               
    }
   public void supprimerC(int idcommande) {
          String req = "delete from lignecommande where "
                + "idcommande= ? ";
        
       PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(req);
            ps.setInt(1,idcommande);
       ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LigneCommandeservice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
               
    }



public Double calculerTotal(int idcommande) {
   double TotalX=0;
            ObservableList<LigneCommande>  lignecommande= FXCollections.observableArrayList();
     
        String requete = "SELECT * FROM `lignecommande` WHERE `idcommande` = ?;";
      
 PreparedStatement ps;
    try {
        ps = mycon.prepareStatement(requete);
         ps.setInt(1,idcommande);
            ResultSet res = ps.executeQuery();
            Produit p=new Produit();
            ProduitService pS=new ProduitService();
           
          
            while (res.next()) {
                
                p= pS.chercheproduit(res.getInt("idproduit"));
                LigneCommande c;
                c = new LigneCommande(res.getInt("id"),
                        res.getInt("idcommande"),
                         p,
                         res.getInt("quantite"),
                         res.getDouble("total"),res.getFloat("prix"));
                TotalX=res.getDouble("total")+TotalX ;

            

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return TotalX ;
    }

  public ObservableList<LigneCommande> findResponsable(String search) throws SQLException {
  
      

          
            String requete = "select * from lignecommande where id like '%"+search+"%' or idcommande like '%"+search+"%' or idproduit like '%"+search+"%' or quantite like '%"+search+"%' or total like '%"+search+"%' or promo like '%"+search+"%' or prix like '%"+search+"%' ;";


            ObservableList<LigneCommande> listcommande = FXCollections.observableArrayList();  
            
            
            //ResultSet resultat = statement.executeQuery(requete);
            PreparedStatement ps;

        ps = mycon.prepareStatement(requete);
      
            ResultSet res = ps.executeQuery();
            Produit p=new Produit();
            ProduitService pS=new ProduitService();
    
            while (res.next()) {

               

  p= pS.chercheproduit(res.getInt("idproduit"));
           LigneCommande c;
                c = new LigneCommande(res.getInt("id"),
                        res.getInt("idcommande"),
                         p,
                         res.getInt("quantite"),
                         res.getDouble("total"),res.getFloat("prix"));
                 listcommande.add(c);
                }
          
        return listcommande;         
  }
           
 
    
}
  















