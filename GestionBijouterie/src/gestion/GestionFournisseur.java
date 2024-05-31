/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import connectiondb.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Razafitsotra Toslin
 */
public class GestionFournisseur {
    ConnectionDB con = new ConnectionDB();
    Statement stm = null;

    public GestionFournisseur() {
        try {
            stm = con.getCon().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAll(){
        ResultSet resultat = null;
        try {
            String sql = "SELECT * FROM bijou";
            resultat = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
    
}
