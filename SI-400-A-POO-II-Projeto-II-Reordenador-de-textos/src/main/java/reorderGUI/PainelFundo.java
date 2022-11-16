package reorderGUI;

import java.awt.Color;

import javax.swing.JPanel;

class PainelFundo extends JPanel
   {
   private static final long serialVersionUID = 1L;
   private Color             corFrente        = Color.white;
   private Color             corFundo         = Color.lightGray;

   PainelFundo()
      {
      super();
      this.setForeground(corFrente);
      this.setBackground(corFundo);
      }

   void setCorFundo(Color novaCor)
      {
      this.corFundo = novaCor;
      }
   }
