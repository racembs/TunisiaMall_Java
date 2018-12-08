/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.service;

import java.util.Date;
import java.text.ParseException;
import tn.pidev.tm.utils.MybdConnection;
import tn.pidev.tm.entite.Promotion;
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
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import tn.pidev.tm.entite.Enseigne;
import tn.pidev.tm.entite.Produit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azuz
 */
public class PromotionService implements Iservice<Promotion> {

    Connection mycon;

    public PromotionService() {
        mycon = MybdConnection.getInstanceBD().getConnection();

    }

    @Override
    public boolean inserer(Promotion p) throws SQLException {
        Date d1 = new Date();

        try {
            Date d2 = p.convertFromSQLDateToJAVADate(p.convert(p.getDate_expiration()));

            if (d1.compareTo(d2) < 0) {
                String req1 = "INSERT INTO `promotion` "
                        + "(`nom`, `description`, `Prix`, `date_expiration`, `date_creation`, `quantitÃ©`, `image`, `idEnseignePromo`)"
                        + " VALUES ('"+ p.getNom() + "', '" + p.getDescription() + "', '" + p.getPrix()+ "', '" + p.convert(p.getDate_expiration()) + "', '"
                        + p.convert(d1) + "', '" + p.getQuantite() + "', '"
                        + p.getImage() + "', '"
                        + p.getProd().getId()+"'); ";

                Statement ste = mycon.createStatement();
                int x = ste.executeUpdate(req1);

                return true;
            }
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }

    @Override
    public boolean modifier(Promotion p) throws SQLException {

        String req2;
        try {
            req2 = "UPDATE `promotion` SET `nom` = '" + p.getNom() + "', `description` = '" + p.getDescription() + "', `date_expiration` = '" + p.convert(p.getDate_expiration()) + "', `quantitÃ©` = '" + p.getQuantite()+"', `image` = '" + p.getImage()+"', `idEnseignePromo` = '" + p.getProd().getId()+"' where id='" + p.getId() + "';";
            Statement ste2 = mycon.createStatement();
            int x = ste2.executeUpdate(req2);

        } catch (ParseException ex) {
            System.out.println(ex.getMessage());;
        }

//int rowsUpdated = statement.executeUpdate();
//if (rowsUpdated > 0) {
//    System.out.println("An existing user was updated successfully!");
//}
        return true;
    }


    public boolean modifierQuantite(int diff,int id) throws SQLException {

     
       
              String req2= "UPDATE `promotion` SET quantité='" +diff+ "' where id='" +id+ "';";
       
            Statement ste2 = mycon.createStatement();
            int x = ste2.executeUpdate(req2);

     

//int rowsUpdated = statement.executeUpdate();
//if (rowsUpdated > 0) {
//    System.out.println("An existing user was updated successfully!");
//}
        return true;
    }

    
    @Override
    public boolean supprimer(Promotion p) throws SQLException {

        String req = "delete from promotion where "
                + "id= ? ";

        PreparedStatement ps = mycon.prepareStatement(req);
        ps.setInt(1, p.getId());
        ps.executeUpdate();
        return true;

    }

    @Override
    public void Afficher() throws SQLException {

        String req1 = "select * from promotion";

        Statement ste = mycon.createStatement();
        ResultSet res = ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("promo est "
                    + res.getInt("id")
                    + " " + res.getString("nom")
                    + " " + res.getString("description") + " " + Promotion.convert(res.getDate("date_expiration")) + " " + Promotion.convert(res.getDate("date_creation")));

        }
    }

//    public boolean supprimerEXPIREE(Promotion p) throws SQLException {
//
//        Date d = new Date();
//        try {
//            Date d2 = p.convertFromSQLDateToJAVADate(p.convert(p.getDate_expiration()));
//
//            if (d.compareTo(d2) > 0) {
//                String req = "delete from promotion where id='" + p.getId() + "';";
//
//                Statement ste2 = mycon.createStatement();
//                int x = ste2.executeUpdate(req);
//                return true;
//
//            }
//        } catch (ParseException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return true;
//    }

