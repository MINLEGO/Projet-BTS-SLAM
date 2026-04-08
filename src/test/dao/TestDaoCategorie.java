/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.dao;

import appli.exceptions.ConnexionBDDException;
import appli.modele.dao.ConnexionBDD;
import appli.modele.metier.DaoCategorie;
import appli.modele.metier.Categorie;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author elven
 */
public class TestDaoCategorie {
    /**
     * @param args the command line arguments
     */
    public static  TestDaoCategoriegs) {
        ConnexionBDD.setParametresConnexion("jdbc:mysql://localhost/SIRH", "sirh_util", "secret");
        // Test 1 getOneById
        System.out.println("\n Test 1 : DaoCategorie.getOneById");
        try {
            String idRecherche = "C1";
            Categorie cat = DaoCategorie.getOneById(idRecherche);
            if(cat != null){
                System.out.println("Categorie d'id "+idRecherche+" trouvé : \n"+cat.toStringEtat());
            }else{
                System.out.println("Categorie d'id "+idRecherche+" non trouvé : \n");
            }
            
        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoCategorie - échec getOneById : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoCategorie - échec de connexion à la BDD : " + ex.getMessage());
        }
        // Test 2 getAll
        System.out.println("\n Test 2 : DaoCategorie.getAll");
        try {
            ArrayList<Categorie> lesCategories = DaoCategorie.getAll();
            for (Categorie cat : lesCategories) {
                System.out.println(cat.toStringEtat());
            }
            System.out.println(lesCategories.size()+" categories trouvés");
        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoCategorie - échec getAll : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoCategorie - échec de connexion à la BDD : " + ex.getMessage());
        }
        
        // Fermeture de la connexion
        try {
            ConnexionBDD.getConnexion().close();
            System.out.println("\nConnexion à la BDD fermée");
        } catch (SQLException | IOException ex) {
            System.out.println("TestDaoCategorie - échec de la fermeture de la connexion : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoCategorie - échec de connexion à la BDD : " + ex.getMessage());
        }
    }
}
