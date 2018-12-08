/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;
import java.util.Date ;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.Objects;
/**
 *
 * @author ADMIN
 */
public class Promotion {
    
    private int id;
    private String nom;
    private String description;
    private double prix;
    private String date_expiration;
    private String date_creation;
    private int quantite;
    private String image ;
    private Enseigne prod;

    public Promotion() {
    }

    public Promotion(int id, String nom, String description, double prix, String date_expiration, String date_creation, int quantite, String image, Enseigne prod) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.date_expiration = date_expiration;
        this.date_creation = date_creation;
        this.quantite = quantite;
        this.image = image;
        this.prod = prod;
    }

    public Promotion(String nom, String description, double prix, String date_expiration, int quantite, String image, Enseigne prod) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.date_expiration = date_expiration;
        this.quantite = quantite;
        this.image = image;
        this.prod = prod;
    }
    

    public Promotion(String nom, String description, double prix, String date_expiration, String date_creation, int quantite, String image, Enseigne prod) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.date_expiration = date_expiration;
        this.date_creation = date_creation;
        this.quantite = quantite;
        this.image = image;
        this.prod = prod;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(String date_expiration) {
        this.date_expiration = date_expiration;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Enseigne getProd() {
        return prod;
    }

    public void setProd(Enseigne prod) {
        this.prod = prod;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", date_expiration=" + date_expiration + ", date_creation=" + date_creation + ", quantite=" + quantite + ", image=" + image + ", prod=" + prod + '}';
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Promotion other = (Promotion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date_expiration, other.date_expiration)) {
            return false;
        }
        if (!Objects.equals(this.date_creation, other.date_creation)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.prod, other.prod)) {
            return false;
        }
        return true;
    }
    

 
    
 /*public java.sql.Date getDate() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Date(date_expiration.getTime());
} */
    public java.sql.Date convert(String date)throws ParseException
    {
    SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date date1=sdf1.parse(date);
    java.sql.Date sqldate= new java.sql.Date(date1.getTime());
    return sqldate;
    
    }
    public static String convert(java.sql.Date d) {
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        String text = df.format(d);
        return text;
    }

    /**
     *
     * @param date
     * @return
     */
    public java.sql.Date convert(java.util.Date date) {
    return new java.sql.Date(date.getTime());
}
  
  
    public String convertdate(Date indate)
{
   String dateString = null;
   SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
   /*you can also use DateFormat reference instead of SimpleDateFormat 
    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
    */
   try{
	dateString = sdfr.format( indate );
   }catch (Exception ex ){
	System.out.println(ex);
   }
   return dateString;
}
    
public  java.util.Date convertFromSQLDateToJAVADate(
            java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
 public static java.sql.Time toSqlTime(LocalTime localTime) {
    return java.sql.Time.valueOf(localTime);
  }

    
    
}
