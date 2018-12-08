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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.pidev.tm.service.ClientService;
import tn.pidev.tm.service.Iservice;
import tn.pidev.tm.service.ServiceEnseigne;

/**
 *
 * @author RBS
 */
public class CarteFidelite {
     private int id;
    private int nombreDePoints;
    private Enseigne enseigne;
    private Client client;

    public CarteFidelite() {
    }

    public CarteFidelite(int id, int nombreDePoints, Enseigne enseigne, Client client) {
        this.id = id;
        this.nombreDePoints = nombreDePoints;
        this.enseigne = enseigne;
        this.client = client;
    }
      public CarteFidelite(int nombreDePoints, Enseigne enseigne, Client client) {
     
        this.nombreDePoints = nombreDePoints;
        this.enseigne = enseigne;
        this.client = client;
    }
    
    Connection mycon;
   
    
    
    public int getId() {
        return id;
    }

    public int getNombreDePoints() {
        return nombreDePoints;
    }

    public Enseigne getEnseigne() {
        return enseigne;
    }

    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreDePoints(int nombreDePoints) {
        this.nombreDePoints = nombreDePoints;
    }

    public void setEnseigne(Enseigne enseigne) {
        this.enseigne = enseigne;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "CarteFidelite{" + "id=" + id + ", nombreDePoints=" + nombreDePoints + ", enseigne=" + enseigne + ", client=" + client + '}';
    }

   
     

   
    
    
}
