package test.vue;

import appli.vue.JFrameListeSalaries;
import java.util.ArrayList;
import appli.modele.metier.Salarie;
import appli.modele.metier.Service;

/**
 * Test unitaire de la GUI
 * @author btssio
 */
public class TestJFrameListeSalaries {

    public static void main(String args[]) {
        JFrameListeSalaries jfListeSalaries;
        ArrayList<Service> lesServices = null;
        ArrayList<Salarie> lesSalaries = null;

        jfListeSalaries = new JFrameListeSalaries("/ressources/StesioImageDeFond.jpg");

        // BOUCHON 
        lesServices = Bouchon.daoServiceGetAll();
        jfListeSalaries.remplirJComBoxServices(lesServices);

        // Remplissage jtable des salariés avec
        // BOUCHON
        lesSalaries = Bouchon.daoSalarieGetAll();        
        jfListeSalaries.remplirJTableSalaries(lesSalaries);
        jfListeSalaries.setVisible(true);

    }
}