    public    ObservableList<Promotion> getAll() {
       ObservableList<Promotion> promos =FXCollections.observableArrayList();
        String req = "select * from promotion";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Promotion promo;
                ServiceEnseigne pros=new ServiceEnseigne();
                Enseigne prod=new Enseigne();
                prod=pros.chercherens(res.getInt("idEnseignePromo"));
                 
            promo = new Promotion(res.getInt("id"), res.getString("nom"), res.getString("description"), res.getDouble("Prix"), Promotion.convert(res.getDate("date_expiration")), Promotion.convert(res.getDate("date_creation")), res.getInt("quantité"), res.getString("image"),prod);
           promos.add(promo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promos;
    }
public ObservableList<Promotion>  getAllbyString(String r) {
             ObservableList<Promotion> promos =FXCollections.observableArrayList();
         String req = "select * from promotion where nom LIKE '%"+r+"%'"+" or description LIKE '%"+r+"%'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Promotion promo;
                ServiceEnseigne pros=new ServiceEnseigne();
                Enseigne prod=new Enseigne();
                prod=pros.chercherens(res.getInt("idEnseignePromo"));
             promo = new Promotion(res.getInt("id"), res.getString("nom"), res.getString("description"), res.getDouble("Prix"), Promotion.convert(res.getDate("date_expiration")), Promotion.convert(res.getDate("date_creation")), res.getInt("quantitÃ©"), res.getString("image"),prod);
           promos.add(promo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promos;
    }
  public List<Promotion> getAllorderByDateASC() throws SQLException
  {
        List<Promotion>  promos = new ArrayList<>();
        String req = "select * from promotion Order by date_expiration asc";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Promotion promo;
       ServiceEnseigne pros=new ServiceEnseigne();
                Enseigne prod=new Enseigne();
                prod=pros.chercherens(res.getInt("idEnseignePromo"));
             promo = new Promotion(res.getInt("id"), res.getString("nom"), res.getString("description"), res.getDouble("Prix"), Promotion.convert(res.getDate("date_expiration")), Promotion.convert(res.getDate("date_creation")), res.getInt("quantitÃ©"), res.getString("image"),prod);
           promos.add(promo);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return  promos;   
    } 
               
  
  
  
      public int CalculP() throws SQLException {
         String sql = "SELECT * FROM promotion";
        
      
     Statement statement = mycon.createStatement(); 
     statement.setFetchSize(0);
     
     
ResultSet resultat = statement.executeQuery(sql); 

int n=0;
while (resultat.next()) {
   n=n+1;
  
}
 //System.out.println(n);
  
 return n;
 
//statement.close();


//ResultSetMetaData metadata = resultat.getMetaData(); 
//int nombreColonnes = metadata.getColumnCount(); 
//System.out.println("Ce ResultSet contient "+nombreColonnes+" colonnes.");





    }     

      
  
  
//    public Promotion findByNom(String r) {
//        Promotion c = null;
//        String req = "select * from promotion where nom LIKE '%"+r+"%'"+" or description LIKE '%"+r+"%'";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = mycon.prepareStatement(req);
////            preparedStatement.setString(2,r);
//            ResultSet res = preparedStatement.executeQuery();
//            while (res.next()) {
//                c = new Promotion(res.getInt("id"), res.getString("nom"), res.getString("description"), res.getFloat("tauxRed"), Promotion.convert(res.getDate("date_expiration")), Promotion.convert(res.getDate("date_creation")), res.getInt("quantitÃ©"), res.getString("image"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return c;
//    }

//  public Promotion findByDescrip(String r) {
//      
//        Promotion  c = null;
//        String req = "select * from users where id=?";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = mycon.prepareStatement(req);
//            //preparedStatement.setString(3,r);
//            ResultSet res = preparedStatement.executeQuery();
//            if (r.lastIndexOf(res.getString("description"))==-1)
//            { while (res.next()) {
//                c = new Promotion(res.getInt("id"), res.getString("nom"), res.getString("description"),res.getFloat("tauxRed"), Promotion.convert(res.getDate("date_expiration")), Promotion.convert(res.getDate("date_creation")),res.getInt("quantitÃ©"),res.getString("image"));
//            }}
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return c;   
//    }
  
      public ObservableList<Promotion> getAllNonExpiree() throws SQLException{
        ObservableList<Promotion> promos =FXCollections.observableArrayList();
        String req = "select * from promotion where date_expiration >= Now() ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Promotion promo;
          ServiceEnseigne pros=new ServiceEnseigne();
                Enseigne prod=new Enseigne();
                prod=pros.chercherens(res.getInt("idEnseignePromo"));
             promo = new Promotion(res.getInt("id"), res.getString("nom"), res.getString("description"), res.getDouble("Prix"), Promotion.convert(res.getDate("date_expiration")), Promotion.convert(res.getDate("date_creation")), res.getInt("quantitÃ©"), res.getString("image"),prod);
           promos.add(promo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promos;
    }
}
