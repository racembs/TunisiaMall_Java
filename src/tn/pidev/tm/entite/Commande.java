/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;

/**
 *
 * @author Asus
 */
public class Commande {
    private int id;
    private double total;
    private Client client;
    private int paiment;
    private int livraison ;

   

    public Commande() {
    }

    public Commande(int id, double total, Client client, int paiment, int livraison) {
        this.id = id;
        this.total = total;
        this.client = client;
        this.paiment = paiment;
        this.livraison = livraison;
    }
    
    public Commande( Client client,Double total, int paiment, int livraison) {
        this.total = total;
        this.client = client;
        this.paiment = paiment;
        this.livraison = livraison;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getPaiment() {
        return paiment;
    }

    public void setPaiment(int paiment) {
        this.paiment = paiment;
    }

    public int getLivraison() {
        return livraison;
    }

    public void setLivraison(int livraison) {
        this.livraison = livraison;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", total=" + total + ", client=" + client + ", paiment=" + paiment + ", livraison=" + livraison + '}';
    }

 
    
}
    
            
    

