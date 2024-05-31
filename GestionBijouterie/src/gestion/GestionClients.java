/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import connectiondb.ConnectionDB;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Clients;
/**
 *
 * @author Razafitsotra Toslin
 */
public class GestionClients {
    ConnectionDB con = new ConnectionDB();
    Statement stm = null;

    public GestionClients() {
        try {
            stm = con.getCon().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void save(Clients client){
        try {
            String sql = "INSERT INTO client(Nom_cli, Prenom_cli,  Adrs_cli, Ville, Tel_cli, Sexe) VALUES('"+ client.getNom() +"', '"+ client.getPrenom() +"', '"+ client.getAdresse() +"', '"+ client.getVille() +"', '"+ client.getTelephone() +"', '"+ client.getSexe() +"')";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int idCli){
        try {
            String sql = "DELETE FROM client WHERE Id_cli = '"+ idCli +"'";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Clients client, int idCli){
        try {
            String sql = "UPDATE client SET Nom_cli = '"+ client.getNom() +"', Prenom_cli = '"+ client.getPrenom() +"', Adrs_cli = '"+ client.getAdresse() +"', Ville = '"+ client.getVille() +"', Tel_cli = '"+ client.getTelephone() +"', Sexe = '"+ client.getSexe() +"' WHERE Id_cli = '"+ idCli +"'";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAll(){
        ResultSet res = null;
        try {
            String sql = "SELECT * FROM client";
            res = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public ResultSet search(String keyword){
        ResultSet res = null;
        String keyword1 = "%"+keyword+"%";
        try {
            String sql = "SELECT * FROM client WHERE Id_cli LIKE '"+ keyword +"' OR Nom_cli LIKE '"+ keyword1 +"' OR Prenom_cli LIKE '"+ keyword1 +"' OR Adrs_cli LIKE '"+ keyword1 +"' OR Ville LIKE '"+ keyword1 +"' OR Tel_cli LIKE '"+ keyword1 +"' OR Sexe LIKE '"+ keyword1 +"'";
            res = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public ResultSet verify(String keyword){
        ResultSet res = null;
        try {
            String sql = "SELECT * FROM client WHERE Tel_cli LIKE '"+ keyword +"'";
            res = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
