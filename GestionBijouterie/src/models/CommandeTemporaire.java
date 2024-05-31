/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Razafitsotra Toslin
 */
public class CommandeTemporaire {
    private int Num_bijou;
    private String Nom_bijou;
    private String description;
    private int quantiteCommander;
    private int prix;
    private int montant;

    public CommandeTemporaire(int Num_bijou, String Nom_bijou, String description, int quantiteCommander, int prix, int montant) {
        this.Num_bijou = Num_bijou;
        this.Nom_bijou = Nom_bijou;
        this.description = description;
        this.quantiteCommander = quantiteCommander;
        this.prix = prix;
        this.montant = montant;
    }

    public int getNum_bijou() {
        return Num_bijou;
    }

    public void setNum_bijou(int Num_bijou) {
        this.Num_bijou = Num_bijou;
    }

    public String getNom_bijou() {
        return Nom_bijou;
    }

    public void setNom_bijou(String Nom_bijou) {
        this.Nom_bijou = Nom_bijou;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantiteCommander() {
        return quantiteCommander;
    }

    public void setQuantiteCommander(int quantiteCommander) {
        this.quantiteCommander = quantiteCommander;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    
}
