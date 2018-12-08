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
public class PropEnseigne extends Personne {

    public PropEnseigne() {
    }

    public PropEnseigne(int id, String nom, String mail, String cin, String username, String password) {
        super(id, nom, mail, cin, username, password);
    }
    
     public String toString() {
        return super.toString();
    }
    
}
