/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.pidev.tm.entite.Client;
import tn.pidev.tm.entite.Commande;

import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.CommandeService;
import tn.pidev.tm.utils.MybdConnection;

/**
 *
 * @author RBS
 */
//public class testclient {
//    static Connection mycon;
//    public static void main(String[] args) throws SQLException  {
//         mycon = MybdConnection.getInstanceBD().getConnection();
//         List<Client> clients;
//     
//            Client c=new Client(23,"bensaid","racem","@gmail"
//                    ,"11070690","rbs","azerty",0,null,1000,"client");
//     Commande com=new Commande(69,4d,c,0,1);
//     
//            
//            CommandeService cs=new CommandeService();
//            cs.modifier(com);
            
//        try {
//             cs.Afficher();
//            
//            System.out.println("**************************insertion*************************");
//            if(cs.inserer(c)==false){
//                System.out.println("login exisitant");
//            }
//           // cs.ajouterpts(2,50);
//            cs.retirerrpts(2,50);
//             c.setId(1);
//           //  System.out.println(cs.inserer(c));
//           System.out.println("******************************chercher**************************");
//             c1=cs.chercherclient(2);
//             c=cs.chercherId(2);
//            System.out.println(c);
//            
//            clients=cs.getAll();
//            
//            /*for(int i=0;i<clients.size();i++){
//                System.out.println(clients.get(i));
//            }*/
//       
//                     
//             System.out.println("********************************modifer**************************");
//             if(cs.modifier(c)==false){
//                System.out.println("client n'existe pas");
//            }
//              cs.Afficher();
//            /* System.out.println("************supprimer***********");
//            // cs.supprimer(c);
//            
//             cs.Afficher();*/
//        } catch (SQLException ex) {
//           Logger.getLogger(testclient.class.getName()).log(Level.SEVERE, null, ex);
//            //ex.getMessage();
//        } 
       
        
//    }
//}
