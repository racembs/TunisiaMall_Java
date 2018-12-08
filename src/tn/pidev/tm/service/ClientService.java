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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author RBS
 */
public class ClientService implements Iservice<Client>{
    Connection mycon;

    public ClientService() {
       
    mycon = MybdConnection.getInstanceBD().getConnection();
}
    
    @Override
    public boolean inserer(Client c) throws SQLException {
       
        String req1 = "INSERT INTO `personne` "
               + "(`id`,`nom`,`prenom`,`email`,`cin`,`username`,`password`,`role`,`EtatBlocage`,`code`)"
               + " VALUES (NULL,'"+c.getNom()+"', '" +c.getPrenom()+"', '" +c.getMail()+"', '" +c.getCin()+"', '" +c.getUsername()+"', '" 
               +c.getPassword()+"','client','nonbloque','"+c.getCode()+"'); "; 
       
       Statement ste1 = mycon.createStatement();
       int x = ste1.executeUpdate(req1);
      
               
      return true;
    }
     @Override
    public boolean modifier(Client c) throws SQLException {
       
                 String req2="UPDATE `personne` SET `nom` = '"+c.getNom()+"', `prenom` = '" +c.getPrenom()+"',"
                       + " `email` = '" +c.getMail()+"', `cin` = '" +c.getCin()+"', `username` = '" +c.getUsername()+"', `password` = '"+c.getPassword()+"', `role` = '" +c.getRole()+"', `EtatBlocage` = '" +c.getEtatBlocage()+"' where id='" +c.getId()+"';";
               Statement ste2 = mycon.createStatement();
               int x = ste2.executeUpdate(req2);
        
               
            
     
        
        return true;
    }
   
    public boolean modifiercode(Client c) throws SQLException {
       
                 String req2="UPDATE `personne` SET `nom` = '"+c.getNom()+"', `prenom` = '" +c.getPrenom()+"',"
                       + " `email` = '" +c.getMail()+"', `cin` = '" +c.getCin()+"', `username` = '" +c.getUsername()+"', `password` = '"+c.getPassword()+"', `role` = '" +c.getRole()+"', `EtatBlocage` = '" +c.getEtatBlocage()+"', `code` = '" +c.getCode()+"' where id='" +c.getId()+"';";
               Statement ste2 = mycon.createStatement();
               int x = ste2.executeUpdate(req2);
        
               
            
     
        
        return true;
    }

    
   

    @Override
    public void Afficher() throws SQLException {
    
    }
    
