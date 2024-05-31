/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import connectiondb.ConnectionDB;
import models.Utilisateur;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Razafitsotra Toslin
 */
public class LoginUtilisateur {
    ConnectionDB con = new ConnectionDB();
    Statement stm = null;

    public LoginUtilisateur() {
        try {
            stm = con.getCon().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet loginUtilisateur(Utilisateur utilisateur){
        ResultSet resultat = null;
        try {
            String sql = "SELECT * FROM utilisateur WHERE Email_utilisateur = '"+ utilisateur.getEmail() +"' AND Mdp_utilisateur = '"+ utilisateur.getMdp() +"'";
            resultat = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}
