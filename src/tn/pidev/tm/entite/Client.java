/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.entite;



/**
 *
 * @author RBS
 */
public class Client extends Personne {
 
   
   
    private String code;
   private String role;
    private String EtatBlocage;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
 
    public void setEtatBlocage(String EtatBlocage) {
        this.EtatBlocage = EtatBlocage;
    }

    public String getEtatBlocage() {
        return EtatBlocage;
    }
    

    public Client() {
    }
    
 public Client(int id, String nom, String prenom, String email, String cin, String username, String password,String role) {
        super(id,nom,prenom,email,cin,username,password);
        
      
        this.role = role;
    }
  public Client(int id, String nom, String prenom, String email, String cin, String username, String password,String role,String EtatBlocage) {
        super(id,nom,prenom,email,cin,username,password);
        
      this.EtatBlocage=EtatBlocage;
        this.role = role;
    }
 
    public Client(String nom, String prenom, String email, String cin, String username, String password,String role) {
        super(nom,prenom,email,cin,username,password);
     
        this.role = role;
    }
    public Client(String nom, String prenom, String email, String cin, String username, String password,String role,String EtatBlocage) {
        super(nom,prenom,email,cin,username,password);
     this.EtatBlocage=EtatBlocage;
        this.role = role;
    }
    
    
    
  public Client(int id, String nom, String prenom, String email, String cin, String username, String password,String role,String EtatBlocage,String code) {
        super(id,nom,prenom,email,cin,username,password);
        
      this.EtatBlocage=EtatBlocage;
        this.role = role;
        this.code=code;
    }
  public Client(String nom, String prenom, String email, String cin, String username, String password,String role,String EtatBlocage,String code) {
        super(nom,prenom,email,cin,username,password);
        
      this.EtatBlocage=EtatBlocage;
        this.role = role;
        this.code=code;
    }

    
    
        public Client(String code, String role, String EtatBlocage, int id, String nom, String prenom, String mail, String cin, String username, String password) {
        super(id, nom, prenom, mail, cin, username, password);
        this.code = code;
        this.role = role;
        this.EtatBlocage = EtatBlocage;
    }
    
    
    
@Override
   public String toString() {
        return super.toString()+ ", role=" + role + '}';
    }

  

   
    
    //************************************************getter and setter*************************************************************
  
    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    
    
    
}
