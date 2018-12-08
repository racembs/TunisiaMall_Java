/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Parking;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author ADMIN
 */
public class ParkingService implements Iservice<Parking> {
        Connection mycon;

    public ParkingService() {
        mycon = MybdConnection.getInstanceBD().getConnection();

    }
 public boolean inserer(Parking P)
 {
 return false;
 }

  
    public boolean insererPlace(int n) throws SQLException {
//        Client c= new Client (.....)
//       p.setC(c);

int id=2;

                String req1 = "INSERT INTO `parking` "
                        + "(`numPlaces`, `idClient`)"
                        + " VALUES ('"+n+ "','"+id+"'); ";

                Statement ste = mycon.createStatement();
                int x = ste.executeUpdate(req1);

           
        

        return false;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Parking p) throws SQLException {
       String req2= "UPDATE `parking` SET `numPlaces`='" + p.getNumPlace()+"',`idClient`='" +  p.getC().getId() + "',`heureEntree`='" +  p.gettE() + "',`heureSortie`='" +  p.gettS() + "',`datePark`='" + p.convert(p.getDatePark()) + "' where id='" + p.getId() + "';";
       
            Statement ste2 = mycon.createStatement();
            int x = ste2.executeUpdate(req2);
            return true;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Parking p) throws SQLException {
         String req = "delete from parking where "
                + "id= ? ";

        PreparedStatement ps = mycon.prepareStatement(req);
        ps.setInt(1, p.getId());
        ps.executeUpdate();
        return true;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Afficher() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      public    ObservableList<Parking> getAll() {
          
       ObservableList<Parking> promos =FXCollections.observableArrayList();
        String req = "select * from parking where heureEntree IS NOT NULL and heureSortie IS NOT NULL and datePark IS NOT NULL ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
               Parking promo;
  ClientService cs=new ClientService();
               Client cli=new Client();
               cli=cs.chercherId(res.getInt("idClient"));
               
  promo= new Parking(res.getInt("id"),res.getInt("numPlaces"),cli,res.getTime("heureEntree"),res.getTime("heureSortie"),res.getDate("datePark"));
                promos.add(promo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promos;
    }

      
         public   ObservableList<Parking> getAllNumPlace(java.util.Date d,Time t) throws ParseException {
       ObservableList<Parking> promos =FXCollections.observableArrayList();
       Parking p=new Parking();
      
        //String req = "select * from parking where heureSortie =< "+p.toSqlTime(He);
        //String req = "SELECT * FROM `parking` WHERE TIMEDIFF('heureSortie','"+java.sql.Time.valueOf(He)+"')= 0 and datePark='"+p.convert(d)+"'";
       //String req ="SELECT * FROM `parking` WHERE datePark='"+p.convert(d)+"' and heureSortie =<'"+t+"'";
          String req ="SELECT * FROM `parking` WHERE datePark >='"+p.convert(d)+"';";
       // String req = "SELECT * FROM `parking` WHERE  TIMESTAMPDIFF( MONTH , '2009-07-01', '2009-07-02' )";
        PreparedStatement preparedStatement;
        try {
              preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
     
           
            while (res.next()) {
                   if (res.getTime("heureSortie").compareTo(t)< 0)
                   {   Parking promo;
  ClientService cs=new ClientService();
               Client cli=new Client();
               cli=cs.chercherId(res.getInt("idClient"));
           
                promo= new Parking(res.getInt("id"), res.getInt("numPlaces"),cli,res.getTime("heureEntree"),res.getTime("heureSortie"),res.getDate("datePark"));
                promos.add(promo);

            }}
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promos;
    }   
      
//public ObservableList<Promotion>  getAllbyString(String r) {
//             ObservableList<Promotion> promos =FXCollections.observableArrayList();
//         String req = "select * from promotion where nom LIKE '%"+r+"%'"+" or description LIKE '%"+r+"%'";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = mycon.prepareStatement(req);
//            ResultSet res = preparedStatement.executeQuery();
//            while (res.next()) {
//                Promotion promo;
//                promo = new Promotion(res.getInt("id"), res.getString("nom"), res.getString("description"), res.getFloat("tauxRed"), Promotion.convert(res.getDate("date_expiration")), Promotion.convert(res.getDate("date_creation")), res.getInt("quantité"), res.getString("image"));
//                promos.add(promo);
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return promos;
//    }
    
    
    
    
    
    
    
}
