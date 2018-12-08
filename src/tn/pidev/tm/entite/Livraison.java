/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tn.pidev.tm.entite;

/**
 *
 * @author HP-PC
 */

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author HP-PC
 */
public class Livraison extends Commande{
    
    private String adresse;
    private String DateLivraison;
    private String Etat;
    
    
public Livraison() {
        
    }
 


    public Livraison(int id, Double total, Client client, int paiment, int livraison, String adresse, String DateLivraison, String Etat) {
        super(id, total, client, paiment, livraison);
        this.adresse = adresse;
        this.DateLivraison= DateLivraison;
        this.Etat= Etat;
    }

    

    public Livraison(Client client, Double total, int paiment, int livraison,String adresse, String DateLivraison,String Etat) {
        super(client, total, paiment, livraison);
        this.adresse = adresse;
        this.DateLivraison = DateLivraison;
        this.Etat = Etat;
    }

 

    
    
    
    
    public Livraison(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDateLivraison() {
        return DateLivraison;
    }

    public String getEtat() {
        return Etat;
    }

    public void setDateLivraison(String DateLivraison) {
        this.DateLivraison = DateLivraison;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }


 

   public java.sql.Date convert(String date)throws ParseException
    {
    SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date1=sdf1.parse(date);
    java.sql.Date sqldate= new java.sql.Date(date1.getTime());
    return sqldate;
    
    }

    @Override

   
    public String toString() {
        return super.toString()+"Livraison{" + "adresse=" + adresse + ", DateLivraison=" + DateLivraison + ", Etat=" + Etat + '}';
    }
  
    
    
    
}
