package appli.modele.dao;

import appli.exceptions.ConnexionBDDException;
import appli.modele.metier.*;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe DAO : liaison classe métier Salarie / table SALARIE
 * @author btssio
 */
public class DaoSalarie {

    /**
     * Rechercher un enregistrement dans la table SALARIE d'après son code
     * (String) et en faire un objet de type Salarie
     *
     * @param id code du salarie recherché
     * @return objet de type Salarie si trouvé dans la BDD, null sinon
     * @throws SQLException
     * @throws java.io.IOException
     * @throws appli.exceptions.ConnexionBDDException
     */
    public static Salarie getOneById(String id) throws SQLException, IOException, ConnexionBDDException {
        Salarie salarieTrouve = null;
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie WHERE Code = ?");
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            salarieTrouve = creerSalarie(rs);
        }
        return salarieTrouve;
    }

    /**
     * Extraire l'ensemble des enregistrements de la table SALARIE
     *
     * @return liste d'objets de type Salarie
     * @throws SQLException
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws appli.exceptions.ConnexionBDDException
     */
    public static ArrayList<Salarie> getAll() throws SQLException, IOException, FileNotFoundException, ConnexionBDDException {
        ArrayList<Salarie> lesSalariesTrouves = new ArrayList<>();
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Salarie");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Salarie unSalarie = creerSalarie(rs);
            lesSalariesTrouves.add(unSalarie);
        }
        return lesSalariesTrouves;
    }

    
    /**
     * Transforme un enregistrement de la table SALARIE en instance de Salarie
     * @param rs jeu d'enregistrements ; l'enregistrement courant est concerné
     * @return instance de Salarie
     * @throws SQLException 
     * @throws IOException 
     */
    private static Salarie creerSalarie(ResultSet rs) throws SQLException, IOException, FileNotFoundException, ConnexionBDDException {
        Salarie unSalarie = null;
        // Récupération du service du salarié

        Service unService = DaoService.getOneById(rs.getInt("CodeServ"));
  
        unSalarie = new Salarie(
                rs.getString("Code"),
                rs.getString("Nom"),
                rs.getString("Prenom"),
                (java.util.Date) rs.getDate("DateNaiss"),
                (java.util.Date) rs.getDate("DateEmbauche"),
                rs.getString("Fonction"),
                rs.getDouble("TauxHoraire"),
                rs.getString("situationFamiliale"),
                rs.getInt("NbrEnfants")
                
        );
        return unSalarie;
    }

}
