package test.metier;


import appli.modele.metier.Categorie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Willifried
 */
public class TestCategorie {
    public static void main(String[] args) {

        System.out.println("TestCategorie");

        // Création d'une catégorie
        Categorie cat = new Categorie("A1", "Cadre", 2500.0, "AGIRC", 500);

        // Affichage
        System.out.println(cat.toString());

        // Test des setters
        cat.setCode("B2");
        cat.setLibelle("Employe");
        cat.setSalaireMini(1800.0);
        cat.setCaisseRetraite("ARRCO");
        cat.setPrime(200);

        System.out.println("Après modification :");
        System.out.println(cat.toString());
    }
} 

