/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Razafitsotra Toslin
 */
public class DetailCommande {
    private int numDetCom;
    private int numCom;
    private int numBijou;
    private int quantiteCom;
    private int prixUnitaire;
    private int montant;

    public DetailCommande(int numDetCom, int numCom, int numBijou, int quantiteCom, int prixUnitaire, int montant) {
        this.numDetCom = numDetCom;
        this.numCom = numCom;
        this.numBijou = numBijou;
        this.quantiteCom = quantiteCom;
        this.prixUnitaire = prixUnitaire;
        this.montant = montant;
    }

    public int getNumDetCom() {
        return numDetCom;
    }

    public void setNumDetCom(int numDetCom) {
        this.numDetCom = numDetCom;
    }

    public int getNumCom() {
        return numCom;
    }

    public void setNumCom(int numCom) {
        this.numCom = numCom;
    }

    public int getNumBijou() {
        return numBijou;
    }

    public void setNumBijou(int numBijou) {
        this.numBijou = numBijou;
    }

    public int getQuantiteCom() {
        return quantiteCom;
    }

    public void setQuantiteCom(int quantiteCom) {
        this.quantiteCom = quantiteCom;
    }

    public int getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
}
