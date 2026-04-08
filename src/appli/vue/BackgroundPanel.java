package appli.vue;

import appli.exceptions.ImageDefondNonTrouveeException;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Type de panel utilisé pour afficher une image de fond
 * @author btssio
 */
public class BackgroundPanel extends JPanel {

    private Image backgroundImage = null;

    public BackgroundPanel(String urlFichierImage) throws ImageDefondNonTrouveeException {
        super();
        if (!urlFichierImage.equals("")) {
            // Charger l'image de fond
            try{
                backgroundImage = new ImageIcon(getClass().getResource(urlFichierImage)).getImage();
            }catch(Exception ex){
                throw new ImageDefondNonTrouveeException("BackgroundPanel - image de fond non trouvée");
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if ( backgroundImage != null) {
        // Dessiner l'image de fond
         g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
       
    }

}
