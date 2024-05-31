/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import connectiondb.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import models.CommandeTemporaire;
import java.sql.SQLException;
/**
 *
 * @author Razafitsotra Toslin
 */
public class GestionCommandeTemporaire {
    ConnectionDB con = new ConnectionDB();
    Statement stm = null;

    public GestionCommandeTemporaire() {
        try {
            stm = con.getCon().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void save(CommandeTemporaire comTmp){
        try {
            String sql = "INSERT INTO commandetmp VALUES('"+ comTmp.getNum_bijou() +"', '"+ comTmp.getNom_bijou() +"', '"+ comTmp.getDescription() +"', '"+ comTmp.getQuantiteCommander() +"', '"+ comTmp.getPrix() +"', '"+ comTmp.getMontant() +"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateQuantity(int Quantite, int Montant, int id){
        try {
            String sql = "UPDATE commandeTmp SET Quantite_com = '"+ Quantite +"', Montant = '"+ Montant +"' WHERE Num_bijou = '"+ id +"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet getAll(){
        ResultSet res = null;
        try {
            String sql = "SELECT * FROM commandetmp";
            res = stm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public ResultSet verify(int Id){
        ResultSet res = null;
        try {
            String sql = "SELECT * FROM commandetmp WHERE Num_bijou = '"+ Id +"'";
            res = stm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public int sommeTotalComTmp(){
        int nbr = 0;
        ResultSet res = null;
        try {
            String sql = "SELECT SUM(Montant) as montant FROM commandetmp";
            res = stm.executeQuery(sql);
            res.next();
            nbr = res.getInt("montant");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nbr;
    }
    
    public void delete(){
        try {
            stm.executeUpdate("DELETE FROM commandetmp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
