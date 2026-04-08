package test.dao;

import java.io.IOException;
import appli.modele.dao.ConnexionBDD;
import appli.exceptions.ConnexionBDDException;
import appli.modele.dao.DaoService;
import java.sql.SQLException;
import java.util.ArrayList;
import appli.modele.metier.Service;

/**
 * Test unitaire de la classe DaoService
 * @author btssio
 */
public class TestDaoService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConnexionBDD.setParametresConnexion("jdbc:mysql://localhost/SIRH", "sirh_util", "secret");
        // Test 1 getOneById
        System.out.println("\n Test 1 : DaoService.getOneById");
        try {
            int idRecherche = 2;
            Service srv = DaoService.getOneById(idRecherche);
            if(srv != null){
                System.out.println("Service d'id "+idRecherche+" trouvé : \n"+srv.toStringEtat());
            }else{
                System.out.println("Service d'id "+idRecherche+" non trouvé : \n");
            }
            
        } catch (SQLException ex) {
            System.out.println("TestDaoService - échec getOneById : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoService - échec getOneById : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoService - échec de connexion à la BDD : " + ex.getMessage());
        }
        // Test 2 getAll
        System.out.println("\n Test 2 : DaoService.getAll");
        try {
            ArrayList<Service> lesServices = DaoService.getAll();
            for (Service srv : lesServices) {
                System.out.println(srv.toStringEtat());
            }
            System.out.println(lesServices.size()+" services trouvés");
        } catch (SQLException ex) {
            System.out.println("TestDaoService - échec getAll : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoService - échec getAll : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoService - échec de connexion à la BDD : " + ex.getMessage());
        }
        
        // Fermeture de la connexion
        try {
            ConnexionBDD.getConnexion().close();
            System.out.println("\nConnexion à la BDD fermée");
        } catch (SQLException ex) {
            System.out.println("TestDaoService - échec de la fermeture de la connexion : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("TestDaoService - échec de la fermeture de la connexion : " + ex.getMessage());
        } catch (ConnexionBDDException ex) {
            System.out.println("TestDaoService - échec de connexion à la BDD : " + ex.getMessage());
        }
    }

}
