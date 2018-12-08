/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.tm.service;

import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public interface Iservice<T> {

    public boolean inserer(T p) throws SQLException;

    public boolean modifier(T p) throws SQLException;

    public boolean supprimer(T p) throws SQLException;

    public void Afficher() throws SQLException;

}
