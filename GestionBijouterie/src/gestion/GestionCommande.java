/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import connectiondb.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import models.Commande;
import java.time.LocalDate;

/**
 *
 * @author Razafitsotra Toslin
 */
public class GestionCommande {

    ConnectionDB con = new ConnectionDB();
    Statement stm = null;

    public GestionCommande() {
        try {
            stm = con.getCon().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAll(){
        ResultSet res = null;
        try {
            res = stm.executeQuery("SELECT client.*, commande.* FROM client, commande WHERE client.Id_cli = commande.Id_cli ORDER BY commande.Num_com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public int countCommande() {
        int nbr = 0;
        ResultSet res = null;
        try {
            String sql = "SELECT COUNT(*) as nombre FROM commande";
            res = stm.executeQuery(sql);
            res.next();
            nbr = res.getInt("nombre");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nbr;
    }

    public void save(Commande com) {
        try {
            stm.executeUpdate("INSERT INTO commande(Id_cli, Montant_tot) VALUES('" + com.getIdCli() + "', '" + com.getMontant() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int montantBijouVenduAujourdhuit() {
        ResultSet res = null;
        int nbr = 0;
        LocalDate date = LocalDate.now();
        try {
            String sql = "SELECT SUM(Montant_tot) as somme FROM commande WHERE Date_com = '" + date + "'";
            res = stm.executeQuery(sql);
            res.next();
            nbr = res.getInt("somme");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nbr;
    }

    public int montantTotalBijouVendu() {
        ResultSet res = null;
        int nbr = 0;
        LocalDate date = LocalDate.now();
        try {
            String sql = "SELECT SUM(Montant_tot) as somme FROM commande";
            res = stm.executeQuery(sql);
            res.next();
            nbr = res.getInt("somme");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nbr;
    }

    public int montantBijouVenduCeMoisCi() {
        ResultSet res = null;
        int nbr = 0;
        LocalDate date = LocalDate.now();
        int annees = date.getYear();
        int mois = date.getMonthValue();
        String dat = annees + "-0" + mois + "-%";
        try {
            String sql = "SELECT SUM(Montant_tot) as somme FROM commande WHERE Date_com like '" + dat + "'";
            res = stm.executeQuery(sql);
            res.next();
            nbr = res.getInt("somme");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nbr;
    }

    public ResultSet donneAreaChart() {
        ResultSet res = null;
        try {
            res = stm.executeQuery("SELECT Date_com, SUM(Montant_tot) as total FROM commande GROUP BY Date_com ORDER BY TIMESTAMP(Date_com)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public ResultSet donneBarChart() {
        ResultSet res = null;
        try {
            res = stm.executeQuery("SELECT Date_com, COUNT(Id_cli) as nombre FROM commande GROUP BY Date_com ORDER BY TIMESTAMP(Date_com)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
