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

import tn.pidev.tm.entite.Enseigne;

import tn.pidev.tm.entite.PropEnseigne;
import tn.pidev.tm.utils.MybdConnection;


/**
 *
 * @author Dhouha
 */
public class ServiceEnseigne implements Iservice<Enseigne>{
     Connection mycon;


    public ServiceEnseigne() {
         mycon = MybdConnection.getInstanceBD().getConnection();
    }

    @Override
    public boolean inserer(Enseigne e) throws SQLException {
            String req1= "INSERT INTO `enseigne` "
               + "(`id`,`nom`,`description`,`idproprietaire`,`categorie`,`capaciteMax`,`capacite`)"
               + " VALUES ('"+e.getId()+"', '"
               +e.getNom()+"', '" +e.getDescription()+"', '" +e.getResponsableEnseigne().getId()+"', '" +e.getCategorie()+"', '" +e.getCapacité()+"', '" 
               +e.getCapacité()+"'); "; 
       Statement ste = mycon.createStatement();
       int x = ste.executeUpdate(req1);
                   
       return true;
    }

    @Override
    public boolean modifier(Enseigne e) throws SQLException {
          String req2;
      
            req2 ="UPDATE `enseigne`  SET nom = '"+e.getNom()+"', description = '"+e.getDescription()+"', idproprietaire = '"+e.getResponsableEnseigne().getId()+"', categorie = '"+e.getCategorie()+"', capaciteMax = '"+e.getCapaMax()+"', capacite = '"+e.getCapacité()+"' where id='" +e.getId()+"';";
            Statement ste2 = mycon.createStatement();
            int x = ste2.executeUpdate(req2);

      return true;
 //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Enseigne p) throws SQLException {
          String req="delete from enseigne where id=" +p.getId();
        Statement ste2 = mycon.createStatement();
               int x = ste2.executeUpdate(req);
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Afficher() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
        public List<Enseigne> getAll() {
        List<Enseigne> promos = new ArrayList<>();
        String req = "select * from enseigne";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Enseigne promo;
                promo = new Enseigne(res.getInt("id"), res.getString("nom"), res.getString("description"));
                promos.add(promo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promos;
    }
        
      
      public Enseigne chercherId(Integer id) {
          Enseigne en=new Enseigne();
        String req = "select * from enseigne where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                
                en = new Enseigne(res.getInt("id")
                    ,res.getString("nom")
                    ,res.getString("description")
                    ,res.getString("categorie")
                    ,res.getInt("capaciteMax")
                    ,res.getInt("capacite")
                    ,res.getFloat("pourcentagefidalite"));
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return en;   
    }
      
         public List<String> getAllNomEnseigne() {
        List<String> promos = new ArrayList<>();
        String req = "select * from enseigne";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                Enseigne promo;
                promo = new Enseigne(res.getInt("id"), res.getString("nom"), res.getString("description"));
                promos.add(promo.getNom());

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return promos;
    }

         
                  public int CalculP() throws SQLException {
         String sql = "SELECT * FROM enseigne";
        
      
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
                  
                  
                  
                  
                        public Enseigne cherchernom(String nom) throws SQLException {
      Enseigne c=new Enseigne();
               PropEnseigne pe=new PropEnseigne();
            
        String req = "select * from enseigne where nom ='"+nom+"';";
         Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
       
       while (res.next()) {
           if(res.getString("nom").equals(nom)){
                
                c.setId(res.getInt("id"));
                c.setNom(nom);
                       
                c.setDescription(res.getString("description"));
                pe.setId(res.getInt("idproprietaire"));
                c.setCategorie(res.getString("categorie"));
                c.setCapaMax(res.getInt("capaciteMax"));
                c.setCapacité(res.getInt("capacite"));
              c.setResponsableEnseigne(pe);
                
           }
       
       }
        return c;
    }
         
                       
           public Enseigne chercherEns(String ense) throws SQLException {
      Enseigne c=new Enseigne();
               PropEnseigne pe=new PropEnseigne();
            
        String req = "select * from enseigne where nom ='"+ense+"';";
         Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
       
       while (res.next()) {
         
                
                c.setId(res.getInt("id"));
                c.setNom(res.getString("nom"));
                c.setDescription(res.getString("description"));
          pe.setId(res.getInt("idproprietaire"));
                c.setCategorie(res.getString("categorie"));
                c.setCapaMax(res.getInt("capaciteMax"));
                c.setCapacité(res.getInt("capacite"));
              c.setResponsableEnseigne(pe);
                
          
       
       }
         return c;
           } 
  
         
           public Enseigne chercherens(int id) throws SQLException {
      Enseigne c=new Enseigne();
               PropEnseigne pe=new PropEnseigne();
            
        String req = "select * from enseigne where id ='"+id+"';";
         Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
       
       while (res.next()) {
           if(res.getInt("id")==id){
                
                c.setId(id);
                c.setNom(res.getString("nom"));
                c.setDescription(res.getString("description"));
          pe.setId(res.getInt("idproprietaire"));
                c.setCategorie(res.getString("categorie"));
                c.setCapaMax(res.getInt("capaciteMax"));
                c.setCapacité(res.getInt("capacite"));
              c.setResponsableEnseigne(pe);
                
           }
       
       }
        
        return c;
    }
     

           
           
           
}
