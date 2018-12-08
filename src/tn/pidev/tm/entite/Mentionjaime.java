/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;

import java.util.Objects;


/**
 *
 * @author Amor
 */
public class Mentionjaime {

        private Client client;
    private Produit produit;

   
    public Mentionjaime(Client client, Produit produit) {
        this.client = client;
        this.produit = produit;
    }

        public Mentionjaime() {
        
    }

    public Mentionjaime(Client client) {
        this.client = client;
    }

    public Mentionjaime(Produit produit) {
        this.produit = produit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
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
        final Mentionjaime other = (Mentionjaime) obj;
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.produit, other.produit)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mentionjaime{" + "client=" + client + ", produit=" + produit + '}';
    }

    
    
}
