package appli.modele.dao;

import appli.exceptions.ConnexionBDDException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de connexion JDBC de type singleton
 * @author btssio
 */
public class ConnexionBDD {

    private static Connection cnx=null;
    
    private static String urlBdd="";
    private static String utilBdd="";
    private static String mdpBdd="";
    

    /**
     * Retourner une connexion ; la créer si elle n'existe pas...
     *
     * @return : objet de type java.sql.Connection
     * @throws java.sql.SQLException
     * @throws java.io.FileNotFoundException
     */
    public static Connection getConnexion() throws SQLException, FileNotFoundException, IOException, ConnexionBDDException {
        // On ne crée la connexion que si elle n'existe pas
        if (cnx == null) {
            // Pour la créer, les paramètres ont du être renseignés
            if (urlBdd.equals("") || utilBdd.equals("")){
                // Sinon, on déclenche une exception
                throw new ConnexionBDDException(ConnexionBDD.class.getSimpleName()+" : paramètres de connexion non définis");
            }else{
                // Le connexion JDBC à la base de données peut être créée
                cnx = DriverManager.getConnection(urlBdd, utilBdd, mdpBdd);
                System.out.println("getConnexion : " + urlBdd);
            }
        }
        return cnx;
    }

    public static void setParametresConnexion(String unUrl, String unUtilisateur, String sonMotDePasse){
        urlBdd = unUrl;
        utilBdd = unUtilisateur;
        mdpBdd = sonMotDePasse;
    }
    
    

}
