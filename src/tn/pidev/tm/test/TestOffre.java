/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.test;

import tn.pidev.tm.utils.MybdConnection;
import java.sql.Connection;
import java.sql.SQLException;
import jdk.nashorn.internal.objects.NativeDate;
import tn.pidev.tm.entite.Offre;

import tn.pidev.tm.service.OffreService;

/**
 *
 * @author ADMIN
 */
public class TestOffre {

    static Connection mycon;

    public static void main(String[] args) {

        try {
            mycon = MybdConnection.getInstanceBD().getConnection();

            Offre f = new Offre(5, "finance", "10/11/2017","10/10/2017","dfrrgtthyjyjukukk");
              //offreService.inserer(f);
  
             Offre f1 = new Offre(6, "resp rh", "25/11/2017","11/10/2017","fguigfuigfebdjcugdefdey");
          // f1.setId(1);
            OffreService offreService = new OffreService();
            offreService.inserer(f1);
                 offreService.Afficher();
            //offreService.supprimer(f);
            System.out.println("modifierrrrrrrrr");;
          //offreService.modifier(f1);
           
          
        offreService.Afficher();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
