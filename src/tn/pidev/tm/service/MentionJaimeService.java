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
import tn.pidev.tm.entite.Mentionjaime;
import tn.pidev.tm.entite.Produit;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author Houssem
 */
public class MentionJaimeService {
   Connection mycon;
    public MentionJaimeService() {  

    
    mycon = MybdConnection.getInstanceBD().getConnection();

    }
    PreparedStatement st;


    public void ajouter_jaime(Mentionjaime mj) {
        try {
            String req = "INSERT INTO mention_jaime"
                    + " VALUES(?,?)";
            st = mycon.prepareStatement(req);
            st.setInt(1, mj.getProduit().getId());
            st.setInt(2, mj.getClient().getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MentionJaimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimer_jaime(Mentionjaime mj ) {
        try {
            String req = "DELETE FROM mention_jaime"
                    + " WHERE id_produit=? and id_client=?";
       st = mycon.prepareStatement(req);
            st.setInt(1, mj.getProduit().getId());
            st.setInt(2, mj.getClient().getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MentionJaimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public  List<Mentionjaime> list_jaimes_employe(Client clt) {

        try {
            ResultSet rs;
            String req = "SELECT * FROM mention_jaime WHERE id_client=" + clt.getId();
            List<Mentionjaime> p = new ArrayList<>();
            PreparedStatement stt;
            stt= mycon.prepareStatement(req);
ClientService cs=new ClientService();
 ProduitService ps=new ProduitService();
            rs = stt.executeQuery(req);
            while (rs.next()) {
                Mentionjaime jaime = new Mentionjaime(cs.chercherId(rs.getInt(1)),
                        ps.chercheproduit(rs.getInt(2)));
                p.add(jaime);
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(MentionJaimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public  List<Mentionjaime> list_jaimes_publication(Produit pub) {

        try {
            ResultSet rs;
            String req = "SELECT * FROM mention_jaime WHERE id_pub=" + pub.getId();
            List<Mentionjaime> e = new ArrayList<>();
            //PreparedStatement stt;
         PreparedStatement stt;
            stt= mycon.prepareStatement(req);
ClientService cs=new ClientService();
 ProduitService ps=new ProduitService();
            rs = stt.executeQuery(req);
            while (rs.next()) {
                Mentionjaime jaime = new Mentionjaime(cs.chercherId(rs.getInt(1)),
                        ps.chercheproduit(rs.getInt(2)));
                e.add(jaime);
            }
           
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(MentionJaimeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
}
