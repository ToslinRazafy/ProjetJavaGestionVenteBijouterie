/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import connectiondb.ConnectionDB;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Bijoux;

/**
 *
 * @author Razafitsotra Toslin
 */
public class GestionBijoux {

    ConnectionDB con = new ConnectionDB();
    Statement stm = null;

    public GestionBijoux() {
        try {
            stm = con.getCon().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void save(Bijoux bijou) {
        try {
            String sql = "INSERT INTO bijou(Nom_bijou, Materiau, Categorie, Description, Photo, Stock, Prix) VALUES('" + bijou.getNom() + "', '" + bijou.getMateriau() + "', '" + bijou.getCategorie() + "', '" + bijou.getDescription() + "', '" + bijou.getPhoto() + "', '" + bijou.getStock() + "', '" + bijou.getPrix() + "')";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int numBijou) {
        try {
            String sql = "DELETE FROM bijou WHERE Num_bijou = '" + numBijou + "'";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Bijoux bijou, int numBijou) {
        try {
            String sql = "UPDATE bijou SET Nom_bijou = '" + bijou.getNom() + "', Materiau = '" + bijou.getMateriau() + "', Categorie = '" + bijou.getCategorie() + "', Description = '" + bijou.getDescription() + "', Photo = '" + bijou.getPhoto() + "', Stock = '" + bijou.getStock() + "', Prix = '" + bijou.getPrix() + "' WHERE Num_bijou = '" + numBijou + "'";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAll() {
        ResultSet resultat = null;
        try {
            String sql = "SELECT * FROM bijou";
            resultat = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public ResultSet verify(int Id) {
        ResultSet resultat = null;
        try {
            String sql = "SELECT * FROM bijou WHERE Num_bijou = '"+ Id +"'";
            resultat = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public ResultSet search(String keyword) {
        ResultSet resultat = null;
        String keyword1 = "%" + keyword + "%";
        try {
            String sql = "SELECT * FROM bijou WHERE Id_bijou LIKE '" + keyword + "' OR Nom_bijou LIKE '" + keyword1 + "' OR Materiau LIKE '" + keyword1 + "' OR Categorie LIKE '" + keyword1 + "' OR Description LIKE '" + keyword1 + "' OR Stock LIKE '" + keyword1 + "' OR Prix LIKE '" + keyword1 + "'";
            resultat = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }

}
