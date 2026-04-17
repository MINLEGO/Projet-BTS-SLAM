/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appli.modele.metier;

/**
 *
 * @author Willifried
 */
public class Categorie {
    
    private String code;
    private String libelle;
    private double salaireMini;
    private String caisseRetraite;
    private int prime;

    public Categorie(String code, String libelle, double salaireMini, String caisseRetraite, int prime) {
        this.code = code;
        this.libelle = libelle;
        this.salaireMini = salaireMini;
        this.caisseRetraite = caisseRetraite;
        this.prime = prime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getSalaireMini() {
        return salaireMini;
    }

    public void setSalaireMini(double salaireMini) {
        this.salaireMini = salaireMini;
    }

    public String getCaisseRetraite() {
        return caisseRetraite;
    }

    public void setCaisseRetraite(String caisseRetraite) {
        this.caisseRetraite = caisseRetraite;
    }

    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }

    @Override
    public String toString() {
        return "Categorie{" + "code=" + code + ", libelle=" + libelle + ", salaireMini=" + salaireMini + ", caisseRetraite=" + caisseRetraite + ", prime=" + prime + '}';
    }

    public String toStringEtat() {
        return "Categorie { code=" + code
                + ", libelle=" + libelle
                + ", salaireMini=" + salaireMini
                + ", caisseRetraite=" + caisseRetraite
                + ", prime=" + prime
                + " }";
    }
 
 

}
