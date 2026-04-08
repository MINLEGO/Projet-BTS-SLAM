/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.dao;

import appli.exceptions.ConnexionBDDException;
import appli.modele.dao.ConnexionBDD;
import appli.modele.dao.DaoSalarie;
import appli.modele.metier.Salarie;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author elven
 */
public class TestDaoSalarie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnexionBDD.setParametresConnexion("jdbc:mysql://localhost/SIRH", "sirh_util", "secret");
        // Test 1 getOneById
        System.out.println("\n Test 1 : DaoSalarie.getOneById");
        try {
            String idRecherche = "C1";
            Salarie sal = DaoSalarie.getOneById(idRecherche);
            if (sal != null) {
                System.out.println("Salarie d'id " + idRecherche + " trouvé : \n" + sal.toString());
            } else {
                System.out.println("Salarie d'id " + idRecherche + " non trouvé : \n");
            }

        } catch (SQLException ex) {
            System.out.println("TestDaoSalarie - échec getOneById : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoSalarie - échec getOneById : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoSalarie - échec de connexion à la BDD : " + ex.getMessage());
        }
        // Test 2 getAll
        System.out.println("\n Test 2 : DaoSalarie.getAll");
        try {
            ArrayList<Salarie> lesSalaries = DaoSalarie.getAll();
            for (Salarie sal : lesSalaries) {
                System.out.println(sal.toString());
            }
            System.out.println(lesSalaries.size() + " services trouvés");
        } catch (SQLException ex) {
            System.out.println("TestDaoSalarie - échec getAll : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoSalarie - échec getAll : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoSalarie - échec de connexion à la BDD : " + ex.getMessage());
        }

        // Fermeture de la connexion
        try {
            ConnexionBDD.getConnexion().close();
            System.out.println("\nConnexion à la BDD fermée");
        } catch (SQLException ex) {
            System.out.println("TestDaoSalarie - échec de la fermeture de la connexion : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoSalarie - échec de la fermeture de la connexion : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoSalarie - échec de connexion à la BDD : " + ex.getMessage());
        }
    }
}
    
