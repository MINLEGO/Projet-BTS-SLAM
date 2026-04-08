package appli.lanceur;

import appli.modele.dao.ConnexionBDD;
import appli.exceptions.ConnexionBDDException;
import appli.vue.JFrameListeSalaries;
import java.util.ArrayList;
import appli.modele.dao.DaoSalarie;
import appli.modele.dao.DaoService;
import appli.modele.metier.Salarie;
import appli.modele.metier.Service;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Classe de lancement de l'application
 * @author btssio
 */
public class Main {

    public static void main(String args[]) {
        
        JFrameListeSalaries jfListeSalaries;    // fenêtre principale
        ArrayList<Service> lesServices = null;  // liste des services pour garnir la JComboBox
        ArrayList<Salarie> lesSalaries = null;  // liste des salariés pour garnir la JTable
        
        // Paramétrer la connexion à la BDD
        Properties paramAppli; // objet de propriétés (paramètres de l'appplication) pour Jdbc
        InputStream input;         // flux de lecture des properties
        // Chargement des paramètres du fichier de properties
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        input = classLoader.getResourceAsStream("ressources/parametres_sirh.properties");
        paramAppli = new Properties();
        try {
            paramAppli.load(input);
        } catch (IOException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        ConnexionBDD.setParametresConnexion(paramAppli.getProperty("url"), paramAppli.getProperty("utilBD"), paramAppli.getProperty("mdpBD"));

        // Instancier la GUI principale (liste des salariés)
        jfListeSalaries = new JFrameListeSalaries(paramAppli.getProperty("imageDeFond"));
        

        // Remplissage combobox des services 
        try {
            lesServices = DaoService.getAll();
        } catch (IOException | SQLException  | ConnexionBDDException ex) {
            JOptionPane.showMessageDialog(jfListeSalaries, 
                                          "Main - pb remplissage combo services : \n" + ex.getMessage(),  
                                          "Incident", 
                                          JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
            System.exit(1);
        }
        jfListeSalaries.remplirJComBoxServices(lesServices);

        // Lecture des salariés dans la base de données
        // Initialement, tous les salariés sont sélectionnés
        try {
            lesSalaries = DaoSalarie.getAll();
        } catch (IOException | SQLException  | ConnexionBDDException ex) {
            JOptionPane.showMessageDialog(jfListeSalaries, 
                                          "Main - pb remplissage JTable salaries : \n" + ex.getMessage(), 
                                          "Incident", 
                                          JOptionPane.ERROR_MESSAGE
            );
            ex.printStackTrace();
            System.exit(1);
        }
        
        // Affichage dans la table
        jfListeSalaries.remplirJTableSalaries(lesSalaries);
        // Affichage de la fenêtre
        jfListeSalaries.setVisible(true);

    }
}
