///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tn.pidev.tm.test;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import tn.pidev.tm.entite.Client;
//import tn.pidev.tm.entite.Commande;
//import tn.pidev.tm.service.AdminService;
//import tn.pidev.tm.service.CommandeService;
//import tn.pidev.tm.service.ConnexionService;
//import tn.pidev.tm.service.LigneCommandeservice;
//import tn.pidev.tm.utils.MybdConnection;
//
///*import tn.esprit.utils.MybdConnection;*/
///**
// *
// * @author Asus
// */
//public class TestCommande {  static Connection mycon;
//    public static void main(String[] args) throws SQLException {
////             mycon = MybdConnection.getInstanceBD().getConnection();
//// Client c1=new Client("bensaid","racem","@gmail"
////                    ,"11070690","rbs","azerty",0,null,1000,"client");
////           
////        Commande c=new Commande(69,1d,c1,1,1);
////        CommandeService cs=new CommandeService();
////        cs.modifier(c);
////        List<Commande> commandes;
//
////   cs.inserer(c);
////  System.out.println("***********ajouter************");
//       //cs.supprimer(c);
//
//                //System.out.println("***********modifer************");
//               //cs.modifier(c);
//               
////            int co = cs.getidc(25);
////            System.out.println("ehoooooooooooooo");
////             System.out.println(co);
////                    commandes=cs.getAll();
////   for (int i = 0; i < commandes.size(); i++) {
////         System.out.println(commandes.get(i));
////             }
//////        
//LigneCommandeservice P = new LigneCommandeservice();
//        CommandeService cs= new CommandeService();
//      AdminService adminservice =new   AdminService();
//ConnexionService co=new ConnexionService();
//
//String usrname=co.getAll().getLogin();
//
//   int  idclient= adminservice.idclient(usrname);
// int idcommande =cs.getidc(idclient);
//        System.out.println(idcommande);
//
//           
//  
//    }
//}
//
