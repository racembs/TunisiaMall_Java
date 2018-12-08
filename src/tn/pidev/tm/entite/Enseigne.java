/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;

import java.util.Objects;
import tn.pidev.tm.service.CartefideliteService;

import tn.pidev.tm.service.ServiceEnseigne;

/**
 *
 * @author amal
 */
public class Enseigne {
    private int id;
    private String nom;
    private String description;
    private PropEnseigne responsableEnseigne;
     private String categorie;
     private int capaMax;
     private int capacité;
     int idprop;
     float pourcentagefidelite;

     
       public Enseigne(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }
       
         public Enseigne(int id, String nom, String description, PropEnseigne responsableEnseigne, String categorie, int capaMax, int capacité) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.responsableEnseigne = responsableEnseigne;
        this.categorie = categorie;
        this.capaMax = capaMax;
        this.capacité = capacité;
    }

         
            public Enseigne(String nom, String description, PropEnseigne responsableEnseigne, String categorie, int capaMax, int capacité) {
        this.nom = nom;
        this.description = description;
        this.responsableEnseigne = responsableEnseigne;
        this.categorie = categorie;
        this.capaMax = capaMax;
        this.capacité = capacité;
    }
       
    public Enseigne(int id, String nom, String description, String categorie, int capaMax, int capacité, float pourcentagefidelite) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        
        this.categorie = categorie;
        this.capaMax = capaMax;
        this.capacité = capacité;
        this.idprop = idprop;
        this.pourcentagefidelite = pourcentagefidelite;
    }

    public void setIdprop(int idprop) {
        this.idprop = idprop;
    }

    public void setPourcentagefidelite(int pourcentagefidelite) {
        this.pourcentagefidelite = pourcentagefidelite;
    }

    public int getIdprop() {
        return idprop;
    }

    public float getPourcentagefidelite() {
        return pourcentagefidelite;
    }
     

    public Enseigne() {
    }

    

    public Enseigne(int id, String nom, String description, String categorie, int capaMax, int capacité) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.responsableEnseigne = responsableEnseigne;
        this.categorie = categorie;
        this.capaMax = capaMax;
        this.capacité = capacité;
    }
     public Enseigne(int id, String nom, String description, int idprop , String categorie, int capaMax, int capacité) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.idprop = idprop;
        this.categorie = categorie;
        this.capaMax = capaMax;
        this.capacité = capacité;
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

    public PropEnseigne getResponsableEnseigne() {
        return responsableEnseigne;
    }

    public void setResponsableEnseigne(PropEnseigne responsableEnseigne) {
        this.responsableEnseigne = responsableEnseigne;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getCapaMax() {
        return capaMax;
    }

    public void setCapaMax(int capaMax) {
        this.capaMax = capaMax;
    }

    public int getCapacité() {
        return capacité;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Enseigne other = (Enseigne) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.capaMax != other.capaMax) {
            return false;
        }
        if (this.capacité != other.capacité) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.responsableEnseigne, other.responsableEnseigne)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Enseigne{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", responsableEnseigne=" + responsableEnseigne + ", categorie=" + categorie + ", capaMax=" + capaMax + ", capacit\u00e9=" + capacité + ", idprop=" + idprop + ", pourcentagefidelite=" + pourcentagefidelite + '}';
    }

  
    
    
   
     public String getbon_achat(int idcarte,int idenseigne){
          CartefideliteService cfs=new CartefideliteService();
          ServiceEnseigne se=new ServiceEnseigne();
          
          Enseigne e=new Enseigne();
          e=se.chercherId(idenseigne);
          System.out.println(e);
          CarteFidelite carte=new CarteFidelite();
         carte= cfs.chercherId(idcarte);
         float sum=carte.getNombreDePoints()*e.getPourcentagefidelite();
         System.out.println(String.valueOf(sum)+"dt");
         return( String.valueOf(sum)+"dt");
          
          
            }
}
