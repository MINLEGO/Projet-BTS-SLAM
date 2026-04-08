package appli.modele.dao;

import appli.exceptions.ConnexionBDDException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import appli.modele.metier.Service;
import java.io.FileNotFoundException;

/**
 * Classe DAO : liaison classe métier Service / table SERVICE
 * @author btssio
 */
public class DaoService {

    /**
     * Rechercher un enregistrement dans la table SERVICE d'après son code (int)
     * et en faire un objet de type Service
     *
     * @param id code du service recherché
     * @return objet de type Service si trouvé dans la BDD, null sinon
     * @throws SQLException
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws appli.exceptions.ConnexionBDDException
     */
    public static Service getOneById(int id) throws SQLException, IOException, FileNotFoundException, ConnexionBDDException {
        Service serviceTrouve = null;
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Service WHERE Code = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            serviceTrouve = new Service(
                    id,
                    rs.getString("Designation"),
                    rs.getString("Email"),
                    rs.getString("Tel")
            );
        }
        return serviceTrouve;
    }

    /**
     * Extraire l'ensemble des enregistrements de la table SERVICE
     * @return liste d'objets de type Service
     * @throws SQLException 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws appli.exceptions.ConnexionBDDException 
     */
    public static ArrayList<Service> getAll() throws SQLException, IOException, FileNotFoundException, ConnexionBDDException {
        ArrayList<Service> lesServicesTrouves = new ArrayList<>();
        Connection cnx = ConnexionBDD.getConnexion();
        PreparedStatement pstmt = cnx.prepareStatement("SELECT * FROM Service");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Service unService = new Service(
                    rs.getInt("Code"),
                    rs.getString("Designation"),
                    rs.getString("Email"),
                    rs.getString("Tel")
            );
            lesServicesTrouves.add(unService);
        }
        return lesServicesTrouves;
    }

}
