/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;
import java.util.Date ;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/**
 *
 * @author ADMIN
 */
public class Offre {
    
     private int id;
    private String poste;
    
    
    private String date_experation;
    private String date_poste;
    private String description;
    
    
    

    public Offre() {
    }

    public Offre(int id, String poste, String date_experation, String date_poste, String description) {
        this.id = id;
        this.poste = poste;
        this.date_experation = date_experation;
        this.date_poste = date_poste;
        this.description = description;
       
    }

    public int getId() {
        return id;
    }

    public String getPoste() {
        return poste;
    }

    public String getDate_experation() {
        return date_experation;
    }

    public String getDate_poste() {
        return date_poste;
    }

    public String getDescription() {
        return description;
    }

   

    public void setId(int id) {
        this.id = id;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setDate_experation(String date_experation) {
        this.date_experation = date_experation;
    }

    public void setDate_poste(String date_poste) {
        this.date_poste = date_poste;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", poste=" + poste + ", description=" + description + '}';
    }
     @Override
    public boolean equals(Object o){ 
        if (o instanceof Offre) {
             Offre f =  (Offre)o;
        
        if(this.id ==f.id && this.poste.equals(f.poste) )
            return true;
        }
      return false;
    }
    
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
    
}