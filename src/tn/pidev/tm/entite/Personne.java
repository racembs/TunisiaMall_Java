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
public class Personne {
    
    
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String cin;
    private String username;
    private String password;
     public Personne(int id, String nom,String mail, String cin, String username, String password) {
        this.id = id;
        this.nom = nom;
        
        this.mail = mail;
        this.cin = cin;
        this.username = username;
        this.password = password;
        
    }
    public Personne(int id, String nom,String prenom, String mail, String cin, String username, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.cin = cin;
        this.username = username;
        this.password = password;
        
    }
    
    public Personne(String nom,String prenom, String mail, String cin, String username, String password) {
       this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.cin = cin;
        this.username = username;
        this.password = password;
        
    }

    public Personne(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    public Personne() {
    }

   
   

    
    
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getCin() {
        return cin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", cin=" + cin + ", username=" + username + ", password=" + password + '}';
    }

  

    
    
            
}
