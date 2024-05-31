/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import connectiondb.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import models.DetailCommande;
/**
 *
 * @author Razafitsotra Toslin
 */
public class GestionDetailCommande {
    ConnectionDB con = new ConnectionDB();
    Statement stm = null;

    public GestionDetailCommande() {
        try {
            stm = con.getCon().createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void save(DetailCommande detCom){
        try {
            String sql = "INSERT INTO detail_commande(Num_com, Num_bijou, Qunatite_com, PU, Montant) VALUES('"+ detCom.getNumCom() +"', '"+ detCom.getNumBijou() +"', '"+ detCom.getQuantiteCom() +"', '"+ detCom.getPrixUnitaire() +"', '"+ detCom.getMontant() +"')";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int nbrBijouVendu(){
        ResultSet res = null;
        int nbr = 0;
        try {
            res = stm.executeQuery("SELECT SUM(Qunatite_com) as total FROM detail_commande");
            res.next();
            nbr = res.getInt("total");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nbr;
    }
    
}
