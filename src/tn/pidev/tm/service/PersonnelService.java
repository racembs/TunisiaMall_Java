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
import tn.pidev.tm.entite.Personnel;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author IMC
 */
public class PersonnelService implements Iservice<Personnel>{
    Connection mycon;

    public PersonnelService() {
       
    mycon = MybdConnection.getInstanceBD().getConnection();
}
    
    @Override
    public boolean inserer(Personnel p) throws SQLException {
        String req1 = "INSERT INTO `personne` "
               + "(`id`,`nom`,`prenom`,`email`,`cin`,`username`,`password`,`salaire`,`poste`,`role`)"
               + " VALUES ('"+p.getId()+"', '"
               +p.getNom()+"', '" +p.getPrenom()+"', '" +p.getMail()+"', '" +p.getCin()+"', '" +p.getUsername()+"', '" 
               +p.getPassword()+"', '" +p.getSalaire()+"','" +p.getPoste()+"','personnel'); "; 
       
       Statement ste = mycon.createStatement();
       int x = ste.executeUpdate(req1);
      
       
       
       return true;
    }
     @Override
    public boolean modifier(Personnel p) throws SQLException {
       
            
            
               String sql="UPDATE `personne` SET `nom` = '"+p.getNom()+"',`prenom`= '"+p.getPrenom()+"', `email` = '"+p.getMail() +"' where id='" +p.getId()+"';";
              PreparedStatement statement = mycon.prepareStatement(sql);
//statement.setString(1, p.getNom());
//statement.setString(2, p.getPrenom());
//statement.setString(3, p.getMail());
//statement.setString(4, p.getCin());
//statement.setString(5, p.getUsername());
//statement.setString(6, p.getPassword());
//statement.setDouble(7, p.getSalaire());
//statement.setString(8, p.getPoste());
//statement.setInt(9, p.getId());
               
             int x = statement.executeUpdate(sql);
      
        
        
        return true;
    }

    @Override
    public boolean supprimer(Personnel p) throws SQLException {
        String req="delete from personne where id='" +p.getId()+"';";
        Statement ste2 = mycon.createStatement();
               int x = ste2.executeUpdate(req);
        return true;
    }

    @Override
    public void Afficher() throws SQLException {
           String req1 = "select * from personne";
       
       Statement ste = mycon.createStatement();
       ResultSet res= ste.executeQuery(req1);
        while (res.next()) {
            System.out.println(res.getInt("id")
                    +" "+res.getString("nom")
                    +" "+ res.getString("prenom")
                    +" "+ res.getString("email")
                    +" "+ res.getString("cin")
                    +" "+ res.getString("username")
                    +" "+ res.getString("password")
                    +" "+ res.getFloat("salaire")
                    +" "+ res.getString("poste"));
            
        }
    }

      
}
