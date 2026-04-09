/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package appli.modele.dao;

import appli.exceptions.ConnexionBDDException;
import appli.modele.dao.ConnexionBDD;
import appli.modele.metier.Categorie;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Willifried
 */
public class DaoCategorie {
    // Retourne une Categorie d'après son code
    public static Categorie getOneById(String code) throws SQLException, IOException, FileNotFoundException, ConnexionBDDException {
        Categorie c = null;
        String sql = "SELECT * FROM Categorie WHERE Code = ?";
        Connection conn = ConnexionBDD.getConnexion();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Categorie(
                            rs.getString("Code"),
                            rs.getString("Libelle"),
                            rs.getDouble("SalaireMini"),
                            rs.getString("CaisseDeRetraite"),
                            rs.getInt("PrimeResultat")
                    );
                }
            }
        }
        return c;
    }

    // Retourne toutes les catégories
    public static ArrayList<Categorie> getAll() throws SQLException, IOException, FileNotFoundException, ConnexionBDDException {
        ArrayList<Categorie> liste = new ArrayList<>();
        String sql = "SELECT * FROM Categorie";
        Connection conn = ConnexionBDD.getConnexion();
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                liste.add(new Categorie(
                        rs.getString("Code"),
                        rs.getString("Libelle"),
                        rs.getDouble("SalaireMini"),
                        rs.getString("CaisseDeRetraite"),
                        rs.getInt("PrimeResultat")
                ));
            }
        }
        return liste;
    }
}
  /**
  
     * Rechercher une catégorie dans la table CATEGORIE d'après son code
     * @param code code de la catégorie (ex : "E2", "C1")
     * @return objet Categorie si trouvé, null sinon
     * @throws SQLException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ConnexionBDDException
     */
    
    