    public Client chercherclient(String id) throws SQLException {
      Client c=new Client();

        String req = "select * from personne where id ='"+id+"';";
         Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
       while (res.next()) {
           if(Integer.toString(res.getInt("id")).equals(id)){
                c.setId(res.getInt("id"));
                c.setNom(res.getString("nom"));
                c.setPrenom(res.getString("prenom"));
                c.setMail(res.getString("email"));
                c.setCin(res.getString("cin"));
                c.setUsername(res.getString("username"));
                c.setPassword(res.getString("password"));
                c.setRole(res.getString("role"));
                c.setEtatBlocage(res.getString("EtatBlocage"));
                
           }
       
       }
        
        return c;
    }
      public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        String req = "select * from personne where role='client'";
        
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
                Client c;
                c = new Client(res.getInt("id")
                    ,res.getString("nom")
                    ,res.getString("prenom")
                    ,res.getString("email")
                    ,res.getString("cin")
                    ,res.getString("username")
                    ,res.getString("password")
        ,res.getString("role"));
                clients.add(c);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;   
    }
    public Client chercherclientbylogin(String login) throws SQLException {
      Client c=new Client();
  String req = "select * from personne where username ='"+login+"';";
         Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
       while (res.next()) {
           if(res.getString("username").equals(login)){
                c.setId(res.getInt("id"));
                c.setNom(res.getString("nom"));
                c.setPrenom(res.getString("prenom"));
                c.setMail(res.getString("email"));
                c.setCin(res.getString("cin"));
                c.setUsername(res.getString("username"));
                c.setPassword(res.getString("password"));
                c.setRole(res.getString("role"));
                c.setEtatBlocage(res.getString("EtatBlocage"));
                 c.setCode(res.getString("code"));
                
           }
       
       }
        
        return c;
    }
    
        public ObservableList<Client> getAllClient() {
        ObservableList<Client> clients = FXCollections.observableArrayList();
        String req = "select * from personne where role='client'";
        
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
                Client c;
                c = new Client(res.getInt("id")
                    ,res.getString("nom")
                    ,res.getString("prenom")
                    ,res.getString("email")
                    ,res.getString("cin")
                    ,res.getString("username")
                    ,res.getString("password")
                    ,res.getString("role")
                    ,res.getString("EtatBlocage"));
                clients.add(c);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;   
    }
        
        
         //filter le tableau
        public ObservableList<Client> getListeByString(String chercher) {
        ObservableList<Client> clients = FXCollections.observableArrayList();
        String req = "SELECT * FROM `personne` WHERE `role`='client' and nom LIKE '%"+chercher+"%' OR  prenom LIKE '%"+chercher+"%'OR email LIKE '%"+chercher+"%' OR username LIKE '%"+chercher+"%' ";
        
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
               
               
                     Client c;
                c = new Client(res.getInt("id")
                    ,res.getString("nom")
                    ,res.getString("prenom")
                    ,res.getString("email")
                    ,res.getString("cin")
                    ,res.getString("username")
                    ,res.getString("password")
                    ,res.getString("role")
                    ,res.getString("EtatBlocage"));
                
                clients.add(c);
                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;   
    }
        
        public Client chercherId(Integer id) {
        Client  c = null;
        String req = "select * from personne where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = mycon.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                
                c = new Client(res.getInt("id")
                    ,res.getString("nom")
                    ,res.getString("prenom")
                    ,res.getString("email")
                    ,res.getString("cin")
                    ,res.getString("username")
                    ,res.getString("password")
                    ,res.getString("role")
                    ,res.getString("EtatBlocage"));
                
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;   
    }
        
         public Client chercherclient(int id) throws SQLException {
      Client c=new Client();

        String req = "select * from personne where id ='"+id+"' and role='client';";
         Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
       while (res.next()) {
           if(res.getInt("id")==id){
                c.setId(id);
                c.setNom(res.getString("nom"));
                c.setPrenom(res.getString("prenom"));
                c.setMail(res.getString("email"));
                c.setCin(res.getString("cin"));
                c.setUsername(res.getString("username"));
                c.setPassword(res.getString("password"));
           
                c.setRole(res.getString("role"));
                
           }
       
       }
        
        return c;
    }
        
         public boolean clientexiste(Client c) throws SQLException {
        boolean b=true;
        String req = "select * from personne where role='client'";
       
       Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req);
        while (res.next()) {
         if(res.getString("username").equals(c.getUsername())||res.getString("email").equals(c.getMail())){
             b=false;
         }   
        }
        return b;
         }
         
         
         
         
        //afficher tableau par id 
        public ObservableList<Client> getListeById(String id) {
        ObservableList<Client> clients = FXCollections.observableArrayList();
        String req = "select * from personne where role='client'";
        
        try {
            Statement ste = mycon.createStatement();
            ResultSet res= ste.executeQuery(req);
            while (res.next()) {
               
                if(Integer.toString(res.getInt("id")).equals(id)){
                     Client c;
                c = new Client(res.getInt("id")
                    ,res.getString("nom")
                    ,res.getString("prenom")
                    ,res.getString("email")
                    ,res.getString("cin")
                    ,res.getString("username")
                    ,res.getString("password")
                    ,res.getString("role"));
                
                clients.add(c);
                }
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;   
    }
        

        
                public int CalculP() throws SQLException {
         String sql = "SELECT * FROM personne WHERE role='client'";
        
      
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
     
    @Override
    public boolean supprimer(Client p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      
}
