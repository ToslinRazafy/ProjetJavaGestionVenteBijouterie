/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Razafitsotra Toslin
 */
public class Commande {
    private int Num;
    private int IdCli;
    private int Montant;
    private String Date;
    private String nom;
    private String prenom;
    private String tel;

    public Commande(int Num, int IdCli, int Montant, String Date, String nom, String prenom, String tel) {
        this.Num = Num;
        this.IdCli = IdCli;
        this.Montant = Montant;
        this.Date = Date;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }

    public int getIdCli() {
        return IdCli;
    }

    public void setIdCli(int IdCli) {
        this.IdCli = IdCli;
    }

    public int getMontant() {
        return Montant;
    }

    public void setMontant(int Montant) {
        this.Montant = Montant;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
}
