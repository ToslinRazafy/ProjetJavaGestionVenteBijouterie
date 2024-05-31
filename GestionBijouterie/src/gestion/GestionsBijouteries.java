/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import connectiondb.ConnectionDB;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Razafitsotra Toslin
 */
public class GestionsBijouteries {
    ConnectionDB con = new ConnectionDB();
    Statement stm = null;

    public GestionsBijouteries() {
        try {
            stm = con.getCon().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
                    
        }
    }
    
    public int nombreClient(){
        ResultSet resultat = null;
        int nbr = 0;
        try {
            String sql = "SELECT COUNT(*) as nombre FROM client";
            resultat = stm.executeQuery(sql);
            resultat.next();
            nbr = resultat.getInt("nombre");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbr;
    }
    
    public int nombreBijou(){
        ResultSet resultat = null;
        int nbr = 0;
        try {
            String sql = "SELECT SUM(Stock) as nombre FROM bijou";
            resultat = stm.executeQuery(sql);
            resultat.next();
            nbr = resultat.getInt("nombre");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nbr;
    }
    
    public ResultSet getClient(int Id){
        ResultSet res = null;
        try {
            String sql = "SELECT * FROM client WHERE Id_cli = '"+ Id +"'";
            res = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public ResultSet getBijou(int Id){
        ResultSet res = null;
        try {
           String sql = "SELECT * FROM bijou WHERE Num_bijou = '"+ Id +"'";
           res = stm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public void updateBijou(int stock, int id){
        try {
            String sql = "UPDATE bijou SET Stock = '"+ stock +"' WHERE Num_bijou = '"+ id +"'";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
}
