/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;

import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class LigneCommande {
    private int id ;
    private int idcommande;
     private Produit produit;
      private int quantite;
     private double total;
private double prix;

    public LigneCommande() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }
public LigneCommande(int id, int idcommande, Produit produit, int quantite, double total, double prix) {
        this.id = id;
        this.idcommande = idcommande;
        this.produit = produit;
        this.quantite = quantite;
        this.total = total;
        this.prix = prix;
    } 

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    
 
     
    
     public boolean equals(Object o){ 
        if (o instanceof LigneCommande) {
             LigneCommande c =  (LigneCommande)o;
        
        if(this.id ==c.id &&this.idcommande==c.idcommande&&this.produit==produit&& this.quantite==c.quantite 
                &&this.total==c.total )
            return true;
        }
      return false;
    }

    

    @Override
    public String toString() {
        return "LigneCommande{" + "id=" + id + ", idcommande=" + idcommande + ", produit=" + produit + ", quantite=" + quantite + ", total=" + total + ", prix=" + prix + '}';
    }
     
     
}
