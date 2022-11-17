package reorderGUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class PainelLogotipo extends JPanel {
    //private static final long serialVersionUID = 1L;
    public ImageIcon matheusImg = new ImageIcon(getClass().getResource(ConstantesGlobais.matheus));
    public ImageIcon tauanImg = new ImageIcon(getClass().getResource(ConstantesGlobais.tauan));
    public ImageIcon waraImg = new ImageIcon(getClass().getResource(ConstantesGlobais.wara));
    public ImageIcon gabrielImg = new ImageIcon(getClass().getResource(ConstantesGlobais.gabriel));
    public ImageIcon rodrigoImg = new ImageIcon(getClass().getResource(ConstantesGlobais.rodrigo));
    
    JLabel labelMatheus = new JLabel(matheusImg);
    JLabel labelTauan = new JLabel(tauanImg);
    JLabel labelWara = new JLabel(waraImg);
    JLabel labelGabriel = new JLabel(gabrielImg);
    JLabel labelRodrigo = new JLabel(rodrigoImg);

    PainelLogotipo(){
        add(labelMatheus);
        add(labelTauan);
        add(labelWara);
        add(labelGabriel);
        add(labelRodrigo);
        
        setSize( 150, 150);
        setVisible(true);
    }
    /*@Override
   public void paint(Graphics g)
      {
      super.paint(g);
      final Graphics2D auxGraphics = (Graphics2D) g;

      try
         {
         final URL auxURL = this.getClass().getResource(ConstantesGlobais.arqLogotipo);
         final Image auxImage = ImageIO.read(auxURL);
         auxGraphics.drawImage(auxImage, 20, 50, 180, 190, 0, 0, auxImage.getWidth(null), auxImage.getHeight(null), null);
         }
      catch (final IOException e)
         {
         System.out.println("Arquivo de imagem nao encontrado. " + e.getMessage());
         }
      catch (Exception e)
         {
         System.out.println("Erro ao carregar arquivo de imagem. " + e.getMessage());
         }
      }*/
}
