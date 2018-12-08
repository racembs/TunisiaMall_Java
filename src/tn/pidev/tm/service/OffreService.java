/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.service;

import java.util.Date;
import java.text.ParseException;
import tn.pidev.tm.utils.MybdConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tn.pidev.tm.entite.Offre;
/**
 *
 * @author imc
 */
public class OffreService implements Iservice<Offre>{
    Connection mycon;

    public OffreService() {
        mycon = MybdConnection.getInstanceBD().getConnection();

    }

    @Override
    public boolean inserer(Offre f) throws SQLException {
        try {
            String req1 = "INSERT INTO `offresemplois` "
                    + "(`id`, `poste`, `date_experation`, `date_poste`, `description`)"
                    + " VALUES ('" + f.getId() + "', '" + f.getPoste() + "', '" + f.convert(f.getDate_experation()) + "', '" + f.convert(f.getDate_poste()) + "', '"
                    + (f.getDescription()) + "'); ";
            Statement ste = mycon.createStatement();
            int x = ste.executeUpdate(req1);

            return true;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean modifier(Offre f) throws SQLException {
        String req2="UPDATE `offresemplois` SET `poste` = '"+f.getPoste()+"', `description` = '"+f.getDescription()+"' where id='" +f.getId()+"';";
               Statement ste2 = mycon.createStatement();
               int x = ste2.executeUpdate(req2);
               
            
      
        
        
       
        

//int rowsUpdated = statement.executeUpdate();
//if (rowsUpdated > 0) {
//    System.out.println("An existing user was updated successfully!");
//}
        return true;
    }

    @Override
    public boolean supprimer(Offre f) throws SQLException {
        String req = "delete from offresemplois where "
                + "id= ? ";

        PreparedStatement ps = mycon.prepareStatement(req);
        ps.setInt(1, f.getId());
        ps.executeUpdate();
        return true;
    }

    @Override
    public void Afficher() throws SQLException {
        String req1 = "select * from offresemplois";

        Statement ste = mycon.createStatement();
        ResultSet res = ste.executeQuery(req1);
        while (res.next()) {
            System.out.println("offre est "
                    + res.getInt("id")
                    + " " + res.getString("poste")
                    + " " + res.getString("description") + " " + Offre.convert(res.getDate("date_experation")));

    }
    }  
}
