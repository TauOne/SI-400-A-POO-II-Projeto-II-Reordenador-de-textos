package reorderGUI;

import java.awt.*;

import javax.swing.*;

class PainelFundo extends JPanel
   {
   private static final long serialVersionUID = 1L;
   private Color             corFrente        = Color.white;
   private Color             corFundo         = Color.lightGray;
   private JTextArea txtArea;

      PainelFundo()
      {
      super();
      this.txtArea = new JTextArea(45,100);
      this.setBorder(BorderFactory.createLineBorder(Color.black));
      JScrollPane scrollPane = new JScrollPane( txtArea );
      this.txtArea.setBorder(BorderFactory.createLineBorder(Color.black));
      txtArea.setLineWrap(true);
      txtArea.setFont(new Font("Verdana", Font.BOLD, 11));
      this.txtArea.setEditable(true);
      this.setForeground(corFrente);
      this.setBackground(corFundo);
      this.add(scrollPane, BorderLayout.PAGE_START);
      }

   void setCorFundo(Color novaCor)
      {
      this.corFundo = novaCor;
      }
   }
