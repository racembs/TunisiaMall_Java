/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.test;

import tn.pidev.tm.utils.MybdConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.objects.NativeDate;
import tn.pidev.tm.entite.Promotion;
import tn.pidev.tm.service.PromotionService;

/**
 *
 * @author ADMIN
 */
//public class TestTM {
//
//    static Connection mycon;
//
//    public static void main(String[] args) {
//
//        try {
//            mycon = MybdConnection.getInstanceBD().getConnection();
//
//            Promotion p = new Promotion(1702, "blackfriday", "a ne pas rater" ,0.2f,"10/11/2017","10/10/2017",12,"url image");
//              //promoService.insererProduit(p);
//  
//            Promotion p1 = new Promotion(5, "theNewblack", "a ne pas rater" ,0.2f,"10/01/2017","10/12/2017",12,"url image");
//          // p1.setId(1);
//            PromotionService promoService = new PromotionService();
//         // promoService.inserer(p);
//                // promoService.Afficher();
//            //promoService.supprimer(p);
//            System.out.println("modifierrrrrrrrr");;
//      promoService.supprimerEXPIREE(p1);
//            List<Promotion> promos = new ArrayList<>(); 
//          promos=promoService.getAll();
//            System.out.println(promos);
//       // promoService.Afficher();
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//}
