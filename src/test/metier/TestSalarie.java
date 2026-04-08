package test.metier;

import appli.modele.metier.Categorie;
import appli.modele.metier.Salarie;
import appli.modele.metier.Service;
import java.sql.Date;

/**
 * Classe de test unitaire de la classe Salarie
 * Teste les constructeurs, getters, setters et toString
 */
public class TestSalarie {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("   TESTS UNITAIRES - Classe Salarie     ");
        System.out.println("========================================\n");

        // --- Données de test ---
        Service serv = new Service(1, "Informatique",
                "informatique@infoware.com", "0169983212");

        Categorie cat = new Categorie("E2", "Employé niveau 2",
                2100, "ARRCO", 0);

        // ------------------------------------------------
        // TEST 1 : constructeur sans service ni catégorie
        // ------------------------------------------------
        System.out.println("--- TEST 1 : constructeur sans service ni catégorie ---");
        Salarie sal1 = new Salarie(
                "S06", "DUPONT", "Henri",
                Date.valueOf("1993-11-15"),
                Date.valueOf("2020-09-01"),
                "Développeur", 21.6, "Marié.e", 2
        );
        System.out.println(sal1.toString());
        System.out.println("Service   attendu : Néant  →  obtenu : "
                + (sal1.getService() == null ? "Néant" : sal1.getService()));
        System.out.println("Catégorie attendu : Néant  →  obtenu : "
                + (sal1.getCategorie() == null ? "Néant" : sal1.getCategorie()));
        System.out.println();

        // ------------------------------------------------
        // TEST 2 : constructeur avec service ET catégorie
        // ------------------------------------------------
        System.out.println("--- TEST 2 : constructeur avec service et catégorie ---");
        Salarie sal2 = new Salarie(
                "S06", "DUPONT", "Henri",
                Date.valueOf("1993-11-15"),
                Date.valueOf("2020-09-01"),
                "Développeur", 21.6, "Marié.e", 2,
                serv, cat
        );
        System.out.println(sal2.toString());
        System.out.println("Service   attendu : Informatique  →  obtenu : "
                + sal2.getService().getDesignation());
        System.out.println("Catégorie attendu : Employé niveau 2  →  obtenu : "
                + sal2.getCategorie().getLibelle());
        System.out.println("Caisse    attendu : ARRCO  →  obtenu : "
                + sal2.getCategorie().getCaisseRetraite());
        System.out.println("Prime     attendu : 0  →  obtenu : "
                + sal2.getCategorie().getPrime());
        System.out.println();

        // ------------------------------------------------
        // TEST 3 : setters sur la catégorie
        // ------------------------------------------------
        System.out.println("--- TEST 3 : setter setCategorie ---");
        Categorie cat2 = new Categorie("C1", "Cadre moyen",
                2500, "AGIRC", 1);
        sal1.setCategorie(cat2);
        System.out.println("Catégorie attendu : Cadre moyen  →  obtenu : "
                + sal1.getCategorie().getLibelle());
        System.out.println("Prime     attendu : 1  →  obtenu : "
                + sal1.getCategorie().getPrime());
        System.out.println();

        // ------------------------------------------------
        // TEST 4 : setter setService
        // ------------------------------------------------
        System.out.println("--- TEST 4 : setter setService ---");
        sal1.setService(serv);
        System.out.println("Service   attendu : Informatique  →  obtenu : "
                + sal1.getService().getDesignation());
        System.out.println();

        System.out.println("========================================");
        System.out.println("   FIN DES TESTS                        ");
        System.out.println("========================================");
    }
}