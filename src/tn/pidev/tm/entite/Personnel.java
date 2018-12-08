/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tn.pidev.tm.service.Iservice;

/**
 *
 * @author RBS
 */
public class Personnel extends Personne {
      
   
    private double salaire;
    private String poste;

    public Personnel() {
    }

    public double getSalaire() {
        return salaire;
    }

    public String getPoste() {
        return poste;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return super.toString()+ "Personnel{" + "salaire=" + salaire + ", poste=" + poste + '}';
    }
    
   

    
   

  

   
    
    //************************************************getter and setter*************************************************************

    public Personnel(double salaire, String poste) {
        this.salaire = salaire;
        this.poste = poste;
    }

    public Personnel(double salaire, String poste, int id, String nom, String mail, String cin, String username, String password) {
        super(id, nom, mail, cin, username, password);
        this.salaire = salaire;
        this.poste = poste;
    }

    public Personnel(double salaire, String poste, String username, String password) {
        super(username, password);
        this.salaire = salaire;
        this.poste = poste;
    }
    
    
    
    
}
