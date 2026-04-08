package test.dao;

import java.io.IOException;
import appli.modele.dao.ConnexionBDD;
import appli.exceptions.ConnexionBDDException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Test unitaire de la classe ConnexionBDD
 * @author btssio
 */
public class TestConnexionBDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection cnx = null;
        ConnexionBDD.setParametresConnexion("jdbc:mysql://localhost/SIRH", "sirh_util", "secret");
        try {
            System.out.println("\n Test de connexion");
            cnx = ConnexionBDD.getConnexion();
            System.out.println("ConnexionBDD : connexion réussie");
            cnx.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } catch (ConnexionBDDException ex) {
            System.getLogger(TestConnexionBDD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

}
