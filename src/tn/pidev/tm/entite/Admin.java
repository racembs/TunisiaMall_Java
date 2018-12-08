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
public class Admin extends Personne {
    private String role;

    public Admin() {
    }

    public Admin(int id, String nom, String mail, String cin, String username, String password) {
        super(id, nom, mail, cin, username, password);
    }
    

     public Admin(String username, String password) {
        super(username, password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" + "role=" + role +super.toString()+ '}';
    }
    
     
    
}
